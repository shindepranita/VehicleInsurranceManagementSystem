package com.capgimini.vehicleinsurance.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgimini.vehicleinsurance.entity.User;
import com.capgimini.vehicleinsurance.entity.Vehicle;
import com.capgimini.vehicleinsurance.exception.VehicleNotFoundException;
import com.capgimini.vehicleinsurance.service.UserService;
import com.capgimini.vehicleinsurance.service.VehicleService;

@Controller
//@RequestMapping("/")
public class VehicleController {
	private final VehicleService vehicleService;

	@Autowired
	public VehicleController(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	public VehicleController() {

		this.vehicleService = null;
		System.out.println("Welcome to vehicles controller");
	}

	@GetMapping("/vehicle-registration/{userId}")

	public String showVehicleRegistrationPage(@PathVariable String userId, Model model) {
		System.out.println("vehicles registration" + " " + userId);
		model.addAttribute("vehicle", new Vehicle());
		Long userId1 = Long.parseLong(userId);
		System.out.println(userId);
		model.addAttribute("uId", userId1);
		return "vehicle-registration";
	}

//updates registered vehicles of the user//
	@GetMapping("myProfile/{userId}")
	public String showUpdateForm(@PathVariable("userId") Long userId, Model model) {
		try {
			model.addAttribute("myProfile", vehicleService.findVehiclesByUserId(userId));
		} catch (VehicleNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println(userId);
		return "myProfile";
	}

//vehicle registration page//
	@PostMapping("addvehicle")
	public String addVehicle(@Valid Vehicle vehicle, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "vehicle-registration";
		}
		System.out.println("******" + " " + vehicle);
		vehicleService.addVehicle(vehicle);
		return "successfullyRegistered"; // chenged tat into this
	}

}
