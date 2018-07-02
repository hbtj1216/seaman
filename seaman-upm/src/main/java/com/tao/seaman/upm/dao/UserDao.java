package com.tao.seaman.upm.dao;

import com.tao.seaman.upm.entity.User;

public interface UserDao {

    int deleteByUserId(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}