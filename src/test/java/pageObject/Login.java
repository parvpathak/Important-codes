package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static pageObject.OrganizationManagement.resetZoomToDefault;

public class Login {

    private WebDriver driver;
    JavascriptExecutor javascriptExecutor;
    Actions actions;
    Robot robot;
    static WebDriverWait wait;
    public static Login login;

    public static Properties properties;

    public Login(WebDriver driver) throws IOException {
        this.driver = driver;
        actions = new Actions(driver);
        try {
            robot = new Robot();
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        wait=new WebDriverWait(driver,Duration.ofSeconds(101));
        javascriptExecutor = (JavascriptExecutor)this.driver;
        PageFactory.initElements(driver, this);
        properties = new Properties();
        FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\data.properties");
        properties.load(fis1);
    }
    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameTextField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement userpasswordTextField;
    @FindBy(xpath = "//button[.='Login']")
    private WebElement loginButton;
    
    
    public WebElement getLoginButton() {
		return loginButton;
	}
	public void setLoginButton(WebElement loginButton) {
		this.loginButton = loginButton;
	}
	public WebElement getusernameField() {
		return usernameTextField;
	}
    public WebElement getuserpasswordTextField() {
		return userpasswordTextField;
	}
  //for confirm button
    @FindBy(xpath = "//button[contains(text(), 'Confirm')]")
    private WebElement confirmButton;
    public WebElement getconfirmButton() {
		return confirmButton;
	}

    public static void loginScenariomethod(WebDriver driver,Login login) throws Exception {
        resetZoomToDefault();
        driver.get(properties.getProperty("URL"));
        login.getusernameField().sendKeys(properties.getProperty("AdminEmailId"));
        login.getuserpasswordTextField().sendKeys(properties.getProperty("AdminPassword"));
        wait.until(ExpectedConditions.elementToBeClickable(login.getLoginButton())).click();
        wait.until(ExpectedConditions.urlContains("/dashboard"));
    }
}
