package com.akhm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
	private JdbcUtils() {
		
	}
	//step1
	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_servlet_db1","root","root");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	//step2
	public static Connection getConnection() {
		//singletern logic
		if(con==null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_servlet_db1","root","root");
			} catch (ClassNotFoundException cnfe) {
				cnfe.printStackTrace();
			}
			catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
				
			}
			
		}
		return con;
	
	
	}
	public static void closeStatement(Statement st) {
		if(st!=null) {
			try {
		        st.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//step3
	public static void closeResultSet(ResultSet rs) {
		if(rs!=null) {
			try {
			rs.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
