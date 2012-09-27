package com.hedgehog.outletss.controller.Manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hedgehog.outletss.domain.SysUser;

@Controller
@RequestMapping("/Manager/Module/FrameWork/SystemApp/GroupManager")
public class GroupManagerController {
	private static final String LOGIN_NAME = "/Manager/Login";
	
	@RequestMapping(value={"/Frame"},method=RequestMethod.GET)
	public String list(			
			ModelMap modelMap) 
	{
		
		return "GroupManager/Frame";
	}

}
