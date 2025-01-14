package com.akhm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.akhm.dao.UserDAO;
import com.akhm.dao.impl.UserDAOImpl;
import com.akhm.dao.model.UserTl;
import com.akhm.exception.MyCustomException;
import com.akhm.service.UserService;
import com.akhm.service.dto.UserDTO;
import com.akhm.utils.FactoryUtils;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	public UserServiceImpl() {
		this.userDAO = new UserDAOImpl();

	}

	@Override
	public Integer saveUser(UserDTO userDTO) {

		Integer userId = 0;
		try {
			if (userDTO != null) {
				UserTl userTl = FactoryUtils.convertUserDTOToUserTl(userDTO);
				if (userTl != null) {
					userId = userDAO.insertUser(userTl);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userId;
	}

	@Override
	public List<UserDTO> loadAllUsers() {
		List<UserDTO> users = new ArrayList<>();

		try {
			List<UserTl> usersList = userDAO.getAllUsers();

			if (usersList != null && !usersList.isEmpty()) {
				ListIterator<UserTl> li = usersList.listIterator();
				while (li.hasNext()) {
					UserTl userTl = li.next();
					UserDTO userDTO = FactoryUtils.convertUserTlToUserDTO(userTl);
					users.add(userDTO);
				}

			}

		} catch (Exception e) {
			throw new MyCustomException("exception occured while getting users details in service" + e.getMessage());

		}

		return users;
	}

	@Override
	public UserDTO loadUser(Integer userId) {
		UserDTO userDTO = null;

		try {
			UserTl userTl = userDAO.getUser(userId);
			if (userTl != null) {
				userDTO = FactoryUtils.convertUserTlToUserDTO(userTl);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDTO;
	}

	@Override
	public Integer removeUser(Integer userId) {
		int noofRowsDeleted = 0;
		try {
			noofRowsDeleted = userDAO.deleteUser(userId);
		} catch (Exception e) {

		}
		return noofRowsDeleted;
	}

	@Override
	public Integer updateUser(UserDTO userDTO) {
		int noOfRowsUpdated = 0;
		try {
			UserTl userTl = FactoryUtils.convertUserDTOToUserTl(userDTO);
			noOfRowsUpdated = userDAO.updateUser(userTl);

		} catch (Exception e) {

		}

		return noOfRowsUpdated;
	}

}
