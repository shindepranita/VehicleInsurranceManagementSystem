package com.capgimini.vehicleinsurance.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.capgimini.vehicleinsurance.entity.Admin;
import com.capgimini.vehicleinsurance.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService userService;

	@RequestMapping(path = "/admin", method = RequestMethod.GET) // url has changed from / to admin//
	public ModelAndView mainpage() {
		ModelAndView mav = new ModelAndView("adminlogin");
		mav.addObject("user", new Admin());
		return mav;
	}

	@RequestMapping(path = "/adminlogin", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("adminlogin");
		mav.addObject("user", new Admin());
		return mav;
	}

	@PostMapping("/adminlogin")
	public String login(@ModelAttribute("user") Admin user) {

		Admin oauthUser = userService.login(user.getUserName(), user.getPassword());

		// Validates the admin credential//
		System.out.print(oauthUser);
		if (Objects.nonNull(oauthUser)) {

			return "adminHomepage";

		} else {
			return "adminlogin";

		}

	}

	@GetMapping("policiesList")
	public String showListOfPolicies() {

		return "policiesList";
	}

}
