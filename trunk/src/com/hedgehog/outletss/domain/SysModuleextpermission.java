package com.hedgehog.outletss.domain;
// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA



/**
 *        @hibernate.class
 *         table="sys_moduleextpermission"
 *     
 */
public class SysModuleextpermission  implements java.io.Serializable {


     /**
      *            @hibernate.id
 *             generator-class="assigned"
 *         
     */
     private SysModuleextpermissionPK comp_id;
     /**
      *            @hibernate.property
 *             column="ExtPermissionID"
 *             length="40"
 *             not-null="true"
 *         
     */
     private String extPermissionId;
     /**
      *            @hibernate.property
 *             column="PermissionName"
 *             length="100"
 *             not-null="true"
 *         
     */
     private String permissionName;

    public SysModuleextpermission() {
    }

    public SysModuleextpermission(SysModuleextpermissionPK comp_id, String extPermissionId, String permissionName) {
       this.comp_id = comp_id;
       this.extPermissionId = extPermissionId;
       this.permissionName = permissionName;
    }
   
    /**       
     *      *            @hibernate.id
     *             generator-class="assigned"
     *         
     */
    public SysModuleextpermissionPK getComp_id() {
        return this.comp_id;
    }
    
    public void setComp_id(SysModuleextpermissionPK comp_id) {
        this.comp_id = comp_id;
    }
    /**       
     *      *            @hibernate.property
     *             column="ExtPermissionID"
     *             length="40"
     *             not-null="true"
     *         
     */
    public String getExtPermissionId() {
        return this.extPermissionId;
    }
    
    public void setExtPermissionId(String extPermissionId) {
        this.extPermissionId = extPermissionId;
    }
    /**       
     *      *            @hibernate.property
     *             column="PermissionName"
     *             length="100"
     *             not-null="true"
     *         
     */
    public String getPermissionName() {
        return this.permissionName;
    }
    
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }




}


