package com.hedgehog.outletss.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hedgehog.outletss.domain.SysUser;
import com.hedgehog.outletss.persistence.SysUserDao;

@Service("myUserDetailsService")
@Transactional(propagation=Propagation.REQUIRED)
public class MyUserDetailsServiceImpl implements MyUserDetailsService {
	private SysUserDao sysUserDao;	
	@Autowired
	public void setUserDao(SysUserDao sysUserDao) {
		this.sysUserDao = sysUserDao;		
	}
	
	


	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
//		Md5PasswordEncoder md5 = new Md5PasswordEncoder(); 
//		System.out.println( md5.encodePassword("admin", "admin"));  
		SysUser user=this.sysUserDao.findUserByName(username);
		if(null==user)
		{
			throw new UsernameNotFoundException("用户名"+username+"不存在");
		}
		return user;
	}




	@Override
	public List<SysUser> selectAllRecord() {
		// TODO Auto-generated method stub
		return this.sysUserDao.selectAllRecord();
	}




	@Override
	public SysUser selectByPrimaryKey(Serializable userId) {
		// TODO Auto-generated method stub
		return this.sysUserDao.selectByPrimaryKey(userId);
	}




	@Override
	public void saveOrUpdate(SysUser record) {
		// TODO Auto-generated method stub
		//Md5PasswordEncoder md5 = new Md5PasswordEncoder(); 
		//md5.encodePassword(record.getPassword(), record.getUsername());
		this.sysUserDao.saveOrUpdate(record);
	}




	@Override
	public void deleteByPrimaryKey(Serializable userId) {
		// TODO Auto-generated method stub
		this.sysUserDao.deleteByPrimaryKey(userId);
	}
	

}
