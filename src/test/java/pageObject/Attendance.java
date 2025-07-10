package pageObject;

import org.apache.commons.lang3.RandomStringUtils;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
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
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static pageObject.OrganizationManagement.resetZoomToDefault;

public class Attendance<WebElements> {


    // private static final org.openqa.selenium.WebElement PersonNameHeaders = null;
    private WebDriver driver;
    JavascriptExecutor javascriptExecutor;
    Actions actions;
    Robot robot;
    static WebDriverWait wait;
    public static Attendance attendance;
    static String Invalid_personId = RandomStringUtils.randomNumeric(5);
    static String Invalid_personName = RandomStringUtils.randomAlphabetic(5);

    public static Properties properties;

    public Attendance(WebDriver driver) throws IOException {
        this.driver = driver;
        actions = new Actions(driver);
        try {
            robot = new Robot();
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(101));
        javascriptExecutor = (JavascriptExecutor) this.driver;
        PageFactory.initElements(driver, this);
        properties = new Properties();
        FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\data.properties");
        properties.load(fis1);
    }


    @FindBy(xpath = "(//p[normalize-space()='Attendance'])[1]")
    private WebElement Attendance_Module;
    @FindBy(xpath = "(//p[normalize-space()='View Attendance Punch'])[1]")
    private WebElement View_Attendance_Punch;
    @FindBy(xpath="(//p[normalize-space()='Timesheet'])[1]")
    private WebElement Attendance_Timesheetpage;
    @FindBy(xpath = "(//div[@class='css-k008qs'])[1]")
    private WebElement ViewAllHeadersData;
    @FindBy(css = "#root > div > div > div.MuiGrid-root.MuiGrid-container.css-1d3bbye > div > div.MuiBox-root.css-xcsyz2 > div > div > div:nth-child(1) > div > div.MuiGrid-root.css-1t8v9jn > div:nth-child(1) > div > div > div.MuiGrid-root.css-1q708hw > label > span.MuiSwitch-root.MuiSwitch-sizeMedium.css-1hz7155 > span.MuiButtonBase-root.MuiSwitch-switchBase.MuiSwitch-colorPrimary.PrivateSwitchBase-root.MuiSwitch-switchBase.MuiSwitch-colorPrimary.css-xdunop")
    private WebElement ViewToggleButton;
    @FindBy(css = "body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1) > svg:nth-child(1) > g:nth-child(2) > path:nth-child(2)")
    private WebElement UploadTranscationIcon;
    @FindBy(xpath = "//li[@class='MuiBreadcrumbs-li']")
    private WebElement View_Attendance_Punch_header;
    @FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-sizeSmall MuiInputBase-adornedEnd css-2uei7d']")
    private WebElement Search_Field_display_btn;
    @FindBy(xpath = "//span[text()='Show mended records']")
    private WebElement Show_Mind_Records_Toggle_Btn;
    @FindBy(css = "body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)")
    private WebElement Show_Usage_Toggle_btn;
    @FindBy(xpath = "(//span[normalize-space()='Download'])[1]")
    private WebElement Download_Hover_Btn;
    @FindBy(css = "body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)")
    private WebElement Refresh_Click_icon;
    @FindBy(xpath = "(//div[@role='row'])[1]")
    private List<WebElement> View_Attendance_All_Headers;
    @FindBy(xpath = "(//p[text()='Mend Attendance Punch'])[2]")
    private WebElement Mend_Attendance_punch_Header;
    @FindBy(xpath = "(//div[@role='row'])[2]")
    private List<WebElement> View_Page_Records;
    @FindBy(xpath = "//div[contains(text(),'Person Name')]")
    private WebElement Person_Sort_Arrow_btn;
    @FindBy(xpath = "//div[contains(text(),'Person ID')]")
    private WebElement Person_ID_Arrow_btn;
    @FindBy(xpath = "//div[contains(text(),'Punch Date')]")
    private WebElement Punch_date_sort_btn;
    @FindBy(xpath="//*[text()='Shift Schedule']")
    //Shift schedule submoule
    private WebElement ShiftScheduleSubModule;
    @FindBy(xpath = "//div[contains(text(),'Attendance record')]")
    private WebElement Attendance_record_arrow_btn;
    @FindBy(xpath = "//div[contains(text(),'TimeZone')]")
    private WebElement TimeZone_Arrow_btn;
    @FindBy(xpath = "//div[contains(text(),'Source')]")
    private WebElement Source_Arrow_btn;
    @FindBy(xpath = "//input[@type='search']")
    static WebElement Filter_search_bar_ViewAtt;
    @FindBy(xpath = "//span[text()='Usage Tips']")
    static WebElement Usage_tips_icon;

    @FindBy(xpath = "//span[normalize-space()='Download']")
    private WebElement Download_reports_icon;

    @FindBy(xpath = "//li[normalize-space()='xlsx']")
    private WebElement XlsX_download_format;

    @FindBy(xpath = "//li[normalize-space()='csv']")
    private WebElement CSV_Download_Format;

    @FindBy(xpath = "//span[text()='Upload Transactions']")
    private WebElement Download_transcation_icon;

    @FindBy(xpath = "(//input[@placeholder='dd-mm-yyyy' and @type='tel'])[1]")
    private WebElement FromDate_label;

    @FindBy(xpath = "(//input[@placeholder='dd-mm-yyyy' and @type='tel'])[2]")
    private WebElement ToDate_label;

    @FindBy(xpath = "(//button[normalize-space()='Confirm'])[1]")
    private WebElement transcation_Confirm_btn;

    @FindBy(xpath = "//button[@aria-label='Show filters']")
    private WebElement Punch_State_Filter_Icon;

    @FindBy(xpath = "(//input[contains(@class, 'MuiInputBase-input') and @placeholder='dd-mm-yyyy'])[1]")
    private WebElement Start_Date_punch_Filter;

    @FindBy(xpath = "(//input[contains(@class, 'MuiInputBase-input') and @placeholder='dd-mm-yyyy'])[2]")
    private WebElement End_Date_Punch_Filter;

    @FindBy(xpath = "//*[normalize-space(text())=\"Please don't select future time\"]")
    private WebElement FutureDate_ErrorMessage;

    @FindBy(css = "body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)")
    private WebElement View_Attedance_refresh;

    @FindBy(xpath = "//div[@aria-haspopup='listbox']")
    private WebElement No_of_rows_icon;

    @FindBy(xpath = "//li[normalize-space()='10']")
    private WebElement Ten_records_per_page;

    @FindBy(xpath = "//li[normalize-space()='20']")
    private WebElement Twenty_records_per_page;

    @FindBy(xpath = "//li[normalize-space()='50']")
    private WebElement FiFTY_records_per_page;

    @FindBy(xpath = "//div[@role='row' and @data-rowindex='0']//div[@data-field='employee_name']")
    private WebElement Scroll_bar_viewAtt;

    @FindBy(xpath = "//button[@title='Go to next page']")
    private WebElement GO_TO_Next_page;

    @FindBy(xpath = "//button[@title='Go to previous page']")
    private WebElement GO_TO_Previous_Page;

    @FindBy(xpath = "(//p[normalize-space()='Mend Attendance Punch'])[1]")
    private WebElement Mend_Attendance_punch_submodule;

    @FindBy(css = "body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)")
    private WebElement Add_mend_Attendance_btn;

    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    private WebElement Add_MendAtt_confirm_btn;

    @FindBy(xpath = "//input[contains(@class, 'MuiInputBase-input') and @type='text']")
    private WebElement Add_person_DropdownTF;

    @FindBy(xpath = "(//input[@class='PrivateSwitchBase-input css-1m9pwf3' and @type='radio'])[1]")
    private WebElement Select_First_Radio_btn;

    @FindBy(xpath = "(//button[normalize-space()='Confirm'])[2]")
    private WebElement Mend_Att_confirm_btn;

    @FindBy(xpath = "(//div[@data-field='firstName'])[2]")
    private WebElement Select_First_record;

    @FindBy(xpath = "//input[@placeholder='mm/dd/yyyy']")
    private WebElement UserDefine_Date_Mend;

    @FindBy(xpath = "//input[@placeholder='hh:mm']")
    private WebElement UserDefine_time;

    @FindBy(xpath = "(//*[normalize-space()='Success'])[1]")
    private WebElement Success_Popup_Message;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElement Add_medAtt_Cancel_btn;

    @FindBy(xpath = "//span[normalize-space()='Refresh']")
    private WebElement Mend_ATT_Refresh_icon;

    @FindBy(xpath = "(//p[text()='Edit'])[1]")
    private WebElement Edit_mendAtt_punch;

    @FindBy(xpath = "(//*[normalize-space()='Punch record updated successfully.'])[1]")
    private WebElement Validate_Toast_Btn;

    @FindBy(xpath = "(//*[normalize-space()='Delete'])[1]")
    private WebElement Delete_mend_Punch;

    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    private WebElement Delete_confirm_btn;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElement cancel_the_Delete_optn;

    @FindBy(xpath = "(//*[normalize-space()='Timecard Management'])[1]")
    private WebElement Time_card_Management_subModule;

    @FindBy(xpath = "(//*[normalize-space()='Timecard Management'])[2]")
    private WebElement Time_card_Management_header;

    @FindBy(xpath = "(//button[contains(@class, 'MuiIconButton-root') and contains(@aria-label, 'Choose date')])[1]")
    private WebElement From_Date_Visibility;

    @FindBy(xpath = "(//button[contains(@class, 'MuiIconButton-root') and contains(@aria-label, 'Choose date')])[2]")
    private WebElement To_Date_Visibility;

    @FindBy(xpath = "//div[contains(@class, 'MuiDataGrid-virtualScrollerRenderZone')]//div[@role='row']")
    private List<WebElement> To_Display_All_records;

    @FindBy(xpath = "//span[text()='Abnormal Records Only']")
    private WebElement AbNormalRecordsCB;

    @FindBy(xpath="//input[@placeholder='Search by Timesheet Name']")
    private  WebElement SearchtextField;

    @FindBy(xpath="//div[@class='MuiDataGrid-cellContent' and text()='627t']")
    private WebElement FindRecordIsdisplayed;

    @FindBy(xpath = "//span[normalize-space()='Export']")
    private WebElement Export_RecordsBtn;

    @FindBy(xpath = "(//input[@placeholder='dd-mm-yyyy' and @type='tel'])[3]")
    private WebElement Export_From_Date;

    @FindBy(xpath = "(//input[@placeholder='dd-mm-yyyy' and @type='tel'])[4]")
    private WebElement Export_To_Date;

    @FindBy(xpath = "//textarea[@name='share']")
    private WebElement Text_Area_Field;

    @FindBy(xpath = "(//input[@placeholder='dd-mm-yyyy' and @type='tel'])[5]")
    private WebElement Automatic_SendingFRTDate;

    @FindBy(xpath = "(//input[@placeholder='hh:mm' and @type='tel'])[1]")
    private WebElement TimeForSendingReport;

    @FindBy(xpath = "//textarea[@name='share_list']")
    private WebElement EmailShareList;

    @FindBy(xpath = "(//button[normalize-space()='Confirm'])[2]")
    private WebElement SecondConfirmBtn;

    @FindBy(xpath = "(//*[normalize-space()='Success'])[1]")
    private WebElement SuccessToastMessage;

    @FindBy(xpath = "(//*[normalize-space()='Weekly'])[1]")
    private WebElement WeeklYToggleBtn;

    @FindBy(xpath = "(//*[normalize-space()='Monthly'])[1]")
    private WebElement MonthlyToggleBtn;

    @FindBy(xpath = "(//span[contains(@class, 'MuiSwitch-switchBase') and contains(@class, 'MuiSwitch-colorPrimary')])[3]")
    private WebElement RecordWithTimeZoneDisable;

    @FindBy(xpath = "(//ul[contains(@class, 'MuiMenu-list')])[5]")
    private List<WebElement> ExportListRecord;

    @FindBy(css = "body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)")
    private List<WebElement> TimeCardRefreshBtn;

    @FindBy(xpath = "//div[contains(@class, 'MuiDataGrid-row') and contains(@class, 'MuiDataGrid-row--lastVisible')]")
    private List<WebElement> ScrollUntilllastElement;

    @FindBy(xpath="//p[@class='MuiTablePagination-displayedRows css-1chpzqh']")
    private WebElement TotalRecordsForTimeCard;

    @FindBy(xpath="(//button[@title='Go to next page'])[1]")
    private WebElement GoTo_next_page;

    @FindBy(xpath="(//button[@title='Go to previous page'])[1]")
    private WebElement GoToPreviousPage;

    @FindBy(xpath = "//button[text()='Confirm']")
    private WebElement confirmbutton;

    @FindBy(css="body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > button:nth-child(1) > p:nth-child(2)")
    private WebElement View_Attendance_page;

    @FindBy(xpath="//button[@id='HelpIconButton']")
    private WebElement View_Hover_icon;

    @FindBy(xpath="(//*[text()='Timesheet'])[2]")
    private WebElement View_TimeSheet_Cycle;

    @FindBy(xpath="//*[text()='Know more about this?']")
    private  WebElement Know_more_about_this;

    @FindBy(xpath="//div[@class='MuiGrid-root css-1kiomvz' and text()='View TimeSheet']")
    private WebElement ScrollToTopViewAtt;

    @FindBy(css="body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)")
    private WebElement AddTimeSheetBtn;

    @FindBy(xpath = "//input[@value='00:00']")
    private WebElement dayChangeTime;

    @FindBy(xpath = "//input[@placeholder='Timesheet Description']")
    private WebElement timesheetDescription;


    @FindBy(xpath = "(//*[@data-testid='ArrowForwardIosSharpIcon'])[4]")
    private WebElement ArrowForwardicontimesheet;

    @FindBy(xpath = "//input[@name='option' and @value='working']")
    private WebElement Flexiblecheckbox;

    @FindBy(xpath = "//input[@placeholder='Timesheet Name']")
    private WebElement timeSheetNametext;

    @FindBy(xpath="(//*[text()='Edit'])[1]")
    private WebElement Edit_Timesheet_Page;

    @FindBy(xpath="(//*[@placeholder='Timesheet Name'])[1]")
    private WebElement Edit_TimeSheet_NamePh;

    @FindBy(xpath="(//*[@placeholder='Timesheet Description'])[1]")
    private WebElement Edit_TimeSheet_Description;

    @FindBy(xpath="(//*[@aria-rowindex='8'])[1]")
    private WebElement lastRowForCycle1;

    @FindBy(xpath="//input[@name='cycle']")
    private WebElement RepeatCycleIcon;

    @FindBy(xpath="//span[normalize-space()='Normal']")
    private WebElement NormalTimesheetRadioBtn;

    @FindBy(xpath="//span[text()='Flexible']")
    private WebElement FlexibleTimesheetRadioBtn;

    @FindBy(xpath="//div[@data-rowindex='13']")
    private  WebElement lastIndexForCycle2;

    @FindBy(xpath="//div[@role='row' and @aria-rowindex='1']")
    private List<WebElement>  AllheadersAvailableonEditTS;

    @FindBy(xpath="//input[@type='tel' and @placeholder='hh:mm' and @value='12:00']")
    private WebElement StartTimeTimesheet;

    @FindBy(xpath="//input[@type='tel' and @placeholder='hh:mm' and @value='12:30']")
    private WebElement EndTimeCheckin;

    @FindBy(xpath="(//*[normalize-space()='The break start time cannot be greater than break end time'])[1]")
    private WebElement BreakTimeErrorMessage;

    @FindBy(xpath ="(//*[normalize-space()='The BreakTime Cycle cannot be repeated and needs to be within the range of Check In and Check out'])[1]")
         private  WebElement BreakTimeMoreThanCheckinToastMessage;

    @FindBy(xpath="//input[@placeholder='hh:mm']")
    private WebElement ChangeTimePH;

    @FindBy(xpath="//div[@id='mui-component-select-pairing']")
    private WebElement StatisticRuleMode;

    @FindBy(xpath="//div[text()='First and Last']")
    private WebElement FirstAndLastDP;

    @FindBy(xpath="//li[normalize-space()='Even and Odd']")
    private WebElement ODDAndEvenDp;

    @FindBy(xpath="//input[@type='tel' and @placeholder='hh:mm' and @value='']")
    private WebElement BreakTimeMoreThanCheckin;

    @FindBy(css="body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(6) > div:nth-child(1) > form:nth-child(1) > form:nth-child(1) > div:nth-child(1) > span:nth-child(2) > span:nth-child(1)")
    private WebElement BreakTimeEnabled;

    @FindBy(css="body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(6) > div:nth-child(1) > form:nth-child(1) > form:nth-child(1) > div:nth-child(2) > span:nth-child(2) > span:nth-child(1)")
    private WebElement EnableOverTimeToggle;

    @FindBy(xpath="//button[@aria-label='add to shopping cart']")
    private WebElement breakTimeCyclebtn;


    @FindBy(css="body > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")
    private  WebElement BreakTimeExceeds;

    @FindBy(css="body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > button:nth-child(3)")
    private WebElement DeleteTimesheetBtn;

    @FindBy(xpath="//button[normalize-space()='Confirm']")
    private WebElement DeletTimesheetconfimBtn;

    @FindBy(css="body > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > svg:nth-child(1) > path:nth-child(1)")
    private WebElement TimesheetcannotDeletetoast;

    //Shift schedule

    @FindBy(xpath="//span[.='Add']")
    private WebElement AddShiftScheduleBtn;

    @FindBy(xpath="//span[.='Delete']")
    private WebElement DeleteShiftScheduleBtn;

    @FindBy(xpath="//span[.='Refresh']")
    private WebElement ShiftRefreshicon;

    @FindBy(css="body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")
     private  WebElement ShiftCalculatorICon;

    @FindBy(css="body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > form:nth-child(1) > div:nth-child(2) > div:nth-child(2)")
    private WebElement AddShiftPerson;

    @FindBy(xpath="(//button[text()='Confirm'])[2]")
    private WebElement AddpersonConfirmBtn;

    @FindBy(css="body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > form:nth-child(1) > div:nth-child(3) > div:nth-child(2)")
    private WebElement AddShifttimesheetBtn;

    @FindBy(css="body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > form:nth-child(1) > div:nth-child(5) > div:nth-child(2) > div:nth-child(1)")
    private WebElement AddStartDateBtn;

    @FindBy(css="body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > form:nth-child(1) > div:nth-child(6) > div:nth-child(2) > div:nth-child(1)")
    private WebElement AddEndTimeBtn;

    @FindBy(xpath="//button[.='Confirm']")
    private WebElement ShiftConfirmBtn;

    @FindBy(css="body > div:nth-child(7) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")
    private WebElement AddPersonUnderShift;

    @FindBy(css="body > div:nth-child(7) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")
    private WebElement AddTimeShiftForShift;

    @FindBy(xpath="//button[.='Confirm']")
    private WebElement AddConfrimBtn;

    @FindBy(xpath="//*[text()='Timesheet is already added to employee']")
    private WebElement DuplicateScheduleName;

    //    @FindBy(className ="(//*[contains(@class, 'MuiButtonBase-root') and contains(@class, 'css-slyssw')])[1]")
//    private WebElement StartDatePicker;
//    @FindBy(xpath = "(//*[contains(@class, 'MuiButtonBase-root') and contains(@class, 'css-slyssw')])[2]")
//    private WebElement EndDatePicker;
    private boolean WebElement;
    //private org.openqa.selenium.WebElement getViewToggleButton;
    public Object getViewToggleButton;


    public WebElement getAttendance_Module() {
        return Attendance_Module;
    }

    public WebElement getView_Attendance_Punch() {
        return View_Attendance_Punch;
    }

    public WebElement getViewAllHeadersData() {
        return ViewAllHeadersData;
    }

    public WebElement getViewToggleButton() {
        WebElement toggleBtn = getViewToggleButton();
        return ViewToggleButton;
    }

    public WebElement getUploadTranscationIcon() {
        return UploadTranscationIcon;
    }

    public WebElement getView_Attendance_Punch_header() {
        return View_Attendance_Punch_header;
    }

    public WebElement getSearch_Field_display_btn() {
        return Search_Field_display_btn;
    }

    public WebElement getShow_Mind_Records_Toggle_Btn() {
        return Show_Mind_Records_Toggle_Btn;
    }

    public WebElement getShow_Usage_Toggle_btn() {
        return Show_Usage_Toggle_btn;
    }

    public WebElement getDownload_Hover_Btn() {
        return Download_Hover_Btn;
    }

    public WebElement getRefresh_Click_icon() {
        return Refresh_Click_icon;
    }

    public List<WebElement> getView_Attendance_All_Headers() {
        return View_Attendance_All_Headers;
    }

    public List<WebElement> getView_Page_Records() {
        return View_Page_Records;
    }

    public WebElement getPerson_Sort_Arrow_btn() {
        return Person_Sort_Arrow_btn;
    }

    public WebElement getPerson_ID_Arrow_btn() {
        return Person_ID_Arrow_btn;
    }

    public WebElement getPunch_date_sort_btn() {
        return Punch_date_sort_btn;
    }

    public WebElement getStart_Date_punch_Filter() {
        return Start_Date_punch_Filter;
    }

    public WebElement getEnd_Date_Punch_Filter() {
        return End_Date_Punch_Filter;
    }

    public WebElement getAttendance_record_arrow_btn() {
        return Attendance_record_arrow_btn;
    }

    public WebElement getShiftScheduleSubModule(){
        return ShiftScheduleSubModule;
    }

    public WebElement getTimeZone_Arrow_btn() {
        return TimeZone_Arrow_btn;
    }

    public WebElement getSource_Arrow_btn() {
        return Source_Arrow_btn;
    }

    public WebElement getFilter_search_bar_ViewAtt() {
        return Filter_search_bar_ViewAtt;
    }

    public WebElement getUsage_tips_icon() {
        return Usage_tips_icon;
    }

    public WebElement getDownload_reports_icon() {
        return Download_reports_icon;
    }

    public WebElement getXlsX_download_format() {
        return XlsX_download_format;
    }

    public WebElement getCSV_Download_Format() {
        return CSV_Download_Format;
    }

    public WebElement getDownload_transcation_icon() {
        return Download_transcation_icon;
    }

    public WebElement getFromDate_label() {
        return FromDate_label;
    }

    public WebElement getToDate_label() {
        return ToDate_label;
    }

    public WebElement gettranscation_Confirm_btn() {
        return transcation_Confirm_btn;
    }

    public WebElement getFutureDate_ErrorMessage() {
        return FutureDate_ErrorMessage;
    }

    public WebElement getMend_Attendance_punch_Header() {
        return Mend_Attendance_punch_Header;
    }

    public WebElement getView_Attedance_refresh() {
        return View_Attedance_refresh;
    }

    public WebElement getNo_of_rows_icon() {
        return No_of_rows_icon;
    }

    public WebElement getPunch_State_Filter_Icon() {
        return Punch_State_Filter_Icon;
    }

    public WebElement getTen_records_per_page() {
        return Ten_records_per_page;
    }

    public WebElement getScroll_bar_viewAtt() {
        return Scroll_bar_viewAtt;
    }

    public WebElement getTwenty_records_per_page() {
        return Twenty_records_per_page;
    }


    public WebElement getFiFTY_records_per_page() {
        return FiFTY_records_per_page;
    }

    public WebElement getGO_TO_Next_page() {
        return GO_TO_Next_page;
    }

    public WebElement getGO_TO_Previous_Page() {
        return GO_TO_Previous_Page;
    }

    public WebElement getMend_Attendance_punch_submodule() {
        return Mend_Attendance_punch_submodule;
    }

    public WebElement getAdd_mend_Attendance_btn() {
        return Add_mend_Attendance_btn;
    }

    public WebElement getAdd_MendAtt_confirm_btn() {
        return Add_MendAtt_confirm_btn;
    }

    public WebElement getAdd_person_DropdownTF() {
        return Add_person_DropdownTF;
    }

    public WebElement getSelect_First_Radio_btn() {
        return Select_First_Radio_btn;
    }

    public WebElement getMend_Att_confirm_btn() {
        return Mend_Att_confirm_btn;
    }

    public WebElement getSelect_First_record() {
        return Select_First_record;
    }

    public WebElement getUserDefine_Date_Mend() {
        return UserDefine_Date_Mend;
    }

    public WebElement getUserDefine_time() {
        return UserDefine_time;
    }

    public WebElement getSuccess_Popup_Message() {
        return Success_Popup_Message;
    }

    public WebElement getAdd_medAtt_Cancel_btn() {
        return Add_medAtt_Cancel_btn;
    }

    public WebElement getMend_ATT_Refresh_icon() {
        return Mend_ATT_Refresh_icon;
    }

    public WebElement getEdit_mendAtt_punch() {
        return Edit_mendAtt_punch;
    }

    public WebElement getValidate_Toast_Btn() {
        return Validate_Toast_Btn;
    }


    public WebElement getDelete_mend_Punch() {
        return Delete_mend_Punch;
    }

    public WebElement getDelete_confirm_btn() {
        return Delete_confirm_btn;
    }

    public WebElement getcancel_the_Delete_optn() {
        return cancel_the_Delete_optn;
    }

    public WebElement getTime_card_Management_subModule() {
        return Time_card_Management_subModule;
    }

    public WebElement getTime_card_Management_header() {
        return Time_card_Management_header;
    }

    public WebElement getFrom_Date_Visibility() {
        return From_Date_Visibility;
    }

    public WebElement getTo_Date_Visibility() {
        return To_Date_Visibility;
    }

    public List<WebElement> getTo_Display_All_records() {
        return To_Display_All_records;
    }

    public WebElement getAbNormalRecordsCB() {
        return AbNormalRecordsCB;
    }

    public WebElement getExport_RecordsBtn() {
        return Export_RecordsBtn;
    }

    public WebElement getText_Area_Field() {
        return Text_Area_Field;
    }

    public WebElement getExport_From_Date() {
        return Export_From_Date;
    }

    public WebElement getExport_To_Date() {
        return Export_To_Date;
    }

    public WebElement getAutomatic_SendingFRTDate() {
        return Automatic_SendingFRTDate;
    }

    public WebElement getTimeForSendingReport() {
        return TimeForSendingReport;
    }

    public WebElement getEmailShareList() {
        return EmailShareList;
    }

    public WebElement getSecondConfirmBtn() {
        return SecondConfirmBtn;
    }

    public WebElement getSuccessToastMessage() {
        return SuccessToastMessage;
    }

    public WebElement getWeeklYToggleBtn() {
        return WeeklYToggleBtn;
    }

    public WebElement getMonthlyToggleBtn() {
        return MonthlyToggleBtn;
    }

    public WebElement getRecordWithTimeZoneDisable() {
        return RecordWithTimeZoneDisable;
    }

    public List<WebElement> getExportListRecord() {
        return ExportListRecord;
    }

    public List<WebElement> getTimeCardRefreshBtn() {
        return TimeCardRefreshBtn;
    }

    public List<WebElement> getScrollUntilllastElement() {
        return ScrollUntilllastElement;
    }

    public WebElement getTotalRecordsForTimeCard(){
        return TotalRecordsForTimeCard;
    }

    public WebElement getGoTo_next_page(){
        return GoTo_next_page;
    }

    public WebElement getGoToPreviousPage(){
        return GoToPreviousPage;
    }

    public WebElement getConfirmbutton() {
        return confirmbutton;
    }

    public  WebElement getAttendance_Timesheetpage(){
        return Attendance_Timesheetpage;
    }

    public WebElement getView_Attendance_page(){
        return View_Attendance_page;
    }

    public WebElement getView_Hover_icon(){
        return View_Hover_icon;
    }

    public WebElement getView_TimeSheet_Cycle(){
        return View_TimeSheet_Cycle;
    }

    public WebElement getKnow_more_about_this(){
        return Know_more_about_this;
    }

    public WebElement getScrollToTopViewAtt(){
        return ScrollToTopViewAtt;
    }

    public WebElement getAddTimeSheetBtn(){
        return AddTimeSheetBtn;
    }

    public WebElement getDayChangeTime() {
        return dayChangeTime;
    }

    public WebElement getTimesheetDescription() {
        return timesheetDescription;
    }

    public WebElement getArrowForwardicontimesheet() {
        return ArrowForwardicontimesheet;
    }

    public WebElement getFlexiblecheckbox() {
        return Flexiblecheckbox;
    }

    public WebElement getTimeSheetNametext() {
        return timeSheetNametext;
    }



    public WebElement getEdit_Timesheet_Page(){
        return Edit_Timesheet_Page;
    }

    public WebElement getEdit_TimeSheet_NamePh(){
        return Edit_TimeSheet_NamePh;
    }

    public WebElement getEdit_TimeSheet_Description(){
        return Edit_TimeSheet_Description;
    }

    public WebElement getlastRowForCycle1(){
        return lastRowForCycle1;
    }

    public WebElement getRepeatCycleIcon(){
        return RepeatCycleIcon;
    }

    public WebElement getNormalTimesheetRadioBtn(){
        return NormalTimesheetRadioBtn;
    }

    public WebElement getFlexibleTimesheetRadioBtn(){
        return FlexibleTimesheetRadioBtn;
    }

    public WebElement getlastIndexForCycle2(){
        return lastIndexForCycle2;
    }

    public List<WebElement> getAllheadersAvailableonEditTS(){
        return AllheadersAvailableonEditTS;
    }

    public WebElement getChangeTimePH(){
        return ChangeTimePH;
    }

    public WebElement getStatisticRuleMode(){
        return StatisticRuleMode;
    }

    public WebElement getFirstAndLastDP(){
        return FirstAndLastDP;
    }

    public WebElement getODDAndEvenDp(){
        return ODDAndEvenDp;
    }

    public WebElement getBreakTimeMoreThanCheckin(){
        return BreakTimeMoreThanCheckin;
    }
    public WebElement getBreakTimeMoreThanCheckinToastMessage(){
        return BreakTimeMoreThanCheckinToastMessage;
    }

    public WebElement getBreakTimeEnabled(){
        return BreakTimeEnabled;
    }

    public WebElement getEnableOverTimeToggle(){
        return EnableOverTimeToggle;
    }

    public WebElement getSearchtextField(){
        return SearchtextField;
    }

    public WebElement getFindRecordIsdisplayed(){
        return FindRecordIsdisplayed;
    }

    public WebElement getbreakTimeCyclebtn(){
        return breakTimeCyclebtn;
    }

    public WebElement getBreakTimeExceeds(){
        return BreakTimeExceeds;
    }

    public WebElement getDeleteTimesheetBtn(){
        return DeleteTimesheetBtn;
    }

    public WebElement getDeletTimesheetconfimBtn(){
        return DeletTimesheetconfimBtn;
    }

    public WebElement getTimesheetcannotDeletetoast(){
        return TimesheetcannotDeletetoast;
    }

    public WebElement getStartTimeTimesheet(){
        return StartTimeTimesheet;
    }

    public WebElement getEndTimeCheckin(){
        return EndTimeCheckin;
    }

    public WebElement getBreakTimeErrorMessage() {
        return BreakTimeErrorMessage;
    }
    //Shift Schedule

    public WebElement getAddShiftScheduleBtn(){
        return AddShiftScheduleBtn;
    }

    public WebElement getDeleteShiftScheduleBtn(){
        return DeleteShiftScheduleBtn;
    }

    public WebElement getShiftRefreshicon(){
        return ShiftRefreshicon;
    }

    public WebElement getShiftCalculatorICon(){
        return ShiftCalculatorICon;
    }

    public WebElement getAddShiftPerson(){
        return AddShiftPerson;
    }

    public WebElement getAddpersonConfirmBtn(){
        return AddpersonConfirmBtn;
    }

    public WebElement getAddShifttimesheetBtn(){
        return AddShifttimesheetBtn;
    }

    public WebElement getAddStartDateBtn(){
        return AddStartDateBtn;
    }

    public WebElement getAddEndTimeBtn(){
        return AddEndTimeBtn;
    }

    public WebElement getShiftConfirmBtn(){
        return ShiftConfirmBtn;
    }

    public WebElement getAddPersonUnderShift(){
        return AddPersonUnderShift;
    }

    public WebElement getAddTimeShiftForShift(){
        return AddTimeShiftForShift;
    }

    public WebElement getAddConfrimBtn(){
        return AddConfrimBtn;
    }

    public WebElement getDuplicateScheduleName(){
        return DuplicateScheduleName;
    }
    
    //parv's code
     
    @FindBy(xpath = "(//p[normalize-space()='Attendance'])[1]")
    private WebElement attendanceButton;
 
    public WebElement getattendanceButton() {
        return attendanceButton;
    }
    @FindBy(xpath = "//p[text()='Shift Schedule']")
    private WebElement shiftscheduleButton;
 
    public WebElement getshiftscheduleButton() {
        return shiftscheduleButton;
    }
    @FindBy(xpath = " //p[text()='Select Person']/following::input[1]")
    private WebElement selectpersonField;
 
    public WebElement getselectpersonField() {
        return selectpersonField;
    }
    
    @FindBy(xpath = "//input[@placeholder='Search by Person First Name']")
    private WebElement firstpersonnameField;
 
    public WebElement getfirstpersonnameField() {
        return firstpersonnameField;
    }
    @FindBy(xpath = " //p[text()='Select Timesheet']/following::input[1]")
    private WebElement selecttemplateField;
 
    public WebElement getselecttemplateField() {
        return selecttemplateField;
    }
    @FindBy(xpath = "//input[@placeholder='Search by Timesheet Name']")
    private WebElement inputtemplateField;
 
    public WebElement getinputtemplateField() {
        return inputtemplateField;
    }
    

    //        public WebElement getStartDatePicker(){
//        return StartDatePicker;
//        }
//
//        public WebElement getEndDatePicker(){
//        return EndDatePicker;
//        }

    public static void AttendanceModuleMethod(WebDriver driver, Attendance attendance) {
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getAttendance_Module())).click();
    }

    public static void SelectMendAtt_Punch_Method(WebDriver driver, Attendance attendance) {
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getMend_Attendance_punch_submodule())).click();
    }

    public static void SelectedViewAttendancepunch(WebDriver driver, Attendance attendance) {
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getView_Attendance_Punch())).click();
        wait.until(ExpectedConditions.urlContains("/transaction"));
    }

    public static void ValidateTheAllTheComponentsInsideViewAttendancePunch(WebDriver driver, Attendance attendance) {
        wait.until(ExpectedConditions.visibilityOf(attendance.getView_Attendance_Punch_header())).isDisplayed();
        wait.until(ExpectedConditions.visibilityOf(attendance.getSearch_Field_display_btn())).isDisplayed();
        wait.until(ExpectedConditions.visibilityOf(attendance.getShow_Mind_Records_Toggle_Btn())).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hoverElement = wait.until(ExpectedConditions.visibilityOf(attendance.getDownload_Hover_Btn()));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();
        WebElement hoverTranscation = wait.until(ExpectedConditions.visibilityOf(attendance.getUploadTranscationIcon()));
        Actions action = new Actions(driver);
        actions.moveToElement(hoverTranscation).perform();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getRefresh_Click_icon())).click();
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

    public static void MendPunch_Enable_code(WebDriver driver, Attendance attendance) {
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getShow_Mind_Records_Toggle_Btn())).click();
        List<WebElement> redTextRecords = attendance.getView_Page_Records();
        String expectedRedColor = "rgb(0, 0, 0,0.87)";
        for (WebElement record : redTextRecords) {
            String actualColor = record.getCssValue("color");
//            System.out.println("Text: " + record.getText() + ", Color: " + actualColor);
//            assertEquals(actualColor, expectedRedColor, "Text color is not red for record: " + record.getText());
        }
    }

    public static void Sort_ArrowClass(WebDriver driver, Attendance attendance) {
        wait.until(ExpectedConditions.visibilityOf(attendance.getPerson_Sort_Arrow_btn())).click();
        wait.until(ExpectedConditions.visibilityOf(attendance.getPerson_ID_Arrow_btn())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getPunch_date_sort_btn())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getAttendance_record_arrow_btn())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getTimeZone_Arrow_btn())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getSource_Arrow_btn())).click();

    }

    public static void userShouldSuccessfullyAddPersonToTheMendPunch(WebDriver driver, Attendance attendance) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getAdd_mend_Attendance_btn())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getAdd_person_DropdownTF())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getNo_of_rows_icon())).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getTen_records_per_page())).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getNo_of_rows_icon())).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getTwenty_records_per_page())).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getNo_of_rows_icon())).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getFiFTY_records_per_page())).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getNo_of_rows_icon())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getTen_records_per_page())).click();
        Thread.sleep(6000);
        WebElement GoNextPage =
                wait.until(ExpectedConditions.elementToBeClickable(attendance.getGO_TO_Next_page()));
        if (GoNextPage.isEnabled()) {
            GoNextPage.click();
            Thread.sleep(6000);
        } else System.out.println("Next Button is not enabled");
        WebElement Previous_Btn =
                wait.until(ExpectedConditions.elementToBeClickable(attendance.getGO_TO_Previous_Page()));
        if (Previous_Btn.isEnabled()) {
            Previous_Btn.click();
        } else System.out.println("Previous button is not enabled");
        //.sleep(2000);
        WebElement inputFile1 = wait.until(ExpectedConditions.elementToBeClickable(attendance.getFilter_search_bar_ViewAtt()));
        inputFile1.sendKeys(properties.getProperty("Person_ID"));
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.click(inputFile1).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(Invalid_personId).perform();
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        WebElement inputFile = wait.until(ExpectedConditions.elementToBeClickable(attendance.getFilter_search_bar_ViewAtt()));
        action.click(inputFile1).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();
        inputFile.sendKeys(properties.getProperty("person_Name"));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getSelect_First_record())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getMend_Att_confirm_btn())).click();
    }

    public static void userShouldAddTheMendAttendanceSuccessfully(WebDriver driver, Attendance attendance) {
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getAdd_mend_Attendance_btn())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getAdd_person_DropdownTF())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getSelect_First_record())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getMend_Att_confirm_btn())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getUserDefine_Date_Mend())).sendKeys(properties.getProperty("MendPunchDate"));
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getUserDefine_time())).sendKeys(properties.getProperty("Mendpunch_Time"));
        wait.until(ExpectedConditions.elementToBeClickable(attendance.gettranscation_Confirm_btn())).click();
        wait.until(ExpectedConditions.visibilityOf(attendance.getSuccess_Popup_Message())).isDisplayed();
    }

    public static void userShouldAbleToCancelTheAddFunctionality(WebDriver driver, Attendance attendance) {
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getAdd_mend_Attendance_btn())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getAdd_person_DropdownTF())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getSelect_First_record())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getMend_Att_confirm_btn())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getUserDefine_Date_Mend())).sendKeys(properties.getProperty("MendPunchDate"));
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getUserDefine_time())).sendKeys(properties.getProperty("Mendpunch_Time"));
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getAdd_medAtt_Cancel_btn())).click();

    }

    public static void FilterClass(WebDriver driver, Attendance attendance, String inputFiled, String inputFiled2) throws InterruptedException {
        WebElement inputFile1 = wait.until(ExpectedConditions.elementToBeClickable(attendance.getFilter_search_bar_ViewAtt()));
        inputFile1.sendKeys(properties.getProperty("Person_ID"));
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.click(inputFile1).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(Invalid_personId).perform();
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        WebElement inputFile = wait.until(ExpectedConditions.elementToBeClickable(attendance.getFilter_search_bar_ViewAtt()));
        action.click(inputFile1).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();
        inputFile.sendKeys(properties.getProperty("person_Name"));
        Thread.sleep(2000);
        Actions action2 = new Actions(driver);
        action2.click(inputFile).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(Invalid_personName).perform();
    }

    public static void FileDownloadFormat(WebDriver driver, Attendance attendance) {
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getDownload_reports_icon())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getXlsX_download_format())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getDownload_reports_icon())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getCSV_Download_Format())).click();
    }

    public static void pagination_listing(WebDriver driver, Attendance attendance) throws Exception {
        resetZoomToDefault();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getNo_of_rows_icon())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getTen_records_per_page())).click();
        //WebElement chatScrollContainer = attendance.getScroll_bar_viewAtt();
        //scrollTopToBottomAndBack(chatScrollContainer, driver);
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getNo_of_rows_icon())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getTwenty_records_per_page())).click();
       // WebElement chatScrollContainer1 = attendance.getScroll_bar_viewAtt();
        //scrollTopToBottomAndBack(chatScrollContainer1, driver);
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getNo_of_rows_icon())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getFiFTY_records_per_page())).click();
        //WebElement chatScrollContainer2 = attendance.getScroll_bar_viewAtt();
        //scrollTopToBottomAndBack(chatScrollContainer2, driver);
    }

    public static void userCanUpdateTheMendRecordPunch(WebDriver driver, Attendance attendance) {
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getEdit_mendAtt_punch())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getUserDefine_Date_Mend())).sendKeys(properties.getProperty("MendPunchDate"));
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getUserDefine_time())).sendKeys(properties.getProperty("Mendpunch_Time"));
        wait.until(ExpectedConditions.elementToBeClickable(attendance.gettranscation_Confirm_btn())).click();
        wait.until(ExpectedConditions.visibilityOf(attendance.getValidate_Toast_Btn())).isDisplayed();
    }

    public static void userCanCancelTheUpdateFunctionality(WebDriver driver, Attendance attendance) {
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getEdit_mendAtt_punch())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getUserDefine_Date_Mend())).sendKeys(properties.getProperty("MendPunchDate"));
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getUserDefine_time())).sendKeys(properties.getProperty("Mendpunch_Time"));
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getAdd_medAtt_Cancel_btn())).click();

    }

    public static void userCanDeleteTheMendAttendancePunch(WebDriver driver, Attendance attendance) {
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getDelete_mend_Punch())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getDelete_confirm_btn())).click();
        wait.until(ExpectedConditions.visibilityOf(attendance.getSuccess_Popup_Message())).isDisplayed();

    }

    public static void userCanCancelTheDeleteOperation(WebDriver driver, Attendance attendance) {
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getDelete_mend_Punch())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getcancel_the_Delete_optn())).click();

    }

    public static void userShouldFilterTheRecordsBasedOnPunchDate(WebDriver driver, Attendance attendance) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getPunch_State_Filter_Icon())).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(attendance.getStart_Date_punch_Filter())).sendKeys(properties.getProperty("Punch_StartDate"));
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(attendance.getEnd_Date_Punch_Filter())).sendKeys(properties.getProperty("Punch_EndDate"));
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getPunch_State_Filter_Icon())).click();

    }

    public static void scrollTopToBottomAndBack(WebElement element, WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long scrollHeight = (long) js.executeScript("return arguments[0].scrollHeight;", element);
        long currentPosition = 0;
        while (currentPosition < scrollHeight) {
            js.executeScript("arguments[0].scrollTop = arguments[1];", element, currentPosition);
            Thread.sleep(500);
            currentPosition += 1000;
        }
        while (currentPosition > 0) {
            currentPosition -= 1000;
            js.executeScript("arguments[0].scrollTop = arguments[1];", element, currentPosition);
            Thread.sleep(500);
        }
    }

    public static void Next_previous_page(WebDriver driver, Attendance attendance) throws Exception {

       resetZoomToDefault();
//        Thread.sleep(2000);
//        wait.until(ExpectedConditions.elementToBeClickable(attendance.getGoTo_next_page())).click();
//        Thread.sleep(2000);
//
//        wait.until(ExpectedConditions.elementToBeClickable(attendance.getGoTo_next_page())).click();
//        Thread.sleep(6000);
//        wait.until(ExpectedConditions.elementToBeClickable(attendance.getGoToPreviousPage())).click();
//        Thread.sleep(6000);
//        wait.until(ExpectedConditions.elementToBeClickable(attendance.getGoToPreviousPage())).click();
//        Thread.sleep(2000);

        resetZoomToDefault();
        Thread.sleep(2000);

// Click next page until it's not clickable anymore
        while (true) {
            try {
                WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(attendance.getGoTo_next_page()));
                nextBtn.click();
                Thread.sleep(2000);
            } catch (TimeoutException e) {
                System.out.println("Reached last page. 'Next' button is no longer clickable.");
                break;
            }
        }

// Click previous page until it's not clickable anymore
        while (true) {
            try {
                WebElement prevBtn = wait.until(ExpectedConditions.elementToBeClickable(attendance.getGoToPreviousPage()));
                prevBtn.click();
                Thread.sleep(2000);
            } catch (TimeoutException e) {
                System.out.println("Reached first page. 'Previous' button is no longer clickable.");
                break;
            }
        }

    }

    public static void Next_Page_Previous_page_With_single_record(WebDriver driver, Attendance attendance) throws Exception {
        resetZoomToDefault();
        try {
            wait.until(ExpectedConditions.elementToBeClickable(attendance.getNo_of_rows_icon())).click();
            wait.until(ExpectedConditions.elementToBeClickable(attendance.getTen_records_per_page())).click();
            Thread.sleep(6000);
        } catch (Exception e) {
            System.out.println("Failed to set records per page: " + e.getMessage());
        }
        try {
            WebElement nextPage = wait.until(ExpectedConditions.elementToBeClickable(attendance.getGO_TO_Next_page()));
            if (nextPage != null && nextPage.isEnabled()) {
                nextPage.click();
                System.out.println("Next page clicked.");
            } else {
                System.out.println("Next button is not clickable or not enabled.");
            }
        } catch (Exception e) {
            System.out.println("Exception while clicking Next button: " + e.getMessage());
        }
        Thread.sleep(6000);
        try {
            WebElement previousBtn = wait.until(ExpectedConditions.elementToBeClickable(attendance.getGO_TO_Previous_Page()));
            if (previousBtn != null && previousBtn.isEnabled()) {
                previousBtn.click();
                System.out.println("Previous page clicked.");
            } else {
                System.out.println("Previous button is not clickable or not enabled.");
            }
        } catch (Exception e) {
            System.out.println("Exception while clicking Previous button: " + e.getMessage());
        }
        Thread.sleep(2000);
    }

    public static void ExportRecordusingAutomaticReportToggle(WebDriver driver, Attendance attendance) throws InterruptedException {
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

    public static String getTodayDateAsNumber() {
        return java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("ddMMyyyy"));
    }

    public static void CodeForDisableTimeZone(WebDriver driver, Attendance attendance) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getExport_RecordsBtn())).click();
        WebElement TimeForSendingReport = wait.until(ExpectedConditions.elementToBeClickable(attendance.getTimeForSendingReport()));
        TimeForSendingReport.click();
        Actions Input = new Actions(driver);
        Input.click(TimeForSendingReport).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE);
        TimeForSendingReport.sendKeys(properties.getProperty("ClockTime"));
        WebElement EmailShareList = wait.until(ExpectedConditions.elementToBeClickable(attendance.getEmailShareList()));
        EmailShareList.click();
        Actions EmailShare = new Actions(driver);
        EmailShare.click(EmailShareList).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(properties.getProperty("EmailShareList")).perform();
        WebElement ScrollUntilFindElement = wait.until(ExpectedConditions.visibilityOf(attendance.getSecondConfirmBtn()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ScrollUntilFindElement);
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getRecordWithTimeZoneDisable())).click();
        wait.until(ExpectedConditions.elementToBeClickable(attendance.getSecondConfirmBtn())).click();
        wait.until(ExpectedConditions.visibilityOf(attendance.getSuccessToastMessage())).isDisplayed();
    }

    public static void userShouldListTheRecordsBySelecting(WebDriver driver,Attendance attendance) throws Exception {

        resetZoomToDefault();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> recordsPerPageOptions = Arrays.asList(
                attendance.getTen_records_per_page(),
                attendance.getTwenty_records_per_page(),
                attendance.getFiFTY_records_per_page()
        );
        List<String> optionLabels = Arrays.asList("10", "20", "50");
        for (int i = 0; i < recordsPerPageOptions.size(); i++) {
            // Step 1: Open dropdown and select option
            wait.until(ExpectedConditions.elementToBeClickable(attendance.getNo_of_rows_icon())).click();
            wait.until(ExpectedConditions.elementToBeClickable(recordsPerPageOptions.get(i))).click();
            Thread.sleep(1000);

            List<WebElement> scrollContainers = attendance.getScrollUntilllastElement();
            if (!scrollContainers.isEmpty()) {
                WebElement scrollContainer = scrollContainers.get(0); // Pick first element
                scrollToLastRecord(scrollContainer, driver);          // Pass it to the scroll method
                System.out.println("Scrolled through records-per-page: " + optionLabels.get(i));
            } else {
                System.out.println("No scroll container found for records-per-page: " + optionLabels.get(i));
            }
        }
    }

    public static void scrollToLastRecord(WebElement scrollContainer, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        long lastHeight = (long) js.executeScript("return arguments[0].scrollHeight", scrollContainer);

        while (true) {
            js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", scrollContainer);
            try {
                Thread.sleep(1000); // Wait for new records (if lazy loaded)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long newHeight = (long) js.executeScript("return arguments[0].scrollHeight", scrollContainer);
            if (newHeight == lastHeight) {
                break; // Reached bottom
            }
            lastHeight = newHeight;
        }

    }

    public static void userCanRefreshThePageAndRecordsShouldGetListedProperly(WebDriver driver,Attendance attendance) throws InterruptedException {
        WebElement BeforeText = attendance.getTotalRecordsForTimeCard();
        String BeforeRefresh = BeforeText.getText();
        System.out.println("📄 Before Refresh: " + BeforeRefresh);
        List<WebElement> paginationBefore = attendance.getTimeCardRefreshBtn();

        for(WebElement beforeText:paginationBefore) {

            if (beforeText.isDisplayed()) {
                //String beforeText = paginationBefore. ();
                System.out.println("📄 Before Refresh: " + beforeText);
            }
        }
        // Step 2: Click refresh
        List<WebElement> refreshIcon =  attendance.getTimeCardRefreshBtn();
        for(WebElement AfterSelecction:refreshIcon){
            if(AfterSelecction.isDisplayed()){
                AfterSelecction.click();
            }
        }
        Thread.sleep(2000); // Or use WebDriverWait if data change is observable

        // Step 3: Capture pagination text again
        WebElement paginationAfter = attendance.getTotalRecordsForTimeCard();
        String afterText = paginationAfter.getText();
        System.out.println("📄 After Refresh: " + afterText);

        // Step 4: Validate: at least pagination exists
        Assert.assertTrue("❌ Pagination info not visible after refresh.", paginationAfter.isDisplayed());

        // Optional: Compare before & after text (if data was expected to change)
        if (!BeforeRefresh.equals(afterText)) {
            System.out.println("✅ Data was updated after refresh.");
        } else {
            System.out.println("ℹ️ Data remained the same after refresh (but page still refreshed).");
        }
    }
}





