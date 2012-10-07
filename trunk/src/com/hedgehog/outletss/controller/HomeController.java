package com.hedgehog.outletss.controller;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hedgehog.outletss.domain.BizNew;
import com.hedgehog.outletss.domain.QueryPara;
import com.hedgehog.outletss.service.BizNewService;




/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public String home(Locale locale, ModelMap modelMap) {
		logger.info("Welcome home! the client locale is "+ locale.toString());		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);		
		String formattedDate = dateFormat.format(date);		
		modelMap.addAttribute("serverTime", formattedDate );
		//modelMap.addAttribute("parameter", new SearchParameter());		
		System.out.println("系统根目录："+System.getProperty("maven.example.root"));	
		
		QueryPara<BizNew> qp=new QueryPara<BizNew>();
		qp.setClazz(BizNew.class);
		qp.setPageNo(1);
		qp.setPagesize(5);
		List<Criterion> criterions=new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("newsCate", new Integer(4)));
		qp.setCriterions(criterions);
		List<Order> orders=new ArrayList<Order>();		
		orders.add(Order.desc("newsId"));		
		qp.setOrders(orders);		
		List<BizNew> list4=this.bizNewService.selectRecordForPage(qp);
		modelMap.addAttribute("list4", list4);
		//modelMap.addAttribute("queryPara", qp);
		QueryPara<BizNew> qp2=new QueryPara<BizNew>();
		qp2.setClazz(BizNew.class);
		qp2.setPageNo(1);
		qp2.setPagesize(5);
		List<Criterion> criterions2=new ArrayList<Criterion>();
		criterions2.add(Restrictions.eq("newsCate", new Integer(5)));
		qp2.setCriterions(criterions2);
		List<Order> orders2=new ArrayList<Order>();		
		orders2.add(Order.desc("newsId"));		
		qp2.setOrders(orders2);		
		List<BizNew> list=this.bizNewService.selectRecordForPage(qp2);
		modelMap.addAttribute("list5", list);
		
		return "home";
	}
	/**
	 * 关于奥特莱斯
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/about"}, method=RequestMethod.GET)
	public String shownewsviedsw(ModelMap model)
	{		
		return "about";
	}
	/**
	 * 奥特莱斯联盟简介
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/union"}, method=RequestMethod.GET)
	public String shownewsviedlsw(ModelMap model)
	{		
		return "union";
	}
	/**
	 * 奥特莱斯在中国
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/inchina"}, method=RequestMethod.GET)
	public String shownewsvidsedsw(ModelMap model)
	{		
		return "inchina";
	}
	/**
	 * 奥特莱斯联盟【奥特莱斯特卖场】
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/alliance"}, method=RequestMethod.GET)
	public String shownewsdvidsedsw(ModelMap model)
	{		
		return "alliance";
	}
	/**
	 * 奥特莱斯联盟【奥特莱斯特卖场详情】
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/alliance_detail"}, method=RequestMethod.GET)
	public String shownewsdvghidsedsw(ModelMap model)
	{		
		return "alliance_detail";
	}
	/**
	 * 战略合作伙伴
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/brand"}, method=RequestMethod.GET)
	public String shownewssvidsedsw(ModelMap model)
	{		
		return "brand";
	}
	/**
	 * 业态研究
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/research"}, method=RequestMethod.GET)
	public String shownewsvidseddsw(ModelMap modelMap)
	{	
		QueryPara<BizNew> qp=new QueryPara<BizNew>();
		qp.setClazz(BizNew.class);
		qp.setPageNo(1);
		qp.setPagesize(5);
		List<Criterion> criterions=new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("newsCate", new Integer(5)));
		qp.setCriterions(criterions);
		List<Order> orders=new ArrayList<Order>();		
		orders.add(Order.desc("newsId"));		
		qp.setOrders(orders);		
		List<BizNew> list=this.bizNewService.selectRecordForPage(qp);
		//Iterator<BizNew> itr=list.iterator();
		
//		while(itr.hasNext())
//		{
//			((BizNew)itr.next()).setNewsSummery(texttools.Html2Text(((BizNew)itr.next()).getNewsContent().trim()));
//			
//		}
		//bizNew.setNewsSummery(texttools.Html2Text(bizNew.getNewsContent().trim()));
		modelMap.addAttribute("list", list);
		modelMap.addAttribute("queryPara", qp);
		return "research";
	}
	/**
	 * 业态研究详细
	 * @param newsId
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/research/{newsId}"}, method=RequestMethod.GET)
	public String shownewsvidsdseddsw(
			@PathVariable("newsId") int newsId,
			ModelMap modelMap)
	{	
		BizNew bizNew=this.bizNewService.selectByPrimaryKey(newsId);
		
    	modelMap.addAttribute("bizNew", bizNew); 
		return "research_detail";
	}
	
    private BizNewService bizNewService;
    
	@Autowired
	public void setBizNewService(BizNewService bizNewService) {
		this.bizNewService = bizNewService;
	}
	/**
	 * 新闻中心
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/news"}, method=RequestMethod.GET)
	public String shownewsview(ModelMap modelMap)
	{
		QueryPara<BizNew> qp=new QueryPara<BizNew>();
		qp.setClazz(BizNew.class);
		qp.setPageNo(1);
		qp.setPagesize(6);
		List<Criterion> criterions=new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("newsCate", new Integer(4)));
		qp.setCriterions(criterions);
		List<Order> orders=new ArrayList<Order>();		
		orders.add(Order.desc("newsId"));		
		qp.setOrders(orders);		
		List<BizNew> list=this.bizNewService.selectRecordForPage(qp);
		modelMap.addAttribute("list", list);
		modelMap.addAttribute("queryPara", qp);
		return "news";
	}
	/**
	 * 新闻中心详细
	 * @param newsId
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/news/{newsId}"}, method=RequestMethod.GET)
	public String shownewsvfhiew(
			@PathVariable("newsId") int newsId,
			ModelMap modelMap)
	{
		BizNew bizNew=this.bizNewService.selectByPrimaryKey(newsId);
    	modelMap.addAttribute("bizNew", bizNew); 
    	//modelMap.addAttribute("title", bizNew.getNewsTitle()); 
		return "news_detail";
	}
	/**
	 * 联系我们
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/conter"}, method=RequestMethod.GET)
	public String shownfewsvidsedsw(ModelMap model)
	{		
		return "conter";
	}
	

}
