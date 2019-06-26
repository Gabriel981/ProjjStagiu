package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class signUp {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(css = "a[class='login']")
    WebElement loginBtn;
    @FindBy(css = "h1[class='page-heading']")
    WebElement verificationText;
    @FindBy(id = "email_create")
    WebElement createAccountEmail;
    @FindBy(id = "SubmitCreate")
    WebElement submitBtn;
    @FindBy(xpath = "//h3[contains(text(),'Your personal information')]")
    WebElement confirmationRegisterText;
    @FindBy(xpath = "//input[@id='id_gender1']")
    WebElement genderRadioBtn;
    @FindBy(id = "customer_firstname")
    WebElement customerFirstName;
    @FindBy(id = "customer_lastname")
    WebElement customerLastName;
    @FindBy(id = "email")
    WebElement emailTextBox;
    @FindBy(id = "passwd")
    WebElement passTextBox;
    @FindBy(id = "days")
    WebElement dayDropDownBtn;
    @FindBy(xpath = "//div[@id='uniform-days']//option[2]")
    WebElement daySelect;
    @FindBy(id = "months")
    WebElement monthDropDownBtn;
    @FindBy(xpath = "//option[contains(text(),'July')]")
    WebElement monthSelect;
    @FindBy(id = "years")
    WebElement yearsDropDownBtn;
    @FindBy(xpath = "//option[contains(text(),'1985')]")
    WebElement yearSelect;
    @FindBy(id = "firstname")
    WebElement firstName;
    @FindBy(id = "lastname")
    WebElement lastName;
    @FindBy(id = "address1")
    WebElement address;
    @FindBy(id = "city")
    WebElement city;
    @FindBy(id = "id_state")
    WebElement state;
    @FindBy(id = "postcode")
    WebElement statePostalCode;
    @FindBy(id = "phone_mobile")
    WebElement mobilePhoneNumber;
    @FindBy(id = "submitAccount")
    WebElement submitAccount;

    public signUp(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void initializationSignInBtn(String accountEmail, String custFirstName, String custLastName,String pass, String addressCompletion, String cityCompletion, String stateCompletion,String stateCode,String mobilePhoneNn){
        loginBtn.click();
        String verifText = verificationText.getText();
        String expected = "Create an account";

            createAccountEmail.sendKeys(accountEmail);
            submitBtn.click();

//        String registerConfirmText = confirmationRegisterText.getText();
//        String expectedText = "Create an account";
//        if(registerConfirmText.equals(expectedText)){

            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='id_gender1']")));
            genderRadioBtn.click();
            customerFirstName.sendKeys(custFirstName);
            customerLastName.sendKeys(custLastName);
            //emailTextBox.sendKeys(accountEmail);
            passTextBox.sendKeys(pass);
            dayDropDownBtn.click();
            daySelect.click();
            monthDropDownBtn.click();
            monthSelect.click();
            yearsDropDownBtn.click();
            yearSelect.click();
            firstName.sendKeys(custFirstName);
            lastName.sendKeys(custLastName);
            address.sendKeys(addressCompletion);
            city.sendKeys(cityCompletion);
            state.sendKeys(stateCompletion);
            statePostalCode.sendKeys(stateCode);
            mobilePhoneNumber.sendKeys(mobilePhoneNn);
            submitAccount.click();
            WebElement signOutNow = driver.findElement(By.cssSelector("a[class='logout']"));
            signOutNow.click();

        }
    }


