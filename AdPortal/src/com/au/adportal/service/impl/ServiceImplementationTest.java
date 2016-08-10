package com.au.adportal.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;

import com.au.adportal.controller.AdPortalController;
import com.au.adportal.dao.DaoInterface;
import com.au.adportal.model.Category;
import com.au.adportal.model.CurrentUser;
import com.au.adportal.model.Location;
import com.au.adportal.service.ServiceInterface;
import com.au.adportal.util.MailSender;
import com.au.adportal.util.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=AdPortalController.class)
@WebAppConfiguration
@TestExecutionListeners(inheritListeners = false, listeners
= {DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class})
public class ServiceImplementationTest {

	@Autowired
	DaoInterface dao;
	
	@Autowired
	MailSender mailSender;
	
	@Autowired
	ServiceInterface service;
	
	private CurrentUser userMock;
	
	@Before
	public void setUp(){
		
		userMock = new CurrentUser("110639035120843953588", "Rajesh R", "rajesh.r@accoliteindia.com", Role.USER);
		
		ReflectionTestUtils.setField(service, "dao", dao);
		ReflectionTestUtils.setField(service, "mailSender", mailSender);
	}
	
	@Test
	public void testMakeAdminValid(){
		userMock.setRole(Role.ADMIN);
		boolean result = service.makeAdmin(userMock, "106881631288842972252");
		assertTrue(result);
	}
	
	@Test
	public void testAddCategoryInvalid(){
		userMock.setRole(Role.USER);
		boolean result = service.addCategory(userMock, "Cat5");
		assertFalse(result);
	}
	
	@Test
	public void testAddCategoryValid(){
		userMock.setRole(Role.ADMIN);
		boolean result = service.addCategory(userMock, "Cat5");
		assertTrue(result);
	}
	
	@Test
	public void testAddLocationInvalid(){
		userMock.setRole(Role.USER);
		boolean result = service.addLocation(userMock, "loc2");
		assertFalse(result);
	}
	
	@Test
	public void testAddLocationValid(){
		userMock.setRole(Role.ADMIN);
		boolean result = service.addLocation(userMock, "loc2");
		assertTrue(result);
	}
	
	@Test
	public void testBlackListInvalid(){
		userMock.setRole(Role.USER);
		boolean result = service.blacklist(userMock, "106881631288842972252");
		assertFalse(result);
	}
	
	@Test
	public void testBlackListValid(){
		userMock.setRole(Role.ADMIN);
		boolean result = service.blacklist(userMock, "106881631288842972252");
		assertTrue(result);
	}
	
	@Test
	public void testUnBlackListInvalid(){
		userMock.setRole(Role.USER);
		boolean result = service.unblacklist(userMock, "106881631288842972252");
		assertFalse(result);
	}
	
	@Test
	public void testUnBlackListValid(){
		userMock.setRole(Role.ADMIN);
		boolean result = service.unblacklist(userMock, "106881631288842972252");
		assertTrue(result);
	}
	
	@Test
	public void testMakeAdminInvalid(){
		userMock.setRole(Role.USER);
		boolean result = service.makeAdmin(userMock, "106881631288842972252");
		assertFalse(result);
	}
	
	@Test
	@Ignore
	public void getLocationsTest(){
		ArrayList<Location> expected = new ArrayList<>();
		expected.add(new Location((short)1,"Chennai"));
		expected.add(new Location((short)2,"Bengaluru"));
		expected.add(new Location((short)3,"Hyderabad"));
		expected.add(new Location((short)4,"Delhi"));
		ArrayList<Location> actual = service.getLocations();
		assertEquals(expected, actual);
	}
	
	@Test
	@Ignore
	public void getCategoriesTest(){
		ArrayList<Category> expected = new ArrayList<>();
		expected.add(new Category((short)1,"Cat1"));
		expected.add(new Category((short)2,"Cat2"));
		expected.add(new Category((short)3,"Cat3"));
		expected.add(new Category((short)4,"Cat4"));
		ArrayList<Category> actual = service.getCategories();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSubscribeValid(){
		userMock.setId("106881631288842972252");
		service.unsubscribe(userMock, 3);
		boolean result = service.subscribe(userMock, 3);
		assertTrue(result);
	}

	@Test
	public void testSubscribeInvalid(){
		userMock.setId("106881631288842972252");
		service.subscribe(userMock, 4);
		boolean result = service.subscribe(userMock, 4); // Already subscribed
		assertFalse(result);
	}

	@Test
	public void testSubscribeInvalidCategory(){
		userMock.setId("106881631288842972252");
		boolean result = service.subscribe(userMock, 312);
		assertFalse(result);
	}

	@Test
	public void testUnsubscribeValid(){
		userMock.setId("106881631288842972252");
		service.subscribe(userMock, 1);
		boolean result = service.unsubscribe(userMock, 1);
		assertTrue(result);
	}

	@Test
	public void testUnsubscribeInvalid(){
		userMock.setId("106881631288842972252");
		service.unsubscribe(userMock, 2);
		boolean result = service.unsubscribe(userMock, 2); // Already unsubscribed
		assertFalse(result);
	}

	@Test
	public void testUnsubscribeInvalidCategory(){
		userMock.setId("106881631288842972252");
		boolean result = service.unsubscribe(userMock, 312);
		assertFalse(result);
	}
	
	@Test
	public void testChangeMobileValid(){
		userMock.setId("106881631288842972252");
		boolean result = service.changeMobile(userMock, "8681875380");
		assertTrue(result);
	}
	
	@Test
	public void testChangeMobileInvalidMobile(){
		userMock.setId("106881631288842972252");
		boolean result = service.changeMobile(userMock, "86818380");
		assertFalse(result);
	}
	
	@Test
	public void testChangeMobileInvalid(){
		userMock.setId("106881631288842972252");
		boolean result = service.changeMobile(userMock, "");
		assertFalse(result);
	}
	
	@Test
	public void testContactValid(){
		userMock.setId("106881631288842972252");
		userMock.setRole(Role.USER);
		boolean result = service.contact(userMock, 15, "testing");
		assertTrue(result);
	}
	
	@Test
	public void testContactInvalidPost(){
		userMock.setId("106881631288842972252");
		userMock.setRole(Role.USER);
		boolean result = service.contact(userMock, 1342, "testing"); // invalid post
		assertFalse(result);
	}

	@Test
	public void testContactInvalidUser(){
		userMock.setId("106881631288842972252");
		userMock.setRole(Role.BLACKLISTED);
		boolean result = service.contact(userMock, 15, "testing"); // blacklisted user
		assertFalse(result);
	}
	
	@Test
	public void testDeletePostValid(){
		userMock.setId("106881631288842972252");
		userMock.setRole(Role.USER);
		boolean result = service.deletePost(userMock, 12);  // Owner
		assertTrue(result);
	}
	
	@Test
	public void testDeletePostValidAdmin(){
		userMock.setId("106881631288842972252");
		userMock.setRole(Role.ADMIN);
		boolean result = service.deletePost(userMock, 24);  // Not owner but ADMIN
		assertTrue(result);
		
	}

	@Test
	public void testDeletePostInvalidPost(){
		userMock.setId("106881631288842972252");
		userMock.setRole(Role.ADMIN);
		boolean result = service.deletePost(userMock, 12324);
		assertFalse(result);
	}

	@Test
	public void testDeletePostInvalidUser(){
		userMock.setId("110639035120843953588");
		userMock.setRole(Role.USER);
		boolean result = service.deletePost(userMock, 12); // Not the owner as well as ADMIN
		assertFalse(result);		
	}

}
