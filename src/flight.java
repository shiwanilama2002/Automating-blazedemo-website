package seleniumset;

import java.time.Duration;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flight {
	@Test
	public static void flightbook() throws InterruptedException {
		String url="https://blazedemo.com/";
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Select gen= new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
		gen.selectByVisibleText("Paris");
		Select gen1= new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
		gen1.selectByVisibleText("Buenos Aires");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//for blazedemo//reserve.phph
		driver.findElement(By.xpath("(//input[@type='submit'])[3]")).click();
		
		//filling up form for the flight
		String firstname="Shiwani";
		String address="Sitapaila";
		String city="Kathmandu";
		String state="Province 3";
		String zipcode="4033";
		String cid="076843445667";
		String cname="Shiwani Lama";
		
		driver.findElement(By.id("inputName")).sendKeys(firstname);
		driver.findElement(By.id("address")).sendKeys(address);
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys(city);
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys(state);
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys(zipcode);
		Select card= new Select(driver.findElement(By.xpath("//select[@id='cardType']")));
		card.selectByVisibleText("Diner's Club");
		driver.findElement(By.id("creditCardNumber")).sendKeys(cid);
		WebElement month = driver.findElement(By.xpath("//input[@id='creditCardMonth']"));
		month.clear();
		month.sendKeys("03");
		WebElement year = driver.findElement(By.xpath("//input[@id='creditCardYear']"));
		year.clear();
		year.sendKeys("2024");
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys(cname);
		driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".container.hero-unit")));
		
	//Thread.sleep(10000);
	driver.quit();
	}

}
