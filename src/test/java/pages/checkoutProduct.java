package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class checkoutProduct {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(css = "a[class='sf-with-ul'][title='Women']")
    WebElement womenElement;
    @FindBy(xpath = "//li[@class='sfHover']//ul[@class='submenu-container clearfix first-in-line-xs']//li//a[contains(text(),'Casual Dresses')]")
    WebElement casualDressesElement;
    @FindBy(css = "a[class='product-name'][title='Printed Dress']")
    WebElement printedDressElement;
    @FindBy(id = "short_description_content")
    WebElement shortDescriptionProduct;
    @FindBy(className = "icon-plus")
    WebElement addElement;
    @FindBy(id = "uniform-group_1")
    WebElement dropDownSelect;
    @FindBy(id = "group_1")
    WebElement dropDownElement;
    @FindBy(css = "button[name='Submit'][class='exclusive']")
    WebElement addToCartElement;
    @FindBy(css = "a[class=\'btn btn-default button button-medium\'][title=\'Proceed to checkout\']")
    WebElement verificationForCheckout;
    @FindBy(css = "a[class='button btn btn-default standard-checkout button-medium'][title='Proceed to checkout']")
    WebElement proceedToCheckout;
    @FindBy(id = "email")
    WebElement emailCompletion;
    @FindBy(id = "passwd")
    WebElement passwordCompletion;
    @FindBy(id = "SubmitLogin")
    WebElement signInButton;
    @FindBy(id = "address_delivery")
    WebElement addressInformations;
    @FindBy(css = "button[class='button btn btn-default button-medium'][name='processAddress']")
    WebElement submitButton;
    @FindBy(id = "uniform-cgv")
    WebElement checkBoxCourier;
    @FindBy(css = "button[class='button btn btn-default standard-checkout button-medium'][name='processCarrier']")
    WebElement processCarrier;
    @FindBy(css = "a[title='Pay by check.']")
    WebElement payByCheck;


    public checkoutProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToCasualDresses() {
        Actions navigateToCasual = new Actions(driver);
        navigateToCasual.moveToElement(womenElement).build().perform();
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Casual Dresses']")));
        navigateToCasual.doubleClick(casualDressesElement).build().perform();
        System.out.println("First sub-test is done!");
    }

    public void navigateToProductPage() {
        Actions clickOnProduct = new Actions(driver);
        clickOnProduct.doubleClick(printedDressElement).build().perform();
        if (shortDescriptionProduct.isDisplayed()) {
            System.out.println(shortDescriptionProduct.getText());
            for (int i = 1; i <=3; i++) {
                addElement.click();
                addElement.getSize();
            }
            dropDownSelect.click();
            dropDownElement.click();
        } else {
            System.out.println("We are sorry but we can't do anything for now!");
        }
    }

    public void addToCart() throws IOException, InterruptedException {
        Actions addToCart = new Actions(driver);
        addToCart.doubleClick(addToCartElement).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class=\'btn btn-default button button-medium\'][title=\'Proceed to checkout\']")));
        if (verificationForCheckout.isDisplayed()) {
            System.out.println(verificationForCheckout.getText());
            TakesScreenshot screenShot = ((TakesScreenshot) driver);
            File screenFile = screenShot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenFile, new File("C:\\Users\\Gabriel\\Desktop\\ss.jpg"));
            verificationForCheckout.click();
        }

    }

    public void doCheckout(String email, String password) throws IOException {
        proceedToCheckout.click();
        emailCompletion.sendKeys(email);
        passwordCompletion.sendKeys(password);
        signInButton.click();
        System.out.println(addressInformations.getText());
        TakesScreenshot screenShot2 = ((TakesScreenshot) driver);
        File screenFile2 = screenShot2.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenFile2, new File("C:\\Users\\Gabriel\\Desktop\\ss2.jpg"));
        submitButton.click();
        checkBoxCourier.click();
        processCarrier.click();
        payByCheck.click();
    }
}
