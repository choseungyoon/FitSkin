package com.fitksin.server.survey.service.Impl;

import com.fitksin.server.survey.domain.*;
import com.fitksin.server.survey.repository.ResultRepository;
import com.fitksin.server.survey.repository.SurveyFormRepository;
import com.fitksin.server.survey.service.SurveyService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class SurveyServiceImpl implements SurveyService {

    private final SurveyFormRepository surveyFormRepository;
    private final ResultRepository resultRepository;
    @Autowired
    public SurveyServiceImpl(SurveyFormRepository surveyFormRepository , ResultRepository resultRepository){
        this.surveyFormRepository = surveyFormRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public boolean insertSurvey(SurveyForm surveyForm){
        try{
            this.surveyFormRepository.save(surveyForm);
        }
        catch (Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public UUID insertResult(HashMap<String,Object> result){

        try{
            boolean sex = Boolean.parseBoolean(null);
            int age = 0;
            int moisturizing = 0;
            int sebum = 0;
            int sensitivity = 0;
            int elasticity = 0;
            int pigmentation = 0;
            int trouble = 0;

            var t = result.get("result");
            //2. Parser
            JSONParser jsonParser = new JSONParser();
            //3. To Object
            JSONObject resultJson = (JSONObject)jsonParser.parse(result.get("result").toString());

            if(resultJson.get("sex").toString().contains("all")){
                sex = true;
                moisturizing+=Integer.parseInt(resultJson.get("sex").toString().split("_")[1]);
                sebum+=Integer.parseInt(resultJson.get("sex").toString().split("_")[1]);
                sensitivity+=Integer.parseInt(resultJson.get("sex").toString().split("_")[1]);
                elasticity+=Integer.parseInt(resultJson.get("sex").toString().split("_")[1]);
                pigmentation+=Integer.parseInt(resultJson.get("sex").toString().split("_")[1]);
                trouble+=Integer.parseInt(resultJson.get("sex").toString().split("_")[1]);
            }

            if(resultJson.get("makeup_times").toString().contains("all")){
                sex = true;
                moisturizing+=Integer.parseInt(resultJson.get("sex").toString().split("_")[1]);
                sebum+=Integer.parseInt(resultJson.get("sex").toString().split("_")[1]);
                sensitivity+=Integer.parseInt(resultJson.get("sex").toString().split("_")[1]);
                elasticity+=Integer.parseInt(resultJson.get("sex").toString().split("_")[1]);
                pigmentation+=Integer.parseInt(resultJson.get("sex").toString().split("_")[1]);
                trouble+=Integer.parseInt(resultJson.get("sex").toString().split("_")[1]);
            }
            age = Integer.parseInt(resultJson.get("age").toString());

            SurveyResult surveyResult = this.resultRepository.save( new SurveyResult(null,sex,age,moisturizing,sebum
                    ,sensitivity,elasticity,pigmentation,trouble));

            return surveyResult.getId();
        }
        catch (Exception ex){
            return null;
        }
    }
}
