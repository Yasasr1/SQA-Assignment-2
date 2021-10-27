Feature: Login to the website


  Scenario: Successful login


    Given Open the web browser and launch the website


    When Enter the correct email and password and click login


    Then User logged into the website

  Scenario: Unsuccessful login

    Given Open the web browser and launch the website

    When Enter the incorrect email and password and click login

    Then User loging fails