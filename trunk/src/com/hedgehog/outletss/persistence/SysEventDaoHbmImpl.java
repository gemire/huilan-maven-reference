/**
 * 
 */
package com.hedgehog.outletss.persistence;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
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
import com.hedgehog.outletss.domain.SysEvent;

/**
 * @author Administrator
 *
 */
@Repository("sysEventDao")
public class SysEventDaoHbmImpl implements SysEventDao {

	private static final Log log = LogFactory.getLog(SysEventDaoHbmImpl.class);
	private SessionFactory sessionFactory;
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	

	/* (non-Javadoc)
	 * @see com.hedgehog.outletss.persistence.SysEventDao#selectRecordForPage(com.hedgehog.outletss.Utils.QueryPara)
	 */
	@Override
	@Cacheable(cacheName = "baseCache")
	@SuppressWarnings("unchecked")
	public List<SysEvent> selectRecordForPage(QueryPara<SysEvent> qp) {
		// TODO Auto-generated method stub
		List<SysEvent> result=null;
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
		        result = (List<SysEvent>)criteria.list();					 
			 
		 }
		 catch (RuntimeException re)   
		    {   
			 log.error(re.getMessage());
		    }				 
		 return result;
	}

	/* (non-Javadoc)
	 * @see com.hedgehog.outletss.persistence.SysEventDao#selectByPrimaryKey(java.io.Serializable)
	 */
	@Override
	@Cacheable(cacheName = "baseCache")
	public SysEvent selectByPrimaryKey(Serializable id) {
		// TODO Auto-generated method stub
		return (SysEvent)this.sessionFactory.getCurrentSession().load(SysEvent.class, id);
	}

	/* (non-Javadoc)
	 * @see com.hedgehog.outletss.persistence.SysEventDao#saveOrUpdate(com.hedgehog.outletss.domain.SysEvent)
	 */
	@Override
	@TriggersRemove(cacheName = "baseCache", when = When.AFTER_METHOD_INVOCATION, removeAll = true)
	public void saveOrUpdate(SysEvent record) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().saveOrUpdate(record);
	}

	/* (non-Javadoc)
	 * @see com.hedgehog.outletss.persistence.SysEventDao#deleteByPrimaryKey(java.io.Serializable)
	 */
	@Override
	@TriggersRemove(cacheName = "baseCache", when = When.AFTER_METHOD_INVOCATION, removeAll = true)
	public void deleteByPrimaryKey(Serializable id) {
		// TODO Auto-generated method stub
		SysEvent sysEvent=(SysEvent)this.sessionFactory.getCurrentSession().load(SysEvent.class, id);
		if(sysEvent!=null)
		{
			this.sessionFactory.getCurrentSession().delete(sysEvent);
		}
	}

}
