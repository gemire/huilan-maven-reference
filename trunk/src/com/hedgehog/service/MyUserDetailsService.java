package com.hedgehog.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.hedgehog.domain.SysUser;

public interface MyUserDetailsService extends UserDetailsService{
	List<SysUser> selectAllRecord();
	SysUser selectByPrimaryKey(Serializable userId);
	void saveOrUpdate(SysUser record);
	void deleteByPrimaryKey(Serializable userId);

}
