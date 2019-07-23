package cucumber011;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import package01.UtilityClass;

public class StepDefinitionValidation {
  WebDriver driver;

    
    
	 @Given("^User must be in registration page$")
	  public void user_must_be_in_registration_page() throws Throwable {
		  driver = UtilityClass.startBrowser("chrome","http://10.232.237.143:443/TestMeApp/registration.htm");
	      //throw new PendingException();
	  }

	  

    @When("^Enter user credentials \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\"$")
    public void enter_user_credentials(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10) throws Throwable {
	  driver.findElement(By.name("userName")).sendKeys(arg1);
	  driver.findElement(By.name("firstName")).sendKeys(arg2);
	  driver.findElement(By.name("lastName")).sendKeys(arg3);
	  driver.findElement(By.name("password")).sendKeys(arg4);
	  driver.findElement(By.name("confirmPassword")).sendKeys(arg5);
	  driver.findElement(By.xpath("//input[@value='Female']")).click();
	  driver.findElement(By.name("emailAddress")).sendKeys(arg6);
	  driver.findElement(By.name("mobileNumber")).sendKeys(arg7);
	  driver.findElement(By.name("dob")).sendKeys(arg8);
	  driver.findElement(By.name("address")).sendKeys(arg9);
	  Select a=new Select(driver.findElement(By.id("securityQuestion")));
	  a.selectByIndex(1);
	  driver.findElement(By.id("answer")).sendKeys(arg10);
	  driver.findElement(By.name("Submit")).click();
      }
	  
	

	  @Then("^User registered successsfully$")
	  public void user_registered_successsfully() throws Throwable {

          WebDriverWait wait= new WebDriverWait(driver, 50);
          wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Login")));
          System.out.println("Registered Successfully !!");
          driver.close();
	  }
	  
	  @Given("^User must be in Login page$")
	  public void user_must_be_in_Login_page() throws Throwable {
		  driver = UtilityClass.startBrowser("chrome","http://10.232.237.143:443/TestMeApp/login.htm");
	      
	  }
	  
	  @When("^Enter \"([^\"]*)\" and \"([^\"]*)\" and click login$")
	  public void enter_and_and_click_login(String arg1, String arg2) throws Throwable {
		  driver.findElement(By.name("userName")).sendKeys(arg1);
		  driver.findElement(By.name("password")).sendKeys(arg2);
		  driver.findElement(By.name("Login")).click();
	      
	  }

	 
	  @Then("^User logged in successfully$")
	  public void user_logged_in_successfully() throws Throwable {
		  WebDriverWait wait= new WebDriverWait(driver, 50);
          wait.until(ExpectedConditions.presenceOfElementLocated(By.name("val")));
          System.out.println("Logged in Successfully !!");
          driver.close();
	  }
	  @Given("^User must be logged in$")
	  public void user_must_be_logged_in() throws Throwable {
		  WebDriverWait wait= new WebDriverWait(driver, 5000);
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.name("val")));
		  System.out.println("user is in search page");

	  }

	  @When("^Search for the product \"([^\"]*)\"$")
	  public void search_for_the_product(String arg1) throws Throwable {
		  driver = UtilityClass.startBrowser("chrome", "http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		  driver.findElement(By.id("myInput")).click();
		  driver.findElement(By.id("myInput")).sendKeys(arg1);
		  driver.findElement(By.name("val")).click();

	     
	  }
	  @Then("^The product entered is searched$")
	  public void the_product_entered_is_searched() throws Throwable {
		  WebDriverWait wait= new WebDriverWait(driver, 5000);
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btnbtn-success btn-product")));
		  System.out.println("Item displayed");
		  driver.close();

	  }

	  @Given("user registered into TestMeApp")
		public void user_registered_into_TestMeApp() {
		   
		  driver = UtilityClass.startBrowser("chrome","http://10.232.237.143:443/TestMeApp/login.htm");
		  driver.findElement(By.name("userName")).sendKeys("Lalitha");
		  driver.findElement(By.name("password")).sendKeys("Password123");
		  driver.findElement(By.name("Login")).click();			
		}

		//@When("user search a particular product like headphones")
		//public void user_search_a_particular_product_like_headphones() {
		//	driver.findElement(By.xpath("//span[contains(text(),'All')]")).click();
		//	driver.findElement(By.xpath("//span[contains(text(),'Electronics')]")).click();
		//	driver.findElement(By.xpath("//span[contains(text(),'Head Phone')]")).click();
		//	driver.findElement(By.xpath("//a[@class='btn btn-success btn-product']")).click();
		//	driver.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
		//}
	  
	    @When("user search a particular product like headphones")
		public void user_search_a_particular_product_like_headphones() {
	    	driver.findElement(By.id("myInput")).click();
	 	   driver.findElement(By.id("myInput")).sendKeys("Headphone");
	 	   driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
	 	   driver.findElement(By.linkText("Add to cart")).click();
	 	   driver.findElement(By.partialLinkText("Cart")).click();
         
	    }
		@Then("TestMeApp doesnt display cart icon")
		public void testmeapp_doesnt_display_cart_icon() {
		    if(driver.getCurrentUrl().equalsIgnoreCase("http://192.168.40.4:8083/TestMeApp1/displayCart.htm"))
		    {
		    	System.out.println("fail");
		    }
		    else
		    {
		    	System.out.println("pass");
		    }
		//driver.close();
		}
	  

	  
	
	  
	  
	  
  
}
