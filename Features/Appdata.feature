#Author: Kulkarni, Sagar
Feature: Scenarios for Appdata Tool

  @Regressiontest
  Scenario Outline: Appdata Tool - To verify that user should be able to add data from a web URL in Appdata tool
    Given Application is launched in browser for Appdata Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Appdata tool is clicked and tool is opened
    Then User should be able to add data from a web URL in Appdata tool SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName   | RowNumber |
      | AppdataTool |         0 |

  @Regressiontest
  Scenario Outline: Appdata Tool - To verify that user should be able to add data using serach section in Appdata tool
    Given Application is launched in browser for Appdata Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Appdata tool is clicked and tool is opened
    Then User should be able to add data using serach section in Appdata tool SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName   | RowNumber |
      | AppdataTool |         1 |
