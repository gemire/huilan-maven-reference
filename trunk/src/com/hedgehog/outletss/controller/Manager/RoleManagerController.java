package com.hedgehog.outletss.controller.Manager;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hedgehog.outletss.Utils.EncryptUtil;
import com.hedgehog.outletss.domain.MessageBox;
import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.SysApplication;
import com.hedgehog.outletss.domain.SysRole;
import com.hedgehog.outletss.domain.SysRolePermission;
import com.hedgehog.outletss.domain.SysUser;
import com.hedgehog.outletss.domain.sys_NavigationUrl;
import com.hedgehog.outletss.domain.MessageBox.Icon_Type;
import com.hedgehog.outletss.domain.sys_NavigationUrl.UrlType;
import com.hedgehog.outletss.service.SysApplicationsService;
import com.hedgehog.outletss.service.SysRolePermissionService;
import com.hedgehog.outletss.service.SysRoleService;

@Controller
@RequestMapping("/Manager/Module/FrameWork/SystemApp/RoleManager")
public class RoleManagerController {
	private static final String LOGIN_NAME = "/Manager/Login";
	private SysRoleService sysRoleService;
	@Autowired
	public void setSysRoleService(SysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}
	private SysApplicationsService applicationsService;
	@Autowired
	public void setApplicationsService(SysApplicationsService applicationsService) {
		this.applicationsService = applicationsService;
	}
	private SysRolePermissionService rolePermissionService;
	@Autowired
	public void setRolePermissionService(
			SysRolePermissionService rolePermissionService) {
		this.rolePermissionService = rolePermissionService;
	}
	
	@InitBinder  
    public void initBinder(WebDataBinder binder) {  
		//System.out.println("��ľ�е�������");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        dateFormat.setLenient(false); 
        //binder.registerCustomEditor(requiredType, field, propertyEditor)
        
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false)); 
//        binder.registerCustomEditor(String[].class, "pvalue", new PropertyEditorSupport()
//        {
//        	
//        	public void setValue(Object value)
//        	{
//        		String[] strarr=(String[])value;
//        		for(String str:strarr)
//        		{
//        			System.out.println("�������"+str);
//        		}        		
//        	}
//        }
//        );
    }  
	@RequestMapping(value={"/RoleList"},method=RequestMethod.GET)
	public String list(				
			@RequestParam(value="page", defaultValue="1") int page,
	        @RequestParam(value="perPage", defaultValue="30") int perPage,		
			ModelMap modelMap) 
	{		
		QueryPara<SysRole> qp=new QueryPara<SysRole>();
		qp.setClazz(SysRole.class);		
		qp.setPagesize(perPage);
		qp.setPageNo(page);
		modelMap.put("rolelist", this.sysRoleService.selectRecordForPage(qp));
		modelMap.put("QueryPara", qp);	
		return "RoleManager/RoleList";
	}
	@RequestMapping(value={"/RoleManager"},method=RequestMethod.GET,params="cmd=new")
	public String RoleManager(				
			ModelMap modelMap) 
	{		
		SysRole sysRole=new SysRole();
		modelMap.addAttribute("sysRole", sysRole);
		return "RoleManager/RoleManager";
	}
	@RequestMapping(value={"/RoleManager"},method=RequestMethod.POST,params="cmd=new")
	public String RoleManagerPost(
			@RequestParam(value="roleid",defaultValue="0") int roleId,
			@ModelAttribute("sysRole") @Valid SysRole sysRole,
			BindingResult result,
			RedirectAttributes redirectAttributes) 
	{		
		if(result.hasErrors())
		{
			return "RoleManager/RoleManager";
		}
		sysRole.setRuserId(1);
		this.sysRoleService.saveOrUpdate(sysRole);
		
		MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("增加角色ID("+roleId+")成功!");
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/SystemApp/RoleManager/RoleList","点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
    	return "redirect:/Manager/Message";		
		
		//return "redirect:RoleList";
	}
	@RequestMapping(value={"/RoleManager"},method=RequestMethod.GET,params="cmd=edit")
	public String RoleManagerput(				
			@RequestParam(value="roleid") int roleId,	    
			ModelMap modelMap) 
	{			
		SysRole sysRole=this.sysRoleService.selectByPrimaryKey(roleId);
		modelMap.addAttribute("sysRole", sysRole);
		return "RoleManager/RoleManager";
	}
	@RequestMapping(value={"/RoleManager"},method=RequestMethod.POST,params="cmd=edit")
	public String RoleManagerputpost(				
			@RequestParam(value="roleid") int roleId,
			@ModelAttribute("sysRole") @Valid SysRole sysRole,
			BindingResult result,
			RedirectAttributes redirectAttributes) 
	{			
		if(result.hasErrors())
		{
			return "RoleManager/RoleManager";
		}
		SysRole sysRole1=this.sysRoleService.selectByPrimaryKey(roleId);
		//from target
		BeanUtils.copyProperties(sysRole,sysRole1, new String[]{"roleId","ruserId"});
		this.sysRoleService.saveOrUpdate(sysRole1);
		
		MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("修改角色ID("+roleId+")成功!");
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/SystemApp/RoleManager/RoleList","点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
    	return "redirect:/Manager/Message";		
		//return "redirect:RoleList";
	}
	@RequestMapping(value={"/RoleManager"},method=RequestMethod.GET,params="cmd=del")
	public String RoleManagerputdel(				
			@RequestParam(value="roleid") int roleId,	    
			RedirectAttributes redirectAttributes) 
	{			
		this.sysRoleService.deleteByPrimaryKey(roleId);
		
		MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("删除角色ID("+roleId+")成功!");
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/SystemApp/RoleManager/RoleList","点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
    	return "redirect:/Manager/Message";	
	}
	
	@RequestMapping(value={"/RolePermissionManager"},method=RequestMethod.GET)
	public String RolePermissionManager(				
			@RequestParam(value="RoleID") int roleId,
			@RequestParam(value="ApplicationID") int applicationid,			
			ModelMap modelMap) 
	{		
		SysRole sysRole=this.sysRoleService.selectByPrimaryKey(roleId);
		modelMap.addAttribute("sysRole", sysRole);
		
		SysApplication sysApplication=this.applicationsService.selectByPrimaryKey(applicationid);
		modelMap.addAttribute("app", sysApplication);
		//Map<String, int> diclist = new Hashtable<String, int>();   //����Ȩ��
		//Dictionary<String, Integer> diclist = new Hashtable<String, Integer>();
		
//		Map<String,Integer> diclist=new LinkedHashMap<String,Integer>();
//        String[] funcation = new String[] { "头条[h]", "推荐[c]", "幻灯[f]", "特荐[a]", "滚动[s]", "加粗[b]", "图片[p]", "跳转[j]" };
//        for (int i = 0; i < funcation.length; i++)
//        {
//        	int value=(int)Math.pow(2, i);
//            //diclist.Add(funcation[i], value);
//        	diclist.put(funcation[i], value);
//        }
//        modelMap.addAttribute("funcation", diclist);
        List<SysRolePermission> rplist=this.rolePermissionService.selectAllRecord();
        modelMap.addAttribute("rplist", rplist);
		return "RoleManager/RolePermissionManager";
	}
	@RequestMapping(value={"/RolePermissionManager"},method=RequestMethod.GET,params="cmd=edit")
	public String RolePermissionManagerget(				
			@RequestParam(value="permissionId") int permissionId,					
			ModelMap modelMap) 
	{		
		//Map<String, int> diclist = new Hashtable<String, int>();   //����Ȩ��
		//Dictionary<String, Integer> diclist = new Hashtable<String, Integer>();
		
		Map<Integer,String> diclist=new LinkedHashMap<Integer,String>();
		String[] funcation = new String[] { "查看", "新增", "修改", "删除", "排序", "打印", "备用A", "备用B" };
        for (int i = 0; i < funcation.length; i++)
        {
        	int value=(int)Math.pow(2, i+1);
            //diclist.Add(funcation[i], value);
        	diclist.put(value,funcation[i]);
        }
        modelMap.addAttribute("funcation", diclist);
		SysRolePermission rolePermission=this.rolePermissionService.selectByPrimaryKey(permissionId);
		
		List<Integer> list=new ArrayList<Integer>();
		//StringBuffer sb=new StringBuffer();
		int pvalue=rolePermission.getPvalue();
		Iterator<Map.Entry<Integer,String>> iter = diclist.entrySet().iterator(); 
		while (iter.hasNext()) { 
		    Map.Entry<Integer,String> entry = (Map.Entry<Integer,String>)iter.next(); 
		    if((pvalue&entry.getKey())==entry.getKey())
		    {
		    	list.add(entry.getKey());
		    }
		    //Object key = entry.getKey(); 
		    //Object val = entry.getValue(); 
		} 
		
		rolePermission.setArraystr(list);
        
        modelMap.addAttribute("rp", rolePermission);
		return "RoleManager/RolePermissionForm";
	}
	@RequestMapping(value={"/RolePermissionManager"},method=RequestMethod.POST,params="cmd=edit")
	public String RolePermissionManagerpost(				
			@RequestParam(value="permissionId") int permissionId,
			@ModelAttribute("rp") @Valid SysRolePermission rolePermission,
			BindingResult result,
			ModelMap modelMap) 
	{
		
		if(result.hasErrors())
		{
			return "RoleManager/RolePermissionForm";
		}
		List<Integer> list=rolePermission.getArraystr();
		int pvalue=0;
		if(list.size()>0)
		{
			for(Integer i:list)
			{
				pvalue=pvalue+i;
			}
		}
		rolePermission.setPvalue(pvalue);
		//��δ��ֵ
		this.rolePermissionService.saveOrUpdate(rolePermission);
		//System.out.println("Ȩ��ֵ��"+pvalue);
		//System.out.println("ִ�е�������:"+rolePermission.getPvalue());
		return "redirect:RolePermissionManager?RoleID=1&ApplicationID=3";
	}
}
