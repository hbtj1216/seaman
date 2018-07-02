package com.tao.seaman.upm.dao;

import com.tao.seaman.upm.entity.System;

public interface SystemDao {

    int deleteByPrimaryKey(String systemId);

    int insert(System record);

    int insertSelective(System record);

    System selectByPrimaryKey(String systemId);

    int updateByPrimaryKeySelective(System record);

    int updateByPrimaryKey(System record);
}