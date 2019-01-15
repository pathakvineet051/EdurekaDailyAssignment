package day2Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchEdureka {

	WebDriver driver;
	WebElement element;

	public static void main(String[] args) throws InterruptedException {
		LaunchEdureka e = new LaunchEdureka();
		e.launchApp();
		e.findElement();
		e.searchElement();
		e.closewindow();
	}

	public void launchApp() {

		String baseurl = "https://www.edureka.co";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vp192x\\workspace\\Jar Files\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(baseurl);
	}

	public void searchElement() throws InterruptedException {
		element = driver.findElement(By.xpath("//input[@id=\"homeSearchBar\"]"));
		System.out.println("ID of Search Box: " + element.getAttribute("id"));
		System.out.println("Name of Search Box: " + element.getAttribute("Name"));
		System.out.println("Class Names of Search Box: " + element.getClass());

		// Retrive all CSS values
		System.out.println("CSS Values of Search Box :" + element.getAttribute("style"));

		// Retrive color of search box using getCss
		System.out.println("CSS Values :" + element.getCssValue("color"));

		Thread.sleep(3000);
		WebElement loginlink = driver.findElement(By.linkText("Log In"));
		loginlink.click();
		loginlink.sendKeys(Keys.ESCAPE);

	}

	public void closewindow() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

	public void findElement() {
		System.out.println("find by ID");
		element = driver.findElement(By.id("homeSearchBar"));
		element.sendKeys("DevOps Certification Training");
		element.sendKeys(Keys.ENTER);

		System.out.println("find element by Xpath");
		element = driver.findElement(By.xpath("//div[@class='heading_bread']//a[text()='Home']"));
		element.click();

		System.out.println("Find element by Name");

	}
}
