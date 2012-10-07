package com.hedgehog.outletss.persistence;

import java.io.Serializable;
import java.util.List;

import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.SysSystemInfo;



public interface SysSystemInfoDao {
	List<SysSystemInfo> getListForPage(final QueryPara<SysSystemInfo> qp);
	SysSystemInfo getUniqueResult();
	SysSystemInfo selectByPrimaryKey(Serializable systemid);	
	void saveOrUpdate(SysSystemInfo record);
}
