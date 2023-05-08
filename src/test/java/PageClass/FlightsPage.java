package PageClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FlightsPage {

	WebDriver driver;
	
	public FlightsPage(WebDriver driver) {
		this.driver= driver;
	}
	
	//click on fastest
	By fastest= By.xpath("(//li[@class='Tab-module__item___t3KVI']//button)[3]");
	
	//click on see flight
	By seeFlight= By.xpath("(//div[@class='css-1niqckn']/following-sibling::button)[2]");

	
	public void fastest() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[@class='Tab-module__item___t3KVI']//button)[3]")));
        driver.findElement(fastest).click(); 
	}
	
	public void seeFlight() {
		driver.findElement(seeFlight).click();
	}

}
