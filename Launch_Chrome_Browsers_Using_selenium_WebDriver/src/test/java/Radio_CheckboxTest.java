import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;

public class Radio_CheckboxTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void RadioTest(){
        //<<<<<<<Radio>>>>>>>
        //Find the default select radio button
        driver.get("https://www.leafground.com/radio.xhtml");
        boolean ChromeRadioOption =  driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean FirefoxRadioOption =  driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean SafariRadioOption =  driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean EdgeRadioOption =  driver.findElement(By.id("j_idt87:console2:3")).isSelected();  //(in the  HTML code input word is only supported to isselected option)

        if (ChromeRadioOption){
            String Chrometext = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("default select radio button is " + Chrometext);
        }
        else if (FirefoxRadioOption) {
            String Firefoxtext = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("default select radio button is " + Firefoxtext);
        }
        else if (SafariRadioOption) {
            String Safaritext = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("default select radio button is " + Safaritext);
        }
        else if (EdgeRadioOption) {
            String Edgetext = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println("default select radio button is " + Edgetext);
        }


        //Select the age group (only if not selected)
        WebElement MyAgeGroup = driver.findElement(By.id("j_idt87:age:0"));
        boolean Checked = MyAgeGroup.isSelected();

        if(!Checked){
            driver.findElement(By.xpath(" //label[@for='j_idt87:age:0']")).click();
        }
    }

    @Test
    public void CheckboxTest(){
        //<<<<<<<Check Box>>>>>>>
        //Select wanted checkboxes and Verifying those checkboxes are selected status
        driver.get("https://www.leafground.com/checkbox.xhtml");
        List<WebElement> CheckBoxList = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for (WebElement element:CheckBoxList){
            if(!(element.getText().equals("Others"))){
                element.click();
            }
        }
        for(int i=1; i<= CheckBoxList.size(); i++){
            boolean CheckBoxstatus = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)[" + 1+ "]")).isSelected();
            System.out.println("Checkbox " + i + "selected status is: " + CheckBoxstatus);
        }


    }
}
