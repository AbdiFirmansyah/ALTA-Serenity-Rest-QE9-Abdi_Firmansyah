package starter.Reqres.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;
import starter.Utils.Constant;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;


public class GetSingleUserDef {

    @Steps
    ReqresAPI reqresAPI;


//    SCENARIO 1
    @Given("Get single users with valid parameter id {int}")
    public void getSingleUsersWithValidParameterId(int id) {
        reqresAPI.getSingleUser(id);

    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }

    @And("Response body page should be {string}")
    public void responseBodyPageShouldBeAndFirstName(String email) {
        SerenityRest.then().body(ReqresResponses.DATA_EMAIL,equalTo(email));

    }

    @And("Get single users json schema validator")
    public void getSingleUsersJsonSchemaValidator() {
        File jsonReq = new File(Constant.JSON_SCHEMA + "SingleUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonReq));

    }
//    SCENARIO 2
    @Given("Get single users with invalid parameter id {int}")
    public void getSingleUsersWithInvalidParameterIdId(int id) {
        reqresAPI.getSingleUser(id);

    }
}




