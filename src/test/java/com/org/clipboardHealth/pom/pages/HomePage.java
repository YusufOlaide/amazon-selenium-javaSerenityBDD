package com.org.clipboardHealth.pom.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
	public HomePage(WebDriver driver) {
		super(driver);
	}


	By hamburger = By.xpath("//a[@id='nav-hamburger-menu']");
	By dept = By.xpath("//div[contains(text(),'TV, Appliances, Electronics')]");
	By tv = By.xpath("//a[contains(text(),'Televisions')]");

	public void navigateToHomePage() {
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	
	public void clickOnHamburger() {
		driver.findElement(hamburger).isDisplayed();
		driver.findElement(hamburger).click();
	}
		
	public String verifyDepartment() {
		return driver.findElement(dept).getText();
	}
	
	public void clickOnDeptOption() {
		driver.findElement(dept).click();
	}
	
	public String verifyTVOption() {
		driver.findElement(tv).isDisplayed();
		return driver.findElement(tv).getText();
	}
	
	public void clickOnTVOption() {
		driver.findElement(tv).click();
	}
	
	public String verifyTVPageURL() {
		return driver.getCurrentUrl();
	}

}
