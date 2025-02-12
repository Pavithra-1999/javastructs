package com.akhm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.akhm.action.form.AddUserActionForm;
import com.akhm.service.UserService;
import com.akhm.service.dto.UserDTO;
import com.akhm.service.imp.UserServiceImpl;
import com.akhm.util.DateUtils;

public class AddUserAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String target = "sucess";
		AddUserActionForm addUserForm = (AddUserActionForm) form;
		UserDTO userDTO = new UserDTO();
		userDTO.setFirstName(addUserForm.getFirstName());
		userDTO.setLastName(addUserForm.getLastName());
		userDTO.setEmailId(addUserForm.getEmailId());
		userDTO.setMobileNo(addUserForm.getMobileNo());
		userDTO.setPassword(addUserForm.getPasword());
		if (addUserForm.getDob() != null) {
			userDTO.setDob(DateUtils.convertStringToDate(addUserForm.getDob()));
		}
		UserService userService = new UserServiceImpl();
		Integer userId = userService.saveuser(userDTO);
		if (userId == null || userId < 0) {
			target = " failed";

		}
		return mapping.findForward(target);
	}
}
