#Author: Kulkarni, Sagar
Feature: Scenarios for Proximity Tool

  @Regressiontest
  Scenario Outline: ProximityTool - To verify that user should be able to use proximity tool to locate address on map with Meters unit
    Given Application is launched in browser for Proximity Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Proximity tool is clicked and tool is opened
    Then User should be able to use proximity tool to locate address on map with Meters unit SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName     | RowNumber |
      | ProximityTool |         0 |

  #@Regressiontest
  Scenario Outline: ProximityTool - To verify that user should be able to use proximity tool to locate address on map with Kilometers unit
    Given Application is launched in browser for Proximity Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Proximity tool is clicked and tool is opened
    Then User should be able to use proximity tool to locate address on map with Kilometers unit SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName     | RowNumber |
      | ProximityTool |         1 |

  #@Regressiontest
  Scenario Outline: ProximityTool - To verify that user should be able to use proximity tool to locate address on map with Feet unit
    Given Application is launched in browser for Proximity Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Proximity tool is clicked and tool is opened
    Then User should be able to use proximity tool to locate address on map with Feet unit SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName     | RowNumber |
      | ProximityTool |         2 |

  #@Regressiontest
  Scenario Outline: ProximityTool - To verify that user should be able to use proximity tool to locate address on map with Miles unit
    Given Application is launched in browser for Proximity Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Proximity tool is clicked and tool is opened
    Then User should be able to use proximity tool to locate address on map with Miles unit SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName     | RowNumber |
      | ProximityTool |         3 |

  #@Regressiontest
  Scenario Outline: ProximityTool - To verify that user should be able to use proximity tool to locate address on map with option Use Selected
    Given Application is launched in browser for Proximity Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Proximity tool is clicked and tool is opened
    Then User should be able to use proximity tool to locate address on map with option Use Selected SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName     | RowNumber |
      | ProximityTool |         4 |

  #@Regressiontest
  Scenario Outline: ProximityTool - To verify that user should be able to use proximity tool to locate address on map with option Set Location
    Given Application is launched in browser for Proximity Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Proximity tool is clicked and tool is opened
    Then User should be able to use proximity tool to locate address on map with option Set Location SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName     | RowNumber |
      | ProximityTool |         5 |
      
  #@Regressiontest
  Scenario Outline: ProximityTool - To verify that user should be able to use proximity tool to locate address on map after enabling the structure layer from layer list tool
    Given Application is launched in browser for Proximity Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Layer list tool is clicked and Layer list tool is opened for proximity tool scenario
    And Proximity tool is opened
    Then User should be able to use proximity tool to locate address on map after enabling the structure layer from layer list tool SheetName "<SheetName>" and rownumber <RowNumber>
    
    Examples: 
      | SheetName     | RowNumber |
      | ProximityTool |         6 |
