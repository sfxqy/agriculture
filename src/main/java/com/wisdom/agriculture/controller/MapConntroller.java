package com.wisdom.agriculture.controller;


import com.wisdom.agriculture.comment.ResultBean;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MapConntroller {



    @ApiOperation(value = "修改监控信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "编号", required = false, dataType = "int"),
            @ApiImplicitParam(name = "aid", value = "视频串流码", required = false, dataType = "String"),
            @ApiImplicitParam(name = "ip", value = "服务器地址", required = false, dataType = "String"),
    })
    @RequestMapping(value = "/getAllPlace", method = RequestMethod.GET)
    public ResultBean getAllPlace(){

        return new ResultBean();
    }
}
