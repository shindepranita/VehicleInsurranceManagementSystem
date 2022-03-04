package com.capgimini.vehicleinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgimini.vehicleinsurance.entity.Insurance;
import com.capgimini.vehicleinsurance.entity.Vehicle;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
	
	//purchasing policy based on vehicle type//
	// public boolean purchaseInsurance(String policyType);

}
