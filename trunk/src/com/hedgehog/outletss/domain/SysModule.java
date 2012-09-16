package com.hedgehog.outletss.domain;
// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA



/**
 *        @hibernate.class
 *         table="sys_module"
 *     
 */
public class SysModule  implements java.io.Serializable {


     /**
      *            @hibernate.id
 *             generator-class="assigned"
 *             type="java.lang.String"
 *             column="ModuleID"
 *         
     */
     private String moduleId;
     /**
      *            @hibernate.property
 *             column="M_ApplicationID"
 *             length="40"
 *             not-null="true"
 *         
     */
     private String mapplicationId;
     /**
      *            @hibernate.property
 *             column="M_ParentID"
 *             length="40"
 *             not-null="true"
 *         
     */
     private String mparentId;
     /**
      *            @hibernate.property
 *             column="M_PageCode"
 *             length="6"
 *             not-null="true"
 *         
     */
     private String mpageCode;
     /**
      *            @hibernate.property
 *             column="M_CName"
 *             length="50"
 *         
     */
     private String mcname;
     /**
      *            @hibernate.property
 *             column="M_Directory"
 *             length="255"
 *         
     */
     private String mdirectory;
     /**
      *            @hibernate.property
 *             column="M_OrderLevel"
 *             length="4"
 *         
     */
     private String morderLevel;
     /**
      *            @hibernate.property
 *             column="M_IsSystem"
 *             length="3"
 *         
     */
     private Byte misSystem;
     /**
      *            @hibernate.property
 *             column="M_Close"
 *             length="3"
 *         
     */
     private Byte mclose;
     /**
      *            @hibernate.property
 *             column="M_Icon"
 *             length="255"
 *         
     */
     private String micon;

    public SysModule() {
    }

	
    public SysModule(String moduleId, String mapplicationId, String mparentId, String mpageCode) {
        this.moduleId = moduleId;
        this.mapplicationId = mapplicationId;
        this.mparentId = mparentId;
        this.mpageCode = mpageCode;
    }
    public SysModule(String moduleId, String mapplicationId, String mparentId, String mpageCode, String mcname, String mdirectory, String morderLevel, Byte misSystem, Byte mclose, String micon) {
       this.moduleId = moduleId;
       this.mapplicationId = mapplicationId;
       this.mparentId = mparentId;
       this.mpageCode = mpageCode;
       this.mcname = mcname;
       this.mdirectory = mdirectory;
       this.morderLevel = morderLevel;
       this.misSystem = misSystem;
       this.mclose = mclose;
       this.micon = micon;
    }
   
    /**       
     *      *            @hibernate.id
     *             generator-class="assigned"
     *             type="java.lang.String"
     *             column="ModuleID"
     *         
     */
    public String getModuleId() {
        return this.moduleId;
    }
    
    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }
    /**       
     *      *            @hibernate.property
     *             column="M_ApplicationID"
     *             length="40"
     *             not-null="true"
     *         
     */
    public String getMapplicationId() {
        return this.mapplicationId;
    }
    
    public void setMapplicationId(String mapplicationId) {
        this.mapplicationId = mapplicationId;
    }
    /**       
     *      *            @hibernate.property
     *             column="M_ParentID"
     *             length="40"
     *             not-null="true"
     *         
     */
    public String getMparentId() {
        return this.mparentId;
    }
    
    public void setMparentId(String mparentId) {
        this.mparentId = mparentId;
    }
    /**       
     *      *            @hibernate.property
     *             column="M_PageCode"
     *             length="6"
     *             not-null="true"
     *         
     */
    public String getMpageCode() {
        return this.mpageCode;
    }
    
    public void setMpageCode(String mpageCode) {
        this.mpageCode = mpageCode;
    }
    /**       
     *      *            @hibernate.property
     *             column="M_CName"
     *             length="50"
     *         
     */
    public String getMcname() {
        return this.mcname;
    }
    
    public void setMcname(String mcname) {
        this.mcname = mcname;
    }
    /**       
     *      *            @hibernate.property
     *             column="M_Directory"
     *             length="255"
     *         
     */
    public String getMdirectory() {
        return this.mdirectory;
    }
    
    public void setMdirectory(String mdirectory) {
        this.mdirectory = mdirectory;
    }
    /**       
     *      *            @hibernate.property
     *             column="M_OrderLevel"
     *             length="4"
     *         
     */
    public String getMorderLevel() {
        return this.morderLevel;
    }
    
    public void setMorderLevel(String morderLevel) {
        this.morderLevel = morderLevel;
    }
    /**       
     *      *            @hibernate.property
     *             column="M_IsSystem"
     *             length="3"
     *         
     */
    public Byte getMisSystem() {
        return this.misSystem;
    }
    
    public void setMisSystem(Byte misSystem) {
        this.misSystem = misSystem;
    }
    /**       
     *      *            @hibernate.property
     *             column="M_Close"
     *             length="3"
     *         
     */
    public Byte getMclose() {
        return this.mclose;
    }
    
    public void setMclose(Byte mclose) {
        this.mclose = mclose;
    }
    /**       
     *      *            @hibernate.property
     *             column="M_Icon"
     *             length="255"
     *         
     */
    public String getMicon() {
        return this.micon;
    }
    
    public void setMicon(String micon) {
        this.micon = micon;
    }




}


