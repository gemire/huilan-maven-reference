package com.hedgehog.outletss.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.TriggersRemove;
import com.googlecode.ehcache.annotations.When;
import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.SysModule;
import com.hedgehog.outletss.persistence.SysModuleDao;

@Service("sysModuleService")
@Transactional(propagation=Propagation.REQUIRED)
public class SysModuleServiceImpl implements SysModuleService{
	
	private SysModuleDao sysModuleDao;
	@Autowired
	public void setModuleDao(SysModuleDao moduleDao) {
		this.sysModuleDao = moduleDao;
	}
	
	public List<SysModule> selectParentModules() {
		// TODO Auto-generated method stub
//		QueryPara<SysModule> qp=new QueryPara<SysModule>();
//		qp.setClazz(SysModule.class);
//		//qp.setPagesize(perPage);
//		List<Criterion> criterions=new ArrayList<Criterion>();
//		//Restrictions.like("newsTitle","����",MatchMode.ANYWHERE );
//		//Expression
//		//criterions.add(Restrictions.like("M_ParentID","0",MatchMode.ANYWHERE ));
//		//criterions.add(Restrictions.eq("comp_id.mapplicationId", new Integer(0)));
//		//criterions.add(Restrictions.isNull("parentSysModule"));
//		criterions.add(Restrictions.eq("mparentId", new Integer(0)));
//		qp.setCriterions(criterions);
//		List<Order> orders=new ArrayList<Order>();		
//		orders.add(Order.desc("morderLevel"));	//������	
//		qp.setOrders(orders);
//		//int pageNo =ServletRequestUtils.getIntParameter(request, "pageNo", 1);
//		//qp.setPageNo(page);
//		return this.moduleDao.selectParentModules(qp);
		return this.sysModuleDao.selectParentModules();
		
	}
	
	public SysModule selectSysModuleByPrimaryKey(Serializable moduleId) {
		// TODO Auto-generated method stub
		return this.sysModuleDao.selectSysModuleByPrimaryKey(moduleId);
	}
	
	public List<SysModule> selectSubModulesByParentId(Serializable mapplicationId,
			Serializable mparentId) {
		// TODO Auto-generated method stub
		return this.sysModuleDao.selectSubModulesByParentId(mapplicationId, mparentId);
	}
	
	public void saveOrUpdate(SysModule record) {
		// TODO Auto-generated method stub
		this.sysModuleDao.saveOrUpdate(record);
	}
	
	public void deleteByPrimaryKey(Serializable moduleId) {
		// TODO Auto-generated method stub
		this.sysModuleDao.deleteByPrimaryKey(moduleId);
	}
//	public void deleteByPrimaryKey(SysModulePK comp_id) {
//		// TODO Auto-generated method stub
//		this.sysModuleDao.deleteByPrimaryKey(comp_id);
//	}
//
//	public SysModule selectSysModuleByPrimaryKey(SysModulePK comp_id) {
//		// TODO Auto-generated method stub
//		return this.sysModuleDao.selectSysModuleByPrimaryKey(comp_id);
//	}	
}
