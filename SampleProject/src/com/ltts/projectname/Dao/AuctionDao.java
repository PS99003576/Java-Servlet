package com.ltts.projectname.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ltts.projectname.configure.MyConnection;
import com.ltts.projectname.model.Auction;
import com.mysql.cj.xdevapi.Statement;

public class AuctionDao {
	
	public List<Auction> AuctionDao()
	{
		List<Auction> li= new ArrayList<Auction>();
		return li;
	}
	public Auction getAuctionById(int id)
	{
		Auction p=new Auction();
		return p;
	}
	
	
	public boolean insertAuction(Auction a) throws Exception
	{
		Connection c= MyConnection.getConnection();
		
		PreparedStatement ps= c.prepareStatement("insert into auction values(?,?,?,?,?)");
		ps.setInt(1,a.getAuctionId());
		ps.setInt(2, a.getPlayerId());
		ps.setInt(3, a.getTeamId());
		ps.setInt(4, a.getYear());
		ps.setInt(5,a.getAmount());
		return ps.execute();
	}
	
	
	public List<Auction> getAllAuction() throws Exception{
		List<Auction> li=new ArrayList<Auction>();
		Connection mc=MyConnection.getConnection(); // TRanfers control to another 
		java.sql.Statement ps=mc.createStatement();
		ResultSet rs=ps.executeQuery("select * from auction");
	
		while(rs.next()) {
			li.add(new Auction(rs.getInt(1), rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5)));
			
		}
		return li;
}
}
