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
//Generated 2012-9-16 15:45:11 by Hibernate Tools 3.2.2.GA
import org.hibernate.annotations.Where;



/**
*        @hibernate.class
*         table="sys_Applications"
*     
*/
@Entity
@Table(name="sys_Applications")
@org.hibernate.annotations.Proxy(lazy = false)
public class SysApplication  implements java.io.Serializable {
	private static final long serialVersionUID = 1L;


  /**
   *            @hibernate.id
*             generator-class="assigned"
*             type="java.lang.String"
*             column="ApplicationID"
*         
  */
  private Integer applicationId;
  /**
   *            @hibernate.property
*             column="A_AppName"
*             length="50"
*         
  */
  private String aappName;
  /**
   *            @hibernate.property
*             column="A_AppDescription"
*             length="200"
*         
  */
  private String aappDescription;
  /**
   *            @hibernate.property
*             column="A_AppUrl"
*             length="50"
*         
  */
  private String aappUrl;
  /**
   *            @hibernate.property
*             column="A_Order"
*             length="10"
*         
  */
  private Integer aorder;
  
  private List<SysModule> childsysModules;
  //@JoinColumn(name="M_ApplicationID",insertable=false,updatable=false)
  
  @OneToMany(mappedBy="sysApplication",fetch=FetchType.LAZY , cascade={CascadeType.REMOVE})     
  @Where(clause="M_ParentID=0")
  @OrderBy("morderLevel ASC")
  public List<SysModule> getChildsysModules() {
		return childsysModules;
	}

	public void setChildsysModules(List<SysModule> childsysModules) {
		this.childsysModules = childsysModules;
	}

 

 /**       
  *      *            @hibernate.id
  *             generator-class="assigned"
  *             type="java.lang.String"
  *             column="ApplicationID"
  *         
  */

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "ApplicationID",unique=true, nullable=false)
 public Integer getApplicationId() {
     return this.applicationId;
 }
 
 public void setApplicationId(Integer applicationId) {
     this.applicationId = applicationId;
 }
 /**       
  *      *            @hibernate.property
  *             column="A_AppName"
  *             length="50"
  *         
  */
 @Column(name="A_AppName",length=50)
 public String getAappName() {
     return this.aappName;
 }
 
 public void setAappName(String aappName) {
     this.aappName = aappName;
 }
 /**       
  *      *            @hibernate.property
  *             column="A_AppDescription"
  *             length="200"
  *         
  */
 @Column(name="A_AppDescription",length=200)
 public String getAappDescription() {
     return this.aappDescription;
 }
 
 public void setAappDescription(String aappDescription) {
     this.aappDescription = aappDescription;
 }
 /**       
  *      *            @hibernate.property
  *             column="A_AppUrl"
  *             length="50"
  *         
  */
 @Column(name="A_AppUrl",length=50)
 public String getAappUrl() {
     return this.aappUrl;
 }
 
 public void setAappUrl(String aappUrl) {
     this.aappUrl = aappUrl;
 }
 /**       
  *      *            @hibernate.property
  *             column="A_Order"
  *             length="10"
  *         
  */
 @Column(name="A_Order",length=10)
 public Integer getAorder() {
     return this.aorder;
 }
 
 public void setAorder(Integer aorder) {
     this.aorder = aorder;
 }
//plumbing
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


