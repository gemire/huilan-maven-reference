package com.hedgehog.outletss.controller.Manager;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import com.hedgehog.outletss.domain.SysUser;



@Component("userLoginValidation")
public class UserLoginValidation {
	public boolean supports(Class<?> klass) {
	    return SysUser.class.isAssignableFrom(klass);
	  }
	public void validate(Object target, Errors errors) {
		SysUser user = (SysUser)target;
		
		//String code = (String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY); 
		if(!StringUtils.hasLength(user.getUloginName()))
		{
			errors.rejectValue("uloginName", "error.uloginName.required","�û�����Ϊ��");	
		}
		if(!StringUtils.hasLength(user.getUpassword()))
		{
			errors.rejectValue("upassword", "error.upassword.required","���벻��Ϊ��");	
		}
//		if(!StringUtils.hasLength(user.getCode_op()))
//		{
//			errors.rejectValue("code_op", "error.code_op.required","��֤�벻��Ϊ��");	
//		}
		
//		if(StringUtils.hasLength(user.getCode_op()))
//		{
//			if(!(user.getCode_op()).equals(code))
//			{
//				errors.rejectValue("code_op", "error.code_op.error", "��֤�����");
//			}			
//		}
		
//		if(!(member.getMemberPwd()).equals(member.getMemberconfirmPwd()))
//		{
//			 errors.rejectValue("memberconfirmPwd","matchingPassword.registration.memberconfirmPwd","ȷ�����������벻һ��");			
//		}
//		if(member.getMemberName()!="")
//		{
//			if(this.memberService.isExist(member.getMemberName()))
//			{
//				errors.rejectValue("memberName", "error.memberName.repeat","���û���ע��");			
//			}
//			
//		}
		
//		HttpSession
//		String code = (String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);  
		
		//ValidationUtils.rejectIfEmpty(errors, "memberCname", "error.memberCname.required", "��ҵ����Ϊ��");
		
//	    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
//	        "NotEmpty.registration.userName",
//	        "User Name must not be Empty.");
//	    String userName = registration.getUserName();
//	    if ((userName.length()) > 50) {
//	      errors.rejectValue("userName",
//	          "lengthOfUser.registration.userName",
//	          "User Name must not more than 50 characters.");
//	    }
//	    if (!(registration.getPassword()).equals(registration
//	        .getConfirmPassword())) {
//	      errors.rejectValue("password",
//	          "matchingPassword.registration.password",
//	          "Password and Confirm Password Not match.");
//	    }
	  }

}
