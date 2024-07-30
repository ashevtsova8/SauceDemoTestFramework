package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTests extends BaseTest implements ITestConstants {

    @Test
    public void isAddToCartButtonDisplayedTest() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayed(SAUCE_LABS_BACKPACK));
    }

    @Test
    public void isRemoveButtonDisplayedTest() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductToCart(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BACKPACK));
    }
}
