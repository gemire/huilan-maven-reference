package com.hedgehog.outletss.domain;

import java.util.List;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA





/**
 *        @hibernate.class
 *         table="sys_RolePermission"
 *     
 */
@Entity
@Table(name="sys_RolePermission")
@org.hibernate.annotations.Proxy(lazy = false)
public class SysRolePermission  implements java.io.Serializable {
	private static final long serialVersionUID = 1L;


     /**
      *            @hibernate.id
 *             generator-class="assigned"
 *         
     */
     //private SysRolepermissionPK comp_id;
     /**
      *            @hibernate.property
 *             column="PermissionID"
 *             length="40"
 *             not-null="true"
 *         
     */
     private Integer permissionId;
     /**
      *                @hibernate.property
 *                 column="P_RoleID"
 *                 length="10"
 *             
     */
	
     private Integer proleId;
     /**
      *                @hibernate.property
 *                 column="P_ApplicationID"
 *                 length="10"
 *             
     */
     private Integer papplicationId;
     /**
      *                @hibernate.property
 *                 column="P_PageCode"
 *                 length="20"
 *             
     */
     private String ppageCode;
     /**
      *            @hibernate.property
 *             column="P_Value"
 *             length="10"
 *         
     */
     private Integer pvalue;

     private List<Integer>  arraystr;
   
    
    /**       
     *      *            @hibernate.property
     *             column="PermissionID"
     *             length="40"
     *             not-null="true"
     *         
     */
     
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "PermissionID",unique=true, nullable=false)
    public Integer getPermissionId() {
        return this.permissionId;
    }
    
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
    /**       
     *      *                @hibernate.property
     *                 column=""
     *                 length="10"
     *             
     */
    @Column(name="P_RoleID",nullable=false)
    public Integer getProleId() {
        return this.proleId;
    }
    
    public void setProleId(Integer proleId) {
        this.proleId = proleId;
    }
    /**       
     *      *                @hibernate.property
     *                 column="P_ApplicationID"
     *                 length="10"
     *             
     */
    @Column(name="P_ApplicationID",nullable=false)
    public Integer getPapplicationId() {
        return this.papplicationId;
    }
    
    public void setPapplicationId(Integer papplicationId) {
        this.papplicationId = papplicationId;
    }
    /**       
     *      *                @hibernate.property
     *                 column="P_PageCode"
     *                 length="20"
     *             
     */
    @Column(name="P_PageCode",length=20,nullable=false)
    public String getPpageCode() {
        return this.ppageCode;
    }
    
    public void setPpageCode(String ppageCode) {
        this.ppageCode = ppageCode;
    }
    /**       
     *      *            @hibernate.property
     *             column="P_Value"
     *             length="10"
     *         
     */
    @Column(name="P_Value",length=10)
    public Integer getPvalue() {
        return this.pvalue;
    }
    
    public void setPvalue(Integer pvalue) {
        this.pvalue = pvalue;
    }
    @Transient    
    public List<Integer> getArraystr() {
		return arraystr;
	}

	public void setArraystr(List<Integer> arraystr) {
		this.arraystr = arraystr;
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


