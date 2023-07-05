package com.pravin.clock.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author pravin.dilpak
 *
 */

@Component
public class RequestInterceptor implements HandlerInterceptor{
	
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception  {
		
		long startTime = System.currentTimeMillis();
		
		request.setAttribute("startTime",startTime);
					return true;
			
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler, ModelAndView mav)
			throws Exception {
		
		HttpSession httpSession=request.getSession(false);
		if(httpSession!=null) { 
		response.setHeader("Cookie", httpSession.getId());
	}
	}
}
