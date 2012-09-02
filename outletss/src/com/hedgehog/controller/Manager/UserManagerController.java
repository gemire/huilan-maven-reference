package com.hedgehog.controller.Manager;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.hedgehog.Utils.EncryptUtil;
import com.hedgehog.domain.SysUser;
import com.hedgehog.service.MyUserDetailsService;

@Controller
@RequestMapping("/Manager/Module/FrameWork/SystemMaintenance/UserManager")
public class UserManagerController {
	private static final Log log = LogFactory.getLog(UserManagerController.class);
	private MyUserDetailsService myUserDetailsService;
	@Autowired
	public void setMyUserDetailsService(MyUserDetailsService myUserDetailsService) {
		this.myUserDetailsService = myUserDetailsService;
	}

	@RequestMapping(value={"/List"},method=RequestMethod.GET)
	 public String bjksdjkadfkfd(ModelMap modelMap)
	 {	
		List<SysUser> list=this.myUserDetailsService.selectAllRecord();
		modelMap.addAttribute("list", list);
		return "UserManager/List";
	 }
	@RequestMapping(value={"/List"},method=RequestMethod.GET,params="cmd=new")
	public String Managernew(						
			ModelMap modelMap) 
	{		
		
		modelMap.addAttribute("user", new SysUser());
    	
    	return "UserManager/Manager";
	}
	@RequestMapping(value={"/List"},method=RequestMethod.POST,params="cmd=new")
	public String Managernewpost(			
			@ModelAttribute("user") @Valid SysUser user,
			BindingResult result,
			RedirectAttributes redirectAttributes,
			ModelMap modelMap) 
	{
		if(!StringUtils.hasLength(user.getPassword()))
		{
			//添加校验信息
			result.rejectValue("password", "password.required", "密码不能为空");	
		}	
		
		if(result.hasErrors())
		{					
			return "UserManager/Manager";
		}
		//Md5PasswordEncoder md5 = new Md5PasswordEncoder();		
		//user.setPassword(md5.encodePassword(user.getPassword(),user.getUsername()));
		user.setUpassword(EncryptUtil.encrypt(user.getPassword()));
		
		this.myUserDetailsService.saveOrUpdate(user);
		redirectAttributes.addFlashAttribute("message", "添加新用户"+user.getUserId()+"成功");
		redirectAttributes.addFlashAttribute("rawlurl", "/Manager/Module/FrameWork/SystemMaintenance/UserManager/List");//${header refer}
    	//return "redirect:/Manager/message";
    	return "redirect:/Manager/Module/FrameWork/SystemMaintenance/UserManager/message";
	}
	
	@RequestMapping(value={"/List"},method=RequestMethod.GET,params="cmd=edit")
	public String Manager(			
			@RequestParam(value="IDX") String userId,		
			ModelMap modelMap) 
	{
		
		
		SysUser user=this.myUserDetailsService.selectByPrimaryKey(userId);
		modelMap.addAttribute("user", user);
		
		return "UserManager/Manager";
	}
	@RequestMapping(value={"/List"},method=RequestMethod.POST,params="cmd=edit")
	public String Managerpost(			
			@RequestParam(value="IDX") String userId,
			@ModelAttribute("user") @Valid SysUser user,
			BindingResult result,
			RedirectAttributes redirectAttributes,
			ModelMap modelMap) 
	{
		if(result.hasErrors())
		{					
			return "UserManager/Manager";
		}		
		SysUser user2=this.myUserDetailsService.selectByPrimaryKey(userId);
		BeanUtils.copyProperties(user, user2,new String[]{"userId"});
		if(StringUtils.hasLength(user.getPassword()))
		{
			//Md5PasswordEncoder md5 = new Md5PasswordEncoder(); 
			
			//user2.setPassword( md5.encodePassword(user.getPassword(),user.getUsername()));	
			user2.setUpassword(EncryptUtil.encrypt(user.getPassword()));
		}	
		
		this.myUserDetailsService.saveOrUpdate(user2);
		redirectAttributes.addFlashAttribute("message", "修改系统用户"+userId+"成功");
		redirectAttributes.addFlashAttribute("rawlurl", "/Manager/Module/FrameWork/SystemMaintenance/UserManager/List");
    	//return "redirect:/Manager/message";
    	return "redirect:/Manager/Module/FrameWork/SystemMaintenance/UserManager/message";
	}
	@RequestMapping(value={"/List"},method=RequestMethod.GET,params="cmd=del")
	public String Managerdel(			
			@RequestParam(value="IDX") String userId,
			RedirectAttributes redirectAttributes
			) 
	{
		log.info("执行删除操作："+userId);
		//redirectAttributes.addAttribute(arg0, arg1)
		redirectAttributes.addFlashAttribute("message", "模拟删除系统用户"+userId+"成功");
		redirectAttributes.addFlashAttribute("rawlurl", "/Manager/Module/FrameWork/SystemMaintenance/UserManager/List");
		return "redirect:/Manager/Module/FrameWork/SystemMaintenance/UserManager/message";
	}


}
