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

import com.hedgehog.outletss.domain.BizInfo;
import com.hedgehog.outletss.domain.BizInfoPK;
import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.persistence.BizInfoDao;
import com.hedgehog.outletss.persistence.BizNewDao;

/**
 * @author Administrator
 *
 */
@Service("bizInfoService")
@Transactional(propagation=Propagation.REQUIRED)
public class BizInfoServiceImpl implements BizInfoService {
   private BizInfoDao bizInfoDao;	
	
   @Autowired
	public void setBizInfoDao(BizInfoDao bizInfoDao) {
	  this.bizInfoDao = bizInfoDao;
   }

	/* (non-Javadoc)
	 * @see com.hedgehog.outletss.service.BizInfoService#selectRecordForPage(com.hedgehog.outletss.domain.QueryPara)
	 */
	@Override
	public List<BizInfo> selectRecordForPage(QueryPara<BizInfo> qp) {
		// TODO Auto-generated method stub
		return this.bizInfoDao.selectRecordForPage(qp);
	}

	/* (non-Javadoc)
	 * @see com.hedgehog.outletss.service.BizInfoService#selectByPrimaryKey(java.io.Serializable)
	 */
	@Override
	public BizInfo selectByPrimaryKey(BizInfoPK comp_id) {
		// TODO Auto-generated method stub
		return this.bizInfoDao.selectByPrimaryKey(comp_id);
	}

	/* (non-Javadoc)
	 * @see com.hedgehog.outletss.service.BizInfoService#saveOrUpdate(com.hedgehog.outletss.domain.BizInfo)
	 */
	@Override
	public void saveOrUpdate(BizInfo record) {
		// TODO Auto-generated method stub
		this.bizInfoDao.saveOrUpdate(record);
	}

	/* (non-Javadoc)
	 * @see com.hedgehog.outletss.service.BizInfoService#deleteByPrimaryKey(java.io.Serializable)
	 */
	@Override
	public void deleteByPrimaryKey(BizInfoPK comp_id) {
		// TODO Auto-generated method stub
		this.bizInfoDao.deleteByPrimaryKey(comp_id);
	}

}
