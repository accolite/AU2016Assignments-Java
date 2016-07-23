package com.accolite.Messanger.messanger;

import javax.ws.rs.WebApplicationException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class JersyClient {
	 public static void main(String[] args) {
		 // Create Jersey client
	        ClientConfig clientConfig = new DefaultClientConfig();
	        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
	        Client client = Client.create(clientConfig);

	        // GET request 
	        String getMessageURL = "http://localhost:8080/messanger/webapi/messages";
	        WebResource webResourceGet = client.resource(getMessageURL);
	        ClientResponse response = webResourceGet.get(ClientResponse.class);
	        String responseEntity = response.getEntity(String.class);
	        if (response.getStatus() != 200) {
	            throw new WebApplicationException();
	        }

	        System.out.println(responseEntity.toString());

			}
}
