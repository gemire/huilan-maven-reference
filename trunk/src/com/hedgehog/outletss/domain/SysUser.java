package com.hedgehog.outletss.domain;
// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA


import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *        @hibernate.class
 *         table="sys_user"
 *     
 */
@Entity
@Table(name="sys_user")
@org.hibernate.annotations.Proxy(lazy = false)
public class SysUser  implements java.io.Serializable ,UserDetails{
	
	private static final long serialVersionUID = 1L;


     /**
      *            @hibernate.id
 *             generator-class="assigned"
 *             type="java.lang.String"
 *             column="UserID"
 *         
     */
     private String userId;
     /**
      *            @hibernate.property
 *             column="U_LoginName"
 *             length="20"
 *             not-null="true"
 *         
     */
     private String uloginName;
     /**
      *            @hibernate.property
 *             column="U_Password"
 *             length="100"
 *             not-null="true"
 *         
     */
     private String upassword;
     /**
      *            @hibernate.property
 *             column="U_CName"
 *             length="20"
 *         
     */
     private String ucname;
     /**
      *            @hibernate.property
 *             column="U_EName"
 *             length="50"
 *         
     */
     private String uename;
     /**
      *            @hibernate.property
 *             column="U_GroupID"
 *             length="40"
 *             not-null="true"
 *         
     */
     private String ugroupId;
     /**
      *            @hibernate.property
 *             column="U_Email"
 *             length="100"
 *         
     */
     private String uemail;
     /**
      *            @hibernate.property
 *             column="U_Type"
 *             length="3"
 *             not-null="true"
 *         
     */
     private byte utype;
     /**
      *            @hibernate.property
 *             column="U_Status"
 *             length="3"
 *             not-null="true"
 *         
     */
     private byte ustatus;
     /**
      *            @hibernate.property
 *             column="U_Licence"
 *             length="30"
 *         
     */
     private String ulicence;
     /**
      *            @hibernate.property
 *             column="U_Mac"
 *             length="50"
 *         
     */
     private String umac;
     /**
      *            @hibernate.property
 *             column="U_Remark"
 *             length="200"
 *         
     */
     private String uremark;
     /**
      *            @hibernate.property
 *             column="U_IDCard"
 *             length="30"
 *         
     */
     private String uidcard;
     /**
      *            @hibernate.property
 *             column="U_Sex"
 *             length="3"
 *         
     */
     private Byte usex;
     /**
      *            @hibernate.property
 *             column="U_BirthDay"
 *             length="19"
 *         
     */
     private Timestamp ubirthDay;
     /**
      *            @hibernate.property
 *             column="U_MobileNo"
 *             length="15"
 *         
     */
     private String umobileNo;
     /**
      *            @hibernate.property
 *             column="U_UserNO"
 *             length="20"
 *         
     */
     private String uuserNo;
     /**
      *            @hibernate.property
 *             column="U_WorkStartDate"
 *             length="19"
 *         
     */
     private Timestamp uworkStartDate;
     /**
      *            @hibernate.property
 *             column="U_WorkEndDate"
 *             length="19"
 *         
     */
     private Timestamp uworkEndDate;
     /**
      *            @hibernate.property
 *             column="U_CompanyMail"
 *             length="255"
 *         
     */
     private String ucompanyMail;
     /**
      *            @hibernate.property
 *             column="U_Title"
 *             length="40"
 *         
     */
     private String utitle;
     /**
      *            @hibernate.property
 *             column="U_Extension"
 *             length="10"
 *         
     */
     private String uextension;
     /**
      *            @hibernate.property
 *             column="U_HomeTel"
 *             length="20"
 *         
     */
     private String uhomeTel;
     /**
      *            @hibernate.property
 *             column="U_PhotoUrl"
 *             length="255"
 *         
     */
     private String uphotoUrl;
     /**
      *            @hibernate.property
 *             column="U_DateTime"
 *             length="19"
 *         
     */
     private Timestamp udateTime;
     /**
      *            @hibernate.property
 *             column="U_LastIP"
 *             length="15"
 *         
     */
     private String ulastIp;
     /**
      *            @hibernate.property
 *             column="U_LastDateTime"
 *             length="19"
 *         
     */
     private Timestamp ulastDateTime;
     /**
      *            @hibernate.property
 *             column="U_ExtendField"
 *             length="2147483647"
 *         
     */
     private byte[] uextendField;
    
   
    /**       
     *      *            @hibernate.id
     *             generator-class="assigned"
     *             type="java.lang.String"
     *             column="UserID"
     *         
     */
    @Id
 	@Column(name = "UserID",length =40,unique=true, nullable=false)	
 	@GeneratedValue(generator = "system-uuid")
 	@GenericGenerator(name = "system-uuid", strategy = "uuid")
    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_LoginName"
     *             length="20"
     *             not-null="true"
     *         
     */
    @Column(name="U_LoginName",length=20)
    public String getUloginName() {
        return this.uloginName;
    }
    
    public void setUloginName(String uloginName) {
        this.uloginName = uloginName;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_Password"
     *             length="100"
     *             not-null="true"
     *         
     */
    @Column(name="U_Password",length=100)
    public String getUpassword() {
        return this.upassword;
    }
    
    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_CName"
     *             length="20"
     *         
     */
    @Column(name="U_CName",length=20)
    public String getUcname() {
        return this.ucname;
    }
    
    public void setUcname(String ucname) {
        this.ucname = ucname;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_EName"
     *             length="50"
     *         
     */
    @Column(name="U_EName",length=50)
    public String getUename() {
        return this.uename;
    }
    
    public void setUename(String uename) {
        this.uename = uename;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_GroupID"
     *             length="40"
     *             not-null="true"
     *         
     */
    @Column(name="U_GroupID",length=40)
    public String getUgroupId() {
        return this.ugroupId;
    }
    
    public void setUgroupId(String ugroupId) {
        this.ugroupId = ugroupId;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_Email"
     *             length="100"
     *         
     */
    @Column(name="U_Email",length=100)
    public String getUemail() {
        return this.uemail;
    }
    
    public void setUemail(String uemail) {
        this.uemail = uemail;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_Type"
     *             length="3"
     *             not-null="true"
     *         
     */
    @Column(name="U_Type",length=3)
    public byte getUtype() {
        return this.utype;
    }
    
    public void setUtype(byte utype) {
        this.utype = utype;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_Status"
     *             length="3"
     *             not-null="true"
     *         
     */
    @Column(name="U_Status",length=3)
    public byte getUstatus() {
        return this.ustatus;
    }
    
    public void setUstatus(byte ustatus) {
        this.ustatus = ustatus;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_Licence"
     *             length="30"
     *         
     */
    @Column(name="U_Licence",length=30)
    public String getUlicence() {
        return this.ulicence;
    }
    
    public void setUlicence(String ulicence) {
        this.ulicence = ulicence;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_Mac"
     *             length="50"
     *         
     */
    @Column(name="U_Mac",length=50)
    public String getUmac() {
        return this.umac;
    }
    
    public void setUmac(String umac) {
        this.umac = umac;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_Remark"
     *             length="200"
     *         
     */
    @Column(name="U_Remark",length=200)
    public String getUremark() {
        return this.uremark;
    }
    
    public void setUremark(String uremark) {
        this.uremark = uremark;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_IDCard"
     *             length="30"
     *         
     */
    @Column(name="U_IDCard",length=30)
    public String getUidcard() {
        return this.uidcard;
    }
    
    public void setUidcard(String uidcard) {
        this.uidcard = uidcard;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_Sex"
     *             length="3"
     *         
     */
    @Column(name="U_Sex",length=3)
    public Byte getUsex() {
        return this.usex;
    }
    
    public void setUsex(Byte usex) {
        this.usex = usex;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_BirthDay"
     *             length="19"
     *         
     */
    @Column(name="U_BirthDay",length=19)
    public Timestamp getUbirthDay() {
        return this.ubirthDay;
    }
    
    public void setUbirthDay(Timestamp ubirthDay) {
        this.ubirthDay = ubirthDay;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_MobileNo"
     *             length="15"
     *         
     */
    @Column(name="U_MobileNo",length=15)
    public String getUmobileNo() {
        return this.umobileNo;
    }
    
    public void setUmobileNo(String umobileNo) {
        this.umobileNo = umobileNo;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_UserNO"
     *             length="20"
     *         
     */
    @Column(name="U_UserNO",length=20)
    public String getUuserNo() {
        return this.uuserNo;
    }
    
    public void setUuserNo(String uuserNo) {
        this.uuserNo = uuserNo;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_WorkStartDate"
     *             length="19"
     *         
     */
    @Column(name="U_WorkStartDate",length=19)
    public Timestamp getUworkStartDate() {
        return this.uworkStartDate;
    }
    
    public void setUworkStartDate(Timestamp uworkStartDate) {
        this.uworkStartDate = uworkStartDate;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_WorkEndDate"
     *             length="19"
     *         
     */
    @Column(name="U_WorkEndDate",length=19)
    public Timestamp getUworkEndDate() {
        return this.uworkEndDate;
    }
    
    public void setUworkEndDate(Timestamp uworkEndDate) {
        this.uworkEndDate = uworkEndDate;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_CompanyMail"
     *             length="255"
     *         
     */
    @Column(name="U_CompanyMail",length=255)
    public String getUcompanyMail() {
        return this.ucompanyMail;
    }
    
    public void setUcompanyMail(String ucompanyMail) {
        this.ucompanyMail = ucompanyMail;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_Title"
     *             length="40"
     *         
     */
    @Column(name="U_Title",length=40)
    public String getUtitle() {
        return this.utitle;
    }
    
    public void setUtitle(String utitle) {
        this.utitle = utitle;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_Extension"
     *             length="10"
     *         
     */
    @Column(name="U_Extension",length=10)
    public String getUextension() {
        return this.uextension;
    }
    
    public void setUextension(String uextension) {
        this.uextension = uextension;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_HomeTel"
     *             length="20"
     *         
     */
    @Column(name="U_HomeTel",length=20)
    public String getUhomeTel() {
        return this.uhomeTel;
    }
    
    public void setUhomeTel(String uhomeTel) {
        this.uhomeTel = uhomeTel;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_PhotoUrl"
     *             length="255"
     *         
     */
    @Column(name="U_PhotoUrl",length=255)
    public String getUphotoUrl() {
        return this.uphotoUrl;
    }
    
    public void setUphotoUrl(String uphotoUrl) {
        this.uphotoUrl = uphotoUrl;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_DateTime"
     *             length="19"
     *         
     */
    @Column(name="U_DateTime",length=19)
    public Timestamp getUdateTime() {
        return this.udateTime;
    }
    
    public void setUdateTime(Timestamp udateTime) {
        this.udateTime = udateTime;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_LastIP"
     *             length="15"
     *         
     */
    @Column(name="U_LastIP",length=15)
    public String getUlastIp() {
        return this.ulastIp;
    }
    
    public void setUlastIp(String ulastIp) {
        this.ulastIp = ulastIp;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_LastDateTime"
     *             length="19"
     *         
     */
    @Column(name="U_LastDateTime",length=19)
    public Timestamp getUlastDateTime() {
        return this.ulastDateTime;
    }
    
    public void setUlastDateTime(Timestamp ulastDateTime) {
        this.ulastDateTime = ulastDateTime;
    }
    /**       
     *      *            @hibernate.property
     *             column="U_ExtendField"
     *             length="2147483647"
     *         
     */
    @Column(name="U_ExtendField",length=2147483647)
    public byte[] getUextendField() {
        return this.uextendField;
    }
    
    public void setUextendField(byte[] uextendField) {
        this.uextendField = uextendField;
    }
    /**
     * 实现UserDetails接口方法
     */
    	@Override
    	@Transient
    	public Collection<? extends GrantedAuthority> getAuthorities() {
    		// TODO Auto-generated method stub
    		return null;
    	}


    	@Override
    	@Transient
    	public String getPassword() {
    		// TODO Auto-generated method stub
    		return this.upassword;
    	}


    	@Override
    	@Transient
    	public String getUsername() {
    		// TODO Auto-generated method stub
    		return this.uloginName;
    	}


    	@Override
    	@Transient
    	public boolean isAccountNonExpired() {
    		// TODO Auto-generated method stub
    		return true;
    	}


    	@Override
    	@Transient
    	public boolean isAccountNonLocked() {
    		// TODO Auto-generated method stub
    		return true;
    	}


    	@Override
    	@Transient
    	public boolean isCredentialsNonExpired() {
    		// TODO Auto-generated method stub
    		return true;
    	}


    	@Override
    	@Transient
    	public boolean isEnabled() {
    		// TODO Auto-generated method stub
    		return this.ustatus==0?true:false;		
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


