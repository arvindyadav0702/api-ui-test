package steps.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pages.api.CoinDeskPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class APISteps {

    private final CoinDeskPage coinDeskPage = new CoinDeskPage();
    private Response response;

    @Given("I send a GET request to the CoinDesk API")
    public void iSendAGETRequestToTheCoinDeskAPI() {
        response = coinDeskPage.sendGetRequest();
    }

    @Then("the response should contain USD, GBP, and EUR")
    public void theResponseShouldContainUSDGBPAndEUR() {
        assertThat(response.jsonPath().getString("bpi.USD"), notNullValue());
        assertThat(response.jsonPath().getString("bpi.GBP"), notNullValue());
        assertThat(response.jsonPath().getString("bpi.EUR"), notNullValue());
    }

    @Then("the GBP description should equal {string}")
    public void theGBPDescriptionShouldEqual(String expectedDescription) {

        String actualDescription = response.jsonPath().getString("bpi.GBP.description");
        assertThat(actualDescription, equalTo(expectedDescription));
    }

}
