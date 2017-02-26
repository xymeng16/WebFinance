package filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class judgefilter implements Filter {
     String username;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
	    HttpServletRequest request = (HttpServletRequest)arg0;
	    HttpServletResponse response=(HttpServletResponse)arg1;
	    username = (String)request.getSession().getAttribute("username");
        if (username==null){
        	arg2.doFilter(arg0,arg1);
        }
        else{
        	response.sendRedirect("pcenter.jsp");
        }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
