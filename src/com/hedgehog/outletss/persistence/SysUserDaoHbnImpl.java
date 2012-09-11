package com.hedgehog.outletss.persistence;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hedgehog.outletss.domain.SysUser;

@Repository("sysUserDao")
public class SysUserDaoHbnImpl implements SysUserDao{
	private static final Log log = LogFactory.getLog(SysUserDao.class);
	private SessionFactory sessionFactory;
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public SysUser findUserByName(final String name) {
		// TODO Auto-generated method stub
		SQLQuery sqlquery=this.sessionFactory.getCurrentSession().createSQLQuery("select * from DIG_USER where USER_NAME=:uloginName");
		sqlquery.setParameter("uloginName", name);
		sqlquery.addEntity(SysUser.class);	
		//sqlquery.setMaxResults(1);
		return (SysUser)sqlquery.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SysUser> selectAllRecord() {
		// TODO Auto-generated method stub
		return (List<SysUser>)this.sessionFactory.getCurrentSession().createCriteria(SysUser.class).list();
	}

	@Override
	public SysUser selectByPrimaryKey(Serializable userId) {
		// TODO Auto-generated method stub
		return (SysUser)this.sessionFactory.getCurrentSession().load(SysUser.class, userId);
	}

	@Override
	public void saveOrUpdate(SysUser record) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().saveOrUpdate(record);
	}

	@Override
	public void deleteByPrimaryKey(Serializable userId) {
		// TODO Auto-generated method stub
		SysUser user=(SysUser)this.sessionFactory.getCurrentSession().load(SysUser.class, userId);
		if(user!=null)
		{
			this.sessionFactory.getCurrentSession().delete(user);
		}
	}
	

}
