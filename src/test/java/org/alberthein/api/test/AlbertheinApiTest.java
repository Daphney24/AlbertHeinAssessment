package org.alberthein.api.test;

import static io.restassured.RestAssured.given;
import java.util.Properties;
import org.base.test.BaseTest;
import org.alberthein.model.test.Customer;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import utils.ExtentReportListener;

@Listeners(ExtentReportListener.class)
public class AlbertheinApiTest extends ExtentReportListener{

	private static RequestSpecification requestSpec;
	private static Properties prop;
	int invalidUserId = 123;
	int validUserId = 1;
	private static final int SUCCESS_STATUS_CODE = 200;
	private static final int NOTFOUND_STATUS_CODE = 401;

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
		test.log(LogStatus.PASS, "Setup is Succcessfully");
	}
	
	/*******************************************************
	 * Send a GET request with /userID 
	 * to validate endpoint
	 ******************************************************/
	
	@Test(priority = 1)
	public void testGetEndpoint(){
		
		Response response = given().
				spec(requestSpec).
		and().
				get("/{userId}",validUserId).
	    then().
	    		extract().
	    		response();
		
		try {
			Assert.assertEquals(SUCCESS_STATUS_CODE, response.getStatusCode());
			test.log(LogStatus.PASS, "Succcessfully validated status code:: " + response.getStatusCode());
		}catch (AssertionError e) {
			test.log(LogStatus.FAIL, "Expected status code is:: "+SUCCESS_STATUS_CODE+", instead got:: "+ response.getStatusCode());
			Assert.fail();
		}catch(Exception e) {
			test.log(LogStatus.FAIL,"Error thrown is: "+e.fillInStackTrace());
			Assert.fail();
		}
	}
	
	/*********************************************************
	 * Send a GET request with /userID
	 * and check  the number of stamps is not null
	 * and check the correct number of stamps is returned
	 **********************************************************/
	
	@Test(priority = 2)
	public void testNumberOfStampsIsReturned(){

		Customer customer = given().
			spec(requestSpec).
		when().
			get("/{userId}",validUserId).
			as(Customer.class);
			
		try {
			Assert.assertNotNull("No stamps present", customer.getNoOfStamps());
			test.log(LogStatus.PASS, "Number of stamps returned successfully as:: " + customer.getNoOfStamps());
		}catch (AssertionError e) {
			test.log(LogStatus.FAIL, "Number of Stamps not found in response "+e.fillInStackTrace());
			Assert.fail();
		}catch(Exception e) {
			test.log(LogStatus.FAIL,"Error thrown is: "+e.fillInStackTrace());
			Assert.fail();
		}
	}
	
	/*********************************************************
	 * Send a GET request with /userID
	 * and validate if promotion is present
	 **********************************************************/
	
	@Test(priority = 3)
	public void testifPromotionExists() {

		Customer customer = given().
				spec(requestSpec).
			when().
				get("/{userId}", validUserId).
				as(Customer.class);
		
		try {
			Assert.assertNotNull("No promotions present", customer.getPromotions());
			test.log(LogStatus.PASS, "Number of promotions returned successfully as:: " + customer.getPromotions());
		}catch (AssertionError e) {
			test.log(LogStatus.FAIL, "Number of Promotions not found in response "+e.fillInStackTrace());
			Assert.fail();
		}catch(Exception e) {
			test.log(LogStatus.FAIL,"Error thrown is: "+e.fillInStackTrace());
			Assert.fail();
		}
	}

	/*********************************************************
	 * Send a GET request with incorrect userID 
	 * and check for status code 401
	 **********************************************************/
	
	@Test(priority = 4)
	public void testIncorrectUserId(){

		Response response = given().
				spec(requestSpec).
			and().
				get("/{userID}", invalidUserId).
			then().
    			extract().
    			response();	
		try {
			Assert.assertEquals(NOTFOUND_STATUS_CODE, response.getStatusCode());
			test.log(LogStatus.PASS, "Correct status code returned :: " + response.getStatusCode()+" for non-exiting user with userId :: "+invalidUserId);
		}catch (AssertionError e) {
			test.log(LogStatus.FAIL, "Incorrect status code returned :: " + response.getStatusCode()+" for non-exiting user with userId :: "+invalidUserId);
			Assert.fail();
		}catch(Exception e) {
			test.log(LogStatus.FAIL,"Error thrown is: "+e.fillInStackTrace());
			Assert.fail();
		}
	}
}

