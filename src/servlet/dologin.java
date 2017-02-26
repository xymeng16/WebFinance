package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDao;

/**
 * Servlet implementation class dologin
 */
@WebServlet("/dologin")
public class dologin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String username = null;
	String password = null;
	String password2 = null;
	String checkcode = null;
	String checkcode2 = null;
	String[] iscookie = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public dologin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=gb2312");
		username = request.getParameter("Username");
		password = request.getParameter("Password");
		checkcode = request.getParameter("Checkcode");
		checkcode2 = (String) request.getSession().getAttribute("checkcode");
		iscookie = request.getParameterValues("Iscookie");
   
     //   System.out.println(iscookie);
		if (UserDao.Check(checkcode.toUpperCase(), checkcode2) == false) {
			out.println("<html><head>");
			out.println("</head>");
			out.println("<body>");
			out.println("<script type='text/javascript'>");
			out.println("alert('CHECKCODE WRONG')");
			out.println("history.back()");
			out.println("</script>");
			out.println("</body>");
			out.println("</html>");
			return;
		}
		if (UserDao.Findusername(username) == true) {
			out.println("<html><head>");
			out.println("</head>");
			out.println("<body>");
			out.println("<script type='text/javascript'>");
			out.println("alert('USER NOT EXISTE')");
			out.println("history.back()");
			out.println("</script>");
			out.println("</body>");
			out.println("</html>");
			return;

		}
		password2 = UserDao.user_pass(username);
		if (UserDao.Check(password, password2) == false) {
			out.println("<html><head>");
			out.println("</head>");
			out.println("<body>");
			out.println("<script type='text/javascript'>");
			out.println("alert('PASSWORD WRONG')");
			out.println("history.back()");
			out.println("</script>");
			out.println("</body>");
			out.println("</html>");
			return;
		}
		if (iscookie != null) {
			Cookie cookie1 = new Cookie("username", username);
			Cookie cookie2 = new Cookie("password", password);
			cookie1.setMaxAge(700000);
			cookie2.setMaxAge(700000);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
		} else {
			Cookie[] cookies = request.getCookies();
			if (cookies != null ) {
				for (Cookie c : cookies) {
					if ("usernmae".equals(c.getName())
							|| "password".equals(c.getName())) {
						c.setMaxAge(0);
						response.addCookie(c);
					}
				}
			}
		}
		 request.getSession().setAttribute("username", username);
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
        response.sendRedirect("/Finance/pcenter.jsp");
        out.close();
	}

}
