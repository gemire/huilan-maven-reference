package com.hedgehog.outletss.controller.Manager;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.Principal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.theme.CookieThemeResolver;

import com.hedgehog.outletss.domain.SysModule;
import com.hedgehog.outletss.domain.SysSystemInfo;
import com.hedgehog.outletss.domain.SysUser;
import com.hedgehog.outletss.service.MyUserDetailsService;
import com.hedgehog.outletss.service.SysModuleService;
import com.hedgehog.outletss.service.SysSystemInfoService;

/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/Manager")
public class BasicController {
	private static final Log log = LogFactory.getLog(BasicController.class);
	
	private SysSystemInfoService systemInfoService;
	@Inject
	public BasicController(SysSystemInfoService systemInfoService) {		
		this.systemInfoService = systemInfoService;
	}
	private MyUserDetailsService myUserDetailsService;
	@Autowired
	public void setMyUserDetailsService(MyUserDetailsService myUserDetailsService) {
		this.myUserDetailsService = myUserDetailsService;
	}
	
//	private ApplicationsService applicationsService;		
//
//	@Inject
//	public void setApplicationsService(ApplicationsService applicationsService) {
//		this.applicationsService = applicationsService;
//	}
	
	private SysModuleService sysModuleService;
	@Inject
	public void setModuleService(SysModuleService moduleService) {
		this.sysModuleService = moduleService;
	}
	 
	@Autowired  
    private ThemeResolver themeResolver;
	//forward
	@RequestMapping(value={"/Main"},method=GET)
	public String manager(			
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap modelMap) 
	{
		//@RequestParam(value="theme", defaultValue="default") String theme,
		
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		List <GrantedAuthority> list=(List<GrantedAuthority>) auth.getAuthorities();
//		for(GrantedAuthority au:list)
//		{
//			System.out.println(au.getAuthority());
//		}
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		log.info("当前用户："+userDetails.getUsername());
		List <GrantedAuthority> list=(List<GrantedAuthority>) userDetails.getAuthorities();
		for(GrantedAuthority au:list)
		{
			log.info(au.getAuthority());
		}
		//User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		//@CookieValue(value="sysuser",defaultValue="") String cookieuserName,
		
		//System.out.println("theme:"+theme);
		//String ss=CookieThemeResolver.DEFAULT_COOKIE_NAME;
		log.info("main current theme is "+themeResolver.resolveThemeName(request));
//		SysUser sysUser=this.myUserDetailsService.selectByUserName(userDetails.getUsername());
//		String[] strarray=(sysUser.getUextendField()+"").split(",");
//		if(strarray.length==3)
//		{
//			this.themeResolver.setThemeName(request, response, sysUser.getTableSink());	
//		}
		
		//themeResolver.setThemeName(request,response,"red");
		//log.info("current theme change to " +themeResolver.resolveThemeName(request));
		
		//Cookie themecookie=new Cookie(CookieThemeResolver.DEFAULT_COOKIE_NAME, theme);
		//themecookie.setMaxAge(1200);
		//themecookie.setPath("/Manager/");
 		//response.addCookie(themecookie);
 		 
//        SysSystemInfo systeminfo=new SysSystemInfo();
//		
//		QueryPara<SysSystemInfo> qp=new QueryPara<SysSystemInfo>();
//		qp.setClazz(SysSystemInfo.class);			
//		//SystemInfoService systemInfoService=new SystemInfoServiceImpl();
//		List<SysSystemInfo> list=this.systemInfoService.getListForPage(qp);
//		if(qp.getRecordcount()==0)
//		{			
//			this.systemInfoService.saveOrUpdate(systeminfo);
//		}
//		else
//		{
//			systeminfo=list.get(0);
//		}
		
		//SysSystemInfo systeminfo=this.systemInfoService.selectByPrimaryKey(1);
		SysSystemInfo systeminfo=this.systemInfoService.getUniqueResult();
		modelMap.addAttribute("FrameName", systeminfo.getSname());
		modelMap.addAttribute("FrameNameVer",systeminfo.getSversion());		
		modelMap.addAttribute("MenuStyle", 1);
		return "Manager/Default";
	}
	//forward
	@RequestMapping(value={"/left"},method=GET)
	public String left(			
			ModelMap modelMap) 
	{		
		//List<SysApplication> list=this.applicationsService.selectAllRecord();
		//modelMap.addAttribute("menu", list);
		//转移
//		List<SysModule> list_parentModule=this.sysModuleService.selectParentModules();
//		modelMap.addAttribute("module", list_parentModule);
		
//		if(list_parentModule.size()>0)
//		{
//			Iterator<SysModule> it=list_parentModule.iterator();  
//			SysModule sysModule=null;
//			while(it.hasNext())
//			{
//				sysModule=(SysModule)it.next();
//				System.out.println("编号："+sysModule.getModuleId());
//				System.out.println("父编号："+sysModule.getMparentId());
//				System.out.println("模块名称："+sysModule.getMcname());
//				System.out.println("应用ID："+sysModule.getMapplicationId());
//				System.out.println("模块代号："+sysModule.getMpageCode());
//				System.out.println("子模块数："+sysModule.getSubsysModules().size());
//				if(sysModule.getSubsysModules().size()>0)
//				{
//					Iterator<SysModule> it2=sysModule.getSubsysModules().iterator();
//					SysModule subsysModule=null;
//					while(it2.hasNext())
//					{
//						subsysModule=(SysModule)it2.next();
//						System.out.println("--编号："+subsysModule.getModuleId());
//						System.out.println("--父编号："+subsysModule.getMparentId());
//						System.out.println("--模块名称："+subsysModule.getMcname());
//						System.out.println("--应用ID："+subsysModule.getMapplicationId());
//						System.out.println("--模块代号："+subsysModule.getMpageCode());						
//					}
//					
//					
//				}
//				System.out.println("------------------------");
//			}			
//		}
		return "forward:/Manager/Module/FrameWork/SystemApp/ModuleManager/left";		
	}
	@RequestMapping(value={"/module"},method=GET)
	public void leftf(			
			ModelMap modelMap) 
	{		
//		SysModulePK comp_id=new SysModulePK();
//		comp_id.setMapplicationId(3);
//		comp_id.setMpageCode("H00");
		
		SysModule sysModule=this.sysModuleService.selectSysModuleByPrimaryKey(27);
		
		System.out.println("编号："+sysModule.getModuleId());
		System.out.println("父编号："+sysModule.getMparentId());
		System.out.println("模块名称："+sysModule.getMcname());
		System.out.println("应用ID："+sysModule.getMapplicationId());
		System.out.println("模块代号："+sysModule.getMpageCode());
		System.out.println("子模块数："+sysModule.getSubsysModules().size());
		
		if(sysModule.getSubsysModules().size()>0)
		{
			Iterator<SysModule> it2=sysModule.getSubsysModules().iterator();
			SysModule subsysModule=null;
			while(it2.hasNext())
			{
				subsysModule=(SysModule)it2.next();
				System.out.println("--编号："+subsysModule.getModuleId());
				System.out.println("--父编号："+subsysModule.getMparentId());
				System.out.println("--模块名称："+subsysModule.getMcname());
				System.out.println("--应用ID："+subsysModule.getMapplicationId());
				System.out.println("--模块代号："+subsysModule.getMpageCode());						
			}
		}
	}
	//forward
	@RequestMapping(value={"/right"},method=GET)
	public String right(			
			@CookieValue(value="Subject",defaultValue="") String cookiesvalue,
			HttpServletResponse response,
			ModelMap model) 
	{
		
//		log.info("取出Subject:"+cookiesvalue);
//		if(!StringUtils.hasLength(cookiesvalue))
//		{
//			return "redirect:"+LOGIN_NAME;
//		}
//		//String key = "faydrian";
//		try {
//			cookiesvalue=DESPlus.decrypt(cookiesvalue,KEY);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		log.info("取出解密后Subject:"+cookiesvalue);
//		String[] cookiearr=cookiesvalue.split("\\|");
//		System.out.println("cookieValues.length："+cookiearr.length);
//		if(cookiearr.length!=3)
//		{
//			System.out.println("进入here");
//			return "redirect:"+LOGIN_NAME;
//		}
//		
//		long validTimeInCookie = new Long(cookiearr[1]);
//		System.out.println("validTimeInCookie："+validTimeInCookie);
//		System.out.println("currentTimeMillis:"+System.currentTimeMillis());
//		if(validTimeInCookie < System.currentTimeMillis()){
//			Cookie cookie=new Cookie("Subject",null);
//			cookie.setMaxAge(0);
//			cookie.setPath("/Manager/"); 
//			response.addCookie(cookie);
//			return "redirect:"+LOGIN_NAME;		
//		}
		
		
//		SysSystemInfo systeminfo=this.systemInfoService.selectByPrimaryKey(1);		
//		
//		model.addAttribute("sysinfo", systeminfo);		
//		return "Manager/right";	
		return "forward:/Manager/Module/FrameWork/SystemMaintenance/SystemConfig/right";
	}
	@RequestMapping(value={"/UserSet"},method=GET)
	public String userset(			
			ModelMap model)
	{		
		return "forward:/Manager/Module/FrameWork/SystemApp/UserManager/UserSet";
	}
	@RequestMapping(value={"/UserSet"},method=POST)
	public String usersetpost(			
			ModelMap model)
	{		
		return "forward:/Manager/Module/FrameWork/SystemApp/UserManager/UserSet";
	}
	
	
}
