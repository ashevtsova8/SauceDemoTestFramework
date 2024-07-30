package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.concurrent.TimeUnit;

/**
 * The type Base test.
 */
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;

    /**
     * Init test.
     */
    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();//скачиваем хромдрайвер и сетаем его в системные
        // настройки
        driver = new ChromeDriver();//инициализируем объект вебдрайвера
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        initPages();
    }

    /**
     * Init pages.
     */
    public void initPages() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    /**
     * End test.
     */
    @AfterMethod(alwaysRun = true)
    public void endTest() {
        driver.quit();
    }
}
