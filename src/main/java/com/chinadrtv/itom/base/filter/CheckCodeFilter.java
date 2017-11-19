package com.chinadrtv.itom.base.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证验证码是否正确
 * @author Fu Qinghui<qinghui.fu@capgemini.com>
 * @version 2013-5-31 下午5:18:55
 */
public class CheckCodeFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest req = (HttpServletRequest)request;
		 HttpServletResponse resp = (HttpServletResponse)response;
		 String inputCode = request.getParameter("validCode").toLowerCase();
		 String generageCode =((String)req.getSession().getAttribute("checkCode")).toLowerCase();
		 if (inputCode.equals(generageCode)){
			 chain.doFilter(request, response);
		 }else{
			 resp.sendRedirect(req.getContextPath()+"/toLogin?error=false");
		 }
	}

	@Override
	public void destroy() {
	}

}
