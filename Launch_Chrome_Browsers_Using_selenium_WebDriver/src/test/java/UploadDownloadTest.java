import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class UploadDownloadTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenUploadDownloadTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/file.xhtml");
        Thread.sleep(3000);
    }

    @Test
    public void UploadDownloadTest() throws InterruptedException, AWTException {
        //Download File
        WebElement DownloadButton = driver.findElement(By.id("j_idt93:j_idt95"));
        DownloadButton.click();
        Thread.sleep(3000);

        //Check the downloaded file available in the location
        File file = new File("C:\\Users\\Kavishka\\Downloads");
        File[] TotalFile = file.listFiles();

        for(File Findfile:TotalFile){
            if(Findfile.getName().equals("TestLeaf Logo.png")){
                System.out.println("File is Downloaded");
                break;
            }
        }

        //Basic Upload - 1st way (using robot class)

//        WebElement UploadButton = driver.findElement(By.id("j_idt88:j_idt89"));
//        UploadButton.click();

        //Window control begin here
//        String data = "C:\\Users\\Kavishka\\Downloads\\K A V I (2).png";
//        StringSelection selection = new StringSelection(data);
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);  //coping the path to Clipboard
//
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL); //VK mean Virtual Keyboard
//        robot.keyPress(KeyEvent.VK_V); //VK mean Virtual Keyboard
//        robot.keyRelease(KeyEvent.VK_V); //VK mean Virtual Keyboard
//        robot.keyRelease(KeyEvent.VK_CONTROL); //VK mean Virtual Keyboard
//
//        Thread.sleep(4000);
//
//        robot.keyPress(KeyEvent.VK_ENTER); //VK mean Virtual Keyboard
//        robot.keyRelease(KeyEvent.VK_ENTER); //VK mean Virtual Keyboard

        //2nd way using Sendkeys (appliable only input type is file)

        String data = "C:\\Users\\Kavishka\\Downloads\\K A V I (2).png";
        WebElement UploadusingSendkeys = driver.findElement(By.id("j_idt88:j_idt89_input"));
        UploadusingSendkeys.sendKeys(data);
    }
}
