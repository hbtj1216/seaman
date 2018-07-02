package com.tao.seaman.upm.dao;

import com.tao.seaman.upm.entity.Log;

public interface LogDao {

    int deleteByPrimaryKey(String logId);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(String logId);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}