package phptravels_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePageBooking {
    public WebDriver driver;
    public WebDriverWait wait;

    public static class hotelBooking {
        @FindBy(css = "a[class='select2-choice']")
        WebElement searchHotelTextBar;
        @FindBy(css = "input[type='text'][class='form input-lg dpd1']")
        WebElement checkIn;
        @FindBy(css = "input[type='text'][class='form input-lg dpd2']")
        WebElement checkOut;
        @FindBy(xpath = "//div[10]//tr[5]//td[3]")
        WebElement checkInDate;
        @FindBy(xpath = "//div[11]//tr[5]//td[6]")
        WebElement checkOutDate;
        @FindBy(id = "travellersInput")
        WebElement clientsNumber;
        @FindBy(id = "adultPlusBtn")
        WebElement adultBtn;
        @FindBy(id = "childPlusBtn")
        WebElement childBtn;
        @FindBy(css = "button[class='btn btn-lg btn-block btn-primary pfb0 loader'][type='submit']")
        WebElement searchBtn;
        @FindBy(css = "li[class='select2-results-dept-1 select2-result select2-result-selectable']")
        WebElement locationSelect;
        private WebDriver driver;
        private WebDriverWait wait;

        public hotelBooking(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public void fillInForm(String hotelName) {
            searchHotelTextBar.click();
            searchHotelTextBar.sendKeys(hotelName);
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class='select2-results-dept-1 select2-result select2-result-selectable']")));
            locationSelect.click();

            checkIn.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[10]//tr[5]//td[3]")));
            checkInDate.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[11]//tr[5]//td[6]")));
            checkOutDate.click();
            clientsNumber.click();
            for (int i = 2; i < 3; i++) {
                adultBtn.click();
            }

            for (int j = 0; j < 3; j++) {
                childBtn.click();
            }

            searchBtn.click();


        }


    }

    public static class flightBooking{
        private WebDriver driver;
        private WebDriverWait wait;
        @FindBy(css = "a[class='text-center'][title='Flights']")
        WebElement flightBtn;
        @FindBy(css = "a[class='select2-choice select2-default']")
        WebElement textBarCity;
        @FindBy(css = "li[class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")
        WebElement locationSelect;
        @FindBy(xpath = "//div[@id='s2id_location_to']//a[@class='select2-choice select2-default']")
        WebElement textBarCity2;
        @FindBy(css = "li[class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")
        WebElement locationSelect2;
        @FindBy(css = "input[type='date'][placeholder='Depart']")
        WebElement departureCalendar;
        @FindBy(xpath = "//div[15]//tr[5]//td[3]")
        WebElement departureDay;
        @FindBy(css = "input[type='date'][placeholder='Return']")
        WebElement returnCalendar;
        @FindBy(xpath = "//div[16]//tr[5]//td[5]")
        WebElement returnDay;
        @FindBy(css = "input[type='text'][class='form form-control input-lg'][data-toggle='modal']")
        WebElement passengersSelect;
        @FindBy(css = "button[type='submit'][class='btn-primary btn btn-lg btn-block pfb0']")
        WebElement searchBtn;

        public flightBooking(WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver,this);
        }

        public void fillInFlightSearch(String nameOfTheCity1, String nameOfTheCity2){
            flightBtn.click();
            wait=new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='select2-choice select2-default']")));
            textBarCity.click();
            textBarCity.sendKeys(nameOfTheCity1);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")));
            locationSelect.click();

            textBarCity2.click();
            textBarCity2.sendKeys(nameOfTheCity2);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")));
            locationSelect2.click();

            departureCalendar.click();
            departureDay.click();
            returnCalendar.click();
            returnDay.click();

            passengersSelect.click();
            passengersSelect.sendKeys("2");
            searchBtn.click();
        }


    }
}
