package utils;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class ReusableFunctions {

    //Validate Navigation---------------------------------------------------------------------------------------------
    public void validateNavigation(WebDriverWait wait, WebElement element) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
//			    	Thread.sleep(1000);
            }
        }
        if (attempts == 3) {
            throw new RuntimeException("Failed to validate navigation to activity log page due to repeated stale element exceptions");
        }
    }

    //Click-----------------------------------------------------------------------------------------
    public void performClickAction(WebElement button) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                button.click();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
        if (attempts == 3) {
            throw new RuntimeException("Failed to click the button due to repeated stale element exceptions");
        }
    }

    //Random Values---------------------------------------------------------------------------------------------
    public void enterRandomAlphanumeric(WebElement textfield) {
        String randomName = RandomStringUtils.randomAlphanumeric(7);
        textfield.sendKeys(randomName);
//		return randomName;
    }

    public String enterRandomEmail(WebElement emailField) {
        String randomEmail = RandomStringUtils.randomAlphanumeric(6) + "@gmail.com";
        emailField.sendKeys(randomEmail);
        return randomEmail;
    }

    public void enterRandomValidPassword(WebElement passwordField) {
        passwordField.sendKeys(RandomStringUtils.randomAlphabetic(1).toUpperCase() + "#@" + RandomStringUtils.randomAlphanumeric(5) + RandomStringUtils.randomNumeric(3));
    }

    public String enterRandomData(WebElement textfield, int minLength, int maxLength) {
        Random random = new Random();
        int length = random.nextInt((maxLength - minLength) + 1) + minLength;
        StringBuilder randomData = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            randomData.append((char) (random.nextInt(26) + 'a')); // Generates random lowercase letters
        }
        textfield.clear();
        textfield.sendKeys(randomData.toString());
        return randomData.toString();
    }

    public void enterRandomNumber(WebElement textfield, int size) {
        String randomNum = RandomStringUtils.randomNumeric(size);
        ;
        textfield.clear();
        textfield.sendKeys(randomNum);
    }


    public void enterRandomTime(WebElement clocktime) {
        // Generate random hours and minutes
        int randomHours = Integer.parseInt(RandomStringUtils.randomNumeric(1, 2)) % 24;
        int randomMinutes = Integer.parseInt(RandomStringUtils.randomNumeric(1, 2)) % 60;
        // Format the time as HH:mm
        String formattedTime = String.format("%02d:%02d", randomHours, randomMinutes);

        // Enter the formatted time into the clock input field
        clocktime.sendKeys(formattedTime);
    }

    public void verifyToastMessage(WebDriver driver, WebDriverWait wait, String expectedMessage) {
        // Wait for toast message to appear — adjust locator as per your toast HTML
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='notistack-snackbar']")));

        // Find all visible toast messages with that class or locator
        List<WebElement> toastMessages = driver.findElements(By.xpath("//div[@id='notistack-snackbar']"));

        boolean flag = true;

        for (WebElement toast : toastMessages) {
            System.out.println(toast.getText());
            wait.until(ExpectedConditions.visibilityOf(toast));
            if (toast.getText().trim().equals(expectedMessage.trim())) {
                flag = false;
                System.out.println(toast.getText() + " = " + expectedMessage);
                Assert.assertEquals(expectedMessage.trim(), toast.getText().trim());
                break;
            }
        }

        if (flag) {
            Assert.fail(expectedMessage + " toast message is not displayed");
        }
    }


}