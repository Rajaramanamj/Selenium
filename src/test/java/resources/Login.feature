Feature: Application login

Scenario: Home page default login
Given User is on netbanking landing page
When User enters username
When User enters password
Then Verify home page
Then cards are displayed