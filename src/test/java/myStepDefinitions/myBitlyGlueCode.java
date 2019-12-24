package myStepDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import cucumber.api.PendingException;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.util.*;


public class myBitlyGlueCode {

    private WebDriver driver;

    //System.setProperty("webdriver.chrome.driver", "C:/Users/Gebruiker.DESKTOP-PF8P81T/Documents/Downloaded_Chromedriver/chromedriver_win32/chromedriver.exe");
    @Before
    public void beforeScenario() {
        System.out.println("Opening browser and maximizing the window");
        System.setProperty("webdriver.chrome.driver", "C:/Users/Gebruiker.DESKTOP-PF8P81T/Documents/Downloaded_Chromedriver/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("^I am on the Bitly web page$")
    public void I_am_on_the_Bitly_web_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Navigating to the Bitly Home page");
        driver.get("https://bitly.com/");
        driver.findElement(By.id("banner-cookie--button")).click();

    }
    @When("^I log in$")
    public void i_log_in() throws Throwable {
    System.out.println("Entering user name");
    driver.findElement(By.xpath("//*[@id=\"sidemenu\"]/li[1]/a/span")).click();
    driver.findElement(By.xpath("//*[@id=\"sign-in\"]/div[2]/fieldset/input[1]")).sendKeys("benjamin1p");
    System.out.println("entering password");
    driver.findElement(By.xpath("//*[@id=\"sign-in\"]/div[2]/fieldset/input[2]")).sendKeys("benjamin1pswd");
    System.out.println("clicking the login button");
    driver.findElement(By.xpath("//*[@id=\"sign-in\"]/div[2]/fieldset/input[4]")).click();
    }


    @Then("^I should see my name displayed beside the environment avatar$")
    public void i_should_see_my_name_displayed_beside_the_environment_avatar() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("waiting 5 seconds");
        synchronized (driver)
        {
            driver.wait(5000);
        }
        System.out.println("Verifying user is on the Bitly landing page");
        Assert.assertEquals("BENJA", driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/nav/span/button")).getText());
    }
}