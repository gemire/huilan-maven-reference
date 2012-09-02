package com.hedgehog.controller.Manager;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.Principal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.theme.CookieThemeResolver;

/**
 * 
 * @author Administrator
 *
 */
@Controller
public class BasicController {
	private static final Log log = LogFactory.getLog(BasicController.class);
	@Autowired  
    private ThemeResolver themeResolver;
	//forward
	/**
	 * 欢迎页面
	 * @param theme
	 * @param request
	 * @param response
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value={"/welcome"},method=GET)
	public String manager(			
			@RequestParam(value="theme", defaultValue="default") String theme,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap modelMap,
			Principal principal
			) 
	{
//		//获取用户名 第一种方式
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		auth.getAuthorities()
//	    String name = auth.getName(); //get logged in username
//		//第二种方式
//	    User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//	    String name = user.getUsername(); //get logged in username
		//disanzhongfangshi
		//@CookieValue(value="sysuser",defaultValue="") String cookieuserName,
		
		System.out.println("theme:"+theme);
		//String ss=CookieThemeResolver.DEFAULT_COOKIE_NAME;
		log.info("current theme is "+themeResolver.resolveThemeName(request));
		themeResolver.setThemeName(request,response,theme);
		log.info("current theme change to " +themeResolver.resolveThemeName(request));
		
		//Cookie themecookie=new Cookie(CookieThemeResolver.DEFAULT_COOKIE_NAME, theme);
		//themecookie.setMaxAge(1200);
		//themecookie.setPath("/Manager/");
 		//response.addCookie(themecookie);
		//第三种方式
		
		String name = principal.getName();
		modelMap.addAttribute("username", name);
		modelMap.addAttribute("message", "Spring Security Custom Form example");
		

		return "templatePage";
	}
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
 
		return "login";
 
	}
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
 
		model.addAttribute("error", "true");
		return "login";
 
	}
	@RequestMapping(value="/accessDenied", method = RequestMethod.GET)
	public String logidnerror(ModelMap model) {
	  return "accessDenied"; 
	}
	
	@RequestMapping(value="/sessionTimeout", method = RequestMethod.GET)
	public String logidsnerror(ModelMap model) {
	  return "sessionTimeout"; 
	}
	
//	@RequestMapping(value="/logout", method = RequestMethod.GET)
//	public String logout(ModelMap model) {
// 
//		return "login";
// 
//	}

	/**
	 * 初始页
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value={"/Manager/first"},method=GET)
	public String sysmanagerfirst(			
			ModelMap modelMap) 
	{
		return "Manager/first";
	}
	/**
	 * 系统管理
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value={"/Manager/index"},method=GET)
	public String sysmanager(			
			ModelMap modelMap) 
	{
		return "Manager/index";
	}
	/**
	 * 采集状态
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value={"/Manager/crawl"},method=GET)
	public String sysmanagercrawl(			
			ModelMap modelMap) 
	{
		return "Manager/crawl";
	}

}
