package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class contactPage {
    WebDriver driver;
    @FindBy(id="contact-link")
    WebElement contactUs;
    @FindBy(id = "id_contact")
    WebElement subjectHeading1;
    @FindBy(css = "option[value='2']")
    WebElement subjectHeadingOption1;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id="id_order")
    WebElement orderID;
    @FindBy(id="message")
    WebElement messageArea;
    @FindBy(id = "submitMessage")
    WebElement submitMessage;

    public contactPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnContactUs(){
        contactUs.click();
        if(driver.findElement(By.cssSelector("span[class='navigation_page']")).isDisplayed()){
            subjectHeading1.click();
            subjectHeadingOption1.click();
            email.sendKeys("test@gmail.com");
            orderID.sendKeys("30303");
            messageArea.sendKeys("assdsd");
            submitMessage.click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            System.out.println("Test successful");
        }
        else{
            System.out.println("It's not okey there!");
        }
    }
}
