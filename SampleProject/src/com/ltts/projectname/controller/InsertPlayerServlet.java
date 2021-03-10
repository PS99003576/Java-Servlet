package com.ltts.projectname.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltts.projectname.Dao.PlayerDao;
import com.ltts.projectname.model.Player;

/**
 * Servlet implementation class InsertPlayerServlet
 */
@WebServlet("/InsertPlayerServlet")
public class InsertPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPlayerServlet() {
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
		int no=Integer.parseInt(request.getParameter("pid"));
		String name=request.getParameter("pname");
		String Dob = request.getParameter("pDOB");
		Date pdate=Date.valueOf(Dob);
		String nationality=request.getParameter("pcountry");
		String skills = request.getParameter("pskills");
		int runs=Integer.parseInt(request.getParameter("pruns"));
		int wickets=Integer.parseInt(request.getParameter("pwickets"));
		int matches=Integer.parseInt(request.getParameter("pmatches"));
		int teamid=Integer.parseInt(request.getParameter("pteamid"));
		Player p=new Player(no,name,pdate,nationality,skills,runs,wickets,matches,teamid);
		System.out.println("Inside Servlet: "+p);
		PlayerDao pd=new PlayerDao();
		boolean b=false;
		try {
			b=pd.insertPlayer(p); // Control TRanfers to Dao file
			System.out.println("Successfully Inserted...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
