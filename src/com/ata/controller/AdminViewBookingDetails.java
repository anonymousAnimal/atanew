package com.ata.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ata.bean.DriverBean;
import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.dao.DriverDaoImpl;
import com.ata.dao.ReservationDaoImpl;
import com.ata.dao.RouteDaoImpl;
import com.ata.service.Administrator;
import com.ata.service.CustomerServiceImpl;


@Controller
@Transactional
@RequestMapping("/Admin")
public class AdminViewBookingDetails {
	
	@Autowired
	Administrator adminsl;
	@Autowired
	RouteDaoImpl routedao;
	@Autowired
	ReservationDaoImpl resdao;
	
	@Autowired
	DriverDaoImpl driverdao;
	@Autowired
	CustomerServiceImpl cservice;

	
	
	@RequestMapping("/ShowUnallotedDrivers")
	public String UnallotedDriverList(Model m)
	{
		ArrayList<ReservationBean>al=resdao.getUnallotedResDrivers();
		m.addAttribute("UnallotedDrivers",al);
		System.out.println("--------------"+al);
		//get drivers which are not in reservation bean driverid
		ArrayList<DriverBean>db=driverdao.findUnallotedDrivers();
		System.out.println("/////////////"+db);
		m.addAttribute("driverList",db);
		return "UnallotedDrivers";
	}
	
	@RequestMapping("/allotDriver")
	public @ResponseBody String allotDriver(@RequestParam("resid") String reservationID ,@RequestParam("did") String driverID,Model m)
	{
	
		
		boolean res=adminsl.allotDriver(reservationID, driverID);
		m.addAttribute("msg","Driver Alloted with id "+driverID);
		if(res==true)
		return "<tr>alloted with driverID "+driverID+"</tr>";
		
		return "<tr>Cannot allot Driver</tr>";
	}
	
	@RequestMapping("/AdminView")
	public String viewPage(Model m)
	{
		Set<String> source=cservice.findAllSources();
		m.addAttribute("sourceSet",source);
		
		return"AdminViewBookingDetails";
	}
	
	@RequestMapping(path="/getAdmindestination")
	public @ResponseBody String getDestination(@RequestParam("source")String source) 
	{
		System.out.println("source = "+source);
		ArrayList<String> list = cservice.getDestination(source);
		String txt = "<select id = 'destination' name = 'destinationname'>";
		
		for(String d: list) {
			txt += "<option label="+d+" value="+d+">"+d+"</option>";
		}
		
		txt += "</select>";
		
		System.out.println(txt);
		
		return txt;
	}
	
	
	@RequestMapping("/viewBookingDetails")
	public @ResponseBody String bookingDetails(@RequestParam("journeydate")String journeyDate,@RequestParam("source")String source,@RequestParam("destination")String destination)
	{ 
		
		System.out.println("controller----------"+journeyDate);
	
		Date d=new Date();
		if(journeyDate!="")
		{
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
			try {
				
				d=formatter.parse(journeyDate);
				System.out.println(".........."+d);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("///////////////"+tempd);
			
		}
		ArrayList<ReservationBean>resList=adminsl.viewBookingDetails(d,source,destination);
		System.out.println("----------------------"+resList.size());
		String response="";	
		if(resList.size()==0)
		{
			response+="<h2>Sorry no Bookings of this DATE !!!</h2>";
		}
		else
		{
			response+="<table><tr><th>ReservationID</th><th>UserID</th><th>RouteID</th><th>BookingDate</th><th>JourneyDate</th><th>VehicleID</th><th>DriverID</th><th>BookingStatus</th><th>TotalFare</th><th>BoardingPoint</th><th>DropPoint</th></tr>";
			
			for(ReservationBean r:resList)
			{
				response+="<tr><td>"+r.getReservationID()+"</td><td>"+r.getUserID()+"</td><td>"+r.getRouteID()+"</td><td>"+r.getBookingDate()+"</td><td>"+r.getJourneyDate()+"</td><td>"+r.getVehicleID()+"</td><td>"+r.getDriverID()+"</td><td>"+r.getBookingStatus()+"</td><td>"+r.getTotalFare()+"</td><td>"+r.getBoardingPoint()+"</td><td>"+r.getDropPoint()+"</td></tr>";
			
			}
		}
		return response;
		
	}
	
	/*
	 AJAX 
 for(String n:source)
	{
		if(n.toUpperCase().startsWith(name.toUpperCase()))
		{
			return n;
		}
		
	}*/

}
