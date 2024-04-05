Feature: Login

 Scenario Outline:Login to the application
  Given I navigate to the OrangeHRM login page
  When I enter username as "<username>" and password as "<password>"
  And I click on the login button
  Then I click on Admin tab on the left side menu
  And I get the number of records found
  And I click on add button
  And I fill the required data
  And I click on save button
  Then I verify that the number of records increased by 1
  And I search with the username for the new user
  And I delete the new user
  Then I verify that the number of records decreased by 1
  Then User should be logged in successfully
  Examples:
   | username | password |
   | Admin    | admin123 |

