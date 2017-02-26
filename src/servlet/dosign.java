package servlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import DAO.UserDao;
/**
 * Servlet implementation class dosign
 */
@WebServlet("/dosign")
public class dosign extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String username = null;
       String password =null;
       String email = null;
       String repassword =null;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dosign() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out = response.getWriter();
		 response.setContentType("text/html; charset=gb2312");
		request.setCharacterEncoding("utf-8");
		username=request.getParameter("Username");
	    password=request.getParameter("Password");
	    email=request.getParameter("Email");
	    repassword = request.getParameter("Confirm_Password");
	    
	    if (username.length()==0 || password.length()==0||email.length()==0||repassword.length()==0){
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
	   	    if (UserDao.Findusername(username)==false){
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
	    if (UserDao.FindEmail(email)==false){
	          out.println("<html><head>");
	          out.println("</head>");
	          out.println("<body>");
	          out.println("<script type='text/javascript'>");
	          out.println("alert('EMAIL HAVE EXISTED')");
	          out.println("history.back()");
	          out.println("</script>");
	          out.println("</body>");
	          out.println("</html>");
	        return;
	    }
	    if (UserDao.Check(password,repassword)==false){
	          out.println("<html><head>");
	          out.println("</head>");
	          out.println("<body>");
	          out.println("<script type='text/javascript'>");
	          out.println("alert('MAKE SURE YOUR PASSWORD IS CONSISTENT')");
	          out.println("history.back()");
	          out.println("</script>");
	          out.println("</body>");
	          out.println("</html>");
	        return;   
	    }
	    
	    UserDao.InsertInfo(username, password, email);
	    request.getSession().setAttribute("username", username);
	    request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
	  response.sendRedirect("/Finance/pcenter.jsp");
	  out.close();
	}

}
