package com.mppkvvcl.rdu.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mppkvvcl.rdu.bean.LoginBean;
import com.mppkvvcl.rdu.dao.LoginDAO;
/**  ashish kumar tiwari **/
/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		LoginBean loginBean=new LoginBean();
		boolean authenticate=false;
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
	
		
		if(username!=null && password!=null)
		{
			loginBean.setUsername(username);
			loginBean.setPassword(password);
			
			authenticate=new LoginDAO().checkLogin(loginBean);
			
		}
		
		if(authenticate)
		{
			
			HttpSession httpSession =request.getSession(true);
			httpSession.setAttribute("userbean", loginBean);
			
			response.sendRedirect("home.jsp");
			
		}
		else{
			
			response.sendRedirect("index.html");
			
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
