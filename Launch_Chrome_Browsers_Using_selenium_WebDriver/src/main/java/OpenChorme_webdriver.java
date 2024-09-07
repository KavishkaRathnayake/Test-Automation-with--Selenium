import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.sql.Driver;

public class OpenChorme_webdriver {

    //open google
    // go to google home page

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","E:\\QA\\QA\\Launch_Chrome_Browsers_Using_selenium_WebDriver\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.quit();
    }
}

