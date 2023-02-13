package starter.Reqres.StepDefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Utils.Constant;

import java.io.File;

public class PostCreateUserDef {


    @Steps
    ReqresAPI reqresAPI;

//    SCENARIO 1
    @Given("Create new user with valid json")
    public void createNewUserWithValidJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"CreateReqBody.json");
        reqresAPI.postCreateUser(jsonReq);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Validate new user json schema")
    public void validateNewUserJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"CreateUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
//    SCENARIO 2
    @Given("Create new user with invalid data")
    public void createNewUserWithInvalidData() {
        File json = new File(Constant.JSON_REQ_BODY+"CreateReqBody.json");
        reqresAPI.postInvalidCreateUser(json);
    }

}


