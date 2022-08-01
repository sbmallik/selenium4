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
  public void testNewWindowTab() {
    WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW);
    newWindow.get("http://automationpractice.com/index.php?controller=prices-drop");
    System.out.println("Title: " + driver.getTitle());
  }

  @Test
  public void testWorkingInBothWindowTabs() {
    driver.switchTo().newWindow(WindowType.TAB)
        .get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    System.out.println("Title: " + driver.getTitle());

    driver.findElement(By.cssSelector("#email_create")).sendKeys("selenium4@gannett.com");
    driver.findElement(By.cssSelector("#SubmitCreate")).click();

    Set<String> allWindowTabs = driver.getWindowHandles();
    Iterator<String> iterate = allWindowTabs.iterator();
    String firstWindow = iterate.next();

    driver.switchTo().window(firstWindow);
    driver.findElement(By.id("search_query_top")).sendKeys("Shirt");
    driver.findElement(By.name("submit_search")).click();
    System.out.println("Title: " + driver.getTitle());
  }
}
