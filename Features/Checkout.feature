Feature: Checkout products

  Scenario: Pay by check

    Given User is logged in and added items to the cart

    When User complete payment by check

    Then Invoice is displayed to the user

  Scenario: Pay by bank wire

    Given User is logged in and added items to the cart

    When User complete payment by bank wire

    Then Invoice is displayed to the user
