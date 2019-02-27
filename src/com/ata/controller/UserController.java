package com.ata.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;
import com.ata.service.CustomerServiceImpl;

@Controller
@RequestMapping("/User")
@Transactional
public class UserController {
	
	@Autowired
	InitController initController;
	@Autowired
	CustomerServiceImpl cservice;
	
	@RequestMapping("/Dashboard")
	public String goToDashboard(HttpSession session)
	{
		return "UserDashboard";
	}
	
	@RequestMapping("/Profile")
	public String goToProfile() {
		return "Profile";
	}
	
	@RequestMapping("/ViewVehiclesAndRoutes")
	public String goToViewVehiclesAndRoutes(Model m) 
	{
		ArrayList<VehicleBean> vehicleList = cservice.viewAllVehicles();
		ArrayList<RouteBean> routeList = cservice.viewAllRoutes();
		m.addAttribute("vehicleList",vehicleList);
		m.addAttribute("routeList",routeList);
		
		return "ViewVR";
	}
	
	
}
