package flipkart;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartTest {
	
	@Test
	public void flipkartTest() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.Flipkart.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iphone11");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String actualProduct = driver.findElement(By.xpath("//div[text()='APPLE iPhone 11 (Black, 128 GB)']")).getText();
		driver.findElement(By.xpath("//div[text()='APPLE iPhone 11 (Black, 128 GB)']")).click();
		
		String parentid= driver.getWindowHandle();
		Set<String> allId=driver.getWindowHandles();
		for(String cid: allId)
		{
			if(!cid.equals(parentid))
			{
			driver.switchTo().window(cid);
			}
		}
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		
		String product=driver.findElement(By.xpath("//a[@class='_2Kn22P gBNbID']")).getText();
		if(product.equals(actualProduct))
			System.out.println("PASS");
		else
			System.out.println("FAIL");
		
		driver.quit();
	}

}
