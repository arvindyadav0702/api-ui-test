package pages.ui;

import com.microsoft.playwright.*;

public class HomePage {
    private Page page;
    private Locator searchField;
    private Locator searchButton;
    private Locator firstItemLink;

    public HomePage(Page page) {
        this.page = page;
        this.searchField = page.locator("[aria-label='Search for anything']");
        this.searchButton = page.locator("#gh-btn");
        this.firstItemLink = page.locator("#srp-river-main a").nth(13);

    }
    public void searchForItem(String item) {
        searchField.fill(item);
        searchButton.click();
        page.waitForLoadState();
    }

    public String getURL() {
        return firstItemLink.getAttribute("href");
    }
}
