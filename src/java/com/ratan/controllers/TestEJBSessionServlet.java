package com.ratan.controllers;

import com.ratan.ejbs.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.naming.*;
import javax.rmi.PortableRemoteObject;

import java.util.Date;

public class TestEJBSessionServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strEmpName = request.getParameter("txtEmpNameS");
		
		System.out.println("Welcome to EJB - Session Bean :: ("+new Date()+")!!");
			
		String ejbMessage = "";			
		TestHome testHome = null;		
		
		try 
		{
			InitialContext ctx = new InitialContext();
			Object objref = ctx.lookup("com.ratan.ejbs.TestComponent");
		    testHome = (TestHome)PortableRemoteObject.narrow(objref,TestHome.class);		    		    
		}
		catch (Exception ne) 
		{
			System.out.println("Exception Occured in EJB-JNDI! - "+ne.getMessage());
			ne.printStackTrace();
		}

		try
		{
			TestComponent beanObj;			
			beanObj = testHome.create();
			
			ejbMessage = beanObj.displayHello(); 
			beanObj.remove();
		}
		catch(Exception ce)
		{
			System.out.println("Exception Occured in EJB-CREATE! - "+ce.getMessage());
			ce.printStackTrace();
		}
		
		PrintWriter pw = response.getWriter();		
		response.setContentType("text/html");		
		try
		{	
			String strVal = "";
			
			pw.print("<h5>Welcome to EJB - Session Bean...\nDate: ("+new Date()+")!!</h5>");
			pw.print("Hello Mr/Ms <strong>"+strEmpName+"</strong>!");	
			pw.print("<h6>EJB Message: "+ejbMessage+"!</h6>");	
			pw.print("<input type='button' value='Home Page' onclick='callMe();'/>");			
			pw.print("<script>function callMe(){history.go(-1);}</script>");
		}		
		catch(Exception e)
		{			
			System.out.println("Exception Occured in Controller! - "+e.getMessage());
		}	
	}	
}
