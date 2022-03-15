Feature: Interpret Simple Operations

  Scenario: Multiply 5 by 10
    Given Open the Firefox and launch the application
    And Intepreter page will be displated
    When User chooses Javascript
    And User input and submit 5 * 10 operation
    Then He will see 50
