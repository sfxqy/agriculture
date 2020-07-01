package com.wisdom.agriculture.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wisdom.agriculture.dao.DataMapper;
import com.wisdom.agriculture.dao.DetailsMapper;
import com.wisdom.agriculture.dao.WarningMapper;
import com.wisdom.agriculture.exception.BusinessException;
import com.wisdom.agriculture.pojo.Details;
import com.wisdom.agriculture.pojo.WarningVo;
import org.apache.commons.collections.BagUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SFX
 */
@Service
public class DataService {

    private static final Logger logger = LoggerFactory.getLogger(DataService.class);


    @Autowired
    private WarningMapper warningMapper;


    @Autowired
    private DetailsMapper detailsMapper;


    /**
     * 按条件查询数据
     * @param pageSize
     * @param pageNum
     * @param did
     * @return
     */
    public PageInfo<WarningVo>  getAllValue(Integer pageSize, Integer pageNum, Integer did)throws Exception{
        logger.info("[查询参数did:{}]",did);
        if (pageNum==null||pageSize==null){
            pageNum=1;
            pageSize=10;
        }
        PageHelper.startPage(pageNum,pageSize);
        List<WarningVo> warningVoList=warningMapper.getValueByDid(did);

        if (warningVoList.size()==0){
            logger.info("[未查询到相关数据 查询参数did:{}]",did);
            throw new BusinessException("未查询到相关数据");
        }
        logger.info("[查询成功  数据量:{}]",warningVoList.size());
        return new PageInfo<>(warningVoList);
    }




    public List<Details> getAllDet(){
        logger.info("[正在查询采集器信息...]");
        return detailsMapper.getDetails(null,null,null);

    }
}
