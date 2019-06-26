package phptravels_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import phptravels_pages.homePageBooking;

public class tests_On_Booking {
    WebDriver driver;
    homePageBooking.hotelBooking hotelBooking;
    homePageBooking.flightBooking flightBooking;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gabriel\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.phptravels.net/");
    }

    @Test
    public void hotelBookingTest() {
        hotelBooking = new homePageBooking.hotelBooking(driver);
        hotelBooking.fillInForm("Iasi");
        System.out.println("The functionality number 1 passed the test!");
    }

//    @Test
//    public void flightBookingTest(){
//        flightBooking = new homePageBooking.flightBooking(driver);
//        flightBooking.fillInFlightSearch("Iasi","Bacau");
//        System.out.println("The functionality number 2 passed the test!");
//
//    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
