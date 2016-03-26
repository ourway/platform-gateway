package com.abanppc.gateway

import org.codehaus.groovy.grails.web.context.ServletContextHolder
import org.springframework.context.ApplicationContext
import org.springframework.web.context.support.WebApplicationContextUtils
import org.springframework.security.core.userdetails.UserDetails
import com.abanppc.gateway.User
import grails.converters.JSON

class AuthenticationFilters {
	
	def springSecurityService

    def filters = {
        all(controller:'transfer', action:'*') {
            before = {
				
				def servletCtx = ServletContextHolder.getServletContext()
				ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletCtx)
				springSecurityService =applicationContext.getBean('springSecurityService')
				
		        boolean authenticated = false
		        try {
					UserDetails userDetails = springSecurityService.userDetailsService.loadUserByUsername(params.username)
		            def encryptedPassword = springSecurityService.encodePassword(params.password)
		            authenticated = encryptedPassword.equals(userDetails.password);
		        } catch (Exception e) {
		        }
				
				if(!authenticated) {
					render "{\"status\" : \"NOT_AUTHENTICATED\"}"
				} else {
					return true
				} 
				
            }
			
            after = { Map model ->

            }
			
            afterView = { Exception e ->

            }
        }
    }
}
