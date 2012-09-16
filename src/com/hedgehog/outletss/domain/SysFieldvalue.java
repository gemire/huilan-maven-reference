package com.hedgehog.outletss.domain;
// Generated 2012-9-16 16:58:05 by Hibernate Tools 3.2.2.GA



/**
 *        @hibernate.class
 *         table="sys_fieldvalue"
 *     
 */
public class SysFieldvalue  implements java.io.Serializable {


     /**
      *            @hibernate.id
 *             generator-class="assigned"
 *             type="java.lang.String"
 *             column="ValueID"
 *         
     */
     private String valueId;
     /**
      *            @hibernate.property
 *             column="V_F_Key"
 *             length="50"
 *         
     */
     private String vfKey;
     /**
      *            @hibernate.property
 *             column="V_Text"
 *             length="100"
 *         
     */
     private String vtext;
     /**
      *            @hibernate.property
 *             column="V_Code"
 *             length="100"
 *         
     */
     private String vcode;
     /**
      *            @hibernate.property
 *             column="V_ShowOrder"
 *             length="10"
 *             not-null="true"
 *         
     */
     private int vshowOrder;

    public SysFieldvalue() {
    }

	
    public SysFieldvalue(String valueId, int vshowOrder) {
        this.valueId = valueId;
        this.vshowOrder = vshowOrder;
    }
    public SysFieldvalue(String valueId, String vfKey, String vtext, String vcode, int vshowOrder) {
       this.valueId = valueId;
       this.vfKey = vfKey;
       this.vtext = vtext;
       this.vcode = vcode;
       this.vshowOrder = vshowOrder;
    }
   
    /**       
     *      *            @hibernate.id
     *             generator-class="assigned"
     *             type="java.lang.String"
     *             column="ValueID"
     *         
     */
    public String getValueId() {
        return this.valueId;
    }
    
    public void setValueId(String valueId) {
        this.valueId = valueId;
    }
    /**       
     *      *            @hibernate.property
     *             column="V_F_Key"
     *             length="50"
     *         
     */
    public String getVfKey() {
        return this.vfKey;
    }
    
    public void setVfKey(String vfKey) {
        this.vfKey = vfKey;
    }
    /**       
     *      *            @hibernate.property
     *             column="V_Text"
     *             length="100"
     *         
     */
    public String getVtext() {
        return this.vtext;
    }
    
    public void setVtext(String vtext) {
        this.vtext = vtext;
    }
    /**       
     *      *            @hibernate.property
     *             column="V_Code"
     *             length="100"
     *         
     */
    public String getVcode() {
        return this.vcode;
    }
    
    public void setVcode(String vcode) {
        this.vcode = vcode;
    }
    /**       
     *      *            @hibernate.property
     *             column="V_ShowOrder"
     *             length="10"
     *             not-null="true"
     *         
     */
    public int getVshowOrder() {
        return this.vshowOrder;
    }
    
    public void setVshowOrder(int vshowOrder) {
        this.vshowOrder = vshowOrder;
    }




}


