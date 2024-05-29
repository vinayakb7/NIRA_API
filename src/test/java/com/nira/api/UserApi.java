package com.nira.api;

import com.google.gson.JsonObject;
import com.nira.endpoints.Endpoints;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UserApi {
	
	@Step("I login")
	public void login(JsonObject requestBody) {
		SerenityRest
			.given()
			.relaxedHTTPSValidation()
				.contentType(ContentType.JSON)
				.body(requestBody.toString())
				.baseUri(Endpoints.Dev_BaseURI)
			.when()
				.post(Endpoints.Login_Endpoint);
	}
	
	@Step("I logout")
	public void logout(String token) {
		SerenityRest
			.given()
			.relaxedHTTPSValidation()
				.baseUri(Endpoints.Dev_BaseURI)
				.header("Authorization", "Bearer " + token)
			.when()
				.get(Endpoints.Logout_Endpoint);
	}
}
