package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.concurrent.TimeUnit;

/**
 * The type Base test.
 */
@Listeners(TestListener.class)
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
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");
//        driver = new ChromeDriver(options);//инициализируем объект вебдрайвера
//        if (System.getProperty("browser").equals("chrome")) {
//            driver = new ChromeDriver();//инициализируем объект вебдрайвера
//        } else if(System.getProperty("browser").equals("firefox")) {
//            driver = new FirefoxDriver();//инициализируем объект вебдрайвера
//        }
        driver = new ChromeDriver();//инициализируем объект вебдрайвера
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        initPages();
        PageFactory.initElements(driver, this);
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
