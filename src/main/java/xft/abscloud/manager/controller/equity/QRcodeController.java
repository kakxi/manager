/**
 * 
 */
package xft.abscloud.manager.controller.equity;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xft.abscloud.manager.util.ZxingUtils;

/**
 * 二维码生成
 */
@RestController
public class QRcodeController {

	/**
	 * 产品二维码
	 * 
	 * @author ligaopeng
	 * @date 2019年7月24日
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/noss/showQRcode")
	public void createProductQRcode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getParameter("url");
		String spendId = request.getParameter("spendId");
		if (StringUtils.isEmpty(url) || StringUtils.isEmpty(spendId) ) {
			throw new Exception("参数传入异常");
		}
		String content = url + "/?spendId=" + spendId;
		createQRcode(content, request, response);
	}

	@RequestMapping("/noss/createQRcode")
	public void createQRcode(@RequestParam String content, HttpServletRequest request, HttpServletResponse response) {
		ByteArrayOutputStream baos = null;
		ServletOutputStream os = null;
		try {
			// 生成二维码
			BufferedImage qRImageWithLogo = ZxingUtils.createDefaultImage(content);

			// 写入返回
			baos = new ByteArrayOutputStream();
			ImageIO.write(qRImageWithLogo, "jpg", baos);

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
	}
}
