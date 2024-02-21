import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AlertTest {
    public static void main(String args[]) {
        try {
            // Set the path to the ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");

            // Launch the Chrome browser
            WebDriver driver = new ChromeDriver();

            // Open the Jobby App login page
            driver.get("https://qajobbyapp.ccbp.tech/login");

            // Locate username field
            WebElement usernameEl = driver.findElement(By.cssSelector("input#userNameInput"));
            usernameEl.sendKeys("rahul");

            // Locate password field
            WebElement passwordEl = driver.findElement(By.cssSelector("input#passwordInput"));
            passwordEl.sendKeys("rahul@2021");


            // Locate submit button
            WebElement buttonEl = driver.findElement(By.cssSelector("button.login-button"));
            buttonEl.submit();

            // Define the expected URL of the home page
            String expectedUrl = "https://qajobbyapp.ccbp.tech/";

            // Wait for the expected URL to be loaded
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlToBe(expectedUrl));

            // Get the current URL after login
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals(expectedUrl)) {
                System.out.println("Navigation to home page is successful!");
            }

            WebElement logOutBtn = driver.findElement(By.cssSelector("button.logout-desktop-btn"));
            logOutBtn.click();

            // switch the Focus/Control to the Alert

            Alert confimationAlert = driver.switchTo().alert();
            System.out.println(confimationAlert.getText());
            confimationAlert.dismiss();
            logOutBtn.click();
            confimationAlert.accept();

            String expectedHomePageUrl = "https://qajobbyapp.ccbp.tech/login";
            wait.until(ExpectedConditions.urlToBe(expectedHomePageUrl));

            String actualHomePageUrl = driver.getCurrentUrl();
            if (expectedHomePageUrl.equals(actualHomePageUrl)){
                System.out.println("Logout successfull");
            }else {
                System.out.println("Logout failed");
            }

            //Close the browser
            driver.quit();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}