import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenWindowTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml");
        Thread.sleep(3000);
    }

    @Test
    public void WindowTest() throws InterruptedException {
        //Click and Confirm new Window Opens
        String OldWindow = driver.getWindowHandle();
        System.out.println("Parent Window: " + OldWindow);

        WebElement OpenButton = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        OpenButton.click();
        Thread.sleep(3000);
        Set<String> Handle = driver.getWindowHandles();
       System.out.println("Handle Size: " + Handle.size());  //count of opened windows


        //First Method (For Each loop)
        for(String NewWindow:Handle){
        System.out.println(NewWindow);
        driver.switchTo().window(NewWindow); //switch To new  window
        System.out.println("Page Title is:" + driver.getTitle());

        }

       // driver.close(); //close only switched windwow


        driver.switchTo().window(OldWindow); //switch back To parent window
        WebElement OpenButton1 = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        boolean OpenButton1Visibility = OpenButton1.isDisplayed();
        System.out.println("OpenButton Visibility is:" + OpenButton1Visibility); //check whether open button is displayed


        //Second Method
        //List<String> list = new ArrayList<String>(Handle); //converting set to the list
        //if(list.size() > 1){
        // driver.switchTo().window(list.get(1));
        //System.out.println("Child tab Title is:" + driver.getTitle());
        //driver.close();
   // }

    // driver.switchTo().window(OldWindow); //switch back To parent window
    // WebElement OpenButton01 = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
    // boolean OpenButton01Visibility = OpenButton1.isDisplayed();
    // System.out.println("OpenButton Visibility is:" + OpenButton01Visibility); //check whether open button is displayed



        //Find the number of opened tabs
        WebElement multiwindowButton =driver.findElement(By.id("j_idt88:j_idt91"));
        multiwindowButton.click();
        Thread.sleep(3000);

        Set<String> CountOfWindow =driver.getWindowHandles();
        int Howmanywindows =CountOfWindow.size();
        System.out.println("Number of windows opened: "  + Howmanywindows);



        //Close all windows except Primary
        WebElement DontClosemeButton =driver.findElement(By.id("j_idt88:j_idt93"));
        DontClosemeButton.click();
        Thread.sleep(3000);

        Set<String> NewWindowsHandle =driver.getWindowHandles();

        for(String allwindow:NewWindowsHandle){
            if(!allwindow.equals(OldWindow)){
                driver.switchTo().window(allwindow);
                driver.close();

            }
        }

    //driver.quit(); //close all browser windows
      driver.switchTo().window(OldWindow);
      driver.close(); //close single browser window driver which on focus
    }
}
