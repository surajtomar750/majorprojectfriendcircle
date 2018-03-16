package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.nis.controller.DBHelper;
import com.nis.controller.TrackingController;

/**
 * Servlet implementation class SearchFriends
 */
@WebServlet("/SearchFriends")
public class SearchFriends extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFriends() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		System.out.println(request.getParameter("mobile"));
	    ResultSet rs=TrackingController.searchByMobileNo(request.getParameter("mobile"));	 
	    ArrayList<JSONObject>L=DBHelper.JsonEngine(rs);
	    out.println(L);
	}

}
