package SeleniumWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWaitTest {
        WebDriver driver;

        @BeforeMethod
        public void openImplicitWaitTest(){
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

            //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.get("https://www.leafground.com/waits.xhtml");
        }

        @Test
        public void ImplicitWaitTest(){
            driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();
            String newbuttontext = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span")).getText();
            System.out.println("New button text is: " +newbuttontext);

        }
        @AfterMethod
        public void CloseBrowser(){
            driver.quit();
        }
    }


