package com.capgimini.vehicleinsurance.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capgimini.vehicleinsurance.entity.Insurance;
import com.capgimini.vehicleinsurance.exception.VehicleNotFoundException;
import com.capgimini.vehicleinsurance.service.InsuranceService;
import com.capgimini.vehicleinsurance.service.VehicleService;

@Controller
//@RequestMapping("/")
public class InsuranceController {

	private final InsuranceService insuranceService;

	private final VehicleService vehicleService;

	@Autowired
	public InsuranceController(InsuranceService insuranceService, VehicleService vehicleService) {
		this.insuranceService = insuranceService;
		this.vehicleService = vehicleService;
	}

	//Retrives admin home//
	@GetMapping("/adminHomePage")
	public String showAdminHomePage() {
		return "adminHomePage";
	}

	@GetMapping("/addPolicies")
	public String showPoliciesAddForm(Model model) {
		System.out.println("insurance controller");
		model.addAttribute("insurance", new Insurance());
		return "addPolicies";
	}

	
	//Admin adds the policy details//
	@PostMapping("addPolicies")
	public String addUser(@Valid Insurance insurance, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "adminHomePage";
		}

		insuranceService.addInsurance(insurance);
		return "redirect:listOfPolicies";// redirected to list of policy//

	}

	// display the policy in admin page//
	@GetMapping("listOfPolicies")
	public String showPolicies(Model model) {

		model.addAttribute("listOfPolicies", insuranceService.getAllInsurance());
		System.out.println();
		return "listOfPolicies";
	}

	@GetMapping("/listOfPolicies/edit/{ins_id}")
	public String editPolicies(@PathVariable int ins_id, Model model) {
		model.addAttribute("insurance", insuranceService.getInsuranceById(ins_id));
		return "updatePolicies";
	}

	@PostMapping("/listOfPolicies/{ins_id}")
	public String updatePolicies(@PathVariable int ins_id, @ModelAttribute("insurance") Insurance insurance,
			Model model) {
		// Gets policy by exisiting userid//
		Insurance exisitingPolicies = insuranceService.getInsuranceById(ins_id);
		exisitingPolicies.setIns_id(ins_id);
		exisitingPolicies.setDescription(insurance.getDescription());
		exisitingPolicies.setClaimSettlement(insurance.getClaimSettlement());
		exisitingPolicies.setIns_Number(insurance.getIns_Number());
		exisitingPolicies.setPremium(insurance.getPremium());
		exisitingPolicies.setProvider(insurance.getProvider());
		exisitingPolicies.setTenure(insurance.getTenure());
		// save policies //
		insuranceService.updateInsurance(exisitingPolicies);
		return "redirect:/listOfPolicies";
	}

   //For deleting insurance//
	@GetMapping("/listOfPolicies/delete/{ins_id}")
	public String deleteInsurance(@PathVariable int ins_id) {
		insuranceService.deleteInsuranceById(ins_id);
		return "redirect:/listOfPolicies";
	}

	@GetMapping("policiesDetails")
	public String showPoliciesList(Model model) {

		model.addAttribute("policiesDetails", insuranceService.getAllInsurance());
		System.out.println();
		return "policiesDetails";
	}

	// display the policy for user//
	@GetMapping("displayPolicies/{userId}")
	public String showInsurance(@PathVariable String userId, Model model) {
		System.out.println("policy" + " " + " userId");
		Long userId1 = Long.parseLong(userId);
		System.out.println(userId);
		model.addAttribute("uId", userId1);
		System.out.println("uId");
		model.addAttribute("displayPolicies", insuranceService.getAllInsurance());
		System.out.println("List the policy");
		return "displayPolicies";
	}

	@GetMapping("purchase/{userId}")
	public String purchaseInsurance(@PathVariable("userId") String userId, Model model) {
		System.out.println("" + userId);
		String[] str = userId.split(" ");
		Long userId1 = Long.parseLong(str[0]);
		Integer ins_id = Integer.parseInt(str[1]);
		System.out.println(userId1 + " " + ins_id);
		try {
			vehicleService.updateVehiclesByInsuranceId(userId1, ins_id);
		} catch (VehicleNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "purchase";
	}

	//Shows the policy purchased by user//
	@GetMapping("/listOfPoliciesPurchased/{userId}")
	public String findInsuranceByUserId(@PathVariable("userId") Long userId, Model model) {
		try {
			model.addAttribute("listOfPoliciesPurchased", vehicleService.findInsuranceByUserId(userId));
		} catch (VehicleNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "listOfPoliciesPurchased";
	}

}


