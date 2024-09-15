import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenDropdownTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/select.xhtml");
        }

        @Test
    public void  LeafgroundPageDropdownTest() throws InterruptedException {
        //1.1 ways of select value of basic dropdown
            WebElement Dropdown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
            Select select = new Select(Dropdown);
            select.selectByIndex(1);  //by index
            Thread.sleep(3000);
            select.selectByVisibleText("Playwright"); //By name
            Thread.sleep(3000);

        //1.2 Get the number of dropdown in selection
            List<WebElement> listofoptions =  select.getOptions();
            int size =  listofoptions.size();
            System.out.println("Number of element in dropdown: " + size);

            for (WebElement element:listofoptions){
                System.out.println(element.getText());
            }

        //1.3 Usig sendkeys select dropdown value
            Dropdown.sendKeys("Puppeteer");
            Thread.sleep(3000);

        //1.4 selecting value of bootstrap dropdown (not including Select tag = bootstrap /EG-div)
            WebElement Dropdown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
            Dropdown2.click();
            List<WebElement> listofDropdown2element = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']//li"));
            for(WebElement element:listofDropdown2element){
                String dropdownValue = element.getText();

                if(dropdownValue.equals("India")){
                    element.click();
                    break;
                }
            }
    }


    //2.Google search = pick a value from suggestions
    //3. Handle hidden auto suggestions dropdown and search using DOM Debugger (Trick)
}
