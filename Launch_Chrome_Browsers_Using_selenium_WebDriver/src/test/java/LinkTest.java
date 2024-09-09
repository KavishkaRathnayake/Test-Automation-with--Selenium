import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LinkTest {
    WebDriver driver;

    @BeforeMethod
    public void openLinkTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");

    }

    @Test
    public void Linktest(){
        //Take me to dashboard
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();

        //Find my destination
        WebElement WhereToGo = driver.findElement(By.partialLinkText("Find the URL "));
        String path = WhereToGo.getAttribute("href");
        System.out.println("This link i going to" + path);

        //Am I broken link?
        //Duplicate Link
        //Count Links
        //Count Layout Links
    }
}
