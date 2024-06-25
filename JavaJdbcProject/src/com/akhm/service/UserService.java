package com.akhm.service;

import java.util.List;

import com.akhm.service.dto.UserDTO;

public interface UserService {

	public Integer saveUser(UserDTO userDTO);

	public List<UserDTO> loadAllUsers();

	public UserDTO loadUser(Integer userId);

	public Integer removeUser(Integer userId);
	public Integer updateUser(UserDTO userDTO);
}
