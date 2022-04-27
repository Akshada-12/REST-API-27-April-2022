package restapi;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TestCases {
	@Test(priority=1)

	public void GetData()
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

		// status line verification
		String statusLine=response.getStatusLine();
		System.out.println("Status line is:"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

	}
	@Test(priority=2)
	public void post_data()
	{
		//Specify base URI
		//RestAssured.baseURI="http://localhost:3000/users";


		//Request object
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");

		//Request paylaod sending along with post request
		JSONObject json=new JSONObject();

		json.put("id","4");
		json.put("email","akshada.solegaonkar@beyondkey.com");
		json.put("firstname","Akshada");
		json.put("lastname","Soleganokar");
		json.put("subjectId","1");

		// attach above data to the request
		request.body(json.toJSONString());

		Response response=request.post("http://localhost:3000/users");
		//Response object
		//Response response=request.request(Method.POST,"/users");

		//print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is:" +responseBody);

		//status code validation
		int code=response.getStatusCode();
		System.out.println("Status code is: "+code);
		Assert.assertEquals(code, 201);

		//success code validation
		//String successCode=response.jsonPath().get("SuccessCode");
		//Assert.assertEquals(successCode, "Data added successfully");
	}

	@Test(priority=3)
	public void put_data()
	{
		//Request object
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");

		//Request paylaod sending along with put request
		JSONObject json=new JSONObject();
		json.put("id","4");
		json.put("email","akshada.solegaonkar@beyondkey.com");
		json.put("firstname","Akshada");
		json.put("lastname","Test");
		json.put("subjectId","1");

		// attach above data to the request
		request.body(json.toJSONString());

		Response response=request.put("http://localhost:3000/users/4");

		//print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is:" +responseBody);

		//status code validation
		int code=response.getStatusCode();
		System.out.println("Status code is: "+code);
		Assert.assertEquals(code, 200);

	}

	@Test(priority=4)
	public void delete_data()
	{

		RequestSpecification request = RestAssured.given();
		Response response=request.delete("http://localhost:3000/users/4");
		
		//status code validation
		int code=response.getStatusCode();
		System.out.println("Status code is: "+code);
		Assert.assertEquals(code, 200);
		
		


		//print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is:" +responseBody);



	}

}