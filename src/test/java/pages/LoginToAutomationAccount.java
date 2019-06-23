package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToAutomationAccount {
    WebDriver driver;
    @FindBy(id = "email")
    WebElement autoUserName;
    @FindBy(id = "passwd")
    WebElement autoPassword;
    @FindBy(css = "span.navigation_page")
    WebElement loginConfirmation;
    @FindBy(id = "SubmitLogin")
    WebElement autoLogin;

    public LoginToAutomationAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String userName) {
        autoUserName.sendKeys("gabriel.noki9@gmail.com");
    }

    public void setPassword(String password) {
        autoPassword.sendKeys("captain3");
    }

    public void loginToPage() {
        autoLogin.click();
    }

    public String getConfirmationLogin() {
        return loginConfirmation.getText();
    }

    public void loginAutomationPage(String userName, String password) {
        this.setUserName(userName);
        this.setPassword(password);
        this.loginToPage();
    }


}
