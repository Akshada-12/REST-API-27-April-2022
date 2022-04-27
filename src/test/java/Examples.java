import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class Examples {
	//Getting data//
	@Test 
	public void get_data()
	{
		baseURI="http://localhost:3000/";
		given().
		get("/users"). 
		then().
		statusCode(200).
		log().all();
	}
	//Inserting Data//
	@Test
	public void post_data()
	{
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type","application/json");

		JSONObject json=new JSONObject();
		json.put("id","4");
		json.put("email","akshada.solegaonkar@beyondkey.com");
		json.put("firstname","Akshada");
		json.put("lastname","Soleganokar");
		json.put("subjectId","1");

		request.body(json.toJSONString());

		Response response=request.post("http://localhost:3000/users");

		int code=response.getStatusCode();

		Assert.assertEquals(code, 201);
	}
	//Updating data//
	@Test
	public void put_data()
	{
		
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type","application/json");

		JSONObject json=new JSONObject();
		json.put("id","4");
		json.put("email","akshada.solegaonkar@beyondkey.com");
		json.put("firstname","Akshada");
		json.put("lastname","Test");
		json.put("subjectId","1");

		request.body(json.toJSONString());

		Response response=request.put("http://localhost:3000/users/4");

		int code=response.getStatusCode();

		Assert.assertEquals(code, 200);
	}
	//Delete Data//
	@Test
	public void delete_data()
	{
		
		RequestSpecification request = RestAssured.given();
		Response response=request.delete("http://localhost:3000/users/4");
		int code=response.getStatusCode();
		Assert.assertEquals(code, 200);
	}

}    
