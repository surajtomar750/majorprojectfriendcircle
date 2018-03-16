package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.TrackingController;
import com.nis.model.Tracking;

/**
 * Servlet implementation class TrackingSubmit
 */
@WebServlet("/TrackingSubmit")
public class TrackingSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrackingSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
	 Tracking T=new Tracking();
	 T.setMobileno(request.getParameter("txtMobile"));
	 T.setTrackingdate(request.getParameter("txtDate"));
	 T.setTrackingtime(request.getParameter("txtTime"));
	 T.setLat(request.getParameter("txtLat"));
	 T.setLng(request.getParameter("txtLng"));
	 T.setAddress(request.getParameter("txtAdress"));
	 
	 
	  boolean st=TrackingController.insert(T);
	  
	    
	   System.out.print(st);}
	      
	 
	}
	
	
	
	

 
