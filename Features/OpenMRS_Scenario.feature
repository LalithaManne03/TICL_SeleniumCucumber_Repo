

Feature: OpenMRS_Inpatient_Registration
  	
  Scenario: User should login successfully with valid credential
    Given Launch Login page
    When Enter username and password
    Then User should be in Home Page
    
   
     
  Scenario: Register a patient
    Given Launch Login page
    When Enter username and password
    And User should be in Home Page
    And Clicks on Register a patient
    And Enter Demographics
    And Enter Contactinfo
    And Enter Relationships
    Then Clicks on confirm patient is registered
     
    
    
  Scenario: Update a patient
    Given Launch Login page
    When Enter username and password
    And User should be in Home Page
    And Clicks on Find Patient Record
    And Enter Search by Name
    And Select Search Patient
    And Clicks on Edit option
    And Update Patient name and Save
    Then Clicks on confirm patient record is updated
    
    
     
     