package com.ata.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ata.bean.ReservationBean;
import com.ata.bean.VehicleBean;

@Repository
public class ReservationDaoImpl implements XyzDao<ReservationBean>{
	@Autowired
	SessionFactory sf;
	
	@Autowired
	RouteDaoImpl routeDaoImpl;

	@Override
	public String create(ReservationBean bean) {
		
		String id = (String) sf.getCurrentSession().save(bean);
		return id;
	}

	@Override
	public int delete(ArrayList<String> li) {
		Session s = sf.getCurrentSession();
		String sql = "delete from ReservationBean r where r.reservationID IN (:list)";
		Query q = s.createQuery(sql);
		q.setParameterList("list", li);
		int rows = q.executeUpdate();
		return rows;
	}

	@Override
	public boolean update(ReservationBean reservationBean) {
		try {
			sf.getCurrentSession().update(reservationBean);
			return true;
		} catch (Exception e) {
		}

		return false;
	}

	@Override
	public ReservationBean findByID(String s) {
		ReservationBean b = (ReservationBean) sf.getCurrentSession().get(ReservationBean.class, s);
		return b;
	}

	@Override
	public ArrayList<ReservationBean> findAll() {
		ArrayList<ReservationBean> li = (ArrayList<ReservationBean>) sf.getCurrentSession().createCriteria(ReservationBean.class).list();
		return li;
	}
	
///////////////////EXTRA METHODS/////////////////////
	
	
	public ArrayList<ReservationBean>findBookingByJR(Date journeyDate,String routeID)
	{
		String sql="from ReservationBean where journeyDate=:j and routeid=:r ";
			
		Query q=sf.getCurrentSession().createQuery(sql);
		q.setParameter("j", journeyDate);
		q.setParameter("r",routeID);
		
		ArrayList<ReservationBean> al=	(ArrayList<ReservationBean>) q.getResultList();
		return al;
	}
	
	
	public ArrayList<ReservationBean> getUnallotedResDrivers()
	{
		String sql="from ReservationBean where driverID is null";
		ArrayList<ReservationBean> al=(ArrayList<ReservationBean>) sf.getCurrentSession().createQuery(sql).list();
		return al;
	}
}
