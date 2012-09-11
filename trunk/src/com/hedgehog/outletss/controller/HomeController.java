package com.hedgehog.outletss.controller;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
	@RequestMapping(value={"/news"}, method=RequestMethod.GET)
	public String shownewsview(ModelMap model)
	{
		System.out.println("有没有到这里news页 修改文件");
		model.addAttribute("title", "中科汇联");
		return "news";
	}

}
