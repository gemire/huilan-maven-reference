package com.hedgehog.outletss.controller.Manager;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.theme.CookieThemeResolver;


import com.hedgehog.outletss.Utils.EncryptUtil;
import com.hedgehog.outletss.domain.MessageBox;
import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.SysUser;
import com.hedgehog.outletss.domain.sys_NavigationUrl;
import com.hedgehog.outletss.domain.MessageBox.Icon_Type;
import com.hedgehog.outletss.domain.sys_NavigationUrl.UrlType;
import com.hedgehog.outletss.service.MyUserDetailsService;

@Controller
@RequestMapping("/Manager/Module/FrameWork/SystemApp/UserManager")
public class UserManagerController {
	private static final Log log = LogFactory.getLog(UserManagerController.class);
	private MyUserDetailsService myUserDetailsService;
	@Autowired
	public void setMyUserDetailsService(MyUserDetailsService myUserDetailsService) {
		this.myUserDetailsService = myUserDetailsService;
	}
	@Autowired  
    private ThemeResolver themeResolver;
	

	@RequestMapping(value={"/List"},method=RequestMethod.GET)
	 public String bjksdjkadfkfd(
			 @RequestParam(value="page", defaultValue="1") int page,
		     @RequestParam(value="perPage", defaultValue="30") int perPage,	
			 ModelMap modelMap)
	 {	
		//System.out.println("password:"+EncryptUtil.encrypt("admin888"));
//		List<SysUser> list=this.myUserDetailsService.selectAllRecord();
//		modelMap.put("userlist", list);
		//modelMap.addAttribute("list", list);
		QueryPara<SysUser> qp=new QueryPara<SysUser>();
		qp.setClazz(SysUser.class);		
		qp.setPagesize(perPage);
		qp.setPageNo(page);
		
		modelMap.put("userlist", this.myUserDetailsService.selectRecordForPage(qp));
		modelMap.put("QueryPara", qp);	
		return "UserManager/List";
	 }
	@RequestMapping(value={"/Manager"},method=RequestMethod.GET,params="cmd=new")
	public String Managernew(						
			ModelMap modelMap) 
	{		
		
		modelMap.addAttribute("user", new SysUser());
    	
    	return "UserManager/Manager";
	}
	@RequestMapping(value={"/Manager"},method=RequestMethod.POST,params="cmd=new")
	public String Managernewpost(
			@RequestParam(value="IDX",defaultValue="0") int userId,
			@ModelAttribute("user") @Valid SysUser user,
			BindingResult result,
			RedirectAttributes redirectAttributes) 
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
		user.setUgroupId(3);
		user.setUtype((byte)0);
		
		this.myUserDetailsService.saveOrUpdate(user);
		
		MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("增加用户ID("+userId+")成功!");
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/SystemApp/UserManager/List","点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
    	return "redirect:/Manager/Message";	
//		redirectAttributes.addFlashAttribute("message", "添加新用户"+user.getUserId()+"成功");
//		redirectAttributes.addFlashAttribute("rawlurl", "/Manager/Module/FrameWork/SystemMaintenance/UserManager/List");//${header refer}
//    	//return "redirect:/Manager/message";
//    	return "redirect:/Manager/Module/FrameWork/SystemMaintenance/UserManager/message";
	}
	
	@RequestMapping(value={"/Manager"},method=RequestMethod.GET,params="cmd=edit")
	public String Manager(			
			@RequestParam(value="IDX") int userId,		
			ModelMap modelMap) 
	{
		
		System.out.println("进入编辑页面");
		SysUser user=this.myUserDetailsService.selectByPrimaryKey(userId);
		modelMap.addAttribute("user", user);
		
		return "UserManager/Manager";
	}
	@RequestMapping(value={"/Manager"},method=RequestMethod.POST,params="cmd=edit")
	public String Managerpost(			
			@RequestParam(value="IDX") int userId,
			@ModelAttribute("user") @Valid SysUser user,
			BindingResult result,
			RedirectAttributes redirectAttributes) 
	{
		
		if(result.hasErrors())
		{					
			return "UserManager/Manager";
		}		
		SysUser user2=this.myUserDetailsService.selectByPrimaryKey(userId);		
		BeanUtils.copyProperties(user,user2, new String[]{"userId","upassword","uename","ugroupId","uemail","utype","ulicence","umac","uidcard","usex","ubirthDay","umobileNo","uworkStartDate","uworkEndDate","ucompanyMail","utitle","uextension","uhomeTel","uphotoUrl","udateTime","ulastIp","ulastDateTime","uextendField"});
		if(StringUtils.hasLength(user.getPassword()))
		{
			//Md5PasswordEncoder md5 = new Md5PasswordEncoder();			
			//user2.setPassword( md5.encodePassword(user.getPassword(),user.getUsername()));	
			user2.setUpassword(EncryptUtil.encrypt(user.getPassword()));
		}	
		this.myUserDetailsService.saveOrUpdate(user2);		
		MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("修改用户ID("+userId+")成功!");
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/SystemApp/UserManager/List","点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
    	return "redirect:/Manager/Message";	
//		redirectAttributes.addFlashAttribute("message", "修改系统用户"+userId+"成功");
//		redirectAttributes.addFlashAttribute("rawlurl", "/Manager/Module/FrameWork/SystemMaintenance/UserManager/List");
//    	//return "redirect:/Manager/message";
//    	return "redirect:/Manager/Module/FrameWork/SystemMaintenance/UserManager/message";
	}
	@RequestMapping(value={"/Manager"},method=RequestMethod.GET,params="cmd=del")
	public String Managerdel(			
			@RequestParam(value="IDX") int userId,
			RedirectAttributes redirectAttributes
			) 
	{
		log.info("执行删除操作："+userId);
		//redirectAttributes.addAttribute(arg0, arg1)
		this.myUserDetailsService.deleteByPrimaryKey(userId);
		MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("删除用户ID("+userId+")成功!");
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/SystemApp/UserManager/List","点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
    	return "redirect:/Manager/Message";	
//		redirectAttributes.addFlashAttribute("message", "模拟删除系统用户"+userId+"成功");
//		redirectAttributes.addFlashAttribute("rawlurl", "/Manager/Module/FrameWork/SystemMaintenance/UserManager/List");
//		return "redirect:/Manager/Module/FrameWork/SystemMaintenance/UserManager/message";
	}
	
	@RequestMapping(value={"/UserSet"},method=RequestMethod.GET)
	public String userset(
			Principal principal,
			ModelMap model)
	{		
		SysUser sysUser=this.myUserDetailsService.selectByUserName(principal.getName());
		String uextendField=sysUser.getUextendField();
		//StringTokenizer st = new StringTokenizer(uextendField, ",");
		String[] strarray=(uextendField+"").split(",");
		if(strarray.length==3)
		{
			sysUser.setMenuSink(strarray[0]);
			sysUser.setTableSink(strarray[1]);
			sysUser.setPageSize(strarray[2]);			
		}
		model.addAttribute("sysUser", sysUser);
		return "Manager/UserSet";
	}
	@RequestMapping(value={"/UserSet"},method=RequestMethod.POST)
	public String usersetpost(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("sysUser") SysUser user,			
			BindingResult result,
			ModelMap model)
	{
		UserSetValidation userSetValidation=new UserSetValidation();
		userSetValidation.validate(user, result);
		//boolean ChangPwdBool = false;
		if(result.hasErrors())
		{
			return "Manager/UserSet";
		}
		SysUser sysUser=this.myUserDetailsService.selectByUserName(user.getUloginName());
		//BeanUtils.copyProperties(sysUser,user, new String[]{"uuserNo","ucname","ustatus","uremark"});
		if(StringUtils.hasLength(user.getNewupassword()))
		{
			sysUser.setUpassword(EncryptUtil.encrypt(user.getNewupassword()));
		}
		sysUser.setUextendField(user.getMenuSink()+","+user.getTableSink()+","+user.getPageSize());
		this.myUserDetailsService.saveOrUpdate(sysUser);
		this.themeResolver.setThemeName(request, response, user.getTableSink());
		//log.info("cookies路径："+this.themeResolver.getCookiePath());
		//model.addAttribute("tags", "true");
		model.addAttribute("TabJs", "<script language='javascript'>window.returnVal='个人资料修改成功';window.parent.hidePopWin(true);</script>");
		//return "redirect:/Manager/Main";//区分相对路径与绝对路径
		return "Manager/UserSet";//区分相对路径与绝对路径
	}
	class UserSetValidation {
		public boolean supports(Class<?> klass) 
		{
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
		  }
	}
}
