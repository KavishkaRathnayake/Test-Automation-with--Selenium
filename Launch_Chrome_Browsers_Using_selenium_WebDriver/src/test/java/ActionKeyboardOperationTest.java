import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.security.Key;
import java.util.List;

public class ActionKeyboardOperationTest {
    WebDriver driver;

    @BeforeMethod
    public void openActionKeyboardOperationTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }
    @Test
    public void ActionKeyboardOperationTest() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement TextBox = driver.findElement(By.name("q"));
        TextBox.sendKeys("Welcome");

        Actions action = new Actions(driver); //initialize Actions class

        //Select the text
        action.keyDown(Keys.CONTROL).sendKeys("a").keyDown(Keys.CONTROL).perform();
        Thread.sleep(5000);

        // capital letter
        action.keyUp(Keys.SHIFT)
                .sendKeys("xyz")
                .keyDown(Keys.SHIFT).perform();


        action.keyUp(Keys.SHIFT)
                .keyDown(Keys.CONTROL)
                .sendKeys("a") //select all
                .keyUp(Keys.CONTROL)
                .keyDown(Keys.CONTROL)
                .sendKeys("x")   //cut

                .perform();

        //other method for capital

        action.keyDown(TextBox, Keys.SHIFT)
                .sendKeys("write me in apital")
                .perform();
    }

    @Test
    public void ActionKeyboardOperationTest2() throws InterruptedException {
        driver.get("https://www.leafground.com/list.xhtml");
        Thread.sleep(4000);

        List<WebElement> Selectable =  driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
       int size = Selectable.size();
       System.out.println("Li count is: " + size);

       Actions action = new Actions(driver);
       action.keyDown(Keys.CONTROL)
               .click(Selectable.get(0))
               .click(Selectable.get(1))
               .click(Selectable.get(2))
               .click(Selectable.get(3))
               .perform();



    }
}

