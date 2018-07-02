package com.tao.seaman.upm.dao;

import com.tao.seaman.upm.entity.UserOrganization;

public interface UserOrganizationDao {

    int deleteByPrimaryKey(String userOrganizationId);

    int insert(UserOrganization record);

    int insertSelective(UserOrganization record);

    UserOrganization selectByPrimaryKey(String userOrganizationId);

    int updateByPrimaryKeySelective(UserOrganization record);

    int updateByPrimaryKey(UserOrganization record);
}