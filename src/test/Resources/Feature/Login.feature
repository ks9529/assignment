Feature: Verifying functionality for book store Website

  Background:
    Given I am on the DemoQAbookstore page

  @Test1
  Scenario Outline: Successful registration for new user
    Then I click on the login button
    When I click on the NewUser button
    Then I have entered  <FirstName> , <LastName> , <Username> , <Password>
    And I click on captcha
    Then I click on the register button

    Examples:
      | FirstName | LastName | Username | Password |
      | Michael   | Cassidy  | test70   | Test@123 |


  @Test2
  Scenario Outline: Successful login and logout with valid credentials

    Given I click on the login button
    When I have entered a valid <username> and <password>
    When I click on the login button
    Then I should be logged in successfully
    When I click on logout button
    Then I should be logged out successfully

    Examples:
      | username | password |
      | test61   | Test@123 |


  @Test3
  Scenario Outline: Unsuccessful login with invalid or empty credentials
    When I click on the login button
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see an error message indicating "<error_message>"

    Examples:
      | username | password        | error_message                 |
      | invalid  | invalidPassword | Invalid username or password! |
      | abcccc   | Test@123        | Invalid username or password! |
      | test61   | invalidPassword | Invalid username or password! |

  @Test4
  Scenario Outline: I should be able to add a book to my profile

    Given I click on the login button
    When I have entered a valid <username> and <password>
    When I click on the login button
    Then I should be logged in successfully
    When I have searched for book by <title>
    Then I should be able to add book to my collection
    Then Verify book with <title> is successfully added to profile
    Examples:
      | username | password | title                               |
      | test656  | Test@123 | Learning JavaScript Design Patterns |

  @Test5
  Scenario Outline: I should be able to delete a book from my profile

    Given I click on the login button
    When I have entered a valid <username> and <password>
    When I click on the login button
    Then I should be logged in successfully
    Then I should be able to delete book with <title> from my collection
    Then Verify book with <title> is deleted from profile
    Examples:
      | username | password | title                               |
      | test656  | Test@123 | Learning JavaScript Design Patterns |
  @Test6
  Scenario Outline: I should be able to delete all book from my profile

    Given I click on the login button
    When I have entered a valid <username> and <password>
    When I click on the login button
    Then I should be logged in successfully
    Then I should be able to delete all book from my profile

    Examples:
      | username | password |
      | test656  | Test@123 |

  @Test7
  Scenario Outline: I should be able to use search functionality of book store

    When I have searched for book by <title>
    Then I should get correct <title>,<author>,<publisher>
    When I have searched for book by <author>
    Then I should get correct <title>,<author>,<publisher>


    Examples:
      | title                               | author               | publisher       |
      | Git Pocket Guide                    | Richard E. Silverman | O'Reilly Media  |
      | Learning JavaScript Design Patterns | Addy Osmani          | O'Reilly Media  |
      | Understanding ECMAScript 6          | Nicholas C. Zakas    | No Starch Press |