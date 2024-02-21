import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CA9AccountRecoveryPageTest {
    public static void main(String[] args){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get("https://qaaccrecovery.ccbp.tech/");

            // Test the submission with empty fields
            WebElement userNameInputEle = driver.findElement(By.cssSelector("input#username"));
            userNameInputEle.sendKeys("Bob");

            WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
            submitButton.click();

            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();

            // Test the successful submission
            WebElement emailInputEle = driver.findElement(By.cssSelector("input#email"));
            emailInputEle.sendKeys("bob@gmail.com");
            submitButton.click();
            System.out.println(alert.getText());
            alert.accept();

            // Test the confirmation for resending OTP
            WebElement resendButton = driver.findElement(By.xpath("//a[text()='Resend OTP']"));
            resendButton.click();
            System.out.println(alert.getText());
            alert.accept();
            System.out.println(alert.getText());
            alert.accept();

            // Test the successful OTP submission
            WebElement enterOTPele = driver.findElement(By.cssSelector("input#otp"));
            enterOTPele.sendKeys("123456");

            WebElement otpSubmitButton = driver.findElement(By.cssSelector("form[id='otpForm'] :nth-child(3)"));
            otpSubmitButton.click();
            submitButton.click();

            System.out.println("Account Recovered");

           /* WebElement succesfullELE = driver.findElement(By.cssSelector("div[class='container'] :first-child"));
            System.out.println(succesfullELE.getText()); */

            Thread.sleep(3000);
            driver.quit();

        }catch (Exception e){
            System.out.println("The Exception is: "+e);
        }
    }
}
