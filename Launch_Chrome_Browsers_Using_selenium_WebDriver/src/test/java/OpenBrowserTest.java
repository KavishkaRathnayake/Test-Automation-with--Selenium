import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenBrowserTest {

        @Test
        public void googleTest(){

            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com/");
            driver.quit();
        }
    }


