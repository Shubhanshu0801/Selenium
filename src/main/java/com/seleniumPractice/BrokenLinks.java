package com.seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.*;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BrokenLinks {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        Set<String> brokenLinkUrls = new HashSet<>();
        for(WebElement link: links) {
            String linkURL = link.getAttribute("href");
            Proxy proxy = new Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress("hostname", 8080));
            URL url = new URL(linkURL);
            URLConnection urlConnection = url.openConnection(proxy);
            HttpURLConnection httpURLConnection = (HttpURLConnection)urlConnection;
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.connect();
            //Other than 200 url is invalid.
            if(httpURLConnection.getResponseCode() != 200) {
                brokenLinkUrls.add(linkURL);
            }
        }
        driver.quit();
        for (String brokenUrl: brokenLinkUrls) {
            System.err.println(brokenUrl);
        }
    }
}
