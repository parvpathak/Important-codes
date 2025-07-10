@NGTeco @System
Feature: NGTeco
  Background:
    Given User has launched the URL

#  Login
#  @TC_01 @TC_SignIn_03 @Sanity @Smoke
#  Scenario:Verify whether user can Login with valid email,companyName and password
#    Given user will provide valid username and password
#    When user will click on Login buttonf
#    Then user will validate dashboard page

  @smoke @sanity @TC_489 @View_Attendance
  Scenario:Verify view attendance punch is displayed along with below components when clicked on Uplod Transcations icon
  1.From
  2.To
  3.Confirm
    Given user login to the application
    Given when Admin click on Attendance module
    And Selected View Attendance punch
    Then upload the transcations for the selected date

    @Smoke @sanity @ChatBotTC_01 @TC_61 @ChatBot
      Scenario: Verify whether user can chat with customer service and resolve their issues using the chatbot option.
      Given user login to the application
      When user selects the chatbot and entered the message
      Then user should able to get the response from chat bot

     @Smoke @sanity @ChatBotTC_02 @TC_62 @ChatBot
       Scenario:Verify whether user is able to MInimize the chatbot windoow.
       Given user login to the application
       When user selects the chatbot and entered the message
       Then user should able to get the response from chat bot
       Then user close the chatBot window

    @Smoke @Sanity @ChatBot_03 @TC_63 @ChatBot
    Scenario: Verify whether user can scroll the page top to bottom and bottom to top to read all the connversations
      Given user login to the application
      When user selects the chatbot and entered the message
      Then user should able to get the response from chat bot
       Then User should scroll the chatBot window from bottom to top and from top to bottom

     @smoke @Sanity @chatBot_04 @TC_64 @ChatBot
    Scenario: Verify whether user can delete the chat history
       Given user login to the application
       When user selects the chatbot and entered the message
       Then user should able to get the response from chat bot
       Then User should delete the chatBot successfully

#  @smoke @Sanity @chatBot_05
#      Scenario: Verify whether user is able to apply the options  such as
#      1.Bold
#      2.Italic
#      3.Ordered list item
#      4.Unorder List item
#        Given user login to the application
#        When user selects the chatbot and entered the message
#        Then user should able to get the response from chat bot
#        Then User should delete the conversation by clicking on delete button

  @Smoke @Sanity @organization_management @Organization_TC_01 @TC_138
  Scenario: Verify whether  user can validate the presence of below components in
  organization profile page
  Edit Icon
  Delete icon
  Organization name with information icon
  Organization code  with information icon
    Given user login to the application
    When user click on organization management submodule
    Then User entered inside organization profile home page




       @Smoke @Sanity @organization_management @Organization_TC_02 @TC_139
         Scenario: Verify whether user cannot update the name with more than 200 characters
         Given user login to the application
         When user click on organization management submodule
         Then User is trying to update the name field by entering more than 200 characters


  @Smoke @Sanity @organization_management @TC_04 @Organization_TC_003 @TC_140
  Scenario: Verify whether user can update the organization profile
    Given user login to the application
    When user click on organization management submodule
    Then user Edit the organization profile and saving the details
    Then User validate all the mentioned country list in Edit organization
    Then User upload the organization profile image successfully

  @Smoke @Sanity @organization_management @TC_04 @Organization_TC_003 @TC_141
  Scenario: Verify whether  user cannot update the profile photo when the size is more than 3 MB
    Given user login to the application
    When user click on organization management submodule
    Then user can update the profile photo which is more than 3MB size

  @Smoke @Sanity @organization_management @TC_04 @Organization_TC_04 @TC_142
  Scenario: Verify whether user can cancel the update functionality
    Given user login to the application
    When user click on organization management submodule
    Then user Edit the organization profile and saving the details
    Then User validate all the mentioned country list in Edit organization
    Then User click on cancel button and redirecting to organization profile page


  @Smoke @Sanity @organization_management @TC_05 @Organization_TC_05 @TC_143
   Scenario: Verify whether user cannot delete the organization if  any persons or devices are already exists
    Given user login to the application
    When user click on organization management submodule
    Then User trying to delete the organization permanently by having atleast one employee

    @Smoke @Sanity @organization_management @TC_05 @Organization_TC_06 @TC_144
      Scenario: Verify whether user can cancel the organization delete functionality
      Given user login to the application with new credentials
      When user click on organization management submodule
      Then User entered inside organization profile home page
      Then User trying to cancel the delete organization operation

  @Smoke @Sanity @organization_management @TC_04 @Organization_TC_07  @TC_145
          Scenario:Verify whether user can delete the account permanently if no persons and no devices are available
            Given user login to the application with valid credentials
            When user click on organization management submodule
              Then User entered inside organization profile home page
            When user click on organization management submodule
            Then User trying to delete the organization permanently

  @Smoke @Sanity @organization_management @TC_03 @Organization_TC_03 @Negative
            Scenario:Verify whether user is not able to edit the organization profile without passing only organization name it should through some error message
              Given user login to the application
              When user click on organization management submodule
              Then User entered inside organization profile home page
              Then User is trying to edit profile by leaving Mandatory field


#          @Smoke @Sanity @organization_management @TC_05 @Organization_TC_05
#            Scenario: Verify whether  user is getting warning window before  deleting   the organization clicking on delete icon
#            Given  user login to the application
#            When user click on organization management submodule
#            Then User entered inside organization profile home page
#            Then User is trying to delete the organization

            @Organization_management @TC_06 @Organization_TC_006 @Negative
              Scenario: Verify whether  user is  not able to edit the organization profile without selecting any data in the country field dropdown
              Given  user login to the application
              When user click on organization management submodule
#              Then User enters the invalid country name and trying to save the details
              Then User selects the country from the dropdown and save the organization details

            @Organization_management @TC_07 @Organization_TC_07 @Negative
              Scenario: Verify whether user is  able to update the profile photo is less then 3 mb
              Given  user login to the application
              When user click on organization management submodule
              Then User upload the organization profile image successfully

            @Organization_management @TC_08 @Organization_TC_08  @Negative
              Scenario: Verify user is able to see all the mentioned countries in Edit Organization page
              Given  user login to the application
              When user click on organization management submodule
              Then User validate all the mentioned country list in Edit organization


  @smoke @sanity @TC_327  @View_Attendance_01 @Attendance @View_Attendance
  Scenario: Verify whether user can validate the presence of below components
  1.Person Name column
  2.Person ID column
  3.Punch Date column
  4.Attendance record column
  5.Show mended records toggle button
  6.Upload transactions icon
  7.Usage Tips info icon
  8.Refresh icon
  9.Search field
  10.View Attendance Punch Label
  11.Page size dropdown
  12.Forward page navigation icon
  13.Previous page navigation icon
    Given user login to the application
    Given when Admin click on Attendance module
    And Selected View Attendance punch
    Then user should validate the all the components inside View Attendance punch

  @smoke @sanity @TC_328 @View_Attendance_02 @View_Attendance
    Scenario: Verify whether user can view Mended Attendance Punch records by enabling the Mended Attendance Punch icon
    Given user login to the application
    Given when Admin click on Attendance module
    And Selected View Attendance punch
    Then User should view the mend punches by enabling mend attendance

  @smoke @sanity @TC_329 @View_Attendance_03 @Attendance @View_Attendance
    Scenario: Verify whether user can sort the records in ascending or descending record
  by using person name, person Id, Attendance record,Time Zone and Source
    Given user login to the application
    Given when Admin click on Attendance module
    And Selected View Attendance punch
    Then User will perform the sort operation using person name,person id,Attendance record,Time Zone and Source

  @smoke @sanity @TC_330 @View_Attendance_04 @Attendance @View_Attendance
    Scenario: Verify whether user can filter the record by using punch date sort button or
  by using punch date filter operation
    Given user login to the application
    Given when Admin click on Attendance module
    And Selected View Attendance punch
    Then User should filter the records based on punch date

  @smoke @sanity @TC_331 @View_Attendance_05 @Attendance @View_Attendance
    Scenario: Verify whether user can filter the attendance punches based on person id
  or Person name
  by using punch date filter operation
    Given user login to the application
    Given when Admin click on Attendance module
    And Selected View Attendance punch
    Then user filter the record using person name and id fields

  @smoke @sanity @TC_332 @View_Attendance_06 @Attendance @View_Attendance
  Scenario: Verify whether user can glance the information by clicking on Usage Tips
    Given user login to the application
    Given when Admin click on Attendance module
    And Selected View Attendance punch
    Then User should able to glance the the information in the usage Tips

  @smoke @sanity @TC_333 @View_Attendance_07 @Attendance @View_Attendance
  Scenario: Verify whether user can download the Attendance records in XLSX and CSV formats
    Given user login to the application
    Given when Admin click on Attendance module
    And Selected View Attendance punch
    Then user should be able to export the records in CSV and Excel format


  @smoke @sanity @TC_334 @View_Attendance_08 @Attendance @View_Attendance
  Scenario: Verify Whether user can Upload Transactions by selecting the date range( user upload device attendance records? Only upload online devices)
    Given user login to the application
    Given when Admin click on Attendance module
    And Selected View Attendance punch
    Then user upload the transcations from the given input date

   @smoke @sanity @TC_335 @View_Attendance_09 @Attendance @View_Attendance
     Scenario: Verify whether  user can refresh the page and see the records listed properly.
     Given user login to the application
     Given when Admin click on Attendance module
     And Selected View Attendance punch
     Then User will refresh the page and records should listed properly

     @smoke @sanity @TC_336 @View_Attendance_10 @Attendance @View_Attendance
     Scenario: Verify whether user can change the number of records displayed per page by selecting 10, 20, or 50
       Given user login to the application
       Given when Admin click on Attendance module
       And Selected View Attendance punch
       Then user should list the records by selecting Ten twenty and Fifty per page

     @smoke @sanity @TC_337 @View_Attendance_11 @Attendance @View_Attendance
       Scenario: Verify whether the user can navigate to the next and previous pages using the navigation icons
       Given user login to the application
       Given when Admin click on Attendance module
       And Selected View Attendance punch
       Then user should navigate to next and previous page

     @smoke @sanity @TC_338 @Mend_Attendance_01 @Attendance @Mend_Attendance
     Scenario: Verify mend Attendance Punch page is displayed along with below components when user clicked on mend attendance module
     Mend Attendance page-Header
     Search icon, Add icon, Refresh icon
     and below columns
     person Name
     Person ID
     Punch Date
     Attendance record
     TimeZone
     Source
     Action
       Given user login to the application
       Given when Admin click on Attendance module
       When user select the Mend Attendance punch
       Then User should validate the presence of all components in that page

    @smoke @sanity @TC_339 @Mend_Attendance_02 @Attendance @Mend_Attendance
       Scenario: Verify whether user can filter the records through Person ID/ Person Name
      Given user login to the application
      Given when Admin click on Attendance module
      When user select the Mend Attendance punch
      Then user filter the record using person name and id fields

    @smoke @sanity @TC_340 @Mend_Attendance_03 @Attendance @Mend_Attendance
    Scenario: Verify whether error message is getting displayed of not when user is clicking on confirm button without providing any data in -
    1.Select user
    2.Set mend att-punch date
    3.Set mend att-punch Time
      Given user login to the application
      Given when Admin click on Attendance module
      When user select the Mend Attendance punch
      Then user should validate the Add mend attendance page


    @smoke @sanity @TC_341 @Mend_Attendance_04 @Attendance @Mend_Attendance
    Scenario: Verify whether user can search and select employee on Add attendance mend page
      Given user login to the application
      Given when Admin click on Attendance module
      When user select the Mend Attendance punch
      Then User should successfully add person to the mend punch

    @smoke @sanity @TC_342 @Mend_Attendance_05 @Attendance @Mend_Attendance
    Scenario: verify whether user can create Mend punch for single Employee
      Given user login to the application
      Given when Admin click on Attendance module
      When user select the Mend Attendance punch
      Then user should add the mend attendance successfully

    @smoke @sanity @TC_343 @Mend_Attendance_06 @Attendance @Mend_Attendance
   Scenario: Verify whether user can cancel the mend attendance punch
      Given user login to the application
      Given when Admin click on Attendance module
      When user select the Mend Attendance punch
      Then User should able to cancel the add functionality

     @smoke @sanity @TC_344 @Mend_Attendance_07 @Attendance @Mend_Attendance
     Scenario: Verify whether user can refresh the page
       Given user login to the application
       Given when Admin click on Attendance module
       When user select the Mend Attendance punch
       Then User should refresh the Mend attendance page and record should listed properly


      @smoke @sanity @TC_345 @Mend_Attendance_08 @Attendance @Mend_Attendance
     Scenario: Verify whether user can update mend attendance punch
        Given user login to the application
        Given when Admin click on Attendance module
        When user select the Mend Attendance punch
        Then user can update the mend record punch

    @smoke @sanity @TC_346 @Mend_Attendance_09 @Attendance @Mend_Attendance
    Scenario: Verify whether user can cancel the update mend attendance functionality
      Given user login to the application
      Given when Admin click on Attendance module
      When user select the Mend Attendance punch
      Then User can cancel the update functionality

    @smoke @sanity @TC_347 @Mend_Attendance_10 @Attendance @Mend_Attendance
      Scenario: Verify whether user can delete mend attendance punch
      Given user login to the application
      Given when Admin click on Attendance module
      When user select the Mend Attendance punch
      Then user can delete the mend attendance punch

    @smoke @sanity @TC_348 @Mend_Attendance_11 @Attendance @Mend_Attendance
      Scenario:Verify whether user can cancel the mend attendance punch
      Given user login to the application
      Given when Admin click on Attendance module
      When user select the Mend Attendance punch
      Then User can cancel the delete operation

     @smoke @sanity @TC_349 @Mend_Attendance_12 @Attendance @Mend_Attendance
    Scenario: verify whether user can sort the records by using
     person name, person ID,Attendance record,Time zone,Source and action
       Given user login to the application
       Given when Admin click on Attendance module
       When user select the Mend Attendance punch
       Then User can sort the record by using Mend record headers

     @smoke @sanity @TC_350 @Mend_Attendance_13 @Attendance @Mend_Attendance
     Scenario: Verify whether user can filter the records by using punch date
       Given user login to the application
       Given when Admin click on Attendance module
       When user select the Mend Attendance punch
       Then User should filter the records based on punch date

    @smoke @sanity @TC_351 @Mend_Attendance_14 @Attendance @Mend_Attendance
     Scenario: Verify whether user can set the pagination as 10,20,50 per page
      Given user login to the application
      Given when Admin click on Attendance module
      When user select the Mend Attendance punch
      Then user should list the records by selecting Ten twenty and Fifty per page

     @smoke @sanity @TC_352 @Mend_Attendance_15 @Attendance @Mend_Attendance
     Scenario: Verify whether user can navigate to forward and backward
       Given user login to the application
       Given when Admin click on Attendance module
       When user select the Mend Attendance punch
       Then user should to next page and the previous page

     @Time_Card_management_TC_01 @TC_353 @smoke @sanity @TimeCard_management
       Scenario: Verify whether user can validate the presence of below components in  Timecard Management page
     Timecard management -header
     From date-calender
     To date-calender
     Usage Tips
     Export, download and refresh icon
     and headers include
     1.Person Name
     2.PersonID
     3.Date
     4.Timesheet
     5.Clock In
     6.Clock out
     7.Clock Time
     8.Total Work Time(h)
     9.Total Break Time(h)
     10.Total Work Time(h)
     11.Total Time(h)
     12.Statistic Rule Mode
       Given user login to the application
       Given when Admin click on Attendance module
       When User selects Time card management submodule
       Then  User should validate all the components in Time card management page

   @Time_Card_management_TC_02 @TC_354 @smoke @sanity @TimeCard_management
   Scenario: Verify user can view all  Timecard Report done by employees in device as well as manual updated punches .
     Given user login to the application
     Given when Admin click on Attendance module
     When User selects Time card management submodule
     Then User should view all the punches done for the current month

  @Time_Card_management_TC_03 @TC_355 @smoke @sanity @TimeCard_management
  Scenario: Verify whether user can view abnormal records by selecting abnormal records only
    Given user login to the application
    Given when Admin click on Attendance module
    When User selects Time card management submodule
    Then User should view the abnormal reports by selecting abnormal records button

  @Time_Card_management_TC_04 @TC_356 @smoke @sanity @TimeCard_management
  Scenario: Verify user can filter the  person id,person name and timesheet.
    Given user login to the application
    Given when Admin click on Attendance module
    When User selects Time card management submodule
    Then User should able to filter the records using person name and timesheet

#    Calender code need to be done TC_05 @TC_372
  @Time_Card_management_TC_05 @TC_357 @smoke @sanity @TimeCard_management
  Scenario: Verify user can filter  the Timecard management records  by using calendar.
    Given user login to the application
    Given when Admin click on Attendance module
    When User selects Time card management submodule
    Then User should filter the records based on the selected date from the calender

   @Time_Card_management_TC_06 @TC_358 @smoke @sanity @TimeCard_management
  Scenario: Verify user can  View Usage Tips  click on usage tips icon in Timecard management page
     Given user login to the application
     Given when Admin click on Attendance module
     When User selects Time card management submodule
     Then User can view the usage tips in Timecard_management

   @Time_Card_management_TC_07 @TC_359 @smoke @sanity @TimeCard_management
     Scenario: Verify user can  Export time card management by selecting from and to date
     Given user login to the application
     Given when Admin click on Attendance module
     When User selects Time card management submodule
    Then User can export the records by selecting from and Todate

  @Time_Card_management_TC_08 @TC_360 @smoke @sanity @TimeCard_management
    Scenario: Verify whether user can enable the automatic report sending
    Given user login to the application
    Given when Admin click on Attendance module
    When User selects Time card management submodule
    Then User can enable and send automatic report sending


     @Time_Card_management_TC_09 @TC_361 @smoke @sanity @TimeCard_management
    Scenario: Verify whether user can export daily, Weekly or monthly wise
       Given user login to the application
       Given when Admin click on Attendance module
       When User selects Time card management submodule
       Then User can export report sending in daily weekly or monthly wise

    @Time_Card_management_TC_10 @TC_362 @smoke @sanity @TimeCard_management
    Scenario: Verify user can export the record by disabling the record with time zone
      Given user login to the application
      Given when Admin click on Attendance module
      When User selects Time card management submodule
      Then User can export the record by disabling timeZone

  @Time_Card_management_TC_11 @TC_363 @smoke @sanity @TimeCard_management
   Scenario: Verify user can able to Download the report by using XlSX or CSV format
    Given user login to the application
    Given when Admin click on Attendance module
    When User selects Time card management submodule
    Then user can download the report by using XLSX or CSV format

  @Time_Card_management_TC_12 @TC_364 @smoke @sanity @TimeCard_management
    Scenario: Verify user can refresh the page and records will listed properly
    Given user login to the application
    Given when Admin click on Attendance module
    When User selects Time card management submodule
    Then user can Refresh the page and records should get listed properly

  @Time_Card_management_TC_13 @TC_365 @smoke @sanity @TimeCard_management
  Scenario: Verify whether user can set the pagination as 10,20,50 per page
    Given user login to the application
    Given when Admin click on Attendance module
    When User selects Time card management submodule
    Then user should list the records by selecting Ten twenty and Fifty per pages

#-------------------------TimesheetCode-----------------------
   @TC_Attendance_Timesheet_280  @Attendance_TimeSheet @Quickstart @Sanity @Smoke
  Scenario: Verify whether Timesheet page contains below elements:
  1.Timesheet Name, Unit,Cycle,Description and Operation columns
  2.Add ,Refresh icon and search field
    Given user login to the application
    Given when Admin click on Attendance module
    When user navigates to Timesheet submodule page
    Then user should validate the timesheet page

   @TC_Attendance_Timesheet_281  @Attendance_TimeSheet @Sanity @Smoke
  Scenario: Verify whether user is able  to add a normal Timesheet by providing all the below details
  1.Number of Repetation
  2.Day,
  3.Check-in start and Check-in,
  4.Check-out and Check-out end,
  5.Workday type
    Given user login to the application
    Given when Admin click on Attendance module
    When user navigates to Timesheet submodule page
    Then user click on add timesheet module
    And the user enters valid data in the Add timesheet
    And the user enter click on confirm button.
    Then user validate the success message

  @TC_Attendance_Timesheet_282  @Attendance_TimeSheet @Sanity @Smoke
  Scenario: Verify whether user is able to add Flexible Timesheet by providing below details:
  1.Number of repetitions,
  2.Day,
  3.Max Work hours,
  4.Workday type
    Given user login to the application
    Given when Admin click on Attendance module
    When user navigates to Timesheet submodule page
    Then user click on add timesheet module
    And the user enters valid data in the Add timesheet and create the flexible timesheet
    And the user enter click on confirm button.
    Then user should validate the timesheet page
    Then user validate the success message

#  @71061 @TC_Attendance_Timesheet_283 @Attendance_TimeSheet  @Quickstart @Sanity @Smoke
#  Scenario: Verify whether user able to view the created timesheet .
#    Given user login to the application
#    Given when Admin click on Attendance module
#    And user click on timesheet module
#    And the user clicks on the View icon for a timesheet
#    Then the user should be able to see the created timesheet details


  @TC_292 @Attendance_TimeSheet @smoke @sanity @Timesheet
    Scenario: Verify whether user able to view the created timesheet
    Given user login to the application
    Given when Admin click on Attendance module
    When user navigates to Timesheet submodule page
    Then User Should view the recently created record

  @TC_293 @Attendance_TimeSheet @smoke @sanity @Timesheet
 Scenario: Verify whether user able to edit the created timesheet
    Given user login to the application
    Given when Admin click on Attendance module
    When user navigates to Timesheet submodule page
    Then User should update the recently created timesheet


  @TC_294 @TC_295  @Attendance_TimeSheet @smoke @sanity @Timesheet
  Scenario: Verify whether user able to delete the created timesheet
  Given user login to the application
    Given when Admin click on Attendance module
    When user navigates to Timesheet submodule page
    Then User should delete the Timesheet Successfully

  @TC_296  @Attendance_TimeSheet @smoke @sanity @Timesheet
    Scenario: Verify whether user is not able to delete the  scheduled timesheet
    Given user login to the application
    Given when Admin click on Attendance module
    When user navigates to Timesheet submodule page
    Then User should cancel the timesheet delete operation


  @TC_297 @TC_298 @Attendance_TimeSheet @smoke @sanity @Timesheet
  Scenario: Verify whether user is able to search the  timesheet from the list
    Given user login to the application
    Given when Admin click on Attendance module
    When user navigates to Timesheet submodule page
    Then User should search by timesheet name

  @TC_299 @Attendance_TimeSheet @smoke @sanity @Timesheet
   Scenario: Verify Normal/Flexible timsheet creation is not successfull without providing the required fields- (Timesheet name)
    Given user login to the application
    Given when Admin click on Attendance module
    When user navigates to Timesheet submodule page
    Then User should not create Timesheet by leaving mandatory field

  @TC_300 @Attendance_TimeSheet @smoke @sanity @Timesheet
  Scenario: Verify Normal timsheet creation is not successful when break-in time is either outside the check-in start and check-out end range or between check in start and check in or check-out and check-out-end
    Given user login to the application
    Given when Admin click on Attendance module
    When user navigates to Timesheet submodule page
    Then User unable to create timesheet if breakTime is Eighter outside the checkIn or Checkout Range


    @TC_301 @TC_302 @TC_303 @Attendance_TimeSheet @smoke @sanity @Timesheet
   Scenario: Verify user is able to navigate to next page by clicking on next button
      Given user login to the application
      Given when Admin click on Attendance module
      When user navigates to Timesheet submodule page
      Then User can navigate to next page by clicking on next page by selecting Ten twenty and fifty

                                              ########################### Shift-schedule ###########################

      @TC_304 @Shift_Schedule @Attendance @smoke @Sanity
      Scenario: Verify whether user can validate the presence of below components
      Add icon
      Delete icon
      Refresh icon
      Search field
      Shift schedule Page label
      Sync Person Icon
      Name column
      Person ID column
      Department column
      Timesheet column
      Start Date column
      End Date column
      Action column
      Next Page navigation icon
      Previous page navigation icon
      Page size dropdown
        Given user login to the application
        Given when Admin click on Attendance module
        When User navigates to Shift schedule sub module
        Then User should validate the presence of all components in Shift shedule page


   @TC_305 @Shift_Schedule @Attendance @smoke @Sanity
  Scenario: Verify whether user will get a warning message by leaving any mandatory field
     Given user login to the application
     Given when Admin click on Attendance module
     When User navigates to Shift schedule sub module
     Then User is trying to add a shift schedule by leaving mandatory fields


  #@TC_306 @Shift_Schedule @Attendance @smoke @Sanity
  #Scenario: Verify user can create shift schedule with valid timesheet and person.
    #Given user login to the application
    #Given when Admin click on Attendance module
    #When User navigates to Shift schedule sub module
    #Then user can create shift schedule with valid timesheet and person

 ####### for this make sure "Do not delete" time sheet must be present in the application ######
    @TC_306 @TC_Shift_Schedule @Sanity @Smoke
    Scenario:Verify user can create shift schedule with valid timesheet and person
    Given user will provide valid username and password
    When user will click on Login button
    Then user will validate dashboard page
    Then user will create one person
    Then i will create create one shift


  @TC_307 @Shift_Schedule @Attendance @smoke @Sanity
  Scenario: Verify whether user cannot add multiple shift for one employee
    Given user will provide valid username and password
    When user will click on Login button
    Then user will validate dashboard page
    Then user will create one person
    Then i will create create one shift
    And i will create create one shift with the same person having existing schedule
 
  @TC_309 @Shift_Schedule @Attendance @smoke @Sanity
  Scenario: Verify whether user will get an error message by clicking on calculate option without selecting the record
    Given user will provide valid username and password
    When user will click on Login button
    Then user will validate dashboard page
    Then i will click on calculate button without selecting schedule
    
      @TC_310 @Shift_Schedule @Attendance @smoke @Sanity
  Scenario: Verify whether user can calculate the employee records by selecting calculate option
    Given user will provide valid username and password
    When user will click on Login button
    Then user will validate dashboard page
     Then user will create one person
    Then i will create create one shift
    And i will select the record and click on calculate
    
       @TC_311 @Shift_Schedule @Attendance @smoke @Sanity
   Scenario:  Verify user can search the records by using  Person name , Person ID and Timesheet 
 Given user will provide valid username and password
    When user will click on Login button
    Then user will validate dashboard page
     Then user will create one person
    Then i will create create one shift
    And i will search shift schedule with Person name , Person ID and Timesheet
    
    
   @TC_315 @Shift_Schedule @Attendance @smoke @Sanity
   Scenario: Verify whether an error message is displayed when the user clicks on the common delete option without selecting any record
 Given user will provide valid username and password
    When user will click on Login button
    Then user will validate dashboard page
    And i will click on delete button without selecting any record
    
     @TC_316 @Shift_Schedule @Attendance @smoke @Sanity
   Scenario: Verify whether user can delete single or multiple shifts by using common delete option
    Given user will provide valid username and password
    When user will click on Login button
    Then user will validate dashboard page
     Then user will create one person
    Then i will create create one shift
    And i will delete shift schedules
    
    @TC_317 @Shift_Schedule @Attendance @smoke @Sanity
   Scenario: Verify whether user can cancel the delete operation by clicking on cancel button
    Given user will provide valid username and password
    When user will click on Login button
    Then user will validate dashboard page
     Then user will create one person
    Then i will create create one shift
    And i will try to delete shift schedule via cancel button
    
      @TC_319 @Shift_Schedule @Attendance @smoke @Sanity
   Scenario: Verify whether user can view the basic settings by clicking on view option.
   Given user will provide valid username and password
    When user will click on Login button
    Then user will validate dashboard page
     Then user will create one person
    Then i will create create one shift
    And i will click on view button for basic setting
   
   
    