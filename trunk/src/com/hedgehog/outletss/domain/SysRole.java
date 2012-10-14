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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA



/**
 *        @hibernate.class
 *         table="sys_Roles"
 *     
 */
@Entity
@Table(name="sys_Roles")
@org.hibernate.annotations.Proxy(lazy = false)
public class SysRole  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;


     /**
      *            @hibernate.id
 *             generator-class="assigned"
 *             type="java.lang.String"
 *             column="RoleID"
 *         
     */
     private Integer roleId;
     /**
      *            @hibernate.property
 *             column="R_UserID"
 *             length="40"
 *             not-null="true"
 *         
     */
     private Integer ruserId;
     /**
      *            @hibernate.property
 *             column="R_RoleName"
 *             length="50"
 *             not-null="true"
 *         
     */
     private String rroleName;
     /**
      *            @hibernate.property
 *             column="R_Description"
 *             length="255"
 *         
     */
     private String rdescription;
     /**
      *            @hibernate.property
 *             column="R_RoleCode"
 *             length="20"
 *         
     */
     private String rroleCode;

     private SysUser rsysUser;
     
     private List<SysUser> users;
   
    /**       
     *      *            @hibernate.id
     *             generator-class="assigned"
     *             type="java.lang.String"
     *             column="RoleID"
     *         
     */
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoleID",unique=true, nullable=false)
    public Integer getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    /**       
     *      *            @hibernate.property
     *             column="R_UserID"
     *             length="40"
     *             not-null="true"
     *         
     */
    @Column(name="R_UserID",length=10,nullable=false)
    public Integer getRuserId() {
        return this.ruserId;
    }
    
    public void setRuserId(Integer ruserId) {
        this.ruserId = ruserId;
    }
    /**       
     *      *            @hibernate.property
     *             column="R_RoleName"
     *             length="50"
     *             not-null="true"
     *         
     */
    @Column(name="R_RoleName",length=50,nullable=false)
    public String getRroleName() {
        return this.rroleName;
    }
    
    public void setRroleName(String rroleName) {
        this.rroleName = rroleName;
    }
    /**       
     *      *            @hibernate.property
     *             column="R_Description"
     *             length="255"
     *         
     */
    @Column(name="R_Description",length=255)
    public String getRdescription() {
        return this.rdescription;
    }
    
    public void setRdescription(String rdescription) {
        this.rdescription = rdescription;
    }
    /**       
     *      *            @hibernate.property
     *             column="R_RoleCode"
     *             length="20"
     *         
     */
    /**
     * outletss版本没有此项
     * @return
     */
    @Column(name="R_RoleCode",length=20)
    public String getRroleCode() {
        return this.rroleCode;
    }
    
    public void setRroleCode(String rroleCode) {
        this.rroleCode = rroleCode;
    }
    
    @ManyToOne(cascade={CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name="R_UserID",nullable=false,insertable=false,updatable=false)
    public SysUser getRsysUser() {
		return rsysUser;
	}

	public void setRsysUser(SysUser rsysUser) {
		this.rsysUser = rsysUser;
	}
	
    @ManyToMany(mappedBy="roles")
    public List<SysUser> getUsers() {
		return users;
	}

	public void setUsers(List<SysUser> users) {
		this.users = users;
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


