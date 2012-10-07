package com.hedgehog.outletss.persistence;

import java.io.Serializable;
import java.util.List;

import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.SysApplication;

public interface SysApplicationsDao {
	List<SysApplication> selectAppForPage(final QueryPara<SysApplication> qp);
	List<SysApplication> selectAllRecord();
	SysApplication selectByPrimaryKey(Serializable applicationid);
	Integer selectMaxOrder();
	void saveOrUpdate(SysApplication record);	
	void deleteByPrimaryKey(Serializable applicationid);

}
