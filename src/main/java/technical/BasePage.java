package technical;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.Assert.assertTrue;


/**
 * Created by alex on 07.02.2017.
 */
public class BasePage {

    //INPUT THE SITE NAME TO CHECK HERE:
    public static String SiteURL = "http://" + "weddingdev.com";
    //-------------------------------------------------------------
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }



    public void waitByLinkText(String ByLinkText) {
        WebDriverWait waitForOne = new WebDriverWait(driver, 25);
        waitForOne.until(ExpectedConditions.elementToBeClickable(By.linkText(ByLinkText)));
    }


    public void clickOnСSSSelector(String CSSSelector) {
        driver.findElement(By.cssSelector(CSSSelector)).click();
    }

    public void hoverAndClick(WebDriver driver, WebElement clickElement) {
        Actions action = new Actions(driver);
        action.moveToElement(clickElement).build().perform();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickElement.click();
    }

    public WebElement findProductByText(String name, By locator) {
        List<WebElement> products = driver.findElements(locator);
        for (WebElement product : products) {
            if (product.getText().contains(name)) {
                return product;
            }
        }
        return null;
    }

//    public WebElement findPriceByProductName(String name) {
//        return findProductByText(name).findElement(By.xpath("../../p[2]"));
//    }


    /**
     * Checks if specified an element is present on the current the page.
     * Note: for Ajax or elements with delayed appearing: "wait"|fluent-wait methods should be used.
     *
     * @param elementLocator By locator of target element
     * @return Boolean
     */
    public boolean isElementPresent(By elementLocator) {
        return !driver.findElements(elementLocator).isEmpty();
    }


    /**
     * Used to encapsulate required check before any interaction with UI element.
     *
     * @param locator     "By" class locator to search input field.
     * @param elementName String descriptive name of the element(just for pretty logs).
     */
    public void assertPresenceAndDisplay(By locator, String elementName) {
        assertTrue(isElementPresent(locator), "FAILED TO FIND ELEMENT: " + elementName);
        assertTrue(driver.findElement(locator).isDisplayed(), "FAILED TO DETECT VISIBILITY OF THE ELEMENT: " + elementName);
    }

    /**
     * Method that finds element by locator with class "By" and clicks on it.
     *
     * @param locator     "By" class locator to search input field.
     * @param elementName String descriptive name of the element(just for pretty logs).
     */
    public void clickOnElement(By locator, String elementName) {
        assertPresenceAndDisplay(locator, elementName);
        //  LOGGER.info("Clicking on: " + elementName);
        driver.findElement(locator).click();
    }


    /**
     * Causes the currently executing thread to sleep (temporarily cease execution)
     * for the specified number of milliseconds, subject to the precision and accuracy of system timers and schedulers.
     * The thread does not lose ownership of any monitors
     *
     * @param millis the length of time to sleep in milliseconds
     */

    public void threadSleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}




