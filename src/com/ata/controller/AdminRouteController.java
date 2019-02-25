package com.ata.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ata.bean.CredentialsBean;
import com.ata.bean.RouteBean;
import com.ata.dao.RouteDaoImpl;
import com.ata.service.Administrator;
import com.ata.service.AdministratorServiceImpl;
import com.ata.util.AuthImpl;

@Transactional
@Controller
public class AdminRouteController {

	@Autowired
	Administrator administratorServiceImpl;
	@Autowired
	AuthImpl authImpl;
	@Autowired
	RouteDaoImpl rdao;
	
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
	@RequestMapping("/delRoute")
	public String delRoute(Model m) 
	{
		ArrayList<RouteBean>al=rdao.findAll();
		m.addAttribute("routelist",al);
		m.addAttribute("routeBean",new RouteBean());
		return "DelRoute";
	}
	
	@RequestMapping("/dodelRoute/{id}")
	public String delRoute1( @RequestParam("id")String id,RouteBean routeBean,Model m) 
	{
	//CredentialsBean cb=(CredentialsBean)ses.getAttribute("credentialsBean");
		//authenticate user
		ArrayList<String>ar=new ArrayList<String>();
		ar.add(id);
	int rows=administratorServiceImpl.deleteRoute(ar);
	m.addAttribute("msg","Route deleted with id"+id);
	
		return "DelRoute";
	}
}
