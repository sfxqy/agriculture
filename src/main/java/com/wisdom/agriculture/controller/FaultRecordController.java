package com.wisdom.agriculture.controller;


import com.wisdom.agriculture.comment.ResultBean;
import com.wisdom.agriculture.service.FaultRecordService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SFX
 * 故障管理接口
 */
@RestController
@CrossOrigin
public class FaultRecordController {


    @Autowired
    private FaultRecordService faultRecordService;


    @ApiOperation(value = "查询故障信息")
    @RequestMapping(value = "/getFaultInfo", method = RequestMethod.POST)
    public ResultBean getFaultInfo(){
        return new ResultBean(faultRecordService.getFaultInfo());
    }


    @ApiOperation(value = "删除故障信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "编号", required = true, dataType = "int"),
    })
    @RequestMapping(value = "/deleteFault", method = RequestMethod.GET)
    public ResultBean deleteFault(Integer id){
        faultRecordService.deleteFault(id);
        return new ResultBean();
    }
}
