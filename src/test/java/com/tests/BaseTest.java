package com.tests;

import com.searchmodule.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() throws MalformedURLException {
        //BROWSER => Chrome /Firefox
        //HUB_HOST => localhost/10.0.1.3/hostname

        //Default Values
        String host = "localhost";
        ChromeOptions op = new ChromeOptions();

        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }

        String completeUrl="http://" + host + ":4444/wd/hub";

        if(System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            FirefoxOptions op1 = new FirefoxOptions();
            this.driver=new RemoteWebDriver(new URL(completeUrl),op1);
        }

       this.driver=new RemoteWebDriver(new URL(completeUrl),op);
    }


    @AfterTest
    public void quitBrowser(){
        this.driver.quit();
    }
}
