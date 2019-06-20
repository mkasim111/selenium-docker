package com.newTours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmation {

    private WebDriver driver;
    private WebDriverWait wait;

    public RegistrationConfirmation(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait( driver,30 );
        PageFactory.initElements( driver,this );
    }

    @FindBy(partialLinkText = "sign-in") private WebElement singInLnk;
    @FindBy(linkText = "Flights") private WebElement flightsLnk;


    public void goToFlightsDetailsPage(){
        this.wait.until( ExpectedConditions.visibilityOf( this.singInLnk ) );
        this.flightsLnk.click();
    }

}
