package com.hedgehog.outletss.domain;
// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA



/**
 * SysUserrolePK generated by hbm2java
 */
public class SysUserrolePK  implements java.io.Serializable {


     /**
      *                @hibernate.property
 *                 column="R_UserID"
 *                 length="40"
 *             
     */
     private String ruserId;
     /**
      *                @hibernate.property
 *                 column="R_RoleID"
 *                 length="40"
 *             
     */
     private String rroleId;

    public SysUserrolePK() {
    }

    public SysUserrolePK(String ruserId, String rroleId) {
       this.ruserId = ruserId;
       this.rroleId = rroleId;
    }
   
    /**       
     *      *                @hibernate.property
     *                 column="R_UserID"
     *                 length="40"
     *             
     */
    public String getRuserId() {
        return this.ruserId;
    }
    
    public void setRuserId(String ruserId) {
        this.ruserId = ruserId;
    }
    /**       
     *      *                @hibernate.property
     *                 column="R_RoleID"
     *                 length="40"
     *             
     */
    public String getRroleId() {
        return this.rroleId;
    }
    
    public void setRroleId(String rroleId) {
        this.rroleId = rroleId;
    }




}


