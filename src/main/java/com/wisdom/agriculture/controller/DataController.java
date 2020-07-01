package com.wisdom.agriculture.controller;

import com.github.pagehelper.PageInfo;
import com.wisdom.agriculture.comment.ResultBean;
import com.wisdom.agriculture.pojo.Details;
import com.wisdom.agriculture.pojo.WarningVo;
import com.wisdom.agriculture.service.DataService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author SFX
 * 数据接口
 */
@RestController
@CrossOrigin
public class DataController {



    @Autowired
    private DataService dataService;


    @ApiOperation(value = "获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "页面数据量", required = false, dataType = "int"),
            @ApiImplicitParam(name = "did", value = "采集器编号", required = false, dataType = "int")
    })
    @RequestMapping(value = "/getAllValue", method = RequestMethod.POST)
    public HashMap<String,Object> getAllValue(Integer pageSize,Integer pageNum,Integer did)throws Exception{
        PageInfo<WarningVo> datalist= dataService.getAllValue(pageSize,pageNum,did);
        HashMap<String,Object> map=new HashMap<>();
        map.put("state",true);
        map.put("total",datalist.getTotal());
        map.put("rows",datalist.getList());
        return map;
    }





    @ApiOperation(value = "查询传感器信息")
    @RequestMapping(value = "/getAllDet", method = RequestMethod.POST)
    public ResultBean getAllDet(){
        List<Details> details= dataService.getAllDet();
        return new ResultBean(details);
    }

}
