import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CP14UpdatePasswordPageTest {
    public static void main(String args[]) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get("https://qaupasswd.ccbp.tech/");

            // Test the submission with empty fields
            WebElement oldPasswordEle = driver.findElement(By.cssSelector("input#oldPassword"));
            oldPasswordEle.sendKeys("admin");

            WebElement changePasswordBtn = driver.findElement(By.cssSelector("button.btn"));
            changePasswordBtn.click();

            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();

            WebElement newPasswordEle = driver.findElement(By.cssSelector("input#newPassword"));
            newPasswordEle.sendKeys("admin1234");

            WebElement reEnterPasswordEle = driver.findElement(By.cssSelector("input#reEnterPassword"));
            reEnterPasswordEle.sendKeys("admin");

            changePasswordBtn.click();
            System.out.println(alert.getText());
            alert.accept();

            // Test the dismissal of the confirmation alert
            reEnterPasswordEle.sendKeys("1234");
            changePasswordBtn.click();
            System.out.println(alert.getText());
            alert.dismiss();

            // Test the successful submission
            oldPasswordEle.sendKeys("123");
            changePasswordBtn.click();
            alert.accept();
            System.out.println(alert.getText());
            alert.accept();

            Thread.sleep(3000);
            //driver.quit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

