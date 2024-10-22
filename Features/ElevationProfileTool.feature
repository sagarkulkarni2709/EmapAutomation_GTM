#Author: Kulkarni, Sagar
Feature: Scenarios for Elevation profile Tool

  @Regressiontest
  Scenario Outline: ElevationProfileTool - To verify that user should be able generate elevation profile with measurement unit Miles and also should be able to use profile result option
    Given Application is launched in browser for Elevation profile Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Elevation Profile tool is clicked and tool is opened
    Then User should be able generate elevation profile with measurement unit Miles and also should be able to use profile result option SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName            | RowNumber |
      | ElevationProfileTool |         0 |

  @Regressiontest
  Scenario Outline: ElevationProfileTool - To verify that user should be able generate elevation profile with measurement unit Kilometers and also should be able to use profile result option
    Given Application is launched in browser for Elevation profile Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Elevation Profile tool is clicked and tool is opened
    Then User should be able generate elevation profile with measurement unit Kilometers and also should be able to use profile result option SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName            | RowNumber |
      | ElevationProfileTool |         1 |

  @Regressiontest
  Scenario Outline: ElevationProfileTool - To verify that user should be able generate elevation profile with measurement unit Feet and also should be able to use profile result option
    Given Application is launched in browser for Elevation profile Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Elevation Profile tool is clicked and tool is opened
    Then User should be able generate elevation profile with measurement unit Feet and also should be able to use profile result option SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName            | RowNumber |
      | ElevationProfileTool |         2 |

  @Regressiontest
  Scenario Outline: ElevationProfileTool - To verify that user should be able generate elevation profile with measurement unit Feet US and also should be able to use profile result option
    Given Application is launched in browser for Elevation profile Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Elevation Profile tool is clicked and tool is opened
    Then User should be able generate elevation profile with measurement unit Feet US and also should be able to use profile result option SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName            | RowNumber |
      | ElevationProfileTool |         3 |

  @Regressiontest
  Scenario Outline: ElevationProfileTool - To verify that user should be able generate elevation profile with measurement unit Meters and also should be able to use profile result option
    Given Application is launched in browser for Elevation profile Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Elevation Profile tool is clicked and tool is opened
    Then User should be able generate elevation profile with measurement unit Meters and also should be able to use profile result option SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName            | RowNumber |
      | ElevationProfileTool |         4 |

  @Regressiontest
  Scenario Outline: ElevationProfileTool - To verify that user should be able generate elevation profile with measurement unit Yards and also should be able to use profile result option
    Given Application is launched in browser for Elevation profile Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Elevation Profile tool is clicked and tool is opened
    Then User should be able generate elevation profile with measurement unit Yards and also should be able to use profile result option SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName            | RowNumber |
      | ElevationProfileTool |         5 |

  @Regressiontest
  Scenario Outline: ElevationProfileTool - To verify that user should be able generate elevation profile with measurement unit Nautical Miles and also should be able to use profile result option
    Given Application is launched in browser for Elevation profile Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Elevation Profile tool is clicked and tool is opened
    Then User should be able generate elevation profile with measurement unit Nautical Miles and also should be able to use profile result option SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName            | RowNumber |
      | ElevationProfileTool |         6 |
