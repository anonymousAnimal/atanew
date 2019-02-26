package com.ata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Admin")
public class AdminDashboardController {
	
	
	@RequestMapping("/Dashboard")
	public String goToAdminDashboard(String msg) {
		
		return "AdminDashboard";
	}
}
