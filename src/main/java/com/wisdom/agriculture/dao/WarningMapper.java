package com.wisdom.agriculture.dao;


import com.wisdom.agriculture.pojo.Data;
import com.wisdom.agriculture.pojo.Details;
import com.wisdom.agriculture.pojo.WarningVo;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WarningMapper {


    List<Integer> getAllDid();


    Details getDetailsByDid(@Param("did") Integer did);

    List<WarningVo> getWarningVo(@Param("did") Integer did, @Param("warnmin") Float warnmin, @Param("warnmax")Float warnmax);


    List<WarningVo>  getValueByDid (@Param("did") Integer did);
}
