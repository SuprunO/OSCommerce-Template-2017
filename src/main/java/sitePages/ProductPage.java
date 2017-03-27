package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import technical.BasePage;

/**
 * Created by alex on 21.02.2017.
 */
public class ProductPage extends BasePage {

    //Locators
    private String CHOOSESIZEFIELD = "#input-option258";
    private String CHOOSECOLORFIELD = "#input-option257";
    private String CHOOSEQTYFIELD = "#input-quantity";
    private String ADDTOCARTBUTTON = "#button-cart";

    public ProductPage(WebDriver driver) {
        super(driver);
    }


    public void chooseSize() {

        Select select = new Select(driver.findElement(By.cssSelector(CHOOSESIZEFIELD)));
        select.selectByIndex(3);
    }

    public String currentSize(){
        Select select = new Select(driver.findElement(By.cssSelector(CHOOSESIZEFIELD)));
        return select.getFirstSelectedOption().getText();
    }

    public void chooseColor() {
        Select select = new Select(driver.findElement(By.cssSelector(CHOOSECOLORFIELD)));
        select.selectByIndex(1);
    }

    public String currentColor() {
        Select select = new Select(driver.findElement(By.cssSelector(CHOOSECOLORFIELD)));
        return select.getFirstSelectedOption().getText();
    }

    public void inputQTYofProducts() {
        driver.findElement(By.cssSelector(CHOOSEQTYFIELD)).clear();
        driver.findElement(By.cssSelector(CHOOSEQTYFIELD)).sendKeys("5");
    }

    public String currentQuantityInInput(){
        WebElement qtyInput =driver.findElement(By.cssSelector(CHOOSEQTYFIELD));
        return qtyInput.getText();

    }

    public void pushAddToCartButton() {
        waiter(ADDTOCARTBUTTON);
        clickOn(ADDTOCARTBUTTON);
    }

}







