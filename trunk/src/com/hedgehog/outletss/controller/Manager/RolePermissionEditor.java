package com.hedgehog.outletss.controller.Manager;

import java.beans.PropertyEditorSupport;



public class RolePermissionEditor extends PropertyEditorSupport{
	@Override
	 public void setAsText(String pvalue) throws IllegalArgumentException
	 {
		 System.out.println("����ֵ��"+pvalue);
		 this.setValue(32);
	 }
	@Override
	 public String getAsText()
	 {
		
		 System.out.println("����bean:"+this.getValue());
		 return "32";
	 }

}
