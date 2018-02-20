package com.jdawebapp.webdriver;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anil.nagisetty\\IdeaProjects\\WebApp\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
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

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anil.nagisetty\\IdeaProjects\\WebApp\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Navigate to Equal Experts hotel booking system
        driver.navigate().to("http://hotel-test.equalexperts.io/");


        // Write code to delete a specific customer in a row given the firstname = "David" and price = "67.5"
        List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='bookings']//div[@id]"));
        Iterator<WebElement> i = rows.iterator();
        while (i.hasNext()) {
            WebElement row = i.next();
            System.out.println(row.getText());

            WebElement dynamicDivs = driver.findElement(By.xpath(".//*[@id='bookings']"));
            rows = dynamicDivs.findElements(By.tagName("p"));
            i = rows.iterator();
            while (i.hasNext()) {
                WebElement row1 = i.next();
                System.out.println(row1.getText());


              /*  if (row.getText().contains("David")) {

                   // driver.findElement(By.className("col-md-1").cssSelector(".col-md-1 > input[type = button")).click();
                   // driver.findElement(By.cssSelector(".col-md-1 + input")).click();

       }*/

              // Delete the booking by locating the booking by Xpath position
                driver.findElement(By.xpath("//*[@id=\"6473\"]/div[7]/input")).click();

                }
            }
        }
    }





















