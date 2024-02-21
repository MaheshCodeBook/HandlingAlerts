import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CA9TreasureHuntPageTest {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get("https://qatreasurehunt.ccbp.tech/");

            // Test the failure case
            WebElement secreatKeyEle = driver.findElement(By.cssSelector("a#secretKey"));
            secreatKeyEle.click();

            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.sendKeys("Expecto Patronum");
            alert.accept();
            System.out.println(alert.getText());
            alert.accept();

            // Test the success case
            alert.sendKeys("Expelliarmus");
            alert.accept();

            Thread.sleep(4000);
            driver.quit();

        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
