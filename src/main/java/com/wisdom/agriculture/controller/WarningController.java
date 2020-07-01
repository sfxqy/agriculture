package com.wisdom.agriculture.controller;


import com.wisdom.agriculture.pojo.WarningVo;
import com.wisdom.agriculture.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class WarningController {

    @Autowired
    private WarningService warningService;

    @RequestMapping(value = "/getAllWarn",method = RequestMethod.GET)
    public HashMap<String,Object> getAllWarn(Integer pageNum,Integer pageSize)throws Exception{
        Object[] objects=warningService.getAllWarn(pageNum, pageSize);
        List<WarningVo> warningVos=(List<WarningVo>)objects[0];
        Integer size=(Integer)objects[1];
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("state",true);
        hashMap.put("msg","查询成功");
        hashMap.put("total",size);
        hashMap.put("rows",warningVos);
        return hashMap;
    }




}
