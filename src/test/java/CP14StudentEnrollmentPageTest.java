import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CP14StudentEnrollmentPageTest {
    public static void main(String args[]) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get("https://qastdenroll.ccbp.tech/");

            WebElement nameInputEle = driver.findElement(By.cssSelector("input#name"));
            nameInputEle.sendKeys("John");

            WebElement enrollButton = driver.findElement(By.cssSelector("button.submit-button"));
            enrollButton.click();

            Alert nameAlert = driver.switchTo().alert();
            System.out.println(nameAlert.getText());
            nameAlert.accept();

            WebElement emailInputEle = driver.findElement(By.cssSelector("input#email"));
            emailInputEle.sendKeys("john@gmail.com");
            enrollButton.click();
            System.out.println(nameAlert.getText());
            nameAlert.accept();

            driver.quit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
