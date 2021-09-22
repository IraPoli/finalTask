Feature: Smoke
  As a user
  I want to test eBay main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check site main functions
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks footer visibility
    And User checks search field visibility
    And User checks cart visibility
    And User checks register button visibility
    And User checks sign in button visibility
    And User select category button visibility

    Examples:
      | homePage              |
      | https://www.ebay.com/ |



  Scenario Outline: Check eBay navigate to Poland Sites
    Given User opens '<homePage>' page
    And User clicks eBay Sites
    And User clicks Polish Sites
    And User verify URL contains '<sites>'


    Examples:
      | homePage              |sites|
      | https://www.ebay.com/ | pl|




  Scenario Outline: Check add product to Cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User click BuyItNow button
    And User clicks first product
    And User clicks add to Cart button
    Then User checks that amount of products in Cart are '<amountOfProducts>'


    Examples:
      | homePage              | keyword      | amountOfProducts |
      | https://www.ebay.com/ | poc helmet   | 1                |



  Scenario Outline: Check delete product from Cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword1>'
    And User clicks search button
    And User click BuyItNow button
    And User clicks first product
    And User clicks add to Cart button
    Then User checks that amount of products in Cart are '<amountOfProducts1>'
    When User makes search by keyword '<keyword2>'
    And User clicks search button
    And User click BuyItNow button
    And User clicks first product
    And User clicks add to Cart button
    Then User checks that amount of products in Cart are '<amountOfProducts2>'
    And User clicks Cart button
    And User remove first product from basket
    Then User checks that amount of products in Cart are '<amountOfProducts1>'

    Examples:
      | homePage              | keyword1      |  keyword2       | amountOfProducts1 |amountOfProducts2 |
      | https://www.ebay.com/ |  poc helmet   |  head race chin | 1                 |2                 |


  Scenario Outline: Check select product with filter price
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User set high limit price '<maxPrice>'
    And User set minimum price '<minPrice>'
    And User submit price range
    And User checks product '<productAmount>'



    Examples:
      | homePage              | keyword    | minPrice | maxPrice |productAmount |
      | https://www.ebay.com/ | lego robot | 500      | 500      |5             |



  Scenario Outline: Check user select product by Shop category
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User click Shop category button
    And User click Sporting Goods Category button
    And User click Winter Sport Category button
    And User click Ice Skating button
    And User click Lake Placid button
    And User clicks first product
    And User check selected product contains '<CategoryName>'


    Examples:
      | homePage              | CategoryName      |
      | https://www.ebay.com/ | Lake   |

  Scenario Outline: Check Advanced Search main functions
    Given User opens '<homePage>' page
    And User click Advanced Search button
    When User enter '<keyword>' for advanced search
    When User enter extends '<extendsKeyword>' in search
    And User select Travel category
    And User click search button


    Examples:
      | homePage              | keyword      |extendsKeyword|
      | https://www.ebay.com/ | backpack     |laptop |




  Scenario Outline: Check change products amount in basket
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks first product
    And User clicks add to Cart button

    When User set quantity of selected product '<amountOfProducts>'
    Then User checks that amount of products in Cart are '<amountOfProducts>'


    Examples:
      | homePage              | keyword          | amountOfProducts |
      | https://www.ebay.com/ |multi-color pen   | 8             |





  Scenario Outline: Check filter first high product price
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User select filter sort by
    And User select highest First Button
    And User check product selected by first high price




    Examples:
      | homePage              | keyword          |
      | https://www.ebay.com/ |multi-color pen   |






  Scenario Outline: Check user sign in as registered user
    Given User opens '<homePage>' page
    And User click Sign In Button
    And User input '<userName>' into User Name filed
    And User click Continue button
    And User input '<password>' into Password filed
    And User click Sign In

    Examples:
      | homePage              | userName               | password        |

      | https://www.ebay.com/ | nikkapolya@gmail.com   |  &Y-v5,xD#nA68)Q |



