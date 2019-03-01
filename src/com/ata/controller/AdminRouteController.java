package com.ata.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ata.bean.CredentialsBean;
import com.ata.bean.RouteBean;
import com.ata.dao.RouteDaoImpl;
import com.ata.service.Administrator;
import com.ata.util.AuthImpl;


@Controller
@Transactional
@RequestMapping("/Admin")
public class AdminRouteController {

	@Autowired
	Administrator administratorServiceImpl;
	@Autowired
	AuthImpl authImpl;
	@Autowired
	RouteDaoImpl rdao;
	
	@RequestMapping("/addroute")
	public String addRoute(Model m) 
	{
		m.addAttribute("routeBean",new RouteBean());
		return "CreateRoute";
	}
	
	@PostMapping("/doRoute")
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
		return "AdminDashboard";
	}
	
	@RequestMapping("/domodify/{id}")
	public String modifyRoute(@PathVariable("id")String routeID,Model m) 
	{
		RouteBean rb=administratorServiceImpl.viewRoute(routeID);
		m.addAttribute("routeBean",rb);
		return "ModifyRoute";
	}
	@RequestMapping("/modifyRoute")
	public String modifyRoute1(RouteBean routeBean,Model m) 
	{
		boolean res=administratorServiceImpl.modifyRoute(routeBean);
		if(res)
			m.addAttribute("msg","Route modified");
		return "AdminDashboard";
	}
	
//	@RequestMapping("/delRoute")
//	public String delRoute(Model m) 
//	{
//		ArrayList<RouteBean>al=rdao.findAll();
//		m.addAttribute("routelist",al);
//		m.addAttribute("routeBean",new RouteBean());
//		return "DelRoute";
//	
	
	@RequestMapping("/dodelRoute/{id}")
	public String delRoute1( @PathVariable("id")String id,RouteBean routeBean,Model m) 
	{
		//CredentialsBean cb=(CredentialsBean)ses.getAttribute("credentialsBean");
		//authenticate user
		try {
		ArrayList<String>ar=new ArrayList<String>();
		ar.add(id);
		int rows=administratorServiceImpl.deleteRoute(ar);
		m.addAttribute("msg","Route deleted with id : "+id);
		}
		catch(Exception e) {
			m.addAttribute("msg","Cannot delete Route id="+id+": it may be booked by customer ["+e.getMessage()+"]");
		}
		return "AdminDashboard";
	}
	
	@RequestMapping("/goToEditDelete")
	public String goToEditDelete(Model m){
		ArrayList<RouteBean> list= rdao.findAll();
		m.addAttribute("list", list);
		return "AdminRouteView";
	}
}
