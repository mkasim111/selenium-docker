package com.newTours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public FindFlightPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait( driver,30 );
        PageFactory.initElements( driver,this );
    }

    @FindBy(name = "reserveFlights") private WebElement continueBtn;
    @FindBy(name = "buyFlights") private WebElement submitSecurePurchaseBtn;

    public void submitFlightPage(){
        this.wait.until( ExpectedConditions.elementToBeClickable( this.continueBtn ) );
        this.continueBtn.click();
    }

    public void submitBuyFlightPage(){
        this.wait.until( ExpectedConditions.elementToBeClickable( this.submitSecurePurchaseBtn ) );
        this.submitSecurePurchaseBtn.click();
    }

}
