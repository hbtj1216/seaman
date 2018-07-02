package com.tao.seaman.upm.dao;

import com.tao.seaman.upm.entity.Organization;

public interface OrganizationDao {

    int deleteByPrimaryKey(String organizationId);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(String organizationId);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);
}