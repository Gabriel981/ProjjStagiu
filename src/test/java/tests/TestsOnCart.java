package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.buyProcess;

public class TestsOnCart {
    WebDriver driver;
    buyProcess homePage;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gabriel\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void cartAddProduct(){
        //object to initialise driver(Automation)
        homePage = new buyProcess(driver);
        homePage.navigateWomen();
        homePage.navigateCasual();
        homePage.containsText();
        homePage.performABuy();
    }

    @Test
    public void performModificationsToCart(){
        homePage.performAModificationInCommand();
        System.out.println("Modifications was successfully registered!");
    }

    @Test
    public void performZcartDeleteProduct(){
        homePage.deleteFromCart();
        System.out.println("The delete of product was fully completed!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
