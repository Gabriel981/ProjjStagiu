package phptravels_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import phptravels_pages.homePageLanguageCurrency;

public class test_On_littleFunctionalities {
    WebDriver driver;
    homePageLanguageCurrency languageCurrency;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gabriel\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.phptravels.net/");
    }

    @Test
    public void testOnCurrencyAndLanguage(){
        languageCurrency = new homePageLanguageCurrency(driver);
        languageCurrency.verifyCurrency();
        languageCurrency.verifyLanguage();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
