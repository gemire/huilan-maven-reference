package com.hedgehog.outletss.controller.Manager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hedgehog.outletss.domain.BizNew;
import com.hedgehog.outletss.domain.MessageBox;
import com.hedgehog.outletss.domain.SysApplication;
import com.hedgehog.outletss.domain.SysGroup;
import com.hedgehog.outletss.domain.SysUser;
import com.hedgehog.outletss.domain.sys_NavigationUrl;
import com.hedgehog.outletss.domain.MessageBox.Icon_Type;
import com.hedgehog.outletss.domain.sys_NavigationUrl.UrlType;
import com.hedgehog.outletss.service.SysGroupService;

@Controller
@RequestMapping("/Manager/Module/FrameWork/SystemApp/GroupManager")
public class GroupManagerController {
	private static final String LOGIN_NAME = "/Manager/Login";
	private static final Integer root_ID = 2;
	private SysGroupService sysGroupService;
	@Autowired	
	public void setSysGroupService(SysGroupService sysGroupService) {
		this.sysGroupService = sysGroupService;
	}
	@RequestMapping(value={"/Frame"},method=RequestMethod.GET)
	public String list(			
			ModelMap modelMap) 
	{		
		return "GroupManager/Frame";
	}
	@RequestMapping(value={"/GroupList"},method=RequestMethod.GET)
	public String list2(
			@RequestParam(value="GroupID", defaultValue="2") int GroupID,
			ModelMap modelMap) 
	{		
		SysGroup sysGroup=this.sysGroupService.selectByPrimaryKey(GroupID);		
		modelMap.addAttribute("sysGroup", sysGroup);		
		modelMap.addAttribute("grouptitle", GetGroupTitle(sysGroup));
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//simpleDateFormat.format(new Date());
		modelMap.addAttribute("date", simpleDateFormat.format(new Date()));
		return "GroupManager/GroupList";
	}
	private String GetGroupTitle(SysGroup sysGroup)
	{
		if(sysGroup.getGroupId()==2)
		{
			return "<a href='GroupList.aspx?GroupID="+sysGroup.getGroupId()+"'>"+sysGroup.getGcname()+"</a>";
		}
		return GetGroupTitle(sysGroup.getParentSysGroup())+"><a href='GroupList.aspx?GroupID="+sysGroup.getGroupId()+"'>"+sysGroup.getGcname()+"</a>";
	}
	@RequestMapping(value={"/CatIndex"},method=RequestMethod.GET)
	public String list3(			
			ModelMap modelMap) 
	{
		SysGroup sysGroup=this.sysGroupService.selectByPrimaryKey(2);
		//modelMap.addAttribute("sysGroup", sysGroup);
		StringBuffer sb=new StringBuffer();
		refJs(sysGroup,sb,new OutJsCallBack()
		{

			@Override
			public void callback(List<SysGroup> sysGroups, StringBuffer sb,String root) {
				// TODO Auto-generated method stub
				//start
				Iterator<SysGroup> itr=sysGroups.iterator();
				SysGroup sysGroup=null;
				while(itr.hasNext())
				{
					sysGroup=itr.next();
					if(sysGroup.getGparentId()==2)
					{
						if(sysGroup.getSubSysGroups().size()>0)
						{
							sb.append("N"+sysGroup.getGroupId()+"=insFld(treeRoot,gFld(\"mainbody\",\""+sysGroup.getGcname()+"\",\"GroupList.html?GroupID="+sysGroup.getGroupId()+"\"))\n");
							
							callback(sysGroup.getSubSysGroups(), sb,"N"+sysGroup.getGroupId());
							continue;
						}				
							sb.append("insDoc(treeRoot,gLnk(\"mainbody\",\""+sysGroup.getGcname()+"\",\"GroupList.aspx?GroupID="+sysGroup.getGroupId()+"\"))\n");				
						continue;
					}			
						if(sysGroup.getSubSysGroups().size()>0)
						{
							sb.append("N"+sysGroup.getGroupId()+"=insFld(N"+sysGroup.getGparentId()+",gFld(\"mainbody\",\""+sysGroup.getGcname()+"\",\"GroupList.html?GroupID="+sysGroup.getGroupId()+"\"))\n");
							
							callback(sysGroup.getSubSysGroups(), sb,"N"+sysGroup.getGroupId());
							continue;
						}				
							sb.append("insDoc(N"+sysGroup.getGparentId()+",gLnk(\"mainbody\",\""+sysGroup.getGcname()+"\",\"GroupList.aspx?GroupID="+sysGroup.getGroupId()+"\"))\n");						
				}
				//end
			}			
		});	
		modelMap.addAttribute("outjs", sb.toString());
		return "GroupManager/CatIndex";
	}
	private void refJs(SysGroup sysGroup,StringBuffer sb,OutJsCallBack callback)
	{		
		sb.append("<script language='JavaScript'>\n");
		sb.append("Fold_id='';\n");
		sb.append("treeRoot = gFld(\"mainbody\", \""+sysGroup.getGcname()+"\", \"GroupList.html\")\n");		
		callback.callback(sysGroup.getSubSysGroups(), sb,"treeRoot");		
		sb.append("	initializeDocument();\n");
		sb.append("</script>\n");		
	}
	private interface OutJsCallBack 
	{
	    void callback(List<SysGroup> sysGroups,StringBuffer sb,String root);
	}	  
	@RequestMapping(value={"/Manager"},method=RequestMethod.GET,params="cmd=new")
	public String listManager(
			@RequestParam(value="pGroupID", defaultValue="2") int pGroupID,
			ModelMap modelMap) 
	{		
		SysGroup sysGroup=this.sysGroupService.selectByPrimaryKey(pGroupID);
		SysGroup newGroup=new SysGroup();
		modelMap.addAttribute("newGroup", newGroup);
		modelMap.addAttribute("sysGroup", sysGroup);
		modelMap.addAttribute("grouptitle", GetGroupTitle(sysGroup));
		return "GroupManager/Manager";
	}
	@RequestMapping(value={"/Manager"},method=RequestMethod.POST,params="cmd=new")
	public String listManagerpost(
			@RequestParam(value="pGroupID", defaultValue="2") int pGroupID,
			@RequestParam(value="GroupID", defaultValue="0") int GroupID,
			@ModelAttribute("newGroup") @Valid SysGroup newGroup,
			BindingResult result,
			RedirectAttributes redirectAttributes) 
	{	
		SysGroup sysGroup=this.sysGroupService.selectByPrimaryKey(pGroupID);
		if(result.hasErrors())
		{
			redirectAttributes.addAttribute("sysGroup", sysGroup);
			redirectAttributes.addAttribute("grouptitle", GetGroupTitle(sysGroup));
			return "GroupManager/Manager";			
		}
		newGroup.setGparentId(pGroupID);
		//newGroup.setParentSysGroup(sysGroup);
		
		newGroup.setGshowOrder(sysGroup.getSubSysGroups().size()+1);
		newGroup.setGdelete((byte)0);
		this.sysGroupService.saveOrUpdate(newGroup);
		
		StringBuffer sb=new StringBuffer();
		//StringBuilder sb = new StringBuilder();
        sb.append("<script language=javascript>");
        sb.append("window.parent.leftbody.location.reload();");
        sb.append("</script>");
        
		MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("增加部门("+GroupID+")成功!");
		MBx.set_M_ReturnScript(sb.toString());
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/SystemApp/GroupManager/GroupList?GroupID="+pGroupID,"点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
    	return "redirect:/Manager/Message";		
		//return "redirect:GroupList?GroupID="+GroupID;
	}
	@RequestMapping(value={"/Manager"},method=RequestMethod.GET,params="cmd=edit")
	public String listManageredit(
			@RequestParam(value="GroupID") int GroupID,
			ModelMap modelMap) 
	{		
		SysGroup newGroup=this.sysGroupService.selectByPrimaryKey(GroupID);
		
		modelMap.addAttribute("newGroup", newGroup);
		modelMap.addAttribute("sysGroup", newGroup.getParentSysGroup());
		modelMap.addAttribute("grouptitle", GetGroupTitle(newGroup));
		return "GroupManager/Manager";
	}
	@RequestMapping(value={"/Manager"},method=RequestMethod.POST,params="cmd=edit")
	public String listManagereditpost(
			@RequestParam(value="GroupID") int GroupID,
			@ModelAttribute("newGroup") @Valid SysGroup newGroup,
			BindingResult result,
			RedirectAttributes redirectAttributes) 
	{	
        SysGroup newGroupback=this.sysGroupService.selectByPrimaryKey(GroupID);
		if(result.hasErrors())
		{
			redirectAttributes.addAttribute("sysGroup", newGroupback.getParentSysGroup());
			redirectAttributes.addAttribute("grouptitle", GetGroupTitle(newGroupback));
			return "GroupManager/Manager";
		}
		
		BeanUtils.copyProperties(newGroup, newGroupback,new String[]{"groupId","gparentId","gshowOrder","glevel","gchildCount","gdelete"});
		this.sysGroupService.saveOrUpdate(newGroupback);
		StringBuffer sb=new StringBuffer();
		//StringBuilder sb = new StringBuilder();
        sb.append("<script language=javascript>");
        sb.append("window.parent.leftbody.location.reload();");
        sb.append("</script>");
        
		MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("修改部门("+GroupID+")成功!");
		MBx.set_M_ReturnScript(sb.toString());
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/SystemApp/GroupManager/GroupList?GroupID="+newGroupback.getGparentId(),"点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
    	return "redirect:/Manager/Message";		
		
		//return "GroupManager/Manager";
	}
	@RequestMapping(value={"/Manager"},method=RequestMethod.GET,params="cmd=del")
	public String listManagerdel(
			@RequestParam(value="GroupID") int GroupID,
			RedirectAttributes redirectAttributes) 
	{	
		SysGroup newGroupback=this.sysGroupService.selectByPrimaryKey(GroupID);
		int GparentId=newGroupback.getGparentId();
		this.sysGroupService.deleteByPrimaryKey(GroupID);
		StringBuffer sb=new StringBuffer();
		//StringBuilder sb = new StringBuilder();
        sb.append("<script language=javascript>");
        sb.append("window.parent.leftbody.location.reload();");
        sb.append("</script>");
        
		MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("删除部门("+GroupID+")成功!");
		MBx.set_M_ReturnScript(sb.toString());
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/SystemApp/GroupManager/GroupList?GroupID="+GparentId,"点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
    	return "redirect:/Manager/Message";		
		//return "GroupManager/Manager";
	}
	@RequestMapping(value={"/Orderby"},method=RequestMethod.GET)
	public String listManagerdelorder(
			@RequestParam(value="GroupID") int GroupID,
			ModelMap modelMap) 
	{	
		SysGroup sysGroup=this.sysGroupService.selectByPrimaryKey(GroupID);
		modelMap.addAttribute("sysGroup", sysGroup);
		modelMap.addAttribute("grouptitle", GetGroupTitle(sysGroup));
		return "GroupManager/Orderby";
	}
	@RequestMapping(value={"/Orderby"},method=RequestMethod.POST)
	public String listManagerdelorderpost(
			@RequestParam(value="GroupID") int GroupID,
			@RequestParam(value="OrderByListItems") String OrderByListItems,
			RedirectAttributes redirectAttributes) 
	{	
		if(OrderByListItems.length()>0)
		{
			StringTokenizer st = new StringTokenizer(OrderByListItems, ",");
			
			SysGroup group=null;
			int order=0;
			while(st.hasMoreTokens())
			{
				order++;
				//System.out.println("循环输出"+st.nextToken());
				group= this.sysGroupService.selectByPrimaryKey(Integer.valueOf(st.nextToken()));
				group.setGshowOrder(order);
				this.sysGroupService.saveOrUpdate(group);
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
		MBx.set_M_Body("排序子部门成功!");
		MBx.set_M_ReturnScript(sb.toString());
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/SystemApp/GroupManager/GroupList?GroupID="+GroupID,"点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
    	return "redirect:/Manager/Message";		
		//return "GroupManager/Orderby";
	}
	@RequestMapping(value={"/Move"},method=RequestMethod.GET,params="!cmd")
	public String listManagerdelordermove(
			@RequestParam(value="GroupID") final int GroupID,
			ModelMap modelMap) 
	{	
		SysGroup sysGroup=this.sysGroupService.selectByPrimaryKey(2);
		StringBuffer sb=new StringBuffer();
		refJs(sysGroup,sb,new OutJsCallBack()
		{

			@Override
			public void callback(List<SysGroup> sysGroups, StringBuffer sb,String root) {
				// TODO Auto-generated method stub
				//start
				Iterator<SysGroup> itr=sysGroups.iterator();
				SysGroup sysGroup=null;
				while(itr.hasNext())
				{
					sysGroup=itr.next();
					if(sysGroup.getGroupId()==GroupID)
					{
						continue;						
					}
					if(sysGroup.getGparentId()==2)
					{
						if(sysGroup.getSubSysGroups().size()>0)
						{
							sb.append("N"+sysGroup.getGroupId()+"=insFld(treeRoot,gFld(\"mainbody\",\""+sysGroup.getGcname()+"\",\"\","+sysGroup.getGroupId()+"))\n");
							
							callback(sysGroup.getSubSysGroups(), sb,"N"+sysGroup.getGroupId());
							continue;
						}				
							sb.append("insDoc(treeRoot,gLnk(\"mainbody\",\""+sysGroup.getGcname()+"\",\"\","+sysGroup.getGroupId()+"))\n");				
						continue;
					}			
						if(sysGroup.getSubSysGroups().size()>0)
						{
							sb.append("N"+sysGroup.getGroupId()+"=insFld(N"+sysGroup.getGparentId()+",gFld(\"mainbody\",\""+sysGroup.getGcname()+"\",\"\","+sysGroup.getGroupId()+"))\n");
							
							callback(sysGroup.getSubSysGroups(), sb,"N"+sysGroup.getGroupId());
							continue;
						}				
							sb.append("insDoc(N"+sysGroup.getGparentId()+",gLnk(\"mainbody\",\""+sysGroup.getGcname()+"\",\"\","+sysGroup.getGroupId()+"))\n");						
				}
				//end
			}			
		});	
		modelMap.addAttribute("outjs", sb.toString());
		return "GroupManager/Move";
	}
	@RequestMapping(value={"/Move"},method=RequestMethod.GET,params="cmd=move")
	public String listManagerdelordermoveexc(
			@RequestParam(value="GroupID") int GroupID,
			@RequestParam(value="ToGroupID") int ToGroupID,
			RedirectAttributes redirectAttributes) 
	{
		SysGroup sysGroup=this.sysGroupService.selectByPrimaryKey(GroupID);
		sysGroup.setGparentId(ToGroupID);
		sysGroup.setGshowOrder(sysGroup.getSubSysGroups().size()+1);
		this.sysGroupService.saveOrUpdate(sysGroup);
		
		StringBuffer sb=new StringBuffer();
		//StringBuilder sb = new StringBuilder();
        sb.append("<script language=javascript>");
        sb.append("window.parent.leftbody.location.reload();");
        sb.append("</script>");
		
        MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("移动部门("+sysGroup.getGcname()+")成功!");
		MBx.set_M_ReturnScript(sb.toString());
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/SystemApp/GroupManager/GroupList?GroupID="+ToGroupID,"点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
    	return "redirect:/Manager/Message";		
		//return "GroupManager/Move";
	}

}
