package com.tao.seaman.upm.dao;

import com.tao.seaman.upm.entity.UserPermission;

public interface UserPermissionDao {

    int deleteByPrimaryKey(String userPermissionId);

    int insert(UserPermission record);

    int insertSelective(UserPermission record);

    UserPermission selectByPrimaryKey(String userPermissionId);

    int updateByPrimaryKeySelective(UserPermission record);

    int updateByPrimaryKey(UserPermission record);
}