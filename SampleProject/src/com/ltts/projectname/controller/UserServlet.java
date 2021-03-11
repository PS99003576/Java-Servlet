package com.ltts.projectname.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltts.projectname.Dao.UserDao;
import com.ltts.projectname.model.user;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String emailid = request.getParameter("emailid");
		String mobile = request.getParameter("mobile");
		String name = request.getParameter("name");
		
		String dob = request.getParameter("dob");
		Date d = Date.valueOf(dob);
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		
		
		
		user u=new user(emailid,mobile,name,d,address,password,usertype);
		
		//System.out.println("Inside Servlet: "+u);
		UserDao pd=new UserDao();
		boolean b=false;
		try {
			b=pd.insertUser(u); // Control TRanfers to Dao file
			System.out.println("Successfully Inserted...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
