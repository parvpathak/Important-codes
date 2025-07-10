package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Dashboard {
    private WebDriver driver;
    JavascriptExecutor javascriptExecutor;
    Actions actions;
    Robot robot;
    static WebDriverWait wait;
   // public Dashboard dashboard;
    public static Dashboard dashboard;
    public Properties properties;
    public Login login;
    public Dashboard(WebDriver driver) throws IOException {
        this.driver = driver;
        actions = new Actions(driver);
        try {
            robot = new Robot();
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        wait=new WebDriverWait(driver, Duration.ofSeconds(101));
        javascriptExecutor = (JavascriptExecutor)this.driver;
        PageFactory.initElements(driver, this);
        properties = new Properties();
        FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\data.properties");
        properties.load(fis1);
        login=new Login(driver);
    }

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiFab-root MuiFab-circular MuiFab-sizeLarge MuiFab-default MuiFab-root MuiFab-circular MuiFab-sizeLarge MuiFab-default css-2pvxx0']//*[name()='svg']")
    private WebElement chatBot;

    @FindBy(xpath="(//div[@class='MuiBox-root css-u420fw'])[1]")
    private  WebElement ChatBotFrame;

    @FindBy(xpath = "//input[@placeholder='Type your message']")
    private WebElement enterDataInsideChatBot;

    @FindBy(xpath = "//button[@title='Send Message']//*[name()='svg']")
    private WebElement chatBotSendButton;

    @FindBy(css="#chat-send-message-button")
    private WebElement chatBotButton;

    @FindBy(xpath="//p[text()='Greeting for the day! How can I assist you today?']")
    private WebElement DisplayedTextAfterAfterEnteringDataOnChatBot;

    @FindBy(xpath="(//button[@type='button'])[3]")
    private WebElement EndChatButton;

    @FindBy(xpath ="(//button[@type='button'])[3]")
        private WebElement MinimizeChatBotButton;

   @FindBy(xpath="//button[@id='richToolbarButton_0']")
      private WebElement Boldselect;

   @FindBy(xpath="//button[@id='richToolbarButton_1']")
   private WebElement Italicselect;

    @FindBy(xpath="//button[@id='richToolbarButton_2']")
    private WebElement orderListItems ;

    @FindBy(xpath="//button[@id='richToolbarButton_3']")
    private WebElement UnorderList;

    @FindBy(xpath="//button[@id='richToolbarButton_4']")
    private WebElement HyperLinkcommand;

    @FindBy(xpath="(//button[@type='button'])[2]")
    private WebElement DeleteChatBtn;

    @FindBy(xpath="(//div[@class='MuiBox-root css-1pr80hd'])[1]")
    private WebElement ChatBotScrollContainer;

    public WebElement getChatBot() {
        return chatBot;
    }

    public WebElement getenterDataInsideChatBot() {
        return enterDataInsideChatBot;
    }

    public WebElement getChatBotSendButton() {
        return chatBotSendButton;
    }

    public WebElement getchatBotButton() {
        return chatBotButton;
    }

    public WebElement getDisplayedTextAfterAfterEnteringDataOnChatBot(){
        return DisplayedTextAfterAfterEnteringDataOnChatBot;
    }

    public WebElement getEndChatButton(){
        return EndChatButton;
    }

    public WebElement getMinimizeChatBotButton(){
        return MinimizeChatBotButton;
    }

    public WebElement getItalicselect(){
        return Italicselect;
    }

    public WebElement getBoldselect(){
        return Boldselect;
    }

    public WebElement getOrderListItems(){
        return orderListItems;
    }

    public WebElement getUnorderList(){
        return UnorderList;
    }

    public WebElement getHyperLinkcommand(){
        return HyperLinkcommand;
    }

    public WebElement getDeleteChatBtn(){
        return DeleteChatBtn;
    }

    public  WebElement getChatBotScrollContainer(){
        return ChatBotScrollContainer;
    }

   public static void userSelectsTheChatbotAndEnteredTheMessage(WebDriver driver,Dashboard dashboard) throws InterruptedException {
       wait.until(ExpectedConditions.elementToBeClickable(dashboard.getChatBot())).click();
       Thread.sleep(4000);
       WebElement inputBoxes = dashboard.getenterDataInsideChatBot();
       wait.until(ExpectedConditions.visibilityOf(inputBoxes));
       inputBoxes.sendKeys("Hello, how can I get help?");
       Thread.sleep(4000);
    }

    public static void userShouldAbleToGetTheResponseFromChatBot(WebDriver driver,Dashboard dashboard) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(dashboard.getChatBotSendButton())).click();
        Thread.sleep(4000);
        WebElement chatResponse = dashboard.getDisplayedTextAfterAfterEnteringDataOnChatBot();
        try {
            if (wait.until(ExpectedConditions.visibilityOf(chatResponse)).isDisplayed()) {
                String botResponseText = chatResponse.getText();
                System.out.println("Chatbot replied: " + botResponseText);
            } else {System.out.println("Oops! Something went wrong. Could you please check back later?");
            }
        } catch (TimeoutException e) {
            System.out.println("Oops! Something went wrong. Could you please check back later?");}}

    public static void UsershouldscrollthechatBotwindowfrombottomtotopandfromtoptobottom(WebDriver driver,Dashboard dashboard) throws InterruptedException {

        WebElement inputBoxes = dashboard.getenterDataInsideChatBot();
        wait.until(ExpectedConditions.visibilityOf(inputBoxes));
        inputBoxes.sendKeys("I want more information about NGteco Application");
        wait.until(ExpectedConditions.elementToBeClickable(dashboard.getChatBotSendButton())).click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOf(inputBoxes));
        inputBoxes.sendKeys("Hello, how can I get help?");
        WebElement chatScrollContainer = dashboard.getChatBotScrollContainer(); // Replace with actual method
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", chatScrollContainer);
        Thread.sleep(2000); // Optional: wait to observe scroll
        js.executeScript("arguments[0].scrollTop = 0;", chatScrollContainer);
        wait.until(ExpectedConditions.elementToBeClickable(dashboard.getMinimizeChatBotButton())).click();
    }


    }

