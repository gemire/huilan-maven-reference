package com.hedgehog.outletss.controller.Manager;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/Manager/Module/FrameWork/SystemApp/OnlineUserManager")
public class OnlineUserManagerController {
	@Autowired  
	SessionRegistry sessionRegistry; 
	
	@RequestMapping("/Default")  
	public String listActiveUsers(ModelMap modelMap) {  
	  Map<Object,Date> lastActivityDates = new HashMap<Object, Date>();  
	  for(Object principal: sessionRegistry.getAllPrincipals()) {  
	      // a principal may have multiple active sessions  
		  for(SessionInformation session : sessionRegistry.getAllSessions(principal, false))  
		    {  
			  
		        // no last activity stored  
			    if(lastActivityDates.get(principal) == null) {  
			      lastActivityDates.put(principal, session.getLastRequest());  
			    } 
			    else 
			    {  
			      // check to see if this session is newer than the last stored  
			      Date prevLastRequest = lastActivityDates.get(principal);  
			      if(session.getLastRequest().after(prevLastRequest)) 
			      {  
			          // update if so  
			          lastActivityDates.put(principal, session.getLastRequest());  
			      }  
			    }  
		    }  
	  }
	  modelMap.addAttribute("activeUsers", lastActivityDates);
	  //model.addAttribute("activeUsers", lastActivityDates);
       return "OnlineUserManager/default";
	}  

}
