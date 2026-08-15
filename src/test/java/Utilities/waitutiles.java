package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitutiles {

	public static WebElement waitForElement(WebDriver driver, By locator) {

		
	    System.out.println("Thread = " + Thread.currentThread().getId());
	    System.out.println("Driver = " + driver);
	    System.out.println("Locator = " + locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
