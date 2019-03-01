
package com.ata.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ata.bean.CredentialsBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;
import com.ata.dao.VehicleDaoImpl;
import com.ata.service.Administrator;
import com.ata.util.AuthImpl;

@Controller
@Transactional
@RequestMapping("/Admin")
public class AdminVehicleController {
	@Autowired
	Administrator administratorServiceImpl;
	@Autowired
	AuthImpl authImpl;
	@Autowired
	VehicleDaoImpl vehicleDaoImpl;
	
	@RequestMapping("/addVehicle")
	public String addVehicle(Model m) 
	{
		m.addAttribute("vehicleBean",new VehicleBean());
		return "AddVehicle";
	}
	
	@PostMapping("/addVehicle1")
	public String addVehicle1(VehicleBean vehicleBean,Model m,HttpSession ses) 
	{
	CredentialsBean cb=(CredentialsBean)ses.getAttribute("credentialsBean");
		//authorize user
		if(authImpl.authorize(cb.getUserID()).equals("A")){
		administratorServiceImpl.addVehicle(vehicleBean);
		m.addAttribute("msg","VehicleAdded");
		}
		else
		{
			m.addAttribute("msg","INVALID");
		}
		return "AdminDashboard";
	}
	
	@RequestMapping("/modifyVehicle/{id}")
	public String modifyVehicle(@PathVariable("id")String vehicleID,Model m) 
	{
		VehicleBean vb=administratorServiceImpl.viewVehicle(vehicleID);
		m.addAttribute("vehicleBean",vb);
		return "ModifyVehicle";
	}
	@RequestMapping("/modifyVehicle1")
	public String modifyVehicle1(VehicleBean vehicleBean,Model m) 
	{
		boolean res=administratorServiceImpl.modifyVehicle(vehicleBean);
		if(res)
			m.addAttribute("msg","Vehicle modified");
		return "AdminDashboard";
	}
	
	@RequestMapping("/dodelVehicle/{id}")
	public String delRoute1( @PathVariable("id")String id,VehicleBean vehicleBean,Model m) 
	{
		//CredentialsBean cb=(CredentialsBean)ses.getAttribute("credentialsBean");
		//authenticate user
		try {
		ArrayList<String>ar=new ArrayList<String>();
		ar.add(id);
		int rows=administratorServiceImpl.deleteVehicle(ar);
		m.addAttribute("msg","Vehicle deleted with id : "+id);
		}
		catch(Exception e) {
			m.addAttribute("msg","cannot delete vehicle id = "+id+" because it may already be assigned to a customer ");
		}
	
		return "AdminDashboard";
	}
	
	@RequestMapping("/vehicleEditDelete")
	public String goToEditDelete(Model m){
		
		ArrayList<VehicleBean> list= vehicleDaoImpl.findAll();
		m.addAttribute("list", list);
		return "AdminVehicleView";
	}
	

}
