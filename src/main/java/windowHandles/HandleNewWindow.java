package windowHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class HandleNewWindow {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String parentHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("//button[@id='newWindowBtn']")).click();
        Set<String> handles = driver.getWindowHandles();
        for(String handle: handles) {
            if(!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                driver.findElement(By.xpath("//input[@id='firstName']"))
                        .sendKeys("Shubhanshu");
                Thread.sleep(5000);
                driver.close();
            }
        }
        driver.switchTo().window(parentHandle);
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Dubey");
        driver.quit();
        System.out.println("passed");
    }
}
