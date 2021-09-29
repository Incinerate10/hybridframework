package CucumberOptions;

import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.mindtree.PageObjects.HomepagePageObjects;
import com.mindtree.Reusable.Getdriver;
import com.mindtree.Utilities.screenshot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class LoginStepDefinations extends Getdriver {
	private static Logger log = LogManager.getLogger(LoginStepDefinations.class.getName());
	String url = "https://www.urbanladder.com";
	JavascriptExecutor js = (JavascriptExecutor) driver;
	HomepagePageObjects hp = new HomepagePageObjects(driver);
	@Given("driver is intialised")
	public void driver_is_intialised() throws Exception {
		PropertyConfigurator.configure("files\\log4j.properties");
		driver = getdrivertype();
		driver.manage().window().maximize();
		log.info("driver is initialized");
		screenshot.takeSnapShot(driver);
		}
	
	@Given("url {string} is entered")
	public void url_is_entered(String url) throws Exception {
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		log.info("Driver initialised");
		log.info(url);
		screenshot.takeSnapShot(driver);
		}
	/*@Given("wait 10s")
	public void delay() {
		driver.manage().timeouts().implicitlyWait(10, seconds);
		
	}*/
	@When("^wait for few seconds and enter the login credentials$")
	
	public void wait_for_few_seconds_and_enter_the_login_credentials() throws Exception {
		HomepagePageObjects hp = new HomepagePageObjects(driver);
		hp.username().sendKeys("fasdfsfas@gmail.com");
		hp.password().sendKeys("demo1234");
		hp.password().sendKeys(Keys.ENTER);
		log.info("signup successful");
		screenshot.takeSnapShot(driver);
	  }
	
/*	@Then("^click on login in$")
	public void click_on_login_in() {
		String Title = "Furniture Online: @Upto 40% Off on Wooden Furniture Online in India at Best Price - Urban Ladder";
		Assert.assertEquals(Title, "Furniture Online: @Upto 40% Off on Wooden Furniture Online in India at Best Price - Urban Ladder\r\n" );
		
	  }
/*	@Then("^quit$")
	public void quit() {
		driver.quit();
	   }*/
	//2
	@When("^profile is clicked and profie page is loaded$")
	public void profile_is_clicked_and_profie_page_is_loaded() throws Exception {
		HomepagePageObjects hp = new HomepagePageObjects(driver);
		hp.Icon().click();
		hp.profileButton().click();
		hp.editButton().click();
		hp.customerName().sendKeys("User1");
		hp.customerMobile().sendKeys("9889912311");
		hp.updateButton().click();
		screenshot.takeSnapShot(driver);
		log.info("Profile updated");

	}
	/*@Then("^edit the profile with {string} and {string}$")
	public void edit_the_profile_with_and(String username, String phonenumber) {

	}*/
	//3
	@When("^stores is clicked$")

	public void stores_is_clicked() throws Exception {
		hp.storeButton().click();
		hp.viewDetails().click();
		screenshot.takeSnapShot(driver);
		log.info("Stores viewed");

	}
/*	@Then("^stores page is opened and get the details$")
	public void stores_page_is_opened_and_get_the_details() {
		log.info("Stores searched");
	}*/
	//4
	@When("^customer stories is clicked$")
	public void customer_stories_is_clicked() throws Exception {

		js.executeScript("window.scrollBy(0,1010)");
		hp.viewCustomerstories().click();
		screenshot.takeSnapShot(driver);
		log.info("Kondapur store found");
	}
/*	@Then("^customer needs page is opened$")
	public void customer_needs_page_is_opened() {
		System.out.println("Hey I'm Working!!!");
		driver.quit();
		//lets write validation here
		//iseqauls(expected,actual)
	}*/
	//5
	@When("^About the company is clicked$")
	public void about_the_company_is_clicked() throws Exception {
		HomepagePageObjects hp = new HomepagePageObjects(driver);
		js.executeScript("window.scrollBy(0,2000)");
		hp.aboutUs().click();
		screenshot.takeSnapShot(driver);
		log.info("About company viewed");
	}
/*	@Then("^About the company page is opened$")
	public void about_the_company_page_is_opened() {
		HomepagePageObjects hp = new HomepagePageObjects(driver);
		//lets write validation here
		//iseqauls(expected,actual)
	}*/
	//6
	@When("lights are searched")
	public void lights_are_searched() throws Exception {
		HomepagePageObjects hp = new HomepagePageObjects(driver);
		hp.search().sendKeys("sofas");
		hp.search().sendKeys(Keys.ENTER);
		Actions a = new Actions(driver);
		WebElement option = hp.sorting();
		WebElement sortlst = hp.viewNewarrivals();
		a.moveToElement(sortlst).perform();
		a.moveToElement(option).click().build().perform();
		screenshot.takeSnapShot(driver);
		log.info("Search performed");
		}
/*	@Then("click on the required light")
	public void click_on_the_required_light() {
		HomepagePageObjects hp = new HomepagePageObjects(driver);
		
	}*/
	//7
	@When("^light is shown and click on add cart$")
	public void light_is_shown_and_click_on_add_cart() throws Exception {
		Thread.sleep(1000);
		HomepagePageObjects hp = new HomepagePageObjects(driver);
		hp.selectProduct().click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    hp.addToCart().click();
		screenshot.takeSnapShot(driver);
		log.info("Added to cart");
		}
	//8
	@When("^lights page is opened and check for EMI$")
	public void lights_page_is_opened_and_check_for_emi() throws Exception {
		HomepagePageObjects hp = new HomepagePageObjects(driver);
		hp.emiOption().click();
		screenshot.takeSnapShot(driver);
		hp.close().click();
		hp.Logo().click();
		log.info("EMI options displayed");

			}
	//9
	@When("^enter <email> by username$")
	public void enter_email_by_username() throws Exception {
		Thread.sleep(10000);
		HomepagePageObjects hp = new HomepagePageObjects(driver);
		hp.emailBox().sendKeys("asfedf2ft8q7@gmail.com");
		hp.emailBox().sendKeys(Keys.ENTER);
		screenshot.takeSnapShot(driver);
		log.info("giveaway subscribed");

		}
	//10
	@When("^click logout$")
	public void click_logout() throws Exception {
		Thread.sleep(10000);
		HomepagePageObjects hp = new HomepagePageObjects(driver);
		hp.Icon().click();
		hp.logoutButton().click();
		screenshot.takeSnapShot(driver);
		log.info("Logout successfull");

		driver.quit();
	}
}
