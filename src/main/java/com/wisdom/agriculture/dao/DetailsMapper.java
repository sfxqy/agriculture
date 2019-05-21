package com.wisdom.agriculture.dao;

import com.wisdom.agriculture.pojo.Details;
import com.wisdom.agriculture.pojo.DetailsVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailsMapper {


    List<DetailsVo> getDetailsByCondition(@Param("did") Integer did, @Param("deviceid") Integer deviceid, @Param("tid") Integer tid);
}
