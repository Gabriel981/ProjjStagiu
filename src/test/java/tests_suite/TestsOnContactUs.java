package tests_suite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.contactPage;

public class TestsOnContactUs {
    WebDriver driver;
    contactPage contact;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gabriel\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void contactUs(){
        contact=new contactPage(driver);
        contact.clickOnContactUs();
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }


}
