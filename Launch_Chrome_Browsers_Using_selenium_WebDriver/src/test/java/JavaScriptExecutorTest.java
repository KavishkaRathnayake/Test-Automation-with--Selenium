import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest {
    WebDriver driver;
    JavascriptExecutor jsexecutor;

    @BeforeMethod
    public void OpenJavaScriptExecutorTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }
    @Test
    public void JavaScriptExecutorTest() throws InterruptedException {

        jsexecutor = (JavascriptExecutor) driver;

        //01) get a alert box in to the web page using javascript
        //jsexecutor.executeScript("alert('My name is Kavishka Rathnayake')");

        //02).set a input value in a textbox using javascript executor
        //2.1) way 01>>>set the value using value property (common way)
        WebElement InputNametoTextbox = driver.findElement(By.xpath("//input[@id='name']"));
        // jsexecutor.executeScript("arguments[0].value='Kavishka Rathnayake';" , InputNametoTextbox);

        //2.2) way 02>>>set the value using setAttribute (common way)
        jsexecutor.executeScript("arguments[0].setAttribute('value' ,'Kavishka Rathnayake')", InputNametoTextbox);

        Thread.sleep(4000);


        //03).Highlight Element
        jsexecutor.executeScript("arguments[0].style.border='3px solid red'", InputNametoTextbox);
        jsexecutor.executeScript("arguments[0].style.background='yellow'", InputNametoTextbox);

        Thread.sleep(4000);

        //04).click element using javascript executor
        WebElement checkbox = driver.findElement(By.xpath("//input[@id='male']"));
        jsexecutor.executeScript("arguments[0].click()", checkbox);

        Thread.sleep(4000);

        //05). scrolling the page

        scrollPage();

    }

    public void scrollPage() throws InterruptedException {
        //5.1).scroll to some position
        jsexecutor.executeScript("window.scrollTo(0,700);");
        Thread.sleep(5000);
        System.out.println("current pageYoffset Value is: " +   jsexecutor.executeScript("return window.pageYoffset"));
        jsexecutor.executeScript("window.scrollTo(0,-700);");
        Thread.sleep(5000);

        //5.2).scroll to bottom of the page by pixel number
        jsexecutor.executeScript("window.scrollTo(0 , document.body.scrollheight)");
        Thread.sleep(5000);

        //5.3).scroll to top of the page
        jsexecutor.executeScript("window.scrollTo(0 , 0)");
        Thread.sleep(5000);

        //5.4)scroll the page till element is visible
        WebElement scrolltoelement =  driver.findElement(By.xpath("//label[text()='Gender:']"));
        jsexecutor.executeScript("arguments[0].scrollIntoView(true);", scrolltoelement);

    }
}
