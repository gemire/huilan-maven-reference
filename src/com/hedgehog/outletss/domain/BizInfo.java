package com.hedgehog.outletss.domain;
//Generated 2012-9-16 15:45:11 by Hibernate Tools 3.2.2.GA


import java.sql.Timestamp;

/**
*        @hibernate.class
*         table="biz_info"
*     
*/
public class BizInfo  implements java.io.Serializable {


  /**
   *            @hibernate.id
*             generator-class="uuid.string"
*             type="java.lang.String"
*             column="InfoID"
*         
  */
  private String infoId;
  /**
   *            @hibernate.property
*             column="Info_domain"
*             length="50"
*         
  */
  private String infoDomain;
  /**
   *            @hibernate.property
*             column="Info_key"
*             length="100"
*         
  */
  private String infoKey;
  /**
   *            @hibernate.property
*             column="Info_value"
*             length="65535"
*         
  */
  private String infoValue;
  /**
   *            @hibernate.property
*             column="Info_properties"
*             length="15"
*         
  */
  private String infoProperties;
  /**
   *            @hibernate.property
*             column="Info_updatetime"
*             length="19"
*         
  */
  private Timestamp infoUpdatetime;

 public BizInfo() {
 }

 public BizInfo(String infoDomain, String infoKey, String infoValue, String infoProperties, Timestamp infoUpdatetime) {
    this.infoDomain = infoDomain;
    this.infoKey = infoKey;
    this.infoValue = infoValue;
    this.infoProperties = infoProperties;
    this.infoUpdatetime = infoUpdatetime;
 }

 /**       
  *      *            @hibernate.id
  *             generator-class="uuid.string"
  *             type="java.lang.String"
  *             column="InfoID"
  *         
  */
 public String getInfoId() {
     return this.infoId;
 }
 
 public void setInfoId(String infoId) {
     this.infoId = infoId;
 }
 /**       
  *      *            @hibernate.property
  *             column="Info_domain"
  *             length="50"
  *         
  */
 public String getInfoDomain() {
     return this.infoDomain;
 }
 
 public void setInfoDomain(String infoDomain) {
     this.infoDomain = infoDomain;
 }
 /**       
  *      *            @hibernate.property
  *             column="Info_key"
  *             length="100"
  *         
  */
 public String getInfoKey() {
     return this.infoKey;
 }
 
 public void setInfoKey(String infoKey) {
     this.infoKey = infoKey;
 }
 /**       
  *      *            @hibernate.property
  *             column="Info_value"
  *             length="65535"
  *         
  */
 public String getInfoValue() {
     return this.infoValue;
 }
 
 public void setInfoValue(String infoValue) {
     this.infoValue = infoValue;
 }
 /**       
  *      *            @hibernate.property
  *             column="Info_properties"
  *             length="15"
  *         
  */
 public String getInfoProperties() {
     return this.infoProperties;
 }
 
 public void setInfoProperties(String infoProperties) {
     this.infoProperties = infoProperties;
 }
 /**       
  *      *            @hibernate.property
  *             column="Info_updatetime"
  *             length="19"
  *         
  */
 public Timestamp getInfoUpdatetime() {
     return this.infoUpdatetime;
 }
 
 public void setInfoUpdatetime(Timestamp infoUpdatetime) {
     this.infoUpdatetime = infoUpdatetime;
 }




}

