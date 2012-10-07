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
import com.hedgehog.outletss.domain.SysApplication;
import com.hedgehog.outletss.persistence.SysApplicationsDao;

@Service("applicationsService")
@Transactional(propagation=Propagation.REQUIRED)
public class SysApplicationsServiceImpl implements SysApplicationsService{
	private SysApplicationsDao applicationsDao;
	@Autowired
	public void setApplicationsDao(SysApplicationsDao applicationsDao) {
		this.applicationsDao = applicationsDao;
	}
	
	public void deleteByPrimaryKey(Serializable applicationid) {
		// TODO Auto-generated method stub
		this.applicationsDao.deleteByPrimaryKey(applicationid);
	}
	
	public List<SysApplication> selectAllRecord() {
		// TODO Auto-generated method stub
		return this.applicationsDao.selectAllRecord();
	}
	
	public List<SysApplication> selectAppForPage(QueryPara<SysApplication> qp) {
		// TODO Auto-generated method stub
		return this.applicationsDao.selectAppForPage(qp);
	}
	
	public void saveOrUpdate(SysApplication record) {
		// TODO Auto-generated method stub
		//System.out.println("未设置order值："+record.getAorder());
		if(record.getAorder()==null)
		{
			record.setAorder(this.applicationsDao.selectMaxOrder());
		}
		this.applicationsDao.saveOrUpdate(record);
	}
	
	public SysApplication selectByPrimaryKey(Serializable applicationid) {
		// TODO Auto-generated method stub
		return this.applicationsDao.selectByPrimaryKey(applicationid);
	}

	

	

}
