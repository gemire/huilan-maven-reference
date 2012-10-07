package com.hedgehog.outletss.controller.Manager;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

import com.hedgehog.outletss.domain.MessageBox;
import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.sys_NavigationUrl;
import com.hedgehog.outletss.domain.MessageBox.Icon_Type;
import com.hedgehog.outletss.domain.sys_NavigationUrl.UrlType;
import com.hedgehog.outletss.domain.SysField;
import com.hedgehog.outletss.domain.SysFieldValue;
import com.hedgehog.outletss.domain.SysUser;
import com.hedgehog.outletss.service.SysFieldService;


@Controller
@RequestMapping("/Manager/Module/FrameWork/SystemApp/FieldManager")
public class FieldManagerController {
	private static final Log log = LogFactory.getLog(FieldManagerController.class);	
	private SysFieldService sysFieldService;
	@Autowired
	public void setSysFieldService(SysFieldService sysFieldService) {
		this.sysFieldService = sysFieldService;
	}
	
	@RequestMapping(value={"/Default"},method=RequestMethod.GET)
	public String list(			
			@RequestParam(value="page", defaultValue="1") int page,
	        @RequestParam(value="perPage", defaultValue="30") int perPage,			
			ModelMap modelMap) 
	{		
		QueryPara<SysField> qp=new QueryPara<SysField>();
		qp.setClazz(SysField.class);
		qp.setPageNo(page);
		qp.setPagesize(perPage);
		List<SysField> list=this.sysFieldService.selectRecordForPage(qp);
		modelMap.addAttribute("list", list);
		modelMap.addAttribute("QueryPara", qp);		
		return "FieldManager/Default";
	}
	
	@RequestMapping(value={"/FieldValueManager"},method=RequestMethod.GET,params="cmd=list")
	public String FieldValueManager(			
			@RequestParam(value="fieldId") int fieldId,	        	
			ModelMap modelMap) 
	{		
		SysField sysField=this.sysFieldService.selectByPrimaryKey(fieldId);
		modelMap.addAttribute("sysField", sysField);
		return "FieldManager/FieldValueManager";
	}
	/**
	 * 新增 get方法
	 * @param cookieuserName
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value={"/FieldValueManagerForm"},method=RequestMethod.GET,params="cmd=new")
	public String FieldValueManagerForm(			
			@CookieValue(value="sysuser",defaultValue="") String cookieuserName,			 	
			ModelMap modelMap) 
	{
		log.info("FieldValueManagerForm1");
		SysField sysField=new SysField();
		modelMap.addAttribute("sysField", sysField);
		return "FieldManager/FieldValueManagerForm";
	}
	/**
	 * 新增 post方法
	 * @param sysField
	 * @param result
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value={"/FieldValueManagerForm"},method=RequestMethod.POST,params="cmd=new")
	public String FieldValueManagerFormpost(
			@RequestParam(value="fieldId",defaultValue="0") int fieldId,	
			@ModelAttribute("sysField") @Valid SysField sysField,
			BindingResult result,
			RedirectAttributes redirectAttributes) 
	{		
		if(result.hasErrors())
		{
			return "FieldManager/FieldValueManagerForm";
		}
		this.sysFieldService.saveOrUpdate(sysField);
		MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("增加应用字段ID("+fieldId+")成功!");
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/SystemApp/FieldManager/Default","点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
    	return "redirect:/Manager/Message";		
		//return "redirect:Default";
		//return "redirect:FieldValueManager?cmd=list";
	}
	/**
	 * 编辑get方法
	 * @param fieldId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value={"/FieldValueManagerForm"},method=RequestMethod.GET,params="cmd=edit")
	public String FieldValueManagerFormedit(			
			@RequestParam(value="fieldId") int fieldId,	
			ModelMap modelMap) 
	{
		
		SysField sysField=this.sysFieldService.selectByPrimaryKey(fieldId);
		modelMap.addAttribute("sysField", sysField);
		return "FieldManager/FieldValueManagerForm";
	}
	/**
	 * 编辑 post方法
	 * @param fieldId
	 * @param sysField
	 * @param result
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value={"/FieldValueManagerForm"},method=RequestMethod.POST,params="cmd=edit")
	public String FieldValueManagerFormeditpost(			
			@RequestParam(value="fieldId") int fieldId,	
			@ModelAttribute("sysField") @Valid SysField sysField,
			BindingResult result,
			RedirectAttributes redirectAttributes) 
	{
		
		if(result.hasErrors())
		{
			return "FieldManager/FieldValueManagerForm";
		}
		this.sysFieldService.saveOrUpdate(sysField);
		MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("编辑应用字段ID("+fieldId+")成功!");
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/SystemApp/FieldManager/Default","点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
    	return "redirect:/Manager/Message";	
		//return "redirect:FieldValueManager?cmd=list&fieldId="+fieldId;
		//return "redirect:FieldManager/FieldValueManager";
	}
	@RequestMapping(value={"/FieldValueManager"},method=RequestMethod.GET,params="cmd=del")
	public String FieldValueManagerFormdel(			
			@RequestParam(value="fieldId") int fieldId,				 	
			RedirectAttributes redirectAttributes) 
	{
		this.sysFieldService.deleteByPrimaryKey(fieldId);
		MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("删除应用字段ID("+fieldId+")成功!");
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/SystemApp/FieldManager/Default","点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
    	return "redirect:/Manager/Message";	
		//return "redirect:Default";
	}
	
	@RequestMapping(value={"/FieldValueBox"},method=RequestMethod.GET,params="cmd=new")
	public String FieldValueBoxnew(
			@RequestParam(value="fieldId") int fieldId,				
			ModelMap modelMap) 
	{
		
		SysFieldValue fieldValue=new SysFieldValue();
		SysField sysField=this.sysFieldService.selectByPrimaryKey(fieldId);
		fieldValue.setSysField(sysField);
		fieldValue.setVfKey(sysField.getFkey());
		modelMap.addAttribute("fieldvalue", fieldValue);
		return "FieldManager/FieldValueBox";
	}
	
	@RequestMapping(value={"/FieldValueBox"},method=RequestMethod.POST,params="cmd=new")
	public String FieldValueBoxnewpost(			
			@RequestParam(value="fieldId") int fieldId,	
			@ModelAttribute("fieldvalue") @Valid SysFieldValue fieldvalue,
			BindingResult result,
			ModelMap modelMap) 
	{
		if(result.hasErrors())
		{
			return "FieldManager/FieldValueBox";
		}		
		SysField sysField=this.sysFieldService.selectByPrimaryKey(fieldId);
		//fieldvalue.setSysField(sysField);
		fieldvalue.setVfKey(sysField.getFkey());
		
         //BeanUtils.copyProperties(sysFieldValue,fieldvalue, new String[]{"vtext","vcode"});
		fieldvalue.setVshowOrder(0);
		this.sysFieldService.saveOrUpdateFieldValue(fieldvalue);
		String Messages=String.format("增加应用字段值(%s)成功!", fieldvalue.getVtext());
		modelMap.addAttribute("TabJs", "<script language='javascript'>window.returnVal=\"" + Messages + "\";window.parent.hidePopWin(true);</script>");
		return "FieldManager/FieldValueBox";
		//return "redirect:FieldValueManager?fieldId="+fieldId+"&cmd=list";
	}
	
	@RequestMapping(value={"/FieldValueBox"},method=RequestMethod.GET,params="cmd=edit")
	public String FieldValueBox(			
			@RequestParam(value="fieldId") int fieldId,	  
			@RequestParam(value="valueId") int valueId,	  
			ModelMap modelMap) 
	{		
		SysFieldValue fieldValue=this.sysFieldService.selectFieldValueByPrimaryKey(valueId);
		modelMap.addAttribute("fieldvalue", fieldValue);
		return "FieldManager/FieldValueBox";
	}
	@RequestMapping(value={"/FieldValueBox"},method=RequestMethod.POST,params="cmd=edit")
	public String FieldValueBoxpost(			
			@RequestParam(value="fieldId") int fieldId,	  
			@RequestParam(value="valueId") int valueId,
			@RequestParam(value="test",defaultValue="0") String  test,	
			@ModelAttribute("fieldvalue") @Valid SysFieldValue fieldvalue,
			BindingResult result,
			ModelMap modelMap) 
	{
		if(test.equals("1"))
		{
			String Messages=String.format("删除应用字段值(%s)成功!",String.valueOf(valueId));
			this.sysFieldService.deleteFieldValueByPrimaryKey(valueId);
			modelMap.addAttribute("TabJs", "<script language='javascript'>window.returnVal=\"" + Messages + "\";window.parent.hidePopWin(true);</script>");
			return "FieldManager/FieldValueBox";	
			
		}
		
		if(result.hasErrors())
		{
			return "FieldManager/FieldValueBox";
		}
		SysFieldValue sysFieldValue=this.sysFieldService.selectFieldValueByPrimaryKey(valueId);
		
		BeanUtils.copyProperties(sysFieldValue,fieldvalue, new String[]{"vtext","vcode"});
		
		this.sysFieldService.saveOrUpdateFieldValue(fieldvalue);
		String Messages=String.format("修改应用字段值(%s)成功!", fieldvalue.getVtext());
		modelMap.addAttribute("TabJs", "<script language='javascript'>window.returnVal=\"" + Messages + "\";window.parent.hidePopWin(true);</script>");
		return "FieldManager/FieldValueBox";
		//return "redirect:FieldValueManager?fieldId="+fieldId+"&cmd=list";
	}
	@Deprecated
	@RequestMapping(value={"/FieldValueBox"},method=RequestMethod.POST,params="cmd=del")
	public String FieldValueBoxpostdel(			
			@RequestParam(value="fieldId") int fieldId,	  
			@RequestParam(value="valueId") int valueId,			
			ModelMap modelMap) 
	{
		String Messages=String.format("删除应用字段值(%s)成功!",String.valueOf(valueId));
		modelMap.addAttribute("TabJs", "<script language='javascript'>window.returnVal=\"" + Messages + "\";window.parent.hidePopWin(true);</script>");
		return "FieldManager/FieldValueBox";		
	}
	
	

}
