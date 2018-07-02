package com.tao.seaman.upm.dao;

import com.tao.seaman.upm.entity.Permission;

public interface PermissionDao {

    int deleteByPrimaryKey(String permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(String permissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}