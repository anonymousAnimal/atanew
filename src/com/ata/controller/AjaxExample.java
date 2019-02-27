package com.ata.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RequestMapping("/Ajax")
public class AjaxExample {
	
	String[] names = {"karan","kamal","kaushal","arun","pankaj","praveen","mohit","neeraj","sachin","vaishali"};
	@RequestMapping(path="/getName")
	public @ResponseBody String getName(@RequestParam("name")String name)
	{
		String responseText = "<select id = 'names'>";
		for(String n:names)
		{
			if(n.startsWith(name))
			{
				responseText += "<option value = "+n+" label="+n+"></option>";
				
			}
		}
		responseText += "</select>";
		System.out.println("request param : "+name);
		return responseText;
	}
}
