import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class TC03_Put_Request {
	
	@Test
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
	

}    
