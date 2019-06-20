package com.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp( ITestContext context) throws MalformedURLException {
        String host = "localhost";


        System.setProperty( "webdriver.chrome.driver","C:\\Users\\mdkas\\IdeaProjects\\seleniumdocker\\src\\main\\resources\\drivers\\chromedriver.exe" );

        DesiredCapabilities capabilities ;

        if(System.getProperty( "BROWSER" )!=null &&
        System.getProperty(  "BROWSER"  ).equalsIgnoreCase( "firefox" )){
            System.setProperty( "webdriver.gecko.driver","C:\\Users\\mdkas\\IdeaProjects\\seleniumdocker\\src\\main\\resources\\drivers\\geckodriver.exe" );
            capabilities = DesiredCapabilities.firefox();
        }else{
            capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("test-type");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        }
        if(System.getProperty( "HUB_HOST" )!=null){
            host = System.getProperty( "HUB_HOST" );
        }

        String testName = context.getCurrentXmlTest().getName();
        String completeurl = "http://"+host+":4444/wd/hub";
        capabilities.setCapability( "name",testName);
        this.driver = new RemoteWebDriver( new URL(completeurl),capabilities );
    }

    @AfterTest
    public void closeDriver( ) {
        driver.quit();
    }


}
