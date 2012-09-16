package com.hedgehog.outletss.domain;
// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA


import java.sql.Timestamp;

/**
 *        @hibernate.class
 *         table="sys_online"
 *     
 */
public class SysOnline  implements java.io.Serializable {


     /**
      *            @hibernate.id
 *             generator-class="assigned"
 *             type="java.lang.String"
 *             column="O_SessionID"
 *         
     */
     private String osessionId;
     /**
      *            @hibernate.property
 *             column="OnlineID"
 *             length="40"
 *             not-null="true"
 *         
     */
     private String onlineId;
     /**
      *            @hibernate.property
 *             column="O_UserName"
 *             length="20"
 *             not-null="true"
 *         
     */
     private String ouserName;
     /**
      *            @hibernate.property
 *             column="O_Ip"
 *             length="15"
 *             not-null="true"
 *         
     */
     private String oip;
     /**
      *            @hibernate.property
 *             column="O_LoginTime"
 *             length="19"
 *             not-null="true"
 *         
     */
     private Timestamp ologinTime;
     /**
      *            @hibernate.property
 *             column="O_LastTime"
 *             length="19"
 *             not-null="true"
 *         
     */
     private Timestamp olastTime;
     /**
      *            @hibernate.property
 *             column="O_LastUrl"
 *             length="500"
 *             not-null="true"
 *         
     */
     private String olastUrl;

    public SysOnline() {
    }

    public SysOnline(String osessionId, String onlineId, String ouserName, String oip, Timestamp ologinTime, Timestamp olastTime, String olastUrl) {
       this.osessionId = osessionId;
       this.onlineId = onlineId;
       this.ouserName = ouserName;
       this.oip = oip;
       this.ologinTime = ologinTime;
       this.olastTime = olastTime;
       this.olastUrl = olastUrl;
    }
   
    /**       
     *      *            @hibernate.id
     *             generator-class="assigned"
     *             type="java.lang.String"
     *             column="O_SessionID"
     *         
     */
    public String getOsessionId() {
        return this.osessionId;
    }
    
    public void setOsessionId(String osessionId) {
        this.osessionId = osessionId;
    }
    /**       
     *      *            @hibernate.property
     *             column="OnlineID"
     *             length="40"
     *             not-null="true"
     *         
     */
    public String getOnlineId() {
        return this.onlineId;
    }
    
    public void setOnlineId(String onlineId) {
        this.onlineId = onlineId;
    }
    /**       
     *      *            @hibernate.property
     *             column="O_UserName"
     *             length="20"
     *             not-null="true"
     *         
     */
    public String getOuserName() {
        return this.ouserName;
    }
    
    public void setOuserName(String ouserName) {
        this.ouserName = ouserName;
    }
    /**       
     *      *            @hibernate.property
     *             column="O_Ip"
     *             length="15"
     *             not-null="true"
     *         
     */
    public String getOip() {
        return this.oip;
    }
    
    public void setOip(String oip) {
        this.oip = oip;
    }
    /**       
     *      *            @hibernate.property
     *             column="O_LoginTime"
     *             length="19"
     *             not-null="true"
     *         
     */
    public Timestamp getOloginTime() {
        return this.ologinTime;
    }
    
    public void setOloginTime(Timestamp ologinTime) {
        this.ologinTime = ologinTime;
    }
    /**       
     *      *            @hibernate.property
     *             column="O_LastTime"
     *             length="19"
     *             not-null="true"
     *         
     */
    public Timestamp getOlastTime() {
        return this.olastTime;
    }
    
    public void setOlastTime(Timestamp olastTime) {
        this.olastTime = olastTime;
    }
    /**       
     *      *            @hibernate.property
     *             column="O_LastUrl"
     *             length="500"
     *             not-null="true"
     *         
     */
    public String getOlastUrl() {
        return this.olastUrl;
    }
    
    public void setOlastUrl(String olastUrl) {
        this.olastUrl = olastUrl;
    }




}


