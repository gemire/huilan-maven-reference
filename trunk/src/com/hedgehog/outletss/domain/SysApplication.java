package com.hedgehog.outletss.domain;
//Generated 2012-9-16 15:45:11 by Hibernate Tools 3.2.2.GA



/**
*        @hibernate.class
*         table="sys_applications"
*     
*/
public class SysApplication  implements java.io.Serializable {


  /**
   *            @hibernate.id
*             generator-class="assigned"
*             type="java.lang.String"
*             column="ApplicationID"
*         
  */
  private String applicationId;
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

 public SysApplication() {
 }

	
 public SysApplication(String applicationId) {
     this.applicationId = applicationId;
 }
 public SysApplication(String applicationId, String aappName, String aappDescription, String aappUrl, Integer aorder) {
    this.applicationId = applicationId;
    this.aappName = aappName;
    this.aappDescription = aappDescription;
    this.aappUrl = aappUrl;
    this.aorder = aorder;
 }

 /**       
  *      *            @hibernate.id
  *             generator-class="assigned"
  *             type="java.lang.String"
  *             column="ApplicationID"
  *         
  */
 public String getApplicationId() {
     return this.applicationId;
 }
 
 public void setApplicationId(String applicationId) {
     this.applicationId = applicationId;
 }
 /**       
  *      *            @hibernate.property
  *             column="A_AppName"
  *             length="50"
  *         
  */
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
 public Integer getAorder() {
     return this.aorder;
 }
 
 public void setAorder(Integer aorder) {
     this.aorder = aorder;
 }
}


