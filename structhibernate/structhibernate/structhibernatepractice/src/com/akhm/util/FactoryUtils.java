package com.akhm.util;

import com.akhm.dao.model.UserTl;
import com.akhm.service.dto.UserDTO;

public class FactoryUtils {

	private FactoryUtils() {

	}

	public static UserTl convertUserDTOToUserTl(UserDTO userDTO) {
		UserTl userTl = null;

		if (userDTO != null) {
			userTl = new UserTl();
			userTl.setUserId(userDTO.getUserId());
			userTl.setFirstName(userDTO.getFirstName());
			userTl.setLastName(userDTO.getLastName());
			userTl.setEmailId(userDTO.getEmailId());
			userTl.setMobileNo(userDTO.getMobileNo());
			userTl.setPasword(userDTO.getPassword());
			if (userDTO.getDob() != null) {
				java.sql.Date sdate = new java.sql.Date(userDTO.getDob().getTime());
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
			userDTO.setPassword(userTl.getPasword());
			userDTO.setDob(userTl.getDob());
			
		}
		
		return userDTO;
		
	}
	

}
