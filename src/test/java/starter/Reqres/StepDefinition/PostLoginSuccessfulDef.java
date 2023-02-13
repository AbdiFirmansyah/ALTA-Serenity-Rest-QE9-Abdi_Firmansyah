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

public class PostLoginSuccessfulDef {


    @Steps
    ReqresAPI reqresAPI;


//   SCENARIO 1
    @Given("User login with valid username and password")
    public void userLoginWithValidUsernameAndPassword() {
        File json = new File(Constant.JSON_REQ_BODY+"LoginReqBody.json");
        reqresAPI.postValidLogin(json);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when()
                    .post(ReqresAPI.POST_LOGIN_SUCCESSFUL);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int OK) {
        SerenityRest.then().statusCode(OK);

    }

    @And("Validate json schema successes login user")
    public void validateJsonSchemaSuccessesLoginUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"LoginUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

//    SCENARIO 2
    @Given("Send login with empty password")
    public void sendLoginWithEmptyPassword() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"EmptyPasswordLogin.json");
        reqresAPI.postInvalidLogin(jsonReq);
    }
    @When("Send request post login")
    public void sendRequestPostLogin() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_SUCCESSFUL);

    }
    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int status) {
        SerenityRest.then().statusCode(status);
    }

    @And("Responses body status should be {string}")
    public void responsesBodyStatusShouldBe(String status) {
    SerenityRest.then().body(ReqresResponses.ERROR,equalTo(status));
    }

    @And("Validate empty password json schema")
    public void validateEmptyPasswordJsonSchema() {
    File jsonSchema = new File(Constant.JSON_SCHEMA+"InvalidLoginUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

}

