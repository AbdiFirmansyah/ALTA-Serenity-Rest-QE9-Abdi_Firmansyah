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

import static org.hamcrest.Matchers.equalTo;

public class PostRegisterUserDef {

    @Steps
    ReqresAPI reqresAPI;

//    SCENARIO 1
    @Given("Register user with valid json")
    public void registerUserWithValidJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"RegisterReqBody.json");
        reqresAPI.postRegisterUser(jsonReq);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_SUCCESSFUL);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOk(int ok) {
        SerenityRest.then().statusCode(ok);

    }

    @And("Response body id should be {int} and token is {string}")
    public void responseBodyIdShouldBeEmailAndTokenIsToken(int id, String token) {
        SerenityRest.then().body("id",equalTo(id)).body("token",equalTo(token));

    }

    @And("Validate register user json schema")
    public void validateRegisterUserJsonSchema() {
        File jsonSchemaRegisterUser = new File(Constant.JSON_SCHEMA+"RegisterJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaRegisterUser));

    }

//    SCENARIO 2
    @Given("Register user with invalid json")
    public void registerUserWithInvalidJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"RegisterInvalidReqBody.json");
        reqresAPI.postRegisterUser(jsonReq);
    }

    @And("Validate json schema failed register user")
    public void validateJsonSchemaFailedRegisterUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"RegisterInvalidJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

    }
}

