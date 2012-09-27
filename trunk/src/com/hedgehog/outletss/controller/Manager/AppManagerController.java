package com.hedgehog.outletss.controller.Manager;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.Valid;

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

import com.hedgehog.outletss.Utils.QueryPara;
import com.hedgehog.outletss.domain.SysApplication;
import com.hedgehog.outletss.domain.SysUser;
import com.hedgehog.outletss.service.SysApplicationsService;

@Controller
@RequestMapping("/Manager/Module/FrameWork/SystemApp/AppManager")
public class AppManagerController {
	private static final String LOGIN_NAME = "/Manager/Login";
	private SysApplicationsService applicationsService;
	@Inject
	  public AppManagerController(SysApplicationsService applicationsService) {
	    this.applicationsService = applicationsService;
	  }
	
	@RequestMapping(value={"/List"},method=RequestMethod.GET)
	public String list(			
			@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="perPage", defaultValue="20") int perPage,
			ModelMap model) 
	{			
		QueryPara<SysApplication> qp=new QueryPara<SysApplication>();
		qp.setClazz(SysApplication.class);
		qp.setPageNo(page);
		qp.setPagesize(perPage);
		List<SysApplication> list=this.applicationsService.selectAppForPage(qp);
		model.addAttribute("list", list);
		model.addAttribute("QueryPara", qp);
//		List<SysApplication> list=this.applicationsService.selectAllRecord();
//		model.addAttribute("list", list);
		//return "Manager/Module/FrameWork/SystemApp/AppManager/List";
		return "AppManager/List";
	}
}
