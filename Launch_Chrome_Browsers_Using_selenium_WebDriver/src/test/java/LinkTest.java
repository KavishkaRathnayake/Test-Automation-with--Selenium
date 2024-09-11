import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;

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
        WebElement BrokenLink = driver.findElement(By.partialLinkText("Broken"));
        BrokenLink.click();

        String title = driver.getTitle();
        if (title.contains("404")){
            System.out.println("The Link is Broken");
        }
        else{
            System.out.println("The Link not Broken");
        }
        driver.navigate().back();

        //Duplicate Link
        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();


        //Count Links
        List<WebElement>  CountFullPageLink = driver.findElements(By.tagName("a"));
        int PageLinkCount = CountFullPageLink.size();
        System.out.println("Count of Full page Links: "+ PageLinkCount);

        //Count Layout Links
        WebElement LayOutElement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> CountofLayOutElement = LayOutElement.findElements(By.tagName("a"));
        System.out.println("Count of Layout Links: "+ CountofLayOutElement.size());

    }
}
