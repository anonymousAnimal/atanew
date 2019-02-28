package com.ata.dao;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ata.bean.DriverBean;


@Repository
public class DriverDaoImpl implements XyzDao<DriverBean>{

	@Autowired
	SessionFactory sf;
	
	@Override
	public String create(DriverBean t) {
		String id=(String)sf.getCurrentSession().save(t);
		return id;
	
	}

	@Override
	public int delete(ArrayList<String> list) {
		String sql="delete from DriverBean where driverID in :li ";
		Query q=sf.getCurrentSession().createQuery(sql);
		q.setParameterList("li",list);
		int rows=q.executeUpdate();
		return rows;
	}

	@Override
	public boolean update(DriverBean t) {
		sf.getCurrentSession().update(t);
		return true;
	}

	@Override
	public DriverBean findByID(String s) {
		
		DriverBean db=(DriverBean)sf.getCurrentSession().get(DriverBean.class, s);
		
		return db;
	}

	@Override
	public ArrayList<DriverBean> findAll() {
		ArrayList< DriverBean>al=(ArrayList<DriverBean>) sf.getCurrentSession().createQuery("from DriverBean").list();
		return al;
	}

	
	///////////////////EXTRA METHODS/////////////////////
	
	public ArrayList<DriverBean> findUnallotedDrivers()
	{
		String sql="from DriverBean d where d.driverID not in (select r.driverID from ReservationBean r where r.driverID is not null)";
		Query q=sf.getCurrentSession().createQuery(sql);
		return (ArrayList<DriverBean>) q.list();
	
	}
	
}
