package com.ata.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.security.sasl.AuthorizeCallback;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	

	@RequestMapping("/register")
	public String register(Model m)
	{
		System.out.println("inside register method");
		m.addAttribute("profileBean",new ProfileBean());
		return"Register";
	}
	
	
	@RequestMapping("/login")
	public String login( Model m)
	{
		System.out.println("inside login method");
		m.addAttribute("credentialsBean",new CredentialsBean());
		return "login";
	}
	
	
	@RequestMapping(path="/dologin", method=RequestMethod.POST)
	public String doLogin(@Valid @ModelAttribute("credentialsBean")CredentialsBean credentialsBean, BindingResult bres, Model m)
	{
		if(bres.hasErrors()) {
			System.out.println("some error occured");
			m.addAttribute("msg","validation problem");
			//m.addAttribute("cb",new CredentialsBean());
			return "login";
		}
		
		String msg = "";
		if(!authUtil.authenticate(credentialsBean))
		{
			System.out.println("invalid uname or pass");
			msg = "invalid username or password !!!";
			m.addAttribute("msg",msg);
			//m.addAttribute("cb",new CredentialsBean());
			return "login";
		}
		
		String result = authUtil.authorize(credentialsBean.getUserID()); 
		
		if(result==null)
		{
			System.out.println("error occured result null");
			msg="some error occured as result is null";
			m.addAttribute("msg",msg);
			//m.addAttribute("cb",new CredentialsBean());
			return "login";
		}
		
		if(result.equals("A") || result.equals("C"))
		{
			System.out.println("valid user");
			boolean res = authUtil.changeLoginStatus(credentialsBean, 1);   //changing the loginstatus
			if(res)
			{
				ProfileBean pb = pdao.findByID(credentialsBean.getUserID());			//getting profileBean from id
				m.addAttribute("profileBean",pb);											//add it as attribute in model m
				return "Profile";												// calling Profile.jsp
			}
		}
		
		return "login";
			
	}
	
	@RequestMapping(path="/doregister", method=RequestMethod.POST)
	public String doRegister(@Valid  ProfileBean profileBean, BindingResult bres, Model m)
	{
		System.out.println("inside doregister method");
		if(bres.hasErrors()) {
			System.out.println("doregister : has errors");
			return "Register";
		}
		
		user.register(profileBean);
		m.addAttribute("profileBean",profileBean);
		
		return "Profile";
	}
	
	
	
	@RequestMapping("logout")
	public String logout(@ModelAttribute("profileBean") ProfileBean profileBean, Model m) 
	{
		if(profileBean!=null )
		{
			if(profileBean.getUserID()==null) {
				System.out.println("user id is null");
				return null;
			}
			
			boolean res =user.logout(profileBean.getUserID());
			if(res)
			{
				m.addAttribute("msg","successfully logged out !");
			}
			else
				m.addAttribute("msg","error while logout possibly you are already logged out !");
			
			return "login";
		}
		 return  null;
			
	}
	
	
	  @InitBinder 
	  protected void initBinder(WebDataBinder binder)
	  {
	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	  binder.registerCustomEditor(Date.class, new CustomDateEditor( dateFormat,
	  false));
	  }
	 
}
