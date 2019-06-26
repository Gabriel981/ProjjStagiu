package tests_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.loginToAccount;
import pages.signUp;

public class TestsOnRegister_Login {
    WebDriver driver;
    signUp signUpclass;
    loginToAccount account;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gabriel\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void testOnSignUpFunctionality(){
        signUpclass = new signUp(driver);
        signUpclass.initializationSignInBtn("testng13@test.nn","Georgica","Mirel","mirelgeorgel","Str.Florilor","Iasi","Romania","30032","0575757755");
        System.out.println("Test complete! - For Register");
    }

    @Test
    public void test_HomePageLogin() {
        //Locate Sign-In button and press it to start the adventure
        driver.findElement(By.cssSelector("a[class='login'][rel='nofollow']")).click();
        //completion for object -account-
        account = new loginToAccount(driver);
        //login to website account
        account.loginAutomationPage("gabriel.noki9@gmail.com", "capptain3");
        //verify if it is logged in
        String textConfirmation = account.getConfirmationLogin();
        Assert.assertTrue(textConfirmation.contains("My account"));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
