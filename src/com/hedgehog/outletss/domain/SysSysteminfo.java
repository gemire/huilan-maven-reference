package com.hedgehog.outletss.domain;

import static javax.persistence.GenerationType.IDENTITY;
import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA

import org.hibernate.annotations.GenericGenerator;



/**
 *        @hibernate.class
 *         table="sys_SystemInfo"
 *     
 */
@Entity
@Table(name="sys_SystemInfo")
@org.hibernate.annotations.Proxy(lazy = false)
public class SysSystemInfo  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;


     /**
      *            @hibernate.id
 *             generator-class="assigned"
 *             type="java.lang.String"
 *             column="SystemID"
 *         
     */
     private Integer systemId;
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

    
   
    /**       
     *      *            @hibernate.id
     *             generator-class="assigned"
     *             type="java.lang.String"
     *             column="SystemID"
     *         
     */
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SystemID",unique=true, nullable=false)
    public Integer getSystemId() {
        return this.systemId;
    }
    
    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }
    /**       
     *      *            @hibernate.property
     *             column="S_Name"
     *             length="50"
     *         
     */
    @Column(name="S_Name",length=50)
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
    @Column(name="S_Version",length=50)
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
    @Column(name="S_SystemConfigData",length=2147483647)
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
    @Column(name="S_Licensed",length=50)
    public String getSlicensed() {
        return this.slicensed;
    }
    
    public void setSlicensed(String slicensed) {
        this.slicensed = slicensed;
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


