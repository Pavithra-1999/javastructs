package com.akhm.dao.impl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.akhm.dao.UserDAO;
import com.akhm.dao.model.UserTl;
import com.akhm.utils.JdbcUtils;

public class UserDAOImpl implements UserDAO {

	@Override
	public Integer insertUser(UserTl usertl) {
		Integer userId = 0;
		// PreparedStatement we can use placeholder
		PreparedStatement pst = null;
		try {
			String sql = "insert into user_tl (first_name,last_name,email_id,mobile_no,password,dob)values(?,?,?,?,?,?)";
			pst = JdbcUtils.getConnection().prepareStatement(sql);
			pst.setString(1, usertl.getFirstName());
			pst.setString(2, usertl.getLastName());
			pst.setString(3, usertl.getEmailId());
			pst.setString(4, usertl.getMobileNo());
			pst.setString(5, usertl.getPassword());
			pst.setDate(6, usertl.getDob());
			userId = pst.executeUpdate();

		} catch (SQLException sql) {
			sql.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeStatement(pst);

		}

		return userId;
	}

	@Override
	public List<UserTl> getAllUsers() {
		List<UserTl> users = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;

		try {
			String sql = "select user_id,first_name,last_name,email_id,mobile_no,password,dob from user_tl";
			st = JdbcUtils.getConnection().createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				UserTl userTl = new UserTl();
				userTl.setUserId(rs.getInt("user_id"));
				userTl.setFirstName(rs.getString("first_name"));
				userTl.setLastName(rs.getString("last_name"));
				userTl.setEmailId(rs.getString("email_id"));
				userTl.setMobileNo(rs.getString("mobile_no"));
				userTl.setPassword(rs.getString("password"));
				userTl.setDob(rs.getDate("dob"));
				users.add(userTl);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JdbcUtils.closeResultSet(rs);
			JdbcUtils.closeStatement(st);
		}

		return users;
	}

	@Override
	public UserTl getUser(Integer userId) {
		UserTl userTl = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "select user_id,first_name,last_name,email_id,mobile_no,password,dob from jdbc_servlet_db where User_Id=?";
			pst = JdbcUtils.getConnection().prepareStatement(sql);
			pst.setInt(1, userId);
			rs = pst.executeQuery();
			if (rs.next()) {
				userTl = new UserTl();
				userTl.setUserId(rs.getInt("user_id"));
				userTl.setFirstName(rs.getString("first_name"));
				userTl.setLastName(rs.getString("last_name"));
				userTl.setEmailId(rs.getString("email_id"));
				userTl.setMobileNo(rs.getString("mobile_no"));
				userTl.setPassword(rs.getString("password"));
				userTl.setDob(rs.getDate("dob"));
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JdbcUtils.closeResultSet(rs);
			JdbcUtils.closeStatement(pst);

		}
		return userTl;
	}

	@Override
	public Integer deleteUser(Integer userId) {
		int noofRowsDeleted = 0;

		CallableStatement cst = null;
		try {
			// procedure name
			String sql = "{call_delete_user(?) }";
			cst = JdbcUtils.getConnection().prepareCall(sql);
			cst.setInt(1, userId);
			noofRowsDeleted = cst.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeStatement(cst);
		}

		return noofRowsDeleted;
	}

	@Override
	public Integer updateUser(UserTl userTl) {
		int noOfRowsUpdated = 0;
		CallableStatement cst = null;
		try {
			// function call
			String sql = "{?=call update_user_function(?,?,?,?,?,?,?)}";
			cst = JdbcUtils.getConnection().prepareCall(sql);
			cst.setInt(2, userTl.getUserId());
			cst.setString(3, userTl.getFirstName());
			cst.setString(4, userTl.getLastName());
			cst.setString(5, userTl.getMobileNo());
			cst.setString(6, userTl.getEmailId());
			cst.setString(7, userTl.getPassword());
			cst.setDate(8, userTl.getDob());
			cst.execute();
			noOfRowsUpdated = cst.getInt(1);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeStatement(cst);
		}
		return noOfRowsUpdated;
	}

}
