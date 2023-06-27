package com.seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesDemo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setAcceptInsecureCerts(true);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.merge(capability);
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://www.cacert.com");
    }
}
