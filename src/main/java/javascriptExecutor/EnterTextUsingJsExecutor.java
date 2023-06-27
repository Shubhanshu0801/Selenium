package javascriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//This can be done by two ways
//1. FindElement(Javascript) + SendText(Javascript)
//2. FindElement(WebDriver) + SendText(Javascript)
public class EnterTextUsingJsExecutor {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/login.php/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. FindElement(Javascript) + SendText(Javascript)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('email').value='abcd@gmail.com'");
        Thread.sleep(3000);

        //2.To retrieve the value of input field
        //In dom structure every element is treated as an object.
        //To get the String value we have to cast it into String
        String text = (String) js.executeScript("return document.getElementById('email').value");
        System.out.println(text);

        //3. FindElement(WebDriver) + SendText(Javascript)
        WebElement inputField = driver.findElement(By.id("pass"));
        js.executeScript("arguments[0].value='abcd'", inputField);
        Thread.sleep(3000);
        driver.quit();
        System.out.println("passed");
    }
}
