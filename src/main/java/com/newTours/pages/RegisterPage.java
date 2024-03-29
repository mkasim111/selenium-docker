package com.newTours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

        private WebDriver driver;
        private WebDriverWait wait;

        public RegisterPage(WebDriver driver){
            this.driver = driver;
            this.wait = new WebDriverWait( driver,30 );
            PageFactory.initElements( driver,this );
        }


        @FindBy(name = "firstName") private WebElement firstNameTxt;
        @FindBy(name = "lastName") private WebElement lastNameTxt;
        @FindBy(name = "email") private WebElement usernameTxt;
        @FindBy(name = "password") private WebElement passwordTxt;
        @FindBy(name = "confirmPassword") private WebElement confirmPasswordTxt;
        @FindBy(name = "register") private WebElement submitBtn;



        public void goTo(){
            this.driver.get( "http://newtours.demoaut.com/mercuryregister.php" );
            this.wait.until( ExpectedConditions.visibilityOf( this.firstNameTxt ) );
        }

        public void enterUserDetails(String firstname,String lastname){
            this.firstNameTxt.sendKeys( firstname );
            this.lastNameTxt.sendKeys( lastname );
        }


        public void enterUserCredentials(String username, String password){
            this.usernameTxt.sendKeys( username );
            this.passwordTxt.sendKeys( password );
            this.confirmPasswordTxt.sendKeys( password );
        }

        public void submit(){
            this.submitBtn.click();
        }



}
