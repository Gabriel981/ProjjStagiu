package tests_methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.checkoutProduct;

import java.io.IOException;

public class TestOnCheckout {
    WebDriver driver;
    checkoutProduct checkout;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gabriel\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void checkoutTest() throws IOException, InterruptedException {
        checkout = new checkoutProduct(driver);
        checkout.navigateToCasualDresses();
        checkout.navigateToProductPage();
        checkout.addToCart();
        checkout.doCheckout("gabriel.noki9@gmail.com", "captain3");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
