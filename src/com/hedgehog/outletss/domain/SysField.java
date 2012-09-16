package com.hedgehog.outletss.domain;
// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA



/**
 *        @hibernate.class
 *         table="sys_field"
 *     
 */
public class SysField  implements java.io.Serializable {


     /**
      *            @hibernate.id
 *             generator-class="assigned"
 *             type="java.lang.String"
 *             column="FieldID"
 *         
     */
     private String fieldId;
     /**
      *            @hibernate.property
 *             column="F_Key"
 *             length="50"
 *         
     */
     private String fkey;
     /**
      *            @hibernate.property
 *             column="F_CName"
 *             length="50"
 *         
     */
     private String fcname;
     /**
      *            @hibernate.property
 *             column="F_Remark"
 *             length="200"
 *         
     */
     private String fremark;

    public SysField() {
    }

	
    public SysField(String fieldId) {
        this.fieldId = fieldId;
    }
    public SysField(String fieldId, String fkey, String fcname, String fremark) {
       this.fieldId = fieldId;
       this.fkey = fkey;
       this.fcname = fcname;
       this.fremark = fremark;
    }
   
    /**       
     *      *            @hibernate.id
     *             generator-class="assigned"
     *             type="java.lang.String"
     *             column="FieldID"
     *         
     */
    public String getFieldId() {
        return this.fieldId;
    }
    
    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }
    /**       
     *      *            @hibernate.property
     *             column="F_Key"
     *             length="50"
     *         
     */
    public String getFkey() {
        return this.fkey;
    }
    
    public void setFkey(String fkey) {
        this.fkey = fkey;
    }
    /**       
     *      *            @hibernate.property
     *             column="F_CName"
     *             length="50"
     *         
     */
    public String getFcname() {
        return this.fcname;
    }
    
    public void setFcname(String fcname) {
        this.fcname = fcname;
    }
    /**       
     *      *            @hibernate.property
     *             column="F_Remark"
     *             length="200"
     *         
     */
    public String getFremark() {
        return this.fremark;
    }
    
    public void setFremark(String fremark) {
        this.fremark = fremark;
    }




}


