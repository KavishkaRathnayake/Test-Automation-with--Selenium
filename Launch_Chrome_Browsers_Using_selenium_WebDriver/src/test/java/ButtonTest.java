import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonTest {
    WebDriver driver;

    @BeforeMethod
    public void openButtonTest(){
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(800,600);
        driver.manage().window().setSize(newSize);  //open browser in this size
        driver.get("https://www.leafground.com/button.xhtml");

    }
    @Test
    public void ButtonTest(){
        //Click and Confirm title.
        WebElement ButtonClick = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']"));
        ButtonClick.click();
        String ExpectedTitle = "Dashboard";
        String ActualTitle = driver.getTitle();

        if (ExpectedTitle.equals(ActualTitle)){
            System.out.println("Actual Title same as Expected");
        }
        else {
            System.out.println("Actual Title not as Expected");
        }

       // Assert.assertEquals(ActualTitle,ExpectedTitle,"Title miss matched"); (a testiNG method)


        //Find the position of the Submit button
        driver.navigate().back();
        WebElement Getposition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xypoint =Getposition.getLocation();
        int x = xypoint.getX();
        int y = xypoint.getY();
        System.out.println("x Axis is " + x + "y Axis is " + y);

        //Find the Save button color
       WebElement Buttoncolor =  driver.findElement(By.id("j_idt88:j_idt96"));
       String color = Buttoncolor.getCssValue("background-color");
       System.out.println("Button Color is " + color);

       //Find the height and width of this button
       WebElement Size = driver.findElement(By.id("j_idt88:j_idt98"));
       int hight = Size.getSize().getHeight();
       int width = Size.getSize().getWidth();
       System.out.println("hight is " + hight + "y Axis width " + width);


    }
}
