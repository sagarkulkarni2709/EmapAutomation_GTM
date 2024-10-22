#Author: Kulkarni, Sagar
Feature: Scenarios for Popup Functions

  @Regressiontest
  Scenario Outline: PopupFunctions - To verify that user should be able to add the marker to the location from the popup option
    Given Application is launched in browser for Popup Functions SheetName "<SheetName>" and rownumber <RowNumber>
    When Popup should be opened
    Then User should be able to add the marker to the location from the popup option

    Examples: 
      | SheetName      | RowNumber |
      | PopupFunctions |         0 |

  @Regressiontest
  Scenario Outline: PopupFunctions - To verify that user should be able to open attribute table from popup window
    Given Application is launched in browser for Popup Functions SheetName "<SheetName>" and rownumber <RowNumber>
    When Popup should be opened
    Then User should be able to open attribute table from popup window

    Examples: 
      | SheetName      | RowNumber |
      | PopupFunctions |         1 |
