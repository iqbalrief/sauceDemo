Feature: This is background demo
  Scenario: Test Menu Items
    Given User access the saucedemo app login
    When User enters valid creds
    And Click on breadcrumd icon
    Then User should be able to see the menu items

    Scenario: Verify add to cart functionality
      Given User access the saucedemo app login
      When User enters valid creds
      And Cliks on Add to boton
      Then Item Should be add to the cart