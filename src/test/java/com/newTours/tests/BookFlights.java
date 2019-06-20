package com.newTours.tests;

import com.newTours.pages.*;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlights extends BaseTest {


    private String noOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassengers","expectedPrice"})
    public void setUpParameter(String noOfPassengers,String expectedPrice){
        this.noOfPassengers = noOfPassengers;
        this.expectedPrice= expectedPrice;
    }

    @Test
    public void registrationPageTest(){
        RegisterPage rpage = new RegisterPage( driver );
        rpage.goTo();
        rpage.enterUserDetails( "Seelnium","Doccker" );
        rpage.enterUserCredentials( "Seelnium","Doccker"  );
        rpage.submit();
    }

    @Test(dependsOnMethods = "registrationPageTest")
    public void registrationConfirmation(){
        RegistrationConfirmation rConfirm = new RegistrationConfirmation( driver );
        rConfirm.goToFlightsDetailsPage();

    }

    @Test(dependsOnMethods = "registrationConfirmation")
    public void flightDetailsPage(){
        FlightDetailsPage fDetails = new FlightDetailsPage( driver );
        fDetails.selectPassengersNumber( noOfPassengers);
        fDetails.goToFindFlightsPage();

    }


    @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightPageTest(){
        FindFlightPage f = new FindFlightPage( driver );
        f.submitFlightPage();
        f.submitBuyFlightPage();
    }


    @Test(dependsOnMethods = "findFlightPageTest")
    public void printFlightConfirmation(){
        FlightConfirmationPage fc = new FlightConfirmationPage( driver );
        String actualPrice=fc.printConfirmation();
        Assert.assertEquals(actualPrice,expectedPrice);
    }

}
