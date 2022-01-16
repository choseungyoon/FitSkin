# -*- coding: utf-8 -*-
import os
import sys
import urllib.request
import json
import time

client_id = "CjWAXbluwPt2SO63kPfZ"
client_secret = "sE9jCpjy6r"

category = ["식품","건강식품","영양제","기타건강보조식품","콜라겐"]

f = open("product.txt", 'r')
w = open("output.txt", 'a')
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
        json_obj = json.loads(response_body.decode('utf-8'))
        if json_obj['total'] == 0 :
            continue
        if(json_obj['items'][0]["category1"] in category) :
            print(json_obj)
            num = num + 1
            w.write(line.strip() + "," + json_obj['items'][0]["image"]+"\n")
    else:
        print("Error Code:" + rescode)