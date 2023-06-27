package mouseMovement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragAndDropExample {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
        Actions action = new Actions(driver);
        WebElement elementToBeDragged = driver.findElement(By.xpath("//ul[@id='gallery']//" +
                "child::li//child::h5[text()='High Tatras']"));
        WebElement elementDestination = driver.findElement(By.xpath("//div[@id='trash']"));
        action.clickAndHold(elementToBeDragged).moveToElement(elementDestination).release()
                .build().perform();
        driver.quit();
        System.out.println("passed");
    }
}
