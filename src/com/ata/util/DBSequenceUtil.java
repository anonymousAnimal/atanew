package com.ata.util;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.type.LongType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ata.bean.CredentialsBean;
import com.ata.bean.DriverBean;
import com.ata.bean.ProfileBean;
import com.ata.bean.ReservationBean;
import com.ata.bean.RouteBean;
import com.ata.bean.VehicleBean;

@Repository
public class DBSequenceUtil {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public <T> String getID(T t) 
	{
		
		String part1 = null;
		String part2 = null;
		String tblname = "";
		if(t instanceof ProfileBean)
		{
			part1 = ((ProfileBean)t).getFirstName().substring(0, 2);
			tblname = "ata_seq_userid";
		}
		else if(t instanceof CredentialsBean)
		{
			/*
			 * part1 = ((CredentialsBean)t).getFirstName(); tblname = "ata_seq_userid";
			 */
			System.out.println("DBSequenceUtil.getID() : you cannot pass credentialsBean object");
			return null;
		}
		else if(t instanceof RouteBean)
		{
			part1 = ((RouteBean)t).getSource().substring(0, 2) + ((RouteBean)t).getDestination().substring(0, 2);
			tblname = "ata_seq_routeid";
		}
		else if(t instanceof DriverBean)
		{
			part1 = ((DriverBean)t).getName().substring(0,2);
			tblname = "ata_seq_driverid";
		}
		else if(t instanceof VehicleBean)
		{
			part1 = ((VehicleBean)t).getName().substring(0,2);
			tblname = "ata_seq_vehicleid";
		}
		else if(t instanceof ReservationBean)
		{
			part1 = "";
			tblname = "ata_seq_reservationid";
		}
		
		System.out.println(part1 + "    "+tblname);
		
		//part2
		String q = "select startwith from dbsequences where sequence_name = '"+tblname+"'";
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(q);
		query.addScalar("startwith",new LongType());
		Long count = (Long)query.getSingleResult();
		part2 = ""+ ++count;
		String r = "update dbsequences set startwith = "+count+" where sequence_name = '"+tblname+"'";
		query = sessionFactory.getCurrentSession().createSQLQuery(r);
		int rowcnt = query.executeUpdate();
		
		if(rowcnt < 1)
		{
			System.out.println("DBSequenceUtil.getID() : error updating dbsequence");
			return null;
		}
		else
			return part1+part2;
	}
}
