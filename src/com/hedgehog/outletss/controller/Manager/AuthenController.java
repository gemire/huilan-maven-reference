package com.hedgehog.outletss.controller.Manager;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/Manager")
public class AuthenController {
	@RequestMapping(value={"/login"},method=RequestMethod.GET)
	public String login(ModelMap modelMap)
	{
		//modelMap.addAttribute("user", new User());
		return "Manager/login";
	}
}
