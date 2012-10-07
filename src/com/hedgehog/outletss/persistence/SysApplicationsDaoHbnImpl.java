package com.hedgehog.outletss.persistence;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.TriggersRemove;
import com.googlecode.ehcache.annotations.When;
import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.SysApplication;

@Repository("applicationsDao")
public class SysApplicationsDaoHbnImpl implements SysApplicationsDao{
	
	private static final Log log = LogFactory.getLog(SysApplicationsDao.class);
	private SessionFactory sessionFactory;
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	
    @TriggersRemove(cacheName = "baseCache", when = When.AFTER_METHOD_INVOCATION, removeAll = true)
	public void deleteByPrimaryKey(Serializable applicationid) {
		// TODO Auto-generated method stub
		SysApplication app=(SysApplication)this.sessionFactory.getCurrentSession().load(SysApplication.class, applicationid);
		this.sessionFactory.getCurrentSession().delete(app);		
	}
	@SuppressWarnings("unchecked")	
	@Cacheable(cacheName = "baseCache")
	public List<SysApplication> selectAllRecord() {
		// TODO Auto-generated method stub
		List<SysApplication> list=(List<SysApplication>)this.sessionFactory.getCurrentSession().createCriteria(SysApplication.class).addOrder(Order.asc("aorder")).list();
		return list;
	}
	@SuppressWarnings("unchecked")	
	@Cacheable(cacheName = "baseCache")
	public List<SysApplication> selectAppForPage(final QueryPara<SysApplication> qp) {
		// TODO Auto-generated method stub
		List<SysApplication> result=null;
		try
		{
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(qp.getClazz());
			 List<Criterion> list=qp.getCriterions();
			 if (list != null)   
		        {   
					 if(list.size()>0)
					 {						 
			            for (Criterion cri : list)   
			            {   
			                criteria.add(cri);
			            }
					 }
		        }
			// ��ȡ���������ҳ��ѯ�������� 
			 //System.out.println("��ȡ���������ҳ��ѯ��������");
		        int rowCount = ((Number) criteria.setProjection(   
		                Projections.rowCount()).uniqueResult()).intValue();   
		        criteria.setProjection(null);   
		        qp.setRecordcount(rowCount);		        
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
			            for (Order ord : list2)   
			            {   
			                criteria.addOrder(ord);//(Restrictions.like(key, map2.get(key)));   
			            }				        		
		        	}
		        }				        
		        criteria.setFirstResult((qp.getPageNo() - 1) * qp.getPagesize());   
		        criteria.setMaxResults(qp.getPagesize());				  
		        result = (List<SysApplication>)criteria.list();					 
			 
		 }
		 catch (RuntimeException re)   
		    {   
			 log.error(re.getMessage());
		    }				 
		 return result;
	}
	@TriggersRemove(cacheName = "baseCache", when = When.AFTER_METHOD_INVOCATION, removeAll = true)
	public void saveOrUpdate(SysApplication record) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().saveOrUpdate(record);
		
	}
	@Cacheable(cacheName = "baseCache")
	public SysApplication selectByPrimaryKey(Serializable applicationid) {
		// TODO Auto-generated method stub
		SysApplication app=(SysApplication)this.sessionFactory.getCurrentSession().load(SysApplication.class, applicationid);
		return app;
	}
	@Override
	public Integer selectMaxOrder() {
		// TODO Auto-generated method stub
		SQLQuery sqlquery=this.sessionFactory.getCurrentSession().createSQLQuery("select max(A_Order) from sys_Applications");		
		int maxorder = ((Number)sqlquery.uniqueResult()).intValue();			
		return maxorder;
	}	

}
