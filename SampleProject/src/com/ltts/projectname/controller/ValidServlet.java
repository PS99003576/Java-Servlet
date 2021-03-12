package com.ltts.projectname.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltts.projectname.Dao.UserDao;
import com.ltts.projectname.model.user;

/**
 * Servlet implementation class ValidServlet
 */
@WebServlet("/ValidServlet")
public class ValidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidServlet() {
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
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
	
		
		user u = new user(name,password);
		
	//	Valid u=new Valid(name,password);
		System.out.println("Inside Servlet: "+u);
		
		
		//System.out.println("Inside Servlet: "+u);
		UserDao pd=new UserDao();
		
		//boolean b=false;
		try {
			if(pd.ValidUser(u))
			{
				response.sendRedirect("index.html");
			}
			else
			{
				response.sendRedirect("restricted.jsp");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
