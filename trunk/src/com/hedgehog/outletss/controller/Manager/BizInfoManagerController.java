/**
 * 
 */
package com.hedgehog.outletss.controller.Manager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.criterion.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hedgehog.outletss.domain.BizInfo;
import com.hedgehog.outletss.domain.BizInfoPK;
import com.hedgehog.outletss.domain.BizNew;
import com.hedgehog.outletss.domain.MessageBox;
import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.sys_NavigationUrl;
import com.hedgehog.outletss.domain.MessageBox.Icon_Type;
import com.hedgehog.outletss.domain.sys_NavigationUrl.UrlType;
import com.hedgehog.outletss.service.BizInfoService;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/Manager/Module/FrameWork/ProjectInfo/InfoManager")
public class BizInfoManagerController {
	private BizInfoService bizInfoService;
	@Autowired
	public void setBizInfoService(BizInfoService bizInfoService) {
		this.bizInfoService = bizInfoService;
	}
	@RequestMapping(value={"/List"},method=RequestMethod.GET)
	public String list(				
			@RequestParam(value="page", defaultValue="1") int page,
	        @RequestParam(value="perPage", defaultValue="30") int perPage,			
			ModelMap modelMap) 
	{		
    	QueryPara<BizInfo> qp=new QueryPara<BizInfo>();
		qp.setClazz(BizInfo.class);
		qp.setPageNo(page);
		qp.setPagesize(perPage);
		//List<Order> orders=new ArrayList<Order>();		
		//orders.add(Order.desc("newsId"));		
		//qp.setOrders(orders);
		
		List<BizInfo> list=this.bizInfoService.selectRecordForPage(qp);
		modelMap.addAttribute("list", list);
		modelMap.addAttribute("queryPara", qp);    	
    	return "InfoManager/List";
	}	
	@RequestMapping(value={"/Manager"},method=RequestMethod.GET,params="cmd=new")
	public String Managernew(			
			ModelMap modelMap) 
	{	
	   BizInfo bizInfo=new BizInfo();
	   modelMap.addAttribute("bizInfo", bizInfo);
	   return "InfoManager/Manager";
	}
	@RequestMapping(value={"/Manager"},method=RequestMethod.POST,params="cmd=new")
	public String Managernewpost(			
			@ModelAttribute("bizInfo") @Valid BizInfo bizInfo,
			BindingResult result,
			RedirectAttributes redirectAttributes) 
	{	
	   if(result.hasErrors())
	   {
		   return "InfoManager/Manager";
	   }
	   Date date = new Date();
	   bizInfo.setInfoUpdatetime(new Timestamp(date.getTime()));
	   this.bizInfoService.saveOrUpdate(bizInfo);
	   MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("增加栏目信息成功!");
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/ProjectInfo/InfoManager/List","点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
		return "redirect:/Manager/Message";
	}
	@RequestMapping(value={"/Manager"},method=RequestMethod.GET,params="cmd=edit")
	public String Manageredit(
			@RequestParam(value="subject") String subject,
	        @RequestParam(value="key") String key,	
			ModelMap modelMap) 
	{	
	   BizInfoPK infoPK=new BizInfoPK(subject,key);
	   BizInfo bizInfo=this.bizInfoService.selectByPrimaryKey(infoPK);
	   modelMap.addAttribute("bizInfo", bizInfo);
	   return "InfoManager/Manager";
	}
	@RequestMapping(value={"/Manager"},method=RequestMethod.POST,params="cmd=edit")
	public String Managernewpostedit(
			@RequestParam(value="subject") String subject,
	        @RequestParam(value="key") String key,
			@ModelAttribute("bizInfo") @Valid BizInfo bizInfo,
			BindingResult result,
			RedirectAttributes redirectAttributes) 
	{
		if(result.hasErrors())
		   {
			   return "InfoManager/Manager";
		   }
		BizInfoPK infoPK=new BizInfoPK(subject,key);
		  BizInfo bizInfo2=this.bizInfoService.selectByPrimaryKey(infoPK);
		  BeanUtils.copyProperties(bizInfo, bizInfo2,new String[]{"comp_id.infoSubject","comp_id.infoKey","infoUpdatetime"});
		  
		   Date date = new Date();
		   bizInfo2.setInfoUpdatetime(new Timestamp(date.getTime()));
		   this.bizInfoService.saveOrUpdate(bizInfo2);
		   
		   MessageBox MBx = new MessageBox();
			MBx.set_M_Title("操作成功");
			MBx.set_M_IconType(Icon_Type.OK);
			MBx.set_M_Body("修改栏目信息成功!");
			List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
			sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/ProjectInfo/InfoManager/List","点击按钮返回！",UrlType.Href,true);
			buttonList.add(nav);
			MBx.set_M_ButtonList(buttonList);		
			redirectAttributes.addFlashAttribute("mbx", MBx);
			return "redirect:/Manager/Message";		
	}
	@RequestMapping(value={"/Manager"},method=RequestMethod.GET,params="cmd=del")
	public String Manageredit(
			@RequestParam(value="subject") String subject,
	        @RequestParam(value="key") String key,	
	        RedirectAttributes redirectAttributes) 
	{
		BizInfoPK infoPK=new BizInfoPK(subject,key);
		
		this.bizInfoService.deleteByPrimaryKey(infoPK);
		MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("删除栏目信息成功!");
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/ProjectInfo/InfoManager/List","点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
		return "redirect:/Manager/Message";		
		
	}

}
