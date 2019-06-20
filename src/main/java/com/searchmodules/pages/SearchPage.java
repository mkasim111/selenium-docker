package com.searchmodules.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SearchPage( WebDriver driver ) {
        this.driver = driver;
        this.wait = new WebDriverWait( driver ,30);
        PageFactory.initElements( driver,this );
    }

    @FindBy(name ="q") private WebElement searchTextBox;
    @FindBy(id="search_button_homepage") private WebElement searchBtn;
    @FindBy(linkText = "Videos") private WebElement videosLnk;
    @FindAll(@FindBy(className="tile--vid")) private List<WebElement> allVideos;

    public void goTo(){
        this.driver.get( "https://duckduckgo.com/" );
    }

    public void doSearch(String keyword){
        this.wait.until( ExpectedConditions.visibilityOf( this.searchTextBox ) );
        this.searchTextBox.sendKeys( keyword );
        this.searchBtn.click();
    }

    public void goToVideos(){
        this.wait.until( ExpectedConditions.visibilityOf( this.videosLnk ) );
        this.videosLnk.click();
    }

    public int printResult(){
        By by = By.className( "tile--vid" );
        this.wait.until( ExpectedConditions.numberOfElementsToBeMoreThan( by,0 ));
        System.out.println(allVideos.size());
        return allVideos.size();
    }
}
