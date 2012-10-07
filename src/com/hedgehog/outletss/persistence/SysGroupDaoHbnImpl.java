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
import com.hedgehog.outletss.domain.SysGroup;

/**
 * @author Administrator
 *
 */
@Repository("sysGroupDao")
public class SysGroupDaoHbnImpl implements SysGroupDao {
	private static final Log log = LogFactory.getLog(SysGroupDaoHbnImpl.class);
	private SessionFactory sessionFactory;
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	

	/* (non-Javadoc)
	 * @see com.hedgehog.outletss.persistence.SysGroupDao#selectRecordForPage(com.hedgehog.outletss.domain.QueryPara)
	 */
    @Override
	@Cacheable(cacheName = "baseCache")
	@SuppressWarnings("unchecked")
	public List<SysGroup> selectRecordForPage(QueryPara<SysGroup> qp) {
		// TODO Auto-generated method stub
		List<SysGroup> result=null;
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
		        result = (List<SysGroup>)criteria.list();			 
		 }
		 catch (RuntimeException re)   
		    {   
			 log.error(re.getMessage());
		    }				 
		 return result;
	}

	/* (non-Javadoc)
	 * @see com.hedgehog.outletss.persistence.SysGroupDao#selectByPrimaryKey(java.io.Serializable)
	 */
	@Override
	@Cacheable(cacheName = "baseCache")
	public SysGroup selectByPrimaryKey(Serializable id) {
		// TODO Auto-generated method stub
		return (SysGroup)this.sessionFactory.getCurrentSession().load(SysGroup.class, id);
	}

	/* (non-Javadoc)
	 * @see com.hedgehog.outletss.persistence.SysGroupDao#saveOrUpdate(com.hedgehog.outletss.domain.SysGroup)
	 */
	@Override
	@TriggersRemove(cacheName = "baseCache", when = When.AFTER_METHOD_INVOCATION, removeAll = true)
	public void saveOrUpdate(SysGroup record) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().saveOrUpdate(record);
	}

	/* (non-Javadoc)
	 * @see com.hedgehog.outletss.persistence.SysGroupDao#deleteByPrimaryKey(java.io.Serializable)
	 */
	@Override
	@TriggersRemove(cacheName = "baseCache", when = When.AFTER_METHOD_INVOCATION, removeAll = true)
	public void deleteByPrimaryKey(Serializable id) {
		// TODO Auto-generated method stub
		SysGroup sysGroup=(SysGroup)this.sessionFactory.getCurrentSession().load(SysGroup.class, id);
		if(sysGroup!=null)
		{
			this.sessionFactory.getCurrentSession().delete(sysGroup);
		}
	}

}
