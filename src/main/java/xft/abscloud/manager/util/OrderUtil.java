package xft.abscloud.manager.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderUtil {

	//生成订单号
	public static synchronized String createOrderNum(String type) {
		
		//获取时间戳+套餐类型+随机码+用户id
		String date = getTime();
		String userId = "1";
		StringBuffer sb = new StringBuffer();
		sb.append(date).append(type).append(getRadomNum()).append(userId);
		
		return sb.toString();
	}
	
	//获取当前时间
	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		return sdf.format(date);
	}

	//获取当前时间
	public static String getCurrentDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();

		return sdf.format(date);
	}
	
	//获取时间戳
	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		return sdf.format(date);
	}
	
	//获取随机数
	public static synchronized String getRadomNum() {
		
		String strNum = String.format("%04d", new Random().nextInt(10000));
		return strNum;
	}


	public static void main(String[] args) {
		System.out.println(getRadomNum());
	}
}
