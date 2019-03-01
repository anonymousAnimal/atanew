package com.ata.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.security.sasl.AuthorizeCallback;
import javax.servlet.http.HttpSession;
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
	User userUtil;
	@Autowired
	Authentication authUtil;

	@RequestMapping("/register")
	public String register(Model m) {
		System.out.println("inside register method");
		m.addAttribute("profileBean", new ProfileBean());
		return "Register";
	}

	@RequestMapping("/login")
	public String login(Model m) {
		System.out.println("inside login method");
		m.addAttribute("credentialsBean", new CredentialsBean());
		return "login";
	}

	@RequestMapping(path = "/dologin")
	public String doLogin( CredentialsBean credentialsBean, Model m, HttpSession session)
	{
		

		String msg = "";
		
		// when userid or pass is invalid then redirecting to login page
		if (!authUtil.authenticate(credentialsBean)){
			System.out.println("invalid uname or pass");
			msg = "invalid username or password !!!";
			m.addAttribute("msg", msg);
			 m.addAttribute("credentialsBean",new CredentialsBean());
			return "login";
		}

		// user valid now checking it's type
		String result = authUtil.authorize(credentialsBean.getUserID());

		// some error occured while checking it's type
		if (result == null) {
			System.out.println("error occured result null");
			msg = "some error occured as result is null";
			m.addAttribute("msg", msg);
			 m.addAttribute("credentialsBean",new CredentialsBean());
			return "login";
		}

		// user authorized . now redirecting to it's respective dashboard page
		if (result.equals("A") || result.equals("C")) {
			System.out.println("valid user : " + result);
			boolean res = authUtil.changeLoginStatus(credentialsBean, 1); // changing the loginstatus
			
				ProfileBean pb = pdao.findByID(credentialsBean.getUserID()); 					// getting profileBean from id
				CredentialsBean cb = cdao.findByID(credentialsBean.getUserID()); 				//getting credentialsBean from id
				m.addAttribute("profileBean", pb); 							// add it as attribute in model m
				session.setAttribute("profileBean", pb); 					// setting profileBean object into session
				session.setAttribute("credentialsBean", cb);
																		// return "Profile"; // calling Profile.jsp
			if (result.equals("A"))
				return "redirect:Admin/Dashboard";
			else if (result.equals("C"))
				return "redirect:User/Dashboard";
				
		}
		return "login";

	}

	
	@RequestMapping(path = "/doregister", method = RequestMethod.POST)
	public String doRegister(@Valid ProfileBean profileBean, BindingResult bres, Model m)
	{
		
		profileBean.setEmailID(profileBean.getEmailID().toLowerCase().trim());
		System.out.println("inside doregister method");
		
		// form validation
		if (bres.hasErrors()) {
			System.out.println("doregister : has errors");
			return "Register";
		}

		// registering user and redirecting to respective page
		String result = userUtil.register(profileBean);
		System.out.println(result);
		if (result.equals("FAIL"))
			m.addAttribute("msg", "Resitration status : " + result + " You are already registered Please Login !!");
		else
			m.addAttribute("msg", "Resitration status : SUCCESS\n you can login now !!!! with uid = " + result);
		m.addAttribute("credentialsBean", new CredentialsBean());
		// session.setAttribute("profileBean", profileBean);

		return "login";
	}

	
	@RequestMapping("/logout")
	public String doLogout(Model m, HttpSession session) 
	{
		try {
			// getting session object stored in  session
		CredentialsBean cb =(CredentialsBean) session.getAttribute("credentialsBean");
		String uid = cb.getUserID();
		System.out.println("logging out...");
		
		// logging out
		boolean res = userUtil.logout(uid);
		if (res) {
			// success
			System.out.println("logout success now invalidating session ....");
			session.invalidate(); // invalidating session.
			m.addAttribute("msg", "successfully logged out !");
		} else
			// fail
			m.addAttribute("msg", "error while logout possibly you are already logged out !");
		
		}
		catch(Exception e) {
			System.out.println("Error at InitController.doLogout() : "+e.getMessage());
		}
		
		System.out.println("redirecting to login page...");
		m.addAttribute("credentialsBean", new CredentialsBean());
		return "login";
		}	
	

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
