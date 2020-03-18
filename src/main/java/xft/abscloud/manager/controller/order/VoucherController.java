package xft.abscloud.manager.controller.order;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.imageio.ImageIO;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UrlPathHelper;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;
import xft.abscloud.manager.config.FastDFSClient;
import xft.abscloud.manager.dto.JsonResult;
import xft.abscloud.manager.enums.ApplyEnum;
import xft.abscloud.manager.exception.BusinessException;
import xft.abscloud.manager.pojo.AbsFileInfo;
import xft.abscloud.manager.pojo.AbsOrder;
import xft.abscloud.manager.pojo.AbsVoucher;
import xft.abscloud.manager.service.file.FileInfoService;
import xft.abscloud.manager.service.order.IOrderService;
import xft.abscloud.manager.service.order.IVoucherService;

/**
 * 凭证
 * @author lenovo
 *
 */
@RestController
@RequestMapping("/voucher")
@Slf4j
public class VoucherController {

	@Autowired
	private IVoucherService voucherService;
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private FileInfoService fileInfoService;
	
	@Autowired
    private FastDFSClient fileClient;
	
	private UrlPathHelper urlPathHelper = new UrlPathHelper();
	/**
	 * 用户申请线下支付凭证
	 * @param absVoucher
	 * @return
	 */
	@PostMapping("/applyVoucher")
	public @ResponseBody JsonResult applyVoucher(AbsVoucher absVoucher) {
		//校验参数
		checkVoucher(absVoucher);
		String orderId = absVoucher.getOrderId();
		
		try {
			AbsOrder absOrder = orderService.queryOrderById(orderId);
			if(absOrder == null) {
				throw new BusinessException("订单号为：【"+orderId+"】不存在！");
			}
			AbsVoucher voucher = voucherService.queryVoucherByOrderId(orderId);
			if(voucher !=null) {
				throw new BusinessException("此订单已经申请凭证！");
			}
			//获取当前用户
			String userId = "1";
			absVoucher.setUserId(userId);
			voucherService.applyVoucher(absVoucher);
			return JsonResult.okMsg("支付凭证申请成功");
		}catch(BusinessException e) {
			log.error(e.getMessage());
			return JsonResult.errorMsg(e.getMessage());
		}
	}
	
	/**
	 * 审核线下支付凭证--同意
	 * @param absVoucher
	 * @return
	 * @throws BusinessException 
	 */
	@PostMapping("/applyConsumptionVoucher")
	public @ResponseBody JsonResult applyConsumptionVoucher(AbsVoucher absVoucher) throws BusinessException {
		
		//判断参数
		checkVoucher(absVoucher);
		//只有管理员才有此功能，获取当前用户，判断是否是管理员
		String userId = "1";
		Integer voucherId = absVoucher.getVoucherId();
		
		try {
			if( voucherId == null) {
				throw new BusinessException("凭证id不能为空！");
			}
			
			if("1".equals(userId)) {
				voucherService.applyConsumptionVoucher(absVoucher);
			}else {
				throw new BusinessException("此用户没有该操作权限");
			}
		}catch(BusinessException e) {
			log.error(e.getMessage());
			return JsonResult.errorMsg(e.getMessage());
		}
		return JsonResult.okMsg("操作成功");
	}
	

	/**
	 * 线下消费凭证审核拒绝
	 * @param voucherId
	 * @param auditOpinion
	 * @return
	 */
	@PostMapping("/applyConsumptionVoucherRefued")
	public @ResponseBody JsonResult applyConsumptionVoucherRefued(String voucherId, String auditOpinion) {
		
		try {
			if(StringUtils.isEmpty(voucherId)) {
				throw new BusinessException("凭证id不能为空！");
			}
			//获取当前用户 只有管理员操作
			String userId = "1";
			
			if(!"1".equals(userId)) {
				throw new BusinessException("此用户没有操作权限，仅管理员操作！");
			}
			voucherService.applyConsumptionVoucherRefued(voucherId,auditOpinion);
			return JsonResult.okMsg("操作成功");
		}catch(BusinessException e) {
			log.error(e.getMessage());
			return JsonResult.errorMsg(e.getMessage());
		}
	}
	
	/**
	 * 修改凭证
	 * @param absVoucher
	 * @return
	 */
	@PostMapping("/editVoucher")
	public @ResponseBody JsonResult editVoucher(AbsVoucher absVoucher) {
		
		checkVoucher(absVoucher);
		
		String userId = "1";
		absVoucher.setUserId(userId);
		Integer voucherId = absVoucher.getVoucherId();
		
		try {
			if( voucherId == null) {
				throw new BusinessException("凭证id不能为空！");
			}
			String applyStatus = absVoucher.getApplyStatus();
			if(applyStatus.equals(ApplyEnum.APPLY.getKey())) {
				throw new BusinessException("ID为【"+voucherId+"】的凭证已经审核通过,不能修改！");
			}
			voucherService.editVoucher(absVoucher);
			return JsonResult.okMsg("修改成功");
		}catch(BusinessException e) {
			log.error(e.getMessage());
			return JsonResult.errorMsg(e.getMessage());
		}
	}
	
	private void checkVoucher(AbsVoucher absVoucher) {

		if(StringUtils.isEmpty(absVoucher.getPayAmount())) {
			throw new BusinessException("支付金额不能为空！");
		}
		if(StringUtils.isEmpty(absVoucher.getOrderId())) {
			throw new BusinessException("订单号不能为空！");
		}
		if(StringUtils.isEmpty(absVoucher.getTranscationNm())) {
			throw new BusinessException("支付流水/交易单号不能为空！");
		}
		
		if(StringUtils.isEmpty(absVoucher.getGoodsName())) {
			throw new BusinessException("商品名称不能为空！");
		}
		if(StringUtils.isEmpty(absVoucher.getFileUrl())) {
			throw new BusinessException("凭证文件不能为空！");
		}
	}
	
	/**
	 * 查询线下凭证
	 * @return
	 */
	@PostMapping("/queryCurrentUserVoucher")
	public @ResponseBody JsonResult queryCurrentUserVoucher(Integer pageNum, Integer pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		//获取当前用户
		//如果是管理员 查询所有用户的消费记录，否则查询当前用户的消费记录
		String userId = "1";
		List<AbsVoucher> expenseList = null;
		//如果是管理员 TODO
		if("1".equals(userId)) {
			expenseList = voucherService.queryCurrentUserVoucher(null);
		}else {//如果不是管理员
			expenseList = voucherService.queryCurrentUserVoucher(userId);
		}
        
        PageInfo<AbsVoucher> pageInfo = new PageInfo<AbsVoucher>(expenseList);
        
        return JsonResult.build(200, "操作成功", pageInfo);
	}
	
	/**
	 * 上传支付凭证
	 * @param file
	 * @return
	 */
	@PostMapping("/uploadVoucher")
	public @ResponseBody JsonResult uploadVoucher(MultipartFile file) {
		try {
			AbsFileInfo absFileInfo = fileInfoService.uploadFile2(file);
			if(absFileInfo == null) {
				throw new BusinessException("上传失败");
			}
			return JsonResult.build(200, "上传成功", absFileInfo.getFileUrl());
		}catch(BusinessException e) {
			log.error(e.getMessage());
			return JsonResult.errorMsg("上传失败");
		}catch(Exception e) {
			log.error(e.getMessage());
			return JsonResult.errorMsg("上传失败");
		}
	}
	
	
	/**
	 *下载支付凭证
     *
     * @param request
     * @param response
     * @author ligaopeng
     */
    @PostMapping(value = "/downloadVoucher")
    public @ResponseBody void download(HttpServletRequest request, HttpServletResponse response) {
        String fileUrl = request.getParameter("fileUrl");
//        String fileName = request.getParameter("fileName");
        download(null, fileUrl, request, response);
    }

    public void download(String fileName, String fileUrl, HttpServletRequest request,
                         HttpServletResponse response) {
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(response.getOutputStream());

            response.setCharacterEncoding("UTF-8");
            // 设置文档打开类型
            response.setContentType("application/octet-stream;charset=GBK");
            // 设置报文头为attachment响应类型
            response.setHeader("Content-disposition", "attachment;" + encodeFileName(request, fileName));
            /**
             * 为了不影响原有的功能，这里先参考代码里最初fastdfs配置的设计，每次需要先new FastDFSClientImpl
             * 否则第一次的时候会报错，后期fastdfs的初始化那里需要统一修改
             */
            byte[] bytes = fileClient.getFile(fileUrl); // 读取字节流
            if (null == bytes || bytes.length == 0) {
                throw new Exception("文件服务器上不存在此文件！");
            }
            // 文件后缀名
            response.setHeader("Content-Length", String.valueOf(bytes.length));
            bos.write(bytes, 0, bytes.length);
            // return IhJSONResult.okMsg("文件下载成功");
        } catch (Exception e) {
            try {
                response.setContentType("text/html;charset=UTF-8");
                byte[] bb = e.getMessage().getBytes("UTF-8");
                bos.write(bb, 0, bb.length);
            } catch (UnsupportedEncodingException e1) {
                log.error(e1.getMessage());
            } catch (IOException e1) {
                log.error(e1.getMessage());
            }
            // return null;
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }
    
    public String encodeFileName(HttpServletRequest request, String fileName) {

        String userAgent = request.getHeader("User-Agent");
        String rtn = "";

        try {
            String new_filename = URLEncoder.encode(fileName, "UTF8");
            new_filename = new_filename.replaceAll("\\+", "%20");

            // 如果没有UA，则默认使用IE的方式进行编码，因为毕竟IE还是占多数的
            rtn = "filename=\"" + new_filename + "\"";
            if (userAgent != null) {
                userAgent = userAgent.toLowerCase();

                // IE/Edge浏览器，只能采用URLEncoder编码
                if (userAgent.contains("msie") || userAgent.contains("edge")) {
                    rtn = "filename=\"" + new_filename + "\"";
                }

                // Opera浏览器只能采用filename*
                else if (userAgent.contains("opera")) {
                    rtn = "filename*=UTF-8''" + new_filename;
                }

                // Safari浏览器，只能采用ISO编码的中文输出
                else if (userAgent.contains("safari")) {
                    rtn = "filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO8859-1") + "\"";
                }

                // Chrome浏览器，只能采用MimeUtility编码或ISO编码的中文输出
                else if (userAgent.contains("applewebkit")) {
                    new_filename = MimeUtility.encodeText(fileName, "UTF8", "B");
                    rtn = "filename=\"" + new_filename + "\"";
                }

                // FireFox浏览器，可以使用MimeUtility或filename*或ISO编码的中文输出
                else if (userAgent.contains("mozilla")) {
                    rtn = "filename*=UTF-8''" + new_filename;
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return rtn;
    }
   
    @RequestMapping("/queryVoucherByOrderId")
    public @ResponseBody JsonResult queryVoucherByOrderId(String orderId) {
    	
    	try {
    		if( orderId == null) {
				throw new BusinessException("订单id不能为空！");
			}
    		AbsVoucher absVoucher = voucherService.queryVoucherByOrderId(orderId);
    		
    		return JsonResult.build(200, "查询成功",absVoucher);
    	}catch(BusinessException e) {
    		log.error(e.getMessage());
    		return JsonResult.errorException(e.getMessage());
    	}
    }
    
    /**
     * 显示图片
     * @param request
     * @param response
     */
    @GetMapping(value = "/showFile/group1/**")
    public void showFileByFileUrl(HttpServletRequest request, HttpServletResponse response) {

        response.setHeader(HttpHeaders.CACHE_CONTROL, "max-age=31536000");
        String reqPath = urlPathHelper.getLookupPathForRequest(request);
        byte[] imgBytes = new byte[]{};
        try {
            // storageFilePath like 'group1/M00/00/01/xx.jpg'
            String fileType = reqPath.substring(reqPath.lastIndexOf(".")+1);
            response.setContentType("image/"+fileType);

            String storageFilePath = reqPath.substring(reqPath.indexOf("/showFile/") + "/showFile/".length());
            imgBytes = fileClient.getFile(storageFilePath);
            InputStream is = new ByteArrayInputStream(imgBytes);
            BufferedImage bi= ImageIO.read(is);
            ImageIO.write(bi, fileType, response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
