import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {
    WebDriver driver;

@BeforeMethod
public void OpenAlertTest(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.leafground.com/alert.xhtml");
}
@Test
    public void AlertTest() throws InterruptedException {
    //Alert (Simple Dialog)

    WebElement AlertBox = driver.findElement(By.id("j_idt88:j_idt91"));
    AlertBox.click();
    Alert AcceptAlertBox = driver.switchTo().alert();
    Thread.sleep(3000);
    AcceptAlertBox.accept(); //Entering Ok


    //Alert (Confirm Dialog)
    WebElement ConfirmBox = driver.findElement(By.id("j_idt88:j_idt93"));
    ConfirmBox.click();
    Alert CancelConfirmBox = driver.switchTo().alert();
    Thread.sleep(3000);
    CancelConfirmBox.dismiss();

    //Alert (Prompt Dialog)
    WebElement PromptBox = driver.findElement(By.id("j_idt88:j_idt104"));
    PromptBox.click();
    Alert EnterwordConfirmBox = driver.switchTo().alert();
    Thread.sleep(3000);
    String AlertText = EnterwordConfirmBox.getText();
    System.out.println("Alert Text is: " + AlertText);

    EnterwordConfirmBox.sendKeys("Kavi Rathnayake");
    EnterwordConfirmBox.accept();
}
}
