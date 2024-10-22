#Author: Kulkarni, Sagar
Feature: Scenarios for RestAPI

  @Regressiontest
  Scenario Outline: To get the respose time for Regulated Structure polygons
    Given API URL is ready to get the response time SheetName "<SheetName>" and rownumber <RowNumber>
    Then User should be able get respose time for Regulated Structure polygons SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName | RowNumber |
      | RestAPI   |         0 |

  @Regressiontest
  Scenario Outline: To get the respose time for Valve Section with spatial query
    Given API URL is ready to get the response time SheetName "<SheetName>" and rownumber <RowNumber>
    Then User should be able get respose time for Valve Section with spatial query SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName | RowNumber |
      | RestAPI   |         1 |

  @Regressiontest
  Scenario Outline: To get the respose time for MCA PIR
    Given API URL is ready to get the response time SheetName "<SheetName>" and rownumber <RowNumber>
    Then User should be able get respose time for MCA PIR SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName | RowNumber |
      | RestAPI   |         2 |

  @Regressiontest
  Scenario Outline: To get the respose time for Supervisor with spatial query
    Given API URL is ready to get the response time SheetName "<SheetName>" and rownumber <RowNumber>
    Then User should be able get respose time for Supervisor with spatial query SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName | RowNumber |
      | RestAPI   |         3 |
      
  #@Regressiontest
  Scenario Outline: To get the respose time for LP Operating Regions
    Given API URL is ready to get the response time SheetName "<SheetName>" and rownumber <RowNumber>
    Then User should be able get respose time for LP Operating Regions SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName | RowNumber |
      | RestAPI   |         4 |
      
  #@Regressiontest
  Scenario Outline: To get the respose time for LP Valve Section with spatial query
    Given API URL is ready to get the response time SheetName "<SheetName>" and rownumber <RowNumber>
    Then User should be able get respose time for LP Valve Section with spatial query SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName | RowNumber |
      | RestAPI   |         5 |
