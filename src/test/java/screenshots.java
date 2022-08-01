import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.io.FileHandler;

public class screenshots {
  WebDriver driver;

  @BeforeTest
  public void setUp() {
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
    driver.get("https://applitools.com/");
  }

  @AfterTest
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void pageSectionScreenshot() throws IOException {
    WebElement pageSection = driver.findElement
      (By.cssSelector(".page-header"));
    FileHandler.copy(pageSection.getScreenshotAs(OutputType.FILE), new File("pageSection.png"));
  }

  @Test
  public void fullPageScreenshot() throws IOException {
    File source = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
    FileHandler.copy(source, new File("fullPage.png"));
  }
}
