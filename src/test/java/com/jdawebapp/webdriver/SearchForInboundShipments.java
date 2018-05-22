package com.jdawebapp.webdriver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchForInboundShipments {

    @Test

    public void firefoxTest() {

        // System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        // System.setProperty("webdriver.gecko.driver","C:\\Program Files\\gecko\\geckodriver-v0.19.1-win64\\geckodriver.exe");


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anil.nagisetty\\IdeaProjects\\WebApp\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //WebDriver driver = new FirefoxDriver();

        // Naviagate to JVA WebApp on LT1
        driver.navigate().to("https://denotsl453.int.kn:8015/rp/login");

        // Locate username and password and enter
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("loginUserName")));

        driver.findElement(By.id("loginUserName")).sendKeys("anil.nagisetty");

        driver.findElement(By.id("loginPassword")).sendKeys("madhuri123");
        driver.findElement(By.id("loginButton")).click();

        try {
            Thread.sleep(10000);
        } catch (Exception e) {
        }

        /*driver.switchTo().frame(driver.findElement(By.id("jdaIFrame-1026")));

        WebDriverWait wait1 = new WebDriverWait(driver, 15);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("container-1042-targetEl")));
        String tmp = driver.findElement(By.id("label-1043")).getText();

        driver.switchTo().defaultContent();*/

        driver.findElement(By.id("button-1022-btnEl")).click();

        driver.findElement(By.id("button-1017-btnEl")).click();

        List<WebElement> elementOptions = driver.findElements(By.cssSelector("#dataview-1020 .menu-item"));
        elementOptions.get(7).click();

        // Click on Inbound shipments

        driver.findElement(By.id("menuNodeLink-1975")).click();




        try {
            Thread.sleep(10000);
        } catch (Exception e) {
        }



        List<WebElement> numberofFrames = driver.findElements(By.tagName("iframe"));
        System.out.println("Total Number of iframes present are : " + numberofFrames.size());
        for (int i = 0; i < numberofFrames.size(); i++) {

            driver.findElement(By.xpath("//*[@id=\"jdaIFrame-1026\"]"));
            System.out.println("Name of the i-frames : " + numberofFrames.get(i).getAttribute("id"));

        }


        try {
            Thread.sleep(10000);
        } catch (Exception e) {
        }

        driver.switchTo().frame(driver.findElement(By.id("jdaIFrame-2010")));

        //click on inbound orders

        driver.findElement(By.id("button-1166-btnIconEl")).click();

        WebDriverWait wait1 = new WebDriverWait(driver, 15);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("rpFilterComboBox-1196-inputEl")));
        driver.findElement(By.id("rpFilterComboBox-1196-inputEl")).click();
        driver.findElement(By.id("rpFilterComboBox-1196-inputEl")).sendKeys("VPINB0305");


        driver.findElement(By.cssSelector("ul > li:nth-child(4) > span")).click();

    }
}
