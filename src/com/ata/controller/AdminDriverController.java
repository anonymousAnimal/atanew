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
import com.ata.bean.DriverBean;
import com.ata.bean.VehicleBean;
import com.ata.dao.DriverDaoImpl;
import com.ata.service.Administrator;
import com.ata.util.AuthImpl;

@Controller
@Transactional
@RequestMapping("/Admin")
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
	
	@PostMapping("/addDriver1")
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
		return "AdminDashboard";
	}
	
	@RequestMapping("/modifyDriver/{id}")
	public String modifyVehicle(@PathVariable("id")String driverID,Model m) 
	{
		DriverBean db=driverdao.findByID(driverID);
		m.addAttribute("driverBean",db);
		return "ModifyDriver";
	}
	@RequestMapping("/modifyDriver1")
	public String modifyVehicle1(DriverBean driverBean,Model m) 
	{
		boolean res=administratorServiceImpl.modifyDriver(driverBean);
		if(res)
			m.addAttribute("msg","Driver modified");
		return "AdminDashboard";
	}
	
	@RequestMapping("/dodelDriver/{id}")
	public String delDriver1( @PathVariable("id")String id,DriverBean driverBean,Model m) 
	{
		//CredentialsBean cb=(CredentialsBean)ses.getAttribute("credentialsBean");
		//authenticate user
		try{
		ArrayList<String>ar=new ArrayList<String>();
		ar.add(id);
		int rows=administratorServiceImpl.deleteDriver(ar);
		}
		catch(Exception e) {
			m.addAttribute("msg","cannot delete driver with id: "+id+" as it may be assigned to a user ["+e.getMessage()+"]");
			
			return "AdminDashboard";
		}
		m.addAttribute("msg","Driver deleted with id : "+id);
	
		return "AdminDashboard";
	}
	
	@RequestMapping("/driverEditDelete")
	public String goToEditDelete(Model m){
		
		ArrayList<DriverBean> list= driverdao.findAll();
		m.addAttribute("list", list);
		return "AdminDriverView";
	}
	

	

}
