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
import com.hedgehog.outletss.domain.SysEvent;
import com.hedgehog.outletss.persistence.SysEventDao;

/**
 * @author Administrator
 *
 */
@Service("sysEventService")
@Transactional(propagation=Propagation.REQUIRED)
public class SysEventServiceImpl implements SysEventService {
	private SysEventDao sysEventDao;
	
	@Autowired
	public void setSysEventDao(SysEventDao sysEventDao) {
		this.sysEventDao = sysEventDao;
	}

	/* (non-Javadoc)
	 * @see com.hedgehog.outletss.service.SysEventService#selectRecordForPage(com.hedgehog.outletss.Utils.QueryPara)
	 */
	@Override
	public List<SysEvent> selectRecordForPage(QueryPara<SysEvent> qp) {
		// TODO Auto-generated method stub
		return this.sysEventDao.selectRecordForPage(qp);
	}

	/* (non-Javadoc)
	 * @see com.hedgehog.outletss.service.SysEventService#selectByPrimaryKey(java.io.Serializable)
	 */
	@Override
	public SysEvent selectByPrimaryKey(Serializable id) {
		// TODO Auto-generated method stub
		return this.sysEventDao.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.hedgehog.outletss.service.SysEventService#saveOrUpdate(com.hedgehog.outletss.domain.SysEvent)
	 */
	@Override
	public void saveOrUpdate(SysEvent record) {
		// TODO Auto-generated method stub
		this.sysEventDao.saveOrUpdate(record);
	}

	/* (non-Javadoc)
	 * @see com.hedgehog.outletss.service.SysEventService#deleteByPrimaryKey(java.io.Serializable)
	 */
	@Override
	public void deleteByPrimaryKey(Serializable id) {
		// TODO Auto-generated method stub
		this.sysEventDao.deleteByPrimaryKey(id);
	}

}
