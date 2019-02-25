package com.ata.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ata.bean.CredentialsBean;
import com.ata.bean.ProfileBean;

@Repository
public class UserProfileDaoImpl implements XyzDao<ProfileBean> {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String create(ProfileBean t) {
		// this return the userid from credentials
		String id = (String) sessionFactory.getCurrentSession().save(t);
		return id;
	}

	@Override
	public int delete(ArrayList<String> list) {

		String query = "delete from ProfileBean where userid in :list";
		Query queryobj = sessionFactory.getCurrentSession().createQuery(query);
		queryobj.setParameterList("list", list);
		int rowcnt = queryobj.executeUpdate();
		return rowcnt;
	}

	@Override
	public boolean update(ProfileBean t) {
		try {
			sessionFactory.getCurrentSession().merge(t);
			return true;
		} catch (Exception e) {
			System.out.println("Exception :" + e.getMessage());
			return false;
		}
	}

	@Override
	public ProfileBean findByID(String s) {
		ProfileBean pbean = (ProfileBean) sessionFactory.getCurrentSession().get(ProfileBean.class, s);

		return pbean;
	}

	@Override
	public ArrayList<ProfileBean> findAll() {
		ArrayList<ProfileBean> list = (ArrayList<ProfileBean>) sessionFactory.getCurrentSession()
				.createCriteria(ProfileBean.class).list();
		return list;
	}

	
	public ProfileBean findByEmail(String email) {
		Query<ProfileBean> query = sessionFactory.getCurrentSession().createQuery(" from ProfileBean where emailID = :em");
				query.setParameter("em", email);
		List list = query.list();
		if(list.isEmpty())
			return null;
		else
			return (ProfileBean) list.get(0);
	}
}
