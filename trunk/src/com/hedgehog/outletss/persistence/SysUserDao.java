/**
 * 
 */
package com.hedgehog.outletss.persistence;

import java.io.Serializable;
import java.util.List;

import com.hedgehog.outletss.domain.SysUser;

/**
 * @author Administrator
 *
 */
public interface SysUserDao {
	public SysUser findUserByName(String name);
	
	List<SysUser> selectAllRecord();
	SysUser selectByPrimaryKey(Serializable userId);
	void saveOrUpdate(SysUser record);
	void deleteByPrimaryKey(Serializable userId);
}
