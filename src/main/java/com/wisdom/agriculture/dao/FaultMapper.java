package com.wisdom.agriculture.dao;

import com.wisdom.agriculture.pojo.Abnormal;
import com.wisdom.agriculture.pojo.FaultRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaultMapper {


    void addFault(@Param("did") Integer did,@Param("daid") Integer daid);

    Abnormal getDaid(@Param("daid") Integer daid);

    void deleteByid(@Param("id") Integer id);


    List<FaultRecord> getAllFault();
}
