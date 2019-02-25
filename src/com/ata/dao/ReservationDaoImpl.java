package com.ata.dao;

import java.util.ArrayList;

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
	SessionFactory ses;

	@Override
	public String create(ReservationBean bean) {
		String id = (String) ses.getCurrentSession().save(bean);
		return id;
	}

	@Override
	public int delete(ArrayList<String> li) {
		Session s = ses.getCurrentSession();
		String sql = "delete from ReservationBean r where r.reservationID IN (:list)";
		Query q = s.createQuery(sql);
		q.setParameterList("list", li);
		int rows = q.executeUpdate();
		return rows;
	}

	@Override
	public boolean update(ReservationBean reservationBean) {
		try {
			ses.getCurrentSession().update(reservationBean);
			return true;
		} catch (Exception e) {
		}

		return false;
	}

	@Override
	public ReservationBean findByID(String s) {
		ReservationBean b = (ReservationBean) ses.getCurrentSession().createCriteria(ReservationBean.class, s);
		return b;
	}

	@Override
	public ArrayList<ReservationBean> findAll() {
		ArrayList<ReservationBean> li = (ArrayList<ReservationBean>) ses.getCurrentSession().createCriteria(ReservationBean.class).list();
		return li;
	}
}
