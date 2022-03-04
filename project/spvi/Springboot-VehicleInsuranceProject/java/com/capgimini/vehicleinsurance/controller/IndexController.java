package com.capgimini.vehicleinsurance.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capgimini.vehicleinsurance.entity.User;

import com.capgimini.vehicleinsurance.exception.UserNotFoundException;
import com.capgimini.vehicleinsurance.repository.UserRepository;
import com.capgimini.vehicleinsurance.service.UserService;

@Controller
//@RequestMapping("/")
public class IndexController {

	private final UserService userService;

	@Autowired
	public IndexController(UserService userService) {
		this.userService = userService;
	}

	public IndexController() {

		this.userService = null;
		System.out.println("Welcome to Index");
	}

	@GetMapping("/")
	public String showIndexPage() {
		return "index";
	}

	@GetMapping("/sign-in")
	public String showSignInPage() {
		System.out.println("index controller");
		return "sign-in";
	}

	@PostMapping("/sign-in")
	public String showHomePage(HttpServletRequest request, Model model) {

		String userName = request.getParameter("userName");
		String pass = request.getParameter("userPassword");
		// model.addAttribute("user",user);
		System.out.println(userName + " " + pass);
		System.out.println("Welcome User Validation Controller");
		User user = null;
		try {

			user = userService.validateUser(userName, pass);
		} catch (UserNotFoundException un) {
			List errorList = new ArrayList();
			errorList.add(un.getMessage());

			System.out.println("user is not found" + un.getMessage());
			model.addAttribute("errorList", errorList);

			return "sign-in";

		}
		model.addAttribute("user", user);

		if (Objects.nonNull(user))

		{

			return "userhome";

		} else {
			return "sign-in";

		}

	}

	@GetMapping("/sign-up")
	public String showSignUpPage(Model model) {
		System.out.println("index controller");
		model.addAttribute("user", new User());
		return "sign-up";
	}

	@GetMapping("list") // listing customer
	public String showUpdateForm(Model model) {
		model.addAttribute("userlist", userService.getAlluser());
		return "userlist";
	}

	@PostMapping("add")
	public String addUser(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "sign-up";
		}

		userService.addUser(user);
		return "redirect:/";// redirected to index//
	}

	@GetMapping("/userhome") // userome//
	public String UserHomePage() {

		return "userhome";
	}

//logout//
	@RequestMapping(value = { "/logout" }, method = RequestMethod.POST)
	public String logoutDo(HttpServletRequest request, HttpServletResponse response) {

		return "redirect:/";// redirect to index page
	}

//shows the aboutUs page to the user//
	@GetMapping("/aboutUs")
	public String showAboutUs() {

		return "aboutUs";
	}

	@GetMapping("/contactUs")
	public String showContactUs() {

		return "contactUs";
	}

}

//user profileupdate//
/*
 * @PostMapping("update/{id}") public String updateUser(@PathVariable("id") long
 * id, @Valid User user, BindingResult result, Model model) { if
 * (result.hasErrors()) { user.setUserid(id); return "update-user"; }
 * 
 * userrepository.save(user); model.addAttribute("students",
 * userrepository.findAll()); return "index"; }
 * 
 * @GetMapping("delete/{id}") public String deleteUser(@PathVariable("id") long
 * id, Model model) { User user = userrepository.findById(id).orElseThrow(() ->
 * new IllegalArgumentException("Invalid userid:" + id));
 * userrepository.delete(user); model.addAttribute("user",
 * userrepository.findAll()); return "index"; }
 * 
 * }
 */
