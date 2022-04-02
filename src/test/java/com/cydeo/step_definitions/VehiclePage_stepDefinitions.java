package com.cydeo.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.cydeo.pages.BasePage;
import com.cydeo.pages.LoginPage;
import com.cydeo.pages.VehiclePage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VehiclePage_stepDefinitions {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    VehiclePage vehiclePage = new VehiclePage();


    @Given("users is on login page")
    public void usersIsOnLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env2"));
    }


    @Given("There is a user {string} and {string}")
    public void there_is_a_user_and(String username, String password) {

        loginPage.login(username, password);

    }

    @And("user is on the homepage")
    public void userIsOnTheHomepage() {
        String expectedTitle = "Dashboard";
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
        System.out.println(Driver.getDriver().getTitle());
    }


    @And("user clicks the Vehicles under the Fleet")
    public void userClicksTheVehiclesUnderTheFleet() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(basePage.fleetButton).perform();
        basePage.vehicles.click();

    }

    @Then("Verify any car info has {string} dots “...”, and there are “view, edit, delete” icons.")
    public void verifyAnyCarInfoHasDotsAndThereAreViewEditDeleteIcons(String string) {

        List<WebElement> threeDotElements = vehiclePage.threeDotElements;
        List<WebElement> numberOfCars = vehiclePage.numberOfCars;

        Assert.assertTrue(threeDotElements.size() == numberOfCars.size());

        // hover over to first ... elements
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.linkText("..."))).pause(2000).perform();

        // store option elements which you see after hovering over into the list of web elements

        List<WebElement> optionsList = vehiclePage.optionList;
        List<String> expectedOptionsText = new ArrayList<>(Arrays.asList("View", "Edit", "Delete"));

        int size = optionsList.size();

        for (int i = 0; i < size; i++) {


            Assert.assertEquals(optionsList.get(i).getAttribute("title"), expectedOptionsText.get(i));
            //System.out.println("optionsList.get(i).getAttribute(\"title\") = " + optionsList.get(i).getAttribute("title"));

            Assert.assertTrue(optionsList.get(i).isEnabled());


        }


    }
}





