package com.akhm;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.akhm.controller.UserController;
import com.akhm.service.dto.UserDTO;
import com.akhm.utils.DateUtils;

public class UserApplication {

	private static UserController userController;

	static {
		userController = new UserController();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option = 0;

		do {
			System.out.println("enter options");
			System.out.println("enter 0 for exit");
			System.out.println("enter 1 for inserting user");
			System.out.println("enter 2 for getAllUsersDetails");
			System.out.println("enter 3 for getUsersDetails");
			System.out.println("enter 4 for deleteUserByUserId");
			System.out.println("enter 5 for updateuser");
			option = sc.nextInt();
			switch (option) {
			case 1:
				saveUser();
				break;

			case 2:
				getAllUsers();
				break;
			case 3:
				getUser();
				break;
			case 4:
				deleteUser();
				break;
			case 5:
				updateUser();
				break;
			default:
				System.out.println("please select correct option");
				break;

			case 0:
				System.out.println("you are exit");

			}

		} while (option != 0);
	}

	public static void saveUser() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("enter firstName");
			String firstName = br.readLine();
			System.out.println("enter lastName");
			String lastName = br.readLine();
			System.out.println("enter emailId");
			String emailId = br.readLine();
			System.out.println("enter mobileNo");
			String mobileNo = br.readLine();
			System.out.println("enter password");
			String password = br.readLine();
			System.out.println("enter dob");
			String dob = br.readLine();
			Date uDate = DateUtils.convertStringToDate(dob);
			UserDTO userDTO = new UserDTO();

			userDTO.setFirstName(firstName);
			userDTO.setLastName(lastName);
			userDTO.setEmailId(emailId);
			userDTO.setMobileNo(mobileNo);
			userDTO.setPassword(password);
			userDTO.setDob(uDate);

			Integer userId = userController.insertUser(userDTO);
			if (userId != null && userId > 0) {
				System.out.println("User Details are SuccessFully inserted ");
			} else {
				System.out.println("Error occured during inserting userDetails");
			}

		} catch (IOException io) {
			io.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void getAllUsers() {
		try {
			List<UserDTO> users = userController.getAllUsers();
			if (users != null && !users.isEmpty()) {
				for (UserDTO user : users) {
					System.out.println("users details are ");
					System.out.println("userId is" + user.getUserId());
					System.out.println("first Name is" + user.getFirstName());
					System.out.println("last Name is " + user.getLastName());
					System.out.println("email Id is" + user.getEmailId());
					System.out.println("mobile number is " + user.getMobileNo());
					System.out.println("password is " + user.getPassword());
					System.out.println("date of birth is " + user.getDob());
					System.out
							.println("date of birth after convertion " + DateUtils.convertDateToString(user.getDob()));
				}
			} else {
				System.out.println("users details not availalble");
			}

		} catch (Exception e) {

		}

	}

	public static void getUser() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter UserId");
			int userId = sc.nextInt();
			UserDTO userDTO = userController.getUser(userId);
			if (userDTO != null) {
				System.out.println("User details are ");

				System.out.println("userId is" + userDTO.getUserId());
				System.out.println("first Name is" + userDTO.getFirstName());
				System.out.println("last Name is " + userDTO.getLastName());
				System.out.println("email Id is" + userDTO.getEmailId());
				System.out.println("mobile number is " + userDTO.getMobileNo());
				System.out.println("password is " + userDTO.getPassword());
				System.out.println("date of birth is " + userDTO.getDob());
				System.out.println("date of birth after convertion " + DateUtils.convertDateToString(userDTO.getDob()));
			} else {
				System.out.println("user details are not found");
			}
		} catch (Exception e) {

		}
	}

	public static void deleteUser() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter UserId");
			int userId = sc.nextInt();
			int noofRowsDeleted = userController.deleteUser(userId);
			if (noofRowsDeleted > 0) {
				System.out.println("User Details are sucessfuly inserted");

			} else {
				System.out.println("user details are not found");
			}
		} catch (Exception e) {

		}

	}

	public static void updateUser() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		try {
			System.out.println("Enter UserId");
			int userId = Integer.valueOf(br.readLine());
			System.out.println("enter firstName");
			String firstName = br.readLine();
			System.out.println("enter lastName");
			String lastName = br.readLine();
			System.out.println("enter emailId");
			String emailId = br.readLine();
			System.out.println("enter mobileNo");
			String mobileNo = br.readLine();
			System.out.println("enter password");
			String password = br.readLine();
			System.out.println("enter dob");
			String dob = br.readLine();
			Date uDate = DateUtils.convertStringToDate(dob);
			UserDTO userDTO = new UserDTO();
			userDTO.setUserId(null);
			userDTO.setFirstName(firstName);
			userDTO.setLastName(lastName);
			userDTO.setEmailId(emailId);
			userDTO.setMobileNo(mobileNo);
			userDTO.setPassword(password);
			userDTO.setDob(uDate);

			Integer userId = userController.updateUser(userDTO);
			if (userId != null && userId > 0) {
				System.out.println("User Details are SuccessFully updated ");
			} else {
				System.out.println("Error occured during updating userDetails");
			}

		} catch (IOException io) {
			io.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
