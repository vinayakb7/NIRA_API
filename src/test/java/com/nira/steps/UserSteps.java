package com.nira.steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

import com.google.gson.JsonObject;
import com.nira.api.UserApi;
import com.nira.commonutils.CommonUltils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class UserSteps {

	@Steps
	UserApi userAPI;

	@When("I login")
	public void i_login() {

		JsonObject requestBody = new JsonObject();
		requestBody.addProperty("email_address", CommonUltils.EMAIL);
		requestBody.addProperty("password", CommonUltils.PASSWORD);

		userAPI.login(requestBody);

		restAssuredThat(response -> response.statusCode(200));// Checking Response status
		// Logging the status line
		String statusLine = "Login successful with status line: " + SerenityRest.lastResponse().getStatusLine();
		System.out.println(statusLine); // Print to console

		// Logging the status response
		String statusresponse = "Login successful with status response: " + SerenityRest.lastResponse().prettyPrint();
		System.out.println(statusresponse); // Print to console

		String token = SerenityRest.lastResponse().getBody().jsonPath().get("access_token");

		Serenity.setSessionVariable("access_token").to(token);

	}

	@Then("I logout")
	public void i_logout() {
		String token = Serenity.getCurrentSession().get("access_token").toString();
		userAPI.logout(token);

		restAssuredThat(response -> response.statusCode(200));// Checking Response status
		// Logging the status line
		String statusLine = "Login successful with status line: " + SerenityRest.lastResponse().getStatusLine();
		System.out.println(statusLine); // Print to console

		// Logging the status response
		String statusresponse = "Login successful with status response: " + SerenityRest.lastResponse().prettyPrint();
		System.out.println(statusresponse); // Print to console

	}

	@When("I login with incorrect credentials")
	public void i_login_with_incorrect_credentials() {
		JsonObject requestBody = new JsonObject();
		requestBody.addProperty("email_address", CommonUltils.FAILED_EMAIL);
		requestBody.addProperty("password", CommonUltils.FAILED_PASSWORD);

		userAPI.login(requestBody);

		// Assert that the response status code is 400
		restAssuredThat(response -> response.statusCode(400));

		// Logging the status line
		String statusLine = "Login failed with status line: " + SerenityRest.lastResponse().getStatusLine();
		System.out.println(statusLine); // Print to console

		// Logging the response body
		String responseBody = "Login failed with response: " + SerenityRest.lastResponse().prettyPrint();
		System.out.println(responseBody); // Print to console
	}

}
