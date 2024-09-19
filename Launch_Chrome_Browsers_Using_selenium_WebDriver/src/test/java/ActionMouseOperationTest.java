import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionMouseOperationTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenMouseTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void ActionMouseOperationTest1() throws InterruptedException {
        driver.get("https://www.leafground.com/drag.xhtml");

                      //01 - Move to an Element Operation

        System.out.println("<<<<<<<<<<01 - Move to an Element Operation>>>>>>>>>>");
        Actions action = new Actions(driver); //initialize action class and passing webdriver

        action.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).perform();  //build().perform()
        Thread.sleep(3000);

        action.moveToElement(driver.findElement(By.id("menuform:j_idt38"))).perform();  //build().perform()
        Thread.sleep(3000);

        action.moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();  //build().perform()
        Thread.sleep(3000);

                              //02 - Darg and Drop Operation

        System.out.println("<<<<<<<<<<02 - Darg and Drop Operation>>>>>>>>>>");

        WebElement from = driver.findElement(By.id("form:drag"));
        WebElement to = driver.findElement(By.id("form:drop"));
        //action.clickAndHold(from).moveToElement(to).release(to).perform(); //1st way
        action.dragAndDrop(from , to).perform(); //2nd way


                              //03 - Slider Operation

        System.out.println("<<<<<<<<<<03 - Slider Operation>>>>>>>>>>");
        WebElement SlidderPoint01 = driver.findElement(By.xpath("//*[@id='form:j_idt125']/span[1]"));
        System.out.println("Location of Slidder Point 01 before moving: " + SlidderPoint01.getLocation());

        action.dragAndDropBy(SlidderPoint01, 50, 0 ).perform();
        System.out.println("Location of Slidder Point 01 after moving: " + SlidderPoint01.getLocation());
    }


    @Test
    public void ActionMouseOperationTest2(){
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        System.out.println("<<<<<<<<<<Right Click Operation>>>>>>>>>>");
        WebElement rightButtonClick = driver.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));
        Actions action01 = new Actions(driver);
        action01.contextClick(rightButtonClick).perform();

        driver.findElement(By.xpath("//span[text()='Edit']")).click();
        Alert alertpop = driver.switchTo().alert();
        System.out.println("Alert shows the text as: "+ alertpop.getText());
        alertpop.accept();
    }
}
