#Author: Kulkarni, Sagar
Feature: Scenarios for Measurement Tool

  @Regressiontest
  Scenario Outline: MeasurementTool - To verify that user should be able to measure distance in Acres unit with measurement tool option Area
    Given Application is launched in browser for Measurement Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Measurement tool is clicked and tool is opened
    Then User should be able to measure distance in Acres unit with measurement tool option Area SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName       | RowNumber |
      | MeasurementTool |         0 |

  @Regressiontest
  Scenario Outline: MeasurementTool - To verify that user should be able to measure distance in Sq Miles unit with measurement tool option Area
    Given Application is launched in browser for Measurement Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Measurement tool is clicked and tool is opened
    Then User should be able to measure distance in Sq Miles unit with measurement tool option Area SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName       | RowNumber |
      | MeasurementTool |         1 |

  @Regressiontest
  Scenario Outline: MeasurementTool - To verify that user should be able to measure distance in Sq Kilometers unit with measurement tool option Area
    Given Application is launched in browser for Measurement Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Measurement tool is clicked and tool is opened
    Then User should be able to measure distance in Sq Kilometers unit with measurement tool option Area SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName       | RowNumber |
      | MeasurementTool |         2 |

  @Regressiontest
  Scenario Outline: MeasurementTool - To verify that user should be able to measure distance in Hectares unit with measurement tool option Area
    Given Application is launched in browser for Measurement Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Measurement tool is clicked and tool is opened
    Then User should be able to measure distance in Hectares unit with measurement tool option Area SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName       | RowNumber |
      | MeasurementTool |         3 |

  @Regressiontest
  Scenario Outline: MeasurementTool - To verify that user should be able to measure distance in Sq Yards unit with measurement tool option Area
    Given Application is launched in browser for Measurement Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Measurement tool is clicked and tool is opened
    Then User should be able to measure distance in Sq Yards unit with measurement tool option Area SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName       | RowNumber |
      | MeasurementTool |         4 |

  @Regressiontest
  Scenario Outline: MeasurementTool - To verify that user should be able to measure distance in Sq Feet unit with measurement tool option Area
    Given Application is launched in browser for Measurement Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Measurement tool is clicked and tool is opened
    Then User should be able to measure distance in Sq Feet unit with measurement tool option Area SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName       | RowNumber |
      | MeasurementTool |         5 |

  @Regressiontest
  Scenario Outline: MeasurementTool - To verify that user should be able to measure distance in Sq Feet (US) unit with measurement tool option Area
    Given Application is launched in browser for Measurement Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Measurement tool is clicked and tool is opened
    Then User should be able to measure distance in Sq Feet US unit with measurement tool option Area SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName       | RowNumber |
      | MeasurementTool |         6 |

  @Regressiontest
  Scenario Outline: MeasurementTool - To verify that user should be able to measure distance in Sq Meters unit with measurement tool option Area
    Given Application is launched in browser for Measurement Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Measurement tool is clicked and tool is opened
    Then User should be able to measure distance in Sq Meters unit with measurement tool option Area SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName       | RowNumber |
      | MeasurementTool |         7 |

  @Regressiontest
  Scenario Outline: MeasurementTool - To verify that user should be able to measure distance in Miles unit with measurement tool option Distance
    Given Application is launched in browser for Measurement Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Measurement tool is clicked and tool is opened
    Then User should be able to measure distance in Miles unit with measurement tool option Distance SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName       | RowNumber |
      | MeasurementTool |         8 |

  @Regressiontest
  Scenario Outline: MeasurementTool - To verify that user should be able to measure distance in Kilometers unit with measurement tool option Distance
    Given Application is launched in browser for Measurement Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Measurement tool is clicked and tool is opened
    Then User should be able to measure distance in Kilometers unit with measurement tool option Distance SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName       | RowNumber |
      | MeasurementTool |         9 |

  @Regressiontest
  Scenario Outline: MeasurementTool - To verify that user should be able to measure distance in Feet unit with measurement tool option Distance
    Given Application is launched in browser for Measurement Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Measurement tool is clicked and tool is opened
    Then User should be able to measure distance in Feet unit with measurement tool option Distance SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName       | RowNumber |
      | MeasurementTool |        10 |

  @Regressiontest
  Scenario Outline: MeasurementTool - To verify that user should be able to measure distance in Feet (US) unit with measurement tool option Distance
    Given Application is launched in browser for Measurement Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Measurement tool is clicked and tool is opened
    Then User should be able to measure distance in Feet US unit with measurement tool option Distance SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName       | RowNumber |
      | MeasurementTool |        11 |

  @Regressiontest
  Scenario Outline: MeasurementTool - To verify that user should be able to measure distance in Meters unit with measurement tool option Distance
    Given Application is launched in browser for Measurement Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Measurement tool is clicked and tool is opened
    Then User should be able to measure distance in Meters unit with measurement tool option Distance SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName       | RowNumber |
      | MeasurementTool |        12 |

  @Regressiontest
  Scenario Outline: MeasurementTool - To verify that user should be able to measure distance in Yards unit with measurement tool option Distance
    Given Application is launched in browser for Measurement Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Measurement tool is clicked and tool is opened
    Then User should be able to measure distance in Yards unit with measurement tool option Distance SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName       | RowNumber |
      | MeasurementTool |        13 |

  @Regressiontest
  Scenario Outline: MeasurementTool - To verify that user should be able to measure distance in Nautical Miles unit with measurement tool option Distance
    Given Application is launched in browser for Measurement Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Measurement tool is clicked and tool is opened
    Then User should be able to measure distance in Nautical Miles unit with measurement tool option Distance SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName       | RowNumber |
      | MeasurementTool |        14 |
      
  @Regressiontest
  Scenario Outline: MeasurementTool - To verify that user should be able to measure distance by creating circle with measurement tool option Distance
    Given Application is launched in browser for Measurement Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Measurement tool is clicked and tool is opened
    Then User should be able to measure distance by creating circle with measurement tool option Distance SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName       | RowNumber |
      | MeasurementTool |        15 |
      
  @Regressiontest
  Scenario Outline: MeasurementTool - To verify that user should be able to plot point and measure lat and long with measurement tool option Location
    Given Application is launched in browser for Measurement Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Measurement tool is clicked and tool is opened
    Then User should be able to plot point and measure lat and long with measurement tool option Location SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName       | RowNumber |
      | MeasurementTool |        16 |
