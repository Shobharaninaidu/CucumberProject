@Login
Feature: This feature will be used to login into Simplilearn Website

  Background: 
    Given I have launched the application URL
    And I click on the Login link

	@Sanity
  Scenario: Validate Login success scenario
    When I enter the username
    And I enter the password
    And I click on the login button
    Then I should land on the home page
	
	@Regression
  Scenario: Validate Login Failure scenario using data parameters
    When I enter the username as "Anc@xyz.com"
    And I enter the password as "Anc@1234"
    And I click on the login button
    Then I should get the Error Msg "The email or password you have entered is invalid."

	@WIP
  Scenario Outline: Validate Login Failure scenario using Examples
    When I enter the username as "<UserName>"
    And I enter the password as "<Password>"
    And I click on the login button
    Then I should get the Error Msg "<ErrorMsg>"

    Examples: 
      | UserName    | Password | ErrorMsg                                           |
      | Abc@xyz.com | Abc@1234 | The email or password you have entered is invalid. |
      | Pqr@xyz.com | Pqr@1234 | The email or password you have entered is invalid. |

	@Sanity @Regression
  Scenario: Validate the other login options on the screen
    Then I should see below login options on the screen
      | Google   |
      | Facebook |
      | Linkedin |
      | Apple    |
