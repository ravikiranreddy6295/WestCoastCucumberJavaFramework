package PageClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class YourFlightToNewYorkPage {

	WebDriver driver;
	
	public YourFlightToNewYorkPage(WebDriver driver) {
		this.driver= driver;
	}
	
	//validations
	By actualStartDate= By.xpath("(//div[@class='css-17qtwxq']//div)[3]");
	
	By actualEndDate= By.xpath("(//div[@class='Text-module__root--variant-small_2___Db1tb css-15jxk80'])[3]");

	By expectedTime= By.xpath("(//div[@data-testid='timeline_location_timestamp_departure'])[1]");
	By actualTime= By.xpath("(//div[@data-testid='flight_card_segment_departure_time_0'])[2]");
	
	By expectedPrice= By.xpath("(//div[@class='css-vxcmzt'])[2]");
	By actualPrice= By.xpath("(//div[text()='Total price for all travellers'])[16]//preceding-sibling::div//h2//div");

	//select
	By select= By.xpath("(//div[@class='css-95bx75']//button)[2]");
	
	//verify price in London to newyork page
	By price= By.xpath("//div[@data-testid='breakdown_list_text']/following-sibling::div[1]");


	
	public void verifyStartDate() {
		 String expectedStartDate = "Mon 31 Jul";
         String actual = driver.findElement(actualStartDate).getText();
         if (actual.contains(expectedStartDate))
             System.out.println("Test passed");
         else
             System.out.println("Test Failed");
	}
	
	public void verifyReturnDate() {
		String expectedEndDate = "Thu 17 Aug";
        String actualEDate = driver.findElement(actualEndDate).getText();
        if (actualEDate.contains(expectedEndDate))
            System.out.println("Test passed");
        else
            System.out.println("Test Failed");
	}
	
	public void verifyFlightTime() {
		String expected = driver.findElement(expectedTime).getText();
        String actualT = driver.findElement(actualTime).getText();
        String expectedT=expected.substring(13,18);
        Assert.assertEquals(actualT,expectedT);
	}
	
	public void verifyPrice() {
		 
        String expectedP= driver.findElement(expectedPrice).getText();
        String actualP = driver.findElement(actualPrice).getText();
        Assert.assertEquals(actualP,expectedP);
	}
	
	public void select() {
		driver.findElement(select).click();
	}
	
	public void verifyPriceLondonToNewyork() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
         WebElement cost= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='breakdown_list_text']/following-sibling::div[1]")));
         String actualC = cost.getText();
         String expectedC= "68";
         if (actualC.contains(expectedC))
             System.out.println("Test passed");
         else
             System.out.println("Test Failed");
	}
	
}
