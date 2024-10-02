package SeleniumWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaitTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenExplicitWaitTest(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://www.leafground.com/waits.xhtml");
    }

    @Test
    public void ExplicitWaitTest(){
        //Declaration part

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Usage
        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();
        WebElement newbuttonelemnent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='j_idt87:j_idt90']/span")));

        String newbuttontext = newbuttonelemnent.getText();
        System.out.println("New button text is: " +newbuttontext);

    }
    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }
}

