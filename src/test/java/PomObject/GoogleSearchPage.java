package PomObject;

import java.time.Duration;

import org.apache.logging.log4j.core.appender.rolling.action.IfAccumulatedFileCount;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage {
	
	WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver,this);

}
    
    @FindBy(name="q")
	WebElement GoogleBar;
    
    
    public void EnterTheSearch(String Search) throws InterruptedException {
    	GoogleBar.click();
    	GoogleBar.clear();
    	Thread.sleep(1000);
    	GoogleBar.sendKeys(Search);
    	GoogleBar.sendKeys(Keys.ENTER);
    }
    
    public void validateThesearch() {
    	
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Liquid detergent']")));
    	
    	WebElement SearchResult=driver.findElement(By.xpath("//span[text()='Liquid detergent']"));
    	if(SearchResult!=null) {
    		System.out.println("Search Result displayed successfully");
    		Assert.assertTrue(true);
    	}
    	else {
    		System.out.println("Search Result displayed successfully");
    		Assert.assertTrue(false);
    	}
    }
    
    public void getthelinks() {
    	int amazonCount = driver.findElements(By.partialLinkText("Amazon")).size();
        int flipkartCount = driver.findElements(By.partialLinkText("Flipkart")).size();
        
        System.out.println("Amazon links: " + amazonCount);
        System.out.println("Flipkart links: " + flipkartCount);
    }
    
    public void clickingonWebsite(String website) throws InterruptedException {
    	
    	Thread.sleep(3000);
    	System.out.println("The Website is :" +website );
    	WebElement link = driver.findElement(By.partialLinkText(website));
        link.click();
        
     // Validate title
        String title = driver.getTitle();
        System.out.println(website + " Title: " + title);

        // Validate number of results
       // WebElement results = driver.findElement(By.id("resultStats"));
        
      
        
        
        if(website.equals("Amazon")) {
        	System.out.println("The Amazon link is clicked");
        WebElement results = driver.findElement(By.xpath("//span[contains(text(),'LG 8 Kg 5 Star Inverter ')]"));
        String resultsText = results.getText();
        String[] splitResults = resultsText.split(" ");
        int count = Integer.parseInt(splitResults[1].replace(",", ""));
        System.out.println(website + " Results Count: " + count);

        // Go back to search results page
        driver.navigate().back();
        }
        
        else {
        	System.out.println("The flipkart link is clicked");
        	 WebElement results = driver.findElement(By.xpath("//div[contains(text(),'Godrej 7 kg 5 Star With Rain Shower Spin Washing ')]"));
             String resultsText = results.getText();
             String[] splitResults = resultsText.split(" ");
             int count = Integer.parseInt(splitResults[1].replace(",", ""));
             System.out.println(website + " Results Count: " + count);

             // Go back to search results page
             driver.navigate().back();
        	
        }
    }
    
    

   
    }
	

