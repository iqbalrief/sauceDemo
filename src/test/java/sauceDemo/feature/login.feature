Feature: Login Page sauce

  @Regression @Positive
  Scenario: Succes Login
    Given hangman login sauce
    When Input username
    And Input password
    And Click login button
    Then Use in on dashboard page

    @Regression @Negative
    Scenario: Failed login
      Given hangman login sauce
      When Input Invalid username
      And Input Invalid Password
      And Click login button
      Then User get error message