#Author: Kulkarni, Sagar
Feature: Scenarios for Inline Tool

  @Regressiontest
  Scenario Outline: InlineTool - To verify that user can able to view data loads in inline widget and red x drawn on map after selecting two points on layer
    Given Application is launched in browser for Inline Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Inline tool is clicked and tool is opened SheetName "<SheetName>" and rownumber <RowNumber>
    Then User can able to view data loads in inline widget and red x drawn on map after selecting two points on layer

    Examples: 
      | SheetName  | RowNumber |
      | InlineTool |         0 |
