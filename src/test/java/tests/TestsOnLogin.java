package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginToAutomationAccount;

public class TestsOnLogin {
    WebDriver driver;

    @FindBy(css = "a[class='login'][rel='nofollow']")
    WebElement signInButton;

    public TestsOnLogin(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    LoginToAutomationAccount account;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gabriel\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void test_HomePageLogin() {
        //Locate Sign-In button and press it to start the adventure
        signInButton.click();
        //completion for object -account-
        account = new LoginToAutomationAccount(driver);
        //login to website account
        account.loginAutomationPage("gabriel.noki9@gmail.com", "capptain3");
        //verify if it is logged in
        String textConfirmation = account.getConfirmationLogin();
        Assert.assertTrue(textConfirmation.contains("My account"));

    }

    @AfterTest
    public void downPage(){
        driver.quit();
    }


}
