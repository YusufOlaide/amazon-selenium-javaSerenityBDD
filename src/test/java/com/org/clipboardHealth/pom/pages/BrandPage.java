package com.org.clipboardHealth.pom.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrandPage extends BasePage{
	public BrandPage(WebDriver driver) {
		super(driver);
	}

	By samsung = By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='Samsung']");
	By sortBy = By.xpath("//span[@data-action='a-dropdown-button']");
	By sortOption = By.cssSelector("ul[role='listbox']");
	By item = By.xpath("//img[@data-image-index='2']");
	
	public void filterBySamsung() {
	driver.findElement(samsung).isDisplayed();
	driver.findElement(samsung).click();
	}
	
	public void sortResults() {
	driver.findElement(sortBy).isDisplayed();
	driver.findElement(sortBy).click();
	}
	
	public void clickOnSortOption() {
		List<WebElement> elements = driver.findElements(sortOption);
		for(int i = 0; i<elements.size();i++) {
			if(elements.get(i).getText().contains("Price: High to Low")) {
				elements.get(i).click();
			}
		}
	}
	
	public void clickOnItem() {
	driver.findElement(item).isDisplayed();
	driver.findElement(item).click();
	}
	
	public void navigate() {
        String base = driver.getWindowHandle();
        Set<String> tabs = driver.getWindowHandles();
        Iterator<String> iterator = tabs.iterator();

        while (iterator.hasNext()) {
            String subWindow = iterator.next();
                if (!base.equalsIgnoreCase(subWindow)) {
                driver.switchTo().window(subWindow);
                break;
              
            }
        }
    }


}
