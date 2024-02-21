import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CA9ConferenceRegistrationPageTest {
    public static void main(String[] args){
     try {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://qaconfreg.ccbp.tech/");

         WebElement nameInputEle = driver.findElement(By.cssSelector("input#name"));
         nameInputEle.sendKeys("Alice");

        WebElement registerButton = driver.findElement(By.xpath("//input[@type='submit']"));
        registerButton.click();

         Alert alert = driver.switchTo().alert();
         System.out.println(alert.getText());
         alert.accept();

         WebElement emailInputEle = driver.findElement(By.cssSelector("input#email"));
         emailInputEle.sendKeys("Alice@gmail.com");
         registerButton.click();
         System.out.println(alert.getText());
         alert.accept();

         Thread.sleep(3000);
         driver.quit();

        }catch (Exception e){
        System.out.println("The Exception is: "+e);
      }
    }
}

