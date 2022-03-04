package com.capgimini.vehicleinsurance.service;


import java.util.List;

import javax.validation.Valid;

import com.capgimini.vehicleinsurance.entity.Insurance;
import com.capgimini.vehicleinsurance.entity.User;
//import com.capgimini.vehicleinsurance.entity.Insurance;
import com.capgimini.vehicleinsurance.entity.Vehicle;
import com.capgimini.vehicleinsurance.exception.VehicleNotFoundException;

public interface VehicleService {
	List<Vehicle> getAllVehicle();
	public Vehicle addVehicle(Vehicle vehicle);
	public Vehicle editVehicle(Vehicle vehicle);
	public boolean deleteVehicle(int  veh_id);
	public List<Vehicle> findVehiclesByUserId(long userId)throws VehicleNotFoundException; //;
	public List<Vehicle> updateVehiclesByInsuranceId(long userId, int ins_id )throws VehicleNotFoundException;
	//public List<Vehicle> findByUserId(long userId);
	public Insurance findInsuranceByUserId(Long userId)throws VehicleNotFoundException;
}


