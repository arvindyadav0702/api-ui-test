package pages.api;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CoinDeskPage {

    private static final String BASE_URL = "https://api.coindesk.com/v1/bpi/currentprice.json";

    public Response sendGetRequest() {
        RequestSpecification request = RestAssured.given();
        return request.get(BASE_URL);
    }
}
