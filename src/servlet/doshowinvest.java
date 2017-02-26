package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.DetailMess;
import entity.ToBorrow;
import DAO.DetailMessDao;
import DAO.ToBorrowDao;
public class doshowinvest extends HttpServlet {

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
		response.setCharacterEncoding("utf-8");
		 PrintWriter out = response.getWriter();
		 int id = Integer.parseInt(request.getParameter("Id"));
//		 System.out.println(id);
		 ToBorrow tb =  new ToBorrow();
			tb = 	 ToBorrowDao.getById(id);
		 System.out.println(tb.getTitle());
		 DetailMess dm = DetailMessDao.getByUser(tb.getUsername());
		 System.out.println(dm.getIdcardfile());
		 request.getSession().setAttribute("tb", tb);
		 request.getSession().setAttribute("dm", dm);
		 response.sendRedirect("/Finance/showinvest.jsp");
		 out.close();
	}

}
