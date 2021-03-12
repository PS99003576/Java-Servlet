package com.ltts.projectname.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ltts.projectname.configure.MyConnection;
import com.ltts.projectname.model.user;

public class UserDao {
	
	public boolean insertUser(user us) throws Exception
	{
		Connection c= MyConnection.getConnection();
		
		PreparedStatement ps= c.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
	
		ps.setString(1, us.getEmailid() );
		ps.setString(2, us.getMobile());
		ps.setString(3, us.getName());
		ps.setDate(4, us.getDob());
		ps.setString(5, us.getAddress());
		ps.setString(6, us.getPassword());
		ps.setString(7, us.getUsertype());
		return ps.execute();
	}


	public boolean ValidUser(user us) throws Exception
	{
		Connection c = MyConnection.getConnection();
		Statement st = c.createStatement();
		ResultSet rs;
		boolean status = false;
		rs = st.executeQuery("select * from user where name = '"+us.getName()+"' and password = '" +us.getPassword()+"'");
		status = rs.next();
		return status;
	}
	
	
	
	
}
