package com.akhm.controller;

import java.util.List;

import com.akhm.service.UserService;
import com.akhm.service.dto.UserDTO;
import com.akhm.service.impl.UserServiceImpl;

public class UserController {

	private UserService userService;

	public UserController() {
		this.userService = new UserServiceImpl();
	}

	public Integer insertUser(UserDTO userDTO) {
		if (userDTO != null) {
			return userService.saveUser(userDTO);
		}

		return null;

	}

	public List<UserDTO> getAllUsers() {
		return userService.loadAllUsers();

	}

	public UserDTO getUser(Integer userId) {
		return userService.loadUser(userId);
	}

	public int deleteUser(Integer userId) {
		return userService.removeUser(userId);
	}

	public int updateUser(UserDTO userDTO) {
		return userService.updateUser(userDTO);

	}

}
