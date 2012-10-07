package com.hedgehog.outletss.domain;

import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;



/**
 *        @hibernate.class
 *         table="sys_Group"
 *     
 */
@Entity
@Table(name="sys_group")
@org.hibernate.annotations.Proxy(lazy = false)
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
     
     private SysGroup parentSysGroup;     
     
     
     private List<SysGroup> subSysGroups;

    
   
    /**       
     *      *            @hibernate.id
     *             generator-class="assigned"
     *             type="java.lang.String"
     *             column="GroupID"
     *         
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GroupID",unique=true, nullable=false)
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
    @Column(name="G_CName",length=50)
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
    @Column(name="G_ParentID",length=10)
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
    @Column(name="G_ShowOrder",length=10)
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
    @Column(name="G_Level",length=10)
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
    @Column(name="G_ChildCount",length=10)
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
    @Column(name="G_Delete",length=3)
    public Byte getGdelete() {
        return this.gdelete;
    }
    
    public void setGdelete(Byte gdelete) {
        this.gdelete = gdelete;
    }
    @ManyToOne(cascade={CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name="G_ParentID",insertable=false,updatable=false)
    @NotFound(action = NotFoundAction.IGNORE)  
    public SysGroup getParentSysGroup() {
		return parentSysGroup;
	}

	public void setParentSysGroup(SysGroup parentSysGroup) {
		this.parentSysGroup = parentSysGroup;
	}
	 @OneToMany(mappedBy="parentSysGroup",fetch=FetchType.LAZY, cascade={CascadeType.REMOVE})   
	  @OrderBy("gshowOrder ASC")
	public List<SysGroup> getSubSysGroups() {
		return subSysGroups;
	}

	public void setSubSysGroups(List<SysGroup> subSysGroups) {
		this.subSysGroups = subSysGroups;
	}

	// plumbing
    @Override
    public boolean equals(Object obj) {
      return reflectionEquals(this, obj);
    }
    
    @Override
    public int hashCode() {
      return reflectionHashCode(this);
    }
    
    @Override
    public String toString() {
      return reflectionToString(this);
    }
}


