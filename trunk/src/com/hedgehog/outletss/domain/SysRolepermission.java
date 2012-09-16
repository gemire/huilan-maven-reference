package com.hedgehog.outletss.domain;
// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA



/**
 *        @hibernate.class
 *         table="sys_rolepermission"
 *     
 */
public class SysRolepermission  implements java.io.Serializable {


     /**
      *            @hibernate.id
 *             generator-class="assigned"
 *         
     */
     private SysRolepermissionPK comp_id;
     /**
      *            @hibernate.property
 *             column="PermissionID"
 *             length="40"
 *             not-null="true"
 *         
     */
     private String permissionId;
     /**
      *            @hibernate.property
 *             column="P_Value"
 *             length="10"
 *         
     */
     private Integer pvalue;

    public SysRolepermission() {
    }

	
    public SysRolepermission(SysRolepermissionPK comp_id, String permissionId) {
        this.comp_id = comp_id;
        this.permissionId = permissionId;
    }
    public SysRolepermission(SysRolepermissionPK comp_id, String permissionId, Integer pvalue) {
       this.comp_id = comp_id;
       this.permissionId = permissionId;
       this.pvalue = pvalue;
    }
   
    /**       
     *      *            @hibernate.id
     *             generator-class="assigned"
     *         
     */
    public SysRolepermissionPK getComp_id() {
        return this.comp_id;
    }
    
    public void setComp_id(SysRolepermissionPK comp_id) {
        this.comp_id = comp_id;
    }
    /**       
     *      *            @hibernate.property
     *             column="PermissionID"
     *             length="40"
     *             not-null="true"
     *         
     */
    public String getPermissionId() {
        return this.permissionId;
    }
    
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
    /**       
     *      *            @hibernate.property
     *             column="P_Value"
     *             length="10"
     *         
     */
    public Integer getPvalue() {
        return this.pvalue;
    }
    
    public void setPvalue(Integer pvalue) {
        this.pvalue = pvalue;
    }




}


