package starter.Reqres.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;

public class DeleteUserDef {


    @Steps
    ReqresAPI reqresAPI;

    // SCENARIO 1
    @Given("Delete user with invalid id {int}")
    public void deleteUserWithInvalidId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No content")
    public void statusCodeShouldBeNoContent(int NoContent) {
        SerenityRest.then().statusCode(NoContent);
    }
//  SCENARIO 2
    @Given("Delete user with invalid id {string}")
    public void deleteUserWithInvalid(String id) {
        reqresAPI.deleteInvalidUser(id);
    }

    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidIdId(int id) {
        reqresAPI.deleteUser(id);
    }
}
