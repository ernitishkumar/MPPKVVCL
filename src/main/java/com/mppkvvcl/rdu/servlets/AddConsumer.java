package com.mppkvvcl.rdu.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mppkvvcl.rdu.bean.Consumer;
import com.mppkvvcl.rdu.dao.ConsumerDAO;

/**
 * Servlet implementation class AddConsumer
 */
public class AddConsumer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddConsumer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String deviceSelected=request.getParameter("deviceSelected");
		
		String accountNumber=request.getParameter("accountnumber");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String poleNumber=request.getParameter("polenumber");
		String terminalNumber=request.getParameter("terminalnumber");
		
		
		//Adding values from jsp to bean
		
		Consumer consumer=new Consumer();
		consumer.setDevice(deviceSelected);
		consumer.setAccountNumber(accountNumber);
		consumer.setName(name);
		consumer.setAddress(address);
		consumer.setPoleNumber(poleNumber);
		consumer.setTerminalNumber(terminalNumber);
		
		
		//Persisting the Consumer to DAO
		ConsumerDAO consumerDAO=new ConsumerDAO();
		
		int updatedRow=consumerDAO.addConsumer(consumer);
		
		if(updatedRow==-1)
		{
			
		response.getWriter().write(" \n The terminal number and device number are duplicate! Please re-check.. ");	
		
		
		
		
		}else{
		System.out.println(updatedRow);
		
		RequestDispatcher view = request.getRequestDispatcher("addconsumers.jsp");
		view.forward(request, response);
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
