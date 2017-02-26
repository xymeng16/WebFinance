package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.DetailWorkDao;
import entity.DetailWork;
public class dodetailwork extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public dodetailwork() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  request.setCharacterEncoding("utf-8");  //…Ë÷√±‡¬Î 
		 PrintWriter out = response.getWriter();
		DetailWork dw =new DetailWork();
		dw.setUsername(request.getParameter("Username"));
		dw.setWork(request.getParameter("Work"));
		dw.setWorkplace(request.getParameter("Workplace"));
		dw.setWorkplacephone(request.getParameter("Workplacephone"));
		dw.setIncome(request.getParameter("Income"));
		dw.setLinkman(request.getParameter("Linkman"));
		dw.setLinkmanphone(request.getParameter("Linkmanphone"));
		  if (DetailWorkDao.Findusername(dw.getUsername())==false){
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
		if (dw.getIncome().length()==0||dw.getLinkman().length()==0||dw.getLinkmanphone().length()==0||dw.getWork().length()==0||dw.getWorkplace().length()==0||dw.getWorkplacephone().length()==0)
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
		DetailWorkDao.InsertInfo(dw.getUsername(), dw.getWork(), dw.getWorkplacephone(), dw.getIncome(), dw.getWorkplacephone(), dw.getLinkman(), dw.getLinkmanphone());
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
