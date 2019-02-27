package com.ata.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ata.bean.DriverBean;
import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.dao.DriverDaoImpl;
import com.ata.dao.ReservationDaoImpl;
import com.ata.dao.RouteDaoImpl;
import com.ata.service.Administrator;


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
	
	@RequestMapping("/ShowUnallotedDrivers")
	public String UnallotedDriverList(Model m)
	{
		ArrayList<ReservationBean>al=resdao.getUnallotedResDrivers();
		m.addAttribute("UnallotedDrivers",al);
		//get drivers which are not in reservation bean driverid
		ArrayList<DriverBean>db=driverdao.findUnallotedDrivers();
		
		m.addAttribute("driverList",db);
		return "UnallotedDrivers";
	}
	
	@RequestMapping("/allotDriver/{id}")
	public String allotDriver(@PathVariable("id") String reservationID ,Model m,HttpServletRequest req)
	{
		String driverID=req.getParameter("drivername");
		
		boolean res=adminsl.allotDriver(reservationID, driverID);
		m.addAttribute("msg","Driver Alloted with id "+driverID);
		
		return "UnallotedDrivers";
	}
	
	@RequestMapping("/AdminView")
	public String viewPage(Model m)
	{
		ArrayList<RouteBean>rb=routedao.findAll();
		m.addAttribute("RouteList",rb);
		
		return"AdminViewBookingDetails";
	}
	
	@RequestMapping("/viewBookingDetails")
	public String bookingDetails(HttpServletRequest req,Model m)
	{ 
		
		Date d=null;
		String journeydate=req.getParameter("journeyDate");
		if(journeydate!="")
		{
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			try {
				d=format.parse(journeydate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//ArrayList<ReservationBean>resList=adminsl.viewBookingDetails(d, req.getParameter("sourcename"),req.getParameter("destinationname"));
		//m.addAttribute("ReservationList",resList);
		System.out.println(journeydate+" "+req.getParameter("sourcename")+" "+req.getParameter("destinationname")+" "+d);
		
		return"BookingDetails";
		
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
