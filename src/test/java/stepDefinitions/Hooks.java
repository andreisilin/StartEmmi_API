package stepDefinitions;

import io.cucumber.java.Before;
import java.io.FileNotFoundException;

public class Hooks {

    @Before("@PickerPage")
    public void beforeScenario() throws FileNotFoundException {
        StepDefinitions stepDefinitions = new StepDefinitions();
        stepDefinitions.login_api_payload_with_and("10590510151", "01/01/2020");
        stepDefinitions.request_is_sent_with_resource("POST", "loginToken");
        stepDefinitions.is_generated_with_status_code(200);
    }
}
