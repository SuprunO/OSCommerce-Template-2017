package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;
import technical.BasePage;

/**
 * Created by alex on 21.02.2017.
 */
public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    //Locators

    //STEP#2
    private String FIRSTNAME = "#input-payment-firstname";
    private String LASTNAME = "#input-payment-lastname";
    private String EMAIL = "#input-payment-email";
    private String PHONE ="#input-payment-telephone";
    private String ADDRESS = "#input-payment-address-1";
    private String CITY = "#input-payment-city";
    private String POSTCODE = "#input-payment-postcode";
    private String COUNTRY = "#input-payment-country";
    private String STATE = "#input-payment-zone";
    private String PASSWORD = "#input-payment-password";
    private String PASSCONFIRM = "#input-payment-confirm";
    private String RADIOBUTTON = ".agree+input";


    public void inputCredentials(String FirstName, String LastName, String EMail, String Telephone, String Address, String City, String Postcode, String Password) {
        waiter(FIRSTNAME);
        driver.findElement(By.cssSelector(FIRSTNAME)).sendKeys(FirstName);
        driver.findElement(By.cssSelector(LASTNAME)).sendKeys(LastName);
        driver.findElement(By.cssSelector(EMAIL)).sendKeys(EMail);
        driver.findElement(By.cssSelector(PHONE)).sendKeys(Telephone);
        driver.findElement(By.cssSelector(ADDRESS)).sendKeys(Address);
        driver.findElement(By.cssSelector(CITY)).sendKeys(City);
        driver.findElement(By.cssSelector(POSTCODE)).sendKeys(Postcode);
        driver.findElement(By.cssSelector(PASSWORD)).sendKeys(Password);
        driver.findElement(By.cssSelector(PASSCONFIRM)).sendKeys(Password);

    }

    public String currentFirstNameInput(){
        Select select = new Select(driver.findElement(By.cssSelector(FIRSTNAME)));
        return select.getFirstSelectedOption().getText();
    }

    public String currentLastNameInput(){
        Select select = new Select(driver.findElement(By.cssSelector(LASTNAME)));
        return select.getFirstSelectedOption().getText();
    }

    public String currentEmailInput() {
        Select select = new Select(driver.findElement(By.cssSelector(EMAIL)));
        return select.getFirstSelectedOption().getText();
    }

    public String currentPhoneInput() {
        Select select = new Select(driver.findElement(By.cssSelector(PHONE)));
        return select.getFirstSelectedOption().getText();
    }
    public String currentAddressInput() {
        Select select = new Select(driver.findElement(By.cssSelector(ADDRESS)));
        return select.getFirstSelectedOption().getText();
    }

    public String currentCityInput() {
        Select select = new Select(driver.findElement(By.cssSelector(CITY)));
        return select.getFirstSelectedOption().getText();
    }

    public String currentPostCodeInput() {
        Select select = new Select(driver.findElement(By.cssSelector(POSTCODE)));
        return select.getFirstSelectedOption().getText();
    }

    public String currentPasswordInput() {
        Select select = new Select(driver.findElement(By.cssSelector(PASSWORD)));
        return select.getFirstSelectedOption().getText();
    }

    public String currentPasswordConfirmINput() {
        Select select = new Select(driver.findElement(By.cssSelector(PASSCONFIRM)));
        return select.getFirstSelectedOption().getText();
    }

    public void chooseCountry(){
        Select select = new Select(driver.findElement(By.cssSelector(COUNTRY)));
        select.selectByIndex(239);
    }

    public String currentCountrySelected(){
        Select select = new Select(driver.findElement(By.cssSelector(COUNTRY)));
        return select.getFirstSelectedOption().getText();
    }

    public void chooseState(){
        Select select = new Select(driver.findElement(By.cssSelector(STATE)));
        select.selectByIndex(5);
    }

    public String currentStateSelected(){
        Select select = new Select(driver.findElement(By.cssSelector(STATE)));
        return select.getFirstSelectedOption().getText();
    }

    public void clickPrivacyPolicyRadioButton(){
        clickOn(RADIOBUTTON);
    }

    // CHECKOUT STEPS
    private String NEW_CUSTOMER_CONTINUE_BUTTON="#button-account";
    private String BILLING_CONTINUE_BUTTON = "#button-register";
    private String DELIVERY_DETAILS_CONTINUE_BUTTON = "#button-shipping-address";
    private String DELIVERY_METHOD_CONTINUE_BUTTON = "#button-shipping-method";
    private String PAYMENT_METHOD_CONTINUE_BUTTON = "#button-payment-method";
    private String CONFIRM_ORDER_BUTTON = "#cardgate-confirm";

    @Step("Click on New Account continue button")

    public void clickOn_Step1_AccountContinueButton(){
        waiter(NEW_CUSTOMER_CONTINUE_BUTTON);
        clickOn(NEW_CUSTOMER_CONTINUE_BUTTON);
    }
    @Step("Click on Billing Continue button")
    public void clickOn_Step2_BillingContinueButton(){
        clickOn(this.BILLING_CONTINUE_BUTTON);
    }


    @Step("Click on Delivery Details Continue button")
    public void clickOn_Step3_DeliveryDetailsContinueButton(){
        waiter(DELIVERY_DETAILS_CONTINUE_BUTTON);
        clickOn(this.DELIVERY_DETAILS_CONTINUE_BUTTON);
    }

    @Step("Click on Delivery Method Continue button")
    public void clickOn_Step4_DeliveryMethodContinueButton(){
        waiter(DELIVERY_METHOD_CONTINUE_BUTTON);
        clickOn(this.DELIVERY_METHOD_CONTINUE_BUTTON);
    }

    @Step("Click on Delivery Method Continue button")
    public void clickOn_Step5_PaymentMethodContinueButton(){
        waiter(PAYMENT_METHOD_CONTINUE_BUTTON);
        clickOn(this.PAYMENT_METHOD_CONTINUE_BUTTON);
    }

    @Step("Confirm Order button")
    public void clickOn_Step6_ConfirmOrderButton(){
        waiter(CONFIRM_ORDER_BUTTON);
        clickOn(this.CONFIRM_ORDER_BUTTON);
    }
}