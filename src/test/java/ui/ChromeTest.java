package ui;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

@Epic("Chrome tests")
@Feature("Base chrome check")
public class ChromeTest extends Base {

    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        driverInit("chrome");
        driver.get("http://google.com");
        String firstWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://google.com");
        driver.switchTo().window(firstWindow);
        WebElement enterText = driver.findElement(By.name("q"));
        enterText.sendKeys("енот");
        enterText.submit();
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//h3[text()='Еноты - Википедия']")).click();
        Thread.sleep(3000);
    }
    @AfterTest
    public void tearDown(){
        if (driver!=null){
            driver.quit();
        }
    }
}
