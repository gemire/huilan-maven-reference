package com.hedgehog.outletss.domain;
// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA



/**
 *        @hibernate.class
 *         table="sys_systeminfo"
 *     
 */
public class SysSysteminfo  implements java.io.Serializable {


     /**
      *            @hibernate.id
 *             generator-class="assigned"
 *             type="java.lang.String"
 *             column="SystemID"
 *         
     */
     private String systemId;
     /**
      *            @hibernate.property
 *             column="S_Name"
 *             length="50"
 *         
     */
     private String sname;
     /**
      *            @hibernate.property
 *             column="S_Version"
 *             length="50"
 *         
     */
     private String sversion;
     /**
      *            @hibernate.property
 *             column="S_SystemConfigData"
 *             length="2147483647"
 *         
     */
     private byte[] ssystemConfigData;
     /**
      *            @hibernate.property
 *             column="S_Licensed"
 *             length="50"
 *         
     */
     private String slicensed;

    public SysSysteminfo() {
    }

	
    public SysSysteminfo(String systemId) {
        this.systemId = systemId;
    }
    public SysSysteminfo(String systemId, String sname, String sversion, byte[] ssystemConfigData, String slicensed) {
       this.systemId = systemId;
       this.sname = sname;
       this.sversion = sversion;
       this.ssystemConfigData = ssystemConfigData;
       this.slicensed = slicensed;
    }
   
    /**       
     *      *            @hibernate.id
     *             generator-class="assigned"
     *             type="java.lang.String"
     *             column="SystemID"
     *         
     */
    public String getSystemId() {
        return this.systemId;
    }
    
    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }
    /**       
     *      *            @hibernate.property
     *             column="S_Name"
     *             length="50"
     *         
     */
    public String getSname() {
        return this.sname;
    }
    
    public void setSname(String sname) {
        this.sname = sname;
    }
    /**       
     *      *            @hibernate.property
     *             column="S_Version"
     *             length="50"
     *         
     */
    public String getSversion() {
        return this.sversion;
    }
    
    public void setSversion(String sversion) {
        this.sversion = sversion;
    }
    /**       
     *      *            @hibernate.property
     *             column="S_SystemConfigData"
     *             length="2147483647"
     *         
     */
    public byte[] getSsystemConfigData() {
        return this.ssystemConfigData;
    }
    
    public void setSsystemConfigData(byte[] ssystemConfigData) {
        this.ssystemConfigData = ssystemConfigData;
    }
    /**       
     *      *            @hibernate.property
     *             column="S_Licensed"
     *             length="50"
     *         
     */
    public String getSlicensed() {
        return this.slicensed;
    }
    
    public void setSlicensed(String slicensed) {
        this.slicensed = slicensed;
    }




}


