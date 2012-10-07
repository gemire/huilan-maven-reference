/**
 * 
 */
package com.hedgehog.outletss.persistence;

import java.io.Serializable;
import java.util.List;

import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.SysUser;

/**
 * @author Administrator
 *
 */
public interface SysUserDao {
	public SysUser findUserByName(String name);
	List<SysUser> selectRecordForPage(QueryPara<SysUser> qp);
	List<SysUser> selectAllRecord();
	SysUser selectByPrimaryKey(Serializable userId);
	boolean authenticate(String username,String password);
	SysUser selectByUserName(String username);
	void saveOrUpdate(SysUser record);
	void deleteByPrimaryKey(Serializable userId);
}
