package com.hedgehog.outletss.controller.Manager;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	  return "Manager/sessionTimeout"; 
	}
}
