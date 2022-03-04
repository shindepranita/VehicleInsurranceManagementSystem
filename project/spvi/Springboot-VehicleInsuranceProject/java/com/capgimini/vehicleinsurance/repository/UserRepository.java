package com.capgimini.vehicleinsurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgimini.vehicleinsurance.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	User findByUserNameAndUserPassword(String userName ,String userPassword);

	/*List<User> findByName(String name);*/ 

	/*User signup(User details);  



	User signin(User details);*/
	}
	
