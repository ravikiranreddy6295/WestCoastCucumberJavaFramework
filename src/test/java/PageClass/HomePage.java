package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import PropertiesFile.ReadConfigFile;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
	}
	
	//source
	By source= By.xpath("(//button[@class='css-1ovag24'])[1]");
	By cancelSource= By.xpath("(//span[@class='css-rh2lq6']/following-sibling::span)[1]");
	By selectSource= By.xpath("//input[@placeholder='Airport or city']");
	By finaliseSource= By.xpath("(//span[@class='css-3cj1dx']//span)[1]");
	
	//destination
	By destination= By.xpath("(//button[@class='css-1ovag24'])[2]");
	By selectDestination= By.xpath("//div[@class='css-3y0hds']//input[1]");
	By finaliseDestination= By.xpath("(//span[@class='css-3cj1dx']//span)[1]");
	
    //Start date and end date
	By date= By.xpath("(//button[@class='css-1ovag24'])[3]");
	By startDate= By.xpath("(//span[@aria-label='31 July 2023']//span)[2]");
	By next= By.xpath("(//div[@data-ui-name='calendar_body']//button)[2]");
	By endDate= By.xpath("(//span[@aria-label='17 August 2023']//span)[2]");
	
	//search
	By search= By.xpath("//button[@data-ui-name='button_search_submit']");

	ReadConfigFile configFile=new ReadConfigFile();

	public void source() {
        driver.findElement(source).click();
        driver.findElement(cancelSource).click();
        driver.findElement(selectSource).sendKeys(configFile.getSource());
        driver.findElement(finaliseSource).click();
	}
	
	public void destination() {
		 driver.findElement(destination).click();
	     driver.findElement(selectDestination).sendKeys(configFile.getDestination());
	     driver.findElement(finaliseDestination).click();
	}
	
	public void startEndDate(){	
		 driver.findElement(date).click();
	     driver.findElement(startDate).click();
	     driver.findElement(next).click();
         driver.findElement(next).click();
         driver.findElement(endDate).click();      
	}
	
	public void search() {
		driver.findElement(search).click();
	}

}