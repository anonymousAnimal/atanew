package com.ata.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ata.bean.CredentialsBean;
import com.ata.bean.ProfileBean;
import com.ata.dao.UserCredentialsDaoImpl;
import com.ata.dao.UserProfileDaoImpl;

@Component
public class UserImpl implements User{

	@Autowired
	UserCredentialsDaoImpl ucdao;
	
	@Autowired
	UserProfileDaoImpl updao;
	
	@Autowired
	AuthImpl authUtil;
	
	@Autowired
	DBSequenceUtil dbseq;
	
	@Override
	public String login(CredentialsBean credentialsBean) {
		
		try {
			if(authUtil.authenticate(credentialsBean))
				return credentialsBean.getUserType(); //A or C
			else
				return "INVALID";
			} 
			catch (Exception e)
			{
				System.out.println("Exception occured at : User.login()");
				e.printStackTrace();
				return "FAIL";
			}
		
	}

	@Override
	public boolean logout(String userId) 
	{
		CredentialsBean cb = ucdao.findByID(userId);
		return authUtil.changeLoginStatus(cb, 0); // 0=logout;
	}

	@Override
	public String changePassword(CredentialsBean credentialsBean, String newPassword) 
	{
		if(authUtil.authenticate(credentialsBean))
		{
			//set new password
			credentialsBean.setPassword(newPassword);
			//call update from usercredentailsDao
			if(ucdao.update(credentialsBean))
				return "SUCCESS";
			else
				return "FAIL";
		}
		else
		return "INVALID";
	}

	@Override
	public String register(ProfileBean profileBean) 
	{
		try 
		{
		ProfileBean pbdb = updao.findByEmail(profileBean.getEmailID());
		if(pbdb != null)  //user already present
			return "FAIL";
			
		String userID = null;
		
		//generate userid;
		userID = dbseq.getID(profileBean);
		
		// set userid in profilebean
		profileBean.setUserID(userID);
		
		if(ucdao.findByID(userID)==null)
		{
			ucdao.create(new CredentialsBean(profileBean.getUserID(),profileBean.getPassword(),"C",0));
			updao.create(profileBean);
			return profileBean.getUserID();
		}
		else
			return "FAIL";
	
		}
		catch(Exception e) {
			e.printStackTrace(); 
			return "FAIL";
			}
	}
	
	

}
