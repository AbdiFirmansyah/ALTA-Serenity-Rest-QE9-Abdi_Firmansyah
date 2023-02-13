package starter.Reqres.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Utils.Constant;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;


public class GetListUserDef {

    @Steps
    ReqresAPI reqresAPI;


//    SCENARIO 1
    @Given("Get list users with valid parameter page {int}")
    public void getListUsersWithValidParameterPagePage(int page) {
        reqresAPI.getListUser(page);

    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USER);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBePage(int page) {
        SerenityRest.then().body("page", equalTo(page));
    }

    @And("Validate get list user json schema")
    public void validateGetListUserJsonSchema() {
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA+"ListUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));

    }
//     SCENARIO 2
    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USER);

    }
    @Given("Get list parameter with invalid page {string}")
    public void getListParameterWithInvalidPage(String page) {
        reqresAPI.getInvalidListUser(page);
    }
}

