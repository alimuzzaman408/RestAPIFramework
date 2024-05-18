package StepDefination;

import io.cucumber.java.en.*;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import static org.junit.Assert.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class Step extends Utils {

	RequestSpecification req;
	ResponseSpecification res;
	TestDataBuild tDataBuild = new TestDataBuild();
	Response response;
	JsonPath jsonPath;
	static String place_id;

	@Given("Add place payload {string} {string}")
	public void add_place_payload(String name, String address) throws IOException {

		req = given().spec(requestspecification()).body(tDataBuild.addPlacePAyload(name, address));

	}

	@When("User call {string}  with {string} Request")
	public void user_call_with_request(String resource, String method) {

		APIResources resources = APIResources.valueOf(resource);

		if (method.equalsIgnoreCase("Post")) {
			response = req.when().post(resources.getResource());
		}

		else if (method.equalsIgnoreCase("get")) {
			response = req.when().get(resources.getResource());
		}

	}

	@Then("Response of the API call status code {int}")
	public void response_of_the_api_call_status_code(Integer code) {

		assertEquals(response.getStatusCode(), 200);

	}

	@Then("{string} in the response body is {string}")
	public void in_the_response_body_is(String key, String value) {

		jsonPath = new JsonPath(response.asString());
		String status = jsonPath.get(key);

		assertEquals(status, value);

	}

	@Then("verify place_ID created map to {string} using {string}")
	public void verify_place_id_created_map_to_using(String expectedname, String resource) throws IOException {

		 place_id = getJsonPath(response, "place_id");
		req = given().spec(requestspecification()).queryParam("place_id", place_id).queryParam("key", "qaclick123");
		user_call_with_request(resource, "get");
		String actualname = getJsonPath(response, "name");

		assertEquals(actualname, expectedname);

	}
	
	@Given("deletePLace payload")
	public void delete_p_lace_payload() throws IOException {
		req = given().spec(requestspecification()).body(tDataBuild.deletePayload(place_id));
	}
	

}
