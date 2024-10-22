#Author: Kulkarni, Sagar
Feature: Scenarios for Locator Tool

  @Regressiontest
  Scenario Outline: LocatorTool - To verify that user should be able to use Segment Route serach option to locate an asset, location on the pipeline, or Compliance feature
    Given Application is launched in browser for Locator Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Locator tool is clicked and tool is opened
    Then User should be able to use Segment Route serach option to locate an asset, location on the pipeline, or Compliance feature SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName   | RowNumber |
      | LocatorTool |         0 |
      
  @Regressiontest
  Scenario Outline: LocatorTool - To verify that user should be able to use Valve Section serach option to locate an asset, location on the pipeline, or Compliance feature
    Given Application is launched in browser for Locator Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Locator tool is clicked and tool is opened
    Then User should be able to use Valve Section serach option to locate an asset, location on the pipeline, or Compliance feature SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName   | RowNumber |
      | LocatorTool |         1 |
      
  @Regressiontest
  Scenario Outline: LocatorTool - To verify that user should be able to use Station Site serach option to locate an asset, location on the pipeline, or Compliance feature
    Given Application is launched in browser for Locator Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Locator tool is clicked and tool is opened
    Then User should be able to use Station Site serach option to locate an asset, location on the pipeline, or Compliance feature SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName   | RowNumber |
      | LocatorTool |         2 |
      
  @Regressiontest
  Scenario Outline: LocatorTool - To verify that user should be able to use Meter Station serach option to locate an asset, location on the pipeline, or Compliance feature
    Given Application is launched in browser for Locator Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Locator tool is clicked and tool is opened
    Then User should be able to use Meter Station serach option to locate an asset, location on the pipeline, or Compliance feature SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName   | RowNumber |
      | LocatorTool |         3 |
      
  @Regressiontest
  Scenario Outline: LocatorTool - To verify that user should be able to use Valve Site serach option to locate an asset, location on the pipeline, or Compliance feature
    Given Application is launched in browser for Locator Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Locator tool is clicked and tool is opened
    Then User should be able to use Valve Site serach option to locate an asset, location on the pipeline, or Compliance feature SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName   | RowNumber |
      | LocatorTool |         4 |
      
  @Regressiontest
  Scenario Outline: LocatorTool - To verify that user should be able to use Valve serach option to locate an asset, location on the pipeline, or Compliance feature
    Given Application is launched in browser for Locator Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Locator tool is clicked and tool is opened
    Then User should be able to use Valve serach option to locate an asset, location on the pipeline, or Compliance feature SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName   | RowNumber |
      | LocatorTool |         5 |
      
  @Regressiontest
  Scenario Outline: LocatorTool - To verify that user should be able to use HCA serach option to locate an asset, location on the pipeline, or Compliance feature
    Given Application is launched in browser for Locator Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Locator tool is clicked and tool is opened
    Then User should be able to use HCA serach option to locate an asset, location on the pipeline, or Compliance feature SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName   | RowNumber |
      | LocatorTool |         6 |
      
