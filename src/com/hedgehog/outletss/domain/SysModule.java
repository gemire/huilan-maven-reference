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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
//Generated 2012-9-16 15:45:11 by Hibernate Tools 3.2.2.GA
import org.hibernate.annotations.Where;




/**
 *        @hibernate.class
 *         table="sys_Module"
 *     
 */
@Entity
@Table(name="sys_Module")
@org.hibernate.annotations.Proxy(lazy = false)
public class SysModule  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;


     /**
      *            @hibernate.id
 *             generator-class="assigned"
 *             type="java.lang.String"
 *             column="ModuleID"
 *         
     */
     private Integer moduleId;
     /**
      *            @hibernate.property
 *             column="M_ApplicationID"
 *             length="40"
 *             not-null="true"
 *         
     */
     private Integer mapplicationId;
     /**
      *            @hibernate.property
 *             column="M_ParentID"
 *             length="40"
 *             not-null="true"
 *         
     */
     private Integer mparentId;
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
     
    private SysModule parentSysModule;
     
     
     
     private List<SysModule> subsysModules;
     
     private SysApplication sysApplication;

    
   
    /**       
     *      *            @hibernate.id
     *             generator-class="assigned"
     *             type="java.lang.String"
     *             column="ModuleID"
     *         
     */
  
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "ModuleID",unique=true, nullable=false)
    public Integer getModuleId() {
        return this.moduleId;
    }
    
    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }
    /**       
     *      *            @hibernate.property
     *             column="M_ApplicationID"
     *             length="40"
     *             not-null="true"
     *         
     */
    @Column(name="M_ApplicationID",nullable=false,length=10)
    public Integer getMapplicationId() {
        return this.mapplicationId;
    }
    
    public void setMapplicationId(Integer mapplicationId) {
        this.mapplicationId = mapplicationId;
    }
    /**       
     *      *            @hibernate.property
     *             column="M_ParentID"
     *             length="40"
     *             not-null="true"
     *         
     */
    @Column(name="M_ParentID",nullable=false,length=10)
    public Integer getMparentId() {
        return this.mparentId;
    }
    
    public void setMparentId(Integer mparentId) {
        this.mparentId = mparentId;
    }
    /**       
     *      *            @hibernate.property
     *             column="M_PageCode"
     *             length="6"
     *             not-null="true"
     *         
     */
    @Column(name="M_PageCode",nullable=false,length=6)
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
    @Column(name="M_CName",length=50)
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
    @Column(name="M_Directory",length=255)
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
    @Column(name="M_OrderLevel",length=4)
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
    @Column(name="M_IsSystem",length=3)
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
    @Column(name="M_Close",length=3)
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
    @Column(name="M_Icon",length=255)
    public String getMicon() {
        return this.micon;
    }
    
    public void setMicon(String micon) {
        this.micon = micon;
    }
//  //@JoinColumns({@JoinColumn(name="M_ParentID",referencedColumnName="ModuleID")})
  //@ManyToOne(cascade={CascadeType.ALL})
  //@ManyToOne(cascade={CascadeType.ALL},fetch = FetchType.LAZY)
  //@JoinColumn(name="M_ParentID",referencedColumnName="ModuleID",insertable=false,updatable=false)
  
  @ManyToOne(cascade={CascadeType.REFRESH},fetch = FetchType.LAZY)
  @JoinColumn(name="M_ParentID",insertable=false,updatable=false)
  @NotFound(action = NotFoundAction.IGNORE)  
	public SysModule getParentSysModule() {
		return parentSysModule;
	}

	public void setParentSysModule(SysModule parentSysModule) {
		this.parentSysModule = parentSysModule;
	}
  //@OneToMany(mappedBy="parentSysModule")
  //@JoinColumn(name="M_ParentID",referencedColumnName="ModuleID",insertable=false,updatable=false)
  //@OneToMany(fetch=FetchType.LAZY , cascade={CascadeType.ALL})
  
  //@JoinColumn(name="M_ParentID",insertable=false,updatable=false)
  // @Where(clause="M_Close=0")
	
  @OneToMany(mappedBy="parentSysModule",fetch=FetchType.LAZY, cascade={CascadeType.REMOVE})   
  @OrderBy("morderLevel ASC")
  public List<SysModule> getSubsysModules() {
		return subsysModules;
	}

	public void setSubsysModules(List<SysModule> subsysModules) {
		this.subsysModules = subsysModules;
	}
	//@JoinColumn(name="M_ApplicationID",insertable=false,updatable=false)
	
  @ManyToOne(fetch=FetchType.LAZY , cascade={CascadeType.REFRESH}) 
  @JoinColumn(name="M_ApplicationID",insertable=false,updatable=false)
	public SysApplication getSysApplication() {
		return sysApplication;
	}

	public void setSysApplication(SysApplication sysApplication) {
		this.sysApplication = sysApplication;
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


