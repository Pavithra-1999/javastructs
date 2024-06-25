package com.akhm.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.akhm.dao.UserDAO;
import com.akhm.dao.model.UserTl;
import com.akhm.utils.JDBCUtils;

public class UserDAOImpl implements UserDAO {

	@Override
	public Integer insertuser(UserTl userTl) {
		Integer userId = 0;
		PreparedStatement pst = null;
		try {
			String sql = "inser into user_tl(first_name,last_name,emailId,mobile_no,password,dob)values(?,?,?,?,?,?)";
			pst = JDBCUtils.getConnection().prepareStatement(sql);
			pst.setString(1, userTl.getFirstName());
			pst.setString(2, userTl.getLastName());
			pst.setString(3, userTl.getEmailId());
			pst.setString(4, userTl.getMobileNo());
			pst.setString(5, userTl.getPasword());
			pst.setDate(6, userTl.getDob());
			userId = pst.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeStatement(pst);
		}
		return userId;
	}

}
