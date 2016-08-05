package com.au.adportal.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.au.adportal.dao.DaoInterface;
import com.au.adportal.model.Category;
import com.au.adportal.model.CurrentUser;
import com.au.adportal.model.Location;
import com.au.adportal.model.Post;
import com.au.adportal.model.User;
import com.au.adportal.service.ServiceInterface;
import com.au.adportal.util.Role;
import com.au.adportal.viewmodel.ViewPost;

@SpringBootApplication
@RestController
@ComponentScan("com.au.adportal")
@EnableAutoConfiguration
@Configuration
@EnableAsync
public class AdPortalController extends SpringBootServletInitializer {
	@Autowired
	ServiceInterface service;
	@Autowired
	CurrentUser current_user;

	@Autowired
	DaoInterface dao;

	@RequestMapping("/user")
	public @ResponseBody Object getUser(Principal p){
		OAuth2Authentication aut = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
		LinkedHashMap obj = (LinkedHashMap)aut.getUserAuthentication().getDetails();
		if(obj.get("hd")==null || !obj.get("hd").equals("accoliteindia.com")){
			SecurityContextHolder.getContext().setAuthentication(null);
			return null;
		}
		String id = aut.getPrincipal().toString();
		User user = service.getUser(id); 
		if(user==null){
			user = new User(id, obj.get("name").toString(), obj.get("email").toString(), "", Role.USER);
			service.addUser(user);			
		}
		current_user.setUser(user);
		return user;
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		// dao.makeAdmin("");
		return "From Controller";
	}

	@RequestMapping(value = "/makeadmin", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody Boolean makeAdmin(@RequestBody String email) {
		return (service.makeAdmin(current_user, email));
	}

	@RequestMapping(value = "/blacklist", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody Boolean blacklist(@RequestBody String email) {
		return (service.blacklist(current_user, email));
	}

	@RequestMapping(value = "/deletepost", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody Boolean deletePost(@RequestBody Integer postId) {
		return (service.deletePost(current_user, postId));
	}

//	@RequestMapping(value = "/editpost", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
//	public @ResponseBody int editPost(@RequestBody int postId) {
//		return (service.editPost(current_user, postId));
//	}

	@RequestMapping(value = "/createlocation", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody Boolean deletePost(@RequestBody String location) {
		return (service.createLocation(current_user, location));
	}

	@RequestMapping(value = "/createcategory", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody Boolean createCategory(@RequestBody String category) {
		return (service.createCategory(current_user, category));
	}

	@RequestMapping(value = "/addpost", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String addPost(@RequestBody Post post) {
		return ""+(service.addPost(current_user, post));
	}

	@RequestMapping(value = "/getallposts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ArrayList<ViewPost> getAllPosts(@RequestParam(value = "title",required=false) String title,
			@RequestParam(value = "location", required=false) Integer locationId, @RequestParam(value = "minPrice",required=false) Integer minPrice,
			@RequestParam(value = "maxPrice", required=false) Integer maxPrice, @RequestParam(value = "category",required=false) Integer categoryId) {
		return (service.getAllPosts(current_user, title, locationId, minPrice, maxPrice, categoryId));
	}

	@RequestMapping(value = "/editpost", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String editPost(@RequestBody Post post) {
		
		return (service.editPost(current_user, post)+"");
		
	}

	@RequestMapping(value = "/getcontactinfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String[] getContactInfo(@RequestParam(value = "postid") Integer postId) {
		return (service.getContactInfo(current_user, postId));
	}

	@RequestMapping(value = "/contact", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean contact(@RequestBody String[] details) {
		try{
			System.out.println(details.toString());
			int id=Integer.parseInt(details[0]);
			return (service.contact(current_user, id, details[1].toString()));
		}
		catch(Exception e){
			return false;
		}
		
	}
	@RequestMapping(value = "/getcategories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ArrayList<Category> getCategories() {
		return (service.getCategories());
	}

	@RequestMapping(value = "/getlocations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ArrayList<Location> getLocations() {
		return (service.getLocations());
	}
	/*
	@RequestMapping(value = "/setcategories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ArrayList<Category> setCategories() {
		return (service.getCategories());
	}

	@RequestMapping(value = "/setlocations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ArrayList<Location> setLocations() {
		return (service.getLocations());
	}
	*/
	
	@RequestMapping(value = "/getpost", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Post getPost(@RequestParam(value = "postid") Integer postId) {
		return (service.getPost(current_user, postId));
	}
	
	@RequestMapping(value = "/updateprofile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean changeMobile(@RequestBody String mobile){
		System.out.println(mobile);
		return service.changeMobile(current_user, mobile);
	}

	@RequestMapping(value = "/addcategory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean addCategory(@RequestBody String category) {
		
		return (service.addCategory(current_user, category));
	}
	@RequestMapping(value = "/addlocation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody boolean addLocation(@RequestBody String location) {
		System.out.println("location"+location);
		return (service.addLocation(current_user,location));
	}
	public static void main(String[] args) {
		SpringApplication.run(AdPortalController.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AdPortalController.class);
	}

}