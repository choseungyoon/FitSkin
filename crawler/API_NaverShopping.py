import os
import sys
import urllib.request
import json
import time 

client_id = "CjWAXbluwPt2SO63kPfZ" # 개발자센터에서 발급받은 Client ID 값
client_secret = "sE9jCpjy6r" # 개발자센터에서 발급받은 Client Secret 값

category = ["식품","건강식품","영양제","기타건강보조식품","콜라겐"]

f = open("/Users/seungyuncho/Desktop/MyProject/FitSkin/crawler/product.txt", 'r')
w = open("/Users/seungyuncho/Desktop/MyProject/FitSkin/crawler/naver_api.txt", 'a')
num = 1
while True:
    line = f.readline()
    if not line: break
    value = line.split(sep='\t')
    encText = urllib.parse.quote(value[0])
    url = "https://openapi.naver.com/v1/search/shop?query=" + encText
    request = urllib.request.Request(url)
    request.add_header("X-Naver-Client-Id",client_id)
    request.add_header("X-Naver-Client-Secret",client_secret)
    
    response = urllib.request.urlopen(request)
    rescode = response.getcode()

    if(rescode==200):
        response_body = response.read()
        #print(response_body.decode('utf-8'))
        json_obj = json.loads(response_body.decode('utf-8'))
        if json_obj['total'] == 0 :
            continue
        if(json_obj['items'][0]["category1"] in category) :
            #print(value[0] + "\t" + value[1] + "\t" + value[2] + "\t" + json_obj['items'][0]["link"]+ "\t" + json_obj['items'][0]["image"]) # prints the string with 'source_name' key
            print(json_obj)
            num = num + 1
            w.write(value[0] + "\t" + value[1] + "\t" + value[2] + "\t" + json_obj['items'][0]["link"]+ "\t" + json_obj['items'][0]["image"]+"\n")
    else:
        print("Error Code:" + rescode)