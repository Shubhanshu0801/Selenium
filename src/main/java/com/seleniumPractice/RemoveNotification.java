package com.seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RemoveNotification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //Many ways to do this
        //we can pass String[] object or Collections object
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});//1
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));//2
        options.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));//3
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));//4
        //5
        List<String> eSwitches = new ArrayList<>();
        eSwitches.add("enable-automation");
        options.setExperimentalOption("excludeSwitches", eSwitches);
        options.setExperimentalOption("useAutomationExtension", false);//6

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
