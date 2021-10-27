Feature: Add products to cart

  Scenario: Add one product to cart

    Given User is logged into the website

    When User select product and press add to cart button

    Then Product is added to the cart
