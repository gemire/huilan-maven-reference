package com.hedgehog.outletss.Utils;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

public class QueryPara<T>{
	
	private String HQL;

	/**
	 * @return
	 */
	public String getHQL() {
		return HQL;
	}

	/**
	 * @param hql
	 */
	public void setHQL(String hql) {
		HQL = hql;
	}
	private int pagesize=Integer.MAX_VALUE;;
	private int pageNo=1;
	private Class<T> Clazz;
	private List<Criterion> criterions;
	private List<Order> orders;
	private int recordcount;
	private int pagecount;

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public Class<T> getClazz() {
		return Clazz;
	}

	public void setClazz(Class<T> clazz) {
		Clazz = clazz;
	}

	public List<Criterion> getCriterions() {
		return criterions;
	}

	public void setCriterions(List<Criterion> criterions) {
		this.criterions = criterions;
	}

	
	public int getRecordcount() {
		return recordcount;
	}

	/**
	 * @param recordcount
	 */
	public void setRecordcount(int recordcount) {
		this.recordcount = recordcount;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public int getPagecount() {
		return pagecount;
	}

	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
}
