set projectLocation=D:\Data\AUTOMATION_ETL\SCHEDULE_TASKS\EMAP_UI_Automation-GTM
cd %projectLocation%
D:

mvn test "-Dcucumber.filter.tags= @Regressiontest" > %projectLocation%\EMAP_UI_Automation-GTM.log
