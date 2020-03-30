# new feature
# Tags: optional


Feature: Forgotten Password

  Background:

  @debug

  Scenario: Successful Reset Password
    Given John is on the forgotten password page
    When John submit password request with "johngo@fsdfs.coy" email
    Then success message "A confirmation email has been sent to your address:" should be displayed