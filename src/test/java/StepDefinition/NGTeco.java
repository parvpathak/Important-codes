package StepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static pageObject.Attendance.*;
import static pageObject.Login.loginScenariomethod;
import static pageObject.OrganizationManagement.ValidateAllTheMentionedCountryListInEditOrganization;
import static pageObject.OrganizationManagement.resetZoomToDefault;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Properties;
import java.awt.Robot;
import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.es.E;
import org.apache.poi.ooxml.util.TransformerHelper;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.Wait;
import pageObject.Attendance;
import pageObject.Dashboard;
import pageObject.Login;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
//import pageObjects.Login;
//import pageObjects.Superuser;
//import pageObjects.customerPageObjects;
//import pageObjects.graphicDesignerPageObjects;
import pageObject.OrganizationManagement;
import utils.Base;
import utils.ReusableFunctions;

public class NGTeco extends Base {

	//	private static final int T = 0;
	String email = "test" + RandomStringUtils.randomAlphanumeric(5) + "@example.com";
	String password = "R" + RandomStringUtils.randomAlphanumeric(5) + "a1@";
	String organizationName_200 = RandomStringUtils.randomAlphabetic(201);
	String YourNewOrganizationName = RandomStringUtils.randomAlphabetic(10);
	String Invalid_personId = RandomStringUtils.randomAlphabetic(5);
	String Invalid_personName = RandomStringUtils.randomAlphabetic(5);
	String RandomTimeSheetName = RandomStringUtils.randomAlphabetic(5);
	private WebDriver driver;
	private Properties properties;
	private JavascriptExecutor js;
	public Login login;

	//syed code
	static File upload_file;
	public Attendance attendance;
	public ReusableFunctions reus;
	WebElement scrollContainer1;
	public Dashboard dashboard;
	public OrganizationManagement organization;
//	public OrganizationManagement organizationManagement;
	
	WebDriverWait wait;

	@Before("@NGTeco")
	public void setup() throws Exception {
		properties = new Properties();
		FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\data.properties");
		//Syed code
		FileInputStream fis = new FileInputStream(".//src//test//resources//data.properties");
		upload_file = new File(System.getProperty("user.dir") + "//src//test//resources//3MB_Pic.lnk");
		upload_file = new File(System.getProperty("user.dir") + "//src//test//resources//4mb_image.jpg");
		properties.load(fis1);
		// driver = initializeDriver("chrome", "x64", "Linux");
		driver = initializeDriver("chrome", "x64", "windows");
		driver.manage().window().maximize();
		login = new Login(driver);
		//Syed code
		attendance = new Attendance(driver);
		dashboard = new Dashboard(driver);
		organization = new OrganizationManagement(driver);
		reus =new ReusableFunctions();
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='67%'");
		Robot robot = new Robot();
	}

	public String getTodayDateAsNumber() {
		return LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
	}

	public String getCurrentTimeAsNumber() {
		return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
	}


	@After("@NGTeco")
	public void teardown(Scenario scenario) throws IOException, InterruptedException {
		if (scenario.isFailed()) {
			scenario.attach(getByteScreenshot(driver), "image/png", "screenshot name");
		}
		driver.close();
		driver.quit();
	}

	private byte[] getByteScreenshot(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Given("User has launched the URL")
	public void User_has_launched_the_URL() throws Exception {
		driver.get(properties.getProperty("URL"));
		windowMinimize(4);
	}

	public void resetZoomToDefault() throws Exception {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_0);
		r.keyRelease(KeyEvent.VK_0);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}

	@Given("user will provide valid username and password")
	public void userWillProvideValidUsernameAndPassword() {
		login.getusernameField().sendKeys(properties.getProperty("emailAddress"));
		login.getuserpasswordTextField().sendKeys(properties.getProperty("password"));
	}

	@When("user will click on Login button")
	public void userWillClickOnLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(login.getLoginButton())).click();
	}

	
	
	
	@Given("user login to the application")
	public void userlogintotheapplication() throws Exception {

		Login loginFeature = new Login(driver);
		loginScenariomethod(driver, login);
//		driver.get(properties.getProperty("URL"));
//		login.getusernameField().sendKeys(properties.getProperty("AdminEmailId"));
//		login.getuserpasswordTextField().sendKeys(properties.getProperty("AdminPassword"));
//		wait.until(ExpectedConditions.elementToBeClickable(login.getLoginButton())).click();
//		wait.until(ExpectedConditions.urlContains("/dashboard"));
	}

	//syed code
	@Given("when Admin click on Attendance module")
	public void whenAdminclickonAttendancemodule() {
		AttendanceModuleMethod(driver, attendance);
		//wait.until(ExpectedConditions.elementToBeClickable(attendance.getAttendance_Module())).click();
	}

	@And("Selected View Attendance punch")
	public void SelectedViewAttendancepunch() {

		Attendance.SelectedViewAttendancepunch(driver, attendance);
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getView_Attendance_Punch())).click();
//		wait.until(ExpectedConditions.urlContains("/transaction"));
	}

	@Then("validated all the components are displaying or not")
	public void validatedallthecomponentsaredisplayingornot() {
		attendance.getViewAllHeadersData();
	}

	@Then("upload the transcations for the selected date")
	public void uploadthetranscationsfortheselecteddate() {
		attendance.getUploadTranscationIcon().click();
	}

	@When("user selects the chatbot and entered the message")
	public void userSelectsTheChatbotAndEnteredTheMessage() throws Exception {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.userSelectsTheChatbotAndEnteredTheMessage(driver, dashboard);

//			wait.until(ExpectedConditions.elementToBeClickable(dashboard.getChatBot())).click();
//			Thread.sleep(4000);
//			WebElement inputBoxes = dashboard.getenterDataInsideChatBot();
//				wait.until(ExpectedConditions.visibilityOf(inputBoxes));
//			inputBoxes.sendKeys("Hello, how can I get help?");
//				Thread.sleep(4000);
	}

	@Then("user should able to get the response from chat bot")
	public void userShouldAbleToGetTheResponseFromChatBot() throws AWTException, InterruptedException {

		dashboard.userShouldAbleToGetTheResponseFromChatBot(driver, dashboard);
//			wait.until(ExpectedConditions.elementToBeClickable(dashboard.getChatBotSendButton())).click();
//			Thread.sleep(4000);
//			WebElement chatResponse = dashboard.getDisplayedTextAfterAfterEnteringDataOnChatBot();
//			try {
//				if (wait.until(ExpectedConditions.visibilityOf(chatResponse)).isDisplayed()) {
//					String botResponseText = chatResponse.getText();
//					System.out.println("Chatbot replied: " + botResponseText);
//				} else {System.out.println("Oops! Something went wrong. Could you please check back later?");
//				}
//			} catch (TimeoutException e) {
//				System.out.println("Oops! Something went wrong. Could you please check back later?");}}

	}

	@Then("user close the chatBot window")
	public void userCloseTheChatBotWindow() {
		wait.until(ExpectedConditions.elementToBeClickable(dashboard.getEndChatButton())).click();
	}

	@When("User launch the chatBot window")
	public void userLaunchTheChatBotWindow() throws Exception {
		resetZoomToDefault();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard.getChatBot())).click();
	}

	@Then("User should scroll the chatBot window from bottom to top and from top to bottom")
	public void UsershouldscrollthechatBotwindowfrombottomtotopandfromtoptobottom() throws InterruptedException {

		dashboard.UsershouldscrollthechatBotwindowfrombottomtotopandfromtoptobottom(driver, dashboard);
//		WebElement inputBoxes = dashboard.getenterDataInsideChatBot();
//		wait.until(ExpectedConditions.visibilityOf(inputBoxes));
//		inputBoxes.sendKeys("I want more information about NGteco Application");
//		wait.until(ExpectedConditions.elementToBeClickable(dashboard.getChatBotSendButton())).click();
//		Thread.sleep(4000);
//		wait.until(ExpectedConditions.visibilityOf(inputBoxes));
//		inputBoxes.sendKeys("Hello, how can I get help?");
//		WebElement chatScrollContainer = dashboard.getChatBotScrollContainer(); // Replace with actual method
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", chatScrollContainer);
//		Thread.sleep(2000); // Optional: wait to observe scroll
//		js.executeScript("arguments[0].scrollTop = 0;", chatScrollContainer);
//		wait.until(ExpectedConditions.elementToBeClickable(dashboard.getMinimizeChatBotButton())).click();
	}

	@Then("User should delete the conversation by clicking on delete button")
	public void userEnteredDataBySelectingBoldItalicOrderedListItemAndUnorderedListItem() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(dashboard.getDeleteChatBtn())).click();
	}

	@When("user click on organization management submodule")
	public void userClickOnOrganizationManagementSubmodule() throws Exception {
		resetZoomToDefault();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganizationManagementBtn())).click();
	}

	@Given("user login to the application with valid credentials")
	public void userLoginToTheApplicationWithValidCredentials() throws InterruptedException {
		driver.get(properties.getProperty("URL"));
		login.getusernameField().sendKeys(properties.getProperty("OldEmailId"));
		login.getuserpasswordTextField().sendKeys(properties.getProperty("Oldpassword"));
		wait.until(ExpectedConditions.elementToBeClickable(login.getLoginButton())).click();
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(organization.getSelectOrganizationdropdown()));
		dropdown.click();
		Actions actions = new Actions(driver);
		String organizationName = "DKMk";
		actions.sendKeys(dropdown, organizationName).perform();
		Thread.sleep(500);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		organization.getEnterOrganizationBtn().click();
		wait.until(ExpectedConditions.urlContains("/dashboard"));
	}

	@Then("User entered inside organization profile home page")
	public void userEnteredInsideOrganizationProfileHomePage() throws Exception {
		resetZoomToDefault();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_profile_btn())).click();
		assertTrue(organization.getEditButton_Hover().isDisplayed());
		assertTrue(organization.getDeleteHover_btn().isDisplayed());
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		organization.getInformation_Icon1().click();
		Thread.sleep(4000);
		organization.getInformation_Icon2().click();
	}

	@Then("User trying to delete the organization permanently")
	public void userTryingToDeleteTheOrganizationPermanently() throws Exception {
		//wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_profile_btn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getDeleteOrganizationBtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getAssertBtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getActivationCodeField())).sendKeys(properties.getProperty("DeleteorganizationCode"));
		wait.until(ExpectedConditions.elementToBeClickable(organization.getDeletePermanetlybtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getDeleteOrgPopupWindow())).click();
		wait.until(ExpectedConditions.visibilityOf(organization.getOrganization_Deleted_Successfully())).isDisplayed();
	}

	@Then("User is trying to edit profile by leaving Mandatory field")
	public void userIsTryingToEditProfileByLeavingMandatoryField() throws Exception {
		resetZoomToDefault();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getEditorganizationBtn())).click();
		WebElement editField = wait.until(ExpectedConditions.visibilityOf(organization.getEditOrganizationtextField()));
		Actions actions = new Actions(driver);
		actions.click(editField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getorganizationEditConfirmbtn())).click();
		wait.until(ExpectedConditions.visibilityOf(organization.getValidate_OrgNametextfield())).getText();
	}

	@Then("user Edit the organization profile and saving the details")
	public void userEditTheOrganizationProfileAndSavingTheDetails() throws Exception {
		resetZoomToDefault();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_profile_btn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getEditorganizationBtn())).click();
		WebElement editField = wait.until(ExpectedConditions.visibilityOf(organization.getEditOrganizationtextField()));
		Actions actions = new Actions(driver);
		actions.click(editField)
				.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.BACK_SPACE)
				.sendKeys(YourNewOrganizationName)
				.perform();
	}

	@Then("User click on cancel button and redirecting to organization profile page")
	public void userClickOnCancelButtonAndRedirectingToOrganizationProfilePage() throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrgCancelBtn())).click();
	}

	@Then("User is trying to delete the organization")
	public void userIsTryingToDeleteTheOrganization() {
		wait.until(ExpectedConditions.visibilityOf(organization.getDeleteHover_btn())).click();
	}

	@Then("User enters the invalid country name and trying to save the details")
	public void userEntersTheInvalidCountryNameAndTryingToSaveTheDetails() throws Exception {
		resetZoomToDefault();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_profile_btn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getEditorganizationBtn())).click();
		organization.getchangeCountryDropdown().click();
		WebElement editField = wait.until(ExpectedConditions.visibilityOf(organization.getchangeCountryDropdown()));
		Actions actions = new Actions(driver);
		actions.click(editField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getorganizationEditConfirmbtn())).click();
	}

	@Then("User selects the country from the dropdown and save the organization details")
	public void userSelectsTheCountryFromTheDropdownAndSaveTheOrganizationDetails() throws Exception {
		resetZoomToDefault();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_profile_btn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getEditorganizationBtn())).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wait.until(ExpectedConditions.elementToBeClickable(organization.getchangeCountryDropdown())).click();
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOf(organization.getchangeCountryDropdown()));
		js.executeScript("arguments[0].click();", dropdown);
		Thread.sleep(2000);
		WebElement unitedKingdomOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='United Kingdom']")));
		unitedKingdomOption.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(organization.getorganizationEditConfirmbtn())).click();
		wait.until(ExpectedConditions.visibilityOf(organization.getValidate_Edit_Toast_message())).isDisplayed();
	}

	@Then("User upload the organization profile image successfully")
	public void userUploadTheOrganizationProfileImageSuccessfully() throws Exception {
		resetZoomToDefault();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(organization.getEditProfilePhotoIcon())).click();
		Thread.sleep(4000);
		WebElement uploadElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));
		uploadElement.sendKeys("C:\\Users\\syedjeelan\\Pictures\\1.jpg");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(organization.getorganizationEditConfirmbtn())).click();
		wait.until(ExpectedConditions.visibilityOf(organization.getValidate_Edit_Toast_message())).isDisplayed();
		boolean isUploaded = wait.until(ExpectedConditions.visibilityOf(organization.getValidate_Edit_Toast_message())).isDisplayed();
		if (isUploaded) {
			System.out.println("Profile picture uploaded successfully.");
		} else System.out.println("Failed to upload profile picture.");
	}


	@Then("User validate all the mentioned country list in Edit organization")
	public void userValidateAllTheMentionedCountryListInEditOrganization() throws Exception {

		OrganizationManagement organization = new OrganizationManagement(driver);
		ValidateAllTheMentionedCountryListInEditOrganization(driver, organization);

//		resetZoomToDefault();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		wait.until(ExpectedConditions.elementToBeClickable(organization.getchangeCountryDropdown())).click();
//		WebElement dropdown = wait.until(ExpectedConditions.visibilityOf(organization.getchangeCountryDropdown()));
//		js.executeScript("arguments[0].click();", dropdown);
//		Thread.sleep(2000);
//		List<WebElement> countrylist = organization.getCountryListFororganization();
//		System.out.println("Available Countries:");
//		for (WebElement country : countrylist) {
//			System.out.println(country.getText());}
//		WebElement unitedKingdomOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='United Kingdom']")));
//		unitedKingdomOption.click();
	}

	@Then("user should validate the all the components inside View Attendance punch")
	public void userShouldValidateTheAllTheComponentsInsideViewAttendancePunch() {
		ValidateTheAllTheComponentsInsideViewAttendancePunch(driver, attendance);
	}

	@Then("User should delete the chatBot successfully")
	public void userShouldDeleteTheChatBotSuccessfully() throws InterruptedException {
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
		wait.until(ExpectedConditions.elementToBeClickable(dashboard.getDeleteChatBtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard.getEndChatButton())).click();
	}

	@Then("User is trying to update the name field by entering more than {int} characters")
	public void userIsTryingToUpdateTheNameFieldByEnteringMoreThanCharacters(int arg0) throws Exception {
		resetZoomToDefault();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_profile_btn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getEditButton_Hover())).click();
//		WebElement editField = wait.until(ExpectedConditions.visibilityOf(organization.getEditOrganizationtextField()));
//		Thread.sleep(200);
		WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(organization.getEditOrganizationtextField()));
		Actions actions = new Actions(driver);
		actions.click(inputField)
				.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.BACK_SPACE)
				.sendKeys(organizationName_200)
				.perform();
		//Actions actions = new Actions(driver);
		//actions.click(inputField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();
		//inputField.clear();
		// organization.getEditOrganizationtextField().sendKeys(properties.getProperty("organizationName_200"));
		wait.until(ExpectedConditions.elementToBeClickable(organization.getorganizationEditConfirmbtn())).click();
		WebElement toastMessage = wait.until(ExpectedConditions.visibilityOf(organization.getOrg_Name_Exceeds_200chars()));
		if (toastMessage.isDisplayed())
			System.out.println("Stating the error message" + toastMessage);
	}

	@Then("User trying to delete the organization permanently by having atleast one employee")
	public void userTryingToDeleteTheOrganizationPermanentlyByHavingAtleastOneEmployee() throws Exception {
		resetZoomToDefault();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_profile_btn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getDeleteOrganizationBtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getAssertBtn())).click();
	}

	@Then("User trying to cancel the delete organization operation")
	public void userTryingToCancelTheDeleteOrganizationOperation() {
		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_profile_btn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getDeleteOrganizationBtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getAssertBtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getActivationCodeField())).sendKeys(properties.getProperty("Delete_organizationCode"));
		wait.until(ExpectedConditions.elementToBeClickable(organization.getDeletePermanetlybtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_Delete_Cancel_btn())).click();
	}

	@Given("user login to the application with new credentials")
	public void userLoginToTheApplicationWithNewCredentials() throws InterruptedException {
		driver.get(properties.getProperty("URL"));
		login.getusernameField().sendKeys(properties.getProperty("New_EmailID"));
		login.getuserpasswordTextField().sendKeys(properties.getProperty("New_Password"));
		wait.until(ExpectedConditions.elementToBeClickable(login.getLoginButton())).click();
		wait.until(ExpectedConditions.urlContains("/dashboard"));
	}

	@Then("User should view the mend punches by enabling mend attendance")
	public void userShouldViewTheMendPunchesByEnablingMendAttendance() {
		MendPunch_Enable_code(driver, attendance);
	}
	@Then("user can update the profile photo which is more than {int}MB size")
	public void userCanUpdateTheProfilePhotoWhichIsMoreThanMBSize(int arg0) throws Exception {
		organization.userCanUpdateTheProfilePhotoWhichIsMoreThanMBSize(driver, organization);
//		resetZoomToDefault();
//		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrganization_profile_btn())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(organization.getEditorganizationBtn())).click();
//		Thread.sleep(2000);
//		wait.until(ExpectedConditions.elementToBeClickable(organization.getEditProfilePhotoIcon())).click();
//		Thread.sleep(4000);
//		WebElement uploadElement = organization.getUpload_Photo_uploadicon();
//		uploadElement.sendKeys("C:\\Users\\syedjeelan\\Desktop\\NGTeco_WEB_Automation\\NGTecoWeb_master (1)\\NGTecoWeb_master\\src\\test\\resources\\3MB_Pic.lnk");
//		Thread.sleep(2000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_ESCAPE);
//		robot.keyRelease(KeyEvent.VK_ESCAPE);
//		Thread.sleep(2000);
//		wait.until(ExpectedConditions.elementToBeClickable(organization.getOrgCancelBtn())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(organization.getEditorganizationBtn())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(organization.getEditProfilePhotoIcon())).click();
//		WebElement uploadElement1=organization.getUpload_Photo_uploadicon();
//		uploadElement1.sendKeys("C:\\Users\\syedjeelan\\Desktop\\NGTeco_WEB_Automation\\NGTecoWeb_master (1)\\NGTecoWeb_master\\src\\test\\resources\\4mb_image.jpg");
//		wait.until(ExpectedConditions.visibilityOf(organization.getProfilePhoto_With_4MB())).isDisplayed();
//		robot.keyPress(KeyEvent.VK_ESCAPE);
//		robot.keyRelease(KeyEvent.VK_ESCAPE);
		//Thread.sleep(4000);
	}

	@Then("User will perform the sort operation using person name,person id,Attendance record,Time Zone and Source")
	public void userWillPerformTheSortOperationUsingPersonNamePersonIdAttendanceRecordTimeZoneAndSource() throws InterruptedException, IOException {
		Attendance attendance = new Attendance(driver);
		Sort_ArrowClass(driver, attendance);
	}

	@Then("user filter the record using person name and id fields")
	public void userFilterTheRecordUsingPersonNameAndIdFields() throws IOException, InterruptedException {
		Attendance attendance = new Attendance(driver);
		FilterClass(driver, attendance, Invalid_personId, Invalid_personName);
	}

	@Then("User should able to glance the the information in the usage Tips")
	public void userShouldAbleToGlanceTheTheInformationInTheUsageTips() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getUsage_tips_icon())).click();
		Thread.sleep(2000);
	}

	@Then("user should be able to export the records in CSV and Excel format")
	public void userShouldBeAbleToExportTheRecordsInCSVAndExcelFormat() {

		FileDownloadFormat(driver, attendance);
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getDownload_reports_icon())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getXlsX_download_format())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getDownload_reports_icon())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getCSV_Download_Format())).click();

	}

	@Then("user upload the transcations from the given input date")
	public void userUploadTheTranscationsFromTheGivenInputDate() {
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getDownload_transcation_icon())).click();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getFromDate_label())).click();
		WebElement FromDate = wait.until(ExpectedConditions.elementToBeClickable(attendance.getFromDate_label()));
		Actions actions = new Actions(driver);
		actions.click(FromDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(properties.getProperty("From_Date")).perform();
		WebElement ToDate = wait.until(ExpectedConditions.elementToBeClickable(attendance.getToDate_label()));
		Actions action = new Actions(driver);
		action.click(ToDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(properties.getProperty("Future_Date")).perform();
		//wait.until(ExpectedConditions.elementToBeClickable(attendance.getFromDate_label())).click();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.gettranscation_Confirm_btn())).click();
		//wait.until(ExpectedConditions.elementToBeClickable(attendance.getFutureDate_ErrorMessage())).isDisplayed();
		action.click(ToDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(getTodayDateAsNumber()).perform();
		//wait.until(ExpectedConditions.elementToBeClickable(attendance.gettranscation_Confirm_btn())).click();
		///action.click(ToDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(properties.getProperty("yesterday_date_change_Every_Run")).perform();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.gettranscation_Confirm_btn())).click();
	}

	@Then("User will refresh the page and records should listed properly")
	public void userWillRefreshThePageAndRecordsShouldListedProperly() {
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getView_Attedance_refresh())).click();
	}

	@Then("user should list the records by selecting Ten twenty and Fifty per page")
	public void usershouldlisttherecordsbyselectingTentwentyandFiftyperpage() throws Exception {
		userShouldListTheRecordsBySelecting(driver, attendance);
	}

	@Then("user should navigate to next and previous page")
	public void userShouldNavigateToNextAndPreviousPage() throws Exception {
		attendance.Next_previous_page(driver, attendance);
	}

	@When("user select the Mend Attendance punch")
	public void userSelectTheMendAttendancePunch() {
		SelectMendAtt_Punch_Method(driver, attendance);
		//wait.until(ExpectedConditions.elementToBeClickable(attendance.getMend_Attendance_punch_submodule())).click();
	}

	@Then("User should validate the presence of all components in that page")
	public void userShouldValidateThePresenceOfAllComponentsInThatPage() throws Exception {
		resetZoomToDefault();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(attendance.getMend_Attendance_punch_Header())).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(attendance.getSearch_Field_display_btn())).isDisplayed();
		List<WebElement> HeaderList = attendance.getView_Attendance_All_Headers();
		System.out.println("Available Headers:");
		for (WebElement headers : HeaderList) {
			System.out.println(headers.getText() + "\t");
		}
		List<WebElement> listrecords = attendance.getView_Page_Records();
		System.out.println("Available records");
		for (WebElement total_Rec : listrecords) {
			System.out.println(total_Rec.getText());
		}
	}

	@Then("User should filter the records based on punch date")
	public void userShouldFilterTheRecordsBasedOnPunchDate() throws InterruptedException {

		Attendance.userShouldFilterTheRecordsBasedOnPunchDate(driver, attendance);
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getPunch_State_Filter_Icon())).click();
//		Thread.sleep(3000);
//		wait.until(ExpectedConditions.visibilityOf(attendance.getStart_Date_punch_Filter())).sendKeys(properties.getProperty("Punch_StartDate"));
//		Thread.sleep(3000);
//		wait.until(ExpectedConditions.visibilityOf(attendance.getEnd_Date_Punch_Filter())).sendKeys(properties.getProperty("Punch_EndDate"));
//		Thread.sleep(3000);
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getPunch_State_Filter_Icon())).click();
	}

	@Then("user should validate the Add mend attendance page")
	public void userShouldValidateTheAddMendAttendancePage() {
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getAdd_mend_Attendance_btn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getAdd_MendAtt_confirm_btn())).click();

	}

	@Then("User should successfully add person to the mend punch")
	public void userShouldSuccessfullyAddPersonToTheMendPunch() throws Exception {
		Attendance.userShouldSuccessfullyAddPersonToTheMendPunch(driver, attendance);

//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getAdd_mend_Attendance_btn())).click();
//    wait.until(ExpectedConditions.elementToBeClickable(attendance.getAdd_person_DropdownTF())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getNo_of_rows_icon())).click();
//		Thread.sleep(3000);
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getTen_records_per_page())).click();
//		Thread.sleep(3000);
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getNo_of_rows_icon())).click();
//		Thread.sleep(3000);
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getTwenty_records_per_page())).click();
//		Thread.sleep(3000);
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getNo_of_rows_icon())).click();
//		Thread.sleep(3000);
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getFiFTY_records_per_page())).click();
//		Thread.sleep(3000);
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getNo_of_rows_icon())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getTen_records_per_page())).click();
//		Thread.sleep(6000);
//		WebElement GoNextPage=
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getGO_TO_Next_page()));
//		if(GoNextPage.isEnabled()) {
//			GoNextPage.click();
//			Thread.sleep(6000);
//		}else System.out.println("Next Button is not enabled");
//		WebElement Previous_Btn=
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getGO_TO_Previous_Page()));
//		if(Previous_Btn.isEnabled()) {
//			Previous_Btn.click();
//		}else System.out.println("Previous button is not enabled");
//		//.sleep(2000);
//		WebElement inputFile1= wait.until(ExpectedConditions.elementToBeClickable(attendance.getFilter_search_bar_ViewAtt()));
//		inputFile1.sendKeys(properties.getProperty("Person_ID"));
//		Thread.sleep(3000);
//		Actions actions = new Actions(driver);
//		actions.click(inputFile1).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(Invalid_personId).perform();
//		Thread.sleep(2000);
//		Actions action = new Actions(driver);
//		WebElement inputFile= wait.until(ExpectedConditions.elementToBeClickable(attendance.getFilter_search_bar_ViewAtt()));
//		action.click(inputFile1).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();
//		inputFile.sendKeys(properties.getProperty("person_Name"));
//		Thread.sleep(2000);
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getSelect_First_record())).click();
//        wait.until(ExpectedConditions.elementToBeClickable(attendance.getMend_Att_confirm_btn())).click();

	}

	@Then("user should add the mend attendance successfully")
	public void userShouldAddTheMendAttendanceSuccessfully() {

		Attendance.userShouldAddTheMendAttendanceSuccessfully(driver, attendance);
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getAdd_mend_Attendance_btn())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getAdd_person_DropdownTF())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getSelect_First_record())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getMend_Att_confirm_btn())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getUserDefine_Date_Mend())).sendKeys(properties.getProperty("MendPunchDate"));
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getUserDefine_time())).sendKeys(properties.getProperty("Mendpunch_Time"));
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.gettranscation_Confirm_btn())).click();
//		wait.until(ExpectedConditions.visibilityOf(attendance.getSuccess_Popup_Message())).isDisplayed();
	}

	@Then("User should able to cancel the add functionality")
	public void userShouldAbleToCancelTheAddFunctionality() {

		Attendance.userShouldAbleToCancelTheAddFunctionality(driver, attendance);
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getAdd_mend_Attendance_btn())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getAdd_person_DropdownTF())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getSelect_First_record())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getMend_Att_confirm_btn())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getUserDefine_Date_Mend())).sendKeys(properties.getProperty("MendPunchDate"));
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getUserDefine_time())).sendKeys(properties.getProperty("Mendpunch_Time"));
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getAdd_medAtt_Cancel_btn())).click();
	}


	@Then("User should refresh the Mend attendance page and record should listed properly")
	public void userShouldRefreshTheMendAttendancePageAndRecordShouldListedProperly() {

		wait.until(ExpectedConditions.elementToBeClickable(attendance.getMend_ATT_Refresh_icon())).click();
	}

	@Then("user can update the mend record punch")
	public void userCanUpdateTheMendRecordPunch() {
		Attendance.userCanUpdateTheMendRecordPunch(driver, attendance);
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getEdit_mendAtt_punch())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getUserDefine_Date_Mend())).sendKeys(properties.getProperty("MendPunchDate"));
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getUserDefine_time())).sendKeys(properties.getProperty("Mendpunch_Time"));
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.gettranscation_Confirm_btn())).click();
//		wait.until(ExpectedConditions.visibilityOf(attendance.getValidate_Toast_Btn())).isDisplayed();
	}

	@Then("User can cancel the update functionality")
	public void userCanCancelTheUpdateFunctionality() {

		Attendance.userCanCancelTheUpdateFunctionality(driver, attendance);

//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getEdit_mendAtt_punch())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getUserDefine_Date_Mend())).sendKeys(properties.getProperty("MendPunchDate"));
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getUserDefine_time())).sendKeys(properties.getProperty("Mendpunch_Time"));
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getAdd_medAtt_Cancel_btn())).click();

	}

	@Then("user can delete the mend attendance punch")
	public void userCanDeleteTheMendAttendancePunch() {
		Attendance.userCanDeleteTheMendAttendancePunch(driver, attendance);
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getDelete_mend_Punch())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getDelete_confirm_btn())).click();
//		wait.until(ExpectedConditions.visibilityOf(attendance.getSuccess_Popup_Message())).isDisplayed();
	}

	@Then("User can cancel the delete operation")
	public void userCanCancelTheDeleteOperation() {
		Attendance.userCanCancelTheDeleteOperation(driver, attendance);
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getDelete_mend_Punch())).click();
//		wait.until(ExpectedConditions.elementToBeClickable(attendance.getcancel_the_Delete_optn())).click();

	}

	@Then("User can sort the record by using Mend record headers")
	public void userCanSortTheRecordByUsingMendRecordHeaders() {
		Sort_ArrowClass(driver, attendance);

	}

	@Then("user should to next page and the previous page")
	public void userShouldToNextPageAndThePreviousPage() throws Exception {

		Next_Page_Previous_page_With_single_record(driver, attendance);
	}

	@When("User selects Time card management submodule")
	public void userSelectsTimeCardManagementSubmodule() throws Exception {
//		resetZoomToDefault();
//         Thread.sleep(2000);
//		JavascriptExecutor je = (JavascriptExecutor) driver;
//		je.executeScript("arguments[0].scrollIntoView(true);",element);
//		Thread.sleep(2000);

		WebElement ScrollUntil = wait.until(ExpectedConditions.elementToBeClickable(attendance.getTime_card_Management_subModule()));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", ScrollUntil);
		ScrollUntil.click();
		Thread.sleep(2000);
	}

	@Then("User should validate all the components in Time card management page")
	public void userShouldValidateAllTheComponentsInTimeCardManagementPage() throws InterruptedException {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(attendance.getTime_card_Management_header())).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(attendance.getFilter_search_bar_ViewAtt())).isDisplayed();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement hoverElement = wait.until(ExpectedConditions.visibilityOf(attendance.getDownload_Hover_Btn()));
		Actions actions = new Actions(driver);
		actions.moveToElement(hoverElement).perform();
		WebElement FromDateVisibility = wait.until(ExpectedConditions.visibilityOf(attendance.getFrom_Date_Visibility()));
		Actions action = new Actions(driver);
		action.moveToElement(FromDateVisibility).perform();
		WebElement ToDate_Visibility = wait.until(ExpectedConditions.visibilityOf(attendance.getTo_Date_Visibility()));
		Actions action2 = new Actions(driver);
		action2.moveToElement(ToDate_Visibility).perform();
		List<WebElement> HeaderList = attendance.getView_Attendance_All_Headers();
		System.out.println("Available Headers:");
		for (WebElement headers : HeaderList) {
			System.out.println(headers.getText() + "\t");
		}
//		List<WebElement> listrecords =attendance.getView_Page_Records();
//		System.out.println("Available records");
//		for (WebElement total_Rec : listrecords) {
//			System.out.println(total_Rec.getText());}
	}

	@Then("User should view all the punches done for the current month")
	public void userShouldViewAllThePunchesDoneForTheCurrentMonth() throws InterruptedException {
		Thread.sleep(4000);
		List<WebElement> listrecords = attendance.getTo_Display_All_records();
		System.out.println("Available records");
		for (WebElement total_Rec : listrecords) {
			System.out.println(total_Rec.getText());
		}
	}

	@Then("User should view the abnormal reports by selecting abnormal records button")
	public void userShouldViewTheAbnormalReportsBySelectingAbnormalRecordsButton() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getAbNormalRecordsCB())).click();
		Thread.sleep(2000);
		List<WebElement> listrecords = attendance.getTo_Display_All_records();
		System.out.println("Available records");
		for (WebElement total_Rec : listrecords) {
			System.out.println(total_Rec.getText());
		}
	}

	@Then("User should able to filter the records using person name and timesheet")
	public void userShouldAbleToFilterTheRecordsUsingPersonNameAndTimesheet() throws InterruptedException {
		WebElement inputFile1 = wait.until(ExpectedConditions.elementToBeClickable(attendance.getFilter_search_bar_ViewAtt()));
		inputFile1.sendKeys(properties.getProperty("TMCard_PersonID"));
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.click(inputFile1).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(properties.getProperty("TimeSheet_Name")).perform();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		WebElement inputFile = wait.until(ExpectedConditions.elementToBeClickable(attendance.getFilter_search_bar_ViewAtt()));
		action.click(inputFile1).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();
		inputFile.sendKeys(properties.getProperty("TMCard_personName"));
		Thread.sleep(2000);
	}

	@Then("User can view the usage tips in Timecard_management")
	public void userCanViewTheUsageTipsInTimecard_management() throws Exception {
		resetZoomToDefault();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getUsage_tips_icon())).click();
		Thread.sleep(2000);
	}

	@Then("User can export the records by selecting from and Todate")
	public void userCanExportTheRecordsBySelectingFromAndTodate() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(attendance.getExport_RecordsBtn())).click();
		WebElement FromDate_textField = wait.until(ExpectedConditions.elementToBeClickable(attendance.getExport_From_Date()));
		FromDate_textField.click();
		Actions actions = new Actions(driver);
		actions.click(FromDate_textField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(properties.getProperty("From_Date")).perform();
		Thread.sleep(3000);
		WebElement ToDate = wait.until(ExpectedConditions.elementToBeClickable(attendance.getExport_To_Date()));
		ToDate.click();
		Actions action = new Actions(driver);
		action.click(ToDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(properties.getProperty("Future_Date")).perform();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.gettranscation_Confirm_btn())).click();
		//wait.until(ExpectedConditions.elementToBeClickable(attendance.getFutureDate_ErrorMessage())).isDisplayed();
		action.click(ToDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(getTodayDateAsNumber()).perform();
		wait.until(ExpectedConditions.visibilityOf(attendance.getText_Area_Field())).sendKeys(properties.getProperty("Email_id_Field"));
		wait.until(ExpectedConditions.elementToBeClickable(attendance.gettranscation_Confirm_btn())).click();

	}

	@Then("User should filter the records based on the selected date from the calender")
	public void userShouldFilterTheRecordsBasedOnTheSelectedDateFromTheCalender() throws InterruptedException {
		Thread.sleep(2000);
		WebElement FromDate_textField = wait.until(ExpectedConditions.elementToBeClickable(attendance.getFromDate_label()));
		FromDate_textField.click();
		Actions actions = new Actions(driver);
		actions.click(FromDate_textField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE);
		//.sendKeys(properties.getProperty("From_Date")).perform();
		FromDate_textField.sendKeys(properties.getProperty("From_Date"));
		Thread.sleep(3000);
		WebElement ToDate = wait.until(ExpectedConditions.elementToBeClickable(attendance.getToDate_label()));
		ToDate.click();
		Actions action = new Actions(driver);
		action.click(ToDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE);
		ToDate.sendKeys(properties.getProperty("Future_Date"));
		//sendKeys(properties.getProperty("Future_Date")).perform();
	}

	@Then("User can enable and send automatic report sending")
	public void userCanEnableAndSendAutomaticReportSending() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getExport_RecordsBtn())).click();
		WebElement FromDate_textField = wait.until(ExpectedConditions.elementToBeClickable(attendance.getExport_From_Date()));
		FromDate_textField.click();
		Actions actions = new Actions(driver);
		actions.click(FromDate_textField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(properties.getProperty("From_Date")).perform();
		Thread.sleep(3000);
		WebElement ToDate = wait.until(ExpectedConditions.elementToBeClickable(attendance.getExport_To_Date()));
		ToDate.click();
		Actions action = new Actions(driver);
		action.click(ToDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(getTodayDateAsNumber()).perform();
		wait.until(ExpectedConditions.visibilityOf(attendance.getText_Area_Field())).sendKeys(properties.getProperty("Email_id_Field"));
		WebElement chatScrollContainer = attendance.getScroll_bar_viewAtt();
		scrollTopToBottomAndBack(chatScrollContainer, driver);
		WebElement Automatic_SendingFRTDate = wait.until(ExpectedConditions.elementToBeClickable(attendance.getAutomatic_SendingFRTDate()));
		Automatic_SendingFRTDate.click();
		Actions act = new Actions(driver);
		act.click(Automatic_SendingFRTDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(properties.getProperty("From_Date")).perform();
		WebElement TimeForSendingReport = wait.until(ExpectedConditions.elementToBeClickable(attendance.getTimeForSendingReport()));
		TimeForSendingReport.click();
		Actions Input = new Actions(driver);
		Input.click(TimeForSendingReport).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE);
		TimeForSendingReport.sendKeys(properties.getProperty("ClockTime"));
		WebElement EmailShareList = wait.until(ExpectedConditions.elementToBeClickable(attendance.getEmailShareList()));
		EmailShareList.click();
		Actions EmailShare = new Actions(driver);
		EmailShare.click(EmailShareList).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(properties.getProperty("EmailShareList")).perform();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getSecondConfirmBtn())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getSuccessToastMessage())).isDisplayed();
	}

	@Then("User can export report sending in daily weekly or monthly wise")
	public void userCanExportReportSendingInDailyWeeklyOrMonthlyWise() throws InterruptedException {
		attendance.ExportRecordusingAutomaticReportToggle(driver, attendance);
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getWeeklYToggleBtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getSecondConfirmBtn())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getSuccessToastMessage())).isDisplayed();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getMonthlyToggleBtn())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getSuccessToastMessage())).isDisplayed();
	}

	@Then("User can export the record by disabling timeZone")
	public void userCanExportTheRecordByDisablingTimeZone() throws InterruptedException {
		attendance.CodeForDisableTimeZone(driver, attendance);
	}
//	@When("user will click on Login buttonf")
//	public void userWillClickOnLoginButtonf() {
//	}

	@Then("user can download the report by using XLSX or CSV format")
	public void userCanDownloadTheReportByUsingXLSXOrCSVFormat() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(attendance.getDownload_Hover_Btn())).click();
		List<WebElement> redTextRecords = attendance.getExportListRecord();
		for (WebElement record : redTextRecords) {
			record.click();
			wait.until(ExpectedConditions.elementToBeClickable(attendance.getSuccessToastMessage())).isDisplayed();
		}
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getDownload_Hover_Btn())).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getCSV_Download_Format())).click();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getSuccessToastMessage())).isDisplayed();
		Thread.sleep(2000);
	}

	@Then("user can Refresh the page and records should get listed properly")
	public void userCanRefreshThePageAndRecordsShouldGetListedProperly() throws InterruptedException {
		attendance.userCanRefreshThePageAndRecordsShouldGetListedProperly(driver, attendance);

//		WebElement BeforeText = attendance.getTotalRecordsForTimeCard();
//		String BeforeRefresh = BeforeText.getText();
//		System.out.println("📄 Before Refresh: " + BeforeRefresh);
//		List<WebElement> paginationBefore = attendance.getTimeCardRefreshBtn();
//
//		for(WebElement beforeText:paginationBefore) {
//
//			if (beforeText.isDisplayed()) {
//				//String beforeText = paginationBefore. ();
//				System.out.println("📄 Before Refresh: " + beforeText);
//			}
//		}
//		// Step 2: Click refresh
//		List<WebElement> refreshIcon =  attendance.getTimeCardRefreshBtn();
//		for(WebElement AfterSelecction:refreshIcon){
//			if(AfterSelecction.isDisplayed()){
//				AfterSelecction.click();
//			}
//		}
//		Thread.sleep(2000); // Or use WebDriverWait if data change is observable
//
//		// Step 3: Capture pagination text again
//		WebElement paginationAfter = attendance.getTotalRecordsForTimeCard();
//		String afterText = paginationAfter.getText();
//		System.out.println("📄 After Refresh: " + afterText);
//
//		// Step 4: Validate: at least pagination exists
//		Assert.assertTrue("❌ Pagination info not visible after refresh.", paginationAfter.isDisplayed());
//
//		// Optional: Compare before & after text (if data was expected to change)
//		if (!BeforeRefresh.equals(afterText)) {
//			System.out.println("✅ Data was updated after refresh.");
//		} else {
//			System.out.println("ℹ️ Data remained the same after refresh (but page still refreshed).");
//		}


//		List<WebElement> refreshBtns = attendance.getTimeCardRefreshBtn();
//
//// Assuming there's only one button and you want to click it 3 times
//		if (!refreshBtns.isEmpty()) {
//			WebElement refreshBtn = refreshBtns.get(0); // Get the first button
//			for (int i = 0; i < 3; i++) {
//				refreshBtn.click();
//				Thread.sleep(1000); // Optional wait between clicks
//			}
//		}

	}

	@Then("user should list the records by selecting Ten twenty and Fifty per pages")
	public void userShouldListTheRecordsBySelectingTenTwentyAndFiftyPerPages() throws Exception {

		attendance.userShouldListTheRecordsBySelecting(driver, attendance);


	}

	@When("user navigates to Timesheet submodule page")
	public void userNavigatesToTimesheetSubmodulePage() {

		WebElement ScrollUntil = wait.until(ExpectedConditions.elementToBeClickable(attendance.getAttendance_Timesheetpage()));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", ScrollUntil);
		ScrollUntil.click();

	}

	@Then("User Should view the recently created record")
	public void userShouldViewTheRecentlyCreatedRecord() throws InterruptedException {

		WebElement viewTimesheeticon = wait.until(ExpectedConditions.elementToBeClickable(attendance.getView_Attendance_page()));
		if (viewTimesheeticon.isDisplayed()) {
			viewTimesheeticon.click();
		} else System.out.println("Element is not displayed!!! Create a new timesheet");
		WebElement hoverIcon = attendance.getView_Hover_icon();
		Actions actions = new Actions(driver);
		actions.moveToElement(hoverIcon).perform();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getView_TimeSheet_Cycle())).click();
		Thread.sleep(3000);
		WebElement scrollToLastRecord = attendance.getKnow_more_about_this();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", scrollToLastRecord);
		Thread.sleep(1000);
		scrollToLastRecord.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(organization.getorganizationEditConfirmbtn())).click();
		WebElement ScrollToTopViewAtt = attendance.getScrollToTopViewAtt();
		JavascriptExecutor ScrollToTop = (JavascriptExecutor) driver;
		ScrollToTop.executeScript("arguments[0].scrollIntoView(true);", ScrollToTopViewAtt);
		Thread.sleep(3000);
		ScrollToTopViewAtt.click();


	}

	@Then("User should update the recently created timesheet")
	public void userShouldUpdateTheRecentlyCreatedTimesheet() throws InterruptedException {

// Determine which radio button is selected
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getEdit_Timesheet_Page())).click();
		WebElement EditTimesheetName = wait.until(ExpectedConditions.elementToBeClickable(attendance.getEdit_TimeSheet_NamePh()));
		EditTimesheetName.click();
		Actions actions = new Actions(driver);
		actions.click(EditTimesheetName).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE);
		EditTimesheetName.sendKeys(RandomTimeSheetName);
		WebElement EditTimesheetDescription = wait.until(ExpectedConditions.elementToBeClickable(attendance.getEdit_TimeSheet_Description()));
		actions.click(EditTimesheetDescription).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE);
		EditTimesheetDescription.sendKeys(RandomTimeSheetName);
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getView_TimeSheet_Cycle())).click();
		//String timesheetType = attendance.getNormalTimesheetRadioBtn().isSelected() ? "NORMAL" : "FLEXIBLE";
		String timesheetType = attendance.getFlexibleTimesheetRadioBtn().isSelected() ? "NORMAL" : "FLEXIBLE";

		//WebElement FlexibleTimesheetRBtn = wait.until(ExpectedConditions.elementToBeClickable(attendance.getFlexibleTimesheetRadioBtn()));


		switch (timesheetType) {
			case "NORMAL":
				WebElement NormalTimeSheetRadioBtn = wait.until(ExpectedConditions.visibilityOf(attendance.getNormalTimesheetRadioBtn()));
				if (NormalTimeSheetRadioBtn.isSelected()) {
					NormalTimeSheetRadioBtn.click();
					Thread.sleep(1500);
				}

				List<WebElement> AllRowheaders = attendance.getAllheadersAvailableonEditTS();
				for (WebElement AllDataDisplay : AllRowheaders) {
					System.out.println("All headers Available" + AllDataDisplay);
				}

				WebElement ScrollUntilCycelDisplay = wait.until(ExpectedConditions.elementToBeClickable(attendance.getRepeatCycleIcon()));
				ScrollUntilCycelDisplay.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
				Thread.sleep(1000);
				ScrollUntilCycelDisplay.sendKeys(properties.getProperty("Cycle1"));

				WebElement LastRec = wait.until(ExpectedConditions.visibilityOf(attendance.getlastRowForCycle1()));
				js.executeScript("arguments[0].scrollIntoView(true);", LastRec);
				Thread.sleep(2000);
				js.executeScript("arguments[0].scrollIntoView(true);", ScrollUntilCycelDisplay);
				Thread.sleep(2000);

				WebElement ToTime1 = wait.until(ExpectedConditions.visibilityOf(attendance.getChangeTimePH()));
				new Actions(driver).click(ToTime1)
						.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
						.sendKeys(Keys.BACK_SPACE)
						.sendKeys(getCurrentTimeAsNumber())
						.perform();

				wait.until(ExpectedConditions.elementToBeClickable(attendance.getStatisticRuleMode())).click();
				wait.until(ExpectedConditions.visibilityOf(attendance.getFirstAndLastDP())).click();

				WebElement BreakTimeToggle = wait.until(ExpectedConditions.visibilityOf(attendance.getBreakTimeEnabled()));
				if (!BreakTimeToggle.isEnabled()) {
					System.out.println("BreakTime is Disabled, Now Enabling");
					BreakTimeToggle.click();
				} else {
					Thread.sleep(3000);
					System.out.println("Break Time is Enabled!!!");
				}

				WebElement BreakTimeToggleBtn = wait.until(ExpectedConditions.visibilityOf(attendance.getEnableOverTimeToggle()));
				if (!BreakTimeToggleBtn.isEnabled()) {
					System.out.println("Break Time is not enabled");
					BreakTimeToggleBtn.click();
				} else {
					System.out.println("BreakTime is already enabled!!!");
				}

				int maxAttempts = 3;
				for (int i = 0; i < maxAttempts; i++) {
					WebElement breakTimeEnabled = wait.until(ExpectedConditions.elementToBeClickable(attendance.getbreakTimeCyclebtn()));
					breakTimeEnabled.click();
					Thread.sleep(1000);
					try {
						WebElement breakTimeExceeds = wait.until(ExpectedConditions.visibilityOf(attendance.getBreakTimeExceeds()));
						if (breakTimeExceeds.isDisplayed()) {
							System.out.println("BreakTimeExceeds appeared!");
							break;
						}
					} catch (TimeoutException e) {
						// Try again
					}
				}

				wait.until(ExpectedConditions.visibilityOf(attendance.gettranscation_Confirm_btn())).click();
				break;

			case "FLEXIBLE":
				//wait.until(ExpectedConditions.elementToBeClickable(attendance.getEdit_Timesheet_Page())).click();
				WebElement ScrollUntilCycelDisplayF = wait.until(ExpectedConditions.elementToBeClickable(attendance.getRepeatCycleIcon()));
				WebElement FlexibleTimesheetRBtn = wait.until(ExpectedConditions.elementToBeClickable(attendance.getFlexibleTimesheetRadioBtn()));
				FlexibleTimesheetRBtn.click();
				List<WebElement> AllRowheader = attendance.getAllheadersAvailableonEditTS();
				for (WebElement AllDataDisplay : AllRowheader) {
					System.out.println("All headers Available" + AllDataDisplay);
				}

				ScrollUntilCycelDisplayF.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
				Thread.sleep(1000);
				ScrollUntilCycelDisplayF.sendKeys(properties.getProperty("Cycle2"));

				WebElement ScrollUntilLastCycelFlexible = wait.until(ExpectedConditions.visibilityOf(attendance.getlastIndexForCycle2()));
				js.executeScript("arguments[0].scrollIntoView(true);", ScrollUntilLastCycelFlexible);
				Thread.sleep(2000);
				js.executeScript("arguments[0].scrollIntoView(true);", ScrollUntilCycelDisplayF);
				Thread.sleep(2000);

				WebElement scrollToLastRecord = attendance.getKnow_more_about_this();
				js.executeScript("arguments[0].scrollIntoView(true);", scrollToLastRecord);
				Thread.sleep(1000);

				WebElement ToTime2 = wait.until(ExpectedConditions.visibilityOf(attendance.getChangeTimePH()));
				new Actions(driver).click(ToTime2)
						.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
						.sendKeys(Keys.BACK_SPACE)
						.sendKeys(getCurrentTimeAsNumber())
						.perform();

				wait.until(ExpectedConditions.elementToBeClickable(attendance.getStatisticRuleMode())).click();
				wait.until(ExpectedConditions.elementToBeClickable(attendance.getODDAndEvenDp())).click();

				WebElement BreakTimeToggle2 = wait.until(ExpectedConditions.visibilityOf(attendance.getBreakTimeEnabled()));
				if (!BreakTimeToggle2.isEnabled()) {
					System.out.println("BreakTime is Disabled, Now Enabling");
					BreakTimeToggle2.click();
				} else {
					System.out.println("Break Time is Enabled!!!");
				}

				WebElement BreakTimeToggleBtn2 = wait.until(ExpectedConditions.visibilityOf(attendance.getEnableOverTimeToggle()));
				if (!BreakTimeToggleBtn2.isEnabled()) {
					System.out.println("Break Time is not enabled");
					BreakTimeToggleBtn2.click();
				} else {
					System.out.println("BreakTime is already enabled!!!");
				}


				int maxAttempts2 = 3;
				for (int i = 0; i < maxAttempts2; i++) {
					WebElement breakTimeEnabled = wait.until(ExpectedConditions.elementToBeClickable(attendance.getbreakTimeCyclebtn()));
					breakTimeEnabled.click();
					Thread.sleep(1000);
					try {
						WebElement breakTimeExceeds = wait.until(ExpectedConditions.visibilityOf(attendance.getBreakTimeExceeds()));
						if (breakTimeExceeds.isDisplayed()) {
							System.out.println("BreakTimeExceeds appeared!");
							break;
						}
					} catch (TimeoutException e) {
						// Try again
					}
				}

				wait.until(ExpectedConditions.visibilityOf(attendance.gettranscation_Confirm_btn())).click();
				break;
		}

	}


	@Then("User should delete the Timesheet Successfully")
	public void userShouldDeleteTheTimesheetSuccessfully() {
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getDeleteTimesheetBtn())).click();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getDeletTimesheetconfimBtn())).click();
		WebElement cannotDeleteToastMessage=wait.until(ExpectedConditions.visibilityOf(attendance.getTimesheetcannotDeletetoast()));
		if(cannotDeleteToastMessage.isEnabled()) {
			System.out.println("TimeSheet is already in use Deletion is prohibited!!!!");
		}
			else {
				wait.until(ExpectedConditions.visibilityOf(attendance.getSuccess_Popup_Message())).isDisplayed();

			}
		}

	@Then("User should cancel the timesheet delete operation")
	public void userShouldCancelTheTimesheetDeleteOperation() {

		wait.until(ExpectedConditions.elementToBeClickable(attendance.getDeleteTimesheetBtn())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getAdd_medAtt_Cancel_btn())).click();
	}

	@Then("User should search by timesheet name")
	public void userShouldSearchByTimesheetName() throws InterruptedException {
		WebElement FindRecord = wait.until(ExpectedConditions.visibilityOf(attendance.getSearchtextField()));
		Thread.sleep(2000);
		FindRecord.sendKeys(properties.getProperty("SearchTimesheetname"));
		if (FindRecord.isDisplayed()) {
			WebElement EntredRecord = attendance.getFindRecordIsdisplayed();
			System.out.println("Record found!!!!");
		} else {
			System.out.println("Sorry! No record found");
		}
	}
	@Then("User should not create Timesheet by leaving mandatory field")
	public void userShouldNotCreateTimesheetByLeavingMandatoryField() throws InterruptedException{

		wait.until(ExpectedConditions.elementToBeClickable(attendance.getAddTimeSheetBtn())).click();
		WebElement EditTimesheetName = wait.until(ExpectedConditions.elementToBeClickable(attendance.getEdit_TimeSheet_NamePh()));
		EditTimesheetName.click();
		Actions actions = new Actions(driver);
		actions.click(EditTimesheetName).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE);
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getView_TimeSheet_Cycle())).click();
		WebElement ScrollUntilCycelDisplay = wait.until(ExpectedConditions.elementToBeClickable(attendance.getRepeatCycleIcon()));
		ScrollUntilCycelDisplay.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(attendance.gettranscation_Confirm_btn())).click();


	}

	@Then("User unable to create timesheet if breakTime is Eighter outside the checkIn or Checkout Range")
	public void userUnableToCreateTimesheetIfBreakTimeIsEighterOutsideTheCheckInOrCheckoutRange() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(attendance.getAddTimeSheetBtn())).click();
		WebElement EditTimesheetName = wait.until(ExpectedConditions.elementToBeClickable(attendance.getEdit_TimeSheet_NamePh()));
		EditTimesheetName.click();
		Actions actions = new Actions(driver);
		actions.click(EditTimesheetName).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE);
		EditTimesheetName.sendKeys(RandomTimeSheetName);
		WebElement scrollToLastRecord = attendance.getKnow_more_about_this();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", scrollToLastRecord);
		Thread.sleep(1000);
		WebElement BreakTimeToggle = wait.until(ExpectedConditions.visibilityOf(attendance.getBreakTimeEnabled()));
		if (!BreakTimeToggle.isEnabled()) {
			System.out.println("BreakTime is Disabled, Now Enabling");
			BreakTimeToggle.click();
		} else {
			Thread.sleep(3000);
			System.out.println("Break Time is Enabled!!!");
		}
             Thread.sleep(2000);
     WebElement StartTimefied=wait.until(ExpectedConditions.visibilityOf(attendance.getStartTimeTimesheet()));
		actions.click(StartTimefied).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE);
		StartTimefied.sendKeys(properties.getProperty("StartTimetimsheet"));
		Thread.sleep(2000);
        WebElement StartTime=wait.until(ExpectedConditions.visibilityOf(attendance.getStartTimeTimesheet()));
		Actions action = new Actions(driver);
		StartTime.sendKeys(properties.getProperty("sameTimeASChekIn"));
		WebElement EndTimeCheckin=wait.until(ExpectedConditions.visibilityOf(attendance.getEndTimeCheckin()));
		Actions action1 = new Actions(driver);
		action1.moveToElement(EndTimeCheckin).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();
		//Thread.sleep(3000);

		WebElement BreakTimeToast=wait.until(ExpectedConditions.visibilityOf(attendance.getBreakTimeErrorMessage()));
		if(BreakTimeToast.isDisplayed())
			System.out.println("Unable to create Break time!!!!!!! "+BreakTimeToast.getText());
		else System.out.println("User can create break time");
		Thread.sleep(2000);

		//WebElement EndTimeCheckin = wait.until(ExpectedConditions.visibilityOf(attendance.getEndTimeCheckin()));
		Actions action2 = new Actions(driver);
		action2
				.moveToElement(EndTimeCheckin)
				.click()
				.keyDown(Keys.CONTROL)
				.sendKeys("a")
				.keyUp(Keys.CONTROL)
				.sendKeys(Keys.BACK_SPACE);
//				.perform();

		Thread.sleep(500);
  WebElement BreakTimeMoreThanCheckin=wait.until(ExpectedConditions.visibilityOf(attendance.getBreakTimeMoreThanCheckin()));
		BreakTimeMoreThanCheckin.sendKeys(properties.getProperty("MoreThanCheckInTime"));
		wait.until(ExpectedConditions.visibilityOf(attendance.gettranscation_Confirm_btn())).click();
		WebElement BreakTimeMoreThanCheckinToastMessage=wait.until(ExpectedConditions.visibilityOf(attendance.getBreakTimeMoreThanCheckinToastMessage()));

		BreakTimeMoreThanCheckinToastMessage.getText();


	}

	@Then("User can navigate to next page by clicking on next page by selecting Ten twenty and fifty")
	public void userCanNavigateToNextPageByClickingOnNextPageBySelectingTenTwentyAndFifty() throws Exception {

		attendance.userShouldListTheRecordsBySelecting(driver, attendance);
		Next_Page_Previous_page_With_single_record(driver, attendance);


	}

    @Then("user should validate the timesheet page")
    public void userShouldValidateTheTimesheetPage() {
        List<WebElement> HeaderList = attendance.getView_Attendance_All_Headers();
        System.out.println("Available Headers:");
        for (WebElement headers : HeaderList) {
            System.out.println(headers.getText() + "\t");
        }
    }

//    @And("user click on timesheet module")
//    public void userClickOnTimesheetModule() {
//    }

    @Then("user click on add timesheet module")
    public void userClickOnAddTimesheetModule() {
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddTimeSheetBtn())).click();
    }

    @And("the user enters valid data in the Add timesheet")
    public void theUserEntersValidDataInTheAddTimesheet() {
		reus.enterRandomAlphanumeric(attendance.getTimeSheetNametext());
		reus.enterRandomAlphanumeric(attendance.getTimesheetDescription());
		reus.enterRandomTime(attendance.getDayChangeTime());


    }

    @And("the user enter click on confirm button.")
    public void theUserEnterClickOnConfirmButton() {
		reus.performClickAction(attendance.getConfirmbutton());


	}

    @Then("user validate the success message")
    public void userValidateTheSuccessMessage() {
		reus.verifyToastMessage(driver,wait,properties.getProperty("Timesheetsuccessmessage"));

	}

    @And("the user enters valid data in the Add timesheet and create the flexible timesheet")
    public void theUserEntersValidDataInTheAddTimesheetAndCreateTheFlexibleTimesheet() {
		reus.enterRandomAlphanumeric(attendance.getTimeSheetNametext());
		reus.enterRandomAlphanumeric(attendance.getTimesheetDescription());
		reus.performClickAction(attendance.getArrowForwardicontimesheet());
		reus.performClickAction(attendance.getFlexiblecheckbox());

    }

    @And("the user clicks on the View icon for a timesheet")
    public void theUserClicksOnTheViewIconForATimesheet() {

    }

    @Then("the user should be able to see the created timesheet details")
    public void theUserShouldBeAbleToSeeTheCreatedTimesheetDetails() {
    }

	@When("User navigates to Shift schedule sub module")
	public void userNavigatesToShiftScheduleSubModule() {
		WebElement ScrollUntil = wait.until(ExpectedConditions.elementToBeClickable(attendance.getShiftScheduleSubModule()));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", ScrollUntil);
		ScrollUntil.click();
	}

	@Then("User should validate the presence of all components in Shift shedule page")
	public void userShouldValidateThePresenceOfAllComponentsInShiftShedulePage() {

		wait.until(ExpectedConditions.visibilityOf(attendance.getAddShiftScheduleBtn())).isDisplayed();
		wait.until(ExpectedConditions.visibilityOf(attendance.getDeleteShiftScheduleBtn())).isDisplayed();
		WebElement ContextClick= wait.until(ExpectedConditions.visibilityOf(attendance.getShiftRefreshicon()));
		Actions Action=new Actions(driver);
		Action.doubleClick(ContextClick).perform();

		List<WebElement> HeaderList = attendance.getView_Attendance_All_Headers();
		System.out.println("Available Headers:");
		for (WebElement headers : HeaderList) {
			System.out.println(headers.getText() + "\t");
		}
		List<WebElement> listrecords = attendance.getTo_Display_All_records();
		System.out.println("Available records");
		for (WebElement total_Rec : listrecords) {
			System.out.println(total_Rec.getText());
		}


		WebElement CalculateICon= wait.until(ExpectedConditions.visibilityOf(attendance.getShiftCalculatorICon()));
		Actions actions = new Actions(driver);
		actions.moveToElement(CalculateICon).perform();


	}

	@Then("User is trying to add a shift schedule by leaving mandatory fields")
	public void userIsTryingToAddAShiftScheduleByLeavingMandatoryFields() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddShiftScheduleBtn())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddShiftPerson())).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddpersonConfirmBtn())).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddShifttimesheetBtn())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddpersonConfirmBtn())).click();

		Actions actions = new Actions(driver);
		WebElement selectStartTime = wait.until(ExpectedConditions.visibilityOf(attendance.getAddStartDateBtn()));
		actions.click(selectStartTime)
				.keyDown(Keys.CONTROL)
				.sendKeys("a")
				.keyUp(Keys.CONTROL)
				.sendKeys(Keys.BACK_SPACE)
				.perform();

		WebElement endTimeClick = wait.until(ExpectedConditions.visibilityOf(attendance.getAddEndTimeBtn()));
		Thread.sleep(1000);
		actions.click(endTimeClick)
				.keyDown(Keys.CONTROL)
				.sendKeys("a")
				.keyUp(Keys.CONTROL)
				.sendKeys(Keys.BACK_SPACE)
				.perform();
		wait.until(ExpectedConditions.elementToBeClickable(attendance.getShiftConfirmBtn())).click();
		Thread.sleep(2000);
	}

	@Then("user can create shift schedule with valid timesheet and person")
	public void userCanCreateShiftScheduleWithValidTimesheetAndPerson() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddShiftScheduleBtn())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddShiftPerson())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddPersonUnderShift())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddpersonConfirmBtn())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddShifttimesheetBtn())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddTimeShiftForShift())).click();
		
		Thread.sleep(4000);

	}

	@Then("User cannot add multiple shift for one employee")
	public void userCannotAddMultipleShiftForOneEmployee() {
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddShiftScheduleBtn())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddShiftPerson())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddPersonUnderShift())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddpersonConfirmBtn())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddShifttimesheetBtn())).click();
		wait.until(ExpectedConditions.visibilityOf(attendance.getAddTimeShiftForShift())).click();
		WebElement DuplicateTimeSheetName= wait.until(ExpectedConditions.visibilityOf(attendance.getDuplicateScheduleName()));
		if(DuplicateTimeSheetName.isDisplayed())
		{
			System.out.println("Employee With Shift Schedule is already exist!!!"+"\n"+"Unable to add Shift Schedule!!!!!!"+DuplicateTimeSheetName.getText());
		}
	}
		
//                      	###### parv's code #####
	
	
	@Then("user will validate dashboard page")
	public void userWillValidateDashboardPage() throws Exception {
		resetZoomToDefault();
		wait.until(ExpectedConditions.urlContains("/dashboard"));
	}

	String xyz = "";
	String globalname = "";
	String globalid = "";
	@Then("user will create one person")
	public void user_will_create_one_person() throws InterruptedException {
		Thread.sleep(3000);
		organization.getOrganizationManagementmodule().click();

		organization.getDepartment().click();
		organization.getAddDepartmentButton().click();
		Thread.sleep(1000);

		String DepartmentName = RandomStringUtils.randomAlphabetic(5);
		String xyz = DepartmentName;
		String DepartmentCode = RandomStringUtils.randomAlphabetic(5);

		organization.getDepartmentName().sendKeys(DepartmentName);
		organization.getDepartmentCode().sendKeys(DepartmentCode);

		login.getconfirmButton().click();

//        organizationManagement.getsuccessmessage().sendKeys(properties.getProperty("SuccessMessage"));
//        WebElement toast = organizationManagement.getsuccessmessage();
//        String actualMessage = toast.getText();
//        String expectedMessage = properties.getProperty("SuccessMessage.message");
// 
//        Assert.assertEquals("Toast message did not match", expectedMessage, actualMessage);
//        driver.quit();

		organization.getPersonSubModule().click();
		Thread.sleep(2000);
		organization.getAddPersonButton().click();
		Thread.sleep(2000);

		String PersonID = RandomStringUtils.randomNumeric(5);
		globalid = PersonID;
		System.err.println(globalid);
		String FirstName = RandomStringUtils.randomAlphabetic(5);
		globalname = FirstName;
		System.err.println(globalname);

		String LastName = RandomStringUtils.randomAlphabetic(5);
		organization.getdepartmentsearch().click();
		Thread.sleep(3000);
		organization.getdepartmentsearch().sendKeys(xyz);
		organization.getdepartmentsearch().sendKeys(Keys.ARROW_DOWN); // Navigate down the suggestions
		organization.getdepartmentsearch().sendKeys(Keys.ENTER);

		organization.getPersonIDTextField().sendKeys(PersonID);
		organization.getfirstNameTextField().sendKeys(FirstName);
		organization.getlastNameTextField().sendKeys(LastName);

		wait.until(ExpectedConditions.elementToBeClickable(organization.getConfirmButtonforPerson())).click();

	}

	@Then("i will create create one shift")
	public void i_will_create_create_one_shift() throws Exception {

		Thread.sleep(2000);
		organization.getOrganizationManagementmodule().click();

		windowMinimize(3);
		Thread.sleep(3000);
		WebElement elementToClick = attendance.getattendanceButton();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", elementToClick);

		attendance.getshiftscheduleButton().click();
		resetZoomToDefault();
		organization.getAddPersonButton().click();
		attendance.getselectpersonField().click();
		attendance.getfirstpersonnameField().sendKeys(globalname);

		driver.findElement(By.xpath("//div[contains(text(),'" + globalname + "')]")).click();

		Thread.sleep(2000);
//		login.getconfirmButton().click();
		driver.findElement(By.xpath("(//button[contains(text(), 'Confirm')])[2]")).click();
		//JTC
		Thread.sleep(2000);

		attendance.getselecttemplateField().click();
		attendance.getinputtemplateField().sendKeys("Do not Delete");
		driver.findElement(By.xpath("//div[text()='Do not Delete']")).click();
		driver.findElement(By.xpath("(//button[contains(text(), 'Confirm')])[2]")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search by Person ID/Person Name/Timesheet Name']")).sendKeys(globalname);
		driver.findElement(By.xpath("//p[text()='1–1 of 1']")).isDisplayed();
		
	}
	
	
	
	@And("i will create create one shift with the same person having existing schedule")
	public void i_will_create_create_one_shift_with_the_same_person_having_existing_schedule() throws Exception {
		organization.getAddPersonButton().click();
		attendance.getselectpersonField().click();
		attendance.getfirstpersonnameField().sendKeys(globalname);

		driver.findElement(By.xpath("//div[contains(text(),'" + globalname + "')]")).click();

		Thread.sleep(2000);
//		login.getconfirmButton().click();
		driver.findElement(By.xpath("(//button[contains(text(), 'Confirm')])[2]")).click();
		//JTC
		Thread.sleep(2000);

		attendance.getselecttemplateField().click();
		attendance.getinputtemplateField().sendKeys("Do not Delete");
		driver.findElement(By.xpath("//div[text()='Do not Delete']")).click();
		driver.findElement(By.xpath("(//button[contains(text(), 'Confirm')])[2]")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Confirm')]")).click();
		
		driver.findElement(By.xpath("//*[text()='Timesheet is already added to employee']")).isDisplayed();
	}
	
	@Then ("i will click on calculate button without selecting schedule")
	public void i_will_click_on_calculate_button_without_selecting_schedule() throws InterruptedException {
		
		WebElement elementToClick = attendance.getattendanceButton();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", elementToClick);

		attendance.getshiftscheduleButton().click();
		driver.findElement(By.xpath("(//div[@class='MuiGrid-root css-973rm6'])[1]/*[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'Please Select Schedule First')]")).isDisplayed();
		
	}
	
	@And ("i will select the record and click on calculate")
    public void i_will_select_the_record_and_click_on_calculate() throws InterruptedException {
		
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='MuiGrid-root css-973rm6'])[1]/*[1]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Success')]")).isDisplayed();
		
	}
	
	@And ("i will search shift schedule with Person name , Person ID and Timesheet")
public void i_will_search_shift_schedule_with_Person_name_PersonID_and_Timesheet () throws InterruptedException{
	
		Thread.sleep(1000);
		
		//Searching with person id
		WebElement deletename = driver.findElement(By.xpath("//input[@placeholder='Search by Person ID/Person Name/Timesheet Name']"));
		String s = Keys.chord(Keys.CONTROL, "a");
		deletename.sendKeys(s);
		deletename.sendKeys(Keys.DELETE);
		deletename.sendKeys(globalid);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[text()='1–1 of 1']")).isDisplayed();
		
		//Searching with timesheet name
		WebElement deletename1 = driver.findElement(By.xpath("//input[@placeholder='Search by Person ID/Person Name/Timesheet Name']"));
		String s1 = Keys.chord(Keys.CONTROL, "a");
		deletename1.sendKeys(s1);
		deletename1.sendKeys(Keys.DELETE);
		deletename1.sendKeys("Do not Delete");
		
		driver.findElement(By.xpath("(//div[@title='Do not Delete'])[1]")).isDisplayed();
		
		
		
}	
	@And ("i will click on delete button without selecting any record")
	public void i_will_click_on_delete_button_without_selecting_any_record() throws Exception {
		
		WebElement elementToClick = attendance.getattendanceButton();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", elementToClick);

		windowMinimize(3);
		
		attendance.getshiftscheduleButton().click();
		driver.findElement(By.xpath("(//span[contains(text(),\"Delete\")])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'Please select one person first')]")).isDisplayed();
		
	}

	 @And ("i will delete shift schedules")
	 public void  i_will_delete_shift_schedules() throws InterruptedException {
	
	driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	Thread.sleep(1000);
//	driver.findElement(By.xpath("(//div[@class='MuiGrid-root css-973rm6'])[1]/*[1]")).click();
	driver.findElement(By.xpath("(//span[contains(text(), 'Delete')])[1]")).click();
	
	reus.performClickAction(attendance.getConfirmbutton());
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[contains(text(),'Success')]")).isDisplayed(); 
	
	Thread.sleep(2000);
	
	WebElement deletename = driver.findElement(By.xpath("//input[@placeholder='Search by Person ID/Person Name/Timesheet Name']"));
	String s = Keys.chord(Keys.CONTROL, "a");
	deletename.sendKeys(s);
	deletename.sendKeys(Keys.DELETE);
	deletename.sendKeys(globalname);
	
	driver.findElement(By.xpath("//p[text()='0–0 of 0']")).isDisplayed();
	
	 }
	 
	 @And ("i will try to delete shift schedule via cancel button")
	 public void i_will_try_to_delete_shift_schedule_via_cancel_button() throws InterruptedException {
	 
		 
		 driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
			Thread.sleep(1000);
//			driver.findElement(By.xpath("(//div[@class='MuiGrid-root css-973rm6'])[1]/*[1]")).click();
			driver.findElement(By.xpath("(//span[contains(text(), 'Delete')])[1]")).click();
			
//			reus.performClickAction(attendance.getConfirmbutton());
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(organization.getOrgCancelBtn())).click();
			
			Thread.sleep(2000);
			
			WebElement deletename = driver.findElement(By.xpath("//input[@placeholder='Search by Person ID/Person Name/Timesheet Name']"));
			String s = Keys.chord(Keys.CONTROL, "a");
			deletename.sendKeys(s);
			deletename.sendKeys(Keys.DELETE);
			deletename.sendKeys(globalname);
			
			driver.findElement(By.xpath("//p[text()='1–1 of 1']")).isDisplayed();
		 
		 
		 
	 }
	 
	 @And ("i will click on view button for basic setting")
	 public void i_will_click_on_view_button_for_basic_setting() {
		 driver.findElement(By.xpath("//button[.//p[text()='View']]")).click(); 
		 driver.findElement(By.xpath("//p[text()='Basic Settings']")).isDisplayed();
	 }
	
}






