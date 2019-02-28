package com.ata.dao;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ata.bean.PaymentBean;
import com.ata.bean.RouteBean;

@Repository
public class PaymentDaoImpl implements XyzDao<PaymentBean>{
	
	@Autowired
	SessionFactory sf;

	@Override
	public String create(PaymentBean t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(ArrayList<String> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(PaymentBean t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PaymentBean findByID(String s) {
		PaymentBean pb=(PaymentBean)sf.getCurrentSession().get(PaymentBean.class, s);
		return pb;
	}

	@Override
	public ArrayList<PaymentBean> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
