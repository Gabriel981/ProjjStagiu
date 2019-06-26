package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class searchBar {
    WebDriver driver;
    @FindBy(css="input[class='search_query form-control ac_input']")
    WebElement searchBarLocation;
    @FindBy(css = "button[class=\'btn btn-default button-search\']")
    WebElement buttonSearch;
    @FindBy(className = "center_column col-xs-12 col-sm-9")
    WebElement numberOfElements;
    @FindBy(css= "a[title='My Store']")
    WebElement homePage;


    public searchBar(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public void searchBarSar(){
        searchBarLocation.clear();
        searchBarLocation.sendKeys("dress");
    }

    public void searchButton(){
        buttonSearch.click();
    }

    public void countElements(){
        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='product_list grid row']"));
        System.out.println("Number of elements on the webpage is: "+list.size());
        System.out.println("Going to home page!");
        homePage.click();
    }


}
