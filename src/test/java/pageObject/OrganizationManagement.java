package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class OrganizationManagement {
    public static OrganizationManagement organization;
    private WebDriver driver;
    private JavascriptExecutor javascriptExecutor;
    private Actions actions;
    private Robot robot;
    private static WebDriverWait wait;
    public Properties properties;





    public OrganizationManagement(WebDriver driver) throws IOException {
        this.driver = driver;
        actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        javascriptExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this); // ✅ Essential
    }
    public static void resetZoomToDefault() throws Exception {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_0);
        r.keyRelease(KeyEvent.VK_0);
        r.keyRelease(KeyEvent.VK_CONTROL);
    }

    @FindBy(css = "input[id=':r3:']")
    private WebElement SelectOrganizationdropdown;


    @FindBy(css = "body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > p:nth-child(2)")
    private WebElement OrganizationManagementBtn;

    @FindBy(xpath = "(//p[text()='Organization Profile'])[1]")
    private WebElement organization_profile_btn;

    @FindBy(xpath = "//p[text()='Edit']")
    private WebElement EditButton_Hover;

    @FindBy(xpath = "//p[text()='Delete']")
    private WebElement DeleteHover_btn;

    @FindBy(xpath = "//button[@aria-label='Organization is one of your family, restaurant, office, working space, etc. Inside an organization, you can create some groups, departments. Groups can have family members or some of your employees']//i[@class='icon iconfont icon-ic_about']")
    private WebElement Information_Icon1;

    @FindBy(xpath = "//button[@aria-label='Organization code is the unique code for the system to identify your organization. You can modify the organization name later, but the organization code will not change. You can use combinations of letters and numbers to form an organization code. Easy-to-remember organization code will help you find relevant information faster. Example: Office954, MyHome001']//i[@class='icon iconfont icon-ic_about']")
    private WebElement Information_Icon2;

    @FindBy(xpath = "(//button[normalize-space()='Enter'])[1]")
    private WebElement EnterOrganizationBtn;

    @FindBy(css = "button[aria-label='Delete'] svg")
    private WebElement DeleteOrganizationBtn;

    @FindBy(xpath = "(//button[normalize-space()='Check Asset'])[1]")
    private WebElement AssertBtn;

    @FindBy(xpath = "//*[text()='to activate delete']/following::div[1]//input")
    private WebElement ActivationCodeField;

    @FindBy(xpath = "(//button[normalize-space()='Delete organization permanently'])[1]")
    private WebElement DeletePermanetlybtn;

    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    private WebElement DeleteOrgPopupWindow;

    @FindBy(xpath = "//button[@aria-label='Edit']//*[name()='svg']")
    private WebElement EditorganizationBtn;

    @FindBy(css = "div[class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl css-msgv56']")
    private WebElement EditOrganizationtextField;

    @FindBy(xpath = "(//button[normalize-space()='Confirm'])[1]")
    private WebElement organizationEditConfirmbtn;

    @FindBy(xpath = ("//div[@id='notistack-snackbar']//*[name()='svg']"))
    private WebElement Validate_Edit_Toast_message;

    @FindBy(xpath = "//p[text()='This field is required!']")
    private WebElement Validate_OrgNametextfield;

    @FindBy(css = "input[id=':r14:']")
    private WebElement EnterOrganizatioName;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElement OrgCancelBtn;

    @FindBy(css = "body > div.MuiDrawer-root.MuiDrawer-modal.MuiModal-root.css-y28f86 > div.MuiPaper-root.MuiPaper-elevation.MuiPaper-elevation16.MuiDrawer-paper.MuiDrawer-paperAnchorRight.css-1ab2xsx > div > div.MuiGrid-root.css-lac5ca > div.MuiGrid-root.css-rfnosa > div > div")
    private WebElement changeCountryDropdown;

    @FindBy(xpath = "//label[text()='Add photos']")
    private WebElement EditProfilePhotoIcon;

    @FindBy(xpath = "(//ul[@role='listbox'])[1]//li")
    private List<WebElement> CountryListFororganization;

    @FindBy(xpath="//*[text()='Name cannot exceed 200 characters in length.']")
    private WebElement Org_Name_Exceeds_200chars;

    @FindBy(xpath = "//*[text()='Organization Deleted Successfully']")
    private WebElement Organization_Deleted_Successfully;

    @FindBy(xpath="//button[text()='Cancel']")
    private WebElement Organization_Delete_Cancel_btn;

    @FindBy(xpath="//input[@type='file']")
    private WebElement Upload_Photo_uploadicon;

    @FindBy(xpath="(//*[text()='Photos size up to maximum 3 MB'])[1]")
    private WebElement ProfilePhoto_With_4MB;



    public WebElement getOrganizationManagementBtn() {
        return OrganizationManagementBtn;
    }

    public WebElement getOrganization_profile_btn() {
        return organization_profile_btn;
    }

    public WebElement getEditButton_Hover() {
        return EditButton_Hover;
    }

    public WebElement getDeleteHover_btn() {
        return DeleteHover_btn;
    }

    public WebElement getInformation_Icon1() {
        return Information_Icon1;
    }

    public WebElement getInformation_Icon2() {
        return Information_Icon2;
    }

    public WebElement getSelectOrganizationdropdown() {
        return SelectOrganizationdropdown;
    }

    public WebElement getEnterOrganizationBtn() {
        return EnterOrganizationBtn;
    }

    public WebElement getDeleteOrganizationBtn() {

        return DeleteOrganizationBtn;
    }

    public WebElement getAssertBtn() {
        return AssertBtn;
    }

    public WebElement getActivationCodeField() {
        return ActivationCodeField;
    }

    public WebElement getDeletePermanetlybtn() {
        return DeletePermanetlybtn;
    }

    public WebElement getDeleteOrgPopupWindow() {
        return DeleteOrgPopupWindow;
    }

    public WebElement getEditorganizationBtn() {
        return EditorganizationBtn;
    }

    public WebElement getEditOrganizationtextField() {
        return EditOrganizationtextField;
    }

    public WebElement getorganizationEditConfirmbtn() {
        return organizationEditConfirmbtn;
    }

    public WebElement getValidate_Edit_Toast_message() {
        return Validate_Edit_Toast_message;
    }

    public WebElement getValidate_OrgNametextfield() {
        return Validate_OrgNametextfield;
    }

    public WebElement getEnterOrganizatioName() {
        return EnterOrganizatioName;
    }

    public WebElement getOrgCancelBtn() {
        return OrgCancelBtn;
    }

    public WebElement getchangeCountryDropdown() {
        return changeCountryDropdown;
    }

    public WebElement getEditProfilePhotoIcon() {
        return EditProfilePhotoIcon;
    }

    public List<WebElement> getCountryListFororganization() {
        return CountryListFororganization;
    }

    public WebElement   getOrg_Name_Exceeds_200chars(){
        return  Org_Name_Exceeds_200chars;
    }

    public WebElement getOrganization_Deleted_Successfully(){
        return Organization_Deleted_Successfully;
    }

    public WebElement getOrganization_Delete_Cancel_btn(){
        return Organization_Delete_Cancel_btn;
    }

    public WebElement getUpload_Photo_uploadicon(){
        return Upload_Photo_uploadicon;
    }

    public WebElement getProfilePhoto_With_4MB(){
        return ProfilePhoto_With_4MB;
    }
    
    
//    parv's code 
    @FindBy(xpath = "//button[text()='Confirm']")
    private WebElement ConfirmButtonforPerson;
 
    public WebElement getConfirmButtonforPerson() {
        return ConfirmButtonforPerson;
    }
    
    @FindBy(xpath = "//p[text()='Organization Management']/parent::div")
    private WebElement OrganizationManagementmodule;
 
    public WebElement getOrganizationManagementmodule() {
        return OrganizationManagementmodule;
    }
    @FindBy(xpath = "//p[text()='Department']")
    private WebElement Department;
 
    public WebElement getDepartment() {
        return Department;
    }

    @FindBy(xpath = "//span[text()='Add']")
    private WebElement AddDepartmentButton;
 
    public WebElement getAddDepartmentButton() {
        return AddDepartmentButton;
    }
    @FindBy(xpath = "//input[@placeholder='Department Name']")
    private WebElement DepartmentName;
 
    public WebElement getDepartmentName() {
        return DepartmentName;
    }
    
    @FindBy(xpath = "//input[@placeholder='Department Code']")
    private WebElement DepartmentCode;
 
    public WebElement getDepartmentCode() {
        return DepartmentCode;
    }
    //parv's code
    
    @FindBy(xpath = "//p[text()='Person']")
    private WebElement PersonSubModule;
 
    public WebElement getPersonSubModule() {
        return PersonSubModule;
    }
    @FindBy(xpath = "//span[text()='Add']")
    private WebElement AddPersonButton;
 
    public WebElement getAddPersonButton() {
        return AddPersonButton;
    }
    @FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd MuiAutocomplete-input MuiAutocomplete-inputFocused css-g2p069']")
    private WebElement departmentsearch;
 
    public WebElement getdepartmentsearch() {
        return departmentsearch;
    }
    @FindBy(xpath = "//*[@name='code']")
    private WebElement PersonIDTextField;
 
    public WebElement getPersonIDTextField() {
        return PersonIDTextField;
    }
 
    @FindBy(xpath = "//*[@name='firstName']")
    private WebElement firstNameTextField;
 
    public WebElement getfirstNameTextField() {
        return firstNameTextField;
    }
 
    @FindBy(xpath = "//*[@name='lastName']")
    private WebElement lastNameTextField;
 
    public WebElement getlastNameTextField() {
        return lastNameTextField;
    }
    
    
    
    

    public static void ValidateAllTheMentionedCountryListInEditOrganization(WebDriver driver, OrganizationManagement organization) throws Exception {
        resetZoomToDefault();
//        wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_profile_btn())).click();
//        wait.until(ExpectedConditions.elementToBeClickable(organization.getEditorganizationBtn())).click();
        Thread.sleep(2000);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(organization.getchangeCountryDropdown())).click();
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(organization.getchangeCountryDropdown()));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", dropdown);
        Thread.sleep(2000);
        List<WebElement> countryList = organization.getCountryListFororganization();
        System.out.println("Available Countries:");
        for (WebElement country : countryList) {
            System.out.println(country.getText());
        }
        WebElement unitedKingdomOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='United Kingdom']")));
        unitedKingdomOption.click();
    }

    public static void userCanUpdateTheProfilePhotoWhichIsMoreThanMBSize(WebDriver driver,OrganizationManagement organization) throws Exception {
        resetZoomToDefault();
        wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_profile_btn())).click();
        wait.until(ExpectedConditions.elementToBeClickable(organization.getEditorganizationBtn())).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(organization.getEditProfilePhotoIcon())).click();
        Thread.sleep(4000);
        WebElement uploadElement = organization.getUpload_Photo_uploadicon();
        uploadElement.sendKeys("C:\\Users\\syedjeelan\\Desktop\\NGTeco_WEB_Automation\\NGTecoWeb_master (1)\\NGTecoWeb_master\\src\\test\\resources\\3MB_Pic.lnk");
        Thread.sleep(2000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(organization.getOrgCancelBtn())).click();
        wait.until(ExpectedConditions.elementToBeClickable(organization.getEditorganizationBtn())).click();
        //wait.until(ExpectedConditions.elementToBeClickable(organization.getEditProfilePhotoIcon())).click();
        WebElement uploadElement1=organization.getUpload_Photo_uploadicon();
        uploadElement1.sendKeys("C:\\Users\\syedjeelan\\Desktop\\NGTeco_WEB_Automation\\NGTecoWeb_master (1)\\NGTecoWeb_master\\src\\test\\resources\\4mb_image.jpg");
        wait.until(ExpectedConditions.visibilityOf(organization.getProfilePhoto_With_4MB())).isDisplayed();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

}






