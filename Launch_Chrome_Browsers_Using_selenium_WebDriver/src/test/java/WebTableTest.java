import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest {
    WebDriver driver;

    @BeforeMethod
    public void OpenWebTableTest(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");


    }
    @Test
    public void WebTableTest() throws InterruptedException {
        //01) How Many Rows in the Table
        List<WebElement> Count = driver.findElements(By.xpath("//table[@id='productTable']//tbody/tr"));
        int RowCount = Count.size();
        System.out.println("There are " +RowCount+ " Rows in the Table");

        //02) How Many Columns in the Table
        int ColumnCount = driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th")).size();
        System.out.println("There are " +ColumnCount+ " Columns in the Table");

        //03)Retrieve the specific row/Column data
        String Value = driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr[3]/td[3]")).getText();
        System.out.println("specific row/Column data: " +Value);

        //04)Retrieve all the data from Table
         for(int i =1; i<=RowCount; i++){ //Rows
             for(int j =1; j<ColumnCount; j++){ //Columns
                 String TableData = driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
                 System.out.print(TableData + " ");
             }
             System.out.println();
         }
         //05)Print ID and Name only
        for(int i=1; i<=RowCount; i++){ //Columns
            String TableID = driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr["+i+"]/td[1]")).getText();
            String TableProdutName = driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr["+i+"]/td[2]")).getText();
            System.out.println("Table ID: " +TableID+ " Table Produt Name: "+TableProdutName);

            //5.1)Find the product price which name related to product 3
            if (TableProdutName.equals("Product 3")) {
                String RelevantProdutPrice = driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr[" + i + "]/td[3]")).getText();
                System.out.println(TableProdutName +" Relevant Produt Price: " +RelevantProdutPrice);
            }
        }

        //06)Select all the Checkbox

        int pagecount = driver.findElements(By.xpath("//*[@id='pagination']/li")).size();
        List<WebElement> Pages =driver.findElements(By.xpath("//*[@id='pagination']/li"));

        for(int k=0; k<pagecount; k++){
            Pages.get(k).click();
            Thread.sleep(3000);

            for (int i =1; i<=RowCount; i++){
                boolean Checkbox =  driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr[" + i + "]/td[4]")).isSelected();
                if(!Checkbox){
                    driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr[" + i + "]/td[4]/input")).click();
                    Thread.sleep(300);
                }
            }
        }

        //07)Select one Checkbox
        int TableRow = 1;
        driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr[" +TableRow+ "]/td[4]/input")).click();


    }

}
