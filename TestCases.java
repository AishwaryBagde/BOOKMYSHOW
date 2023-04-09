package demo;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.hc.core5.http.nio.entity.NoopEntityConsumer;
import org.openqa.selenium.JavascriptExecutor;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///

public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01()throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        
        //  1. Launch Browser (Chrome) :ChromeDriver()
        // 1.2 Maximize Window :driver.windows().manage().maximize();
        // 1.5 Handle Sync issue using implicitlyWait() :driver.windows().timeouts().implicitlyWait(30,TimeUnit.SECONDS)
        // 2. Load URL :https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        Thread.sleep(3000);

        // 3. Scroll down To the end of the website so that all the links get loaded using javascript  :js.executeScript("window.scrollBy(0,0)", "");
        JavascriptExecutor js = (JavascriptExecutor) driver ;
        js.executeScript("window.scrollBy(0,2000)");
    
        Thread.sleep(3000);

        // 4 . Locate all the a tag links and store it in the List Using Locator "XPath":"//a[@href]" / List<WebElement> links ; size();
        List<WebElement> links = driver.findElementsByXPath("//a[@href]");
        // 5. Print All the Links Size  :
        System.out.println("The Size of : "+links.size());

        // Thread.sleep(3000);
        // // 5. Print All the Links  using for each loop :for(WebElement link: links){}
        // for(WebElement link: links){
        //     Thread.sleep(1000);
        //     System.out.println("The links Present on the webpage are : " +link.getAttribute("href"));
        // }

     }


}
