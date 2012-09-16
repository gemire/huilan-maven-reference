package com.hedgehog.outletss.domain;
// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA



/**
 *        @hibernate.class
 *         table="sys_group"
 *     
 */
public class SysGroup  implements java.io.Serializable {


     /**
      *            @hibernate.id
 *             generator-class="assigned"
 *             type="java.lang.String"
 *             column="GroupID"
 *         
     */
     private String groupId;
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
     private String gparentId;
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

    public SysGroup() {
    }

	
    public SysGroup(String groupId, String gparentId, int gshowOrder) {
        this.groupId = groupId;
        this.gparentId = gparentId;
        this.gshowOrder = gshowOrder;
    }
    public SysGroup(String groupId, String gcname, String gparentId, int gshowOrder, Integer glevel, Integer gchildCount, Byte gdelete) {
       this.groupId = groupId;
       this.gcname = gcname;
       this.gparentId = gparentId;
       this.gshowOrder = gshowOrder;
       this.glevel = glevel;
       this.gchildCount = gchildCount;
       this.gdelete = gdelete;
    }
   
    /**       
     *      *            @hibernate.id
     *             generator-class="assigned"
     *             type="java.lang.String"
     *             column="GroupID"
     *         
     */
    public String getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(String groupId) {
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
    public String getGparentId() {
        return this.gparentId;
    }
    
    public void setGparentId(String gparentId) {
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


