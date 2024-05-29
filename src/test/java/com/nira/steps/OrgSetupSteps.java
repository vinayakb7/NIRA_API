package com.nira.steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.assertj.core.api.Assertions.assertThat;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nira.api.OrgSetupApi;
import com.nira.commonutils.CommonUltils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class OrgSetupSteps {
	@Steps
	OrgSetupApi orgSetupApi;

	@When("I update Orgsetup form")
	public void i_setupfrom() {
		JsonObject requestBody = new JsonObject();
		requestBody.addProperty("organizationName", CommonUltils.ORG_ORGANIZATION_NAME);
		requestBody.addProperty("orgStartDate", CommonUltils.Org_orgStartDate);
		requestBody.addProperty("totalEmployees", CommonUltils.Org_totalEmployees);
		requestBody.addProperty("phoneNumber", CommonUltils.Org_phoneNumber);
		requestBody.addProperty("secondaryPhone", CommonUltils.Org_secondaryPhone);
		requestBody.addProperty("faxNumber", CommonUltils.Org_faxNumber);
		requestBody.addProperty("email", CommonUltils.Org_email);
		requestBody.addProperty("secondaryEmail", CommonUltils.Org_secondaryEmail);
		requestBody.addProperty("country", CommonUltils.Org_country);
		requestBody.addProperty("state", CommonUltils.Org_state);
		requestBody.addProperty("city", CommonUltils.Org_city);
		requestBody.addProperty("address", CommonUltils.Org_address);
		requestBody.addProperty("detailsOfOtherBranches", CommonUltils.ORG_DETAILS_OF_OTHER_BRANCHES_JSON);
		requestBody.addProperty("registrationNumber", CommonUltils.Org_registrationNumber);
		requestBody.addProperty("orgHead", CommonUltils.Org_orgHead);
		requestBody.addProperty("orgImage", CommonUltils.Org_orgImage);
		requestBody.addProperty("description", CommonUltils.Org_description);
		JsonArray websitesArray = new JsonArray();
		for (String website : CommonUltils.Org_website) {
			websitesArray.add(website);
		}
		requestBody.add("website", websitesArray);
		requestBody.addProperty("userLicense", CommonUltils.Org_userLicense);
		requestBody.addProperty("id", CommonUltils.Org_id);

		orgSetupApi.setupfrom(requestBody);
		restAssuredThat(response -> response.statusCode(200));// Checking Response status
		// Update the status line
		String statusLine = "Update successful with status line: " + SerenityRest.lastResponse().getStatusLine();
		System.out.println(statusLine); // Print to console
		// Logging the status response
		String statusresponse = "Update successful with status response: " + SerenityRest.lastResponse().prettyPrint();
		System.out.println(statusresponse); // Print to console

	}

	@And("I create designation")
	public void i_setdesignation() {
		String jsonString = "[{\"name\": \"CEO\"},{\"name\": \"COO\"},{\"name\": \"CFO\"},{\"name\": \"Manager\"}]";
		// Convert the string to a JsonArray
		JsonArray requestBody = JsonParser.parseString(jsonString).getAsJsonArray();

		orgSetupApi.setDesignation(requestBody);
		restAssuredThat(response -> response.statusCode(200));// Checking Response status
		// Update the status line
		String statusLine = "Update successful with status line: " + SerenityRest.lastResponse().getStatusLine();
		System.out.println(statusLine); // Print to console
		// Logging the status response
		String statusresponse = "Update successful with status response: " + SerenityRest.lastResponse().prettyPrint();
		System.out.println(statusresponse); // Print to console
	}

	@And("I get organization details")
	public void i_getorganization() {
		orgSetupApi.getOrganization();
		restAssuredThat(response -> response.statusCode(200));
		System.out.println("Expected JSON as string -> " + CommonUltils.EXPECTED_GET_ORGANIZATION);
		// Get the actual JSON response
		String actualJson = SerenityRest.lastResponse().asString();
		System.out.println("Actual JSON as string -> " + actualJson);
		// Parse JSON strings into JsonObject
		JsonObject expectedJsonObject = JsonParser.parseString(CommonUltils.EXPECTED_GET_ORGANIZATION).getAsJsonObject();
		JsonObject actualJsonObject = JsonParser.parseString(actualJson).getAsJsonObject();
		// Remove modifiedDate field from both expected and actual JSON objects
		// We have to remove modified date because in next step we are updating data and
		// with that
		// date is also getting updated and due to this assert is failing everytime.
		expectedJsonObject.getAsJsonArray("data").forEach(element -> element.getAsJsonObject().remove("modifiedDate"));
		actualJsonObject.getAsJsonArray("data").forEach(element -> element.getAsJsonObject().remove("modifiedDate"));
		// Compare JSON objects
		assertThat(actualJsonObject).isEqualTo(expectedJsonObject);
	}
}
