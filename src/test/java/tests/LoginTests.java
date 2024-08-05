package tests;

import listeners.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest implements ITestConstants {
    private static final String EMPTY_USERNAME_ERROR_TEXT = "Epic sadface: Username is required";
    private static final String EMPTY_USERNAME_ERROR_TEXT_ERROR = "Epic sadface: Username is " +
            "required";
    private static final String EMPTY_PASSWORD_ERROR_TEXT = "Epic sadface: Password is required";
    private static final String INCORRECT_DATA_ERROR_TEXT = "Epic sadface: Username and password do not match any user in this service";

    @Test()
    public void loginWithEmptyFieldsTest() {
        loginPage
                .openPage()
                .waitForPageOpened()
                .login("", "");
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_USERNAME_ERROR_TEXT);
    }

    @Test(retryAnalyzer = Retry.class)
    public void loginWithEmptyFieldsTestWithError() {
        loginPage
                .openPage()
                .waitForPageOpened()
                .login("", "");
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_USERNAME_ERROR_TEXT_ERROR);
    }

    @Test
    public void loginWithEmptyUsernameTest() {
        loginPage
                .openPage()
                .waitForPageOpened()
                .login("", PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_USERNAME_ERROR_TEXT);
    }

    @Test
    public void loginWithEmptyPasswordTest() {
        loginPage
                .openPage()
                .waitForPageOpened()
                .login(USERNAME, "");
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_PASSWORD_ERROR_TEXT);
    }

    @Test
    public void loginWithIncorrectDataTest() {
        loginPage
                .openPage()
                .waitForPageOpened()
                .login("evnev", "evev");
        Assert.assertEquals(loginPage.getErrorMessageText(), INCORRECT_DATA_ERROR_TEXT);
    }

    @Test()
    public void loginCorrectDataTest() {
        loginPage
                .openPage()
                .waitForPageOpened()
                .login(USERNAME, PASSWORD);
        Assert.assertEquals(productsPage.getProductText(), "Products");
    }

    //отличие обычного использования локаторов и PageFactory
//    @FindBy(xpath = "//*[contains(text(),'Add ')]")
//    WebElement addButton;
//
//    @FindBy(xpath = "//button[contains(text(),'Delete')]")
//    WebElement deleteButton;
//
//    @Test
//    public void addWithoutPageFactory() {
//        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
//        WebElement addButton = driver.findElement(By.xpath("//*[contains(text(),'Add ')]"));
//        addButton.click();
//        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
//        deleteButton.click();
//        addButton.click();
//        deleteButton.click();
//    }
//
//    @Test
//    public void addWithPageFactory() {
//        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
//        WebElement addButtonPageFactory = addButton;
//        addButtonPageFactory.click();
//        WebElement deleteButtonPageFactory = deleteButton;
//        deleteButtonPageFactory.click();
//        addButtonPageFactory.click();
//        deleteButtonPageFactory.click();
//    }
}
