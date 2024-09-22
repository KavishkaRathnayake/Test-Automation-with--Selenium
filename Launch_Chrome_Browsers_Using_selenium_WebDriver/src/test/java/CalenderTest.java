import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CalenderTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenCalenderTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void CalenderTest1() {
        driver.get("https://jqueryui.com/datepicker/");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

        //Method 01
//        WebElement datepicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
//        datepicker.sendKeys("09/22/2024");

        //Method 02
        SelectFutureDate("2027", "October", "27");
        //SelectPastDate("2022", "May", "10");

    }


    public void SelectFutureDate(String Year, String Month, String Day) {
        WebElement datepicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
        datepicker.click();

        while (true) {
            String AtualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String AtualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (AtualYear.equals(Year) && AtualMonth.equals(Month)) {
                break;
            } else {
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            }
        }
        List<WebElement> AllDate = driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody//tr//td//a"));
        for (WebElement Date : AllDate) {
            if (Date.getText().equals(Day)) ;
            Date.click();
            break;
        }

    }

    public void SelectPastDate(String Year, String Month, String Day) {
        WebElement datepicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
        datepicker.click();

        while (true) {
            String AtualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String AtualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (AtualYear.equals(Year) && AtualMonth.equals(Month)) {
                break;
            } else {
                driver.findElement(By.xpath("//a[@title='Prev']")).click();
            }
        }
        List<WebElement> AllDate = driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody//tr//td//a"));
        for (WebElement Date : AllDate) {
            if (Date.getText().equals(Day)) ;
            Date.click();
            break;
        }
    }
}


