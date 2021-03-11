package com.ltts.projectname.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltts.projectname.Dao.AuctionDao;
import com.ltts.projectname.model.Auction;

/**
 * Servlet implementation class InsertAuctionServlet
 */
@WebServlet("/InsertAuctionServlet")
public class InsertAuctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAuctionServlet() {
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
		PrintWriter out = response.getWriter(); 
		int auctionid = Integer.parseInt(request.getParameter("auctionId"));
		int playerid = Integer.parseInt(request.getParameter("playerId"));
		int teamid = Integer.parseInt(request.getParameter("teamId"));
		int year = Integer.parseInt(request.getParameter("year"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		
		Auction ab = new Auction(auctionid,playerid,teamid,year,amount);
		System.out.println("Inside Servlet: "+ab);
		AuctionDao pd=new AuctionDao();
		boolean b=false;
		RequestDispatcher rd=null;
		try {
			b=pd.insertAuction(ab); // Control TRanfers to Dao file
			rd=request.getRequestDispatcher("success.html");
			rd.forward(request, response);
			//System.out.println("Successfully Inserted...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.write("Already Player id Used: "+e);
			rd=request.getRequestDispatcher("addAuction.html");
			rd.include(request, response);
			e.printStackTrace();
		}
	}

}
