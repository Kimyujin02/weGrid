package com.kh.wegrid.familyEvent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
@RequestMapping("familyEvent")
public class FamilyEventController {

    @GetMapping("list")
    public void list(){}

    @PostMapping("list")
    @ResponseBody
    public String m01() throws IOException {

        System.out.println("TestController.m01");

        // 노션 API 호출에 필요한 데이터 준비
        String databaseId = "154d5a279fee80c88482d6f734abfa6a";
        String secretKey = "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";
        String notionVersion = "2022-06-28";

        //HTTP 요청 보내고 , 응답받기

        // URL 설정

        URL url = new URL("https://api.notion.com/v1/databases/" + databaseId + "/query");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // method 설정

        connection.setRequestMethod("POST");

        // header 설정

        connection.setRequestProperty("Authorization", secretKey);
        connection.setRequestProperty("Notion-Version", notionVersion);
        connection.setRequestProperty("Content-Type", "application/json");

        // 응답코드 얻기
        int responseCode = connection.getResponseCode();
        System.out.println("responseCode = " + responseCode);

        //데이터 읽기
        StringBuilder response = new StringBuilder();
        InputStream is = connection.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);
        String str;
        while ((str = reader.readLine()) != null) {
            response.append(str.trim());
        }


        System.out.println("response = " + response);
        System.out.println("@@@@@@@@@@@@@@@@@@@@response = " + response.toString());

        return response.toString();

    }
}
