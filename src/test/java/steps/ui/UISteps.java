package steps.ui;

import com.microsoft.playwright.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.ui.HomePage;
import pages.ui.ItemListingPage;

import java.util.logging.Logger;


public class UISteps {
    private Browser browser;
    private Page page;
    private Page page2;
    BrowserContext context;
    private HomePage homePage;
    private ItemListingPage itemListingPage;


    @Given("I open the browser and navigate to eBay")
    public void i_open_the_browser_and_navigate_to_ebay() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://www.ebay.com");
        homePage = new HomePage(page);
    }

    @When("I search for {string}")
    public void i_search_for(String searchItem) {
        homePage.searchForItem(searchItem);
    }

    @When("I click on the first book in the list")
    public void i_click_on_the_first_book_in_the_list() {
        String urlToNavigate = homePage.getURL();
        page.waitForLoadState();
        page2 = context.newPage();
        page2.navigate(urlToNavigate);

    }

    @When("I click on {string}")
    public void i_click_on(String buttonText) {
        if (buttonText.contains("Add to cart")) {
            page2.waitForSelector("#atcBtn_btn_1");
            page2.click("#atcBtn_btn_1");

        }
    }

    @Then("I should see that the cart contains one item")
    public void i_should_see_that_the_cart_contains_one_item() throws InterruptedException {
        Thread.sleep(3000);
        page2.waitForSelector("#gh-cart-n");
        String cartItemCount = page2.innerText("#gh-cart-n");

        // Verify that the cart contains 1 item
        if (cartItemCount.equals("1")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
        browser.close();
    }


}
