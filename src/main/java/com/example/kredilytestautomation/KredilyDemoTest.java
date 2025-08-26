package com.example.kredilytestautomation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.nio.file.WatchEvent;
import java.time.Duration;
import java.util.List;

public class KredilyDemoTest {


        public static void main(String[] args) throws InterruptedException {
            WebDriver driver;
            WebDriverWait wait;


            driver = new ChromeDriver();
            // WebDriverManager.edgedriver().setup();
            // driver = new EdgeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            driver.get("https://kredily.com");

            driver.manage().window().maximize();
            WebElement ew = wait.until(ExpectedConditions.elementToBeClickable(By.id("menu-item-3339")));
            ew.click();

            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInFormEmailAddress")));
            emailField.sendKeys("2100032200cseh@gmail.com");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInFormPassword")));
            passwordField.sendKeys("Kedhar@03");

            WebElement signin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signinSubmitBtn")));
            signin.click();

            WebElement demo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("schedule_demo")));
            demo.click();
            Thread.sleep(5000);
            WebElement framemodal = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/iframe"));
            driver.switchTo().frame(framemodal);
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
            button.click();

            WebElement entry = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='PjPBl3MPKsCvWXT51KHv _nXFoboOeiuXIxcIeTZu _Jtap3zpvOIYtGbqACME']")));
            entry.click();

            Thread.sleep(5000);

            // Get all available dates
            List<WebElement> availableDates = driver.findElements(
                    By.xpath("//button[contains(@aria-label, 'Times available') and not(@disabled)]"));

    // Click the first available date
            if (!availableDates.isEmpty()) {
                availableDates.get(0).click();
            }

            // Wait for time slots to load after date selection
            Thread.sleep(2000); // Small delay for time slots to appear

// Find all available time slots using the data-container attribute
            List<WebElement> timeSlots = driver.findElements(
                    By.xpath("//button[@data-container='time-button']"));

            if (timeSlots.isEmpty()) {
                throw new RuntimeException("No available time slots found");
            }

// Select the first available time slot
            WebElement firstTimeSlot = timeSlots.get(0);

// Scroll to the time slot to ensure it's visible
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", firstTimeSlot);

// Click the time slot (with JavaScript fallback)
            try {
                firstTimeSlot.click();
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor)driver).executeScript("arguments[0].click();", firstTimeSlot);
            }

// Optional: Verify the time slot was selected by checking its selected state
            String ariaSelected = firstTimeSlot.getAttribute("aria-selected");

            // After selecting the time slot, wait for Next button to be clickable
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

// Find the Next button using aria-label attribute
            WebElement nextButton = wait1.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[starts-with(@aria-label, 'Next ') and text()='Next']")));

// Scroll to the button and click with JavaScript executor as fallback
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);

            try {
                nextButton.click();
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor)driver).executeScript("arguments[0].click();", nextButton);
            }

// Wait for next page to load
            wait.until(ExpectedConditions.invisibilityOf(nextButton));

            WebElement fullname= wait.until(ExpectedConditions.elementToBeClickable(By.id("full_name_input")));
            fullname.sendKeys("KedharNath");

            WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.id("email_input")));
            email.sendKeys("2100032200cseh@gmail.com");

            WebElement agenda= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("YKiHAPvZEKN2ByK-dS3bp")));
            agenda.sendKeys("This is a demo schedule booking");


            WebElement number = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("GtZR5pZmGgta4XhmpjLOg")));
            number.sendKeys("1234567893");

            WebElement scheduleButton = driver.findElement(
                    By.xpath("//button[.//span[contains(text(), 'Schedule Event')]]")
            );
            scheduleButton.click();







        }


}