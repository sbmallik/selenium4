import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.*;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class relativeLocators {
  WebDriver driver;

  @BeforeTest
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://opensource-demo.orangehrmlive.com/");
  }

  @AfterTest
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void testRelativeLocator() {
    WebElement loginPanel = driver.findElement(By.id("logInPanelHeading"));
    WebElement credentials = driver.findElement(with(By.tagName("span")).above(loginPanel));
    System.out.println(credentials.getText());
  }

  @Test
  public void testListOfElements() {
    List<WebElement> allSocialMedia = driver.findElements(with(
        By.tagName("img"))
        .near(By.id("footer")));

    for (WebElement socialMedia : allSocialMedia) {
      System.out.println(socialMedia.getAttribute("alt"));
    }
  }
}
