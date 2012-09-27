package com.hedgehog.outletss.controller.Manager;

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

import com.hedgehog.outletss.Utils.QueryPara;
import com.hedgehog.outletss.domain.SysField;
import com.hedgehog.outletss.domain.SysFieldValue;
import com.hedgehog.outletss.domain.SysUser;
import com.hedgehog.outletss.service.SysFieldService;


@Controller
@RequestMapping("/Manager/Module/FrameWork/SystemApp/FieldManager")
public class FieldManagerController {
	private static final Log log = LogFactory.getLog(FieldManagerController.class);
	private static final String LOGIN_NAME = "/Manager/Login";
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
		log.info("到了这个页面没有FieldValueManager");
		SysField sysField=this.sysFieldService.selectByPrimaryKey(fieldId);
		modelMap.addAttribute("sysField", sysField);
		return "FieldManager/FieldValueManager";
	}
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
	
	@RequestMapping(value={"/FieldValueManagerForm"},method=RequestMethod.POST,params="cmd=new")
	public String FieldValueManagerFormpost(			
			@ModelAttribute("sysField") @Valid SysField sysField,
			BindingResult result,
			ModelMap modelMap) 
	{		
		if(result.hasErrors())
		{
			return "FieldManager/FieldValueManagerForm";
		}
		this.sysFieldService.saveOrUpdate(sysField);
		return "redirect:Default";
		//return "redirect:FieldValueManager?cmd=list";
	}
	
	@RequestMapping(value={"/FieldValueManagerForm"},method=RequestMethod.GET,params="cmd=edit")
	public String FieldValueManagerFormedit(			
			@RequestParam(value="fieldId") int fieldId,	
			ModelMap modelMap) 
	{
		
		SysField sysField=this.sysFieldService.selectByPrimaryKey(fieldId);
		modelMap.addAttribute("sysField", sysField);
		return "FieldManager/FieldValueManagerForm";
	}
	
	@RequestMapping(value={"/FieldValueManagerForm"},method=RequestMethod.POST,params="cmd=edit")
	public String FieldValueManagerFormeditpost(			
			@RequestParam(value="fieldId") int fieldId,	
			@ModelAttribute("sysField") @Valid SysField sysField,
			BindingResult result,
			ModelMap modelMap) 
	{
		
		if(result.hasErrors())
		{
			return "FieldManager/FieldValueManagerForm";
		}
		this.sysFieldService.saveOrUpdate(sysField);
		
		return "redirect:FieldManager/FieldValueManager";
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
		
		return "redirect:FieldValueManager?fieldId="+fieldId+"&cmd=list";
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
			@ModelAttribute("fieldvalue") @Valid SysFieldValue fieldvalue,
			BindingResult result,
			ModelMap modelMap) 
	{
		
		if(result.hasErrors())
		{
			return "FieldManager/FieldValueBox";
		}
		SysFieldValue sysFieldValue=this.sysFieldService.selectFieldValueByPrimaryKey(valueId);
		
		BeanUtils.copyProperties(sysFieldValue,fieldvalue, new String[]{"vtext","vcode"});
		
		this.sysFieldService.saveOrUpdateFieldValue(fieldvalue);
		return "redirect:FieldValueManager?fieldId="+fieldId+"&cmd=list";
	}
	
	

}
