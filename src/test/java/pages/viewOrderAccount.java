package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class viewOrderAccount {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(css = "a[title='Orders']")
    WebElement orderHistory_otherBtn;
    @FindBy(css = "a[class='color-myaccount']")
    WebElement orderHistory;
    @FindBy(css = "a[class='color-myaccount']")
    WebElement viewDetailsOrder;
    @FindBy(xpath = "//span[contains(text(),'Home')]")
    WebElement backToHomeBtn;
    @FindBy(css = "a[title='Addresses']")
    WebElement addressBtn;
    @FindBy(css = "a[title='Update']")
    WebElement updateAdressBtn;
    @FindBy(id = "other")
    WebElement addInformation;
    @FindBy(id = "submitAddress")
    WebElement submitAdressBtn;
    @FindBy(xpath = "//div[@class='columns-container']//li[1]//a[1]")
    WebElement backToAccountBtn;


    public viewOrderAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void viewDetailsOrder() throws IOException {
        orderHistory_otherBtn.click();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='color-myaccount']")));
        String orderHistoryText = orderHistory.getText();
        System.out.println(orderHistoryText);
        TakesScreenshot screenShot1 = ((TakesScreenshot) driver);
        File screenFile1 = screenShot1.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenFile1, new File(("C:\\Users\\Gabriel\\Desktop\\ssOrderDetails.jpg")));
        viewDetailsOrder.click();
        backToAccountBtn.click();
    }

    public void modifyAdressOfOrders(String updatedInformation) {
        addressBtn.click();
        updateAdressBtn.click();
        addInformation.sendKeys(updatedInformation);
        submitAdressBtn.click();
        backToAccountBtn.click();
    }


}
