import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.TimeUnit;

public class CP14SecureFileDownloaderTest {
    public static void main(String args[]) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get("https://qasecdwnld.ccbp.tech/");

            // Test the invalid Email submission
            WebElement emailInputEle = driver.findElement(By.cssSelector("input#email"));
            emailInputEle.sendKeys("example");

            WebElement generateOtpBtn = driver.findElement(By.cssSelector("button#otpButton"));
            generateOtpBtn.click();

            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();

            // Test the valid Email submission
            emailInputEle.sendKeys("@gmail.com");
            generateOtpBtn.click();
            System.out.println(alert.getText());
            alert.accept();

            // Test the valid OTP submission
            WebElement enterOTPele = driver.findElement(By.cssSelector("input#otp"));
            enterOTPele.sendKeys("123456");

            WebElement submitButton = driver.findElement(By.cssSelector("button#submitBtn"));
            submitButton.click();
            System.out.println(alert.getText());
            alert.accept();
            System.out.println(alert.getText());
            alert.accept();

            WebElement downloadButton = driver.findElement(By.cssSelector("button#downloadBtn"));
            downloadButton.click();
            System.out.println(alert.getText());
            alert.sendKeys("password123");
            alert.accept();

            System.out.println("Download successfull");

            Thread.sleep(3000);
            driver.quit();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

