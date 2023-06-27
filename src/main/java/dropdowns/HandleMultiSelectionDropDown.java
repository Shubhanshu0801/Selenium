package dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HandleMultiSelectionDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //handling multi selection drop down
        WebElement ideNameElement = driver.findElement(By.xpath("//select[@id='ide']"));
        Select ideNameDropDown = new Select(ideNameElement);
        ideNameDropDown.selectByIndex(1);
        Thread.sleep(5000);
        ideNameDropDown.selectByValue("nb");
        Thread.sleep(5000);
        ideNameDropDown.selectByVisibleText("Visual Studio");
        Thread.sleep(5000);

        driver.quit();
        System.out.println("passed");
    }
}
