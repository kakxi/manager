package xft.abscloud.manager.util;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class DateUtils {

    /**
     * 判断当前时间是否到期，传入截止日期 yyyy-MM-dd
     */
    public static boolean judgeExpired(String expireDateStr) {
        Date expireDate = DateUtil.parse(expireDateStr, "yyyy-MM-dd");
        // 得到一天的结束 23:59:59
        Date endOfDay = DateUtil.endOfDay(expireDate);

        return judgeExpired(new Date(), endOfDay);
    }


    /**
     * 判断是否到期:
     * 返回 true 过期了，false 未过期
     */
    public static boolean judgeExpired(Date currentDate, Date expireDate) {
        long betweenDay = DateUtil.between(currentDate, expireDate, DateUnit.SECOND, false);
        return betweenDay < 0;
    }

}
