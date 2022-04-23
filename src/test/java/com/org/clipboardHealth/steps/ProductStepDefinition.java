package com.org.clipboardHealth.steps;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.org.clipboardHealth.pom.pages.BrandDetailsPage;
import com.org.clipboardHealth.pom.pages.BrandPage;
import com.org.clipboardHealth.pom.pages.DriverManager;
import com.org.clipboardHealth.pom.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import utils.CP;


public class ProductStepDefinition {
	
	HomePage homePage;
	BrandPage brandPage;
	BrandDetailsPage brandDetailsPage;
	CP property = new CP();
	@Managed                                                            
    WebDriver driver;
	
	@Given("^User is on Amazon home page$")
	public void userIsOnAmazonHomePage() throws IOException {
		driver = new DriverManager().initialize();
		homePage= new HomePage(driver);
		brandPage= new BrandPage(driver);
		brandDetailsPage = new BrandDetailsPage(driver);
		homePage.navigateToHomePage();
	}
	
	@And("^User clicks on the hamburger menu$")
	public void userClicksOnTheHamburgerMenu() throws IOException, InterruptedException {
		Thread.sleep(5000);
		homePage.clickOnHamburger();
	}
	
	@And("^User shops by department$")
	public void userShopsByDepartment() throws IOException, InterruptedException {
		Thread.sleep(5000);
		homePage.clickOnDeptOption();
	}
	
	@And("^User selects televisions option$")
	public void userSelectsTelevisionsOption() throws IOException {
		String tv = homePage.verifyTVOption();
		Assert.assertEquals(tv, property.getObjectRepository().getProperty("tv"));
		homePage.clickOnTVOption();
		String url = homePage.verifyTVPageURL();
		Assert.assertEquals(url, property.getObjectRepository().getProperty("tvURL"));
	}
	
	@When("^User filters brands by Samsung$")
	public void userFiltersBrandsBySamsung() throws InterruptedException {
		Thread.sleep(5000);
		brandPage.filterBySamsung();
	}
	
	@And("^User filters results from High to Low prices$")
	public void userFiltersResultsFromHighToLowPrices() throws IOException, InterruptedException {
		brandPage.sortResults();
		brandPage.clickOnSortOption();
		Thread.sleep(5000);
	}
	
	@And("^User selects second highest priced item$")
	public void userSelectsSecondHighestPricedItem() throws IOException {
		brandPage.clickOnItem();
		brandPage.navigate();
	}
	
	@Then("^User should be shown the corresponding product page$")
	public void userShouldBeShownTheCorrespondingProductPage() throws IOException {	
		brandDetailsPage.verifyBrandImg();
	}
	
	@And("^About this item section should be present$")
	public void aboutThisItemSectionShouldBePresent() {
		brandDetailsPage.printBrandDetailsTexts();
		brandDetailsPage.tearDown();
	}
	
}
