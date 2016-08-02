package com.au.adportal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
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
import com.au.adportal.service.ServiceInterface;

@SpringBootApplication
@RestController
@ComponentScan("com.au.adportal")
@EnableAutoConfiguration
@Configuration
public class AdPortalController extends SpringBootServletInitializer {
	@Autowired
	ServiceInterface service;
	@Autowired
	CurrentUser current_user;

	@Autowired
	DaoInterface dao;

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
	public @ResponseBody int addPost(@RequestBody Post post) {
		return (service.addPost(current_user, post));
	}

	@RequestMapping(value = "/getallposts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ArrayList<Post> getAllPosts(@RequestParam(value = "title",required=false) String title,
			@RequestParam(value = "location",required=false) Integer locationId, @RequestParam(value = "minPrice",required=false) Integer minPrice,
			@RequestParam(value = "maxPrice",required=false) Integer maxPrice, @RequestParam(value = "category",required=false) Integer categoryId) {
		return (service.getAllPosts(current_user, title, locationId, minPrice, maxPrice, categoryId));
	}

	@RequestMapping(value = "/editpost", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody int editpost(@RequestBody Post post) {
		return (service.editPost(current_user, post));
	}

	@RequestMapping(value = "/getcontactinfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String[] getContactInfo(@RequestBody Integer postId) {
		return (service.getContactInfo(current_user, postId));
	}

	@RequestMapping(value = "/contact", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody boolean getContactInfo(@RequestBody Integer postId, @RequestBody String message) {
		return (service.contact(current_user, postId, message));
	}

	@RequestMapping(value = "/getcategories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ArrayList<Category> getCategories() {
		return (service.getCategories());
	}

	@RequestMapping(value = "/getlocations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ArrayList<Location> getLocations() {
		return (service.getLocations());
	}

	@RequestMapping(value = "/getpost", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Post getLocations(Integer postId) {
		return (service.getPost(current_user, postId));
	}

	public static void main(String[] args) {
		SpringApplication.run(AdPortalController.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AdPortalController.class);
	}

}