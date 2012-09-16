package com.hedgehog.outletss.domain;
// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA


import java.sql.Timestamp;

/**
 *        @hibernate.class
 *         table="sys_event"
 *     
 */
public class SysEvent  implements java.io.Serializable {


     /**
      *            @hibernate.id
 *             generator-class="assigned"
 *             type="java.lang.String"
 *             column="EventID"
 *         
     */
     private String eventId;
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
     private String euserId;
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
     private String eapplicationId;
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

    public SysEvent() {
    }

	
    public SysEvent(String eventId, Timestamp edateTime, byte etype) {
        this.eventId = eventId;
        this.edateTime = edateTime;
        this.etype = etype;
    }
    public SysEvent(String eventId, String euLoginName, String euserId, Timestamp edateTime, String eapplicationId, String eaAppName, String emName, String emPageCode, String efrom, byte etype, String eip, String erecord) {
       this.eventId = eventId;
       this.euLoginName = euLoginName;
       this.euserId = euserId;
       this.edateTime = edateTime;
       this.eapplicationId = eapplicationId;
       this.eaAppName = eaAppName;
       this.emName = emName;
       this.emPageCode = emPageCode;
       this.efrom = efrom;
       this.etype = etype;
       this.eip = eip;
       this.erecord = erecord;
    }
   
    /**       
     *      *            @hibernate.id
     *             generator-class="assigned"
     *             type="java.lang.String"
     *             column="EventID"
     *         
     */
    public String getEventId() {
        return this.eventId;
    }
    
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
    /**       
     *      *            @hibernate.property
     *             column="E_U_LoginName"
     *             length="20"
     *         
     */
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
    public String getEuserId() {
        return this.euserId;
    }
    
    public void setEuserId(String euserId) {
        this.euserId = euserId;
    }
    /**       
     *      *            @hibernate.property
     *             column="E_DateTime"
     *             length="19"
     *             not-null="true"
     *         
     */
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
    public String getEapplicationId() {
        return this.eapplicationId;
    }
    
    public void setEapplicationId(String eapplicationId) {
        this.eapplicationId = eapplicationId;
    }
    /**       
     *      *            @hibernate.property
     *             column="E_A_AppName"
     *             length="50"
     *         
     */
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
    public String getEfrom() {
        return this.efrom;
    }
    
    public void setEfrom(String efrom) {
        this.efrom = efrom;
    }
    /**       
     *      *            @hibernate.property
     *             column="E_Type"
     *             length="3"
     *             not-null="true"
     *         
     */
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
    public String getErecord() {
        return this.erecord;
    }
    
    public void setErecord(String erecord) {
        this.erecord = erecord;
    }




}


