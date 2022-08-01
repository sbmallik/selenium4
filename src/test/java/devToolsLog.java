import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v103.log.Log;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class devToolsLog {
  ChromeDriver driver;

  @BeforeTest
  public void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
  }

  @AfterTest
  public void teardown() {
    driver.quit();
  }

  @Test
  public void viewConsoleLogs() {
    DevTools devTools = driver.getDevTools();
    devTools.createSession();
    devTools.send(Log.enable());
    devTools.addListener(Log.entryAdded(), logEntry -> {
      System.out.println("----------\nLevel: " + logEntry.getLevel() + "\nText: " + logEntry.getText() + "\nBroken URL: " + logEntry.getUrl());
    });
    driver.get("http://the-internet.herokuapp.com/broken_images");
  }
}
