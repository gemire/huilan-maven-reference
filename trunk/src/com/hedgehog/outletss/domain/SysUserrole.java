package com.hedgehog.outletss.domain;
// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA



/**
 *        @hibernate.class
 *         table="sys_userroles"
 *     
 */
public class SysUserrole  implements java.io.Serializable {


     /**
      *            @hibernate.id
 *             generator-class="assigned"
 *         
     */
     private SysUserrolePK comp_id;

    public SysUserrole() {
    }

    public SysUserrole(SysUserrolePK comp_id) {
       this.comp_id = comp_id;
    }
   
    /**       
     *      *            @hibernate.id
     *             generator-class="assigned"
     *         
     */
    public SysUserrolePK getComp_id() {
        return this.comp_id;
    }
    
    public void setComp_id(SysUserrolePK comp_id) {
        this.comp_id = comp_id;
    }




}


