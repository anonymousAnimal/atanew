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
	User user;
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
	public String doLogin(@Valid CredentialsBean credentialsBean, BindingResult bres,
			Model m, HttpSession session) {
		session.setMaxInactiveInterval(0);
		
		if (bres.hasErrors()) {
			System.out.println("some error occured");
			m.addAttribute("msg", "validation problem");
			 m.addAttribute("credentialsBean",new CredentialsBean());
			return "login";
		}

		String msg = "";
		if (!authUtil.authenticate(credentialsBean)){
			System.out.println("invalid uname or pass");
			msg = "invalid username or password !!!";
			m.addAttribute("msg", msg);
			 m.addAttribute("credentialsBean",new CredentialsBean());
			return "login";
		}

		String result = authUtil.authorize(credentialsBean.getUserID());

		if (result == null) {
			System.out.println("error occured result null");
			msg = "some error occured as result is null";
			m.addAttribute("msg", msg);
			 m.addAttribute("credentialsBean",new CredentialsBean());
			return "login";
		}

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
	public String doRegister(@Valid ProfileBean profileBean, BindingResult bres, Model m) {
		profileBean.setEmailID(profileBean.getEmailID().toLowerCase().trim());
		System.out.println("inside doregister method");
		if (bres.hasErrors()) {
			System.out.println("doregister : has errors");
			return "Register";
		}

		String result = user.register(profileBean);
		System.out.println(result);
		if (result.equals("FAIL"))
			m.addAttribute("msg", "Resitration status : " + result + " You are already registered Please Login !!");
		else
			m.addAttribute("msg", "Resitration status : SUCCESS\n you can login now !!!! with uid = " + result);
		m.addAttribute("credentialsBean", new CredentialsBean());
		// session.setAttribute("profileBean", profileBean);

		return "login";
	}

//	@RequestMapping(path = "/logout")
//	public String logout(@ModelAttribute("profileBean") ProfileBean pb, Model m, HttpSession session) {
//		ProfileBean profileBean = (ProfileBean) session.getAttribute("profileBean");
//
//		if (profileBean != null || (session.getAttribute("credentialsBean") != null)) {
//			String uid;
//			if (profileBean != null) {
//				System.out.println("InitController.logout() : profileBean is not null");
//				if (profileBean.getUserID() == null) {
//					System.out.println("user id is null");
//					return null;
//				}
//			}
//
//			System.out.println("logging out...");
//			boolean res = user.logout(profileBean.getUserID());
//			if (res) {
//				System.out.println("logout success now invalidating session ....");
//				session.invalidate(); // invalidating session.
//				m.addAttribute("msg", "successfully logged out !");
//			} else
//				m.addAttribute("msg", "error while logout possibly you are already logged out !");
//
//			System.out.println("redirecting to login page...");
//			m.addAttribute("credentialsBean", new CredentialsBean());
//			return "login";
//		} else
//			System.out.println("InitController.logout(): profileBean is null && credentialsBean is null");
//		return null;
//
//	}
	
	@RequestMapping("/logout")
	public String doLogout(Model m, HttpSession session) {
		try {
		CredentialsBean cb =(CredentialsBean) session.getAttribute("credentialsBean");
		String uid = cb.getUserID();
		System.out.println("logging out...");
		boolean res = user.logout(uid);
		if (res) {
			System.out.println("logout success now invalidating session ....");
			session.invalidate(); // invalidating session.
			m.addAttribute("msg", "successfully logged out !");
		} else
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
