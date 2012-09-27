package com.hedgehog.outletss.controller.Manager;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hedgehog.outletss.Utils.QueryPara;
import com.hedgehog.outletss.domain.SysApplication;
import com.hedgehog.outletss.domain.SysModule;
import com.hedgehog.outletss.domain.SysUser;
import com.hedgehog.outletss.service.SysApplicationsService;
import com.hedgehog.outletss.service.SysModuleService;

@Controller 
@RequestMapping("/Manager/Module/FrameWork/SystemApp/ModuleManager")
public class ModuleManagerController {
	private SysApplicationsService applicationsService;
	@Inject
	  public ModuleManagerController(SysApplicationsService applicationsService) {
	    this.applicationsService = applicationsService;
	  }
	private SysModuleService sysModuleService;
	@Autowired 
	public void setSysModuleService(SysModuleService sysModuleService) {
		this.sysModuleService = sysModuleService;
	}
	@RequestMapping(value={"/List"},method=RequestMethod.GET)
	public String list(			
			ModelMap modelMap) 
	{
		
//		QueryPara<SysApplication> qp=new QueryPara<SysApplication>();
//		qp.setClazz(SysApplication.class);
//		qp.setPageNo(page);
//		qp.setPagesize(perPage);
//		List<SysApplication> list=this.applicationsService.selectAppForPage(qp);
//		modelMap.addAttribute("list", list);
//		modelMap.addAttribute("QueryPara", qp);
		List<SysApplication> list=this.applicationsService.selectAllRecord();
		modelMap.addAttribute("list", list);
		return "ModuleManager/List";
	}
	
	@RequestMapping(value={"/ModuleList"},method=RequestMethod.GET)
	public String ModuleList(			
			@RequestParam(value="S_ID") int S_ID,
			@RequestParam(value="ModuleId",defaultValue="0") int mparentId,				
			ModelMap modelMap) 
	{
		
		//@RequestParam(value="AppName") String AppName,
		SysApplication sysApplication=this.applicationsService.selectByPrimaryKey(S_ID);
		//modelMap.addAttribute("sysApplication", sysApplication);
		modelMap.addAttribute("S_ID", S_ID);
		modelMap.addAttribute("ModuleId", mparentId);
		modelMap.addAttribute("AppName", sysApplication.getAappName());
		
		//SysModule sysModule=new SysModule();
		//sysModule.setMapplicationId(S_ID);		
		
		//子模块列表
		//List<SysModule> sysModules=this.sysModuleService.selectSubModulesByParentId(S_ID, mparentId);
		modelMap.addAttribute("childmodule", sysApplication.getChildsysModules());
		//modelMap.addAttribute("childmodule", sysModules);
		return "ModuleManager/ModuleList";
	}
	
	@RequestMapping(value={"/ModuleManager"},method=RequestMethod.GET,params="cmd=new")
	public String moduleManager(			
			@RequestParam(value="S_ID") int S_ID,
			@RequestParam(value="mparentId",defaultValue="0") int mparentId,
			ModelMap modelMap) 
	{
		
		SysApplication sysApplication=this.applicationsService.selectByPrimaryKey(S_ID);
		modelMap.addAttribute("sysApplication", sysApplication);
		
		SysModule sysModule=new SysModule();
		sysModule.setMapplicationId(S_ID);
		sysModule.setSysApplication(sysApplication);
		sysModule.setMparentId(mparentId);//GetModuleTitle(sysModule)函数调用
		if(mparentId!=0)
		{
			SysModule parentModule=this.sysModuleService.selectSysModuleByPrimaryKey(mparentId);			
			sysModule.setParentSysModule(parentModule);	
			//System.out.println("父级模块："+sysModule.getParentSysModule().getMcname());
		}		
		modelMap.addAttribute("sysModule", sysModule);
		modelMap.addAttribute("nav", GetModuleTitle(sysModule));
		//子模块列表 mparentId=0
		List<SysModule> sysModules=this.sysModuleService.selectSubModulesByParentId(S_ID, mparentId);
		modelMap.addAttribute("sysModules", sysModules);		
		return "ModuleManager/ModuleManager";
	}
	@RequestMapping(value={"/ModuleManager"},method=RequestMethod.POST,params="cmd=new")
	public String moduleManageradd(				
			@RequestParam(value="S_ID") int S_ID,
			@RequestParam(value="mparentId",defaultValue="0") int mparentId,
			@ModelAttribute("sysModule") @Valid SysModule sysModule,
			BindingResult result,
			ModelMap modelMap) 
	{
		
		if(result.hasErrors())
		{
			return "ModuleManager/ModuleManager";
		}
		//sysModule.setModuleId(null);
		//sysModule.setMapplicationId(S_ID);//所属应用(默认已经赋值)
		//sysModule.setMparentId(mparentId);// 父级模块(默认已经赋值 post和get参数 都有)
		this.sysModuleService.saveOrUpdate(sysModule);
		return "redirect:ModuleList?S_ID="+String.valueOf(S_ID);
//		if(sysModule.getMparentId()==0)
//		{
//			return "redirect:ModuleList?S_ID="+String.valueOf(S_ID);
//		}
//		return "redirect:ModuleManager?cmd=edit&S_ID="+String.valueOf(S_ID+"&ModuleId="+String.valueOf(mparentId));
	}
	@RequestMapping(value={"/ModuleManager"},method=RequestMethod.GET,params="cmd=edit")
	public String moduleManageredit(			
			@RequestParam(value="S_ID") int S_ID,
			@RequestParam(value="ModuleId",defaultValue="0") int ModuleId,
			ModelMap modelMap) 
	{		
		
		//SysModule sysModule=new SysModule();
		SysApplication sysApplication=this.applicationsService.selectByPrimaryKey(S_ID);
		modelMap.addAttribute("sysApplication", sysApplication);
		//sysModule.setSysApplication(sysApplication);
		//System.out.println("模块编号："+mparentId);
		SysModule parentModule=this.sysModuleService.selectSysModuleByPrimaryKey(ModuleId);
		if(parentModule.getMparentId()==0)
		{
			//modelMap.addAttribute("currentsysModule", parentModule);
			parentModule.setParentSysModule(null);
		}
		modelMap.addAttribute("currentsysModule", parentModule);
		//SysModule ppsysModule=parentModule.getParentSysModule();
		//System.out.println("父模块名称："+ppsysModule.getMcname());
		//System.out.println("模块代码："+parentModule.getMpageCode());
		//sysModule.setParentSysModule(parentModule);
		modelMap.addAttribute("sysModule", parentModule);
		modelMap.addAttribute("nav", GetModuleTitle(parentModule));
		//子模块列表 mparentId=0
		List<SysModule> sysModules=this.sysModuleService.selectSubModulesByParentId(S_ID, ModuleId);
		modelMap.addAttribute("sysModules", sysModules);
		
		return "ModuleManager/ModuleManager";
	}
	
	@RequestMapping(value={"/ModuleManager"},method=RequestMethod.POST,params="cmd=edit")
	public String moduleManagereditpost(			
			@RequestParam(value="S_ID") int S_ID,
			@RequestParam(value="ModuleId",defaultValue="0") int ModuleId,
			@ModelAttribute("sysModule") @Valid SysModule sysModule,
			BindingResult result,
			ModelMap modelMap) 
	{
		
		if(result.hasErrors())
		{
			return "ModuleManager/ModuleManager";
		}
		//System.out.println("正在修改的模块ID："+sysModule.getModuleId());
		SysModule sModule=this.sysModuleService.selectSysModuleByPrimaryKey(ModuleId);
		BeanUtils.copyProperties(sysModule,sModule,new String[]{"moduleId","mapplicationId","mparentId"});
		this.sysModuleService.saveOrUpdate(sModule);
		return "redirect:ModuleList?S_ID="+String.valueOf(S_ID);
//		if(sModule.getMparentId()==0)
//		{
//			return "redirect:ModuleList?S_ID="+String.valueOf(S_ID);
//		}
//		
//		return "redirect:ModuleManager?cmd=edit&S_ID="+String.valueOf(S_ID)+"&ModuleId="+String.valueOf(sModule.getMparentId());
	}
	@RequestMapping(value={"/ModuleManager"},method=RequestMethod.GET,params="cmd=del")
	public String moduleManagerdel(				
			@RequestParam(value="S_ID") int S_ID,
			@RequestParam(value="ModuleId",defaultValue="0") int ModuleId,			
			ModelMap modelMap) 
	{
		
		//SysModule sModule=this.sysModuleService.selectSysModuleByPrimaryKey(ModuleId);
		//int temp=sModule.getMparentId();
		//System.out.println("正在删除的模块ID："+ModuleId);
		//System.out.println("正在删除的模块的父模块ID："+temp);
		this.sysModuleService.deleteByPrimaryKey(ModuleId);
		
		return "redirect:ModuleList?S_ID="+String.valueOf(S_ID);
//		if(temp==0)
//		{
//			return "redirect:ModuleList?S_ID="+String.valueOf(S_ID);
//		}
//		return "redirect:ModuleManager?cmd=edit&S_ID="+String.valueOf(S_ID)+"&ModuleId="+String.valueOf(temp);
		
	}
	@RequestMapping(value={"/left"},method=GET)
	public String left(			
			ModelMap modelMap) 
	{
		
		List<SysModule> list_parentModule=this.sysModuleService.selectParentModules();
		modelMap.addAttribute("module", list_parentModule);
		return "Manager/left";	
	}
	private String GetModuleTitle(SysModule sysModule)
	{
		StringBuffer sb=new StringBuffer();
		if(sysModule.getMparentId()!=0)
		{
			sb.append(GetModuleTitle(sysModule.getParentSysModule())+"&gt;<a href='ModuleManager?cmd=edit&S_ID="+sysModule.getMapplicationId()+"&ModuleId="+sysModule.getParentSysModule().getModuleId()+"'>"+sysModule.getParentSysModule().getMcname()+"</a>");
		}
		return sb.toString();
	}

}
