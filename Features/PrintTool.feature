#Author: Kulkarni, Sagar
Feature: Scenarios for Print Tool

  @Regressiontest
  Scenario Outline: PrintTool - To verify that in Enbridge Landscape Template Layout user is able to print in all the different formats
    Given Application is launched in browser for Print Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Print tool is clicked and tool is opened
    Then In Enbridge Landscape Template Layout user is able to print in all the different formats SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName | RowNumber |
      | PrintTool |         0 |

  @Regressiontest
  Scenario Outline: PrintTool - To verify that in Enbridge Landscape Template Attributes Layout user is able to print in all the different formats
    Given Application is launched in browser for Print Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Print tool is clicked and tool is opened
    Then In Enbridge Landscape Template Attributes Layout user is able to print in all the different formats SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName | RowNumber |
      | PrintTool |         1 |

  @Regressiontest
  Scenario Outline: PrintTool - To verify that in Enbridge Portrait Template Layout user is able to print in all the different formats
    Given Application is launched in browser for Print Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Print tool is clicked and tool is opened
    Then In Enbridge Portrait Template Layout user is able to print in all the different formats SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName | RowNumber |
      | PrintTool |         2 |

  @Regressiontest
  Scenario Outline: PrintTool - To verify that in Enbridge Portrait Template Attributes Layout user is able to print in all the different formats
    Given Application is launched in browser for Print Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Print tool is clicked and tool is opened
    Then In Enbridge Portrait Template Attributes Layout user is able to print in all the different formats SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName | RowNumber |
      | PrintTool |         3 |

  @Regressiontest
  Scenario Outline: PrintTool - To verify that in LP_ClassLocation_Layout_Static_PROD_10.4 Layout user is able to print in all the different formats
    Given Application is launched in browser for Print Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Print tool is clicked and tool is opened
    Then In LP_ClassLocation_Layout_Static_PROD_10.4 Layout user is able to print in all the different formats SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName | RowNumber |
      | PrintTool |         4 |
