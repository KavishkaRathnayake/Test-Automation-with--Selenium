import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenFrameTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml");
    }

    @Test
    public void FrameTest(){
        //Click Me (Inside frame =iframe)
        driver.switchTo().frame(0);
        WebElement Button01 = driver.findElement(By.xpath("//*[@id='Click']"));
        Button01.click();

        String AfterClickButton01 = Button01.getText(); //when text with tag name using getText()
        System.out.println("After Click inside Button text: "+AfterClickButton01);

        //Click Me (Inside Nested frame)
        driver.switchTo().defaultContent(); //comeback into main html page
        driver.switchTo().frame(2); //inside into third frame
        driver.switchTo().frame("frame2"); //inside into third frame > child frame

        WebElement NestedButton = driver.findElement(By.id("Click"));
        NestedButton.click();

        String AfterClickNestedFrameButton= NestedButton.getText(); //when text with tag name using getText()
        System.out.println("After Click Nested frame Button text: "+AfterClickNestedFrameButton);


        //How many frames in this page?
        driver.switchTo().defaultContent(); //comeback into main html page
        List<WebElement> GetiframeCount = driver.findElements(By.tagName("iframe"));
        int Count = GetiframeCount.size();
        System.out.println("There are " +Count+ " frames in this page");

        for(WebElement iframeElement :GetiframeCount){
            String FramesrcAttributeValue = iframeElement.getAttribute("src");
            System.out.println("Frame src Attribute Value: " + FramesrcAttributeValue);

            }
        }
    }




