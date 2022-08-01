import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class windowManagement {
  WebDriver driver;

  @BeforeTest
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("http://automationpractice.com/index.php");
    System.out.println("Title: " + driver.getTitle());
  }

  @AfterTest
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void getRect() {
    WebElement logo = driver.findElement(By.cssSelector("#header_logo img"));
    Rectangle rectLogo = logo.getRect();
    System.out.println("x: " + rectLogo.getX());
    System.out.println("y: " + rectLogo.getY());
    System.out.println("Width: " + rectLogo.getWidth());
    System.out.println("Height: " + rectLogo.getHeight());
  }
}
