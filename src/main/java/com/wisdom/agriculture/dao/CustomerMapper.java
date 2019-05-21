package com.wisdom.agriculture.dao;

import com.wisdom.agriculture.pojo.Customer;
import com.wisdom.agriculture.pojo.Role;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {


    List<Customer> getCustomerByCondition(@Param("cid") Integer cid,@Param("username") String username);

    List<Customer> getCustomerByNameOrUsername(@Param("name") String name);

    int insertSelective(Customer customer);


    int updateByPrimaryKeySelective(Customer customer);


    int selectByPrimaryKey(@Param("cid") Integer cid);

    List<Customer> selectByUsernaeOrName(@Param("username") String username,@Param("name") String name);


    int deleteCustomer(Integer cid);


    List<Role> getAllRole(@Param("rname") String rname);


    int addRole(@Param("rname") String rname,@Param("rid") Integer rid);


    int deleteRole(@Param("rid") Integer rid);






}
