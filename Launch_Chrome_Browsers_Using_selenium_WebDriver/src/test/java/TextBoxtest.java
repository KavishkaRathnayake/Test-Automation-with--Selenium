import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxtest {
    WebDriver driver;

    @BeforeMethod
    public void openLinkTest() throws InterruptedException {
        ChromeOptions options= new ChromeOptions();
        options.setBrowserVersion("122"); // change browser version
        options.addArguments("--start-maximized");//maximize window
        options.addArguments("--incognito"); //incognito
       // options.addArguments("--headless"); //background run
        driver = new ChromeDriver(options); //passing value
        driver.manage().window().maximize();//maximize window
        driver.get("https://www.leafground.com/input.xhtml");
        Thread.sleep(5000); //wait 5 seconds on website
    }

    @Test
    public void TextBoxtests(){
    //Type your name
       WebElement Name =  driver.findElement(By.id("j_idt88:name"));
       Name.sendKeys("Kavishka Rathnayake");

    //Append Country to this City.
       WebElement AppendText =  driver.findElement(By.id("j_idt88:j_idt91"));
       AppendText.sendKeys("India");

       //Verify if text box is disabled
        boolean diabled = driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is this textbox ie enabled: "+diabled);

    //Clear the typed text
        WebElement CleartheText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        CleartheText.clear();

    //Retrieve the typed text.
        WebElement RetreiveTypedText = driver.findElement(By.id("j_idt88:j_idt97"));
        String Value = RetreiveTypedText.getAttribute("Value");
        System.out.println(Value);

//Type email and Tab. Confirm control moved to next element.
        WebElement TypeEmail = driver.findElement(By.id("j_idt88:j_idt99"));
        TypeEmail.sendKeys("medhangakavishka06@gmail.com" + Keys.TAB + "Confirmed! Control moved to next element.");

    }
}