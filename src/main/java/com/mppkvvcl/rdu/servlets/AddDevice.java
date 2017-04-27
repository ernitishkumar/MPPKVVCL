package com.mppkvvcl.rdu.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mppkvvcl.rdu.bean.Device;
import com.mppkvvcl.rdu.dao.DeviceDAO;

/**
 * Servlet implementation class AddDevice
 */
public class AddDevice extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddDevice() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			Device device=new Device();
			//Conversiom of Incoming Data
			
			
			String deviceName=request.getParameter("device");
			String nameOfFeeder=request.getParameter("nameoffeeder");
			String poleNumber=request.getParameter("polenumber");
			String dateOfInstallationInString=request.getParameter("dateofinstallation");
			//String to Date conversion
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
			Date dateOfInstallation = sdf.parse(dateOfInstallationInString);
			String zoneName=request.getParameter("zonename");
			//String to long conversion
			Long simNumber= Long.parseLong(request.getParameter("simnumber"));
			
			//Populating the Bean object with incoming data
			device.setDevice(deviceName);
			device.setNameOfFeeder(nameOfFeeder);
			device.setPoleNumber(poleNumber);
			device.setZoneName(zoneName);
			device.setSimNo(simNumber);
			device.setDateOfInstallation(dateOfInstallation);
			
			//Calling the DAO object for persisting the data
			
			int updateRow=new DeviceDAO().addDevice(device);
			
			System.out.println("Number of device updated  : "+updateRow);
			response.getWriter().append(updateRow+ "Number of device updated!");
			RequestDispatcher view = request.getRequestDispatcher("adddevice.jsp");
			view.forward(request, response);
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
