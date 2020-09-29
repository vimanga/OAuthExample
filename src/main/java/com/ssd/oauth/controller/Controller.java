package com.ssd.oauth.controller;

import java.security.Principal;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

@RestController
@SessionAttributes("name")
public class Controller {

	@SuppressWarnings("deprecation")
	@RequestMapping("/")
	public ModelAndView home(ModelMap model, Principal principal) throws JsonProcessingException, ParseException
	{
		
		JSONParser parser = new JSONParser(); 
		//get the principal into JSON format
		JSONObject json = (JSONObject) parser.parse(userjson(principal));
		
		//get array inside authorities
		JSONArray jsonAuthorities = (JSONArray) parser.parse(json.getAsString("authorities"));
		
		//get the first element in JSON array to JSON object
		JSONObject AuthoritiesFirstEliment = (JSONObject) parser.parse(jsonAuthorities.get(0).toString());
		
		//access the attributes section in the previous JSON object.
		JSONObject jsonAttributes = (JSONObject) parser.parse(AuthoritiesFirstEliment.getAsString("attributes"));
		
		System.out.println("****************"+jsonAttributes.getAsString("name"));
		
		String name = jsonAttributes.getAsString("name");
		String email = jsonAttributes.getAsString("email");
		
		model.put("name", name);
		model.put("email", email);
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping("user")
//	@ResponseBody
	public Principal user(Principal principal) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
	    String user = mapper.writeValueAsString(principal);
	    System.out.println(user);
		return principal;
	}
	
	@RequestMapping("userjson")
	public String userjson(Principal principal) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
	    String user = mapper.writeValueAsString(principal);
	    //System.out.println(user);
		return user;
	}
	
	@RequestMapping("test")
	public String test() {

		return "xxx";
	}
}
