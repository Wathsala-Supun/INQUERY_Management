
package com;

import java.sql.*;
import java.util.Base64;

public class Bill {
	//DataBase Connection
	
		private static final String Email = null;
		private static String url = "jdbc:mysql://localhost:3306/inquery_management";
		private static String userName = "root";
		private static String password = "12345";
		
		
		public Connection connect()
		{
		Connection con = null;
		
		try
		{
		  Class.forName("com.mysql.jdbc.Driver");
		  con= DriverManager.getConnection(url,userName,password);
		  //For testing
		  System.out.print("Successfully connected");
		}
		catch(Exception e)
		{
			System.out.println("Database connection is not success!!!");
		}
		
		return con;
		}

		//user management
		public String AllUsers() {
			// TODO Auto-generated method stub
			String output = "";
			try
			{
				Connection con = connect();
				if (con == null)
				{return "Error while connecting to the database for reading."; }
				// Prepare the html table to be displayed
				output = "<table border=\"1\"><tr><th>User ID</th><th>Name</th><th>Acc.Number</th><th>Date</th><th>INQ.Rerson</th><th>INQ.Desecription</th><th>E-mail</th><th>";




				String query = "select * from inquery   ";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);


				// iterate through the rows in the result set
				while (rs.next())
				{
					String inqID = Integer.toString(rs.getInt("inqID"));
					String name = rs.getString("name");
					String acc_no = rs.getString("acc_no");
					String date = rs.getString("date");
					String inq_rerson = rs.getString("inq_rerson");
					String inq_des = rs.getString("inq_des");
					String Email = rs.getString("Email");
					

					// Add into the html table
					output += "<tr><td>" + inqID + "</td>";
					output += "<td>" + name + "</td>";
					output += "<td>" + acc_no + "</td>";
					output += "<td>" + date + "</td>";
					output += "<td>" + inq_rerson + "</td>";
					output += "<td>" + inq_des + "</td>";
					output += "<td>" + Email + "</td>";
				

					// buttons
					output += "<td><input name='btnUpdate' type='button' value='Update' "
							+ "class='btnUpdate btn btn-success' data-itemid='" + inqID + "'></td>"
							+ "<td><input name='btnRemove' type='button' value='Remove' "
							+ "class='btnRemove btn btn-danger' data-itemid='" + inqID + "'></td></tr>";


				}
				con.close();

				// Complete the html table
				output += "</table>";
			}
			catch (Exception e)
			{
				output = "Error while reading the inquery.";
				System.err.println(e.getMessage());
			}
			return output;
		}


		//read users
		public String viewRegUsers() {
			// TODO Auto-generated method stub
			String output = "";
			try
			{
				Connection con = connect();
				if (con == null)
				{return "Error while connecting to the database for reading."; }
				// Prepare the html table to be displayed
				output = "<table border=\"1\"><tr><th>Name</th><th>Acc.Number</th><th>Date</th><th>INQ.Rerson</th><th>INQ.Desecription</th><th>Email</th>";

	                      

				//String query = "select * from users  where username = '"+usr+"'";
				String query = "select * from inquery   ";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);


				// iterate through the rows in the result set
				while (rs.next())
				{
					String inqID = Integer.toString(rs.getInt("inqID"));
					String name = rs.getString("name");
					String acc_no = rs.getString("acc_no");
					String date = rs.getString("date");
					String inq_rerson = rs.getString("inq_rerson");
					String inq_des = rs.getString("inq_des");
					String Email = rs.getString("Email");
					

					// Add into the html table
					
					output += "<tr><td>" + inqID + "</td>";
					output += "<td>" + name + "</td>";
					output += "<td>" + acc_no + "</td>";
					output += "<td>" + date + "</td>";
					output += "<td>" + inq_rerson + "</td>";
					output += "<td>" + inq_des + "</td>";
					output += "<td>" + Email + "</td>";
				

					// buttons
					output += "<td><input name='btnUpdate' type='button' value='Update' "
							+ "class='btnUpdate btn btn-success' data-itemid='" + inqID + "'></td>"
							+ "<td><input name='btnRemove' type='button' value='Remove' "
							+ "class='btnRemove btn btn-danger' data-itemid='" + inqID + "'></td></tr>";


				}
				con.close();

				// Complete the html table
				output += "</table>";
			}
			catch (Exception e)
			{
				output = "Error while reading the users.";
				System.err.println(e.getMessage());
			}
			return output;
		}


		//insert Users
		public String insertinquery(String name, String acc_no, String date, String inq_rerson, String inq_des,String Email)
		{
			String output = "";
			/*
			 * String regex = "^(.+)@(.+)$";
			 * 
			 * // String regex2 ="^\\d{10}$"; String regex3="^[0-9]{9}[vVxX]$";
			 */

			try
			{
				Connection con = connect();
				if (con == null)
				{
					return "Error while connecting to the database for inserting."; 
				}
				// create a prepared statement
				String query = " insert into inquery (`inqID`,`name`,`acc_no`,`date`,`inq_rerson`,`inq_des`,`Email`)" + " values (?, ?, ?, ?, ?,?,?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, name);
				preparedStmt.setString(3, acc_no);
				preparedStmt.setString(4, date);
				preparedStmt.setString(5, inq_rerson);
				preparedStmt.setString(6, inq_des);
				preparedStmt.setString(7, Email);
		
				// execute the statement
				preparedStmt.execute();
				con.close();

				String newUsers = viewRegUsers();
				output = "{\"status\":\"success\", \"data\": \"" + newUsers + "\"}";

				
			}
			catch (Exception e)
			{
				output = "{\"status\":\"error\", \"data\": \"Error while inserting the user.\"}";
				System.err.println(e.getMessage());
			}
			return output;
		}






		//update profile details

		public String updateinqueryinfo(String inqID,String name, String acc_no, String date, String inq_rerson, String inq_des,String Email)  {  
			String output = ""; 

			try   {    
				Connection con = connect(); 

				if (con == null)   
				{
					return "Error while connecting to the database for updating."; 

				} 

				String query = "UPDATE inquery SET name=?,acc_no=?,date=?,inq_rerson=?,inq_des=?,Email=? WHERE inqID=?"; 

				PreparedStatement preparedStmt = con.prepareStatement(query); 


				preparedStmt.setString(1, name);   
				preparedStmt.setString(2, acc_no);   
				preparedStmt.setString(3, date);  
				preparedStmt.setString(4, inq_rerson); 
				preparedStmt.setString(5, inq_des); 
				preparedStmt.setString(6, Email); 
				
				//preparedStmt.setString(8,  password);

				
				preparedStmt.execute();   
				con.close(); 

				String newUsers = viewRegUsers();
				output = "{\"status\":\"success\", \"data\": \"" + newUsers + "\"}"; 

			}  
			catch (Exception e)   
			{  
				output = "{\"status\":\"error\", \"data\":\"Error while updating the user.\"}";
				System.err.println(e.getMessage());
			} 

			return output; 
		} 




		//delete profile details

		public String deleteUserinfo(String inqID)  {   

			String output = ""; 

			try   {   

				Connection con = connect(); 

				if (con == null)    

				{
					return "Error while connecting to the database for deleting.";

				} 

				String query = "delete from inquery where inqID=?"; 

				PreparedStatement preparedStmt = con.prepareStatement(query); 

				preparedStmt.setInt(1, Integer.parseInt(inqID)); 

				preparedStmt.execute();   
				con.close(); 

				String newUsers = viewRegUsers();
				output = "{\"status\":\"success\", \"data\": \"" + newUsers + "\"}";


			} 
			catch (Exception e)  
			{    
				output = "{\"status\":\"error\", \"data\":\"Error while deleting the user.\"}";
				System.err.println(e.getMessage()); 
			} 

			return output; 
		} 



				}