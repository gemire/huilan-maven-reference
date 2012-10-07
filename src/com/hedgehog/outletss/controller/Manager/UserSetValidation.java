package com.hedgehog.outletss.controller.Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.hedgehog.outletss.Utils.EncryptUtil;
import com.hedgehog.outletss.domain.SysUser;
import com.hedgehog.outletss.service.MyUserDetailsService;

@Component("userSetValidation")
public class UserSetValidation {
	public boolean supports(Class<?> klass) {
	    return SysUser.class.isAssignableFrom(klass);
	  }
	private MyUserDetailsService sysUserService;
	@Autowired
	public void setSysUserService(MyUserDetailsService sysUserService) {
		this.sysUserService = sysUserService;
	}
	public void validate(Object target, Errors errors) {
		SysUser user = (SysUser)target;
		//ValidationUtils.rejectIfEmpty(errors, "memberCname", "error.memberCname.required", "��ҵ����Ϊ��");
//		if(!StringUtils.hasLength(user.getOldupassword()))
//		{
//			errors.rejectValue("oldupassword", "error.oldupassword.required","�����벻��Ϊ��");	
//		}
		
//		if(!StringUtils.hasLength(user.getNewupassword()))
//		{
//			errors.rejectValue("newupassword", "error.newupassword.required","�����벻��Ϊ��");	
//		}
//		if(!StringUtils.hasLength(user.getRenewupassword()))
//		{
//			errors.rejectValue("renewupassword", "error.renewupassword.required","�������������벻��Ϊ��");	
//		}
		//本系统注释		
		if(StringUtils.hasLength(user.getOldupassword())&&StringUtils.hasLength(user.getNewupassword())&&StringUtils.hasLength(user.getRenewupassword()))
		{
			if(!user.getNewupassword().equals(user.getRenewupassword()))
			{
				errors.rejectValue("renewupassword", "error.renewupassword.inconsequent","两次输入密码不一致");	
			}
			
			SysUser sysuser =this.sysUserService.selectByUserName(user.getUloginName());
			
			if(!EncryptUtil.match(sysuser.getUpassword(), EncryptUtil.encrypt(user.getOldupassword())))
			{
				errors.rejectValue("oldupassword", "error.oldupassword.error","旧密码错误");
				
			}
			
		}
		
//		if(StringUtils.hasLength(user.getOldupassword()))
//		{
//			SysUser sysuser =this.sysUserService.selectByUserName(user.getUloginName());
//			if(!sysuser.getUpassword().equals(Security.MD5(user.getOldupassword())))
//			{
//				errors.rejectValue("oldupassword", "error.oldupassword.error","���������");	
//			}			
//		}

	  }
	

}
