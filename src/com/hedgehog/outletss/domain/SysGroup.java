package com.hedgehog.outletss.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA



/**
 *        @hibernate.class
 *         table="sys_Group"
 *     
 */

public class SysGroup  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;


     /**
      *            @hibernate.id
 *             generator-class="assigned"
 *             type="java.lang.String"
 *             column="GroupID"
 *         
     */
     private Integer groupId;
     /**
      *            @hibernate.property
 *             column="G_CName"
 *             length="50"
 *         
     */
     private String gcname;
     /**
      *            @hibernate.property
 *             column="G_ParentID"
 *             length="40"
 *             not-null="true"
 *         
     */
     private Integer gparentId;
     /**
      *            @hibernate.property
 *             column="G_ShowOrder"
 *             length="10"
 *             not-null="true"
 *         
     */
     private int gshowOrder;
     /**
      *            @hibernate.property
 *             column="G_Level"
 *             length="10"
 *         
     */
     private Integer glevel;
     /**
      *            @hibernate.property
 *             column="G_ChildCount"
 *             length="10"
 *         
     */
     private Integer gchildCount;
     /**
      *            @hibernate.property
 *             column="G_Delete"
 *             length="3"
 *         
     */
     private Byte gdelete;

    
   
    /**       
     *      *            @hibernate.id
     *             generator-class="assigned"
     *             type="java.lang.String"
     *             column="GroupID"
     *         
     */
    public Integer getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
    /**       
     *      *            @hibernate.property
     *             column="G_CName"
     *             length="50"
     *         
     */
    public String getGcname() {
        return this.gcname;
    }
    
    public void setGcname(String gcname) {
        this.gcname = gcname;
    }
    /**       
     *      *            @hibernate.property
     *             column="G_ParentID"
     *             length="40"
     *             not-null="true"
     *         
     */
    public Integer getGparentId() {
        return this.gparentId;
    }
    
    public void setGparentId(Integer gparentId) {
        this.gparentId = gparentId;
    }
    /**       
     *      *            @hibernate.property
     *             column="G_ShowOrder"
     *             length="10"
     *             not-null="true"
     *         
     */
    public int getGshowOrder() {
        return this.gshowOrder;
    }
    
    public void setGshowOrder(int gshowOrder) {
        this.gshowOrder = gshowOrder;
    }
    /**       
     *      *            @hibernate.property
     *             column="G_Level"
     *             length="10"
     *         
     */
    public Integer getGlevel() {
        return this.glevel;
    }
    
    public void setGlevel(Integer glevel) {
        this.glevel = glevel;
    }
    /**       
     *      *            @hibernate.property
     *             column="G_ChildCount"
     *             length="10"
     *         
     */
    public Integer getGchildCount() {
        return this.gchildCount;
    }
    
    public void setGchildCount(Integer gchildCount) {
        this.gchildCount = gchildCount;
    }
    /**       
     *      *            @hibernate.property
     *             column="G_Delete"
     *             length="3"
     *         
     */
    public Byte getGdelete() {
        return this.gdelete;
    }
    
    public void setGdelete(Byte gdelete) {
        this.gdelete = gdelete;
    }




}


