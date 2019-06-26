package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.searchBar;


public class TestsOnSearchBar {
    WebDriver driver;
    searchBar search;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gabriel\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void searchBarTest(){
        search=new searchBar(driver);
        search.searchBarSar();
        search.searchButton();
        search.countElements();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
