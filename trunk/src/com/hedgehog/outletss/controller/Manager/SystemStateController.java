package com.hedgehog.outletss.controller.Manager;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Properties; 

@Controller
@RequestMapping("/Manager/Module/FrameWork/SystemMaintenance/SystemState")
public class SystemStateController {
	@RequestMapping(value={"/Default"},method=GET)
	public String right(			
			ModelMap modelMap) 
	{	
		Properties props=System.getProperties(); //获得系统属性集  
		modelMap.addAttribute("props", props);
		return "SystemState/Default";		
	}

}
