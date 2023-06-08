@jira
Feature: Logout Functionality
  Background:
    Given The user goes to homepage
    When The user closes pop-up
    When The user logs in

  @B3VIR1-110
    Scenario: Logout button isdisplayed
      Then Verify that the logout button isdisplayed

@B3VIR1-111
    Scenario: Logout process
      When The user clicks logout button
      Then The user sees "You have been logged off your account. It is now safe to leave the computer." and "Your shopping cart has been saved, the items inside it will be restored whenever you log back into your account." message

