package com.wisdom.agriculture.service;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wisdom.agriculture.dao.CustomerMapper;
import com.wisdom.agriculture.exception.BusinessException;
import com.wisdom.agriculture.pojo.Customer;
import com.wisdom.agriculture.pojo.Role;
import com.wisdom.agriculture.utils.CheckUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SFX
 * 用户业务类
 */
@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerMapper customerMapper;

    public Customer login(HttpSession session,String username,String password)throws Exception{
        CheckUtil.isNull(username);
        CheckUtil.isNull(password);
        logger.info("用户登录中...");

        List<Customer> customers=customerMapper.getCustomerByCondition(null,username);
        if (customers.size()==0){
            logger.info("账号错误");
            throw new BusinessException("账号错误");
        }else {
            if (!customers.get(0).getPassword().equals(password)){
                logger.info("密码错误");
                throw new BusinessException("密码错误");
            }

        }
        logger.info("登录成功");
        return customers.get(0);

    }


    public void registered(String username,String password){
        logger.info("用户注册中 参数{}...",username);
        Customer customer=new Customer();
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setRid(0);
        customerMapper.insertSelective(customer);
        logger.info("用户注册成功");
    }



    public void addUser(String username,String name,String phone,Integer rid)throws Exception{
        logger.info("用户注册中 参数{}，{}，{}，{}...",username,name,phone,rid);
        Customer customer=new Customer(username,"123456",name,phone,rid);
        int row1=customerMapper.selectByUsernaeOrName(username,null).size();
        if (row1!=0){
            logger.info("该账号已存在");
            throw new BusinessException("该账号已存在");
        }
        int row=customerMapper.insertSelective(customer);
        if (row==0){
            logger.info("系统异常，添加用户失败");
            throw new BusinessException("系统异常，添加用户失败");
        }
        logger.info("用户添加成功");

    }



    @Transactional(rollbackFor = Exception.class)
    public void updateCustomer(Integer cid,String username,String name,String phone)throws Exception{
        CheckUtil.isNull(cid,username,name,phone);
        logger.info("用户信息修改中  参数{} {} {} {}",cid,username,name,phone);
        Customer customer=new Customer(cid,username,null,name,phone,null);
        customer.setCid(cid);
        customer.setUsername(username);
        customer.setName(name);
        customer.setPhone(phone);
        customerMapper.updateByPrimaryKeySelective(customer);
        logger.info("用户信息修改成功");
    }



    public Customer getCustomer(Integer cid){
        return customerMapper.getCustomerByCondition(cid,null).get(0);
    }


    public PageInfo<Customer> getAllCustomer(Integer pageNum, Integer pageSize){
        if (pageNum==null&&pageSize==null){
            pageNum=1;
            pageSize=10;
        }
        logger.info("[查询管理员信息]");
        PageHelper.startPage(pageNum, pageSize);
        List<Customer> customers= customerMapper.getCustomerByCondition(null,null);
        return new PageInfo<Customer>(customers);
    }


    public PageInfo<Customer> getCustomerByNameOrUsername(String name)throws Exception{
        logger.info("[查询管理员信息]");
        PageHelper.startPage(1, 10);
        List<Customer> customers= customerMapper.getCustomerByNameOrUsername(name);
        if (customers.size()==0){
            throw new BusinessException("未查询到相关数据");
        }
        return new PageInfo<Customer>(customers);
    }




    @Transactional(rollbackFor = Exception.class)//删除失败进行事务回滚
    public void deleteCustomer(String cid)throws Exception{
        CheckUtil.isNull(cid);
        logger.info("执行删除操作  参数{}",cid);
        String cid1[]=cid.split(",");

        for (int i=0;i<cid1.length;i++){
            int row=customerMapper.deleteCustomer(Integer.parseInt(cid1[i]));
            if (row==0){
                throw new BusinessException("系统异常，删除失败");
            }
        }

        logger.info("删除成功");
    }


    /**
     * 分页查询所有角色信息
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    public PageInfo<Role> getAllRole(Integer pageNum, Integer pageSize,String rname)throws Exception{
        logger.info("开始查询角色信息...");
        if (pageNum==null&&pageSize==null){
            pageNum=1;
            pageSize=10;
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Role> roleList=customerMapper.getAllRole(rname);
        if (roleList.size()==0){
            logger.info("未查询到相关数据");
            throw  new BusinessException("未查询到相关数据");
        }

        logger.info("查询角色信息结束");
        return new PageInfo<Role>(roleList);
    }


    /**
     * 添加角色信息
     * @param rname
     * @throws Exception
     */
    public void addRole(String rname)throws Exception{
        CheckUtil.isNull(rname);
        logger.info("角色信息添加中...  ");
        List<Role> roleList=customerMapper.getAllRole(null);
        for(Role r:roleList){
            if (r.getRname().equals(rname))
                throw new BusinessException("改角色已存在");
        }
        int row=customerMapper.addRole(rname,roleList.get(roleList.size()-1).getRid()+1);
        if (row==0){
            logger.info("系统异常，信息添加失败");
            throw new BusinessException("系统异常，信息添加失败");
        }
        logger.info("信息添加成功");
    }


    /**
     * 删除角色信息
     * @param rid
     * @throws Exception
     */
    public void deleteRole(String rid)throws Exception{
        CheckUtil.isNull(rid);
        logger.info("执行删除操作  参数{}",rid);
        String rid1[]=rid.split(",");
        for (int i=0;i<rid1.length;i++){
            Integer rid2=Integer.parseInt(rid1[i]);
            int row=customerMapper.deleteRole(rid2);
            if (row==0){
                logger.info("系统异常，信息删除失败");
                throw new BusinessException("系统异常，信息删除失败");
            }
        }
        logger.info("删除成功");

    }
}
