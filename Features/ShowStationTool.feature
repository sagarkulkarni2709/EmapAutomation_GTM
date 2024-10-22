#Author: Kulkarni, Sagar
Feature: Scenarios for Show Station Tools

  @Regressiontest
  Scenario Outline: ShowStationTool - To verify that user should be able to see the station details using show station tool
    Given Application is launched in browser for Show Station Tools SheetName "<SheetName>" and rownumber <RowNumber>
    When Show Station tool is clicked and tool is opened SheetName "<SheetName>" and rownumber <RowNumber>
    Then User should be able to see the station details using show station tool SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName       | RowNumber |
      | ShowStationTool |         0 |
