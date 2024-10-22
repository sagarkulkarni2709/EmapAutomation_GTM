import os
import requests
import enb_encryption as enbEn

class emap_token:
 
    def __init__(self, env):
        config = enbEn.EnbEncryption()
        _dict = config.get_config_section(env)   
        self.username = _dict["USERNAME"]
        self.password = config.decrypt_message(_dict["PASSWORD"])
        self.base_url = _dict["BASE_URL"]
        self.url = _dict["URL"]
        self.code_path = os.path.dirname(os.path.realpath(__file__))    #Path to directory of this file
        self.AppURL = _dict["APP_URL"]
    
    def generatePortalToken(self):
        parameters = {'username' : self.username, 'password' : self.password, 'client' : 'referer', 'referer': self.base_url, 'expiration': 20160, 'f' : 'json'}
        response = requests.post(self.url, data=parameters)
        #print(response.json())

        jsonResponse = response.json()
        if 'token' in jsonResponse:
            self.token = jsonResponse['token']
        else:
            self.token = ""

    def generateFile(self):

        # do not generate file if token is empty. Previous token file will work for 2 weeks
        if self.token == "":
            return

        file_name = os.path.join(self.code_path, 'datafile.properties')
        with open(file_name, "w") as file:
            file.write("BrowserType = CHROME\n")
            file.write("HeadlessMode = True\n")                      
            file.write("AppURL = {}/?token={}\n".format(self.AppURL,self.token))
            file.write("driverPath = ./Drivers/\n")
            file.write("tesData = ./TestData/EmapTestData.xlsx\n")
            file.write("testReport = ./TestReport\n")
            file.write(f"screenShotFolderPath = \Screenshots\\")
        

if __name__== "__main__":   
    test = emap_token("EMAP_PROD")
    test.generatePortalToken()
    test.generateFile()

    
