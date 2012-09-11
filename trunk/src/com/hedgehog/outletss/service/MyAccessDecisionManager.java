/**
 * 
 */
package com.hedgehog.outletss.service;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author Administrator
 *
 */
public class MyAccessDecisionManager implements AccessDecisionManager {

	/**
	 * authentication代表用户  configAttributes 访问资源需要具有的角色集合
	 */
	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		// TODO Auto-generated method stub
		if (configAttributes == null) {  
            return;  
        }
		Iterator<ConfigAttribute> ite = configAttributes.iterator();  
		  
        while (ite.hasNext()) {  
  
            ConfigAttribute ca = ite.next();  
            String needRole = ((SecurityConfig)ca).getAttribute();  
  
            // ga 为用户所被赋予的权限。 needRole 为访问相应的资源应该具有的权限。  
            for (GrantedAuthority ga : authentication.getAuthorities()) {  
                if (needRole.trim().equals(ga.getAuthority().trim())) {  
                    return;  
                }  
            }  
        }  
  
        throw new AccessDeniedException("Acess Denied");  
		
		
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

}
