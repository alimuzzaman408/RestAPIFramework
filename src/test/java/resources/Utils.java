package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {

	static RequestSpecification req;
	ResponseSpecification res;

	public RequestSpecification requestspecification() throws IOException {

		if (req == null) {
			PrintStream log = new PrintStream(new FileOutputStream("Logging.txt"));
			req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseurl")).addQueryParam("key", "qaclick123")
					.setContentType(ContentType.JSON).build().filter(RequestLoggingFilter.logRequestTo(log))
					.filter(ResponseLoggingFilter.logResponseTo(log));

			return req;

		}
		return req;

	}

	public ResponseSpecification responsepecification() {

		res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		return res;
	}

	public static String getGlobalValue(String key) throws IOException {

		Properties properties = new Properties();

		FileInputStream fileInputStream = new FileInputStream("global.properties");
		properties.load(fileInputStream);

		return properties.getProperty(key);

	}

	public String getJsonPath(Response response, String key) {
		String res = response.asString();
		JsonPath jsonPath = new JsonPath(res);
		return jsonPath.get(key).toString();
	}

}
