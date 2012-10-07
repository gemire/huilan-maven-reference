package com.hedgehog.outletss.domain;
// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA


import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *        @hibernate.class
 *         table="sys_Event"
 *     
 */
@Entity
@Table(name="sys_event")
@org.hibernate.annotations.Proxy(lazy = false)
public class SysEvent  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
      *            @hibernate.id
 *             generator-class="assigned"
 *             type="java.lang.String"
 *             column="EventID"
 *         
     */
     private Integer eventId;
     /**
      *            @hibernate.property
 *             column="E_U_LoginName"
 *             length="20"
 *         
     */
     private String euLoginName;
     /**
      *            @hibernate.property
 *             column="E_UserID"
 *             length="40"
 *         
     */
     private Integer euserId;
     /**
      *            @hibernate.property
 *             column="E_DateTime"
 *             length="19"
 *             not-null="true"
 *         
     */
     private Timestamp edateTime;
     /**
      *            @hibernate.property
 *             column="E_ApplicationID"
 *             length="40"
 *         
     */
     private Integer eapplicationId;
     /**
      *            @hibernate.property
 *             column="E_A_AppName"
 *             length="50"
 *         
     */
     private String eaAppName;
     /**
      *            @hibernate.property
 *             column="E_M_Name"
 *             length="50"
 *         
     */
     private String emName;
     /**
      *            @hibernate.property
 *             column="E_M_PageCode"
 *             length="6"
 *         
     */
     private String emPageCode;
     /**
      *            @hibernate.property
 *             column="E_From"
 *             length="500"
 *         
     */
     private String efrom;
     /**
      *            @hibernate.property
 *             column="E_Type"
 *             length="3"
 *             not-null="true"
 *         
     */
     private byte etype;
     /**
      *            @hibernate.property
 *             column="E_IP"
 *             length="15"
 *         
     */
     private String eip;
     /**
      *            @hibernate.property
 *             column="E_Record"
 *             length="500"
 *         
     */
     private String erecord;

    
	
    
   
    /**       
     *      *            @hibernate.id
     *             generator-class="assigned"
     *             type="java.lang.String"
     *             column="EventID"
     *         
     */
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "EventID",unique=true, nullable=false)
    public Integer getEventId() {
        return this.eventId;
    }
    
    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }
    /**       
     *      *            @hibernate.property
     *             column="E_U_LoginName"
     *             length="20"
     *         
     */
    @Column(name="E_U_LoginName",length=20)
    public String getEuLoginName() {
        return this.euLoginName;
    }
    
    public void setEuLoginName(String euLoginName) {
        this.euLoginName = euLoginName;
    }
    /**       
     *      *            @hibernate.property
     *             column="E_UserID"
     *             length="40"
     *         
     */
    @Column(name="E_UserID",length=10)
    public Integer getEuserId() {
        return this.euserId;
    }
    
    public void setEuserId(Integer euserId) {
        this.euserId = euserId;
    }
    /**       
     *      *            @hibernate.property
     *             column="E_DateTime"
     *             length="19"
     *             not-null="true"
     *         
     */
    @Column(name="E_DateTime",length=19)
    public Timestamp getEdateTime() {
        return this.edateTime;
    }
    
    public void setEdateTime(Timestamp edateTime) {
        this.edateTime = edateTime;
    }
    /**       
     *      *            @hibernate.property
     *             column="E_ApplicationID"
     *             length="40"
     *         
     */
    @Column(name="E_ApplicationID",length=10)
    public Integer getEapplicationId() {
        return this.eapplicationId;
    }
    
    public void setEapplicationId(Integer eapplicationId) {
        this.eapplicationId = eapplicationId;
    }
    /**       
     *      *            @hibernate.property
     *             column="E_A_AppName"
     *             length="50"
     *         
     */
    @Column(name="E_A_AppName",length=50)
    public String getEaAppName() {
        return this.eaAppName;
    }
    
    public void setEaAppName(String eaAppName) {
        this.eaAppName = eaAppName;
    }
    /**       
     *      *            @hibernate.property
     *             column="E_M_Name"
     *             length="50"
     *         
     */
    @Column(name="E_M_Name",length=50)
    public String getEmName() {
        return this.emName;
    }
    
    public void setEmName(String emName) {
        this.emName = emName;
    }
    /**       
     *      *            @hibernate.property
     *             column="E_M_PageCode"
     *             length="6"
     *         
     */
    @Column(name="E_M_PageCode",length=6)
    public String getEmPageCode() {
        return this.emPageCode;
    }
    
    public void setEmPageCode(String emPageCode) {
        this.emPageCode = emPageCode;
    }
    /**       
     *      *            @hibernate.property
     *             column="E_From"
     *             length="500"
     *         
     */
    @Column(name="E_From",length=500)
    public String getEfrom() {
        return this.efrom;
    }
    
    public void setEfrom(String efrom) {
        this.efrom = efrom;
    }
    /**       
     *      *           日志类型：日记类型,1:操作日记2:安全日志 @hibernate.property
     *             column="E_Type"
     *             length="3"
     *             not-null="true"
     *         
     */
    @Column(name="E_Type",length=3,nullable=false)
    public byte getEtype() {
        return this.etype;
    }
    
    public void setEtype(byte etype) {
        this.etype = etype;
    }
    /**       
     *      *            @hibernate.property
     *             column="E_IP"
     *             length="15"
     *         
     */
    @Column(name="E_IP",length=15)
    public String getEip() {
        return this.eip;
    }
    
    public void setEip(String eip) {
        this.eip = eip;
    }
    /**       
     *      *            @hibernate.property
     *             column="E_Record"
     *             length="500"
     *         
     */
    @Column(name="E_Record",length=500)
    public String getErecord() {
        return this.erecord;
    }
    
    public void setErecord(String erecord) {
        this.erecord = erecord;
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


