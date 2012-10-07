/**
 * 
 */
package com.hedgehog.outletss.persistence;

import java.io.Serializable;
import java.util.List;

import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.SysGroup;

/**
 * @author Administrator
 *
 */
public interface SysGroupDao {
	List<SysGroup> selectRecordForPage(QueryPara<SysGroup> qp);	
	SysGroup selectByPrimaryKey(Serializable id);
	void saveOrUpdate(SysGroup record);	
	void deleteByPrimaryKey(Serializable id);

}
