package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.DataBuilder;
import resources.Utils;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.junit.Assert.assertEquals;

public class StepDefinitions extends Utils {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;
    DataBuilder dataBuilder = new DataBuilder();
    APIResources apiResources;
    public static String loginToken;

    @Given("login API payload with {string} and {string}")
    public void login_api_payload_with_and(String accessCode, String dob) throws FileNotFoundException {
        requestSpecification = given().spec(getRequestSpecification())
                .body(dataBuilder.getLoginPayload(accessCode, dob));
    }

    @When("{string} request is sent with {string} resource")
    public void request_is_sent_with_resource(String httpMethod, String resource) {
        apiResources = APIResources.valueOf(resource);
        responseSpecification = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
        if (httpMethod.equalsIgnoreCase("POST")) {
            response = requestSpecification.when().post(apiResources.getResource());
        } else if (httpMethod.equalsIgnoreCase("GET")) {
            response = requestSpecification.when().get(apiResources.getResource());
        }

    }

    @Then("loginToken is generated with {int} statusCode")
    public void is_generated_with_status_code(int code) {
        assertEquals(code, response.getStatusCode());
        loginToken = getResponseAsString(response);
    }

    @Given("programsPicker API")
    public void programsPicker_API() throws FileNotFoundException {
        requestSpecification = given().spec(getRequestSpecification());
    }

    @Then("response is generated with {int} statusCode")
    public void response_Is_Generated_With_StatusCode(int code) {

    }

    @And("{string} is provided for viewGroup")
    public void isProvidedForViewGroup(String viewGroupId) {
        switch (viewGroupId) {
            case "1":
                apiResources.getResource().replace("{View_Grp_Cd}", "1");
                break;
            case "2":
                apiResources.getResource().replace("{View_Grp_Cd}", "2");
                break;
            case "3":
                apiResources.getResource().replace("{View_Grp_Cd}", "3");
                break;
            case "4":
                apiResources.getResource().replace("{View_Grp_Cd}", "4");
                break;
            default:
                System.out.println("View_Grp_Cd is not present");
        }
    }
}
