package com.wisdom.agriculture.dao;

import com.wisdom.agriculture.pojo.FaultRecord;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbnormalMapper {

    //故障检测查询
    List<FaultRecord> getFaultInfo();


    void deleteFault(@Param("id")Integer id);
}
