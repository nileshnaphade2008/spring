package com.nilesh.poc.laundry.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nilesh.poc.laundry.dao.IUserDao;
import com.nilesh.poc.laundry.exception.LaundryException;
import com.nilesh.poc.laundry.pojos.User;

//import com.app.pojos.Vendor;
@Controller
@RequestMapping("/user")
public class LoginController {
	private final static Logger LOG = LoggerFactory.getLogger(LoginController.class);

	@Autowired // auto wiring by type
	private IUserDao dao;

	public LoginController() {
	}

	@GetMapping("/login")
	public String showLoginForm() {
		LOG.info("in show login form");
		return "/user/login";
	}

	@PostMapping("/login")
	public String processLoginForm(@RequestParam String em, @RequestParam String pass, Model map,
			RedirectAttributes flashMap, HttpSession hs, HttpServletRequest request) throws LaundryException {
		LOG.info("in process login form");
		hs = request.getSession(true);
		try {
			User u = dao.auntheticateUser(em, pass);
			hs.setAttribute("user_dtls", u);
			flashMap.addFlashAttribute("mesg", "Login Successful");
			if (u.getRole().equals("user")) {
				map.addAttribute(u);
				return "/user/welcome";
			}
			return "redirect:/admin/clothscat";
		} catch (Exception e) {
			LOG.error("err in controller " + e);
			map.addAttribute("error", e.getMessage());
			return "/user/login";
		}
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		LOG.info("LoginController ::logout() :: start");
		HttpSession httpSession = request.getSession(false);
		LOG.info("Is session enable :" + httpSession);
		httpSession.invalidate();
		httpSession = request.getSession(false);
		LOG.info("Is session enable after invalidate :" + httpSession);
		return "/user/logout";
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
