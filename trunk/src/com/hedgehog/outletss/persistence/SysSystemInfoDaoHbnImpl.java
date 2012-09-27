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
import com.hedgehog.outletss.domain.SysSystemInfo;


@Repository("systemInfoDao")
public class SysSystemInfoDaoHbnImpl implements SysSystemInfoDao{
	private static final Log log = LogFactory.getLog(SysSystemInfoDao.class);
	private SessionFactory sessionFactory;
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	
    @TriggersRemove(cacheName = "baseCache", when = When.AFTER_METHOD_INVOCATION, removeAll = true)
	public void saveOrUpdate(SysSystemInfo record) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().saveOrUpdate(record);
	}
	@Cacheable(cacheName = "baseCache")
	public SysSystemInfo selectByPrimaryKey(Serializable systemid) {
		// TODO Auto-generated method stub
		return (SysSystemInfo)this.sessionFactory.getCurrentSession().load(SysSystemInfo.class, systemid);
	}
	@SuppressWarnings("unchecked")
	@Cacheable(cacheName = "baseCache")
	public List<SysSystemInfo> getListForPage(QueryPara<SysSystemInfo> qp) {
		// TODO Auto-generated method stub
		//System.out.println("ִ�з�����");
		List<SysSystemInfo> result=null;
		try
		 {
			//System.out.println("ִ�з���");
			 Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(qp.getClazz());
			 List<Criterion> list=qp.getCriterions();
			 if (list != null)   
		        {  
				 //System.out.println("��������");
					 if(list.size()>0)
					 {
						 //Set<String> keys = map.keySet();   
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
		        //System.out.println("�ܼ�¼��"+rowCount);
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
		        	//System.out.println("��������");
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
		        result = (List<SysSystemInfo>)criteria.list();					 
			 
		 }
		 catch (RuntimeException re)   
		    {   
			 log.error(re.getMessage());
		    }				 
		 return result;
	}
	@Cacheable(cacheName = "baseCache")
	public SysSystemInfo getUniqueResult() {
		// TODO Auto-generated method stub
		SQLQuery sqlquery=this.sessionFactory.getCurrentSession().createSQLQuery("select * from sys_SystemInfo");
		//sqlquery.setParameter("uloginName", username);
		sqlquery.addEntity(SysSystemInfo.class);	
		sqlquery.setMaxResults(1);
		return (SysSystemInfo)sqlquery.uniqueResult();
	}

}
