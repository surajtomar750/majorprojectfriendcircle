package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.RegistrationController;
import com.nis.model.Registration;

/**
 * Servlet implementation class RegistrationSubmit
 */
@WebServlet("/RegistrationSubmit")
public class RegistrationSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try{
		  Registration R=new Registration();	
		R.setFriendname(request.getParameter("nameTxt"));
		R.setMobileno(request.getParameter("mobileTxt"));
		R.setDob(request.getParameter("dobTxt"));
		R.setGender(request.getParameter("gender"));
		R.setEmail(request.getParameter("emailTxt"));
		R.setPassword(request.getParameter("pwdTxt"));
		R.setPhotograph(request.getParameter("picture"));
		boolean st=RegistrationController.insert(R);
		out.print(st);
		
		
		}catch(Exception e){
		 	out.print("Error");
		}
	}

}
