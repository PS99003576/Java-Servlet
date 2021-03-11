package com.ltts.projectname.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.ltts.projectname.configure.MyConnection;
import com.ltts.projectname.model.Auction;

public class AuctionDao {
	
	
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
}
