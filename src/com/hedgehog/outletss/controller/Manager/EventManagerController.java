package com.hedgehog.outletss.controller.Manager;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.domain.BizNew;
import com.hedgehog.outletss.domain.SysEvent;
import com.hedgehog.outletss.service.SysEventService;

@Controller
@RequestMapping("/Manager/Module/FrameWork/SystemApp/EventManager")
public class EventManagerController {
	private SysEventService sysEventService;
	@Autowired	
	public void setSysEventService(SysEventService sysEventService) {
		this.sysEventService = sysEventService;
	}

	@RequestMapping(value={"/Default"},method=RequestMethod.GET)
	public String list(
			@RequestParam(value="page", defaultValue="1") int page,
	        @RequestParam(value="perPage", defaultValue="30") int perPage,	
			ModelMap modelMap) 
	{	
		QueryPara<SysEvent> qp=new QueryPara<SysEvent>();
		qp.setClazz(SysEvent.class);
		qp.setPageNo(page);
		qp.setPagesize(perPage);
		List<Order> orders=new ArrayList<Order>();		
		orders.add(Order.desc("eventId"));		
		qp.setOrders(orders);
		
		List<SysEvent> list=this.sysEventService.selectRecordForPage(qp);
		modelMap.addAttribute("list", list);
		modelMap.addAttribute("queryPara", qp);		
		
		return "EventManager/Default";
	}
	@RequestMapping(value={"/EventDisp"},method=RequestMethod.GET)
	public String EventDisp(
			@RequestParam(value="EventID") int EventID,	        
			ModelMap modelMap) 
	{	
		SysEvent sysEvent=this.sysEventService.selectByPrimaryKey(EventID);
		modelMap.addAttribute("sysEvent", sysEvent);
		return "EventManager/EventDisp";
	}

}
