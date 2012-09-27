package com.hedgehog.outletss.persistence;

import java.io.Serializable;
import java.util.List;

import com.hedgehog.outletss.Utils.QueryPara;
import com.hedgehog.outletss.domain.SysField;
import com.hedgehog.outletss.domain.SysFieldValue;


public interface SysFieldDao {
	
	//List<SysField> selectAllRecord();
	List<SysField> selectRecordForPage(QueryPara<SysField> qp);
	SysField selectByPrimaryKey(Serializable fieldId);
	void saveOrUpdate(SysField record);	
	void deleteByPrimaryKey(Serializable fieldId);
	
	List<SysFieldValue> selectFieldValueAllRecord();
	List<SysFieldValue> selectFieldValueRecordByvfKey(String vfKey);
	SysFieldValue selectFieldValueByPrimaryKey(Serializable valueId);
	void saveOrUpdateFieldValue(SysFieldValue record);	
	void deleteFieldValueByPrimaryKey(Serializable valueId);

}
