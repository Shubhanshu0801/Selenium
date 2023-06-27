package mouseMovement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseMovementExample {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://phptravels.com/demo/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Actions action = new Actions(driver);
        WebElement hoveredElement = driver.findElement(By.xpath("//div[@class='nav_left']//child::ul//child::li" +
                "//child::div//child::span[contains(text(),'Product')]"));
        WebElement elementToBeClicked = driver.findElement(By.xpath("//a[contains(text(),'Customizations') and " +
                "@class='arrow waves-effect']"));
        action.moveToElement(hoveredElement)
                .build().perform();
        elementToBeClicked.click();
        driver.quit();
        System.out.println("passed");
    }
}
