package com.wisdom.agriculture.controller;


import com.github.pagehelper.PageInfo;
import com.wisdom.agriculture.comment.ResultBean;
import com.wisdom.agriculture.pojo.Customer;
import com.wisdom.agriculture.pojo.Role;
import com.wisdom.agriculture.service.CustomerService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@CrossOrigin
public class CustomerController {


    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @ApiOperation(value = "测试接口")
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public ResultBean test(){
        return new ResultBean("成功",true);
    }



    @ApiOperation(value = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "账号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultBean login(HttpSession session, String username, String password)throws Exception{
        customerService.login(session,username,password);
        return new ResultBean("登录成功",true);
    }


    @ApiOperation(value = "注册管理员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "账号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/registered", method = RequestMethod.POST)
    public ResultBean registered(HttpSession session,String username, String password){
        customerService.registered(username,password);
        return new ResultBean("注册成功",true);
    }







    @ApiOperation(value = "添加普通用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "账号", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResultBean addUser(HttpSession session, String username, String name, String phone, Integer rid)throws Exception{
        customerService.addUser(username,name,phone,rid);
        return new ResultBean("添加成功",true);
    }


    @ApiOperation(value = "修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cid", value = "编号", required = true, dataType = "int"),
            @ApiImplicitParam(name = "username", value = "账号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "name", value = "真实姓名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "phone", value = "手机号码", required = true, dataType = "String")
    })
    @RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT)
    public ResultBean updateCustomer(Integer cid,String username,String name,String phone)throws Exception{
        customerService.updateCustomer(cid, username, name, phone);
        return new ResultBean("修改成功",true);
    }


    @ApiOperation(value = "获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cid", value = "编号", required = true, dataType = "int")
    })
    @RequestMapping(value = "/getCustomerInfo", method = RequestMethod.POST)
    public ResultBean getCustomerInfo(Integer cid){
        return new ResultBean(customerService.getCustomer(cid));
    }



    @ApiOperation(value = "分页查询用户信息")
    @RequestMapping(value = "/getAllCustomer", method = RequestMethod.GET)
    public HashMap<String,Object> getAllCustomer(Integer pageNum, Integer pageSize){
        logger.info("分页参数{} {}",pageNum,pageSize);
        HashMap<String,Object> hashMap=new HashMap<>();
        PageInfo<Customer> pageInfo =customerService.getAllCustomer(pageNum,pageSize);
        hashMap.put("state",true);
        hashMap.put("msg","添加成功");
        hashMap.put("total",pageInfo.getTotal());
        hashMap.put("rows",pageInfo.getList());
        return hashMap;
    }



    @ApiOperation(value = "按条件查询用户信息")
    @RequestMapping(value = "/getCustomerByNameOrUsername", method = RequestMethod.GET)
    public HashMap<String,Object> getCustomerByNameOrUsername(String name)throws Exception{
        HashMap<String,Object> hashMap=new HashMap<>();
        PageInfo<Customer> pageInfo =customerService.getCustomerByNameOrUsername(name);
        hashMap.put("state",true);
        hashMap.put("msg","查询成功");
        hashMap.put("total",pageInfo.getTotal());
        hashMap.put("rows",pageInfo.getList());
        return hashMap;
    }




    @ApiOperation(value = "删除用户信息")
    @RequestMapping(value = "/deleteCustomer", method = RequestMethod.DELETE)
    public ResultBean deleteCustomer(String cid)throws Exception{
        customerService.deleteCustomer(cid);
        return new ResultBean("删除成功",true);
    }





    //-用户角色-------------------------------------
    @ApiOperation(value = "分页查询角色信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "页面数据量", required = true, dataType = "int")
    })
    @RequestMapping(value = "/getAllRole", method = RequestMethod.GET)
    public HashMap<String,Object> getAllRole(Integer pageNum, Integer pageSize,String rname)throws Exception{
        PageInfo<Role> rolePageInfo= customerService.getAllRole(pageNum,pageSize,rname);
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("state",true);
        hashMap.put("msg","查询成功");
        hashMap.put("total",rolePageInfo.getTotal());
        hashMap.put("rows",rolePageInfo.getList());
        return hashMap;
    }


    @ApiOperation(value = "添加角色信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rname", value = "角色名称", required = true, dataType = "int"),
    })
    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public ResultBean addRole(String rname)throws Exception{
        customerService.addRole(rname);
        return new ResultBean("信息添加成功",true);
    }


    @ApiOperation(value = "删除角色信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rid", value = "角色编号串", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/deleteRole", method = RequestMethod.DELETE)
    public ResultBean deleteRole(String rid)throws Exception{
        customerService.deleteRole(rid);
        return new ResultBean("信息删除成功",true);
    }


}
