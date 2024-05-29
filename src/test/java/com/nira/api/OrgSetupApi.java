package com.nira.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.nira.apimethodhelper.ApiMethodHelper;
import com.nira.endpoints.Endpoints;
import net.thucydides.core.annotations.Step;

public class OrgSetupApi {

	@Step("I update Orgsetup form ")
	public void setupfrom(JsonObject requestBody) {
		ApiMethodHelper.putMethod(requestBody, Endpoints.UpdateOrgsetup_Endpoint);
	}
	
	@Step("I create designation")
	public void setDesignation(JsonArray requestBody) {
		ApiMethodHelper.postMethod(requestBody, Endpoints.CreateDesignation_Endpoint);
	}
	@Step("I get organization details")
	public void getOrganization() {
		ApiMethodHelper.getMethod(Endpoints.GET_ORGANIZATION);
	}
}
