/**
 * 
 */
package com.hedgehog.outletss.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.SysGroup;
import com.hedgehog.outletss.persistence.SysGroupDao;

/**
 * @author Administrator
 *
 */
@Service("sysGroupService")
@Transactional(propagation=Propagation.REQUIRED)
public class SysGroupServiceImpl implements SysGroupService {
	private SysGroupDao sysGroupDao;	
	@Autowired
	public void setSysGroupDao(SysGroupDao sysGroupDao) {
		this.sysGroupDao = sysGroupDao;
	}

	/* (non-Javadoc)
	 * @see com.hedgehog.outletss.service.SysGroupService#selectRecordForPage(com.hedgehog.outletss.domain.QueryPara)
	 */
	@Override
	public List<SysGroup> selectRecordForPage(QueryPara<SysGroup> qp) {
		// TODO Auto-generated method stub
		return this.sysGroupDao.selectRecordForPage(qp);
	}

	/* (non-Javadoc)
	 * @see com.hedgehog.outletss.service.SysGroupService#selectByPrimaryKey(java.io.Serializable)
	 */
	@Override
	public SysGroup selectByPrimaryKey(Serializable id) {
		// TODO Auto-generated method stub
		return this.sysGroupDao.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.hedgehog.outletss.service.SysGroupService#saveOrUpdate(com.hedgehog.outletss.domain.SysGroup)
	 */
	@Override
	public void saveOrUpdate(SysGroup record) {
		// TODO Auto-generated method stub
		this.sysGroupDao.saveOrUpdate(record);
	}

	/* (non-Javadoc)
	 * @see com.hedgehog.outletss.service.SysGroupService#deleteByPrimaryKey(java.io.Serializable)
	 */
	@Override
	public void deleteByPrimaryKey(Serializable id) {
		// TODO Auto-generated method stub
		this.sysGroupDao.deleteByPrimaryKey(id);
	}

}
