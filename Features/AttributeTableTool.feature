#Author: Kulkarni, Sagar
Feature: Scenarios for Attribute Table Tool

  @Regressiontest
  Scenario Outline: Attribute Table Tool - To verify that user can apply filters to attribute table and the data is getting popultaed as per the applied filters with Add Expression option
    Given Application is launched in browser for Attribute Table Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Attribute Table tool is clicked and tool is opened
    Then User can apply filters to attribute table and the data is getting popultaed as per the applied filters with Add Expression option SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName          | RowNumber |
      | AttributeTableTool |         0 |

  @Regressiontest
  Scenario Outline: Attribute Table Tool - To verify that user can apply filters to attribute table and the data is getting popultaed as per the applied filters with Add Set option
    Given Application is launched in browser for Attribute Table Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Attribute Table tool is clicked and tool is opened
    Then User can apply filters to attribute table and the data is getting popultaed as per the applied filters with Add Set option SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName          | RowNumber |
      | AttributeTableTool |         1 |

  @Regressiontest
  Scenario Outline: Attribute Table Tool - To verify that user should be able to export the attribute table data to CSV
    Given Application is launched in browser for Attribute Table Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Attribute Table tool is clicked and tool is opened
    Then User should be able to export the attribute table data to CSV SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName          | RowNumber |
      | AttributeTableTool |         2 |
