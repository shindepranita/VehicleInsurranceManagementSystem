package com.capgimini.vehicleinsurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgimini.vehicleinsurance.entity.Admin;
import com.capgimini.vehicleinsurance.entity.User;
import com.capgimini.vehicleinsurance.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public Admin login(String userName, String password) {
		Admin user = adminRepository.findByUserNameAndPassword(userName, password);

		// admin //
		// System.out.println(user.getUserName()+" " + user.getPassword());
		return user;
	}

}
