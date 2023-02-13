package starter.Reqres.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;
import starter.Utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PutUpdateUserDef {

    @Steps
    ReqresAPI reqresAPI;

//    SCENARIO 1
    @Given("Update user with valid json and parameter id {int}")
        public void updateUserWithValidJsonAndParameterId(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY + "UpdateReqBody.json");
        reqresAPI.putUpdateUser(id,jsonReq);
    }

    @When("send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }
    @And("Response body name should be {string} and job is {string}")
    public void responseBodyNameShouldBeAndJobIs(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }
    @And("Validate update user json schema")
    public void validateUpdateUserJsonSchema() {
        File jsonSchemaUpdateUser = new File(Constant.JSON_SCHEMA + "UpdateuserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaUpdateUser));
    }

}