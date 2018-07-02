package com.tao.seaman.upm.dao;

import com.tao.seaman.upm.entity.RolePermission;

public interface RolePermissionDao {

    int deleteByPrimaryKey(String rolePermissionId);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(String rolePermissionId);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}