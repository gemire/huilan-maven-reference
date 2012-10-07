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
import com.hedgehog.outletss.domain.SysRole;
import com.hedgehog.outletss.persistence.SysRoleDao;

@Service("sysRoleService")
@Transactional(propagation=Propagation.REQUIRED)
public class SysRoleServiceImpl implements SysRoleService{

	private SysRoleDao sysRoleDao;
	@Autowired
	public void setSysRoleDao(SysRoleDao sysRoleDao) {
		this.sysRoleDao = sysRoleDao;
	}
	
	public void deleteByPrimaryKey(Serializable roleId) {
		// TODO Auto-generated method stub
		this.sysRoleDao.deleteByPrimaryKey(roleId);
	}
	
	public void saveOrUpdate(SysRole record) {
		// TODO Auto-generated method stub
		this.sysRoleDao.saveOrUpdate(record);
	}
	
	public List<SysRole> selectAllRecord() {
		// TODO Auto-generated method stub
		return this.sysRoleDao.selectAllRecord();
	}
	
	public SysRole selectByPrimaryKey(Serializable roleId) {
		// TODO Auto-generated method stub
		return this.sysRoleDao.selectByPrimaryKey(roleId);
	}
	
	public List<SysRole> selectRecordForPage(QueryPara<SysRole> qp) {
		// TODO Auto-generated method stub
		return this.sysRoleDao.selectRecordForPage(qp);
	}

	

}
