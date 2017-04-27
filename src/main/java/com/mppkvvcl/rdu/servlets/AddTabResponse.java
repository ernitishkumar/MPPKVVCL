package com.mppkvvcl.rdu.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mppkvvcl.rdu.bean.TabResponse;
import com.mppkvvcl.rdu.dao.TabResponseDAO;

/**
 * Servlet implementation class AddTabResponse
 */
public class AddTabResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTabResponse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Recieved Do Get request");
		// TODO Auto-generated method stub
		String deviceName=request.getParameter("devicename");
		String deviceSelected = request.getParameter("deviceSelected");
		String name=request.getParameter("name");
		String accountNumber=request.getParameter("accountnumber");
		String status=request.getParameter("status");
		String onoff=request.getParameter("onoff");
		String terminalNumber=request.getParameter("terminalnumber");
		String t1=request.getParameter("t1");
		String t2=request.getParameter("t2");
		String t3=request.getParameter("t3");
		String t4=request.getParameter("t4");
		String t5=request.getParameter("t5");
		String t6=request.getParameter("t6");
		
		
		System.out.println("Device Name "+deviceName + "     Name "+name+"    AccountNumber"+accountNumber+"     CurrentStatus "+status+"  Button click detail"+onoff+"  teminal Number is : "+terminalNumber);
		System.out.println("T1 "+t1);
		System.out.println("T2 "+t2);
		System.out.println("T3 "+t3);
		System.out.println("T4 "+t4);
		System.out.println("T5 "+t5);
		System.out.println("T6 "+t6);
		
		
		TabResponse tabResponse=new TabResponse();
		
		tabResponse.setDeviceName(deviceName);
		tabResponse.setT1(t1);
		tabResponse.setT2(t2);
		tabResponse.setT3(t3);
		tabResponse.setT4(t4);
		tabResponse.setT5(t5);
		tabResponse.setT6(t6);
		tabResponse.setStatus(onoff);
		tabResponse.setTerminalNumber(terminalNumber);
		
		TabResponseDAO tabResponseDAO=new TabResponseDAO();
		//int updatedRows=tabResponseDAO.addTabResponse(tabResponse);
		tabResponse=tabResponseDAO.addTabResponse(tabResponse);
		
		
		//response.getWriter().write("Changes done.."+updatedRows+"    Number of row inserted...");

		System.out.println("Forwarding request with deviceSelected as: "+deviceSelected);
		RequestDispatcher rd = request.getRequestDispatcher("/viewdetail.jsp");
		rd.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	
}
