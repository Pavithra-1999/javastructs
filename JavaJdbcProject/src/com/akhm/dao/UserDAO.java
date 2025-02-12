package com.akhm.dao;

import java.util.List;

import com.akhm.UserApplication;
import com.akhm.dao.model.UserTl;

public interface UserDAO {

	// this is for inserting the user details in the database
	public Integer insertUser(UserTl usertl);

	// this is for getting the list of all users
	public List<UserTl> getAllUsers();

	// getting user based on id
	public UserTl getUser(Integer userId);
	
	public Integer deleteUser(Integer userId);
	
	public Integer updateUser(UserTl userTl);

}
