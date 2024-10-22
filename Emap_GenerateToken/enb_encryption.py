import os
from cryptography.fernet import Fernet
import configparser

#Generate a new Key using generate_key() and set system environment variable ENCRYPTION_KEY
code_path = os.path.dirname(os.path.realpath(__file__))

class EnbEncryption:
    def __init__(self):
        self.key = os.environ['ENCRYPTION_KEY']
        self.f = Fernet(self.key)

    def get_config_section(self,section):
        self.parser = configparser.ConfigParser()
        self.parser.optionxform = str
        self.parser.read(code_path + r"\\config.ini")
        dict = {}
        options = self.parser.options(section)
        for option in options:
            try:
                dict[option] = self.parser.get(section, option)
            except:
                dict[option] = None
        return dict

    def decrypt_dict(self, dict):
        for key, val in dict.items():          
            dict[key] = self.decrypt_message(val)
        return dict
    
    def encrypt_dict(self, dict):
        for key, val in dict.items():
            dict[key] = self.encrypt_message(val)
        return dict

    def decrypt_message(self, encrypted_message):
        if not isinstance(encrypted_message, bytes):  
            encrypted_message = bytes(encrypted_message, 'utf-8')
        decrypted_message = self.f.decrypt(encrypted_message)
        return decrypted_message.decode()
        
    def encrypt_message(self, message):
        if not isinstance(message, bytes):  
            message = bytes(message, 'utf-8')
        encrypted_message = self.f.encrypt(message)
        return encrypted_message.decode()
        
    def generate_key(self):
        return Fernet.generate_key().decode()

    def set_key(self,key):
        self.key = key
        self.f = Fernet(key)

# This code excludes if imported in another module
if __name__== "__main__":    
    print(code_path)
    config = EnbEncryption()    
    _dict = config.get_config_section("Token")    
    _dict = config.decrypt_dict(_dict)
    print(_dict)
           # for key, val in _dict.items():
    #    print("{}={}".format(key, val))