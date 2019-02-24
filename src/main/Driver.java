package main;

import java.util.Date;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ata.bean.CredentialsBean;
import com.ata.bean.ProfileBean;
import com.ata.dao.UserCredentialsDaoImpl;
import com.ata.dao.UserProfileDaoImpl;
import com.ata.dao.XyzDao;
import com.ata.util.DBSequenceUtil;

public class Driver {

	public static void main(String[] args) {
		
		
		/*
		 * ProfileBean p = new ProfileBean("k","k","k",new
		 * Date(29,9,1994),"m","x","y","z","a","121001","1212121212","k@g.com",
		 * "karan123"); CredentialsBean c = new
		 * CredentialsBean(p.getUserID(),p.getPassword(),"C",0); XyzDao<CredentialsBean>
		 * cdao = new UserCredentialsDaoImpl(); XyzDao<ProfileBean> pdao = new
		 * UserProfileDaoImpl(); System.out.println(cdao.create(c));
		 * System.out.println(pdao.create(p));
		 */
		
		CredentialsBean cb = new CredentialsBean();
		ProfileBean pb = new ProfileBean();
		new DBSequenceUtil().getID(new Object());
	}

}
