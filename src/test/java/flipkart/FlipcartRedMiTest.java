package flipkart;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipcartRedMiTest {
	
	@Test
	public void flipcartReadMiTest()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.Flipkart.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("redMi");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		List<WebElement> elements = driver.findElements(By.xpath("//li[contains(text(),'4 GB RAM')]"));
		
		for(WebElement element:elements)
		{
			System.out.println(element.getText());
		}
		
	}

}
