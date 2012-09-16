package com.hedgehog.outletss.domain;
// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA



/**
 *        @hibernate.class
 *         table="sys_roles"
 *     
 */
public class SysRole  implements java.io.Serializable {


     /**
      *            @hibernate.id
 *             generator-class="assigned"
 *             type="java.lang.String"
 *             column="RoleID"
 *         
     */
     private String roleId;
     /**
      *            @hibernate.property
 *             column="R_UserID"
 *             length="40"
 *             not-null="true"
 *         
     */
     private String ruserId;
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

    public SysRole() {
    }

	
    public SysRole(String roleId, String ruserId, String rroleName) {
        this.roleId = roleId;
        this.ruserId = ruserId;
        this.rroleName = rroleName;
    }
    public SysRole(String roleId, String ruserId, String rroleName, String rdescription, String rroleCode) {
       this.roleId = roleId;
       this.ruserId = ruserId;
       this.rroleName = rroleName;
       this.rdescription = rdescription;
       this.rroleCode = rroleCode;
    }
   
    /**       
     *      *            @hibernate.id
     *             generator-class="assigned"
     *             type="java.lang.String"
     *             column="RoleID"
     *         
     */
    public String getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    /**       
     *      *            @hibernate.property
     *             column="R_UserID"
     *             length="40"
     *             not-null="true"
     *         
     */
    public String getRuserId() {
        return this.ruserId;
    }
    
    public void setRuserId(String ruserId) {
        this.ruserId = ruserId;
    }
    /**       
     *      *            @hibernate.property
     *             column="R_RoleName"
     *             length="50"
     *             not-null="true"
     *         
     */
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
    public String getRroleCode() {
        return this.rroleCode;
    }
    
    public void setRroleCode(String rroleCode) {
        this.rroleCode = rroleCode;
    }




}


