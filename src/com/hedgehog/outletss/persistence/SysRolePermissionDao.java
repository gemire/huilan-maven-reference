package com.hedgehog.outletss.persistence;

import java.io.Serializable;
import java.util.List;

import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.SysRolePermission;


public interface SysRolePermissionDao {
	List<SysRolePermission> selectAllRecord();
	List<SysRolePermission> selectRecordForPage(QueryPara<SysRolePermission> qp);
	SysRolePermission selectByPrimaryKey(Serializable roleId);
	void saveOrUpdate(SysRolePermission record);	
	void deleteByPrimaryKey(Serializable roleId);

}
