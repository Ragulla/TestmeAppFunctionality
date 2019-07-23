package package01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UtilityClass {
	static WebDriver driver;

	 public static WebDriver startBrowser(String browsername,String url)
	 {
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Training_c2a.05.01\\Desktop\\chromedriver.exe");
	   driver= new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
	   return driver;
	  }


}
