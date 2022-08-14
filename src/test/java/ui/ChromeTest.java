package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ChromeTest extends Base {

    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        firstTest("chrome");
        System.out.println("go go go");
//        driver.manage().window().maximize();


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
