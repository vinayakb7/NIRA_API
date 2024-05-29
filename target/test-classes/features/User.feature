 @dev
Feature: The user endpoint works as intended
  The user endpoint can handle various 
  Add, Get, Update, Log in, Log out
  Delete requests

 
  Scenario:  login user, logout user 
    When I login
    Then I logout
    When I login with incorrect credentials
  