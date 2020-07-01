package com.wisdom.agriculture.controller;

import com.wisdom.agriculture.comment.ResultBean;
import com.wisdom.agriculture.utils.WeatherReportByCity;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class GetWeatherByCityController {

    @ApiOperation(value = "获取天气信息")
    @RequestMapping(value = "/getWeather",method = RequestMethod.GET)
    public ResultBean getWeather()throws Exception{
        return new ResultBean(WeatherReportByCity.GetTodayTemperatureByCity("襄阳"));
    }
}
