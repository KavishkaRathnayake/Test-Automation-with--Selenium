import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class FindBrokenImageTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenFindBrokenImageTest() throws InterruptedException {
        ChromeOptions ChromeOptions = new ChromeOptions();
        File file = new File("C:\\Users\\Kavishka\\Downloads\\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx"); //add seletorhub to automated browser.(add any extension to  automated browser.)
        ChromeOptions.addExtensions(file);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(4000);
    }

    @Test
    public void FindBrokenImageTest(){
        driver.get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> Images = driver.findElements(By.xpath("//div[@class='example']/img"));

        int i = 1;
        for(WebElement Image :Images){  //if "naturalwidth" attribute is equal to "0", then we can say this is a broken image
            if(Image.getAttribute("naturalWidth").equals("0")){
                System.out.println("image" +i+ "is broken ");
            }
            else {
                System.out.println("image" +i+ "is not broken  ");
            }
            i++;
        }

    }

    @Test
    public void FindBrokenImageTest2(){
        driver.get("https://demoqa.com/broken");
        WebElement Image = driver.findElement(By.xpath("//*[@id='app']/div/div/div/div[2]/div[2]/img[2]"));
        if(Image.getAttribute("naturalWidth").equals("0")){
            System.out.println("image is broken ");
        }
        else {
            System.out.println("this is not a broken image");
        }
    }

}
