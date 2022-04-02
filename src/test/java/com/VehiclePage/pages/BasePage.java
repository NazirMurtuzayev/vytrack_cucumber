package com.VehiclePage.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.VehiclePage.utilities.Driver;

public class BasePage {

    public BasePage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//span[contains(text(),'Fleet')])[1]")
    public WebElement fleetButton;

    @FindBy(linkText = "Vehicles")
    public WebElement vehicles;


    //"//*[@id='main-menu']/ul/li[1]/a/span"
    // //span[contains(text(), ‘Fleet’)]


}