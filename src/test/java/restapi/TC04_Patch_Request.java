package restapi;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC04_Patch_Request {
	@Test
	public void patch_data()
	{
	//Request object
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type","application/json");

	//Request paylaod sending along with put request
	JSONObject json=new JSONObject();
	
	json.put("lastname","Solegaonkar");
	

	// attach above data to the request
	request.body(json.toJSONString());

	Response response=request.patch("http://localhost:3000/users/4");

	//print response in console window
	String responseBody=response.getBody().asString();
	System.out.println("Response Body is:" +responseBody);

	//status code validation
	int code=response.getStatusCode();
	System.out.println("Status code is: "+code);
	Assert.assertEquals(code, 200);
}
}
