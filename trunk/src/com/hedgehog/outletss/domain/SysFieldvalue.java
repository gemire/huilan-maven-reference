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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA



/**
 *        @hibernate.class
 *         table="sys_fieldvalue"
 *     
 */
@Entity
@Table(name="sys_FieldValue")
@org.hibernate.annotations.Proxy(lazy = false)
public class SysFieldValue  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;


     /**
      *            @hibernate.id
 *             generator-class="assigned"
 *             type="java.lang.String"
 *             column="ValueID"
 *         
     */
     private Integer valueId;
     /**
      *            @hibernate.property
 *             column="V_F_Key"
 *             length="50"
 *         
     */
     private String vfKey;
     /**
      *            @hibernate.property
 *             column="V_Text"
 *             length="100"
 *         
     */
     private String vtext;
     /**
      *            @hibernate.property
 *             column="V_Code"
 *             length="100"
 *         
     */
     private String vcode;
     /**
      *            @hibernate.property
 *             column="V_ShowOrder"
 *             length="10"
 *             not-null="true"
 *         
     */
     private int vshowOrder;

     private SysField sysField;
   
    /**       
     *      *            @hibernate.id
     *             generator-class="assigned"
     *             type="java.lang.String"
     *             column="ValueID"
     *         
     */
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ValueID",unique=true, nullable=false)
    public Integer getValueId() {
        return this.valueId;
    }
    
    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }
    /**       
     *      *            @hibernate.property
     *             column="V_F_Key"
     *             length="50"
     *         
     */
    @Column(name="V_F_Key",length=50)
    public String getVfKey() {
        return this.vfKey;
    }
    
    public void setVfKey(String vfKey) {
        this.vfKey = vfKey;
    }
    /**       
     *      *            @hibernate.property
     *             column="V_Text"
     *             length="100"
     *         
     */
    @Column(name="V_Text",length=100)
    public String getVtext() {
        return this.vtext;
    }
    
    public void setVtext(String vtext) {
        this.vtext = vtext;
    }
    /**       
     *      *            @hibernate.property
     *             column="V_Code"
     *             length="100"
     *         
     */
    @Column(name="V_Code",length=100)
    public String getVcode() {
        return this.vcode;
    }
    
    public void setVcode(String vcode) {
        this.vcode = vcode;
    }
    /**       
     *      *            @hibernate.property
     *             column="V_ShowOrder"
     *             length="10"
     *             not-null="true"
     *         
     */
    @Column(name="V_ShowOrder",nullable=false,length=10)
    public int getVshowOrder() {
        return this.vshowOrder;
    }
    
    public void setVshowOrder(int vshowOrder) {
        this.vshowOrder = vshowOrder;
    }
    
    @ManyToOne(fetch=FetchType.LAZY , cascade={CascadeType.REFRESH}) 
    @JoinColumn(name="V_F_Key",referencedColumnName="F_Key",insertable=false,updatable=false)
    public SysField getSysField() {
		return sysField;
	}

	public void setSysField(SysField sysField) {
		this.sysField = sysField;
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


