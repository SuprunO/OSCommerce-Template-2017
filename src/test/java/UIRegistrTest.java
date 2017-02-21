import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by alex on 05.02.2017.
 */
public class UIRegistrTest {


    WebDriver driver = new FirefoxDriver();
    RegistrPage1 regPage = new RegistrPage1(driver);
    UserCredentialsProvider dataProvider = new UserCredentialsProvider();


    @BeforeClass
    public void startUp() {
        driver.get(dataProvider.SiteURL+"/index.php?route=account/login");
    }


    @Test
    public void newCustomerHeader() {

        Assert.assertEquals(regPage.NewCustomerHeader().getText(), "New Customer", "The NewCustomerHeader is wrong or missing");
    }

    @Test
    public void registerAccountHeader() {
        Assert.assertEquals(regPage.RegisterAccountHeader().getText(), "Register Account", " Register Account header is wrong or missing");
    }

    @Test
    public void registerAccountText() {
        Assert.assertEquals(regPage.RegisterAccountText().getText(), "By creating an account you will be able to shop faster, be up to date on an order's status, and keep track of the orders you have previously made.", " Register Account text is wrong or missing");
    }

    @Test
    public void registerAccountButton() {
        Assert.assertEquals(regPage.RegisterAccountButton().getText(), "Continue", " Continue Button text is wrong or missing");
    }
}