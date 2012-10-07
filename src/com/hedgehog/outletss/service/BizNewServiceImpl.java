package com.hedgehog.outletss.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.BizNew;
import com.hedgehog.outletss.persistence.BizNewDao;

@Service("bizNewService")
@Transactional(propagation=Propagation.REQUIRED)
public class BizNewServiceImpl implements BizNewService {
	private BizNewDao bizNewDao;
	
	@Autowired
	public void setBizNewDao(BizNewDao bizNewDao) {
		this.bizNewDao = bizNewDao;
	}
	
	@Override
	public List<BizNew> selectRecordForPage(QueryPara<BizNew> qp) {
		// TODO Auto-generated method stub
		return this.bizNewDao.selectRecordForPage(qp);
	}

	

	@Override
	public BizNew selectByPrimaryKey(Serializable id) {
		// TODO Auto-generated method stub
		return this.bizNewDao.selectByPrimaryKey(id);
	}

	@Override
	public void saveOrUpdate(BizNew record) {
		// TODO Auto-generated method stub
		this.bizNewDao.saveOrUpdate(record);
	}

	@Override
	public void deleteByPrimaryKey(Serializable id) {
		// TODO Auto-generated method stub
		this.bizNewDao.deleteByPrimaryKey(id);
	}

}
