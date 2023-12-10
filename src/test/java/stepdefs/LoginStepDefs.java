package stepdefs;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {

	WebDriver driver = BaseClass.driver;

	@Given("I have launched the application URL")
	public void i_have_launched_the_application_URL() {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://simplilearn.com");
	}

	@And("I click on the Login link")
	public void i_click_on_the_Login_link() {
		// Write code here that turns the phrase above into concrete actions
		WebElement loginLink = driver.findElement(By.linkText("Log in"));
		loginLink.click();
	}

	@When("I enter the username")
	public void i_enter_the_username() {
		// Write code here that turns the phrase above into concrete actions
		WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys("naidushobharani@gmail.com");

	}

	@When("I enter the password")
	public void i_enter_the_password() {
		// Write code here that turns the phrase above into concrete actions
		WebElement Password = driver.findElement(By.name("user_pwd"));
		Password.sendKeys("Vaishnavi26");
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		// Write code here that turns the phrase above into concrete actions
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		LoginBtn.click();

	}

	@Then("I should land on the home page")
	public void i_should_land_on_the_home_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("I enter the username as {string}")
	public void i_enter_the_username_as(String UserNameVal) {
		// Write code here that turns the phrase above into concrete actions
		WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys(UserNameVal);
	}

	@When("I enter the password as {string}")
	public void i_enter_the_password_as(String PasswordVal) {
		// Write code here that turns the phrase above into concrete actions
		WebElement Password = driver.findElement(By.name("user_pwd"));
		Password.sendKeys(PasswordVal);
	}

	@Then("I should get the Error Msg {string}")
	public void i_should_get_the_Error_Msg(String expError) {
		// Write code here that turns the phrase above into concrete actions
		WebElement Error = driver.findElement(By.className("error_msg"));
		String ActError = Error.getText();
		Assert.assertEquals(expError, ActError);

	}

	@Then("I should see below login options on the screen")
	public void i_should_see_below_login_options_on_the_screen(List<String> Options) {
		for (String option : Options) {
			WebElement LoginOption = driver.findElement(By.xpath("//button[@data-clickedtype='" + option + "']"));
			Assert.assertTrue(LoginOption.isDisplayed());

		}
	}

}
