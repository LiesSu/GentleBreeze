package com.liessu.gentlebreeze.util;

import android.content.Context;
import android.content.res.Resources;
import android.media.Image;

import com.liessu.gentlebreeze.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 格式化工具类
 */
public class FormatUtil {
    private static final String DAY_PREFIX = "code_";
    private static final String NIGHT_PREFIX = "code_night_";

    /**
     * 将String型格式化,比如想要将2011-11-11格式化成2011年11月11日,就StringPattern("2011-11-11","yyyy-MM-dd","yyyy年MM月dd日").
     * @param date String 想要格式化的日期
     * @param oldPattern String 想要格式化的日期的现有格式
     * @param newPattern String 想要格式化成什么格式
     * @return String
     */
    public static  final String dateFormat(String date, String oldPattern, String newPattern) {
        if (date == null || oldPattern == null || newPattern == null)
            return "";
        SimpleDateFormat sdf1 = new SimpleDateFormat(oldPattern) ;        // 实例化模板对象
        SimpleDateFormat sdf2 = new SimpleDateFormat(newPattern) ;        // 实例化模板对象
        Date d = null ;
        try{
            d = sdf1.parse(date) ;   // 将给定的字符串中的日期提取出来
        }catch(Exception e){            // 如果提供的字符串格式有错误，则进行异常处理
            e.printStackTrace() ;       // 打印异常信息
        }
        return sdf2.format(d);
    }

    /**
     * 根据天气代码和时间，获得天气ICON
     * @param code 天气代码
     * @param time  待显示的时刻
     * @return 根据天气代码得出天气ICON组，06:00~18:00之间返回日间的ICON资源ID，否则返回夜间ICON
     * 的资源ID。如果没有对应的资源，则返回0
     */
    public static int obtainImageIdentifier(Context context, int code, String time){
        if(time == null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            time = simpleDateFormat.format(new Date());
        }

        int imageID;
        Resources res = context.getResources();
        final String packageName = context.getPackageName();
        final String timeByHour = dateFormat(time,"yyyy-MM-dd HH:mm", "HH:mm");
        if(timeByHour.compareTo("06:00")>0 && timeByHour.compareTo("18:00")<0) {
             imageID = res.getIdentifier(DAY_PREFIX+code , "drawable", packageName);
        }else {
            imageID = res.getIdentifier(NIGHT_PREFIX + code, "drawable", packageName);
        }

        if(imageID == 0 )
            return R.drawable.code_default;
        else
            return imageID;
    }

    /**
     * 取出string.xml中字符串并完成格式化
     * @param context 上下文
     * @param strId 字符串ID
     * @param objects 参数列表
     * @return 格式化后的字符串
     */
    public static  String formatStringResource(Context context,int strId,Object... objects){
        return String.format(context.getString(strId),objects);
    }
}
