package com.org.clipboardHealth.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.CP;

public class DriverManager {
	WebDriver driver;
	public WebDriver initialize() {
		CP property = new CP();
		String browser = property.getObjectRepository().getProperty("browser");
		switch (browser){
        case "Chrome":
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            break;
        case "Firefox":
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            break;
        case "Edge":
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            break;
        default:
            throw new IllegalStateException("Invalid browser name: "+ browser);
    }
		driver.manage().window().maximize();
		return driver;
		
	}

}
