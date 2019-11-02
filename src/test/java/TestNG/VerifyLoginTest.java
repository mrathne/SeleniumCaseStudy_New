package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyLoginTest {
  ChromeDriver driver;
  
  @BeforeMethod
  public void launch(){
	  	  System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:3001");
		driver.manage().window().maximize();
  }
  
  @Test
  public void verifyLogin() {

		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.name("login")).sendKeys("selenium");
		driver.findElement(By.name("password")).sendKeys("selenium");
		driver.findElement(By.name("click")).click();

		
		String result = driver.findElement(By.name("hello")).getText();
		
		//System.out.println("The reslult is " + result);
		
		Assert.assertEquals(result, "Login Failed!");

  }
  @AfterMethod
  public void close(){
	  driver.close();
  }
}
