import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalendarHandling {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://seleniumpractise.blogspot.com/search?updated-max=2016-08-09T11:22:00-07:00&max-results=7&start=14&by-date=false");

        driver.findElement(By.id("datepicker")).click();

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar")));


       String monthYearVal =  driver.findElement(By.className("ui-datepicker-title")).getText();

        System.out.println(monthYearVal);// February 2025

        String month = monthYearVal.split(" ")[0].trim();
        String year = monthYearVal.split(" ")[1].trim();

        System.out.println(month);
        System.out.println(year);

        while (!(month.equals("June") && year.equals("2022"))) {
            driver.findElement(By.xpath("//a[@title='Prev']")).click();
            monthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();


            System.out.println(monthYearVal);// February 2022

            month = monthYearVal.split(" ")[0].trim();
            year = monthYearVal.split(" ")[1].trim();
        }

        driver.findElement(By.xpath("//a[text() = '21']")).click();

    }
}
