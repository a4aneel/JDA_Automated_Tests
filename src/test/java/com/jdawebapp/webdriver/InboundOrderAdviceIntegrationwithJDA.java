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

public class InboundOrderAdviceIntegrationwithJDA {

    @Test

    public void InboundOrderAdviceIntegrationwithJDA() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anil.nagisetty\\IdeaProjects\\WebApp\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //WebDriver driver = new FirefoxDriver();

        // Navigate to ESB Test System
        driver.navigate().to("http://esb-test.int.kn:8585/");

        driver.findElement(By.id("wm_login-username")).sendKeys("anil.nagisetty");
        driver.findElement(By.id("wm_login-password")).sendKeys("Windows3");
        driver.findElement(By.id("submit_login")).click();

        // Navigate to Publisher screen

        driver.findElement(By.id("wmp5703:__rowu_002f_metau_002f_defaultu_002f_wm_xt_fabricfolderu_002f_0000067511:hotspot")).click();
        driver.findElement(By.xpath("//*[@id=\"jsfwmp67513:defaultForm:dropdownTopic\"]")).sendKeys("KNMS_SwiftLOG_InboundOrderAdviceV0100");

        // Browse and select a file


        WebElement element = driver.findElement(By.xpath("//*[@id=\"jsfwmp67513:defaultForm:inputMsgFile\"]"));
        element.sendKeys("C:\\Users\\anil.nagisetty\\Documents\\InboundOrderAdvice\\RswftgXMLSAM__20180428080000.xml");


        // set JMS_CorrelationID

        driver.findElement(By.xpath("//*[@id=\"jsfwmp67513:defaultForm:inputJMSCorrelationID\"]")).sendKeys("new15");

        // set ReceiverID

        driver.findElement(By.xpath("//*[@id=\"jsfwmp67513:defaultForm:inputRoutingReceiverId\"]")).sendKeys("Swift");

        // set ReceiverInstance

        driver.findElement(By.xpath("//*[@id=\"jsfwmp67513:defaultForm:inputRoutingReceiverInstance\"]")).sendKeys("TST");

        //set Country

        driver.findElement(By.xpath("//*[@id=\"jsfwmp67513:defaultForm:inputRoutingCountry\"]")).sendKeys("GB");

        // set custom field #1

        driver.findElement(By.xpath("//*[@id=\"jsfwmp67513:defaultForm:inputCustomName1\"]")).sendKeys("KNESB_Routing_Warehouse");
        driver.findElement(By.xpath("//*[@id=\"jsfwmp67513:defaultForm:inputCustomValue1\"]")).sendKeys("LT0");

        // set custom field #2

        driver.findElement(By.xpath("//*[@id=\"jsfwmp67513:defaultForm:inputCustomName2\"]")).sendKeys("KNESB_Routing_Client");
        driver.findElement(By.xpath("//*[@id=\"jsfwmp67513:defaultForm:inputCustomValue2\"]")).sendKeys("CLIE01");

        // Click on Publish

        driver.findElement(By.xpath("//*[@id=\"jsfwmp67513:defaultForm:publishButton\"]/span/span")).click();


        // close the browser

        //   driver.close();

        try {
            Thread.sleep(10000);
        } catch (Exception e) {
        }

        // Naviagate to JVA WebApp on LT1

         driver.navigate().to("https://denotsl453.int.kn:8015/rp/login");

       // driver.navigate().to("https://ssit01d1-s1.int.kn:8015/portal?siteId=LT2");

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
        driver.findElement(By.id("rpFilterComboBox-1196-inputEl")).sendKeys("VPINB0305/1");


        driver.findElement(By.cssSelector("ul > li:nth-child(5) > span")).click();

        //click on the Inbound order

        driver.findElement(By.id("ext-gen2066")).click();

    }
}


