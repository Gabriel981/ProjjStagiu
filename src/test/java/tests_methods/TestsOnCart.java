package tests_methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.buyProcess;

public class TestsOnCart {
    WebDriver driver;
    buyProcess homePage;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gabriel\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test(groups = "products",priority = 1)
    public void cartAddProduct(){
        //object to initialise driver(Automation)
        homePage = new buyProcess(driver);
        homePage.navigateWomen();
        homePage.navigateCasual();
        homePage.containsText();
        homePage.performABuy();
    }

    @Test(groups = "products", priority = 2)
    public void performModificationsToCart(){
        homePage.performAModificationInCommand();
        System.out.println("Modifications was successfully registered!");
    }

    @Test(groups = "products", priority = 3)
    public void performZcartDeleteProduct(){
        homePage.deleteFromCart();
        System.out.println("The delete of product was fully completed!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
