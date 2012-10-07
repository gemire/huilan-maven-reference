package com.hedgehog.outletss.controller.Manager;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hedgehog.outletss.domain.MessageBox;
import com.hedgehog.outletss.domain.sys_NavigationUrl;
import com.hedgehog.outletss.domain.MessageBox.Icon_Type;
import com.hedgehog.outletss.domain.sys_NavigationUrl.UrlType;
import com.hedgehog.outletss.domain.SysSystemInfo;
import com.hedgehog.outletss.domain.SysUser;
import com.hedgehog.outletss.service.SysSystemInfoService;


@Controller
@RequestMapping("/Manager/Module/FrameWork/SystemMaintenance/SystemConfig")
public class SystemConfigController {
	private static final String LOGIN_NAME = "/Manager/Login";
	private SysSystemInfoService systemInfoService;
	@Inject
	public SystemConfigController(SysSystemInfoService systemInfoService) {		
		this.systemInfoService = systemInfoService;
	}	
	
	@RequestMapping(value={"/Default"},method=GET)
	public String right(			
			ModelMap modelMap) 
	{
		modelMap.addAttribute("sysinfo", this.systemInfoService.getUniqueResult());
		return "SystemConfig/Default";		
	}
	
	@RequestMapping(value={"/Manager"},method=GET,params="cmd=edit")
	public String rightfgh(			
			ModelMap modelMap) 
	{		
		modelMap.addAttribute("sysinfo", this.systemInfoService.getUniqueResult());
		return "SystemConfig/Manager";		
	}
	@RequestMapping(value={"/Manager"},method=POST,params="cmd=edit")
	public String rightfghfg(			
			@ModelAttribute("sysinfo") @Valid SysSystemInfo systeminfo,
			BindingResult result,
			RedirectAttributes redirectAttributes) 
	{
		
		if(result.hasErrors())
		{
			return "SystemConfig/Manager";	
		}
		SysSystemInfo sysinfo=this.systemInfoService.getUniqueResult();
		BeanUtils.copyProperties(systeminfo, sysinfo,new String[]{"systemId","ssystemConfigData","slicensed"});
		this.systemInfoService.saveOrUpdate(sysinfo);
		//model.put("sysinfo", this.systemInfoService.selectByPrimaryKey(1));
		MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("修改环境配置成功!");
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/SystemApp/SystemConfig/Default","点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
    	return "redirect:/Manager/Message";		
		//return "redirect:Default";
	}	
	
	@RequestMapping(value={"/right"},method=GET)
	public String righth(			
			ModelMap model) 
	{		
		//HttpServletResponse response,
        //SysSystemInfo systeminfo=this.systemInfoService.selectByPrimaryKey(1);	
        SysSystemInfo systeminfo=this.systemInfoService.getUniqueResult();
		model.addAttribute("sysinfo", systeminfo);		
		return "Manager/right";		
	}
}
