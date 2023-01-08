package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver driver;

    public WebDriver init_driver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            tlDriver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("firefox")) {
            tlDriver.set(new FirefoxDriver());
        } else if (browserName.equalsIgnoreCase("edge")) {
            tlDriver.set(new EdgeDriver());
        }
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
