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

import com.hedgehog.outletss.Utils.QueryPara;
import com.hedgehog.outletss.domain.BizNew;
import com.hedgehog.outletss.service.BizNewService;

@Controller
@RequestMapping("/Manager/Module/FrameWork/ProjectInfo/NewManager")
public class BizNewManagerController {
	private BizNewService bizNewService;
	@Autowired
	public BizNewService getBizNewService() {
		return bizNewService;
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

}
