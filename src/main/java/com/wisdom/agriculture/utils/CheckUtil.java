package com.wisdom.agriculture.utils;

import com.wisdom.agriculture.exception.BusinessException;

import java.util.Collection;

/**
 * @author SFX
 * 检查工具类
 */
public class CheckUtil {


    /**
     * 非空检查
     * @param object
     * @throws Exception
     */
    public static void isNull(Object... object)throws Exception{
        for (int i=0;i<object.length;i++){
            if (object==null){
                throw new BusinessException("数据不能为空");
            }
            if (object[i] instanceof String && ((String) object[i]).length()==0){
                throw new BusinessException("数据不能为空");
            }
            if (object[i] instanceof Collection && ((Collection) object[i]).size()==0){
                throw new BusinessException("数据不能为空");
            }

        }

    }


    public static void attributeIsNull(Object object,String attribute[]){
        Class obj=object.getClass();

    }



}
