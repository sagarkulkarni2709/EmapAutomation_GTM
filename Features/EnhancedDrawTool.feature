#Author: Kulkarni, Sagar
Feature: Scenarios for Enhanced Draw Tool

  @Regressiontest
  Scenario Outline: EnhancedDrawTool - To verify that user should be able to draw point feature on map
    Given Application is launched in browser for Enhanced Draw Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Enhanced Draw tool is clicked and tool is opened
    Then User should be able to draw point feature on map SheetName "<SheetName>" and rownumber <RowNumber>
    And User should be able to edit the drawing details of point SheetName "<SheetName>" and rownumber <RowNumber>
    And User should be able to delete the drawn point shape SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName        | RowNumber |
      | EnhancedDrawTool |         0 |

  @Regressiontest
  Scenario Outline: EnhancedDrawTool - To verify that user should be able to draw line feature on map
    Given Application is launched in browser for Enhanced Draw Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Enhanced Draw tool is clicked and tool is opened
    Then User should be able to draw line feature on map SheetName "<SheetName>" and rownumber <RowNumber>
    And User should be able to edit the drawing details of line SheetName "<SheetName>" and rownumber <RowNumber>
    And User should be able to delete the drawn line shape SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName        | RowNumber |
      | EnhancedDrawTool |         1 |

  @Regressiontest
  Scenario Outline: EnhancedDrawTool - To verify that user should be able to draw polyline feature on map
    Given Application is launched in browser for Enhanced Draw Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Enhanced Draw tool is clicked and tool is opened
    Then User should be able to draw polyline feature on map SheetName "<SheetName>" and rownumber <RowNumber>
    And User should be able to edit the drawing details of polyline SheetName "<SheetName>" and rownumber <RowNumber>
    And User should be able to delete the drawn polyline shape SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName        | RowNumber |
      | EnhancedDrawTool |         2 |

  @Regressiontest
  Scenario Outline: EnhancedDrawTool - To verify that user should be able to draw Freehand polyline feature on map
    Given Application is launched in browser for Enhanced Draw Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Enhanced Draw tool is clicked and tool is opened
    Then User should be able to draw Freehand polyline feature on map SheetName "<SheetName>" and rownumber <RowNumber>
    And User should be able to edit the drawing details of Freehand polyline SheetName "<SheetName>" and rownumber <RowNumber>
    And User should be able to delete the drawn Freehand polyline shape SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName        | RowNumber |
      | EnhancedDrawTool |         3 |

  @Regressiontest
  Scenario Outline: EnhancedDrawTool - To verify that user should be able to draw Triangle feature on map
    Given Application is launched in browser for Enhanced Draw Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Enhanced Draw tool is clicked and tool is opened
    Then User should be able to draw Triangle feature on map SheetName "<SheetName>" and rownumber <RowNumber>
    And User should be able to edit the drawing details of Triangle SheetName "<SheetName>" and rownumber <RowNumber>
    And User should be able to delete the drawn Triangle shape SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName        | RowNumber |
      | EnhancedDrawTool |         4 |

  @Regressiontest
  Scenario Outline: EnhancedDrawTool - To verify that user should be able to draw Extent feature on map
    Given Application is launched in browser for Enhanced Draw Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Enhanced Draw tool is clicked and tool is opened
    Then User should be able to draw Extent feature on map SheetName "<SheetName>" and rownumber <RowNumber>
    And User should be able to edit the drawing details of Extent SheetName "<SheetName>" and rownumber <RowNumber>
    And User should be able to delete the drawn Extent shape SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName        | RowNumber |
      | EnhancedDrawTool |         5 |

  @Regressiontest
  Scenario Outline: EnhancedDrawTool - To verify that user should be able to draw Circle feature on map
    Given Application is launched in browser for Enhanced Draw Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Enhanced Draw tool is clicked and tool is opened
    Then User should be able to draw Circle feature on map SheetName "<SheetName>" and rownumber <RowNumber>
    And User should be able to edit the drawing details of Circle SheetName "<SheetName>" and rownumber <RowNumber>
    And User should be able to delete the drawn Circle shape SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName        | RowNumber |
      | EnhancedDrawTool |         6 |

  @Regressiontest
  Scenario Outline: EnhancedDrawTool - To verify that user should be able to draw Ellipse feature on map
    Given Application is launched in browser for Enhanced Draw Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Enhanced Draw tool is clicked and tool is opened
    Then User should be able to draw Ellipse feature on map SheetName "<SheetName>" and rownumber <RowNumber>
    And User should be able to edit the drawing details of Ellipse SheetName "<SheetName>" and rownumber <RowNumber>
    And User should be able to delete the drawn Ellipse shape SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName        | RowNumber |
      | EnhancedDrawTool |         7 |

  @Regressiontest
  Scenario Outline: EnhancedDrawTool - To verify that user should be able to draw Polygon feature on map
    Given Application is launched in browser for Enhanced Draw Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Enhanced Draw tool is clicked and tool is opened
    Then User should be able to draw Polygon feature on map SheetName "<SheetName>" and rownumber <RowNumber>
    And User should be able to edit the drawing details of Polygon SheetName "<SheetName>" and rownumber <RowNumber>
    And User should be able to delete the drawn Polygon shape SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName        | RowNumber |
      | EnhancedDrawTool |         8 |

  @Regressiontest
  Scenario Outline: EnhancedDrawTool - To verify that user should be able to draw Freehand Polygon feature on map
    Given Application is launched in browser for Enhanced Draw Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Enhanced Draw tool is clicked and tool is opened
    Then User should be able to draw Freehand Polygon feature on map SheetName "<SheetName>" and rownumber <RowNumber>
    And User should be able to edit the drawing details of Freehand Polygon SheetName "<SheetName>" and rownumber <RowNumber>
    And User should be able to delete the drawn Freehand Polygon shape SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName        | RowNumber |
      | EnhancedDrawTool |         9 |

  @Regressiontest
  Scenario Outline: EnhancedDrawTool - To verify that user should be able to draw Text feature on map
    Given Application is launched in browser for Enhanced Draw Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Enhanced Draw tool is clicked and tool is opened
    Then User should be able to draw Text feature on map SheetName "<SheetName>" and rownumber <RowNumber>
    And User should be able to edit the drawing details of Text SheetName "<SheetName>" and rownumber <RowNumber>
    And User should be able to delete the drawn Text shape SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName        | RowNumber |
      | EnhancedDrawTool |        10 |

  #@Regressiontest
  Scenario Outline: EnhancedDrawTool - To verify that user should be able to import and export the drawings
    Given Application is launched in browser for Enhanced Draw Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Enhanced Draw tool is clicked and tool is opened
    Then User should be able to import and export drawings "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName        | RowNumber |
      | EnhancedDrawTool |        11 |
