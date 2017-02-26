package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.ToBorrowDao;
import entity.ToBorrow;
public class dotoborrow extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  request.setCharacterEncoding("utf-8");  //…Ë÷√±‡¬Î 
		 PrintWriter out = response.getWriter();
		ToBorrow tb =new ToBorrow();
		tb.setUsername(request.getParameter("Username"));
		tb.setTitle(request.getParameter("Title"));
		tb.setRate(request.getParameter("Rate"));
		tb.setTarget(request.getParameter("Target"));
		tb.setTime(request.getParameter("Time"));
		tb.setCalculationway(request.getParameter("Calculationway"));
		tb.setWaytoback(request.getParameter("Waytoback"));
		tb.setDescription(request.getParameter("Description"));
		tb.setInstitution(request.getParameter("Institution"));
		  if (ToBorrowDao.Findusername(tb.getUsername())==false){
	        	out.println("<html><head>");
		          out.println("</head>");
		          out.println("<body>");
		          out.println("<script type='text/javascript'>");
		          out.println("alert('USER HAVE EXISTED')");
		          out.println("history.back()");
		          out.println("</script>");
		          out.println("</body>");
		          out.println("</html>");
		          return;
	        }
		if (tb.getTitle().length()==0||tb.getCalculationway().length()==0||tb.getDescription().length()==0||tb.getInstitution().length()==0||tb.getRate().length()==0||tb.getTarget().length()==0||tb.getTime().length()==0||tb.getWaytoback().length()==0)
		{
			out.println("<html><head>");
	          out.println("</head>");
	          out.println("<body>");
	          out.println("<script type='text/javascript'>");
	          out.println("alert('COMPLETE YOUR INFORMATION')");
	          out.println("history.back()");
	          out.println("</script>");
	          out.println("</body>");
	          out.println("</html>");
	          return;
		}
		ToBorrowDao.InsertInfo(tb.getUsername(), tb.getTitle(),tb.getRate(),tb.getTarget(),tb.getCalculationway(),tb.getWaytoback(),tb.getTime(),tb.getDescription(),tb.getInstitution());
		ToBorrowDao.createByUser(tb.getUsername());
		response.sendRedirect("/Finance/pcenter.jsp");
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
