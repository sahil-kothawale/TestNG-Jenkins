package com.ui.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;
import com.ui.Models.FlightSearch;
import com.ui.Utilities.Waits;

public class UITestScenarios{

	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	public static WebDriver driver() {
		return tlDriver.get();
	}
	
	@DataProvider (name = "flightSearchData")
	public Object[][] flightSearchData() {
		return new Object[][] {
			{new FlightSearch("Mumbai", "Pune")}
		};
	}
	
	@BeforeMethod(alwaysRun = true)
	public void SetUp() {
		WebDriver driver = new ChromeDriver();
		tlDriver.set(driver);
		driver().manage().window().maximize();
	}
	
	@Test (groups = {"regression"})
	public void visitAmazonSiteTest() {
		driver().get("https://www.amazon.in/");
		//assert driver.getTitle().contains("Online Shopping site in India");
		//assert driver.getCurrentUrl().equals("amazon.in");
	}
	
	@Test (groups = {"regression"})
	public void visitFlikartSiteTest() {
		driver().get("https://www.flipkart.com/");
		By searchBarLocator = By.xpath("//*[contains(@class,'form-search')]//input[contains(@placeholder,'Search')]");
		new Waits(driver()).waitUntilElementIsVisible(searchBarLocator);
		Assert.assertTrue(driver().getTitle().contains("Online Shopping Site"));
		Assert.assertEquals(driver().getCurrentUrl(), "https://www.flipkart.com/");
	}
	
	@Test(dataProvider = "flightSearchData", groups = "regression")
	public void flipkartFlightBookTest(FlightSearch fs) {
		driver().get("https://www.flipkart.com/");
		By searchBarLocator = By.xpath("//*[contains(@class,'form-search')]//input[contains(@placeholder,'Search')]");
		new Waits(driver()).waitUntilElementIsVisible(searchBarLocator);
		WebElement flipKartBookingsIcon = driver().findElement(By.xpath("//*[text()='Flight Bookings']"));
		flipKartBookingsIcon.click();
	}
	
	@Test (groups = {"regression", "smoke"}, invocationCount = 2)
	public void visitYoutubeSiteTest() {
		driver().get("https://www.youtube.com/");
		By searchBarLocator = By.xpath("//*[@id='container']//*[@role='search']//input");
		new Waits(driver()).waitUntilElementIsVisible(searchBarLocator);
		Assert.assertTrue(driver().getTitle().contains("YouTube"));
		Assert.assertEquals(driver().getCurrentUrl(), "https://www.youtube.com/");
	}
	
	@Test (groups = {"regression", "smoke"})
	public void visitCricBuzzSiteTest() {
		driver().get("https://www.cricbuzz.com/");
		By navBarLocator = By.xpath("//img[@title='Cricbuzz Logo']/ancestor::nav");
		new Waits(driver()).waitUntilElementIsVisible(navBarLocator);
		Assert.assertTrue(driver().getTitle().contains("India tour of England"));
		Assert.assertEquals(driver().getCurrentUrl(), "https://www.cricbuzz.com/");
	}
	
	@AfterMethod(alwaysRun = true)
	public void TearDown() {
		driver().quit();
		tlDriver.remove();
	}
	
}
