package com.accolite.producerconsumer;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/prodcon")
public class ProducerConsumer{
	
	Fruits fruits;
	ProducerConsumer() {
		fruits = new Fruits();
	}
	@GET
	@Path("/produce")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public void produceItems(@QueryParam(value="qty1") int qty1,@QueryParam(value="qty2") int qty2,@QueryParam(value="qty3") int qty3,@QueryParam(value="qty4") int qty4){
		ProducerHandler prodhandler = new ProducerHandler(fruits,qty1,qty2,qty3,qty4);
		Thread t1 = new Thread(prodhandler);
		t1.start();
		System.out.println("kk");
	}
	
	@GET
	@Path("/consume")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public void consumeItems(@QueryParam(value="qty1") int qty1,@QueryParam(value="qty2") int qty2,@QueryParam(value="qty3") int qty3,@QueryParam(value="qty4") int qty4){
		ConsumerHandler consumerhandler = new ConsumerHandler(fruits,qty1,qty2,qty3,qty4);
		Thread t2 = new Thread(consumerhandler);
		t2.start();
	}
	
}
