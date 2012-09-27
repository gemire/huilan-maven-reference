package com.hedgehog.outletss.service;

import java.io.Serializable;
import java.util.List;


import com.hedgehog.outletss.Utils.QueryPara;
import com.hedgehog.outletss.domain.SysApplication;

public interface SysApplicationsService {
	List<SysApplication> selectAppForPage(QueryPara<SysApplication> qp);
	List<SysApplication> selectAllRecord();
	SysApplication selectByPrimaryKey(Serializable applicationid);
	void saveOrUpdate(SysApplication record);	
	void deleteByPrimaryKey(Serializable applicationid);

}
