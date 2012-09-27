package com.hedgehog.outletss.service;

import java.io.Serializable;
import java.util.List;

import com.hedgehog.outletss.Utils.QueryPara;
import com.hedgehog.outletss.domain.SysRolePermission;

public interface SysRolePermissionService {
	List<SysRolePermission> selectAllRecord();
	List<SysRolePermission> selectRecordForPage(QueryPara<SysRolePermission> qp);
	SysRolePermission selectByPrimaryKey(Serializable roleId);
	void saveOrUpdate(SysRolePermission record);	
	void deleteByPrimaryKey(Serializable roleId);

}
