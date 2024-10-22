#Author: Kulkarni, Sagar
Feature: Scenarios for Imagery Tool

  @Regressiontest
  Scenario Outline: ImageryTool - To verify that user can select basemap from basemap gallery and as per the selection basemap should be changed
    Given Application is launched in browser for Imagery Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Imagery tool is clicked and tool is opened
    Then User can select basemap from basemap gallery and as per the selection basemap should be changed

    Examples: 
      | SheetName   | RowNumber |
      | ImageryTool |         0 |

  @Regressiontest
  Scenario Outline: ImageryTool - To verify that user can open streetview by setting coordinates on map from streetviewAerial widget
    Given Application is launched in browser for Imagery Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Imagery tool is clicked and tool is opened
    Then User can open streetview by setting coordinates on map from streetviewAerial widget

    Examples: 
      | SheetName   | RowNumber |
      | ImageryTool |         1 |

  @Regressiontest
  Scenario Outline: ImageryTool - To verify that user can open pictometry and can see the pictures in widget by plotting point on map
    Given Application is launched in browser for Imagery Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Imagery tool is clicked and tool is opened
    Then User can open pictometry and can see the pictures in widget by plotting points on map

    Examples: 
      | SheetName   | RowNumber |
      | ImageryTool |         2 |

  @Regressiontest
  Scenario Outline: ImageryTool - To verify that user can open Maxar Imagery tool and can add the layer to map
    Given Application is launched in browser for Imagery Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Imagery tool is clicked and tool is opened
    Then User can open Maxar Imagery tool and can add the layer to map

    Examples: 
      | SheetName   | RowNumber |
      | ImageryTool |         3 |
