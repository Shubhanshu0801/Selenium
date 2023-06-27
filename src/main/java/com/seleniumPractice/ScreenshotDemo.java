package com.seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;

public class ScreenshotDemo {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        //Three ways of taking screenshot
        //1. Here Output type is File
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./Screenshots/Image1.png"));
        System.out.println("passed");

        //2. Output type is byte64
        String base64Code = takesScreenshot.getScreenshotAs(OutputType.BASE64);
        //We have to convert this file into byte[]- for this we use Base64 class
        //Base64 class is Available in java
        byte[] byteArray = Base64.getDecoder().decode(base64Code);
        FileOutputStream fos1 = new FileOutputStream("./Screenshots/Image2.jpeg");
        fos1.write(byteArray);
        fos1.close();
        System.out.println("passed");

        //Output type is bytes
        byte[] byteArr = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        FileOutputStream fos2 = new FileOutputStream("./Screenshots/Image3.jpg");
        fos2.write(byteArr);
        fos2.close();
        System.out.println("passed");

        //For taking screenshot we should create a separate method in Utility class.
        //Taking screenshot using Utility class
        Utility.captureScreenshot(driver, "Img.png");
        driver.quit();
        System.out.println("passed");
    }
}
