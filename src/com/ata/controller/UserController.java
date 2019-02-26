package com.ata.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	InitController initController;
	
	@RequestMapping("/Dashboard")
	public String goToDashboard(HttpSession session)
	{
		return "UserDashboard";
	}
	
	@RequestMapping("/Profile")
	public String goToProfile() {
		return "Profile";
	}
	
}
