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

public class GetListResourceDef {

    @Steps
    ReqresAPI reqresAPI;

//    SCENARIO 1
    @Given("Get list users with unknown parameter")
    public void getListUsersWithUnknownParameter() {
        reqresAPI.getListResource();
    }

    @When("Send request get list unknown")
    public void sendRequestGetListUnknown() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_RESOURCE);
    }

    @And("Validate get list resource json schema")
    public void validateGetListResourceJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "ListResourceJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}

