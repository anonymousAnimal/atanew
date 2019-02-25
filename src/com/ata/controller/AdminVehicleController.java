
package com.ata.controller;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ata.bean.CredentialsBean;
import com.ata.bean.VehicleBean;
import com.ata.dao.VehicleDaoImpl;
import com.ata.service.Administrator;
import com.ata.util.AuthImpl;

@Controller
@Transactional
//@RequestMapping("/Vehicle")
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
	
	@RequestMapping("/addVehicle1")
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
		return "AddVehicle";
	}
	

}
