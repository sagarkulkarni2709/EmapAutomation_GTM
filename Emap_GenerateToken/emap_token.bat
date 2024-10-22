SET location=D:\Data\AUTOMATION_ETL\SCHEDULE_TASKS\EMAP_UI_Automation-GTM
SET pythonexe=C:\ProgramData\anaconda3\envs\GTMETLP\python.exe

"%pythonexe%" "%location%\Emap_GenerateToken\emap_token.py" 

copy "%location%\Emap_GenerateToken\datafile.properties" %location%
