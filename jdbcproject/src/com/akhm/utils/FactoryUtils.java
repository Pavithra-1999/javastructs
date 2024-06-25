package com.akhm.utils;

import com.akhm.dao.model.UserTl;
import com.akhm.service.dto.UserDTO;

public class FactoryUtils {
	private FactoryUtils() {

	}

	public static UserTl convertUserDTOtoUserTl(UserDTO userDTO) {
		UserTl userTl = null;
		if (userDTO != null) {
			userTl = new UserTl();
			userTl.setFirstName(userDTO.getFirstName());
			userTl.setLastName(userDTO.getLastName());
			userTl.setEmailId(userDTO.getEmailId());
			userTl.setMobileNo(userDTO.getMobileNo());
			userTl.setPasword(userDTO.getPasword());
			// userTl.setDob(userDTO.getDob());
			if (userDTO.getDob() != null) {
				java.sql.Date sdate = new java.sql.Date(userDTO.getDob().getTime());
				userTl.setDob(sdate);
			}

		}

		return userTl;
	}
	public static UserDTO convertUserTlToUserDTO(UserTl userTl) {
		UserDTO userDTO=null;
		if(userTl!=null) {
			userDTO=new UserDTO();
			userDTO.setLastName(userTl.getFirstName());
			userDTO.setLastName(userTl.getLastName());
			userDTO.setEmailId(userDTO.getEmailId());
			userDTO.setMobileNo(userTl.getMobileNo());
			userDTO.setPasword(userTl.getPasword());
			userDTO.setDob(userDTO.getDob());
		}
		return userDTO;
	}
	

}
