package com.nis.controller;

import java.sql.Connection;
import com.nis.model.Registration;
import java.sql.ResultSet;

public class RegistrationController {

public static boolean insert(Registration R)
{ try{
	Connection cn=DBHelper.openConnection();
	String q="insert into registration values('"+R.getFriendname()+"','"+R.getMobileno()+"','"+R.getDob()+"','"+R.getGender()+"','"+R.getEmail()+"','"+R.getPassword()+"','"+R.getPhotograph()+"')";
	boolean st=DBHelper.executeUpdate(cn, q);
	return(st);
	
}catch(Exception e){}
	return(false);
}

public static ResultSet checkLogin(String ep,String pwd)
{ try{
	Connection cn=DBHelper.openConnection();
	String q="select * from registration where (mobile='"+ep+"' or email='"+ep+"') and password='"+pwd+"'";
	ResultSet rt=DBHelper.executeQuery(cn, q);

	return rt;
	
}catch(Exception e){}
	return(null);
}



}
