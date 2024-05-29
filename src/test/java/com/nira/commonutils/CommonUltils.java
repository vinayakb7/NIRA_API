package com.nira.commonutils;

import java.util.Arrays;
import java.util.List;

public  class CommonUltils {

	public final static String EMAIL = "hamid.obaid@aitglobalinc.com";
	public final static String PASSWORD = "Hamid@123";
	public final static String FAILED_EMAIL = "invalid@user.com";
	public final static String FAILED_PASSWORD = "invalidPassword";
	public final static String ORG_ORGANIZATION_NAME = "AIT GLOBAL";
	public final static String Org_orgStartDate = "2024-05-21T18:30:00.000Z";
	public final static String Org_totalEmployees = "1";
	public final static String Org_phoneNumber = "+919890098900";
	public final static String Org_secondaryPhone = "+919890098900";
	public final static String Org_faxNumber = "+919890098900";
	public final static String Org_email = "gaurav.deshpande@aitglobalinc.com";
	public final static String Org_secondaryEmail = "gaurav.deshpande@aitglobalinc.com";
	public final static String Org_country = "IN";
	public final static String Org_state = "MH";
	public final static String Org_city = "Pune";
	public final static String Org_address = "Kharadi Pune";
	public final static String Org_registrationNumber = "22222";
	public final static String Org_orgHead = "Pinky Mishra";
	public final static String Org_orgImage = "https://niradev.aitglobalindia.com:5771/cropped-AIT-indiaLogo-file-180x180.png";
	public final static String Org_description = "A Software Development Company";
	public final static List<String> Org_website = Arrays.asList("http://www.aitglobalinc.com", "https://www.aitglobalindia.com" );
	public final static String Org_userLicense = "12";
	public final static String Org_id = "1";
	public static final String ORG_DETAILS_OF_OTHER_BRANCHES_JSON = "[{\"location\":\"PUNE\",\"completeAddress\":\"Wanori Pune\"}]";
	
	public static final String EXPECTED_GET_ORGANIZATION = "{\"status\":\"success\",\"data\":[{\"id\":1,\"organizationName\":\"AIT GLOBAL\",\"orgImage\":\"https://niradev.aitglobalindia.com:5771/cropped-AIT-indiaLogo-file-180x180.png\",\"website\":[\"http://www.aitglobalinc.com\",\"https://www.aitglobalindia.com\"],\"totalEmployees\":\"1\",\"registrationNumber\":\"22222\",\"orgStartDate\":\"2024-05-21T18:30:00.000Z\",\"phoneNumber\":\"+919890098900\",\"secondaryPhone\":\"+919890098900\",\"email\":\"gaurav.deshpande@aitglobalinc.com\",\"secondaryEmail\":\"gaurav.deshpande@aitglobalinc.com\",\"faxNumber\":\"+919890098900\",\"country\":\"IN\",\"state\":\"MH\",\"city\":\"Pune\",\"address\":\"Kharadi Pune\",\"description\":\"A Software Development Company\",\"orgHead\":\"Pinky Mishra\",\"userLicense\":12,\"statusId\":null,\"detailsOfOtherBranches\":\"[{\\\"location\\\":\\\"PUNE\\\",\\\"completeAddress\\\":\\\"Wanori Pune\\\"}]\",\"createdBy\":null,\"modifiedBy\":1,\"createdDate\":null,\"modifiedDate\":\"2024-05-28T15:10:42.904Z\"}]}";
}
