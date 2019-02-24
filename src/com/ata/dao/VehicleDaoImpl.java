package com.ata.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ata.bean.VehicleBean;

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
		String sql = "delete form VehicleBean v where v.vehicleid IN (:list)";
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
		VehicleBean b = (VehicleBean) ses.getCurrentSession().createCriteria(VehicleBean.class, s);
		return b;
	}

	@Override
	public ArrayList<VehicleBean> findAll() {
		ArrayList<VehicleBean> li = (ArrayList<VehicleBean>) ses.getCurrentSession().createCriteria(VehicleBean.class).list();
		return li;
	}

}
