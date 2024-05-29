@orgsetup
Feature: The user endpoint works as intended
  The user endpoint OrgSetup update

 
  Scenario:  Update OrgSetup form 
    When I login
    And I get organization details
    When I update Orgsetup form 
    And I create designation 
    Then I logout
   
  