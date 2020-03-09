package xft.abscloud.manager.controller.order;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;
import xft.abscloud.manager.config.PayProperties;
import xft.abscloud.manager.dto.JsonResult;
import xft.abscloud.manager.enums.OrderStatusEnum;
import xft.abscloud.manager.exception.BusinessException;
import xft.abscloud.manager.pojo.AbsOrder;
import xft.abscloud.manager.service.order.IOrderService;
import xft.abscloud.manager.util.HttpUtil;
import xft.abscloud.manager.util.QRCodeUtils;

/**
 * 订单
 * @author lenovo
 *
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

	@Autowired
	private IOrderService orderService;
	
	/**
	 * 创建订单
	 * @param absOrder
	 * @throws BusinessException 
	 */
	@PostMapping("/createOrder")
	public @ResponseBody JsonResult createOrder(AbsOrder absOrder) throws BusinessException {
		
		//校验参数
		if(StringUtils.isEmpty(absOrder.getNumber())) {
			throw new BusinessException("订单数量不能为空！");
		}
		if(StringUtils.isEmpty(absOrder.getmGradeId())) {
			throw new BusinessException("会员等级Id不能为空！");
		}
		if(StringUtils.isEmpty(absOrder.getTotalAmount())) {
			throw new BusinessException("订单金额不能为空！");
		}
		if(StringUtils.isEmpty(absOrder.getMemberGrade())) {
			throw new BusinessException("会员等级名称不能为空！");
		}
		
		//获取当前操作用户
		String userId = null;
		absOrder.setUserId("1");
		try {
			orderService.createOrder(absOrder);
			return JsonResult.okMsg("操作成功");
		}catch(Exception e) {
			log.error(e.getMessage()+"--->创建订单失败");
			return JsonResult.errorMsg(e.getMessage());
		}
	}
	
	/**
	 * 查询订单列表 分页
	 * @param pageNum
	 * @param orderId
	 * @param pageSize
	 * @param orderStatus 0未支付 1已支付 2已取消
	 * @return
	 */
	@PostMapping("/queryOrderPage")
	public @ResponseBody JsonResult queryOrderPage(Integer pageNum, String orderId, Integer pageSize,String orderStatus){
		
		PageHelper.startPage(pageNum, pageSize);
		//获取当前用户
		String userId = "1";
		 List<AbsOrder> userList = null;
		//判断是否管理员
		//是管理员
		if("1".equals(userId)) {
			userList = orderService.queryOderList(null,orderId,orderStatus);
		}else {//不是
			userList = orderService.queryOderList(userId,orderId,orderStatus);
		}
		
        PageInfo<AbsOrder> pageInfo = new PageInfo<AbsOrder>(userList);
        
        return JsonResult.build(200, "操作成功", pageInfo);
	}
	
	/**
	 * 修改订单
	 * @param absOrder
	 * @return
	 */
	@PostMapping("/editOrder")
	public @ResponseBody JsonResult editOrder(AbsOrder absOrder) {
		
		//判断订单是否支付完成  支付完成不能编辑  未支付可以编辑 ---只能是管理员编辑
		String orderId = absOrder.getOrderId();
		if(StringUtils.isEmpty(orderId)) {
			throw new BusinessException("订单编号不能为空！");
		}
		
		String orderStatus = absOrder.getOrderStatus();
		
		if(StringUtils.isEmpty(orderStatus)) {
			throw new BusinessException("订单编号为：【"+orderId+"】 的订单异常！");
		}
		
		if(orderStatus.equals(OrderStatusEnum.UN_PAY.getKey())) {
			try {
				orderService.editOrder(absOrder);
				return JsonResult.okMsg("操作成功");
			}catch(Exception e) {
				log.error(e.getMessage());
				return JsonResult.errorMsg(e.getMessage());
			}
		}else {
			throw new BusinessException("订单编号为：【"+orderId+"】 的订单不能修改！");
		}
	}
	/**
	 * 取消订单
	 * @param orderId
	 * @return
	 */
	@PostMapping("/cancelOrder")
	public @ResponseBody JsonResult cancelOrder(String orderId) {
		if(StringUtils.isEmpty(orderId)) {
			throw new BusinessException("订单编号不能为空！");
		}
		
		AbsOrder absOrder = orderService.queryOrderById(orderId);
		if(absOrder == null) {
			throw new BusinessException("订单不存在！");
		}
		String payStatus = absOrder.getOrderStatus();
		if(!payStatus.equals(OrderStatusEnum.UN_PAY.getKey())) {
			throw new BusinessException("已支付或者已取消状态不能操作！");
		}
		try {
			orderService.cancelOrder(orderId);
			return JsonResult.okMsg("取消成功");
		}catch(Exception e){
			log.error(e.getMessage());
			return JsonResult.errorMsg(e.getMessage());
		}
		
	}
	/**
	 * 微信支付
	 * @param absOrder
	 * @return
	 */
	@PostMapping("/toWxPay")
	public @ResponseBody String toWxPay(HttpServletResponse response, AbsOrder absOrder) {//
		//订单号
		String orderId = absOrder.getOrderId();
		String goodsName = absOrder.getMemberGrade();
		String totalAmount = absOrder.getTotalAmount();
		String goodsId = absOrder.getmGradeId();
		if(StringUtils.isEmpty(orderId)) {
			throw new BusinessException("订单号不能为空！");
		}
		if(StringUtils.isEmpty(goodsName)) {
			throw new BusinessException("会员等级名称不能为空！");
		}
		if(StringUtils.isEmpty(totalAmount)) {
			throw new BusinessException("订单金额不能为空！");
		}
		if(StringUtils.isEmpty(goodsId)) {
			throw new BusinessException("会员等级ID不能为空！");
		}
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("outTradeNo", orderId);//订单编号
		paramMap.put("body", goodsName);//商品描述---->会员等级名称
		paramMap.put("productId", goodsId);//商品ID --->会员等级id
		paramMap.put("totalFee", totalAmount);//订单金额
		
		ByteArrayOutputStream baos = null;
        ServletOutputStream os = null;
        String code_url = HttpUtil.sendPost(PayProperties.wxPayUrl, JSON.toJSONString(paramMap));
		try {
			BufferedImage img = QRCodeUtils.createQrCode(code_url);
        
            // 写入返回
            baos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", baos);

            byte[] QRJPG = baos.toByteArray();
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");

            os = response.getOutputStream();
            os.write(QRJPG); // 自此完成一套，图片读入，写入流，转为字节数组，写入输出流
            os.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return null;
		
		
	}
	
	/**
	 * 微信回调通知
	 * @param orderId
	 * @return
	 */
	@PostMapping("/absPayCallBack")
	public @ResponseBody JsonResult absPayCallBack(@RequestBody Map<String, String> param) {
		log.info("回调更新业务开始");
		String orderId = param.get("out_trade_no").toString();
		if(StringUtils.isEmpty(orderId)) {
			throw new BusinessException("订单号为空！");
		}
		try {
			orderService.absPayCallBack(orderId);
			log.info("回调更新业务结束");
			return JsonResult.okMsg("支付成功");
		}catch(Exception e){
			log.error(e.getMessage());
			return JsonResult.errorMsg(e.getMessage());
		}

	}
	
}
