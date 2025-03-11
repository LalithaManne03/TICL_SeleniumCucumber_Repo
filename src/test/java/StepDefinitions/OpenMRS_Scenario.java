
package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import Base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpenMRS_Scenario {
	
	WebDriver driver = Base.driver;
	
	@Given("Launch Login page")
	public void launchLoginPage() {
		
	    
	    driver.get("https://o2.openmrs.org/openmrs/login.htm");
		driver.manage().window().maximize();
	    
	}

	
	@When("Enter username and password")
	public void enter_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.xpath("//li[@id='Inpatient Ward']")).click();
		driver.findElement(By.id("loginButton")).click();
	}
	
	@Then("User should be in Home Page")
	public void userLoggedIn() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverWait wdw=new WebDriverWait(driver,Duration.ofSeconds(40));

		WebElement logout = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a"));

	Assert.assertEquals(logout.getText(), "Logout");
		 
	}
	
	@When("Clicks on Register a patient")
	public void clicksRegisterPatient() {
	    driver.findElement(By.xpath("//a[@id='referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension']")).click();
	}
	@When("Enter Demographics")
	public void enter_demographics() {
	    driver.findElement(By.xpath("//input[@name='givenName']")).sendKeys("Bentex");
	    driver.findElement(By.xpath("//input[@name='familyName']")).sendKeys("Alpha");
	    driver.findElement(By.xpath("//button[@id='next-button']")).click();
	    
	    WebElement gender = driver.findElement(By.id("gender-field"));
	    Select gen = new Select(gender);
	    gen.selectByVisibleText("Female");
	    driver.findElement(By.xpath("//button[@id='next-button']")).click();
	    driver.findElement(By.xpath("//input[@id='birthdateDay-field']")).sendKeys("19");
	    WebElement month = driver.findElement(By.id("birthdateMonth-field"));
	    Select bmonth = new Select(month);
	    bmonth.selectByVisibleText("June");
	    driver.findElement(By.xpath("//input[@id='birthdateYear-field']")).sendKeys("1990");
	    driver.findElement(By.xpath("//button[@id='next-button']")).click();
	    
	}
	@When("Enter Contactinfo")
	public void enter_Contactinfo() {
		 driver.findElement(By.xpath("//input[@id=\"address1\"]")).sendKeys("Vihanga");
		 driver.findElement(By.xpath("//button[@id='next-button']")).click();
		 driver.findElement(By.xpath("//button[@id='next-button']")).click();
	}
	@When("Enter Relationships")
	public void enter_relationships() {
		driver.findElement(By.xpath("//button[@id='next-button']")).click();
	}


	@Then("Clicks on confirm patient is registered")
	public void confirmRegistration() {
		driver.findElement(By.id("submit")).click();
		
		WebDriverWait wdw=new WebDriverWait(driver,Duration.ofSeconds(40));
		wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"patient-header row \"]/div[2]/div/span")));
				
				boolean patientId =  driver.findElement(By.xpath("//*[@class=\"patient-header row \"]/div[2]/div/span")).isDisplayed();
				Assert.assertTrue("Patient Id should generate ", patientId);

	}

	@When("Clicks on Find Patient Record")
	public void clicks_on_find_patient_record() {
		driver.findElement(By.xpath("//a[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']")).click();
	}
	@When("Enter Search by Name")
	public void enter_search_by_name() {
	    driver.findElement(By.xpath("//input[@placeholder='Search by ID or Name']")).sendKeys("Bentex");
	}
	@When("Select Search Patient")
	public void select_search_patient() throws InterruptedException {
		WebElement moveMouse=driver.findElement(By.xpath("//*[@id='patient-search-results-table_wrapper']/table/tbody/tr[1]"));
		Actions ac=new Actions(driver);
		ac.moveToElement(moveMouse).click().perform();
		

	}
	@When("Clicks on Edit option")
	public void clicks_on_editOption() {
		
		driver.findElement(By.xpath("//span[@id='edit-patient-demographics']")).click();
	}
	@When("Update Patient name and Save")
	public void update_patient_name_and_save() {
	    driver.findElement(By.xpath("//input[@name='givenName']")).clear();
	    driver.findElement(By.xpath("//input[@name='givenName']")).sendKeys("BentexBeta");
	    driver.findElement(By.xpath("//a[@id='save-form']")).click();
	}
	@Then("Clicks on confirm patient record is updated")
	public void confirmUpdate() {
		driver.findElement(By.xpath("//button[@id='registration-submit']")).click();
		WebDriverWait wdw=new WebDriverWait(driver,Duration.ofSeconds(40));
		wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='PersonName-givenName']")));
				
				WebElement actual_updated_name =  driver.findElement(By.xpath("//span[@class='PersonName-givenName']"));
				Assert.assertEquals(actual_updated_name.getText(), "BentexBeta");
	}


}