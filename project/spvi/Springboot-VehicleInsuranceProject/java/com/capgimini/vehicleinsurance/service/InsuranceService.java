package com.capgimini.vehicleinsurance.service;

import java.util.List;

import com.capgimini.vehicleinsurance.entity.Insurance;
import com.capgimini.vehicleinsurance.entity.Vehicle;

public interface InsuranceService {
	List<Insurance> getAllInsurance();

	public Insurance addInsurance(Insurance insurance);

	public Insurance updateInsurance(Insurance insurance);

	public boolean deleteInsuranceById(int ins_id);

	public Insurance getInsuranceById(int ins_id);

}
