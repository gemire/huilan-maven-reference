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
import com.hedgehog.outletss.Utils.QueryPara;
import com.hedgehog.outletss.domain.SysField;
import com.hedgehog.outletss.domain.SysFieldValue;
import com.hedgehog.outletss.persistence.SysFieldDao;

@Service("sysFieldService")
@Transactional(propagation=Propagation.REQUIRED)
public class SysFieldServiceImpl implements SysFieldService{
	
	private SysFieldDao sysFieldDao;
	@Autowired
	public void setSysFieldDao(SysFieldDao sysFieldDao) {
		this.sysFieldDao = sysFieldDao;
	}
	
	public List<SysField> selectRecordForPage(QueryPara<SysField> qp) {
		// TODO Auto-generated method stub
		return this.sysFieldDao.selectRecordForPage(qp);
	}
	
	public SysField selectByPrimaryKey(Serializable fieldId) {
		// TODO Auto-generated method stub
		return this.sysFieldDao.selectByPrimaryKey(fieldId);
	}
	
	public void saveOrUpdate(SysField record) {
		// TODO Auto-generated method stub
		this.sysFieldDao.saveOrUpdate(record);
	}
	
	public void deleteByPrimaryKey(Serializable fieldId) {
		// TODO Auto-generated method stub
		this.sysFieldDao.deleteByPrimaryKey(fieldId);
	}

	
	public List<SysFieldValue> selectFieldValueAllRecord() {
		// TODO Auto-generated method stub
		return this.sysFieldDao.selectFieldValueAllRecord();
	}
	
	public SysFieldValue selectFieldValueByPrimaryKey(Serializable valueId) {
		// TODO Auto-generated method stub
		return this.sysFieldDao.selectFieldValueByPrimaryKey(valueId);
	}
	
	public void saveOrUpdateFieldValue(SysFieldValue record) {
		// TODO Auto-generated method stub
		this.sysFieldDao.saveOrUpdateFieldValue(record);
	}
	
	public void deleteFieldValueByPrimaryKey(Serializable valueId) {
		// TODO Auto-generated method stub
		this.sysFieldDao.deleteFieldValueByPrimaryKey(valueId);
	}
	
	public List<SysFieldValue> selectFieldValueRecordByvfKey(String vfKey) {
		// TODO Auto-generated method stub
		return this.sysFieldDao.selectFieldValueRecordByvfKey(vfKey);
	}

}
