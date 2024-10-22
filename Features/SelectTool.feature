#Author: Kulkarni, Sagar
Feature: Scenarios for Directions Tools

  @Regressiontest
  Scenario Outline: SelectTool - To verify that user should be able to Select reactangle shape and draw on map where features are available to get the details on line
    Given Application is launched in browser for Directions Tools SheetName "<SheetName>" and rownumber <RowNumber>
    When Select tool is clicked and tool is opened
    Then User should be able to Select reactangle shape and draw on map where features are available to get the details on line SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName  | RowNumber |
      | SelectTool |         0 |

  @Regressiontest
  Scenario Outline: SelectTool - To verify that user should be able to Select polygon shape and draw on map where features are available to get the details on line
    Given Application is launched in browser for Directions Tools SheetName "<SheetName>" and rownumber <RowNumber>
    When Select tool is clicked and tool is opened
    Then User should be able to Select polygon shape and draw on map where features are available to get the details on line SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName  | RowNumber |
      | SelectTool |         1 |

  @Regressiontest
  Scenario Outline: SelectTool - To verify that user should be able to Select circle shape and draw on map where features are available to get the details on line
    Given Application is launched in browser for Directions Tools SheetName "<SheetName>" and rownumber <RowNumber>
    When Select tool is clicked and tool is opened
    Then User should be able to Select circle shape and draw on map where features are available to get the details on line SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName  | RowNumber |
      | SelectTool |         2 |

  @Regressiontest
  Scenario Outline: SelectTool - To verify that user should be able to Select zoom to option of layer after selecting shape by reactangle
    Given Application is launched in browser for Directions Tools SheetName "<SheetName>" and rownumber <RowNumber>
    When Select tool is clicked and tool is opened
    Then User should be able to Select zoom to option of layer after selecting shape by reactangle SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName  | RowNumber |
      | SelectTool |         3 |

  @Regressiontest
  Scenario Outline: SelectTool - To verify that user should be able to Export layer data to CSV after selecting shape by reactangle
    Given Application is launched in browser for Directions Tools SheetName "<SheetName>" and rownumber <RowNumber>
    When Select tool is clicked and tool is opened
    Then User should be able to Export layer data to CSV after selecting shape by reactangle SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName  | RowNumber |
      | SelectTool |         4 |

  @Regressiontest
  Scenario Outline: SelectTool - To verify that user should be able to Export layer data to feature collection after selecting shape by reactangle
    Given Application is launched in browser for Directions Tools SheetName "<SheetName>" and rownumber <RowNumber>
    When Select tool is clicked and tool is opened
    Then User should be able to Export layer data to feature collection after selecting shape by reactangle SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName  | RowNumber |
      | SelectTool |         5 |

  @Regressiontest
  Scenario Outline: SelectTool - To verify that user should be Export layer data to GeoJSON after selecting shape by reactangle
    Given Application is launched in browser for Directions Tools SheetName "<SheetName>" and rownumber <RowNumber>
    When Select tool is clicked and tool is opened
    Then User should be Export layer data to GeoJSON after selecting shape by reactangle SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName  | RowNumber |
      | SelectTool |         6 |

  @Regressiontest
  Scenario Outline: SelectTool - To verify that user should be create new layer from layer options after selecting shape by reactangle
    Given Application is launched in browser for Directions Tools SheetName "<SheetName>" and rownumber <RowNumber>
    When Select tool is clicked and tool is opened
    Then User should be create new layer from layer options after selecting shape by reactangle SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName  | RowNumber |
      | SelectTool |         7 |

  @Regressiontest
  Scenario Outline: SelectTool - To verify that user should be save the content of layer after selecting shape by reactangle
    Given Application is launched in browser for Directions Tools SheetName "<SheetName>" and rownumber <RowNumber>
    When Select tool is clicked and tool is opened
    Then User should be save the content of layer after selecting shape by reactangle SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName  | RowNumber |
      | SelectTool |         8 |

  @Regressiontest
  Scenario Outline: SelectTool - To verify that user should be view the layer data in attribute table after selecting shape by reactangle
    Given Application is launched in browser for Directions Tools SheetName "<SheetName>" and rownumber <RowNumber>
    When Select tool is clicked and tool is opened
    Then User should be view the layer data in attribute table after selecting shape by reactangle SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName  | RowNumber |
      | SelectTool |         9 |

  @Regressiontest
  Scenario Outline: SelectTool - To verify that user should be view the statistics of layer data after selecting shape by reactangle
    Given Application is launched in browser for Directions Tools SheetName "<SheetName>" and rownumber <RowNumber>
    When Select tool is clicked and tool is opened
    Then User should be view the statistics of layer data after selecting shape by reactangle SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName  | RowNumber |
      | SelectTool |        10 |

  @Regressiontest
  Scenario Outline: SelectTool - To verify that user should be clear the selection after selecting shape by reactangle
    Given Application is launched in browser for Directions Tools SheetName "<SheetName>" and rownumber <RowNumber>
    When Select tool is clicked and tool is opened
    Then User should be clear the selection after selecting shape by reactangle SheetName "<SheetName>" and rownumber <RowNumber>

    Examples: 
      | SheetName  | RowNumber |
      | SelectTool |        11 |
