package com.ata.dao;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ata.bean.RouteBean;

@Repository
public class RouteDaoImpl implements XyzDao<RouteBean> {
	
	@Autowired
	SessionFactory sf;
	
	@Override
	public String create(RouteBean routeBean) {
	
		String id=(String)sf.getCurrentSession().save(routeBean);
		return id;
	}

	@Override
	public int delete(ArrayList<String> list) {
		String sql="delete from RouteBean where routeID in :li ";
		Query q=sf.getCurrentSession().createQuery(sql);
		q.setParameterList("li",list);
		int rows=q.executeUpdate();
		return rows;
	}

	@Override
	public boolean update(RouteBean routeBean) {
		sf.getCurrentSession().update(routeBean);
		return true;
	}

	@Override
	public RouteBean findByID(String s) {
	RouteBean rb=(RouteBean)sf.getCurrentSession().get(RouteBean.class, s);
		
		return rb;
	}
	
	

	@Override
	public ArrayList<RouteBean> findAll() {
		ArrayList< RouteBean>al=(ArrayList<RouteBean>) sf.getCurrentSession().createQuery("from RouteBean").list();
		return al;
	}

	
	/////////////////////////////////////extra methods/////////////////////////////
	
	/*public String getRouteID(String source,String destination)
	{
		String sql="select routeID from RouteBean where source=:s and destination=:d";
		Query q=sf.getCurrentSession().createQuery(sql);
		q.setParameter("s",source);
		q.setParameter("d", destination);
		String routeid=(String) q.list().get(0);
		return routeid;
	}*/

	public RouteBean getRouteBySD(String source,String destination)
	{
		String sql="from RouteBean where source=:s and destination=:d";
		Query q=sf.getCurrentSession().createQuery(sql);
		q.setParameter("s",source);
		q.setParameter("d", destination);
		RouteBean rb=(RouteBean) q.getSingleResult();
		return rb;
	}
	

}
