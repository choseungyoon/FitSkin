package com.fitksin.server.survey.service.Impl;

import com.fitksin.server.analysis.model.TypeScore;
import com.fitksin.server.analysis.service.AnalysisService;
import com.fitksin.server.survey.domain.IndexDto;
import com.fitksin.server.survey.domain.SurveyForm;
import com.fitksin.server.survey.domain.SurveyResult;
import com.fitksin.server.survey.repository.ResultRepository;
import com.fitksin.server.survey.repository.SurveyFormRepository;
import com.fitksin.server.survey.service.SurveyService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class SurveyServiceImpl implements SurveyService {

    private final SurveyFormRepository surveyFormRepository;
    private final ResultRepository resultRepository;
    private final AnalysisService analysisService;

    @Autowired
    public SurveyServiceImpl(
            SurveyFormRepository surveyFormRepository ,
            ResultRepository resultRepository,
            AnalysisService analysisService){
        this.surveyFormRepository = surveyFormRepository;
        this.resultRepository = resultRepository;
        this.analysisService = analysisService;
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
    public UUID insertResult(HashMap<String,Object> result, String email){

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


            // sex
            log.info("Confirm sex");
            if(resultJson.get("sex").toString().equals("true")) {
                sex = true;
                moisturizing += 1;
                sebum += 1;
                sensitivity += 1;
                elasticity += 1;
                pigmentation += 1;
                trouble += 1;
            }

            // age
            log.info("Confirm Age");
            age = Integer.parseInt(resultJson.get("age").toString());
            int age_value = 0;
            if(age >=30 && age <= 35 ) age_value = 1;
            else if(age >=36 && age <= 40) age_value = 2;
            else if(age >=41 && age <= 50) age_value = 3;
            else if(age > 50) age_value = 4;

            moisturizing+=age_value;
            sebum+=age_value;
            sensitivity+=age_value;
            elasticity+=age_value;
            pigmentation+=age_value;
            trouble+=age_value;

            if(sex){
                // pregnant
                log.info("Confirm Pregnant");
                moisturizing+=Integer.parseInt(resultJson.get("pregnant").toString().split("_")[1]);
                sebum+=Integer.parseInt(resultJson.get("pregnant").toString().split("_")[1]);
                sensitivity+=Integer.parseInt(resultJson.get("pregnant").toString().split("_")[1]);
                elasticity+=Integer.parseInt(resultJson.get("pregnant").toString().split("_")[1]);
                pigmentation+=Integer.parseInt(resultJson.get("pregnant").toString().split("_")[1]);
                trouble+=Integer.parseInt(resultJson.get("pregnant").toString().split("_")[1]);

                // Symptom_menstruation
                log.info("Confirm Sysptom_memstruation");
                moisturizing+=Integer.parseInt(resultJson.get("Symptom_menstruation").toString().split("_")[1]);
                sebum+=Integer.parseInt(resultJson.get("Symptom_menstruation").toString().split("_")[1]);
                sensitivity+=Integer.parseInt(resultJson.get("Symptom_menstruation").toString().split("_")[1]);
                elasticity+=Integer.parseInt(resultJson.get("Symptom_menstruation").toString().split("_")[1]);
                pigmentation+=Integer.parseInt(resultJson.get("Symptom_menstruation").toString().split("_")[1]);
                trouble+=Integer.parseInt(resultJson.get("Symptom_menstruation").toString().split("_")[1]);

                // lactation
                log.info("Confirm lactation");
                moisturizing+=Integer.parseInt(resultJson.get("lactation").toString().split("_")[1]);
                sebum+=Integer.parseInt(resultJson.get("lactation").toString().split("_")[1]);
                sensitivity+=Integer.parseInt(resultJson.get("lactation").toString().split("_")[1]);
                elasticity+=Integer.parseInt(resultJson.get("lactation").toString().split("_")[1]);
                pigmentation+=Integer.parseInt(resultJson.get("lactation").toString().split("_")[1]);
                trouble+=Integer.parseInt(resultJson.get("lactation").toString().split("_")[1]);

            }

            // skintype
            log.info("Confirm skintype");
            String valueType = resultJson.get("skintype").toString().split("-")[1];
            for (String val:
                    valueType.split(",")) {
                val = val.trim();
                String index = val.split("_")[0];
                int index_score = Integer.parseInt(val.split("_")[1]);
                switch (index) {
                    case "Moisturizing" :
                        moisturizing+=index_score;
                        break;
                    case "sebum" :
                        sebum+=index_score;
                        break;
                    case "pigmentation" :
                        pigmentation+=index_score;
                        break;
                    case "elasticity" :
                        elasticity+=index_score;
                        break;
                    case "sensitivity" :
                        sensitivity+=index_score;
                        break;
                    case "trouble" :
                        trouble+=index_score;
                        break;
                }
            }

            // outActivity
            log.info("Confirm outActivity");
            valueType = resultJson.get("outActivity").toString().split("-")[1];
            for (String val:
                    valueType.split(",")) {
                val = val.trim();
                String index = val.split("_")[0];
                int index_score = Integer.parseInt(val.split("_")[1]);
                switch (index) {
                    case "Moisturizing" :
                        moisturizing+=index_score;
                        break;
                    case "sebum" :
                        sebum+=index_score;
                        break;
                    case "pigmentation" :
                        pigmentation+=index_score;
                        break;
                    case "elasticity" :
                        elasticity+=index_score;
                        break;
                    case "sensitivity" :
                        sensitivity+=index_score;
                        break;
                    case "trouble" :
                        trouble+=index_score;
                        break;
                }
            }

            // sleep
            log.info("Confirm sleep");
            moisturizing+=Integer.parseInt(resultJson.get("sleep").toString().split("_")[1]);
            sebum+=Integer.parseInt(resultJson.get("sleep").toString().split("_")[1]);
            sensitivity+=Integer.parseInt(resultJson.get("sleep").toString().split("_")[1]);
            elasticity+=Integer.parseInt(resultJson.get("sleep").toString().split("_")[1]);
            pigmentation+=Integer.parseInt(resultJson.get("sleep").toString().split("_")[1]);
            trouble+=Integer.parseInt(resultJson.get("sleep").toString().split("_")[1]);

            // skinAge
            log.info("Confirm look skin age");
            valueType = resultJson.get("skinAge").toString().split("-")[1];
            for (String val:
                    valueType.split(",")) {
                val = val.trim();
                String index = val.split("_")[0];
                int index_score = Integer.parseInt(val.split("_")[1]);
                switch (index) {
                    case "Moisturizing" :
                        moisturizing+=index_score;
                        break;
                    case "sebum" :
                        sebum+=index_score;
                        break;
                    case "pigmentation" :
                        pigmentation+=index_score;
                        break;
                    case "elasticity" :
                        elasticity+=index_score;
                        break;
                    case "sensitivity" :
                        sensitivity+=index_score;
                        break;
                    case "trouble" :
                        trouble+=index_score;
                        break;
                }
            }

            // smoke
            log.info("Confirm smoke");
            moisturizing+=Integer.parseInt(resultJson.get("smoke").toString().split("_")[1]);
            sebum+=Integer.parseInt(resultJson.get("smoke").toString().split("_")[1]);
            sensitivity+=Integer.parseInt(resultJson.get("smoke").toString().split("_")[1]);
            elasticity+=Integer.parseInt(resultJson.get("smoke").toString().split("_")[1]);
            pigmentation+=Integer.parseInt(resultJson.get("smoke").toString().split("_")[1]);
            trouble+=Integer.parseInt(resultJson.get("smoke").toString().split("_")[1]);

            // eatinghabits
            log.info("Confirm habbit of eating");
            var eatinghabits = jsonParser.parse(resultJson.get("eatinghabits").toString());

            for (var row:
                    (JSONArray)eatinghabits) {
                String habitValue = row.toString().split("-")[1];

                for (String habit:
                habitValue.split(",")) {
                    String index = habit.split("_")[0];
                    int index_score = Integer.parseInt(habit.toString().split("_")[1]);
                    switch (index) {
                        case "Moisturizing" :
                            moisturizing+=index_score;
                            break;
                        case "sebum" :
                            sebum+=index_score;
                            break;
                        case "pigmentation" :
                            pigmentation+=index_score;
                            break;
                        case "elasticity" :
                            elasticity+=index_score;
                            break;
                        case "sensitivity" :
                            sensitivity+=index_score;
                            break;
                        case "trouble" :
                            trouble+=index_score;
                            break;
                    }
                }
            }

            // troubleTimes
            log.info("Confirm how many times trouble");
            valueType = resultJson.get("troubleTimes").toString().split("-")[1];
            for (String val:
                    valueType.split(",")) {
                val = val.trim();
                val = val.trim();
                String index = val.split("_")[0];
                int index_score = Integer.parseInt(val.split("_")[1]);
                switch (index) {
                    case "Moisturizing" :
                        moisturizing+=index_score;
                        break;
                    case "sebum" :
                        sebum+=index_score;
                        break;
                    case "pigmentation" :
                        pigmentation+=index_score;
                        break;
                    case "elasticity" :
                        elasticity+=index_score;
                        break;
                    case "sensitivity" :
                        sensitivity+=index_score;
                        break;
                    case "trouble" :
                        trouble+=index_score;
                        break;
                }
            }

            // pigmentation
            log.info("Confirm usaully pigmentation");
            pigmentation+=Integer.parseInt(resultJson.get("pigmentation").toString().split("_")[1]);

            // makeup_times
            log.info("Confirm Makeup times");
            int makeupTimes = Integer.parseInt(resultJson.get("makeup_times").toString().split("-")[1]
                    .split("_")[1]);

            if(makeupTimes > 0){
                // makeup times
                moisturizing+=makeupTimes;
                sebum+=makeupTimes;
                sensitivity+=makeupTimes;
                elasticity+=makeupTimes;
                pigmentation+=makeupTimes;
                trouble+=makeupTimes;

                // makeup_side_effect
                log.info("Confirm Makeup side effect");
                if(!resultJson.get("makeup_side_effect").toString().contains("all")){
                    sebum+=3;
                    trouble+=5;
                }

                // makeupTool
                log.info("Confirm makeup tool");
                var makeupTools = jsonParser.parse(resultJson.get("makeupTool").toString());

                for (var row:
                        (JSONArray)makeupTools) {
                    String toolValue = row.toString().split("-")[1];

                    for (String tool:
                            toolValue.split(",")) {
                        String index = tool.split("_")[0];
                        int index_score = Integer.parseInt(tool.toString().split("_")[1]);
                        switch (index) {
                            case "Moisturizing" :
                                moisturizing+=index_score;
                                break;
                            case "sebum" :
                                sebum+=index_score;
                                break;
                            case "pigmentation" :
                                pigmentation+=index_score;
                                break;
                            case "elasticity" :
                                elasticity+=index_score;
                                break;
                            case "sensitivity" :
                                sensitivity+=index_score;
                                break;
                            case "trouble" :
                                trouble+=index_score;
                                break;
                        }
                    }
                }

                log.info("Confirm how dry");
                valueType = resultJson.get("dry").toString();
                moisturizing+=Integer.parseInt(valueType);

                log.info("Confirm skin worrris");
                // skin_worry
                var skin_worrys = jsonParser.parse(resultJson.get("skin_worry").toString());
                for (var row:
                        (JSONArray)skin_worrys) {
                    String worryValue = row.toString().split("-")[1];

                    for (String worry:
                            worryValue.split(",")) {
                        String index = worry.split("_")[0];
                        int index_score = Integer.parseInt(worry.toString().split("_")[1]);
                        switch (index) {
                            case "Moisturizing" :
                                moisturizing+=index_score;
                                break;
                            case "sebum" :
                                sebum+=index_score;
                                break;
                            case "pigmentation" :
                                pigmentation+=index_score;
                                break;
                            case "elasticity" :
                                elasticity+=index_score;
                                break;
                            case "sensitivity" :
                                sensitivity+=index_score;
                                break;
                            case "trouble" :
                                trouble+=index_score;
                                break;
                        }
                    }
                }
            }

            // look_pore
            log.info("Confirm look pore");
            sebum+=Integer.parseInt(resultJson.get("look_pore").toString().split("_")[1]);

            // look_old
            log.info("Confirm look old");
            if(resultJson.get("look_old").toString().equals("true")){
                moisturizing+=3;
                pigmentation+=3;
            }

            // wrinkle
            log.info("Confirm look wrinkle");
            valueType = resultJson.get("wrinkle").toString();
            elasticity+=Integer.parseInt(valueType);
            
            if(makeupTimes == 1 || makeupTimes == 2) {
                sensitivity *= 1.1;
                trouble *= 1.1;
                pigmentation *=0.9;
            }
            else if(makeupTimes == 3 || makeupTimes == 4){
                sensitivity *= 1.2;
                trouble *= 1.2;
                pigmentation *=0.9;
            }

            String type = this.analysisService.getType(sex,makeupTimes > 1 ? true : false);
            TypeScore typeScore = this.analysisService.getTypeScore(type);

            int my = moisturizing + sebum + sensitivity + elasticity + pigmentation + trouble;
            int standard = typeScore.getMoisturizing() + typeScore.getSebum() + typeScore.getSensitivity() +
                    typeScore.getElasticity() + typeScore.getPigmentation() + typeScore.getTrouble();

            int total = getScore(my, standard);

            moisturizing    = getScore(moisturizing, typeScore.getMoisturizing());
            sebum           = getScore(sebum, typeScore.getSebum());
            sensitivity     = getScore(sensitivity, typeScore.getSensitivity());
            elasticity      = getScore(elasticity, typeScore.getElasticity());
            pigmentation    = getScore(pigmentation, typeScore.getPigmentation());
            trouble         = getScore(trouble, typeScore.getTrouble());

            SurveyResult surveyResult = this.resultRepository.save(
                    new SurveyResult(email,sex,age,total,moisturizing,sebum
                    ,sensitivity,elasticity,pigmentation,trouble));

            return surveyResult.getId();
        }
        catch (Exception ex){
            return null;
        }
    }

    private int getScore(int value , int index){
        return  (int)((((float)index - (float)value) / (float)index) * 100);
    }
    @Override
    public JSONArray selectResult(UUID id){
        try{
            SurveyResult result = this.resultRepository.findById(id).get();

            JSONArray series = new JSONArray();
            JSONObject myResult = new JSONObject();
            myResult.put("name" , "you");
            myResult.put("total",result.getTotal());
            int[] myResult_score = {
                    result.getMoisturizing(),
                    result.getSebum(),
                    result.getSensitivity(),
                    result.getElasticity(),
                    result.getPigmentation(),
                    result.getTrouble()};
            myResult.put("data" , myResult_score);

            series.add(myResult);
            series.add(getSexScore(result.isSex()));
            series.add(getScoreByAGE(result.getAge()/10));
            return series;
        }
        catch (Exception ex){
            return null;
        }
    }

    private JSONObject getSexScore(boolean sex){
        JSONObject sexAvg = new JSONObject();

        IndexDto sexScore = this.resultRepository.selectAverageScoreBySex(sex);

        sexAvg.put("data", new int[] {
                sexScore.getMoisturizing(),
                sexScore.getSebum(),
                sexScore.getSensitivity(),
                sexScore.getElasticity(),
                sexScore.getPigmentation(),
                sexScore.getTrouble()});

        if(sex) sexAvg.put("name","여성 평균");
        else sexAvg.put("name","남성 평균");

        return sexAvg;
    }
    private JSONObject getScoreByAGE(int age){
        JSONObject ageAvg = new JSONObject();

        IndexDto sexScore = this.resultRepository.selectAverageScoreByAge(age*10 , (age+1)*10);

        ageAvg.put("data", new int[] {
                sexScore.getMoisturizing(),
                sexScore.getSebum(),
                sexScore.getSensitivity(),
                sexScore.getElasticity(),
                sexScore.getPigmentation(),
                sexScore.getTrouble()});

        ageAvg.put("name" , age + "0대 평균");

        return ageAvg;
    }


    public JSONArray selectResultAll(String email){

        List<SurveyResult> results = this.resultRepository.findByEmailOrderByCreatedAtAsc(email);
        JSONArray allSurvey = new JSONArray();

        for (SurveyResult result:
             results) {
            JSONObject survey = new JSONObject();
            survey.put("total",result.getTotal());
            survey.put("date",result.getCreatedAt());
            survey.put("moisturizing",result.getMoisturizing());
            survey.put("sebum",result.getSebum());
            survey.put("sensitivity",result.getSensitivity());
            survey.put("elasticity",result.getElasticity());
            survey.put("pigmentation",result.getPigmentation());
            survey.put("trouble",result.getTrouble());
            survey.put("UUID",result.getId());
            allSurvey.add(survey);
        }
        return allSurvey;
    }
}
