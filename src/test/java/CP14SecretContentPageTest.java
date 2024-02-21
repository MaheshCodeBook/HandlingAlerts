import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CP14SecretContentPageTest {
    public static void main(String args[]) {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get("https://qascrtcontent.ccbp.tech/");

            // Test the failure case
            WebElement viewContentEle = driver.findElement(By.cssSelector("button.button"));
            viewContentEle.click();

            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());

            alert.sendKeys("admin");
            alert.accept();

            System.out.println(alert.getText());
            alert.accept();

            // Test the success case
            viewContentEle.click();
            alert.sendKeys("password");
            alert.accept();

            WebElement secreatContent = driver.findElement(By.cssSelector("div#secretContent :first-child"));
            System.out.println(secreatContent.getText());

            Thread.sleep(3000);
            driver.quit();

        }catch (Exception e){
        System.out.println(e.getMessage());
        }
    }
}

