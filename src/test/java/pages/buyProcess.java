package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class buyProcess {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(css = "a[class=\'sf-with-ul\'][title=\'Women\']")
    WebElement navigateToWomen;
    @FindBy(xpath = "//ul[@class='submenu-container clearfix first-in-line-xs']//ul//li//a[contains(text(),'Casual Dresses')]")
    WebElement navigateToCasual;
    @FindBy(css = "span[class='cat-name']")
    WebElement containsDress;
    @FindBy(css = "a[class='product-name'][title='Printed Dress']")
    WebElement clickOnDress;
    @FindBy(css = "button[type='submit'][class='exclusive']")
    WebElement clickOnCart;
    @FindBy(css="a[title='My Store']")
    WebElement homePage;
    @FindBy(css = "a[title='View my shopping cart']")
    WebElement shopCartView;
    @FindBy(css = "a[class='ajax_cart_block_remove_link']")
    WebElement deteleFromCartElement;
    @FindBy(xpath = "//i[@class='icon-plus']")
    WebElement addBtn;
    @FindBy(xpath = "//i[@class='icon-minus']")
    WebElement minusBtn;

    public buyProcess(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateWomen() {
        Actions actions = new Actions(driver);
        actions.moveToElement(navigateToWomen).build().perform();
    }

    public void navigateCasual() {
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='submenu-container clearfix first-in-line-xs']//ul//li//a[contains(text(),'Casual Dresses')]")));
        navigateToCasual.click();
        System.out.println("Operation 1 was performed correctly!");
    }

    public void containsText() {
        String webPageText = containsDress.getText();
        String expected = "CASUAL DRESSES";
        if (webPageText.contains(expected)) {
            Actions action1 = new Actions(driver);
            action1.doubleClick(clickOnDress).build().perform();

        } else {
            System.out.println("It's not okey for now!");
        }
    }

    public void performABuy() {
        if (clickOnCart.isEnabled()) {
            Actions buyThisProduct = new Actions(driver);
            buyThisProduct.doubleClick(clickOnCart).build().perform();
            wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2[1]")));
            buyThisProduct.doubleClick(driver.findElement(By.cssSelector("span[class='continue btn btn-default button exclusive-medium']"))).build().perform();
            homePage.click();
        } else {
            System.out.println("We are sorry, but this button is inactive!");
        }
    }

    public void performAModificationInCommand(){
        shopCartView.click();
        wait=new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon-minus']")));
        for(int i=0; i<=3;i++){
            addBtn.click();
        }
        minusBtn.click();
        homePage.click();
    }

    public void deleteFromCart(){
        Actions moveToCartAgain = new Actions(driver);
        moveToCartAgain.moveToElement(shopCartView).build().perform();
        wait=new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='ajax_cart_block_remove_link']")));
        deteleFromCartElement.click();
    }


}
