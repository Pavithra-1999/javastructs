package com.akhm.utils;

import com.akhm.dao.model.UserTl;
import com.akhm.service.dto.UserDTO;

public class FactoryUtils {

	private FactoryUtils() {

	}

	public static UserTl convertUserDTOToUserTl(UserDTO userdto) {
		UserTl userTl = null;

		if (userdto != null) {
			userTl = new UserTl();
			userTl.setUserId(userdto.getUserId());
			userTl.setFirstName(userdto.getFirstName());
			userTl.setLastName(userdto.getLastName());
			userTl.setEmailId(userdto.getEmailId());
			userTl.setMobileNo(userdto.getMobileNo());
			userTl.setPassword(userdto.getPassword());
			if (userdto.getDob() != null) {
				java.sql.Date sdate = new java.sql.Date(userdto.getDob().getTime());
				userTl.setDob(sdate);
			}

		}
		

		return userTl;

	}
	public static UserDTO convertUserTlToUserDTO(UserTl userTl)
	{
		UserDTO userDTO=null;
		if(userTl != null)
		{
			userDTO = new UserDTO();
			userDTO.setUserId(userTl.getUserId());
			userDTO.setUserId(userTl.getUserId());
			userDTO.setFirstName(userTl.getFirstName());
			userDTO.setLastName(userTl.getLastName());
			userDTO.setEmailId(userTl.getEmailId());
			userDTO.setMobileNo(userTl.getMobileNo());
			userDTO.setPassword(userTl.getPassword());
			userDTO.setDob(userTl.getDob());
			
		}
		
		return userDTO;
		
	}
	

}
