package com.ata.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ata.bean.CredentialsBean;
import com.ata.bean.DriverBean;
import com.ata.dao.DriverDaoImpl;
import com.ata.service.Administrator;
import com.ata.util.AuthImpl;

@Controller
@Transactional
public class AdminDriverController {
	
	@Autowired
	Administrator administratorServiceImpl;
	@Autowired
	AuthImpl authImpl;
	@Autowired
	DriverDaoImpl driverdao;
	
	@RequestMapping("/addDriver")
	public String addDriver(Model m) 
	{
		m.addAttribute("driverBean",new DriverBean());
		return "AddDriver";
	}
	
	@RequestMapping("/addDriver1")
	public String addDriver1(DriverBean driverBean,Model m,HttpSession ses) 
	{
	CredentialsBean cb=(CredentialsBean)ses.getAttribute("credentialsBean");
		//authenticate user
		if(authImpl.authorize(cb.getUserID()).equals("A")){
		administratorServiceImpl.addDriver(driverBean);
		m.addAttribute("msg","DriverAdded");
		}
		else
		{
			m.addAttribute("msg","INVALID");
		}
		return "AddDriver";
	}
	

}
