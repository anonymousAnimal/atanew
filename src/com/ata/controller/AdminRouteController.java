package com.ata.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ata.bean.CredentialsBean;
import com.ata.bean.RouteBean;
import com.ata.service.Administrator;
import com.ata.service.AdministratorServiceImpl;
import com.ata.util.AuthImpl;


@Controller
public class AdminRouteController {

	@Autowired
	Administrator administratorServiceImpl;
	@Autowired
	AuthImpl authImpl;
	
	@RequestMapping("/addRoute")
	public String addRoute(Model m) 
	{
		m.addAttribute("routeBean",new RouteBean());
		return "CreateRoute";
	}
	
	@RequestMapping("/doRoute")
	public String addRoute1(RouteBean routeBean,Model m,HttpSession ses) 
	{
	CredentialsBean cb=(CredentialsBean)ses.getAttribute("credentialsBean");
		//authenticate user
		if(authImpl.authorize(cb.getUserID()).equals("A")){
		administratorServiceImpl.addRoute(routeBean);
		m.addAttribute("msg","RouteAdded");
		}
		else
		{
			m.addAttribute("msg","INVALID");
		}
		return "CreateRoute";
	}
}
