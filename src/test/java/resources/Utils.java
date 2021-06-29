package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Utils {

    public static RequestSpecification reqSpec;

    public RequestSpecification getRequestSpecification() throws FileNotFoundException {
        if(reqSpec == null){
            PrintStream log = new PrintStream(new FileOutputStream("logs.txt"));
            reqSpec = new RequestSpecBuilder().setBaseUri(Constants.baseUrlQa)
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return reqSpec;
        }
        return reqSpec;
    }

    public String getJsonPath(Response response, String key){
        String stringResponse = response.asString();
        JsonPath jsonPath = new JsonPath(stringResponse);
        return jsonPath.getString(key);
    }

    public String getResponseAsString(Response response){
        String stringResponse = response.asString();
        return stringResponse;
    }
}
