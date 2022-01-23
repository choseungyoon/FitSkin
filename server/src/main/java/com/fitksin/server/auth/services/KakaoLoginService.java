package com.fitksin.server.auth.services;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

@Service
public class KakaoLoginService {
    public String getAccessToken(String authorize_code){
        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try{
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("grant_type=authorization_code");
            stringBuilder.append("&client_id=51e8bf8a063e8c574cdb3f45b548ed6a");
            stringBuilder.append("&redirect_uri=http://fitskin.co.kr/signup");
            stringBuilder.append("&code=" + authorize_code);
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();
            System.out.println(stringBuilder.toString());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result= "";

            while((line = bufferedReader.readLine()) != null){
                result += line;
            }

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();
            System.out.println("access_token : " + access_Token);
            bufferedReader.close();
            bufferedWriter.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return access_Token;
    }

    public HashMap<String ,String> getUserInfo(String access_Token){
        HashMap<String,String> userInfo = new HashMap<>();
        String reqURL = "https://kapi.kakao.com/v2/user/me";

        try{
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization","Bearer " + access_Token);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = "";
            String result = "";

            while((line = bufferedReader.readLine()) != null){
                result += line;
            }
            System.out.println("result : " + result);
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

            String id = element.getAsJsonObject().get("id").getAsString();
            String email = null;
            if(kakao_account.getAsJsonObject().get("email") != null){
                email = kakao_account.getAsJsonObject().get("email").getAsString();
                userInfo.put("id",id);
                userInfo.put("email",email);
            }
            if(kakao_account.getAsJsonObject().get("profile").getAsJsonObject().get("nickname").getAsString() != null){
                userInfo.put("username",kakao_account.getAsJsonObject().get("profile").getAsJsonObject().get("nickname").getAsString());
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return userInfo;
    }

}