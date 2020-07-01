package com.wisdom.agriculture.controller;

import com.wisdom.agriculture.comment.ResultBean;
import com.wisdom.agriculture.utils.RedisUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

@RestController
@CrossOrigin
public class a {
    @Resource
    RedisUtils redisUtils;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @ApiOperation(value = "获取所有设备信息")
    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    public String getInfo(){
        redisUtils.set("name","sfx");
        System.out.println(redisUtils.get("name1")==null);
        return (String)redisUtils.get("name1");
    }


    public void testFile(HttpServletResponse response)throws Exception{
        OutputStream outputStream=null;
        File file=new File("sfx.txt");
        file.createNewFile();
        outputStream=response.getOutputStream();
     //e   outputStream.write(file);
    }
}
