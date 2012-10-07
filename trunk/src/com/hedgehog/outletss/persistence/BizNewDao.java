package com.hedgehog.outletss.persistence;

import java.io.Serializable;
import java.util.List;

import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.BizNew;



public interface BizNewDao {
	List<BizNew> selectRecordForPage(QueryPara<BizNew> qp);	
	BizNew selectByPrimaryKey(Serializable id);
	void saveOrUpdate(BizNew record);	
	void deleteByPrimaryKey(Serializable id);

}
