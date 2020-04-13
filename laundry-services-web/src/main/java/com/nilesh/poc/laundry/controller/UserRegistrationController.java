package com.nilesh.poc.laundry.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nilesh.poc.laundry.dao.IUserDao;
import com.nilesh.poc.laundry.pojos.User;

@Controller
@RequestMapping("/user")
public class UserRegistrationController {
	private final static Logger LOG = LoggerFactory.getLogger(UserRegistrationController.class);

	@Autowired // auto wiring by type
	private IUserDao dao;
	@Autowired
	@Qualifier("laundryValidator")
	private Validator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	public UserRegistrationController() {
	}

	// request handling method to show login form
	@GetMapping("/reg")
	public String showRegistrationForm(User u) {
		LOG.info("UserRegistrationController :: showRegistrationForm: in show register form ");
		return "/user/register";
	}

	@PostMapping("/reg")
	public String registerUser(@ModelAttribute("user") @Validated User u,
			BindingResult bindingResult, Model map) {
		LOG.info("UserRegistrationController :: registerUser:: start");
        try {
        	if (bindingResult.hasErrors()) {
    			LOG.info("Returning to Register page");
    			return "/user/register";
    		}
		  dao.register(u);
        }catch (Exception exe) {
			LOG.error("Exception while registering new user ::"+exe.getMessage());
			map.addAttribute("error",exe.getMessage());
			return "/user/register";
		}
		return "/user/success";
	}

	/*
	 * @PostMapping("/reg1") public String ProcessLogin(HttpSession
	 * hs, @RequestParam String em, @RequestParam String pass, Model map,
	 * RedirectAttributes flashMap) {
	 * 
	 * System.out.println("In the processing the login form "); try { User u =
	 * dao.auntheticateUser(em, pass); hs.setAttribute("user_dtls", u);
	 * flashMap.addFlashAttribute("mesg", "Login Successful"); if
	 * (u.getRole().equals("user")) { return "redirect:/user/welcome";
	 * 
	 * } return "redirect:/admin/showorders"; } catch (RuntimeException e) {
	 * System.out.println("In login form error page"); map.addAttribute("mesg",
	 * "Invalid login"); } return "/user/welcome"; }
	 */

}
