package com.wisdom.agriculture.utils;

import com.wisdom.agriculture.exception.BusinessException;
import com.wisdom.agriculture.pojo.WeatherForecast;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WeatherReportByCity {


    /**
     * 根据城市名获取
     * @param cityName
     * @return
     */
    public static String excute(String cityName){
        String url=//此处以返回json格式数据示例,所以format=2,以根据城市名称为例,cityName传入中文
                "http://v.juhe.cn/weather/index?cityname="+cityName+"&key=a1dbf5e44c63dc27192a7ad886a4b17f";
        return PureNetUtil.get(url);//通过工具类获取返回数据
    }
    /**
     * 获取返回数据中的一个属性示例,此处以获取今日温度为例
     * "temperature": "8℃~20℃"     今日温度
     * @param
     * @return
     */
    public static List<WeatherForecast> GetTodayTemperatureByCity(String city)throws Exception {
        String result=excute(city);
        JSONObject obj=JSONObject.fromObject(result);
        String resultcode=obj.getString("resultcode");
       // System.out.println(resultcode);
        if (result==null||!resultcode.equals("200")){
            throw new BusinessException("网络异常");
        }

        String result1=obj.getString("result");
        JSONObject res=JSONObject.fromObject(result1);
        String sk=res.getString("sk");
        System.out.println(sk);
        JSONObject sk1=JSONObject.fromObject(sk);
        String temp=sk1.getString("temp");
        String humidity=sk1.getString("humidity");

        String future=res.getString("future");
        JSONObject fromObject=JSONObject.fromObject(future);

        Iterator<String>  keys=fromObject.keys();

        List<String> week=new ArrayList(Arrays.asList("星期一","星期二","星期三","星期四","星期五","星期六","星期日"));
        List<String> week1=new ArrayList(Arrays.asList("Mon","Tues","Wed","Thur","Fri","Satu","Sun"));
        List<WeatherForecast> weatherForecasts=new ArrayList<WeatherForecast>();
        int count=0;
        while (keys.hasNext()) {
            String key = keys.next();
            String teamsInfo = fromObject.optString(key);
            JSONObject allvalue=JSONObject.fromObject(teamsInfo);
            String temperature=allvalue.getString("temperature");
            String weather=allvalue.getString("weather");
            String wind=allvalue.getString("wind");
            String week2=allvalue.getString("week");
            if(week.contains(week2)){
                int index=week.indexOf(week2);
                week2=week1.get(index);
            }
            String temper[]=temperature.split("~");
            if (count!=0){
                temp=null;
                humidity=null;
            }
            WeatherForecast weatherForecast=new WeatherForecast(week2,temper[1],temper[0],weather,wind,temp,humidity);
            weatherForecasts.add(weatherForecast);
            count++;
        }
        return weatherForecasts;
    }




}
