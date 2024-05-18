Feature: Validate search results for 'Best Washing Machine' on Google

  Scenario: Verify Amazon and Flipkart links and their search results
    Given User is on the Google homepage
    When User searches for "Best Washing Machine"
    When Search results are displayed
    When User validates the number of Amazon and Flipkart links
    When User clicks on "<website>" link
    Then Title is displayed
    And Number of results is greater than 0

   
    Examples:
      | website   |
      | Amazon    |
      | Flipkart  |
     