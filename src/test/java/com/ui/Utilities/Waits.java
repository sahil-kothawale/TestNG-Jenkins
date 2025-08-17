package com.ui.Utilities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	
	private WebDriver driver;
	public Waits(WebDriver driver) {
		this.driver = driver;
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public void waitUntilElementIsVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
	}
}
