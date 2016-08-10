package com.accolite.library.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accolite.library.controller.AuthorizationController;
import com.accolite.library.model.City;
import com.accolite.library.model.Employee;
import com.accolite.library.service.AuthorizationService;
import com.accolite.library.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={ "classpath:applicationContext.xml" })

public class AuthorizationControllerTest {

	@Autowired
	AuthorizationService authorizationService;
	
	@Autowired
	AuthorizationController authorizationController;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	Employee employee;
	

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DriverManagerDataSource dataSource;
	
	public AuthorizationService getAuthorizationService() {
		return authorizationService;
	}

	public void setAuthorizationService(AuthorizationService authorizationService) {
		this.authorizationService = authorizationService;
	}

	public AuthorizationController getAuthorizationController() {
		return authorizationController;
	}

	public void setAuthorizationController(AuthorizationController authorizationController) {
		this.authorizationController = authorizationController;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public DriverManagerDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DriverManagerDataSource dataSource) {
		this.dataSource = dataSource;
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
	//	fail("Not yet implemented");
	}
	
	@Test
	public void setGetAuthorizationTest()
	{
		authorizationController.setAuthorizationService(authorizationService);
		assertEquals(authorizationService, authorizationController.getAuthorizationService());
	}
	
	@Test
	public void setGetEmployeeServiceTest(){
		authorizationController.setEmployeeService(employeeService);
		assertNotEquals(employeeService, authorizationController.getAuthorizationService());
	}
	
	@Test
	public void setGetEmployeeTest(){
		authorizationController.setEmployee(employee);
		assertEquals(employee, authorizationController.getEmployee());
	}
	
	@Test
	public void getCityTest(){
		ArrayList<City> cities = new ArrayList<City>();
		assertNotEquals(cities, authorizationController.getCity());
	}
	
	
	
	
}
