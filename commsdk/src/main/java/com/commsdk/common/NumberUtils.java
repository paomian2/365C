package com.commsdk.common;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * @Description  专门对数据进行数量
 * @Author Created by LinXZ on 2016/8/31 00:08.
 */
public class NumberUtils {




    /***
     * double 数据保存小数操作
     *
     * */
   public static double scaleNumber(double targetNumber,int scale){
       BigDecimal b1 = new BigDecimal(targetNumber);
       return b1.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
   }


    /**
     *
     * double 数据保留小数操作
     * */
    public static String sacleNumber2(double targetNumber, int scale ){
        NumberFormat ddf1 = NumberFormat.getNumberInstance();
        ddf1.setMaximumFractionDigits(scale);
       return ddf1.format(targetNumber);
    }

    /**
     *
     * double 数据保留小数操作
     * */
    public static String sacleNumber2(String targetNumber, int scale ){
        double target=Double.parseDouble(targetNumber);
        NumberFormat ddf1 = NumberFormat.getNumberInstance();
        ddf1.setMaximumFractionDigits(scale);
        return ddf1.format(target);
    }

    /**格式化距离*/
    public static String formatNumberofDistance(float distance){
        if(distance<1000){
            return sacleNumber2(distance,1)+"m";
        }else{
            return sacleNumber2(distance/1000,2)+"km";
        }
    }

    /**数量格式化*/
    public static String forNumberCount(int count){
        if (count>1000){
            Double temp=Double.parseDouble(count+"");
            return temp/10000+"万";
        }
        return count+"";
    }


    private static final int DEF_DIV_SCALE = 10;
    /**
     * 提供精确的加法运算。
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static double add(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }
    /**
     * 提供精确的减法运算。
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double sub(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }
    /**
     * 提供精确的乘法运算。(double:0.035*100会出现很多小数位，这个方法可以避免)
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double mul(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }
    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后10位，以后的数字四舍五入。
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double div(double v1,double v2){
        return div(v1,v2,DEF_DIV_SCALE);
    }
    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     * @param v1 被除数
     * @param v2 除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double v1,double v2,int scale){
        if(scale<0){
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    /**
     * 提供精确的小数位四舍五入处理。
     * @param v 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double v,int scale){
        if(scale<0){
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }



    /***********************************高德地图与百度地图的经纬度转换*****************************/

    /**
     *
     * http://blog.csdn.net/meegomeego/article/details/39927017
     *
     * 高德地图使用的是火星系坐标：GCJ-02
     * 百度地图使用的是百度坐标：在GCJ-02的基础上进行BD-09加密
     *
     * */

    private static double x_pi = 3.14159265358979324 * 3000.0 / 180.0;
    /**
     * 将 GCJ-02 坐标转换成 BD-09 坐标
     * GoogleMap和高德map用的是同一个坐标系GCJ-02（高德地图装成为百度地图）
     * */
    public static double[] bd_encrypt(double gg_lat, double gg_lon) {
        double bd_lat = 0.0;
        double bd_lon = 0.0;
        double location[] = new double[2];
        double x = gg_lon, y = gg_lat;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
        bd_lon = z * Math.cos(theta) + 0.0065;
        bd_lat = z * Math.sin(theta) + 0.006;
        location[0] = bd_lat;
        location[1] = bd_lon;
        return location;
    }

    /**
     * 将 BD-09 坐标转换成 GCJ-02 坐标
     * GoogleMap和高德map用的是同一个坐标系GCJ-02（百度地图转换高德地图）
     * */
    public static double[] bd_decrypt(double bd_lat, double bd_lon) {
        double gg_lat = 0.0;
        double gg_lon = 0.0;
        double location[] = new double[2];
        double x = bd_lon - 0.0065, y = bd_lat - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
        gg_lon = z * Math.cos(theta);
        gg_lat = z * Math.sin(theta);
        location[0] = gg_lat;
        location[1] = gg_lon;
        return location;
    }
}
