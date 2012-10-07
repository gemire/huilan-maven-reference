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
import com.hedgehog.outletss.domain.SysModule;


@Repository("sysModuleDao")
public class SysModuleDaoHbnImpl implements SysModuleDao{
	
	private static final Log log = LogFactory.getLog(SysModuleDao.class);
	private SessionFactory sessionFactory;
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	
    @SuppressWarnings("unchecked")
    @Cacheable(cacheName = "baseCache")
	public List<SysModule> selectParentModules(final QueryPara<SysModule> qp) {
		// TODO Auto-generated method stub
		List<SysModule> result=null;		

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
		        result = (List<SysModule>)criteria.list();					 
			 
		 }
		 catch (RuntimeException re)   
		    {   
			 log.error(re.getMessage());
		    }				 
		 return result;
	}
    @SuppressWarnings("unchecked")  
    @Cacheable(cacheName = "baseCache")
    public List<SysModule> selectParentModules() 
    {
    	//List<SysModule> result=null;
    	SQLQuery sqlquery=this.sessionFactory.getCurrentSession().createSQLQuery("select M.* from sys_Module as M inner join sys_Applications as A on M.M_ApplicationID=A.ApplicationID where M.M_ParentID=0 and M_Close=0 order by A.A_Order asc, M.M_OrderLevel asc");
    	sqlquery.addEntity(SysModule.class);
    	List<SysModule> result=(List<SysModule>)sqlquery.list();
    	return result;
    }
    @Cacheable(cacheName = "baseCache")
	public SysModule selectSysModuleByPrimaryKey(Serializable moduleId) {
		// TODO Auto-generated method stub
		SysModule sysModule=(SysModule)this.sessionFactory.getCurrentSession().load(SysModule.class, moduleId);
		return sysModule;
	}
	@SuppressWarnings("unchecked")	
	@Cacheable(cacheName = "baseCache")
	public List<SysModule> selectSubModulesByParentId(Serializable mapplicationId,
			Serializable mparentId) {
		// TODO Auto-generated method stub
		SQLQuery sqlquery=this.sessionFactory.getCurrentSession().createSQLQuery("select M.* from sys_Module M where M.M_ApplicationID="+mapplicationId+" and M.M_ParentID="+mparentId+" order by M.M_OrderLevel asc");
    	sqlquery.addEntity(SysModule.class);
    	List<SysModule> result=(List<SysModule>)sqlquery.list();
		return result;
	}
	@TriggersRemove(cacheName = "baseCache", when = When.AFTER_METHOD_INVOCATION, removeAll = true)
	public void saveOrUpdate(SysModule record) {
		// TODO Auto-generated method stub
		//this.sessionFactory.getCurrentSession().merge(record);
		this.sessionFactory.getCurrentSession().saveOrUpdate(record);
	}
	@TriggersRemove(cacheName = "baseCache", when = When.AFTER_METHOD_INVOCATION, removeAll = true)
	public void deleteByPrimaryKey(Serializable moduleId) {
		// TODO Auto-generated method stub
		System.out.println("SysModuleDaoHbnImpl:"+moduleId);
		SysModule sysModule=(SysModule)this.sessionFactory.getCurrentSession().load(SysModule.class, moduleId);
		if(sysModule!=null)
		{
			this.sessionFactory.getCurrentSession().delete(sysModule);
		}		
	}
//	public void deleteByPrimaryKey(SysModulePK comp_id) {
//		// TODO Auto-generated method stub
//		SysModule sysModule=(SysModule)this.sessionFactory.getCurrentSession().load(SysModule.class, comp_id);
//		if(sysModule!=null)
//		{
//			this.sessionFactory.getCurrentSession().delete(sysModule);
//		}		
//	}
//	public SysModule selectSysModuleByPrimaryKey(SysModulePK comp_id) {
//		// TODO Auto-generated method stub
//		return (SysModule)this.sessionFactory.getCurrentSession().load(SysModule.class, comp_id);
//	}
	
	
	
}
