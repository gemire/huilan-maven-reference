package com.hedgehog.outletss.service;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.SysUser;
import com.hedgehog.outletss.persistence.SysUserDao;

@Service("myUserDetailsService")
@Transactional(propagation=Propagation.REQUIRED)
public class MyUserDetailsServiceImpl implements MyUserDetailsService {
	private static final Log log = LogFactory.getLog(SysUser.class);
	
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
		log.info("有没有到这里：");
		if(null==user)
		{			
			throw new UsernameNotFoundException("用户名"+username+"不存在");
		}
		
		List <GrantedAuthority> list=(List<GrantedAuthority>) user.getAuthorities();
		for(GrantedAuthority au:list)
		{
			log.info("角色："+au.getAuthority());
		}
		return user;
	}




	@Override
	public List<SysUser> selectAllRecord() {
		// TODO Auto-generated method stub
		return this.sysUserDao.selectAllRecord();
	}
	@Override
	public List<SysUser> selectRecordForPage(QueryPara<SysUser> qp) {
		// TODO Auto-generated method stub
		return this.sysUserDao.selectRecordForPage(qp);
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




	@Override
	public SysUser selectByUserName(String username) {
		// TODO Auto-generated method stub
		return this.sysUserDao.selectByUserName(username);
	}




	@Override
	public boolean authenticate(String username, String password) {
		// TODO Auto-generated method stub
		return this.sysUserDao.authenticate(username, password);
	}
	

}
