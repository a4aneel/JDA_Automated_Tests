package com.jdawebapp.webdriver;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import org.junit.Test;
import org.openqa.selenium.WebDriver;


import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.lang.String;




public class EqualExpertsTest {


    @Test

    public void SuccessfullyBooking() {

        // Instantiation of chrome web driver

        // System.setProperty("webdriver.chrome.driver", "C:\\Users\\anil.nagisetty\\IdeaProjects\\WebApp\\chromedriver\\chromedriver.exe");
        // WebDriver driver = new ChromeDriver();

        // Instantiation of Firefox web driver


        System.setProperty("webdriver.gecko.driver", "C:\\Users\\anil.nagisetty\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        // Naviagate to Equal Experts hotel booking system
        driver.navigate().to("http://hotel-test.equalexperts.io/");

        // Fill in customer first name and last name

        driver.findElement(By.id("firstname")).sendKeys("David");
        driver.findElement(By.id("lastname")).sendKeys("Lotto");

        // Fill in total price
        driver.findElement(By.id("totalprice")).sendKeys("67.50");

        // Set deposit paid to either true/false

        driver.findElement(By.id("depositpaid")).sendKeys("true");

        // select check-in and check-out dates

        driver.findElement(By.id("checkin")).sendKeys("2018-02-24");
        driver.findElement(By.id("checkout")).sendKeys("2018-02-25");

        // save the booking

        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[7]/input")).click();

        // Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"6467\"]/div[1]/p")).getText().contains("David"));

        driver.quit();
    }

    @Test

    public void SuccessfullDeletionofBooking() {

        // Instantiation of chrome web driver

        // System.setProperty("webdriver.chrome.driver", "C:\\Users\\anil.nagisetty\\IdeaProjects\\WebApp\\chromedriver\\chromedriver.exe");
        // WebDriver driver = new ChromeDriver();

        // Instantiation of Firefox web driver

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\anil.nagisetty\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Navigate to Equal Experts hotel booking system
        driver.navigate().to("http://hotel-test.equalexperts.io/");


        // Write code to delete a specific customer in a row given the firstname = "David"


        List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='bookings']//div[@id]"));
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("[type='button'][value='Delete']"));

        for (int i = 0; i < rows.size(); i++) {

            if (rows.get(i).getText().contains("David"))
                deleteButtons.get(i).click();

        }

        }
    }
































