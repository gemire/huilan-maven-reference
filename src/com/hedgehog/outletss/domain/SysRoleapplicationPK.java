package com.hedgehog.outletss.domain;
// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA



/**
 * SysRoleapplicationPK generated by hbm2java
 */
public class SysRoleapplicationPK  implements java.io.Serializable {


     /**
      *                @hibernate.property
 *                 column="A_RoleID"
 *                 length="40"
 *             
     */
     private String aroleId;
     /**
      *                @hibernate.property
 *                 column="A_ApplicationID"
 *                 length="40"
 *             
     */
     private String aapplicationId;

    public SysRoleapplicationPK() {
    }

    public SysRoleapplicationPK(String aroleId, String aapplicationId) {
       this.aroleId = aroleId;
       this.aapplicationId = aapplicationId;
    }
   
    /**       
     *      *                @hibernate.property
     *                 column="A_RoleID"
     *                 length="40"
     *             
     */
    public String getAroleId() {
        return this.aroleId;
    }
    
    public void setAroleId(String aroleId) {
        this.aroleId = aroleId;
    }
    /**       
     *      *                @hibernate.property
     *                 column="A_ApplicationID"
     *                 length="40"
     *             
     */
    public String getAapplicationId() {
        return this.aapplicationId;
    }
    
    public void setAapplicationId(String aapplicationId) {
        this.aapplicationId = aapplicationId;
    }




}


