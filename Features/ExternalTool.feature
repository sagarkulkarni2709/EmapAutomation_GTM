#Author: Kulkarni, Sagar
Feature: Scenarios for Enhanced Draw Tool

  @Regressiontest
  Scenario Outline: ExternalTool - To verify that user should be able to open schematics page
    Given Application is launched in browser for External Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When External tool is clicked and tool is opened
    Then Verify that user should be able to open schematics page

    Examples: 
      | SheetName        | RowNumber |
      | EnhancedDrawTool |         0 |

  @Regressiontest
  Scenario Outline: ExternalTool - To verify that user should be able to select BU Segment and Pipeline to see the Schematics
    Given Application is launched in browser for External Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When External tool is clicked and tool is opened
    Then Verify that user should be able to select BU Segment and Pipeline to see the Schematics

    Examples: 
      | SheetName        | RowNumber |
      | EnhancedDrawTool |         1 |
