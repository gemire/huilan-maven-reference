package com.hedgehog.outletss.domain;
// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA



/**
 *        @hibernate.class
 *         table="sys_roleapplication"
 *     
 */
public class SysRoleapplication  implements java.io.Serializable {


     /**
      *            @hibernate.id
 *             generator-class="assigned"
 *         
     */
     private SysRoleapplicationPK comp_id;

    public SysRoleapplication() {
    }

    public SysRoleapplication(SysRoleapplicationPK comp_id) {
       this.comp_id = comp_id;
    }
   
    /**       
     *      *            @hibernate.id
     *             generator-class="assigned"
     *         
     */
    public SysRoleapplicationPK getComp_id() {
        return this.comp_id;
    }
    
    public void setComp_id(SysRoleapplicationPK comp_id) {
        this.comp_id = comp_id;
    }




}


