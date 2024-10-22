#Author: Kulkarni, Sagar
Feature: Scenarios for Layer List Tool

  @Regressiontest
  Scenario Outline: LayerListTool - To verify that user should be able to select/deselect the layer from layerlist tool and as per the selection/deselction visibility of the layer become ON and OFF on map
    Given Application is launched in browser for Layer List Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Layer list tool is clicked and Layer list tool is opened
    Then User should be able to select and deselect the layer from layerlist tool and as per the selection and deselction visibility of the layer become ON and OFF on map

    Examples: 
      | SheetName     | RowNumber |
      | LayerListTool |         0 |

  @Regressiontest
  Scenario Outline: LayerListTool - To verify that user should be able use the popup menu options like Zoom In and Enable/Diable popup of Layer list tool
    Given Application is launched in browser for Layer List Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Layer list tool is clicked and Layer list tool is opened
    Then User should be able to use the popup menu options like Zoom In and Enable Diable popup of Layer list tool

    Examples: 
      | SheetName     | RowNumber |
      | LayerListTool |         1 |

  @Regressiontest
  Scenario Outline: LayerListTool - To verify that user should be able use the popup menu options like expand and collapsed all layers
    Given Application is launched in browser for Layer List Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Layer list tool is clicked and Layer list tool is opened
    Then User should be able use the popup menu options like expand and collapsed all layers

    Examples: 
      | SheetName     | RowNumber |
      | LayerListTool |         2 |
