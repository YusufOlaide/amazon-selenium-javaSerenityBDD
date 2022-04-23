package com.org.clipboardHealth.pom.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrandDetailsPage extends BasePage{
	

	public BrandDetailsPage(WebDriver driver) {
		super(driver);
	}

	By brandDetails = By.xpath("//div[@id='feature-bullets']");
	By label = By.cssSelector("h1[class='a-size-base-plus a-text-bold']");
	By lists = By.cssSelector(".a-unordered-list.a-vertical.a-spacing-mini");
	By img = By.xpath("//div[@id='imgTagWrapperId']");

	
	public void tearDown() {
		driver.quit();
	}
	
	
	public void verifyBrandDetailsSection() {
	driver.findElement(brandDetails).isDisplayed();
	}
	
	public List<String> printBrandDetailsTexts() {
		List<WebElement> elements = driver.findElements(lists);
		List<String> texts = new ArrayList<>();
		for(int i = 0; i<elements.size();i++) {
			System.out.println(driver.findElement(label).getText());
		    System.out.println(elements.get(i).getText());
		    texts.add(elements.get(i).getText());
		}
		
		return texts; 
		
	}
	
	public void verifyBrandImg() {
	driver.findElement(img).isDisplayed();
	}

}
