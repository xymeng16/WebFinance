package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDao;

import entity.ToBorrow;

public class fruit extends HttpServlet {

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
		request.setCharacterEncoding("utf-8");  //ÉèÖÃ±àÂë
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		ToBorrow tb = (ToBorrow) request.getSession().getAttribute("tb");
		String investor = (String) request.getSession().getAttribute("username");
		int now = UserDao.getProperty(investor);
		int amount = Integer.parseInt(request.getParameter("Fruit"));
		if (now>=amount){
		UserDao.payProperty(tb.getUsername(), amount);
		UserDao.withdrawProperty(investor, amount);
		response.sendRedirect("/Finance/pcenter.jsp");
		}
		else{
			out.println("<html><head>");
	          out.println("</head>");
	          out.println("<body>");
	          out.println("<script type='text/javascript'>");
	          out.println("alert('YOU DONT HAVE SUCH MONEY')");
	          out.println("history.back()");
	          out.println("</script>");
	          out.println("</body>");
	          out.println("</html>");
	          out.close();
	          return;
		}
	}

}
