package com.hedgehog.outletss.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.hedgehog.outletss.Utils.QueryPara;
import com.hedgehog.outletss.domain.SysUser;

public interface MyUserDetailsService extends UserDetailsService{
	List<SysUser> selectAllRecord();
	List<SysUser> selectRecordForPage(QueryPara<SysUser> qp);
	SysUser selectByPrimaryKey(Serializable userId);
	void saveOrUpdate(SysUser record);
	void deleteByPrimaryKey(Serializable userId);

}
