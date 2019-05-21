package com.wisdom.agriculture.controller;

import com.github.pagehelper.PageInfo;
import com.wisdom.agriculture.comment.ResultBean;
import com.wisdom.agriculture.pojo.Monitoring;
import com.wisdom.agriculture.service.MonitoringService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
@CrossOrigin
public class MonitoringController {


    @Autowired
    private MonitoringService monitoringService;

    @ApiOperation(value = "获取视频解析码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "解析码", required = true, dataType = "int"),
    })
    @RequestMapping(value = "/getIpAddress", method = RequestMethod.GET)
    public ResultBean getIpAddress(){
        return new ResultBean();
    }


    @ApiOperation(value = "添加视频监控信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "编号", required = false, dataType = "int"),
            @ApiImplicitParam(name = "aid", value = "视频串流码", required = false, dataType = "String"),
            @ApiImplicitParam(name = "ip", value = "服务器地址", required = false, dataType = "String"),
    })
    @RequestMapping(value = "/addMonitoring", method = RequestMethod.POST)
    public ResultBean addMonitoring(Monitoring monitoring)throws Exception{
        monitoringService.addMonitoring(monitoring);
        return new ResultBean("信息添加成功过",true);
    }



    @ApiOperation(value = "删除视频监控信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "编号", required = false, dataType = "String"),
    })
    @RequestMapping(value = "/deleteMonitoring", method = RequestMethod.POST)
    public ResultBean deleteMonitoring(String id)throws Exception{
        monitoringService.deleteMonitoring(id);
        return new ResultBean("删除成功",true);
    }



    @ApiOperation(value = "修改监控信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "编号", required = false, dataType = "int"),
            @ApiImplicitParam(name = "aid", value = "视频串流码", required = false, dataType = "String"),
            @ApiImplicitParam(name = "ip", value = "服务器地址", required = false, dataType = "String"),
    })
    @RequestMapping(value = "/updataMonitoring", method = RequestMethod.PUT)
    public ResultBean updataMonitoring(Monitoring monitoring){
        monitoringService.updataMon(monitoring);
        return new ResultBean("修改成功",true);
    }

    @ApiOperation(value = "获取视频解析码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "解析码", required = false, dataType = "int"),
    })
    @RequestMapping(value = "/getInfoByConditions", method = RequestMethod.POST)
    public HashMap<String,Object> getInfoByConditions(Integer id,Integer pageNum,Integer pageSize)throws Exception{
        PageInfo<Monitoring> pageInfo=monitoringService.getInfoByConditions(id,pageNum,pageSize);
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("state",true);
        hashMap.put("msg","信息获取成功");
        hashMap.put("total",pageInfo.getTotal());
        hashMap.put("rows",pageInfo.getList());
        return hashMap;
    }






}
