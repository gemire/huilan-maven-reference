package com.hedgehog.outletss.domain;
// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA



/**
 * SysModuleextpermissionPK generated by hbm2java
 */
public class SysModuleextpermissionPK  implements java.io.Serializable {


     /**
      *                @hibernate.property
 *                 column="ModuleID"
 *                 length="40"
 *             
     */
     private String moduleId;
     /**
      *                @hibernate.property
 *                 column="PermissionValue"
 *                 length="10"
 *             
     */
     private Integer permissionValue;

    public SysModuleextpermissionPK() {
    }

    public SysModuleextpermissionPK(String moduleId, Integer permissionValue) {
       this.moduleId = moduleId;
       this.permissionValue = permissionValue;
    }
   
    /**       
     *      *                @hibernate.property
     *                 column="ModuleID"
     *                 length="40"
     *             
     */
    public String getModuleId() {
        return this.moduleId;
    }
    
    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }
    /**       
     *      *                @hibernate.property
     *                 column="PermissionValue"
     *                 length="10"
     *             
     */
    public Integer getPermissionValue() {
        return this.permissionValue;
    }
    
    public void setPermissionValue(Integer permissionValue) {
        this.permissionValue = permissionValue;
    }




}


