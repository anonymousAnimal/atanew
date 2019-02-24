package com.ata.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.security.sasl.AuthorizeCallback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ata.bean.CredentialsBean;
import com.ata.bean.ProfileBean;
import com.ata.dao.DaoImpl;
import com.ata.dao.UserCredentialsDaoImpl;
import com.ata.dao.UserProfileDaoImpl;
import com.ata.dao.XyzDao;
import com.ata.util.Authentication;
import com.ata.util.User;
import com.ata.util.UserImpl;

@Controller
@Transactional
public class InitController {
	
	@Autowired
	UserCredentialsDaoImpl cdao;
	@Autowired
	UserProfileDaoImpl pdao;
	@Autowired
	User user;
	@Autowired
	Authentication authUtil;
	
	/*
	 * @Autowired DaoImpl<CredentialsBean> cbdao;
	 */

	@RequestMapping("/register")
	public String hello(Model m, ProfileBean profileBean)
	{
		m.addAttribute(profileBean);
		return"Register";
	}
	
	
	@RequestMapping("/login")
	public String hello1(CredentialsBean cb, Model m)
	{
		m.addAttribute("cb",cb);
		return "login";
	}
	
	
	@RequestMapping("/dologin")
	public String hello4(CredentialsBean cb, Model m)
	{
		m.addAttribute("cb",cb);
		if(!authUtil.authenticate(cb))
		{
			m.addAttribute("msg","invalid username or password !!!");
			return "login";
		}
		
		String result = authUtil.authorize(cb.getUserID());
		
		if(result==null)
		{
			m.addAttribute("msg","some error occured as result is null");
			return "login";
		}
		
		if(result.equals("A") || result.equals("C"))
		{
			ProfileBean pb = pdao.findByID(cb.getUserID());
			m.addAttribute("cust",pb);
			return "Profile";
		}
		
		return "login";
			
	}
	
	@RequestMapping("/doregister")
	public String hello2(ProfileBean profileBean, Model m)
	{
		
		user.register(profileBean);
		
		m.addAttribute("cust",profileBean);
		
		return "Profile";
	}
	
	@RequestMapping("logout")
	public String logout(CredentialsBean cb, Model m) {
		m.addAttribute("cb",cb);
		return "login";
	}
	
	
	  @InitBinder 
	  protected void initBinder(WebDataBinder binder)
	  {
	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	  binder.registerCustomEditor(Date.class, new CustomDateEditor( dateFormat,
	  false));
	  }
	 
}
