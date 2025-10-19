package authentication;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SignUp {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.edge.driver",
				"C:\\Program Files\\MyNewChromeWebDriver\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		String userName = "standard_user";
		String pass = "secret_sauce";
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(userName);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pass);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#login-button")).click();
		Thread.sleep(3000);
		
		 //اوجد جميع العناصر التي لها نقس الكلاس 
		List<WebElement> buttons = driver.findElements(By.className("btn_primary"));
		int expectedResult = 6;
		int actualresult = buttons.size();
		Assert.assertEquals(actualresult, expectedResult);

		//التحقق من عدد الازرار 
		//System.out.println(actualresult);
		//للضغط على جميع الازرار 
		for(int i =0;i<buttons.size();i++)
		{
			buttons.get(i).click();
		}
		
		TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Step 5: Define destination file
        File destination = new File("C:\\Users\\Ehab\\eclipse-workspace-Ehab\\screenshot.png");
        
        FileUtils.copyFile(source, destination);

		
		
		
		
		
	}

}
