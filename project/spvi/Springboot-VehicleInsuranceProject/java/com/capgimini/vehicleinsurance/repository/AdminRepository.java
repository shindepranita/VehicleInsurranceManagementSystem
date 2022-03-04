package com.capgimini.vehicleinsurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgimini.vehicleinsurance.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
	

	// Admin findByUserNameAndPassword(String userName, String password);

	Admin findByUserNameAndPassword(String userName, String password);
	

}