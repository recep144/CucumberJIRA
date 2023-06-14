@addToCart_2
Feature: Add To Cart 2

  Background:
    Given The user goes to homepage
    When The user closes pop-up
    When The user logs in

  @B3VIR1-114
  Scenario: Add products into the shopping cart by using shortcut and check them on the Shopping Cart page
    When The user should be able to select "Networking" category
    Then When the user hovers mouse hover over "ASUS PCE-AC51 - network adapter " product, four small options is presented to the user into the red boxes that is having:
      | Add to Cart          |
      | Add to Wish List     |
      | Compare this Product |
      | Quickview            |
    Then The user should be able to click the Add to Cart icon of the "ASUS PCE-AC51 - network adapter" product
    And A success message appears as: "Success: You have added ASUS PCE-AC51 - network adapter to your shopping cart!"
    When The user should be able to select "Health & Beauty" category
    Then The user should be able to click the Add to Cart icon of the "BaByliss 3663U - Hair rollers " product
    And A success message appears as: "Success: You have added BaByliss 3663U - Hair rollers to your shopping cart!"
    Then The user should be able to click the cirt ıtem that is at the middle-right
    And The user should be able to see  the pruducts added in the Shoping Cart page:
      | ASUS PCE-AC51 - network adapter |
      | BaByliss 3663U - Hair rollers   |
    And The user should be able to click logout Type

  @B3VIR1-115
  Scenario:Add products into the shopping cart by using shortcut and check them on the Base Page
    When The user should be able to select "Health & Beauty" category
    Then The user should be able to click the Add to Cart icon of the "Noerden Minimi Smart Body Scale " product
    When The user should be able to select "Networking" category
    Then The user should be able to click the Add to Cart icon of the "BenQ TDY31 - Network adapter " product
    When The user should be able to select "TV Accessories" category
    Then The user should be able to click the Add to Cart icon of the "Cables Direct audio cable " product
    Then The user should be able to hover the cirt ıtem that is at the middle-right
    And The user should be able to see  the pruducts added on the Base Page:
      | Cables Direct audio cable       |
      | Noerden Minimi Smart Body Scale |
      | BenQ TDY31 - Network adapter    |
    And The user should be able to delete shopping cart and click logout Type

  @B3VIR1-116
  Scenario: Checking the number of added products in the cart icon
    When The user should be able to select "Networking" category
    Then The user should be able to click the Add to Cart icon of the "ASUS PCE-AC51 - network adapter" product
    When The user should be able to select "Health & Beauty" category
    Then The user should be able to click the Add to Cart icon of the "Fitbit Aria Air Smart Bathroom Scale " product
    When The user should be able to select "TV Accessories" category
    Then The user should be able to click the Add to Cart icon of the "Belkin adapter cable " product
    And The number on the basket icon should show the added item number
    And The user should be able to click logout Type

  @B3VIR1-117
  Scenario: Add the same product in the shopping cart
    When The user should be able to hover the cirt ıtem that is at the middle-right
    When The user should be able to delete the previous shopping cart
    When The user should be able to select "Health & Beauty" category
    Then The user should be able to click the Add to Cart icon of the "Fitbit Aria Air Smart Bathroom Scale " product
    When The user should be able to select "Health & Beauty" category
    Then The user should be able to click the Add to Cart icon of the "Fitbit Aria Air Smart Bathroom Scale " product
    When The user should be able to select "Health & Beauty" category
    Then The user should be able to click the Add to Cart icon of the "Fitbit Aria Air Smart Bathroom Scale " product
    Then The user should be able to click the cirt ıtem that is at the middle-right
    And The user should be able to see  the same pruducts added in the Shoping Cart page:
      | Fitbit Aria Air Smart Bathroom Scale |
    And The user should be able to click logout Type





