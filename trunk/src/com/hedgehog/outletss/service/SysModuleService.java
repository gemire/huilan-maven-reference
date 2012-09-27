package com.hedgehog.outletss.service;

import java.io.Serializable;
import java.util.List;

import com.hedgehog.outletss.domain.SysModule;

public interface SysModuleService {
	List<SysModule> selectParentModules();
	SysModule selectSysModuleByPrimaryKey(Serializable moduleId);
	//SysModule selectSysModuleByPrimaryKey(SysModulePK comp_id);
	void saveOrUpdate(SysModule record);
	void deleteByPrimaryKey(Serializable moduleId);
	//void deleteByPrimaryKey(SysModulePK comp_id);
	List<SysModule> selectSubModulesByParentId(Serializable mapplicationId,Serializable mparentId);
}
