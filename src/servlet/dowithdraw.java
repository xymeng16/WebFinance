package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDao;
import entity.UserInfo;
public class dowithdraw extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public dowithdraw() {
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
		PrintWriter out = response.getWriter();
		UserInfo ui = new UserInfo();
		ui.setUsername((String)request.getSession().getAttribute("username"));
		int temp = Integer.parseInt(request.getParameter("Withdraw"));
		int now = UserDao.getProperty(ui.getUsername());
		if (temp<=now){
		UserDao.withdrawProperty(ui.getUsername(), temp);
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

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	
	}

}
