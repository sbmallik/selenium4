import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v103.network.Network;
import org.openqa.selenium.devtools.v103.network.model.ConnectionType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Optional;

public class emulateNetworkConditions {
  ChromeDriver driver;
  DevTools devTools;

  @BeforeTest
  public void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    devTools = driver.getDevTools();
  }

  @AfterTest
  public void teardown() {
    driver.quit();
  }

  @Test
  public void enableSlowNetworkConn() {
    devTools.createSession();
    devTools.send(Network.enable(
        Optional.empty(),
        Optional.empty(),
        Optional.empty()));
    devTools.send(Network.emulateNetworkConditions(
        false,
        150,
        2500,
        2000,
        Optional.of(ConnectionType.CELLULAR3G)));
    driver.get("https://linkedin.com");
    System.out.println("Enable slow network: " + driver.getTitle());
  }

  @Test
  public void doNotEnableNetwork() {
    driver.get("https://linkedin.com");
    System.out.println("Do not enable network: " + driver.getTitle());
  }
}
