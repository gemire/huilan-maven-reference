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
import com.hedgehog.outletss.Utils.QueryPara;
import com.hedgehog.outletss.domain.SysField;
import com.hedgehog.outletss.domain.SysFieldValue;


@Repository("sysFieldDao")
public class SysFieldDaoHbnImpl implements SysFieldDao{
	
	private static final Log log = LogFactory.getLog(SysFieldDao.class);
	private SessionFactory sessionFactory;
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	
    @SuppressWarnings("unchecked")    
    @Cacheable(cacheName = "baseCache")
    public List<SysField> selectRecordForPage(QueryPara<SysField> qp) {
		// TODO Auto-generated method stub
    	List<SysField> result=null;
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
		        result = (List<SysField>)criteria.list();					 
			 
		 }
		 catch (RuntimeException re)   
		    {   
			 log.error(re.getMessage());
		    }				 
		 return result;		
	}
    @Cacheable(cacheName = "baseCache")
    public SysField selectByPrimaryKey(Serializable fieldId) {
		// TODO Auto-generated method stub
		return (SysField)this.sessionFactory.getCurrentSession().load(SysField.class, fieldId);
	}
    @TriggersRemove(cacheName = "baseCache", when = When.AFTER_METHOD_INVOCATION, removeAll = true)
    public void saveOrUpdate(SysField record) {
		// TODO Auto-generated method stub
    	this.sessionFactory.getCurrentSession().merge(record);
	}
    @TriggersRemove(cacheName = "baseCache", when = When.AFTER_METHOD_INVOCATION, removeAll = true)
	public void deleteByPrimaryKey(Serializable fieldId) {
		// TODO Auto-generated method stub
		SysField sysField=(SysField)this.sessionFactory.getCurrentSession().load(SysField.class, fieldId);
		if(sysField!=null)
		{
			this.sessionFactory.getCurrentSession().delete(sysField);
		}
	}	
	
	@SuppressWarnings("unchecked")	
	@Cacheable(cacheName = "baseCache")
	public List<SysFieldValue> selectFieldValueAllRecord() {
		// TODO Auto-generated method stub
		return (List<SysFieldValue>)this.sessionFactory.getCurrentSession().createCriteria(SysFieldValue.class).list();
	}
	@Cacheable(cacheName = "baseCache")
	public SysFieldValue selectFieldValueByPrimaryKey(Serializable valueId) {
		// TODO Auto-generated method stub
		return (SysFieldValue)this.sessionFactory.getCurrentSession().load(SysFieldValue.class, valueId);
	}
	@TriggersRemove(cacheName = "baseCache", when = When.AFTER_METHOD_INVOCATION, removeAll = true)
	public void saveOrUpdateFieldValue(SysFieldValue record) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().merge(record);
	}
	@TriggersRemove(cacheName = "baseCache", when = When.AFTER_METHOD_INVOCATION, removeAll = true)
	public void deleteFieldValueByPrimaryKey(Serializable valueId) {
		// TODO Auto-generated method stub
		SysFieldValue sysFieldValue=(SysFieldValue)this.sessionFactory.getCurrentSession().load(SysFieldValue.class, valueId);
		if(sysFieldValue!=null)
		{
			this.sessionFactory.getCurrentSession().delete(sysFieldValue);
		}
	}
	@SuppressWarnings("unchecked")	
	@Cacheable(cacheName = "baseCache")
	public List<SysFieldValue> selectFieldValueRecordByvfKey(String vfKey) {
		// TODO Auto-generated method stub
		SQLQuery sqlquery=this.sessionFactory.getCurrentSession().createSQLQuery("select M.* from sys_FieldValue M where M.V_F_Key='"+vfKey+"' order by M.V_ShowOrder asc");
    	sqlquery.addEntity(SysFieldValue.class);
    	//List<SysFieldValue> result=(List<SysFieldValue>)sqlquery.list();
		return (List<SysFieldValue>)sqlquery.list();
	}	

}
