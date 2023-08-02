package com.example.banking.services;

import java.util.ArrayList;
import java.util.List;

import com.example.banking.models.Admin;

public class AdminService {
	private List<Admin> adminList = new ArrayList<>();

	public AdminService() {
		//will fetch this information from db later
		adminList.add(new Admin("admin1", "admin123"));
		adminList.add(new Admin("admin2", "password"));
	}

	public Admin getAdminByUsername(String username) {
		// based on the provided username, will fetech the admin object from db
		for (Admin admin : adminList) {
			if (admin.getUsername().equals(username)) {
				return admin;
			}
		}
		return null; // Return null if Admin not found with the given username.
	}
}
