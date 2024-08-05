package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static tests.ITestConstants.*;

public class CartTests extends BaseTest {
    //1) добавить товар в корзину и проверить, что у него отображается верная цена
    //2) удалить товар из корзины и проверить, что он удалился
    //3) добавть 2 товара в корзину и проверить, что количество добавленных товаров = 2

    @DataProvider(name = "products")
    public Object[] products () {
        return new Object[] {
                SAUCE_LABS_BACKPACK,
                SAUCE_LABS_BIKE_LIGHT,
                SAUCE_LABS_BOLT_T_SHIRT,
                SAUCE_LABS_FLEECE_JACKET,
                SAUCE_LABS_ONESIE,
                T_SHIRT_RED
        };
    }

    @Test(alwaysRun = true)
    public void addProductToCartTest() {
        loginPage
                .openPage()
                .waitForPageOpened()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK);
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_BACKPACK), "$29.99");
    }

    @Test
    public void removeOneOfProductsFromCartTest() {
        loginPage
                .openPage()
                .waitForPageOpened()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK)
                .addProductToCart(SAUCE_LABS_FLEECE_JACKET);
        cartPage
                .openPage()
                .removeProductFromCart(SAUCE_LABS_BACKPACK);
        Assert.assertEquals(cartPage.getProductsCount(), 1);
    }

    @Test(dataProvider = "products")
    public void removeProductFromCartTest(String productName) {
        loginPage
                .openPage()
                .waitForPageOpened()
                .login(USERNAME, PASSWORD)
                .addProductToCart(productName);
        cartPage
                .openPage()
                .removeProductFromCart(productName);
        Assert.assertFalse(cartPage.isProductDisplayed(productName));
    }

    @Test
    public void addTwoProductsToCartAndCheckCountTest() {
        loginPage
                .openPage()
                .waitForPageOpened()
                .login(USERNAME, PASSWORD)
                .addProductToCart(SAUCE_LABS_BACKPACK)
                .addProductToCart(SAUCE_LABS_FLEECE_JACKET);
        cartPage
                .openPage();
        Assert.assertEquals(cartPage.getProductsCount(), 2);
    }
}