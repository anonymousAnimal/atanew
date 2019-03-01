package com.ata.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ata.bean.CredentialsBean;
import com.ata.bean.PaymentBean;
import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;
import com.ata.dao.ReservationDaoImpl;
import com.ata.dao.RouteDaoImpl;
import com.ata.dao.VehicleDaoImpl;
import com.ata.service.CustomerServiceImpl;
import com.ata.util.DBSequenceUtil;
import com.ata.util.DBUtil;

@RequestMapping("Booking")
@Controller
@Transactional
public class UserBooking {
	
	@Autowired
	CustomerServiceImpl cservice;
	
	@Autowired
	VehicleDaoImpl vehicleDaoImpl;
	
	@Autowired
	RouteDaoImpl routeDaoImpl;
	
	@Autowired
	DBSequenceUtil dbsequtil;
	
	@Autowired
	ReservationDaoImpl rsvDaoImpl;
	
	@RequestMapping("/BookVehicle")
	public String bookVehicle1(Model m)
	{
		m.addAttribute("typelist",cservice.getAllVehicleTypes());
		m.addAttribute("seatlist",cservice.getAllVehicleSeats());
		m.addAttribute("sourcelist",cservice.findAllSources());
		m.addAttribute("reservationBean",new ReservationBean());
		return "BookVehicle1";
	}
	
	//////////////////////ajax handlers////////////////////////////////////
	
	
	
	
	@RequestMapping(path="/getvehicles")
	public @ResponseBody String getVehicles(@RequestParam("type") String type, @RequestParam("seat") String seat) {
		
		System.out.println("type is "+type+" seat is "+seat);
		
		Set<VehicleBean> set = cservice.getVehiclesBySeatAndType(type, seat);
		
		String response = "<select id='vehiclelist' name='vehicleid'><br>";
		
		if(set.size()==0)
		{
			response += "<option label='NOT FOUND' value=''>NOT FOUND</option>";
		}
		else
		{
			for(VehicleBean v : set)
			{
			   response += "<option id='"+v.getName()+"' value="+v.getVehicleID()+" >"+v.getName()+"</option>";
			}
		}
		
		response += "</select>";
		
		System.out.println(response);
		
		return response;
			
	}
	
	@RequestMapping(path="/getdestination")
	public @ResponseBody String getDestination(@RequestParam("source")String source) 
	{
		System.out.println("source = "+source);
		ArrayList<String> list = cservice.getDestination(source);
		String txt = "<select id = 'destinationlist' name = 'destination'>";
		
		for(String d: list) {
			txt += "<option label="+d+" value="+d+">"+d+"</option>";
		}
		
		txt += "</select>";
		
		System.out.println(txt);
		
		return txt;
	}
	
	
	
	@RequestMapping(path="/Page2",method=RequestMethod.POST)
	public String bookingPage1(@ModelAttribute("reservationBean") ReservationBean reservationBean, @RequestParam("source") String source,
			@RequestParam("destination")String destination,
			@RequestParam("vehicleid")String vehicleid, Model m, HttpSession session) {
		
		System.out.println("vehicle id is "+vehicleid);
		
		VehicleBean vb = vehicleDaoImpl.findByID(vehicleid);
		RouteBean rb = routeDaoImpl.getRouteBySD(source, destination);
		CredentialsBean cb = (CredentialsBean)session.getAttribute("credentialsBean");
		PaymentBean pb = new PaymentBean();
		
		if(rb==null) {
			System.out.println("routebean is null");
			
		}
		if(vb==null)
			System.out.println("vehiclebean is null");
		
		System.out.println("boarding point "+reservationBean.getBoardingPoint()+",   "+reservationBean.getDropPoint());
		
		//reservationBean.boardingPoint  - set from form
		//reservationBean.bookingStatus - pending (default)
		//reservationBean.driverID - assigned by admin
		//reservationBean.Droppoint - set from form
		//reservationBean.journeyDate - set from form
		reservationBean.setBookingDate(new Date());  // to assign current date to booking date.
		reservationBean.setReservationID(dbsequtil.getID(reservationBean)); // set reservationID
		reservationBean.setRouteID(rb.getRouteID());									// set Route id
		reservationBean.setTotalFare(vb.getFarePerKM() * rb.getDistance());			//calc. and set total fare 
		reservationBean.setUserID(cb.getUserID());												//set userid from credentialsbean
		reservationBean.setVehicleID(vb.getVehicleID());                      //assigning vehicle id
		
		
		
		m.addAttribute("vehicleBean",vb);
		m.addAttribute("routeBean",rb);
		m.addAttribute("paymentBean",pb);
		m.addAttribute("reservationBean",reservationBean);
		
		session.setAttribute("vehicleBean", vb);
		session.setAttribute("routeBean", rb);
		session.setAttribute("reservationBean",reservationBean);
		
		return "BookVehicle2";
	}
	
	@RequestMapping(path="/CompletePayment", method=RequestMethod.POST)
	public String bookingPage2(@ModelAttribute("paymentBean") PaymentBean paymentBean ,HttpSession session, Model m) 
	{
		
		ReservationBean rvb = (ReservationBean)session.getAttribute("reservationBean");
		VehicleBean vb = (VehicleBean) session.getAttribute("vehicleBean");
		RouteBean rb = (RouteBean) session.getAttribute("routeBean");
		
		Double payment = vb.getFarePerKM() * rb.getDistance();
		
		boolean paymentres = cservice.makePayment(paymentBean, payment);
		if(paymentres) {
			m.addAttribute("paymentBean",paymentBean);
			m.addAttribute("rb",rvb); // set reservationbean
			String res = cservice.bookVehicle(rvb);
			System.out.println("saving reservationbean result : "+res);
			m.addAttribute("msg","payment successful :)");
		}
		else
			m.addAttribute("msg","payment unsuccessful :(");
		return "PaymentResult";
	}
	
	
	@RequestMapping(path="/CancelBooking")
	public String cancelBooking(Model m) {
		
		ArrayList<ReservationBean> reservationList = rsvDaoImpl.findAll();
		m.addAttribute("reservationList",reservationList);
		return "CancelBooking";
	}
	
	
	@RequestMapping(path="/doCancelBooking")
	public @ResponseBody String doCancelBooking(@RequestParam("reservationID") String reservationID, HttpSession session) {
		CredentialsBean credentialsBean = (CredentialsBean)session.getAttribute("credentialsBean");
		boolean res = cservice.cancelBooking(credentialsBean.getUserID(), reservationID);
		return res+"";
	}
	
	@RequestMapping(path="/ViewBooking")
	public String viewBooking(Model m) 
	{
		ArrayList<ReservationBean> list = rsvDaoImpl.findAll();
		m.addAttribute("reservationList",list);
		return "ViewPrintBooking1";
	}
	
	@RequestMapping(path="/doViewBooking")
	public String doviewBooking(@RequestParam String reservationId, Model m) 
	{
		System.out.println(reservationId);
		ReservationBean reservationBean = cservice.viewBookingDetails(reservationId);
		m.addAttribute("reservationBean",reservationBean);
		System.out.println(reservationBean);
		return "ViewPrintBooking2";
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
}
