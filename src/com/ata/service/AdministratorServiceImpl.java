package com.ata.service;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ata.bean.DriverBean;
import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;
import com.ata.dao.DriverDaoImpl;
import com.ata.dao.ReservationDaoImpl;
import com.ata.dao.RouteDaoImpl;
import com.ata.dao.VehicleDaoImpl;
import com.ata.util.DBSequenceUtil;

@Service

public class AdministratorServiceImpl implements Administrator {

	@Autowired
	SessionFactory sf;
	@Autowired
	VehicleDaoImpl vehicleDaoImpl;
	
	@Autowired
	RouteDaoImpl routeDaoImpl;
	@Autowired
	DriverDaoImpl driverDaoImpl;
	@Autowired
	DBSequenceUtil dbseq;
	@Autowired
	ReservationDaoImpl resdaoimpl;
	
	@Override
	public String addVehicle(VehicleBean vehicleBean) {
		
		String id=dbseq.getID(vehicleBean);
		vehicleBean.setVehicleID(id);
		String res=vehicleDaoImpl.create(vehicleBean);
		System.out.println(res+" Vehicle Added with Vehicleid"+id);
		return res;
	}

	@Override
	public int deleteVehicle(ArrayList<String> vehicleID) {
		int rows=vehicleDaoImpl.delete(vehicleID);
		return rows;
	}

	@Override
	public VehicleBean viewVehicle(String vehicleID) {
		VehicleBean vb=vehicleDaoImpl.findByID(vehicleID);
		return vb;
	}

	@Override
	public boolean modifyVehicle(VehicleBean vehicleBean) {
		
		return vehicleDaoImpl.update(vehicleBean);

	}

	@Override
	public String addDriver(DriverBean driverBean)
	{
		String id=dbseq.getID(driverBean);
		driverBean.setDriverID(id);
		String res=driverDaoImpl.create(driverBean);
		System.out.println(res+" Driver Added with driverid"+id);
		return res;
	}

	@Override
	public int deleteDriver(ArrayList<String> driverID) {
		
		int rows=driverDaoImpl.delete(driverID);
		return rows;
	
	}

	@Override
	public boolean allotDriver(String reservationID, String driverID) {
		//first check if driverid is not alloted to another
		boolean res=false;
		ReservationBean rb=resdaoimpl.findByID(reservationID);
		System.out.println(rb);
		if(rb.getBookingStatus().equals("pending")){
			rb.setDriverID(driverID);
			rb.setBookingStatus("Approved");
			res=resdaoimpl.update(rb);
		}
		
		return res;
	}

	@Override
	public boolean modifyDriver(DriverBean driverBean) {
		
		return driverDaoImpl.update(driverBean);
	}

	@Override
	public String addRoute(RouteBean routeBean) {
		
		String id=dbseq.getID(routeBean);
		routeBean.setRouteID(id);
		String res=routeDaoImpl.create(routeBean);
		System.out.println(res+" Route Added with routeid"+id);
		return res;
	}

	@Override
	public int deleteRoute(ArrayList<String> routeID) {
		int rows=routeDaoImpl.delete(routeID);
		return rows;
	}

	@Override
	public RouteBean viewRoute(String routeID) {
		RouteBean rb=routeDaoImpl.findByID(routeID);
		return rb;
	}

	@Override
	public boolean modifyRoute(RouteBean routeBean) {
		
		return routeDaoImpl.update(routeBean);
	}

	@Override
	public ArrayList<ReservationBean> viewBookingDetails(Date journeyDate, String source, String destination) 
	{
		RouteBean routeBean=routeDaoImpl.getRouteBySD(source, destination);
		System.out.println("service layer : view booking details : routeid"+routeBean.getRouteID());
		ArrayList<ReservationBean> al=resdaoimpl.findBookingByJR(journeyDate,routeBean.getRouteID());
		return al;
	}

}
