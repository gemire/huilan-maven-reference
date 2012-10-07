package com.hedgehog.outletss.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.TriggersRemove;
import com.googlecode.ehcache.annotations.When;
import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.SysSystemInfo;
import com.hedgehog.outletss.persistence.SysSystemInfoDao;

@Service("systemInfoService")
@Transactional(propagation=Propagation.REQUIRED)
public class SysSystemInfoServiceImpl implements SysSystemInfoService{
	
	private SysSystemInfoDao systemInfoDao;
	@Autowired
	public void setSystemInfoDao(SysSystemInfoDao systemInfoDao) {
		this.systemInfoDao = systemInfoDao;
	}
	
	public List<SysSystemInfo> getListForPage(QueryPara<SysSystemInfo> qp) {
		// TODO Auto-generated method stub
		//System.out.println("������񷽷�");
		List<SysSystemInfo> result=this.systemInfoDao.getListForPage(qp);
		//System.out.println("�˳����񷽷�");
		return result;
	}
	
	public SysSystemInfo selectByPrimaryKey(Serializable systemid) {
		// TODO Auto-generated method stub
		return this.systemInfoDao.selectByPrimaryKey(systemid);
	}
	
	public void saveOrUpdate(SysSystemInfo record) {
		// TODO Auto-generated method stub
		this.systemInfoDao.saveOrUpdate(record);
	}
	
	public SysSystemInfo getUniqueResult() {
		// TODO Auto-generated method stub
		return this.systemInfoDao.getUniqueResult();
	}

	

}
