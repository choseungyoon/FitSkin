package com.fitksin.server.survey.controller;

import com.fitksin.server.common.domain.Result;
import com.fitksin.server.survey.domain.SurveyHeaders;
import com.fitksin.server.survey.service.SurveyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/survey")
public class SurveyController {

    private final SurveyService surveyService;

    @Autowired
    public SurveyController (SurveyService surveyService){
        this.surveyService = surveyService;
    }

    @GetMapping("/form")
    public Result getSurveyForm(){
        log.info("getSurveyForm");
        Result result = Result.successInstance();
        String jsonData = "{\n" +
                "\"title\": \"Skin Type Survey\",\n" +
                "\"description\": \"나만의 피부 Type을 확인하면 맞춤 Solution을 받을 수 있어요\",\n" +
                " \"pages\": [\n" +
                "  {\n" +
                "   \"name\": \"page1\",\n" +
                "   \"elements\": [\n" +
                "    {\n" +
                "     \"type\": \"radiogroup\",\n" +
                "     \"name\": \"sex\",\n" +
                "     \"title\": \"성별이 어떻게 되시나요?\",\n" +
                "     \"isRequired\": true,\n" +
                "     \"choices\": [\n" +
                "      \"남성\",\n" +
                "      \"여성\"\n" +
                "     ],\n" +
                "     \"colCount\": 0\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"radiogroup\",\n" +
                "     \"name\": \"makeup\",\n" +
                "     \"title\": \"화장을 하시나요?\",\n" +
                "     \"isRequired\": true,\n" +
                "     \"choices\": [\n" +
                "       \"Yes\", \"No\"\n" +
                "     ]\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"radiogroup\",\n" +
                "     \"name\": \"product_discovering\",\n" +
                "     \"title\": \"1주일에 몇번 정도 화장 하시나요? \",\n" +
                "     \"isRequired\": true,\n" +
                "     \"visibleIf\": \"{makeup}='Yes'\",\n" +
                "     \"choices\": [\n" +
                "        {\n" +
                "            \"value\" : 1,\n" +
                "            \"text\" : \"1회 이하\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\" : 2,\n" +
                "            \"text\" : \"2~3회\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\" : 3,\n" +
                "            \"text\" : \"4~5회\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"value\" : 4,\n" +
                "            \"text\" : \"매일\"\n" +
                "        }\n" +
                "     ]\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"radiogroup\",\n" +
                "     \"name\": \"age\",\n" +
                "     \"title\": \"나이가 어떻게 되시나요?\",\n" +
                "     \"isRequired\": true,\n" +
                "     \"choices\": [\n" +
                "      \"20대 이하\",\n" +
                "      \"30~35세\",\n" +
                "      \"36~40세\",\n" +
                "      \"41~50세\",\n" +
                "      \"50대 이상\"\n" +
                "     ]\n" +
                "    }\n" +
                "   ]\n" +
                "  }\n" +
                " ]\n" +
                "}\n";
        result.setData(jsonData.replaceAll("\\n",""));
        return result;
    }

    @PostMapping("/header")
    public Result createSurvey(@RequestBody SurveyHeaders surveyHeaders) throws Exception{
        log.info(surveyHeaders.toString());
        Result result = Result.successInstance();
        SurveyHeaders createdSurvey = this.surveyService.createSurvey(surveyHeaders);
        return result;
    }

    @GetMapping("/header")
    public Result getSurvey(@RequestParam int surveyId) throws Exception{
        Result result = Result.successInstance();
        SurveyHeaders getSurvey = this.surveyService.getSurvey(surveyId);
        if(getSurvey==null) result.fail();
        else result.setData(getSurvey);
        return result;
    }

}
