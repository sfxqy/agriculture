package com.wisdom.agriculture.controller;


import com.wisdom.agriculture.comment.ResultBean;
import com.wisdom.agriculture.service.DataVisualizationService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DataVisualizationController {

    @Autowired
    private DataVisualizationService dataVisualizationService;

    @ApiOperation(value = "获取采集器类型及其数量信息")
    @RequestMapping(value = "/getDeviceType", method = RequestMethod.GET)
    public ResultBean getDeviceType(){
        return new ResultBean(dataVisualizationService.getDeviceType());
    }


    @ApiOperation(value = "获取设备情况")
    @RequestMapping(value = "/getDeviceSituation", method = RequestMethod.GET)
    public ResultBean getDeviceSituation(){
        return new ResultBean(dataVisualizationService.getDeviceSituation());
    }
}
