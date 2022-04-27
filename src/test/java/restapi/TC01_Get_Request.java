package restapi;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC01_Get_Request {
	@Test
	public void get_data()
	{
		//Specify base URI
				RestAssured.baseURI="http://localhost:3000/";

				//Request object
				RequestSpecification httpRequest=RestAssured.given();

				//Response object
				Response response=httpRequest.request(Method.GET,"/users");

				//print response in console window

				String responseBody=response.getBody().asString();
				System.out.println("Response Body is:" +responseBody);

				//status code validation
				int statusCode=response.getStatusCode();
				System.out.println("Status code is: "+statusCode);
				Assert.assertEquals(statusCode, 200);


	}
}    
