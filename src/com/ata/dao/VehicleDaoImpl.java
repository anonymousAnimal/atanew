package com.ata.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;

@Repository
public class VehicleDaoImpl implements XyzDao<VehicleBean> {

	@Autowired
	SessionFactory ses;

	@Override
	public String create(VehicleBean vehicleBean) {
		String vehicleid = (String) ses.getCurrentSession().save(vehicleBean);
		return vehicleid;
	}

	@Override
	public int delete(ArrayList<String> li) {
		Session s = ses.getCurrentSession();
		String sql = "delete from VehicleBean  where vehicleid in :list";
		Query q = s.createQuery(sql);
		q.setParameterList("list", li);
		int rows = q.executeUpdate();
		return rows;
	}

	@Override
	public boolean update(VehicleBean vehicleBean) {
		try {
			ses.getCurrentSession().update(vehicleBean);
			return true;
		} catch (Exception e) {
		}

		return false;
	}

	@Override
	public VehicleBean findByID(String s) {
		VehicleBean b = (VehicleBean) ses.getCurrentSession().get(VehicleBean.class, s);
		return b;
	}

	@Override
	public ArrayList<VehicleBean> findAll() {
		ArrayList< VehicleBean>al=(ArrayList<VehicleBean>) ses.getCurrentSession().createQuery("from VehicleBean").list();
		return al;
	}

	
	public ArrayList<VehicleBean> findByType(String type){
		
		Query<VehicleBean> query =ses.getCurrentSession().createQuery("from VehicleBean where type=:type");
		query.setParameter("type", type);
		ArrayList<VehicleBean> list = (ArrayList<VehicleBean>)query.list();
		return list;
		
	}
	
public ArrayList<VehicleBean> findBySeats(int seats){
		
		Query<VehicleBean> query =ses.getCurrentSession().createQuery("from VehicleBean where seatingCapacity=:seats");
		query.setParameter("seats", seats);
		ArrayList<VehicleBean> list = (ArrayList<VehicleBean>)query.list();
		return list;
		
	}
}
