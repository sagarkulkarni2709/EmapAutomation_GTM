#Author: Kulkarni, Sagar
Feature: Scenarios for Bookmark Tool

  @Regressiontest
  Scenario Outline: To verify that user can add the bookmark
    Given Application is launched in browser for Bookmark Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Bookmark tool is clicked and Bookmark tool is opened SheetName "<SheetName>" and rownumber <RowNumber>
    Then User is able to add the bookmark

    Examples: 
      | SheetName    | RowNumber |
      | BookmarkTool |         0 |

  @Regressiontest
  Scenario Outline: To verify that user can delete the bookmark
    Given Application is launched in browser for Bookmark Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Bookmark tool is clicked and Bookmark tool is opened SheetName "<SheetName>" and rownumber <RowNumber>
    Then User is able to delete the bookmark which is added

    Examples: 
      | SheetName    | RowNumber |
      | BookmarkTool |         1 |

  @Regressiontest
  Scenario Outline: To verify that user can edit the bookmark
    Given Application is launched in browser for Bookmark Tool SheetName "<SheetName>" and rownumber <RowNumber>
    When Bookmark tool is clicked and Bookmark tool is opened SheetName "<SheetName>" and rownumber <RowNumber>
    Then User is able to edit the bookmark which is added

    Examples: 
      | SheetName    | RowNumber |
      | BookmarkTool |         2 |
