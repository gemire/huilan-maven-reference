package com.hedgehog.outletss.controller.Manager;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hedgehog.outletss.domain.MessageBox;
import com.hedgehog.outletss.domain.sys_NavigationUrl;
import com.hedgehog.outletss.domain.MessageBox.Icon_Type;
import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.sys_NavigationUrl.UrlType;
import com.hedgehog.outletss.domain.SysApplication;
import com.hedgehog.outletss.domain.SysUser;
import com.hedgehog.outletss.service.SysApplicationsService;

@Controller
@RequestMapping("/Manager/Module/FrameWork/SystemApp/AppManager")
public class AppManagerController {
	//private static final String LOGIN_NAME = "/Manager/Login";
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
	@RequestMapping(value={"/Manager"},method=RequestMethod.GET,params="cmd=new")
	public String listadd(			
			ModelMap modelMap) 
	{	
		SysApplication app=new SysApplication();
		modelMap.addAttribute("app", app);
		return "AppManager/Manager";
	}
	@RequestMapping(value={"/Manager"},method=RequestMethod.POST,params="cmd=new")
	public String listaddpost(
			@RequestParam(value="IDX", defaultValue="0") int applicationId,
			@ModelAttribute("app") @Valid SysApplication app,			
			BindingResult result,
			RedirectAttributes redirectAttributes) 
	{	
		if(result.hasErrors())
		{
			return "AppManager/Manager";
		}
		//System.out.println("order:"+app.getAorder());
		this.applicationsService.saveOrUpdate(app);
		
		MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("增加应用ID("+applicationId+")成功!");
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/SystemApp/AppManager/List","点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
    	return "redirect:/Manager/Message";		
		//return "redirect:List";
	}
	@RequestMapping(value={"/Manager"},method=RequestMethod.GET,params="cmd=edit")
	public String listedit(
			@RequestParam(value="IDX") int applicationId,
			ModelMap modelMap) 
	{	
		SysApplication app=this.applicationsService.selectByPrimaryKey(applicationId);
		modelMap.addAttribute("app", app);
		return "AppManager/Manager";
	}
	@RequestMapping(value={"/Manager"},method=RequestMethod.POST,params="cmd=edit")
	public String listeditpost(
			@RequestParam(value="IDX") int applicationId,
			@ModelAttribute("app") @Valid SysApplication app,			
			BindingResult result,
			RedirectAttributes redirectAttributes) 
	{	
		SysApplication app1=this.applicationsService.selectByPrimaryKey(applicationId);
		BeanUtils.copyProperties(app, app1,new String[]{"applicationId","aorder"});
		this.applicationsService.saveOrUpdate(app1);
		
		MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("修改应用ID("+applicationId+")成功!");
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/SystemApp/AppManager/List","点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
    	return "redirect:/Manager/Message";		
		//return "redirect:List";
	}
	@RequestMapping(value={"/Manager"},method=RequestMethod.GET,params="cmd=del")
	public String listdel(
			@RequestParam(value="IDX") int applicationId,
			RedirectAttributes redirectAttributes
			) 
	{	
		this.applicationsService.deleteByPrimaryKey(applicationId);
		
		MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("删除记录ID:("+applicationId+")成功");
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/SystemApp/AppManager/List","点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);
		redirectAttributes.addFlashAttribute("mbx", MBx);
		//redirectAttributes.addFlashAttribute("rawlurl", "/Manager/Module/FrameWork/SystemMaintenance/UserManager/List");
    	//return "redirect:/Manager/message";
    	return "redirect:/Manager/Message";		
	}
	@RequestMapping(value={"/Orderby"},method=RequestMethod.GET)
	public String listorderby(			
			ModelMap modelMap) 
	{
		List<SysApplication> list=this.applicationsService.selectAllRecord();
		modelMap.addAttribute("list", list);
		return "AppManager/Orderby";
	}
	@RequestMapping(value={"/Orderby"},method=RequestMethod.POST)
	public String listorderbypost(
			@RequestParam(value="OrderByListItems") String OrderByListItems,
			RedirectAttributes redirectAttributes) 
	{
		System.out.println("输出值："+OrderByListItems);
		if(OrderByListItems.length()>0)
		{
			StringTokenizer st = new StringTokenizer(OrderByListItems, ",");
			
			SysApplication app=null;
			int order=0;
			while(st.hasMoreTokens())
			{
				order++;
				//System.out.println("循环输出"+st.nextToken());
				app= this.applicationsService.selectByPrimaryKey(Integer.valueOf(st.nextToken()));
				app.setAorder(order);
				this.applicationsService.saveOrUpdate(app);
			}		
		}
		StringBuffer sb=new StringBuffer();
		//StringBuilder sb = new StringBuilder();
        sb.append("<script language=javascript>");
        sb.append("window.parent.leftbody.location.reload();");
        sb.append("</script>");
		
        MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("排序应用成功!");
		MBx.set_M_ReturnScript(sb.toString());
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/SystemApp/AppManager/List","点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
    	return "redirect:/Manager/Message";		
		//return "redirect:List";
	}
}
