/**
 * 
 */
package com.hedgehog.outletss.service;

import java.io.Serializable;
import java.util.List;

import com.hedgehog.outletss.domain.BizInfo;
import com.hedgehog.outletss.domain.BizInfoPK;
import com.hedgehog.outletss.domain.QueryPara;

/**
 * @author Administrator
 *
 */
public interface BizInfoService {
	List<BizInfo> selectRecordForPage(QueryPara<BizInfo> qp);	
	BizInfo selectByPrimaryKey(BizInfoPK comp_id);
	void saveOrUpdate(BizInfo record);	
	void deleteByPrimaryKey(BizInfoPK comp_id);

}
