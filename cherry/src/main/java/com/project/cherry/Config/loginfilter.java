package com.project.cherry.Config;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(urlPatterns = {"/chatlist","/sell","/mypage"})
public class loginfilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		if(id != null) {
			chain.doFilter(request, response);
		}else {
			String url=req.getRequestURI();
			String query=req.getQueryString();
			String encodedUrl=null;
			if(query==null) {
				encodedUrl=URLEncoder.encode(url);
			}else {
				encodedUrl=URLEncoder.encode(url+"?"+query);
			}
			String cPath=req.getContextPath();
			HttpServletResponse resp=(HttpServletResponse)response;
			System.out.println(cPath+"/loginform?url="+encodedUrl);
			resp.sendRedirect(cPath+"/loginform?url="+encodedUrl);
		}	
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub		
	}

}

// import org.aspectj.lang.ProceedingJoinPoint;
// import org.aspectj.lang.annotation.Around;
// import org.aspectj.lang.annotation.Aspect;
// import org.springframework.stereotype.Component;
// import org.springframework.web.servlet.ModelAndView;

// @Aspect
// @Component
// public class loginfilter {
// 	@Around("execution(org.springframework.web.servlet.ModelAndView auth*(..))")
// 	public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable {
// 		Object[] args=joinPoint.getArgs();
// 		for(Object tmp:args) {
// 			if(tmp instanceof HttpServletRequest) {
// 				HttpServletRequest request=(HttpServletRequest) tmp;
// 				String id=(String)request.getSession().getAttribute("id");
// 				if(id==null) {
// 					String url = request.getRequestURI();
// 					String query=request.getQueryString();
// 					String encodeUrl;
// 					if (query==null) {
// 						encodeUrl=URLEncoder.encode(url);
// 					}else {
// 						encodeUrl=URLEncoder.encode(url+"?"+query);
// 					}
// 					ModelAndView mView=new ModelAndView();
// 					mView.setViewName("redirect:/loginform?url="+encodeUrl);
// 					return mView;
// 				}
// 			}
// 		}
// 		Object obj=joinPoint.proceed();
// 		return obj;
// 	}
// }

