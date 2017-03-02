import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by alex on 21.02.2017.
 */
public class PurchaseProductTest {


    WebDriver driver = new FirefoxDriver();



    ProductPage purchaseProduct = new ProductPage(driver);
    UserCredentialsProvider userData = new UserCredentialsProvider();
    RealCheckoutPage realCheckoutPage = new RealCheckoutPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    PayPage payPageUserCredentialsInput = new PayPage(driver);


    @BeforeTest
    void StartUp() {
        System.setProperty("webdriver.gecko.driver", "C://gecko/geckodriver.exe");
        driver.get("http://kidsclotheslab.com/index.php?route=product/product&path=62&product_id=246");
        driver.manage().window().maximize();
    }

    @Test
    public void buyProduct() {
        purchaseProduct.chooseSize();
        purchaseProduct.chooseColor();
        purchaseProduct.inputQTYofProducts();
        purchaseProduct.pushAddToCartButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get("http://kidsclotheslab.com/index.php?route=checkout/checkout");

        realCheckoutPage.checkout_BTN_on_RealCheckout_Page();
        checkoutPage.pushNewCustomerContinueButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkoutPage.inputCredentials(userData.FirstName, userData.Lastname, userData.EMail, userData.Telephone, userData.Address, userData.City, userData.PostCode, userData.Password);
        checkoutPage.chooseCountry();
        checkoutPage.chooseState();
        checkoutPage.clickPrivacyPolicyRadioButton();
        checkoutPage.clickOn_Step2_BillingContinueButton();
        checkoutPage.clickOn_Step3_DeliveryDetailsContinueButton();
        checkoutPage.clickOn_Step4_DeliveryMethodContinueButton();
        checkoutPage.clickOn_Step5_PaymentMethodContinueButton();
        checkoutPage.clickOn_Step6_ConfirmOrderButton();
        payPageUserCredentialsInput.enterClientCredentialsPaypage(userData.FirstName,userData.Lastname,userData.Address,userData.City,userData.PostCode,userData.Country,userData.Telephone,userData.EMail,userData.IssuingBank,userData.CardNumber,userData.ExpirationMonth,userData.ExpirationYear,userData.CVV2);
        payPageUserCredentialsInput.clickOnSubmitTransactionButton();
    }
}

//    @AfterClass
//    public void cleanup() {
//        driver.quit(
//        );







