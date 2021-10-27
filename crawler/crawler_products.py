from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
import time 
import os

driver = webdriver.Chrome('/Users/seungyuncho/Desktop/chromedriver')
driver.implicitly_wait(3)

driver.get('https://www.foodsafetykorea.go.kr/portal/healthyfoodlife/searchHomeHF.do?menu_grp=MENU_NEW01')
driver.implicitly_wait(3)

f = open("/Users/seungyuncho/Desktop/MyProject/FitSkin/crawler/product.txt", 'w')

num = -1
page = 1
while num != 1 :
  time.sleep(5)
  table = driver.find_element_by_class_name('mobile_table')
  tbody = table.find_element_by_tag_name("tbody")
  rows = tbody.find_elements_by_tag_name("tr")

  #print("page : " , page);
  for index, value in enumerate(rows):
    # num = value.find_elements_by_tag_name("td")[0]
    body=value.find_elements_by_tag_name("td")[1]
    print(body.text)
    f.write(body.text + "\n")

  driver.find_element_by_xpath("/html/body/div[2]/form/div/div[1]/main/div[3]/div[2]/div/ul/li[7]/a").send_keys(Keys.ENTER)

f.close()






