/**
 * 
 */
package com.hedgehog.outletss.persistence;

import java.io.Serializable;
import java.util.List;

import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.SysEvent;

/**
 * @author Administrator
 *
 */
public interface SysEventDao {
	List<SysEvent> selectRecordForPage(QueryPara<SysEvent> qp);	
	SysEvent selectByPrimaryKey(Serializable id);
	void saveOrUpdate(SysEvent record);	
	void deleteByPrimaryKey(Serializable id);

}
