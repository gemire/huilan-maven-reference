package com.hedgehog.outletss.persistence;

import java.io.Serializable;
import java.util.List;

import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.SysModule;




public interface SysModuleDao {	
	List<SysModule> selectParentModules(final QueryPara<SysModule> qp);
	List<SysModule> selectParentModules();
	SysModule selectSysModuleByPrimaryKey(Serializable moduleId);
	//SysModule selectSysModuleByPrimaryKey(SysModulePK comp_id);
	
	void saveOrUpdate(SysModule record);
	void deleteByPrimaryKey(Serializable moduleId);
	//void deleteByPrimaryKey(SysModulePK comp_id);
	List<SysModule> selectSubModulesByParentId(Serializable mapplicationId,Serializable mparentId);
}
