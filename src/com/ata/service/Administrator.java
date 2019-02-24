package com.ata.service;

import java.util.ArrayList;
import java.util.Date;

import com.ata.bean.DriverBean;
import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;

public interface Administrator {
	
	String addVehicle(VehicleBean vehicleBean);
	int deleteVehicle(ArrayList<String>vehicleID);
	VehicleBean viewVehicle(String vehicleID);
	boolean modifyVehicle(VehicleBean vehicleBean);
	String addDriver(DriverBean driverBean );
	int deleteDriver(ArrayList<String> driverID);
	boolean allotDriver(String reservationID,String driverID);
	boolean modifyDriver(DriverBean driverBean);
	String addRoute(RouteBean routeBean);
	int deleteRoute(ArrayList<String>routeID);
	RouteBean viewRoute(String routeID);
	boolean modifyRoute(RouteBean routeBean);
	ArrayList<ReservationBean> viewBookingDetails(Date journeyDate,String source, String destination); 

}
