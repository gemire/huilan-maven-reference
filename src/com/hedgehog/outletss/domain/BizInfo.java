package com.hedgehog.outletss.domain;
//Generated 2012-9-16 15:45:11 by Hibernate Tools 3.2.2.GA


import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*        @hibernate.class
*         table="biz_info"
*     
*/
@Entity
@Table(name="biz_info")
@org.hibernate.annotations.Proxy(lazy = false)
public class BizInfo  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
  /**
   *            @hibernate.id
*             generator-class="uuid.string"
*             type="java.lang.String"
*             column="InfoID"
*         
  */
  //private Integer infoId;
  /**
   *            @hibernate.property
*             column="Info_domain"
*             length="50"
*         
  */
  //private String infoDomain;
  /**
   *            @hibernate.property
*             column="Info_key"
*             length="100"
*         
  */
  //private String infoKey;
	 /**
     *            @hibernate.id
*             generator-class="assigned"
*         
    */
    private BizInfoPK comp_id;
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
  
  //Info_des
  private String infoDes;

 

 /**       
  *      *            @hibernate.id
  *             generator-class="uuid.string"
  *             type="java.lang.String"
  *             column="InfoID"
  *         
  */
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "InfoID",unique=true, nullable=false)
// public Integer getInfoId() {
//     return this.infoId;
// }
// 
// public void setInfoId(Integer infoId) {
//     this.infoId = infoId;
// }
 /**       
  *      *            @hibernate.property
  *             column="Info_domain"
  *             length="50"
  *         
  */
// @Column(name="Info_domain",length=50)
// public String getInfoDomain() {
//     return this.infoDomain;
// }
// 
// public void setInfoDomain(String infoDomain) {
//     this.infoDomain = infoDomain;
// }
 /**       
  *      *            @hibernate.property
  *             column="Info_key"
  *             length="100"
  *         
  */
// @Column(name="Info_key",length=100)
// public String getInfoKey() {
//     return this.infoKey;
// }
// 
// public void setInfoKey(String infoKey) {
//     this.infoKey = infoKey;
// }
  /**       
   *      *            @hibernate.id
   *             generator-class="assigned"
   *         
   */
  @EmbeddedId
  public BizInfoPK getComp_id() {
      return this.comp_id;
  }
  
  public void setComp_id(BizInfoPK comp_id) {
      this.comp_id = comp_id;
  }
 /**       
  *      *            @hibernate.property
  *             column="Info_value"
  *             length="65535"
  *         
  */
 @Column(name="Info_value",length=65535)
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
 @Column(name="Info_properties",length=15)
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
 @Column(name="Info_updatetime",length=19)
 public Timestamp getInfoUpdatetime() {
     return this.infoUpdatetime;
 }
 
 public void setInfoUpdatetime(Timestamp infoUpdatetime) {
     this.infoUpdatetime = infoUpdatetime;
 }
 
 @Column(name="Info_des",length=100)
public String getInfoDes() {
	return infoDes;
}

public void setInfoDes(String infoDes) {
	this.infoDes = infoDes;
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

