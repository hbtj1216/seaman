package com.tao.seaman.upm.dao;

import com.tao.seaman.upm.entity.Role;

public interface RoleDao {

    int deleteByPrimaryKey(String roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}