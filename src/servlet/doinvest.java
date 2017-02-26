package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.ToBorrowDao;
import entity.ToBorrow;
import java.lang.Math;
public class doinvest extends HttpServlet {

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
		
		int pageNos = Integer.parseInt(request.getParameter("pageNos"));
//		System.out.println(pageNos);
	    List<Map<String,Object>> list =list = ToBorrowDao.getResult(pageNos);
//	    System.out.println(list.get(0).get("ID"));
	    List<ToBorrow>  resultList = new ArrayList<ToBorrow>();
	    for (Map<String,Object> map :list){
	    	ToBorrow tb = new ToBorrow(map);
//	    	System.out.println((Math.floor((tb.getId()-1)/3)+1 ));
	    	if (pageNos==1 && request.getSession().getAttribute("totalPage")==null){
	    		int temp=(int)((tb.getId()-1)/3)+1;
	    	request.getSession().setAttribute("totalPage",temp);
	    	}
	    	resultList.add(tb);
	    	
	    }
	    request.getSession().setAttribute("result", resultList);
	  
	request.getSession().setAttribute("pageNos", pageNos);
	    response.sendRedirect("/Finance/toinvest.jsp");
	    out.close();
	     
	    
	}

}
