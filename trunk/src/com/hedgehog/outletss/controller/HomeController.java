package com.hedgehog.outletss.controller;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hedgehog.outletss.Utils.SearchParameter;


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
	public String shownewsvidseddsw(ModelMap model)
	{		
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
			@PathVariable("newsId") String newsId,
			ModelMap model)
	{		
		return "research_detail";
	}
	/**
	 * 新闻中心
	 * @param model
	 * @return
	 */
	@RequestMapping(value={"/news"}, method=RequestMethod.GET)
	public String shownewsview(ModelMap model)
	{
		System.out.println("有没有到这里news页 修改文件");
		model.addAttribute("title", "中科汇联");
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
			@PathVariable("newsId") String newsId,
			ModelMap model)
	{
		System.out.println("有没有到这里news页 修改文件");
		model.addAttribute("title", "中科汇联");
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
