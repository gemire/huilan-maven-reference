package com.hedgehog.outletss.service;

import java.io.Serializable;
import java.util.List;

import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.SysSystemInfo;



public interface SysSystemInfoService {
	List<SysSystemInfo> getListForPage(QueryPara<SysSystemInfo> qp);
	SysSystemInfo getUniqueResult();
	SysSystemInfo selectByPrimaryKey(Serializable systemid);	
	void saveOrUpdate(SysSystemInfo record);
}
