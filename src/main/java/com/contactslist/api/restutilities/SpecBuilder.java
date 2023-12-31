/**
 * 
 */
package com.contactslist.api.restutilities;

import com.contactslist.api.routes.Endpoints;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * @author Santosh Sharma
 *
 */
public class SpecBuilder {
	
	public static RequestSpecification reqSpecBuild(Object payload) {
		RequestSpecBuilder spec = new RequestSpecBuilder();
		spec.setBaseUri(Endpoints.BASE_URL).setContentType(ContentType.JSON)
		.setBody(payload).log(LogDetail.ALL);
		
		RequestSpecification reqSpec = spec.build();
		return reqSpec;
	}
	
	public static RequestSpecification reqSpecBuild(String token) {
		RequestSpecBuilder spec = new RequestSpecBuilder();
		spec.setBaseUri(Endpoints.BASE_URL).setContentType(ContentType.JSON)
		.addHeader("Authorization", "Bearer " + token).log(LogDetail.ALL);
		
		RequestSpecification reqSpec = spec.build();
		return reqSpec;
	}
	
	public static RequestSpecification reqSpecBuild(Object payload, String token) {
		RequestSpecBuilder spec = new RequestSpecBuilder();
		spec.setBaseUri(Endpoints.BASE_URL).setContentType(ContentType.JSON)
		.setBody(payload).addHeader("Authorization", "Bearer " + token).log(LogDetail.ALL);
		
		RequestSpecification reqSpec = spec.build();
		return reqSpec;
	}
	
	
	public static ResponseSpecification resSpecBuild(boolean expectContentType) {
		ResponseSpecification resSpec = null;
		ResponseSpecBuilder spec = null;
		
		if(expectContentType) {
			spec = new ResponseSpecBuilder();
			spec.expectContentType(ContentType.JSON);
			resSpec = spec.build();
		} else {
			spec = new ResponseSpecBuilder();
			resSpec = spec.build();
		}
		return resSpec;
	}

}
