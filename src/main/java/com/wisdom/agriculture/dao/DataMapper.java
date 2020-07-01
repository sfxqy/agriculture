package com.wisdom.agriculture.dao;


import com.wisdom.agriculture.pojo.Data;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DataMapper {


    int addValue(@Param("did")Integer did, @Param("value") Float value, @Param("time") Date time);

    List<Integer> getAllDid();


    List<Data> getFault(@Param("did")Integer did,@Param("max") Float max,@Param("min") Float min);
}
