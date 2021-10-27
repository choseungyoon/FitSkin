# -*- coding: utf-8 -*-
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
import time 
import os
from selenium.webdriver.chrome.options import Options

options = webdriver.ChromeOptions()
options.add_argument("--log-level=3")
options.add_argument('headless')
driver = webdriver.Chrome(executable_path='/Users/seungyuncho/Desktop/chromedriver',chrome_options=options)


driver.implicitly_wait(3)

driver.get('https://www.foodsafetykorea.go.kr/portal/healthyfoodlife/searchHomeHF.do?menu_grp=MENU_NEW01')
driver.implicitly_wait(3)

f = open("/Users/seungyuncho/Desktop/MyProject/FitSkin/crawler/product.txt", 'r')
w = open("/Users/seungyuncho/Desktop/MyProject/FitSkin/crawler/product_detail.txt", 'a')

while True:
    line = f.readline()
    if not line: break
    try:

      time.sleep(1)
      driver.find_element_by_id("search_word").clear()
      driver.find_element_by_id("search_word").send_keys(line)
      time.sleep(1)
      driver.find_element_by_xpath("/html/body/div[2]/form/div/div[1]/main/div[3]/div[1]/div/fieldset/a").click()
      time.sleep(2)
      table = driver.find_element_by_class_name('mobile_table')
      tbody = table.find_element_by_tag_name("tbody")
      rows = tbody.find_elements_by_tag_name("tr")
      num = 0;
      print_line = ""
      for index, value in enumerate(rows):
        body=value.find_elements_by_tag_name("td")[1]
        #print(body.text)
        print_line+= body.text + "\t"
        #w.write(body.text + "\n")
        element = driver.find_element_by_xpath("/html/body/div[2]/form/div/div[1]/main/div[3]/table/tbody/tr[1]")
        time.sleep(2)
        element.click()
        time.sleep(2)
        #print("Main ingredient : ")
        detail_table = driver.find_element_by_xpath('/html/body/div[2]/form/div/div[1]/main/div[3]/article/div[1]/table')
        detail_tbody = detail_table.find_element_by_tag_name("tbody")
        detail_rows = detail_tbody.find_elements_by_tag_name("tr")
        main_ingredient = ""
        for detail_index , detail_value in enumerate(detail_rows):
          try:
            detail_body=detail_value.find_elements_by_tag_name("td")[1]
            main_ingredient += detail_body.text + ","
          except Exception :
            main_ingredient = ""
          #print(detail_body.text)
    
        #print(main_ingredient)
        #w.write(main_ingredient + "\n")
        print_line+= main_ingredient + "\t"

        Etc_ingredient = ""
        detail_table = driver.find_element_by_xpath('/html/body/div[2]/form/div/div[1]/main/div[3]/article/div[2]/table')
        detail_tbody = detail_table.find_element_by_tag_name("tbody")
        detail_rows = detail_tbody.find_elements_by_tag_name("tr")
      
        for detail_index , detail_value in enumerate(detail_rows):
          try:
           detail_body=detail_value.find_elements_by_tag_name("td")[1]
           Etc_ingredient += detail_body.text + ","
          except IndexError:
            Etc_ingredient = ""

          #print(detail_body.text)

        #print(Etc_ingredient)
        #w.write(Etc_ingredient + "\n\n")
        print_line+= Etc_ingredient + "\t"

        print(print_line)
        w.write(print_line + "\n")
        driver.back()
        break;
    except Exception:
      print("No element")
f.close()