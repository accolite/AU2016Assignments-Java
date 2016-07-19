package com.Accolite.controller;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.GET;
import com.sun.jersey.api.view.Viewable;
import javax.ws.rs.core.Response;

@Path("/Calculator")

public class Calculator {

	double addition(double a, double b) {
		return (a + b);
	}

	double subtraction(double a, double b) {
		return (a - b);
	}

	double multiplication(double a, double b) {
		return (a * b);
	}

	double division(double a, double b) {
		return (a / b);
	}

	@Path("/Operation")
	@GET
	public Response result(@QueryParam("op1") double a, @QueryParam("op2") double b, @QueryParam("op") String op) {
		double value = 0;
		if (op.equals("addition")) {
			value = addition(a, b);
		} else if (op.equals("subtraction")) {
			value = subtraction(a, b);
		} else if (op.equals("multiplication")) {
			value = multiplication(a, b);
		} else if (op.equals("division")) {
			value = division(a, b);
		}
		return Response.ok(new Viewable("/WEB-INF/Result.jsp", value)).build();

	}

}
