package com.seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NavigationalMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//textarea[@id='APjFqb']"))
                .sendKeys("HYR Tutorials", Keys.ENTER);
        driver.navigate().to("https://www.facebook.com/");
        driver.findElement(By.xpath("//input[@id='email']"))
                .sendKeys("Shubhanshu Dubey");
        Thread.sleep(5000);
        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().forward();
        driver.quit();
        System.out.println("passed");
    }
}
