package com.hedgehog.outletss.controller.Manager;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.hibernate.criterion.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hedgehog.outletss.domain.MessageBox;
import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.sys_NavigationUrl;
import com.hedgehog.outletss.domain.MessageBox.Icon_Type;
import com.hedgehog.outletss.domain.sys_NavigationUrl.UrlType;
import com.hedgehog.outletss.domain.BizNew;
import com.hedgehog.outletss.domain.SysEvent;
import com.hedgehog.outletss.domain.SysFieldValue;
import com.hedgehog.outletss.event.LogPublisher;
import com.hedgehog.outletss.service.BizNewService;
import com.hedgehog.outletss.service.MyUserDetailsService;
import com.hedgehog.outletss.service.SysFieldService;

@Controller
@RequestMapping("/Manager/Module/FrameWork/ProjectInfo/NewManager")
public class BizNewManagerController {
	private Map<String,String> sort;
	private BizNewService bizNewService;
	
	@Autowired
	public void setBizNewService(BizNewService bizNewService) {
		this.bizNewService = bizNewService;
	}
	private SysFieldService sysFieldService;
	@Autowired
	public void setSysFieldService(SysFieldService sysFieldService) {
		this.sysFieldService = sysFieldService;
	}
	private LogPublisher logPublisher;
	@Autowired
	public void setLogPublisher(LogPublisher logPublisher) {
		this.logPublisher = logPublisher;
	}

	@InitBinder  
    public void initBinder(WebDataBinder binder) {  
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        dateFormat.setLenient(false); 
        //binder.registerCustomEditor(requiredType, field, propertyEditor)
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));  
    } 
	public BizNewManagerController()
	{
		sort=new LinkedHashMap<String,String>();
		sort.put("h", "头条[h]");
		sort.put("c", "推荐[c]");
		sort.put("f", "幻灯[f]");
		sort.put("a", "特荐[a]");		
		sort.put("s", "滚动[s]");
		sort.put("b", "加粗[b]");
		sort.put("p", "图片[p]");
		sort.put("j", "跳转[j]");
	}

	@RequestMapping(value={"/List"},method=RequestMethod.GET)
	public String list(				
			@RequestParam(value="page", defaultValue="1") int page,
	        @RequestParam(value="perPage", defaultValue="30") int perPage,			
			ModelMap modelMap) 
	{		
    	QueryPara<BizNew> qp=new QueryPara<BizNew>();
		qp.setClazz(BizNew.class);
		qp.setPageNo(page);
		qp.setPagesize(perPage);
		List<Order> orders=new ArrayList<Order>();		
		orders.add(Order.desc("newsId"));		
		qp.setOrders(orders);
		
		List<BizNew> list=this.bizNewService.selectRecordForPage(qp);
		modelMap.addAttribute("list", list);
		modelMap.addAttribute("queryPara", qp);    	
    	return "NewManager/List";
	}
	@RequestMapping(value={"/Manager"},method=RequestMethod.GET,params="cmd=new")
	public String Managernew(			
			ModelMap modelMap) 
	{		
//		try
//		{
//			throw new Exception("测试错误");
//		}
//		catch (Exception re)  
//		{
//			re.printStackTrace();
//		}
		//自定义属性
//		Map<String,String> sort=new LinkedHashMap<String,String>();
//		sort.put("h", "头条[h]");
//		sort.put("c", "推荐[c]");
//		sort.put("f", "幻灯[f]");
//		sort.put("a", "特荐[a]");		
//		sort.put("s", "滚动[s]");
//		sort.put("b", "加粗[b]");
//		sort.put("p", "图片[p]");
//		sort.put("j", "跳转[j]");
		modelMap.addAttribute("sortlist", sort);
		
    	List<SysFieldValue> nclist=this.sysFieldService.selectFieldValueRecordByvfKey("newssort");
    	modelMap.addAttribute("nclist", nclist);		
    	BizNew bizNew=new BizNew();
    	modelMap.addAttribute("bizNew", bizNew);    	
    	return "NewManager/Manager";
	}
	@RequestMapping(value={"/Manager"},method=RequestMethod.POST,params="cmd=new")
	public String Managernewpost(
			@RequestParam(value="IDX",defaultValue="0") int newsId,
			@ModelAttribute("syNew") @Valid BizNew bizNew,
			BindingResult result,
			RedirectAttributes redirectAttributes) 
	{
		if(result.hasErrors())
		{
			redirectAttributes.addAttribute("sortlist", sort);
			List<SysFieldValue> nclist=this.sysFieldService.selectFieldValueRecordByvfKey("newssort");
			redirectAttributes.addAttribute("nclist", nclist);
	    	return "NewManager/Manager";			
		}
		Date date = new Date();
		bizNew.setNewsUpdatetime(new Timestamp(date.getTime()));
		bizNew.setNewsHits(0);
		this.bizNewService.saveOrUpdate(bizNew);
		
		MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("增加新闻ID("+newsId+")成功!");
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/ProjectInfo/NewManager/List","点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		SysEvent sysEvent=new SysEvent();
		sysEvent.setEuLoginName(userDetails.getUsername());
		sysEvent.setEuserId(1);
		sysEvent.setEdateTime(new Timestamp(date.getTime()));		
		sysEvent.setEapplicationId(2);
		sysEvent.setEaAppName("奥特莱斯");
		sysEvent.setEmName("新闻管理");
		sysEvent.setEfrom("/Manager/Module/FrameWork/ProjectInfo/NewManager/Manager?cmd=new");
		sysEvent.setEtype((byte)1);
		sysEvent.setErecord("增加新闻(ID:"+newsId+")成功!");
		this.logPublisher.publishEvent(sysEvent);
    	return "redirect:/Manager/Message";		
	}
	@RequestMapping(value={"/Manager"},method=RequestMethod.GET,params="cmd=edit")
	public String Manageredit(
			@RequestParam(value="IDX") int newsId,
			ModelMap modelMap) 
	{
		modelMap.addAttribute("sortlist", sort);
    	List<SysFieldValue> nclist=this.sysFieldService.selectFieldValueRecordByvfKey("newssort");
    	modelMap.addAttribute("nclist", nclist);		
    	BizNew bizNew=this.bizNewService.selectByPrimaryKey(newsId);
    	modelMap.addAttribute("bizNew", bizNew);    	
    	return "NewManager/Manager";
	}
	@RequestMapping(value={"/Manager"},method=RequestMethod.POST,params="cmd=edit")
	public String Managereditpost(
			@RequestParam(value="IDX") int newsId,
			@ModelAttribute("syNew") @Valid BizNew bizNew,
			BindingResult result,
			RedirectAttributes redirectAttributes) 
	{		
		if(result.hasErrors())
		{
			redirectAttributes.addAttribute("sortlist", sort);
			List<SysFieldValue> nclist=this.sysFieldService.selectFieldValueRecordByvfKey("newssort");
			redirectAttributes.addAttribute("nclist", nclist);
	    	return "NewManager/Manager";			
		}
		BizNew bizNew2=this.bizNewService.selectByPrimaryKey(newsId);
		
		BeanUtils.copyProperties(bizNew, bizNew2,new String[]{"newsId","newsHits","newsUpdatetime"});		
		Date date = new Date();
		bizNew2.setNewsUpdatetime(new Timestamp(date.getTime()));		
		this.bizNewService.saveOrUpdate(bizNew2);
		MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("修改新闻ID("+newsId+")成功!");
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/ProjectInfo/NewManager/List","点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
		
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		SysEvent sysEvent=new SysEvent();
		sysEvent.setEuLoginName(userDetails.getUsername());
		sysEvent.setEuserId(1);
		sysEvent.setEdateTime(new Timestamp(date.getTime()));		
		sysEvent.setEapplicationId(2);
		sysEvent.setEaAppName("奥特莱斯");
		sysEvent.setEmName("新闻管理");
		sysEvent.setEfrom("/Manager/Module/FrameWork/ProjectInfo/NewManager/Manager?cmd=edit&IDX="+newsId);
		sysEvent.setEtype((byte)1);
		sysEvent.setErecord("修改新闻(ID:"+newsId+")成功!");
		this.logPublisher.publishEvent(sysEvent);
    	return "redirect:/Manager/Message";		
    	
	}
	@RequestMapping(value={"/Manager"},method=RequestMethod.GET,params="cmd=del")
	public String Managerdel(
			@RequestParam(value="IDX") int newsId,
			RedirectAttributes redirectAttributes) 
	{		
		this.bizNewService.deleteByPrimaryKey(newsId);
		MessageBox MBx = new MessageBox();
		MBx.set_M_Title("操作成功");
		MBx.set_M_IconType(Icon_Type.OK);
		MBx.set_M_Body("删除新闻ID("+newsId+")成功!");
		List<sys_NavigationUrl> buttonList=new 	ArrayList<sys_NavigationUrl>();
		sys_NavigationUrl nav=new sys_NavigationUrl("确定","Manager/Module/FrameWork/ProjectInfo/NewManager/List","点击按钮返回！",UrlType.Href,true);
		buttonList.add(nav);
		MBx.set_M_ButtonList(buttonList);		
		redirectAttributes.addFlashAttribute("mbx", MBx);
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		SysEvent sysEvent=new SysEvent();
		sysEvent.setEuLoginName(userDetails.getUsername());
		sysEvent.setEuserId(1);
		sysEvent.setEdateTime(new Timestamp(new Date().getTime()));		
		sysEvent.setEapplicationId(2);
		sysEvent.setEaAppName("奥特莱斯");
		sysEvent.setEmName("新闻管理");
		sysEvent.setEfrom("/Manager/Module/FrameWork/ProjectInfo/NewManager/Manager?cmd=del&IDX="+newsId);
		sysEvent.setEtype((byte)1);
		sysEvent.setErecord("删除新闻(ID:"+newsId+")成功!");
		this.logPublisher.publishEvent(sysEvent);
		
    	return "redirect:/Manager/Message";	
	}

}
