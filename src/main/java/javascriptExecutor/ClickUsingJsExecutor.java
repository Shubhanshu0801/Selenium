package javascriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

//This can be done by two ways
//1. FindElement(Javascript) + Click(Javascript)
//2. FindElement(WebDriver) + Click(Javascript)
public class ClickUsingJsExecutor {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('femalerb').click()");
        //getElementById returns WebElement
        //But all other getElements method returns List
        List checkBoxes = (List) js.executeScript("return document.getElementsByName('language')");
        for(Object object: checkBoxes) {
            js.executeScript("arguments[0].click()", object);
        }
        js.executeScript("document.getElementsByClassName('bcButton')[0].click()");
        Thread.sleep(3000);
        WebElement homePageLink = driver.findElement(By.xpath("//a[text()='Click here to navigate to the home page']"));
        js.executeScript("arguments[0].click()", homePageLink);
        System.out.println("passed");
    }
}
