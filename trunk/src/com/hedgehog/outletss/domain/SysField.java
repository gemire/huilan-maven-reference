package com.hedgehog.outletss.domain;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;


// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA



/**
 *        @hibernate.class
 *         table="sys_field"
 *     
 */
@Entity
@Table(name="sys_Field")
@org.hibernate.annotations.Proxy(lazy = false)
public class SysField  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;


     /**
      *            @hibernate.id
 *             generator-class="assigned"
 *             type="java.lang.String"
 *             column="FieldID"
 *         
     */
     private Integer fieldId;
     /**
      *            @hibernate.property
 *             column="F_Key"
 *             length="50"
 *         
     */
     private String fkey;
     /**
      *            @hibernate.property
 *             column="F_CName"
 *             length="50"
 *         
     */
     private String fcname;
     /**
      *            @hibernate.property
 *             column="F_Remark"
 *             length="200"
 *         
     */
     private String fremark;

     private List<SysFieldValue> sysFieldValues;
   
    /**       
     *      *            @hibernate.id
     *             generator-class="assigned"
     *             type="java.lang.String"
     *             column="FieldID"
     *         
     */
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FieldID",unique=true, nullable=false)
    public Integer getFieldId() {
        return this.fieldId;
    }
    
    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }
    /**       
     *      *            @hibernate.property
     *             column="F_Key"
     *             length="50"
     *         
     */
    @Column(name="F_Key",length=50)
    public String getFkey() {
        return this.fkey;
    }
    
    public void setFkey(String fkey) {
        this.fkey = fkey;
    }
    /**       
     *      *            @hibernate.property
     *             column="F_CName"
     *             length="50"
     *         
     */
    @Column(name="F_CName",length=50)
    public String getFcname() {
        return this.fcname;
    }
    
    public void setFcname(String fcname) {
        this.fcname = fcname;
    }
    /**       
     *      *            @hibernate.property
     *             column="F_Remark"
     *             length="200"
     *         
     */
    @Column(name="F_Remark",length=200)
    public String getFremark() {
        return this.fremark;
    }
    
    public void setFremark(String fremark) {
        this.fremark = fremark;
    }
    
    //@OrderBy("vshowOrder ASC") domain属性
    
    @OneToMany(mappedBy="sysField",fetch=FetchType.LAZY, cascade={CascadeType.REMOVE})   
    @OrderBy("vshowOrder ASC")
    public List<SysFieldValue> getSysFieldValues() {
		return sysFieldValues;
	}

	public void setSysFieldValues(List<SysFieldValue> sysFieldValues) {
		this.sysFieldValues = sysFieldValues;
	}

	// plumbing
    @Override
    public boolean equals(Object obj) {
      return reflectionEquals(this, obj);
    }
    
    @Override
    public int hashCode() {
      return reflectionHashCode(this);
    }
    
    @Override
    public String toString() {
      return reflectionToString(this);
    }



}


