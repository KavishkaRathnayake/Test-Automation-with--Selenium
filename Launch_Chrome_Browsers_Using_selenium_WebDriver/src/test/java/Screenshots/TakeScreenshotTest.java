package Screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakeScreenshotTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenTakeScreenshotTest(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public void TakeScreenshotTest() throws IOException, AWTException {
//        //01)Capture Screenshot of full web page
//        TakesScreenshot TakeScreenshot = (TakesScreenshot) driver;
//        File SourceFile = TakeScreenshot.getScreenshotAs(OutputType.FILE);
//
//                   //E:\\QA\\QA\\Launch_Chrome_Browsers_Using_selenium_WebDriver\\Screenshot
//
//        File DestinationFile = new File(System.getProperty("user.dir")+ "\\Screenshot\\"+ "alert_full_web_page.png");
//        FileHandler.copy(SourceFile,DestinationFile);


        //02)Capture Screenshot of section of web page
//        WebElement Section01Pageelement = driver.findElement(By.xpath("//*[@id='j_idt88']/div/div[1]"));
//        File Source = Section01Pageelement.getScreenshotAs(OutputType.FILE);
//        File Target = new File(System.getProperty("user.dir")+ "\\Screenshot\\"+ "alert_Section_of_web_page.png");
//        FileUtils.copyFile(Source,Target);
//
//        //03)Capture Screenshot of an element of web page
//        WebElement elementofpage = driver.findElement(By.xpath("(//div[@class='card'])[1]"));
//        File Source1 = Section01Pageelement.getScreenshotAs(OutputType.FILE);
//        File Target1 = new File(System.getProperty("user.dir")+ "\\Screenshot\\"+ "alert_element_of_web_page.png");
//        FileUtils.copyFile(Source1,Target1);

        //04)Capture Screenshot of full full_entire_ screen

        WebElement Alertbtn = driver.findElement(By.id("j_idt88:j_idt91"));
        Alertbtn.click();

        Robot robot = new Robot();
        Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(ScreenSize);

        BufferedImage Source2 = robot.createScreenCapture(rectangle);
        File DestinationFile2 = new File(System.getProperty("user.dir")+ "\\Screenshot\\"+ "alert_full_entire_ screen.png");
        ImageIO.write(Source2,"png",DestinationFile2);

    }
}
