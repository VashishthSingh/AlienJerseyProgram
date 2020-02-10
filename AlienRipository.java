package com.test.TestExample;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class AlienRipository {
	List<Alien> list;
	public static Connection createConnection() {
		Connection con=null;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=(Connection) DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/report?useSSL=false","root","password");  
		}catch(Exception e){ 
				System.out.println(e);
		}  
		return(con); 
	}  

	public List<Alien> getAliens(){
		List<Alien> list=new ArrayList<Alien>();
		Alien alien;
		try {
		  Connection con=AlienRipository.createConnection();
		  Statement stmt=(Statement) con.createStatement();  
		  ResultSet rs=stmt.executeQuery("select * from alienTable");
		  while(rs.next()) {
			alien=new Alien();
			alien.setName(rs.getString("name"));
			alien.setId(rs.getInt("id"));
			alien.setPoints(rs.getInt("points"));
			list.add(alien);
		  }
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return(list);
	}
	public Alien getAlien(int id) {
		Alien alien=new Alien();
		try {
			  Connection con=AlienRipository.createConnection();
			  PreparedStatement stmt=(PreparedStatement) con.prepareStatement("select * from alienTable where id=?");   
			  stmt.setInt(1,id);
			  ResultSet rs=stmt.executeQuery();
			  if(rs.next()) {
				  alien=new Alien();
				  alien.setId(rs.getInt("id"));
				  alien.setName(rs.getString("name"));
				  alien.setPoints(rs.getInt("points"));
			  }
		}
		catch(Exception e){
				System.out.println(e);
		}
		return(alien);
	}
	public void insertAlien(Alien a) {
		try {
			  Connection con=AlienRipository.createConnection();
			  PreparedStatement stmt=(PreparedStatement) con.prepareStatement("insert into alienTable(name,id,points) values(?,?,?)");   
			  stmt.setString(1, a.getName());
			  stmt.setInt(2,a.getId());
			  stmt.setInt(3, a.getPoints());
			  int rs=stmt.executeUpdate();
			  if(rs==1)
				  System.out.println("Alien Inserted Successfully..");
			  else
				  System.out.println("Alien Could't Inserted Successfully.."); 
		}
		catch(Exception e){
				System.out.println(e);
		}	
	}
	public String delete(int id) {
		String result=null;
		try {
			  Connection con=AlienRipository.createConnection();
			  PreparedStatement stmt=(PreparedStatement) con.prepareStatement("delete from alienTable where id=?");   
			  stmt.setInt(1,id);
			  int rs=stmt.executeUpdate();
			  if(rs==1)
				  result="Successfully Alien Deleted..";
			  else
				  result="Alien Could't Be Deleted..";
		}
		catch(Exception e){
				System.out.println(e);
		}
		return(result);
	}
	public String update(Alien alien) {
		String result=null;
		try {
			  Connection con=AlienRipository.createConnection();
			  PreparedStatement stmt=(PreparedStatement) con.prepareStatement("update alienTable set name=?,points=? where id=?");   
			  stmt.setString(1,alien.getName());
			  stmt.setInt(2,alien.getPoints());
			  stmt.setInt(3,alien.getId());
			  int rs=stmt.executeUpdate();
			  if(rs==1)
				  result="Successfully Alien Updated..";
			  else
				  result="Alien Could't Be Updated..";
		}
		catch(Exception e){
				System.out.println(e);
		}
		return(result);
	}
}




