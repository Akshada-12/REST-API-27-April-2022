import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class TC04_Delete_Request {
	@Test
	public void delete_data()
	{

		RequestSpecification request = RestAssured.given();
		Response response=request.delete("http://localhost:3000/users/4");

		
		//status code validation
		int code=response.getStatusCode();
		System.out.println("Status code is: "+code);
		Assert.assertEquals(code, 200);


	}

}    
