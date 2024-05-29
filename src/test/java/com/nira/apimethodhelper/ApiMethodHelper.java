package com.nira.apimethodhelper;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.nira.endpoints.Endpoints;

import io.restassured.http.ContentType;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;

public class ApiMethodHelper {
	static String token = Serenity.getCurrentSession().get("access_token").toString();
	
	public static void postMethod(JsonObject requestBody, String endPoint) {
		SerenityRest
		.given()
		.relaxedHTTPSValidation()
			.contentType(ContentType.JSON)
			.body(requestBody.toString())
			.baseUri(Endpoints.Dev_BaseURI)
			.header("Authorization", "Bearer " + token)
		.when()
			.post(endPoint);
	}
	
	public static void postMethod(JsonArray requestBody, String endPoint) {
		SerenityRest
		.given()
		.relaxedHTTPSValidation()
			.contentType(ContentType.JSON)
			.body(requestBody.toString())
			.baseUri(Endpoints.Dev_BaseURI)
			.header("Authorization", "Bearer " + token)
		.when()
			.post(endPoint);
	}
	
	public static void putMethod(JsonObject requestBody, String endPoint) {
		SerenityRest
		.given()
		.relaxedHTTPSValidation()
			.contentType(ContentType.JSON)
			.body(requestBody.toString())
			.baseUri(Endpoints.Dev_BaseURI)
			.header("Authorization", "Bearer " + token)
		.when()
			.put(endPoint);
	}
	
	public static void getMethod(String endPoint) {
		SerenityRest
		.given()
		.relaxedHTTPSValidation()
			.contentType(ContentType.JSON)
			.baseUri(Endpoints.Dev_BaseURI)
			.header("Authorization", "Bearer " + token)
		.when()
			.get(endPoint);
	}
}
