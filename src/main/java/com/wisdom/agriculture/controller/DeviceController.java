package com.wisdom.agriculture.controller;


import com.github.pagehelper.PageInfo;
import com.wisdom.agriculture.comment.ResultBean;
import com.wisdom.agriculture.pojo.DetailsVo;
import com.wisdom.agriculture.pojo.Device;
import com.wisdom.agriculture.pojo.Dtype;
import com.wisdom.agriculture.service.DeviceService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author SFX
 */

@RestController
@CrossOrigin
public class DeviceController {


    @Autowired
    private DeviceService deviceService;





    //---------设备类型相关接口-----------------------------------
    @ApiOperation(value = "添加设备类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "设备类型名称", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/addDtype", method = RequestMethod.POST)
    public ResultBean addDtype(String name)throws Exception{
        deviceService.addDtype(name);
        return new ResultBean("添加成功",true);
    }


    @ApiOperation(value = "删除设备类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "设备类型名称", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/deleteDtype", method = RequestMethod.POST)
    public ResultBean deleteDtype(String tid){
        deviceService.deleteDtype(tid);
        return new ResultBean("删除成功",true);
    }


    @ApiOperation(value = "获取所有设备类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "设备类型名称", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/getAllDeviceType", method = RequestMethod.GET)
    public HashMap<String,Object> getAllDeviceType(Integer pageNum,Integer pageSize){
        PageInfo<Dtype> pageInfo= deviceService.getAllDeviceType(pageNum,pageSize);
        HashMap<String,Object> map=new HashMap<>();
        map.put("state",true);
        map.put("msg","添加成功");
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }


    //---------设备相关接口-----------------------------------
    @ApiOperation(value = "添加设备接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deviceName", value = "设备名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "appKey", value = "设备id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "longitude", value = "经度", required = true, dataType = "Float"),
            @ApiImplicitParam(name = "latitude", value = "纬度", required = true, dataType = "Float"),
            @ApiImplicitParam(name = "place", value = "详细地址", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/addDevice", method = RequestMethod.POST)
    public ResultBean addDevice(Integer deviceid, String deviceName, String appkey, Float longitude, Float latitude, String place)throws Exception{
        deviceService.addDevice(deviceid, deviceName, appkey, longitude, latitude, place);
        return new ResultBean("添加成功",true);
    }


    @ApiOperation(value = "删除设备")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deviceId", value = "设备编号", required = true, dataType = "int"),
    })
    @RequestMapping(value = "/deleteDevice", method = RequestMethod.DELETE)
    public ResultBean deleteDevice(String deviceId)throws Exception{
        deviceService.deleteDevice(deviceId);
        return new ResultBean("删除设备成功",true);

    }

    @ApiOperation(value = "修改设备信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deviceName", value = "设备名称", required = true, dataType = "String"),
            @ApiImplicitParam(name = "appKey", value = "设备id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "longitude", value = "经度", required = true, dataType = "Float"),
            @ApiImplicitParam(name = "latitude", value = "纬度", required = true, dataType = "Float"),
            @ApiImplicitParam(name = "place", value = "详细地址", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/updataDevice", method = RequestMethod.PUT)
    public ResultBean updataDevice(Integer deviceId,String deviceName,String appkey,Float longitude,Float latitude,String place)throws Exception{
        deviceService.updataDevice(deviceId,deviceName, appkey, longitude, latitude, place);
        return new ResultBean("设备信息修改成功",true);
    }



    @ApiOperation(value = "获取所有设备信息")
    @RequestMapping(value = "/getAllDevice",method = RequestMethod.GET)
    public  HashMap<String,Object> getAllDevice(Integer pageNum,Integer pageSize,Integer deviceid,String appkey,String place,String devicename)throws Exception{

        PageInfo<Device> pageInfo=deviceService.getDeviceByCondition(null,deviceid,devicename,appkey,null,place,pageSize,pageNum);
        HashMap<String,Object> map=new HashMap<>();
        map.put("state",true);
        map.put("msg","查询成功");
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }




  //---------设备详情接口-----------------------------------

    @ApiOperation(value = "添加传感器信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deviceId", value = "设备编号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "tid", value = "设备类型编号", required = true, dataType = "int"),
            @ApiImplicitParam(name = "max", value = "设备采集数据峰值", required = true, dataType = "float"),
            @ApiImplicitParam(name = "min", value = "设备采集数据低值", required = true, dataType = "float"),
            @ApiImplicitParam(name = "warnmax", value = "预警峰值", required = true, dataType = "float"),
            @ApiImplicitParam(name = "warnmin", value = "预警低值", required = true, dataType = "float"),

    })
    @RequestMapping(value = "/addDetails", method = RequestMethod.POST)
    public ResultBean addDetails(Integer deviceId,Integer tid,float max,float min,float warnmax,float warnmin)throws Exception{
        deviceService.addDetails(  deviceId, tid, max, min, warnmax, warnmin);
        return new ResultBean("添加成功",true);
    }

    @ApiOperation(value = "删除传感器信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "did", value = "编号", required = true, dataType = "int"),
    })
    @RequestMapping(value = "/deleteDetails", method = RequestMethod.DELETE)
    public ResultBean deleteDetails(String did)throws Exception{
        deviceService.deleteDetails(did);
        return new ResultBean("删除成功",true);
    }

    @ApiOperation(value = "修改传感器信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deviceId", value = "设备编号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "tid", value = "设备类型编号", required = true, dataType = "int"),
            @ApiImplicitParam(name = "max", value = "设备采集数据峰值", required = true, dataType = "float"),
            @ApiImplicitParam(name = "min", value = "设备采集数据低值", required = true, dataType = "float"),
            @ApiImplicitParam(name = "warnmax", value = "预警峰值", required = true, dataType = "float"),
            @ApiImplicitParam(name = "warnmin", value = "预警低值", required = true, dataType = "float"),

    })
    @RequestMapping(value = "/updateDetails", method = RequestMethod.POST)
    public ResultBean updateDetails(Integer did,Integer deviceId,Integer tid,float max,float min,float warnmax,float warnmin)throws Exception{
        deviceService.updateDetails(did,deviceId,tid,max,min,warnmax,warnmin);
        return new ResultBean("修改成功",true);
    }



    @ApiOperation(value = "查询传感器信息")
    @ApiImplicitParams({
    })
    @RequestMapping(value = "/getDetailsInfo", method = RequestMethod.POST)
    public HashMap<String,Object> getDetailsInfo(Integer did,Integer deviceId,Integer tid,Integer pageNum,Integer pageSize)throws Exception{
        PageInfo<DetailsVo>  pageInfo=deviceService.getDetailsInfo( did,deviceId,tid,pageNum,pageSize);
        HashMap<String,Object> map=new HashMap<>();
        map.put("state",true);
        map.put("msg","查询成功");
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }










}
