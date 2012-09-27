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
import com.hedgehog.outletss.Utils.QueryPara;
import com.hedgehog.outletss.domain.SysRolePermission;

@Repository("rolePermission")
public class SysRolePermissionDaoHbnImpl implements SysRolePermissionDao{
	
	private static final Log log = LogFactory.getLog(SysRolePermissionDao.class);
	private SessionFactory sessionFactory;
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	
    @TriggersRemove(cacheName = "baseCache", when = When.AFTER_METHOD_INVOCATION, removeAll = true)
	public void deleteByPrimaryKey(Serializable roleId) {
		// TODO Auto-generated method stub
		SysRolePermission sysRolePermission=(SysRolePermission)this.sessionFactory.getCurrentSession().load(SysRolePermission.class, roleId);
		if(sysRolePermission!=null)
		{
			this.sessionFactory.getCurrentSession().delete(sysRolePermission);
		}
	}
    @TriggersRemove(cacheName = "baseCache", when = When.AFTER_METHOD_INVOCATION, removeAll = true)
	public void saveOrUpdate(SysRolePermission record) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().merge(record);
	}	
	
	@SuppressWarnings("unchecked")
	@Cacheable(cacheName = "baseCache")
	public List<SysRolePermission> selectAllRecord() {
		// TODO Auto-generated method stub
		return (List<SysRolePermission>)this.sessionFactory.getCurrentSession().createCriteria(SysRolePermission.class).list();
	}
	@Cacheable(cacheName = "baseCache")
	public SysRolePermission selectByPrimaryKey(Serializable roleId) {
		// TODO Auto-generated method stub
		return (SysRolePermission)this.sessionFactory.getCurrentSession().load(SysRolePermission.class, roleId);
	}
	@SuppressWarnings("unchecked")
	@Cacheable(cacheName = "baseCache")
	public List<SysRolePermission> selectRecordForPage(
			QueryPara<SysRolePermission> qp) {
		// TODO Auto-generated method stub
		List<SysRolePermission> result=null;
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
		        result = (List<SysRolePermission>)criteria.list();					 
			 
		 }
		 catch (RuntimeException re)   
		    {   
			 log.error(re.getMessage());
		    }				 
		 return result;		
	}

	

}
