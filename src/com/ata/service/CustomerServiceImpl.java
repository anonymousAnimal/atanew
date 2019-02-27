package com.ata.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ata.bean.CredentialsBean;
import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;
import com.ata.dao.ReservationDaoImpl;
import com.ata.dao.RouteDaoImpl;
import com.ata.dao.VehicleDaoImpl;
import com.ata.util.AuthImpl;

@Controller
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
		
		if(authImpl == null) {
			System.out.println("customerServicimpl.authorize : authimpl is null");
		}
	
		// if user type is otherthan "C" ie customer then return false; 
		if(!authImpl.authorize(cb.getUserID()).equals("C"))
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
	
	
	public ArrayList<VehicleBean> viewAllVehicles() {
		if(authorizeCustomer())
			return vehicleDaoImpl.findAll();
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
			//
						
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
	
	/////////////////////////////////extra methods////////////////////////////////
	
	
	public ArrayList<VehicleBean> viewAvailVehiclesByType(String vehicleType)
	{
		if(authorizeCustomer())
		{
			try {
			return vehicleDaoImpl.findAvailVehicleByType(vehicleType);
			}
			catch(Exception e) {
				System.out.println("Exception at CustomerService.findAvailVehicleByType() : "+e.getMessage());
				return null;
			}
		}
		else
			return null;
	}
		
		public ArrayList<VehicleBean> viewAvailVehiclesBySeat(String seat)
		{
			if(authorizeCustomer())
			{
				try {
				return vehicleDaoImpl.findAvailVehicleBySeats(seat);
				}
				catch(Exception e) {
					System.out.println("Exception at CustomerService.findAvailVehicleBySeat() : "+e.getMessage());
					return null;
				}
			}
		else
			return null;
	}
		
	public ArrayList<String> getDestination(String source){
		try {
		if(authorizeCustomer())
		{
			
				
					//code
					ArrayList<RouteBean> routeList = routeDaoImpl.findAll();
					System.out.println("received routes "+routeList);
					ArrayList<String> destinationList = new ArrayList<String>();
					for(RouteBean r : routeList)
					{
						if(r.getSource().toUpperCase().equals(source.toUpperCase()))
							destinationList.add(r.getDestination());
					}
					return destinationList;
				
				}
		}
		
				catch(Exception e) {
					System.out.println("Exception at CustomerService.getdestination() : "+e.getMessage());
					return null;
				}
			
		
		return null;
	}
	
	
	public Set<String> findAllSources() {
		Set<String> set = new HashSet<String>();
		ArrayList<RouteBean> rlist = routeDaoImpl.findAll();
		for(RouteBean r : rlist) {
			set.add(r.getDestination());
		}
		return set;
	}
	

}
