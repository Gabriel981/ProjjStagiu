package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.loginToAccount;
import pages.viewOrderAccount;

import java.io.IOException;

public class TestsOnAccount_Functionalities {
    WebDriver driver;
    loginToAccount account;
    viewOrderAccount orderAccount;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gabriel\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void loginToAccount(){
        WebElement loginClick = driver.findElement(By.cssSelector("a[class='login'][rel='nofollow']"));
        loginClick.click();
        //completion for object -account-
        account = new loginToAccount(driver);
        //login to website account
        account.loginAutomationPage("gabriel.noki9@gmail.com", "capptain3");
        //verify if it is logged in
        String textConfirmation = account.getConfirmationLogin();
        Assert.assertTrue(textConfirmation.contains("My account"));
    }

    @Test
    public void testOrderHistoryFunctionality() throws IOException {
        orderAccount=new viewOrderAccount(driver);
        orderAccount.viewDetailsOrder();
    }

    @Test
    public void testAdressModificator(){
        orderAccount=new viewOrderAccount(driver);
        orderAccount.modifyAdressOfOrders("asd1");
        System.out.println("Test succesed in execution!");
    }

    @Test
    public void testzOnLogout(){
        WebElement logout = driver.findElement(By.cssSelector("a[class='logout']"));
        logout.click();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
