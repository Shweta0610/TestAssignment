package com.api;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;


public class SpaceX {
	
	CloseableHttpClient httpClient;
	HttpGet httpget;
	CloseableHttpResponse resp;
	JSONObject jsonObject; 
	String response=""; 
	

public void launchAPI() throws Throwable {
	 httpClient = HttpClients.createDefault();
	 httpget = new HttpGet("https://api.spacexdata.com/v4/launches/latest");
	 resp = httpClient.execute(httpget);
	 System.out.println("Response Code-->"+resp.getStatusLine().getStatusCode());
	 response = EntityUtils.toString(resp.getEntity(),"UTF-8");
	 jsonObject = new JSONObject(response); 
}

public void verify_Satellite_Name_Version() throws Throwable {
	
	String Name = jsonObject.get("name").toString();
	System.out.println("Name : "+Name);

	if (Name.contains("Starlink-11 (v1.0)")) {
		System.out.println("The mission has successfully launched the eleventh batch of operational Starlink satellites, which are of version 1.0");
	}
	else 
		Assert.fail("Satellite name and Version launched is not correct !!!");
}
public void verify_Satellite_Destination() throws Throwable {

	JSONArray arr = jsonObject.getJSONArray("cores");
	String landing_type="";
    Boolean landing_attempt =false;
     
    for (int i = 0; i < arr.length(); i++) {
        landing_type = (String) arr.getJSONObject(i).get("landing_type");
        landing_attempt = (Boolean) arr.getJSONObject(i).get("landing_attempt");
        System.out.println("Attempt : "+landing_attempt + "\n Destination :"+landing_type);  	
    }
    if (landing_attempt && landing_type.equals("ASDS"))
    {
    	System.out.println("Landing has been successful on ASDS !!! ");
    }
    else 
    	Assert.fail("Required landing destination and attempt not as expected !!!");
	
}

public void verify_Satellite_Has_No_Failures() throws Throwable {

	JSONArray jsonarray = jsonObject.getJSONArray("failures");
	System.out.println(jsonarray.length());
	
	if (jsonarray.length()==0) {
		System.out.println("Launch is success with no failures !!");
	}
	else {
		Assert.fail("There have been some failures in the launch !!!");
	}
	
}

}
