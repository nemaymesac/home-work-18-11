package com.pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseFunc {

    private WebDriver driver;
    private WebDriverWait wait;
    Actions actions;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
    }

    public void navigateTo(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }
        driver.get(url);
    }

    public String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    public void waitSeconds() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public WebElement findElementByXpath(String locator) {
        return driver.findElement(By.xpath(locator));
    }

    public List<WebElement> findElementsByXpath(String locator) {
        List<WebElement> elements = driver.findElements(By.xpath(locator));
        return elements;
    }

    public WebElement findElementById(String locator) {
        WebElement element = driver.findElement(By.id(locator));
        return element;
    }

    public void moveMouseToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void waitForElementToBeClickable(WebElement element) {
        FluentWait wait = new FluentWait(driver).withTimeout(20, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(ElementClickInterceptedException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickOnElementContainsName(List<WebElement> listOfElements, String name) {
        for (WebElement we : listOfElements) {
            if (we.getText().toLowerCase().contains(name)) {
                we.click();
                break;
            }
        }

    }

    public void closeBrowser() {
        driver.quit();
    }

}
