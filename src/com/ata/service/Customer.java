package com.ata.service;

import java.util.ArrayList;

import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;

public interface Customer {

	ArrayList<VehicleBean> viewVehiclesByType(String vehicleType) ;
	 ArrayList<VehicleBean> viewVehicleBySeats(int noOfSeats) ;
	 ArrayList<RouteBean> viewAllRoutes() ;
	 String bookVehicle(ReservationBean reservationBean); 
	 boolean cancelBooking(String userID, String reservationID); 
	 ReservationBean viewBookingDetails(String reservationID) ;
	 ReservationBean printBookingDetails(String reservationID) ;
	 

}
