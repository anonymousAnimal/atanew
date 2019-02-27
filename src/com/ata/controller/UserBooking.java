package com.ata.controller;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ata.bean.ReservationBean;
import com.ata.bean.VehicleBean;
import com.ata.service.CustomerServiceImpl;

@RequestMapping("Booking")
@Controller
@Transactional
public class UserBooking {
	
	@Autowired
	CustomerServiceImpl cservice;
	
	@RequestMapping("/BookVehicle")
	public String bookVehicle1(Model m)
	{
		m.addAttribute("sourcelist",cservice.findAllSources());
		m.addAttribute("reservationBean",new ReservationBean());
		return "BookVehicle";
	}
	
	//////////////////////ajax handlers////////////////////////////////////
	
	
	
	
	@RequestMapping(path="/getvehicles")
	public @ResponseBody String getVehicles(@RequestParam("criteria") String criteria) {
		
		System.out.println("criteria is "+criteria);
		
		ArrayList<VehicleBean> list ;
		if(criteria.toLowerCase().equals("type"))
		{
			list = cservice.viewAvailVehiclesByType(criteria);
		}
		else if(criteria.toLowerCase().equals("seat"))
		{
			list = cservice.viewAvailVehiclesBySeat(criteria);
		}
		else 
		{
			return "cannot get vehicles";
		}
		
		String response = "<select id='vehiclelist' name='vehicle'>";
		
		for(VehicleBean v : list)
		{
		   response += "<option id='"+v.getVehicleID()+"' value="+v.getName()+" ></option>";
		}
		
		response += "</select>";
		
		return response;
			
	}
	
	@RequestMapping(path="/getdestination")
	public @ResponseBody String getDestination(@RequestParam("source")String source) 
	{
		System.out.println("source = "+source);
		ArrayList<String> list = cservice.getDestination(source);
		String txt = "<select id = 'destinationlist'>";
		
		for(String d: list) {
			txt += "<option label="+d+" value="+d+">";
		}
		
		txt += "</select>";
		
		System.out.println(txt);
		
		return txt;
	}
}
