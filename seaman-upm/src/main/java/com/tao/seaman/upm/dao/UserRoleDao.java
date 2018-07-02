package com.tao.seaman.upm.dao;

import com.tao.seaman.upm.entity.UserRole;

public interface UserRoleDao {

    int deleteByPrimaryKey(String userRoleId);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(String userRoleId);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}