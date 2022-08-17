package ui;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Base {
    WebDriver driver =null;

    public void driverInit(String browserName) throws MalformedURLException {
        DesiredCapabilities ds = new DesiredCapabilities();
        if (browserName.equals("chrome")){
            ds.setPlatform(Platform.LINUX.family());
            ds.setBrowserName(Browser.CHROME.browserName());
        }
        else if (browserName.equals("firefox")) {
            ds.setPlatform(Platform.LINUX.family());
            ds.setBrowserName(Browser.FIREFOX.browserName());
        }
        //nix AWS
        driver = new RemoteWebDriver(new URL("http://3.12.200.161:4444"),ds);
        //local
        //driver = new RemoteWebDriver(new URL("http://localhost:4444"),ds);
        //win AWS
        //driver = new RemoteWebDriver(new URL("http://18.216.186.143:4444"),ds);
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
    }
    @AfterClass
    public void quit(){
        if (driver!=null){
            driver.quit();
        }
    }
}
