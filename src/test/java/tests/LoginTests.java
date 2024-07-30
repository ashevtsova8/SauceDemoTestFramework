package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest implements ITestConstants {
    private static final String EMPTY_USERNAME_ERROR_TEXT = "Epic sadface: Username is required";
    private static final String EMPTY_PASSWORD_ERROR_TEXT = "Epic sadface: Password is required";
    private static final String INCORRECT_DATA_ERROR_TEXT = "Epic sadface: Username and password do not match any user in this service";

    @Test
    public void loginWithEmptyFieldsTest() {
        loginPage.openPage();
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_USERNAME_ERROR_TEXT);
    }

    @Test
    public void loginWithEmptyUsernameTest() {
        loginPage.openPage();
        loginPage.login("", PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_USERNAME_ERROR_TEXT);
    }

    @Test
    public void loginWithEmptyPasswordTest() {
        loginPage.openPage();
        loginPage.login(USERNAME, "");
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_PASSWORD_ERROR_TEXT);
    }

    @Test
    public void loginWithIncorrectDataTest() {
        loginPage.openPage();
        loginPage.login("evnev", "evev");
        Assert.assertEquals(loginPage.getErrorMessageText(), INCORRECT_DATA_ERROR_TEXT);
    }

    @Test
    public void loginCorrectDataTest() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertEquals(productsPage.getProductText(), "Products");
    }
}
