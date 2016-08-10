package com.accolite.library.test;

import junit.framework.TestCase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.accolite.library.dao.ResourceDao;
import com.accolite.library.model.Author;
import com.accolite.library.model.Resource;
import com.accolite.library.model.ResourceType;
import com.accolite.library.model.Review;
import com.accolite.library.model.Title;
import com.accolite.library.model.Topic;
import com.accolite.library.service.*;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class ResourceServiceTest extends TestCase {


@Autowired
private ResourceDao resourceDao;

boolean value;
int returnvalue;

@Autowired
private ResourceService resourceService;

@Before
public void setUp() {
	 resourceService =new ResourceService();        
    ReflectionTestUtils.setField(resourceService, "resourceDao", resourceDao);
}


@Test
public void testInsertNewBook()
{

	Resource book= new Resource();
	book.setAllocated(0);
	book.setCityName("Bangalore");
	book.setLocationId(1);
	book.setResourceId(1);
	book.setTitleId(1);
	book.setTitleName("java");
	value=resourceService.InsertNewBook(book);
	System.out.println("InsertNewBook" + value);
	assertEquals(true,value);
	
}

/*
@Test
public void testremoveResource1(){
 int resourceId = 4;
 returnvalue=resourceService.removeResource(resourceId);
 assertEquals(1, returnvalue);
}
*/

@Test
public void testinsertAuthor(){
 Author author=new Author();

 author.setAuthorName("java");
 value=resourceService.insertAuthor(author);
 System.out.println("value is "+ value);
 assertEquals(true, value);
}


@Test
public void testgetAllAuthors()
{
	ArrayList<Author> arraylist=new ArrayList<Author>();
	ArrayList<Author> arraylisttest=new ArrayList<Author>();
	Author author=new Author();
	author.setAuthorId(1);
	author.setAuthorName("java");
	arraylist.add(author);
	author.setAuthorId(2);
	arraylist.add(author);
	author.setAuthorId(3);
	arraylist.add(author);
	
	author.setAuthorId(4);
	arraylist.add(author);
	author.setAuthorId(5);
	arraylist.add(author);
	author.setAuthorId(6);
	arraylist.add(author);
	
	arraylisttest=resourceService.getAllAuthors();
	assertNotEquals(arraylist.size(),arraylisttest.size());
	
}


@Test
public void testgetAllReviewTitleId()
{
	 List<Integer> list=new ArrayList<Integer>();
	 List<Integer> listtest=new ArrayList<Integer>();

	 String email="juhi.jain@accoliteindia.com";
	 listtest=resourceService.getReviewTitleId(email);
	 assertNotEquals(list,listtest);

}


@Test
public void testupdateReview()
{
    Review review=new Review();
    review.setEmail("juhi.jain@accoliteindia.com");
    review.setRating(5);
    review.setReview("must read");
    review.setTitleId(1);
    returnvalue=resourceService.updateOldReview(review);
    assertNotEquals(0,returnvalue);
    
}


@Test
public void testinsertReview()
{
	 Review review=new Review();
	    review.setEmail("jjaincol@accoliteindia.com");
	    review.setRating(5);
	    review.setReview("must read");
	    review.setTitleId(2);
	    value=resourceService.insertNewReview(review);
	    assertEquals(false,value);
}


@Test
public void testinsertResourceType()
{
	   ResourceType resourcetype=new ResourceType();
	   resourcetype.setResourceName("book");
	    value=resourceService.insertResourceType(resourcetype);
	    assertNotEquals(false,value);
}



@Test
public void testgetAllResourceType()
{
	  
	   ArrayList<ResourceType> list=new ArrayList<ResourceType>();
	   ArrayList<ResourceType> listtest=new ArrayList<ResourceType>();
	   list=resourceService.getAllResourceTypes();
	    assertNotEquals(list.size(),listtest.size());
}


@Test
public void testgetAllTitles()
{
	  
	ArrayList<Title> list=new ArrayList<Title>();
	ArrayList<Title> listtest=new ArrayList<Title>();
	   list=resourceService.getAllTitles();
	    assertEquals(list.size(),listtest.size());
}



@Test
public void testgetAllTopics()
{
	  
	ArrayList<Topic> list=new ArrayList<Topic>();
	ArrayList<Topic> listtest=new ArrayList<Topic>();
	   list=resourceService.getAllTopics();
	    assertEquals(list.size(),listtest.size());
}
}
