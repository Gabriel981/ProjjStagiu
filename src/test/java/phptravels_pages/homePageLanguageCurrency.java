package phptravels_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePageLanguageCurrency {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//li[@class='dropdown']//a[@class='dropdown-toggle go-text-right']")
    WebElement currencyBtn;
    @FindBy(xpath = "/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[2]/ul[1]/li[2]/ul[1]/li[4]/a[1]")
    WebElement eurCurrency;
    @FindBy(xpath = "//div[@class='vc_row wpb_row vc_inner vc_row-fluid vc_column-gap-30 RTL']//div[2]//div[1]//div[1]//div[1]//div[1]//div[3]//div[1]//span[1]")
    WebElement verificationCurrency;
    @FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//ul[@class='nav navbar-nav']//li[@class='dropdown']")
    WebElement languageBtn;
    @FindBy(xpath = "//li[@class='dropdown open']//ul[@class='dropdown-menu wow fadeIn animated']//li//a[@id='es']")
    WebElement spanishBtn;
    @FindBy(css = "div[class='title']")
    WebElement verificationLanguage;

    public homePageLanguageCurrency(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyCurrency(){
        currencyBtn.click();
        wait=new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left user_menu']//li[@class='dropdown']//ul[@class='dropdown-menu wow fadeIn animated']//li//a[@class='go-text-right'][contains(text(),'EUR')]")));
        eurCurrency.click();
        String currencyVerif = verificationCurrency.getText();
        String expectedVerif = "EUR 88";
        if(currencyVerif==expectedVerif)
            System.out.println("It's passed the test!");
        else
            System.out.println("It's not passed the test!");
    }

    public void verifyLanguage(){
        languageBtn.click();
        wait=new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='dropdown open']//ul[@class='dropdown-menu wow fadeIn animated']//li//a[@id='es']")));
        spanishBtn.click();
        String languageVerif = verificationLanguage.getText();
        String expected = " Featured Tours ";
        if(languageVerif==expected)
            System.out.println("It's passed the language test!");
        else
            System.out.println("It's not passed the language test!");
    }
}
