package com.hedgehog.outletss.controller.Manager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hedgehog.outletss.domain.MessageBox;
import com.hedgehog.outletss.domain.sys_NavigationUrl;
import com.hedgehog.outletss.domain.MessageBox.Icon_Type;
import com.hedgehog.outletss.domain.sys_NavigationUrl.UrlType;
import com.hedgehog.outletss.domain.SysSystemInfo;
import com.hedgehog.outletss.service.SysSystemInfoService;


@Controller
@RequestMapping("/Manager")
public class AuthenController {
	
	private SysSystemInfoService systemInfoService;
	@Inject
	public AuthenController(SysSystemInfoService systemInfoService) {		
		this.systemInfoService = systemInfoService;
	}
	@RequestMapping(value={"/Login"},method=RequestMethod.GET)
	public String login(ModelMap modelMap)
	{
		SysSystemInfo systeminfo=this.systemInfoService.getUniqueResult();
		modelMap.addAttribute("systeminfo", systeminfo);
		
		//modelMap.addAttribute("user", new User());
		return "Manager/login";
	}	
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap modelMap) {
		SysSystemInfo systeminfo=this.systemInfoService.getUniqueResult();
		modelMap.addAttribute("systeminfo", systeminfo);
 
		modelMap.addAttribute("error", "true");
		return "Manager/login";
 
	}
	@RequestMapping(value="/accessDenied", method = RequestMethod.GET)
	public String logidnerror(ModelMap modelMap) {
	  return "Manager/accessDenied"; 
	}
	
	@RequestMapping(value="/sessionTimeout", method = RequestMethod.GET)
	public String logidsnerror(ModelMap modelMap) {
		 MessageBox MBx = new MessageBox();
         MBx.set_M_Type(2);
         MBx.set_M_Title("没有登陆!");
         MBx.set_M_IconType(Icon_Type.Error);
         MBx.set_M_Body("您与系统的连接已经超时，请重新登陆！");
         List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
         sys_NavigationUrl nav=new sys_NavigationUrl("返回","Manager/Main",null,UrlType.Href,true);
 		 buttonList.add(nav);
         MBx.set_M_ButtonList(buttonList);
		modelMap.addAttribute("mbx", MBx);
		return "Manager/Messages"; 
	  //return "Manager/sessionTimeout"; 
	}
}
