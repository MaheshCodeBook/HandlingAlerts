import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CA9MusicConcertPageTest {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
          //  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://qaconcertreg.ccbp.tech/");

            // Test the submission with empty fields
            WebElement nameInputEle = driver.findElement(By.cssSelector("input#name"));
            nameInputEle.sendKeys("Charlie");

            WebElement bookNowBtn = driver.findElement(By.cssSelector("button.btn"));
            bookNowBtn.click();

            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();

            // Test the successful submission
            WebElement emailInputEle = driver.findElement(By.cssSelector("input#email"));
            emailInputEle.sendKeys("charlie@gmail.com");
            bookNowBtn.click();
            System.out.println(alert.getText());
            alert.accept();

            // Test the valid passcode submission
            WebElement enterPassword = driver.findElement(By.cssSelector("input#passcode"));
            enterPassword.sendKeys("123456");

            WebElement veriftBtn = driver.findElement(By.cssSelector("div[class='container'] :nth-child(3)"));
            veriftBtn.click();

            System.out.println(alert.getText());
            alert.accept();
            System.out.println(alert.getText());
            alert.accept();

            // Test the valid promocode submission
            alert.sendKeys("foodmunch");
            alert.accept();

            System.out.println("Gift Voucher Issued");

            Thread.sleep(4000);
            driver.quit();

        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
