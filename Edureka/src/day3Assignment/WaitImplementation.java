package day3Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitImplementation {
	static WebDriver driver;
	static WebElement element;

	public static void main(String[] args) throws InterruptedException {
		WaitImplementation w = new WaitImplementation();
		w.launchApp();
		w.search();
		w.closewindow();

	}

	public void launchApp() {

		String baseurl = "https://www.edureka.co";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vp192x\\workspace\\Jar Files\\libs\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseurl);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	public void search() throws InterruptedException {
		element = driver.findElement(By.id("homeSearchBar"));
		element.sendKeys("Selenium Certification Training");
		Thread.sleep(3000);
		element.sendKeys(Keys.ENTER);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement courseLink = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[.='Selenium Certification Training ']")));
		courseLink.click();

		String title = driver.getTitle();
		System.out.println(title);
		if (title.equals("Selenium 3.0 WebDriver Online Training")) {
			System.out.println("Title is matching");
		} else {
			System.out.println("Title is not matching");
		}

	}

	public void closewindow() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

}
