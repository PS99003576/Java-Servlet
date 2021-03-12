package com.ltts.projectname.Dao;


import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ltts.projectname.configure.MyConnection;
import com.ltts.projectname.model.Player;
import com.mysql.cj.xdevapi.Statement;




public class PlayerDao {
	
	public Player getPlayerById(int id) throws Exception {
		Player p=new Player();
		List<Player> li=getAllPlayers();
		for(Player p1:li) {
			if(p1.getPlayer_id() == id) {
				p.setPlayer_id(id);
				p.setName(p1.getName());
				p.setDateOfBirth(p1.getDateOfBirth());
				p.setNationality(p1.getNationality());
				p.setSkills(p1.getSkills());
				p.setRuns(p1.getRuns());
				p.setWickets(p1.getWickets());
				p.setNumber_of_matches(p1.getNumber_of_matches());
				p.setTeam_id(p1.getTeam_id());
			}
		}
		
		return p;
	}
	public boolean insertPlayer(Player p) throws Exception
	{
		Connection c= MyConnection.getConnection();
		PreparedStatement ps= c.prepareStatement("insert into player values(?,?,?,?,?,?,?,?,?)");
		ps.setInt(1, p.getPlayer_id());
		ps.setString(2, p.getName());
		ps.setDate(3,(Date) p.getDateOfBirth());
		ps.setString(4, p.getNationality());
		ps.setString(5, p.getSkills());
		ps.setInt(6, p.getRuns());
		ps.setInt(7, p.getWickets());
		ps.setInt(8, p.getNumber_of_matches());
		ps.setInt(9, p.getTeam_id());
		System.out.println("Data Inserted Succesfully");
		return ps.execute();
		
	}
	public List<Player> getAllPlayers() throws Exception{
		List<Player> li=new ArrayList<Player>();
		Connection mc=MyConnection.getConnection(); // TRanfers control to another 
		java.sql.Statement ps=mc.createStatement();
		ResultSet rs=ps.executeQuery("select * from player");
		//Player p=new Player();
		while(rs.next()) {
			li.add(new Player(rs.getInt(1),rs.getString(2),rs.getDate(3), rs.getString(4),rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
			
		}
		return li;
		
	}
	

	public boolean updatePlayer(int id,String name) throws Exception
	{
		Connection c= MyConnection.getConnection();
		PreparedStatement ps= c.prepareStatement("UPDATE player SET name=? WHERE playerid=?");
		ps.setString(1, name);
		ps.setInt(2, id);
		System.out.println("Data Updated Succesfully");
		return ps.execute();
	}
	
	public void showPlayer() throws Exception
	{
		Connection c= MyConnection.getConnection();
		PreparedStatement ps=c.prepareStatement("Select * from player;");
		ps.execute();
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDate(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getInt(7)+" "+rs.getInt(8)+" "+rs.getInt(9));
			
		}
	}

}