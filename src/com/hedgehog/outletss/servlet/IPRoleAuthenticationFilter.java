/**
 * 
 */
package com.hedgehog.outletss.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author Administrator
 *
 */
public class IPRoleAuthenticationFilter  extends OncePerRequestFilter{
	
	private String targetRole;  
	private List<String> allowedIPAddresses;  

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// before we allow the request to proceed, we'll first get the user's role  
	      // and see if it's an administrator  
	      final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();  
	      if (authentication != null && targetRole != null) {  
	          boolean shouldCheck = false;  
	          // look if the user is the target role  
	          for (GrantedAuthority authority : authentication.getAuthorities()) {  
	              if(authority.getAuthority().equals(targetRole)) {  
	                  shouldCheck = true;  
	                  break;  
	                   }  
	          }  
	          // if we should check IP, then check  
	          if(shouldCheck && allowedIPAddresses.size() > 0) {  
	              boolean shouldAllow = false;  
	              for (String ipAddress : allowedIPAddresses) {  
	                  if(request.getRemoteAddr().equals(ipAddress)) {  
	                      shouldAllow = true;  
	                      break;  
	                  }  
	              }  
	                
	              if(!shouldAllow) {  
	                  // fail the request  
	                  throw new AccessDeniedException("Access has been denied for your IP address: "+request.getRemoteAddr());  
	              }  
	          }  
	      } 
	      else 
	      {  
	        logger.warn("The IPRoleAuthenticationFilter should be placed  after the user has been authenticated in the filter chain.");  
	      }  
	      filterChain.doFilter(request, response);    
	}
	// accessors (getters and setters) omitted

}
