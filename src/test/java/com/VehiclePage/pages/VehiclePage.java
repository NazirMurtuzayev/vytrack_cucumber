package com.VehiclePage.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.VehiclePage.utilities.Driver;

import java.util.List;

public class VehiclePage  {

    public VehiclePage(){


        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (linkText = "...")
    public List<WebElement> threeDotElements;


    @FindBy(xpath = "//table//tbody//tr")
    public List<WebElement> numberOfCars;

    @FindBy(xpath = "(//ul[@class='dropdown-menu dropdown-menu__action-cell launchers-dropdown-menu'])[1]//li[@class='launcher-item']/a" )
    public List<WebElement> optionList;








}