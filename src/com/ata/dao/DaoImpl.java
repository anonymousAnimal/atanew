package com.ata.dao;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class DaoImpl<T> implements XyzDao<T>{

	Class<T> tClass;
	
	@SuppressWarnings("unchecked")
	public DaoImpl(){
		
		/*
		 * ParameterizedType ptype = (ParameterizedType)
		 * this.getClass().getGenericInterfaces()[0];
		 * System.out.println("type is "+ptype.getActualTypeArguments()[0].getTypeName()
		 * );
		 */
	}
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String create(T t) {
		// this return the userid from credentials
		String id = (String) sessionFactory.getCurrentSession().save(t);
		return id;
	}

	@Override
	public int delete(ArrayList<String> list) {

		String query = "delete from "+tClass.getName()+" where userid in :list";
		Query queryobj = sessionFactory.getCurrentSession().createQuery(query);
		queryobj.setParameterList("list", list);
		int rowcnt = queryobj.executeUpdate();
		return rowcnt;
	}

	@Override
	public boolean update(T t) {
		try {
			sessionFactory.getCurrentSession().update(t);
			return true;
		} catch (Exception e) {
			System.out.println("Exception :" + e.getMessage());
			return false;
		}
	}

	@Override
	public T findByID(String s) {
		T bean = (T) sessionFactory.getCurrentSession().get(tClass, s);

		return bean;
	}

	@Override
	public ArrayList<T> findAll() {
		ArrayList<T> list = (ArrayList<T>) sessionFactory.getCurrentSession().createCriteria(tClass).list();
		return list;
	}

}
