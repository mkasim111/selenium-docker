package com.newTours.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public FlightConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait( driver,30 );
        PageFactory.initElements( driver,this );
    }

    @FindBy(xpath= "(//*[contains(text(),'Confirmation')])[2]") private WebElement flightConfirmHeaderTxt;
    @FindAll( @FindBy(xpath= "//*[contains(text(),'USD')]")) private List<WebElement> prices;
    @FindBy(linkText = "SIGN-OFF") private WebElement signOffLink;



    public String printConfirmation(){
        this.wait.until( ExpectedConditions.visibilityOf( this.flightConfirmHeaderTxt ) );
        System.out.println(this.flightConfirmHeaderTxt.getText());
        ((JavascriptExecutor) driver).executeScript( "arguments[0].scrollIntoView(true);",this.prices.get(1) );
        System.out.println(this.prices.get( 1 ).getText());
        String price = this.prices.get( 1 ).getText();
        this.signOffLink.click();
        return price;
    }



}
