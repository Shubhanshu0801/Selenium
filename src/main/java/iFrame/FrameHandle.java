package iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class FrameHandle {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Hello");
        //switch to frame 1
        driver.switchTo().frame(driver.findElement(By.id("frm1")));
        Select courseDropdown = new Select(driver.findElement(By.id("course")));
        courseDropdown.selectByVisibleText("Java");
        //switch back to main web page
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("World");
        driver.quit();
        System.out.println("passed");
    }
}
