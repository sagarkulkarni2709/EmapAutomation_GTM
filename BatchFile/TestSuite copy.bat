set projectLocation=D:\Data\AUTOMATION_ETL\SCHEDULE_TASKS\EMAP_UI_Automation-GTM
cd %projectLocation%
D:

net use k: "\\usops\operations\FME_Processes\FME_InputOutput\Test\EMapUIAutomationRegressionTestReport\TestFiles" /user:AASH-POPTAUS-GISApA1
:: copy /Y "\\usops\operations\FME_Processes\FME_InputOutput\Test\EMapUIAutomationRegressionTestReport\TestFiles\datafile.properties" %projectLocation%
copy /Y K:\datafile.properties %projectLocation%
:: net use k: /delete
:: mvn test "-Dcucumber.filter.tags= @Regressiontest" > %projectLocation%\EMAP_UI_Automation-GTM.log
