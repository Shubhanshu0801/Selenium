package dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class GetOptionsFromDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement courseNameElement = driver.findElement(By.xpath("//select[@id='course']"));
        Select courseNameDropDown = new Select(courseNameElement);
        List<WebElement> courseAvailable = courseNameDropDown.getOptions();
        System.out.println("Courses Available:");
        for(WebElement element: courseAvailable) {
            System.out.println(element.getText());// print all the courses available
        }
        courseNameDropDown.selectByIndex(1);
        courseNameDropDown.selectByValue("net");
        courseNameDropDown.selectByVisibleText("Python");

        //prints first selected option
        System.out.println("First selected option is:");
        System.out.println(courseNameDropDown.getFirstSelectedOption().getText());

        //prints all selected options
        WebElement ideNameElement = driver.findElement(By.xpath("//select[@id='ide']"));
        Select ideNameDropDown = new Select(ideNameElement);
        ideNameDropDown.selectByIndex(1);
        Thread.sleep(5000);
        ideNameDropDown.selectByValue("nb");
        Thread.sleep(5000);
        List<WebElement> ideSelected = ideNameDropDown.getAllSelectedOptions();
        System.out.println("Selected options are:");
        for(WebElement element: ideSelected) {
            System.out.println(element.getText());
        }
        driver.quit();
        System.out.println("passed");
    }
}
