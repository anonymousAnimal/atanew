package com.ata.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ata.bean.CredentialsBean;
import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;
import com.ata.dao.ReservationDaoImpl;
import com.ata.dao.RouteDaoImpl;
import com.ata.dao.VehicleDaoImpl;
import com.ata.util.AuthImpl;

public class CustomerServiceImpl implements Customer{

	@Autowired
	RouteDaoImpl routeDaoImpl;
	@Autowired
	VehicleDaoImpl vehicleDaoImpl;
	@Autowired
	ReservationDaoImpl resDaoImpl;
	
	@Autowired
	AuthImpl authImpl;
	
	@Autowired
	HttpSession session;
	
	public boolean authorizeCustomer() {
CredentialsBean cb = (CredentialsBean)session.getAttribute("credentialsBean");
		
		if(authImpl.authorize(cb.getUserID()).equals("C"))
		{
			System.out.println("CustomerServiceImpl.ViewVehiclebytype() : not a valid user");
			return false;
		}
		
		return true;
	}
	
	@Override
	public ArrayList<VehicleBean> viewVehiclesByType(String vehicleType)
	{
		if(authorizeCustomer())
			return vehicleDaoImpl.findByType(vehicleType);
		else
			return null;
	}

	@Override
	public ArrayList<VehicleBean> viewVehicleBySeats(int noOfSeats) {
		if(authorizeCustomer())
			return vehicleDaoImpl.findBySeats(noOfSeats);
		else 
			return null;
	}

	@Override
	public ArrayList<RouteBean> viewAllRoutes() {
		if(authorizeCustomer())
			return routeDaoImpl.findAll();
		else
			return null;
	}

	@Override
	public String bookVehicle(ReservationBean reservationBean) {
		if(authorizeCustomer())
		{
			return resDaoImpl.create(reservationBean);  //return reservationid
		}
		return "FAIL";
	}

	@Override
	public boolean cancelBooking(String userID, String reservationID) {
		if(!authorizeCustomer())
			return false;
		
		ArrayList<String> list = new ArrayList<String>();
		list.add(reservationID);
		int rowcnt = resDaoImpl.delete(list);
		if(rowcnt > 0)
			return true;
		else 
			return false;
	}

	@Override
	public ReservationBean viewBookingDetails(String reservationID) {
		if(!authorizeCustomer())
			return null;
		
		ReservationBean bean = resDaoImpl.findByID(reservationID);
		return bean;
	}

	@Override
	public ReservationBean printBookingDetails(String reservationID) {
		return viewBookingDetails(reservationID);
	}

}
