package pages.ui;

import com.microsoft.playwright.*;

public class ItemListingPage {
    private final Page page;
    private final Locator addToCartButton;
    private final Locator cartItemCounter;

    public ItemListingPage(Page page) {
        this.page = page;
        this.addToCartButton = page.locator("#atcBtn_btn_1");
        this.cartItemCounter = page.locator("#gh-cart-n");
    }


}
