package com.nis.controller;

import java.sql.Connection;
import java.sql.ResultSet;

import com.nis.model.Tracking;

public class TrackingController {
	public static boolean insert(Tracking T)
	{ try{
		Connection cn=DBHelper.openConnection();
		String q="insert into tracking(mobileno,trackingdate,trackingtime,lat,lng,address) values('"+T.getMobileno()+"','"+T.getTrackingdate()+"','"+T.getTrackingtime()+"','"+T.getLat()+"','"+T.getLng()+"','"+T.getAddress()+"')";
		System.out.println(q);
		boolean st=DBHelper.executeUpdate(cn, q);
		return(st);
	}catch(Exception e){ 
	System.out.println(e);	
	return(false);}
	}
	
	
	
	public static ResultSet searchByMobileNo(String mobile)
	{ try{
		Connection cn=DBHelper.openConnection();												// is point par t.mobileno tha
		String q="select r.*,t.* from registration r,tracking t where (r.mobile=t.mobileno) and (t.mobile='"+mobile+"') order by t.trackingtime,t.trackingdate limit 0,10";  
		System.out.println(q);
		ResultSet rs=DBHelper.executeQuery(cn, q);
		return(rs);
	}catch(Exception e){ 
	System.out.println(e);	
	return(null);}
	}
	
}
