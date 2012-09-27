package com.hedgehog.outletss.persistence;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.googlecode.ehcache.annotations.Cacheable;
import com.hedgehog.outletss.Utils.QueryPara;
import com.hedgehog.outletss.domain.SysUser;

@Repository("sysUserDao")
public class SysUserDaoHbnImpl implements SysUserDao{
	private static final Log log = LogFactory.getLog(SysUserDaoHbnImpl.class);
	private SessionFactory sessionFactory;
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public SysUser findUserByName(final String name) {
		// TODO Auto-generated method stub
		SQLQuery sqlquery=this.sessionFactory.getCurrentSession().createSQLQuery("select * from sys_User where U_LoginName=:uloginName");
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
	@SuppressWarnings("unchecked")
	@Cacheable(cacheName = "baseCache")
	public List<SysUser> selectRecordForPage(QueryPara<SysUser> qp) {
		// TODO Auto-generated method stub
		//处理分页开始
		List<SysUser> result=null;
		 try
		 {
			 Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(qp.getClazz());
			 List<Criterion> list=qp.getCriterions();
			 if (list != null)   
		        {   
					 if(list.size()>0)
					 {
						 //Set<String> keys = map.keySet();   
			            for (Criterion cri : list)   
			            {   
			                criteria.add(cri);
			            }
					 }
		        }
			// 获取根据条件分页查询的总行数 
			 //System.out.println("获取根据条件分页查询的总行数");
		        int rowCount = ((Number) criteria.setProjection(   
		                Projections.rowCount()).uniqueResult()).intValue();   
		        criteria.setProjection(null);   
		        criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		        qp.setRecordcount(rowCount);		        
		        //qp.setPagecount(qp.getRecordcount() % qp.getPagesize() != 0 ? qp.getRecordcount()/qp.getPagesize() + 1: qp.getRecordcount()/ qp.getPagesize());
		        qp.setPagecount((qp.getRecordcount()+qp.getPagesize() - 1)/qp.getPagesize());
		        if(qp.getPageNo()>qp.getPagecount())
		        {				        	
		        	qp.setPageNo(qp.getPagecount());
		        }
		        if(qp.getPageNo()<1)
		        {
		        	qp.setPageNo(1);
		        }				        
		        List<Order> list2=qp.getOrders();
		        if (list2 != null)   
		        { 
		        	if(list2.size()>0)
		        	{
		        		 //Set<String> keys = map2.keySet();   
			            for (Order ord : list2)   
			            {   
			                criteria.addOrder(ord);//(Restrictions.like(key, map2.get(key)));   
			            }				        		
		        	}
		        }				        
		        criteria.setFirstResult((qp.getPageNo() - 1) * qp.getPagesize());   
		        criteria.setMaxResults(qp.getPagesize());
		        //criteria.setResultTransformer(Transformers.aliasToBean(SysUser.class));
		        //criteria.setResultTransformer(new AliasToBeanResultTransformer(SysUser.class));
		        result = (List<SysUser>)criteria.list();					 
			 
		 }
		 catch (RuntimeException re)   
		    {   
			 log.error(re.getMessage());
		    }				 
		 return result;
		 //处理分页结束		
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
