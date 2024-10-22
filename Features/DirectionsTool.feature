#Author: Kulkarni, Sagar
Feature: Scenarios for Directions Tool

  @Regressiontest
  Scenario Outline: DirectionsTool - To verify that user should be able to get direction between two locations using Directions tool and also able to get Driving Time
    Given Application is launched in browser for Directions Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Directions tool is clicked and tool is opened
    Then User should be able to get direction between two locations using Directions tool and also able to get Driving Time SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName      | RowNumber |
      | DirectionsTool |         0 |

  @Regressiontest
  Scenario Outline: DirectionsTool - To verify that user should be able to get direction between two locations using Directions tool and also able to get Rural Driving Time
    Given Application is launched in browser for Directions Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Directions tool is clicked and tool is opened
    Then User should be able to get direction between two locations using Directions tool and also able to get Rural Driving Time SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName      | RowNumber |
      | DirectionsTool |         1 |

  @Regressiontest
  Scenario Outline: DirectionsTool - To verify that user should be able to get direction between two locations using Directions tool and also able to get Walking Time
    Given Application is launched in browser for Directions Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Directions tool is clicked and tool is opened
    Then User should be able to get direction between two locations using Directions tool and also able to get Walking Time SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName      | RowNumber |
      | DirectionsTool |         2 |
