package org.alberthein.api.test;


import static io.restassured.RestAssured.given;
import java.util.Properties;
import org.base.test.BaseTest;
import org.alberthein.model.test.Customer;
import org.alberthein.model.test.Promotion;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class AlbertheinApiTest {

	private static RequestSpecification requestSpec;
	private static Properties prop;

	private static final int SUCCESS_STATUS_CODE = 200;
	private static final int CREATED_STATUS_CODE = 201;

	@BeforeClass
	public void setup()  {
		BaseTest baseTest = new BaseTest();
		prop = baseTest.getProp();
		String url = prop.getProperty("api.baseUri");
		String basePath = prop.getProperty("api.basePath");
		requestSpec = new RequestSpecBuilder()
				.setBaseUri(url)
				.setBasePath(basePath)
				.setContentType(ContentType.JSON)
				.build();			
	}

	@Test
	public void getStamps(){

		given().
			spec(requestSpec).
		when().
			get().
		then().
			assertThat().
			statusCode(SUCCESS_STATUS_CODE);				
	}

	@Test
	public void testifPromotionExists() {

		given().
			spec(requestSpec).
		and().
			get("/1").
		then().
			assertThat().
			statusCode(SUCCESS_STATUS_CODE);
	}

	@Test
	public void testNoOfStamps() {

		given().
		spec(requestSpec).
			auth().
			preemptive()
			.basic(prop.getProperty("username"),prop.getProperty("password")).
		and().
			delete("/25").
		then().
			assertThat().
			statusCode(CREATED_STATUS_CODE);

	}
	
	
//	private JsonPath getStamps(Integer userId) {
//		String baseUrl= "https://www.ah.nl/stamps/{userId}";
//		RequestSpecification httpRequest = RestAssured.given();
//		Response response = httpRequest.get(baseUrl, userId);
//		int statusCode = response.getStatusCode();
//		Assert.assertEquals(statusCode,200, "Incorrect status code returned");
//		JsonPath jsonData = new JsonPath(response.body().asString()); 
//		return jsonData;
//	}
//
//
//	@Test(priority = 1)
//	public void testifPromotionExists() {
//		int userId = 455;
//		JsonPath jsonData = getStamps(userId);
//		List promotions = jsonData.get("promotion");
//		Assert.assertNotNull(promotions, "promotion is null");
//	}
//
//	@Test(priority = 2)
//	public void testNoOfStamps() {
//		int userId = 455;
//		JsonPath jsonData = getStamps(userId);
//		Integer noOfStamps = jsonData.get("noOfStamps");
//		Assert.assertNotNull(noOfStamps, "no Of Stamps not present ");
//
//	}

}

