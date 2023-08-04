@smoke
Feature: Testing login functionality for BravoCare


  Scenario: Happy Path(Correct username-Correct Password)
    When User provides 'qa_candidate@email.com','qa_password4' and clicks login button
    Then User validates 'https://joomgi.com/login'


  Scenario Outline: Negative Login
    When User provides '<email>','<password>' and clicks login button
    Then User validates the message '<message>'

    Examples:
      | email                  | password     | message                            |
      |                        | qa_password4 | Please enter an email address.     |
      | qa_candidate@email.com |              | Please enter a password.           |
      | qa_candidatemail.com   | qa_password4 | Username must be an email address. |
      | qa_candidate@email.com | qa_PASSWORD4 | Sorry the password isn t right.    |