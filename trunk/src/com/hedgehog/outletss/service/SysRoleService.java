package com.hedgehog.outletss.service;

import java.io.Serializable;
import java.util.List;

import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.SysRole;

public interface SysRoleService {
	List<SysRole> selectAllRecord();
	List<SysRole> selectRecordForPage(QueryPara<SysRole> qp);
	SysRole selectByPrimaryKey(Serializable roleId);
	void saveOrUpdate(SysRole record);	
	void deleteByPrimaryKey(Serializable roleId);
}
