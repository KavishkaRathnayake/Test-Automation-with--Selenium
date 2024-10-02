package SeleniumWait;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

import static com.google.common.util.concurrent.Futures.withTimeout;

public class FluentWaitTest {
    WebDriver driver;

   @BeforeMethod
    public void openFluentWaitTest(){
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://www.leafground.com/waits.xhtml");
   }

   @Test
   //Declaration part
   public void FluentWaitTest(){
       Wait<WebDriver> wait  = new FluentWait<WebDriver>(driver)
               .withTimeout(Duration.ofSeconds(30))  // Maximum wait time
               .pollingEvery(Duration.ofSeconds(5))  // Polling interval
               .ignoring(NoSuchElementException.class);  // Ignore this exception while waiting
       // Usage
       driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();
       WebElement FluentWaitElement = wait.until(new Function<WebDriver, WebElement>() {
                                           public WebElement apply(WebDriver driver) {
                                               return driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span"));
                                           }
                                       });




       String newbuttontext = FluentWaitElement.getText();
       System.out.println("New button text is: " +newbuttontext);


   }
}
