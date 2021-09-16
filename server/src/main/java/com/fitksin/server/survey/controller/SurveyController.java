package com.fitksin.server.survey.controller;

import com.fitksin.server.common.domain.Result;
import com.fitksin.server.survey.domain.OptionChoices;
import com.fitksin.server.survey.domain.Questions;
import com.fitksin.server.survey.domain.SurveyHeaders;
import com.fitksin.server.survey.domain.SurveySections;
import com.fitksin.server.survey.service.SurveyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                " \"title\": \"Personalizing\",\n" +
                " \"pages\": [\n" +
                "  {\n" +
                "   \"name\": \"mainSurvey\",\n" +
                "   \"elements\": [\n" +
                "    {\n" +
                "     \"type\": \"boolean\",\n" +
                "     \"name\": \"sex\",\n" +
                "     \"title\": \"성별이 어떻게 되시나요?\",\n" +
                "     \"isRequired\": true,\n" +
                "     \"labelTrue\": \"여성\\n\",\n" +
                "     \"labelFalse\": \"남성\\n\"\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"radiogroup\",\n" +
                "     \"name\": \"question1\",\n" +
                "     \"title\": \"일주일에 화장 빈도가 어떻게 되시나요?\",\n" +
                "     \"isRequired\": true,\n" +
                "     \"choices\": [\n" +
                "      {\n" +
                "       \"value\": \"0\",\n" +
                "       \"text\": \"전혀하지 않음\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"1\",\n" +
                "       \"text\": \"주1회 이하\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"2\",\n" +
                "       \"text\": \"주 2~3회\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"3\",\n" +
                "       \"text\": \"주 4~5회\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"4\",\n" +
                "       \"text\": \"매일\"\n" +
                "      }\n" +
                "     ]\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"text\",\n" +
                "     \"name\": \"age\",\n" +
                "     \"title\": \"나이가 어떻게 되시나요?\",\n" +
                "     \"isRequired\": true,\n" +
                "     \"inputType\": \"number\",\n" +
                "     \"min\": \"0\",\n" +
                "     \"max\": \"150\"\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"boolean\",\n" +
                "     \"name\": \"pregnent\",\n" +
                "     \"visibleIf\": \"{sex} = true\",\n" +
                "     \"title\": \"임신 혹은 임신 이력이 있으신가요?\",\n" +
                "     \"isRequired\": true,\n" +
                "     \"labelTrue\": \"있어요\",\n" +
                "     \"labelFalse\": \"없어요\"\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"boolean\",\n" +
                "     \"name\": \"Symptom_ menstruation\",\n" +
                "     \"visibleIf\": \"{sex} = true\",\n" +
                "     \"title\": \"생리 전 증후군이 있나요?\",\n" +
                "     \"isRequired\": true,\n" +
                "     \"labelTrue\": \"있어요\",\n" +
                "     \"labelFalse\": \"없어요\"\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"boolean\",\n" +
                "     \"name\": \"lactation\",\n" +
                "     \"visibleIf\": \"{sex} = true\",\n" +
                "     \"title\": \"수유증이 있으신가요?\",\n" +
                "     \"isRequired\": true,\n" +
                "     \"labelTrue\": \"있어요\",\n" +
                "     \"labelFalse\": \"없어요\"\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"radiogroup\",\n" +
                "     \"name\": \"skintype\",\n" +
                "     \"title\": \"평소 피부타입이 어떻다고 느끼시나요?\",\n" +
                "     \"isRequired\": true,\n" +
                "     \"choices\": [\n" +
                "      {\n" +
                "       \"value\": \"0\",\n" +
                "       \"text\": \"건성\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"1\",\n" +
                "       \"text\": \"중성\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"2\",\n" +
                "       \"text\": \"지성\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"3\",\n" +
                "       \"text\": \"복합성\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"4\",\n" +
                "       \"text\": \"민감성\"\n" +
                "      }\n" +
                "     ]\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"radiogroup\",\n" +
                "     \"name\": \"outActivity\",\n" +
                "     \"title\": \"하루에 야외활동 정도가 어떻게 되시나요?\",\n" +
                "     \"isRequired\": true,\n" +
                "     \"choices\": [\n" +
                "      {\n" +
                "       \"value\": \"0\",\n" +
                "       \"text\": \"일상생활 대부분\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"1\",\n" +
                "       \"text\": \"3시간 이상\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"2\",\n" +
                "       \"text\": \"2시간 이상\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"3\",\n" +
                "       \"text\": \"1시간 이상\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"4\",\n" +
                "       \"text\": \"1시간 이하\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"5\",\n" +
                "       \"text\": \"거의 없음\"\n" +
                "      }\n" +
                "     ]\n" +
                "    }\n" +
                "   ]\n" +
                "  }\n" +
                " ],\n" +
                " \"showQuestionNumbers\": \"off\",\n" +
                " \"showProgressBar\": \"top\",\n" +
                " \"goNextPageAutomatic\": true,\n" +
                " \"startSurveyText\": \"Next\",\n" +
                " \"requiredText\": \"\",\n" +
                " \"questionsOnPageMode\": \"questionPerPage\",\n" +
                " \"showPreviewBeforeComplete\": \"showAnsweredQuestions\"\n" +
                "}";
        result.setData(jsonData.replaceAll("\\n",""));
        return result;
    }

    @PostMapping("/result")
    public Result getSurveyResult(@RequestBody HashMap<String,Object> result){
        log.info(result.toString());
        return null;
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
        else {
            int headerId = getSurvey.getId();
            List<SurveySections> sections = this.surveyService.getSectionByHeaderId(headerId);
            if(sections!=null){
                for (SurveySections section: sections) {
                    List<Questions> questions = this.surveyService.getQuestions(section.getId());
                    for (Questions question:questions) {
                        List<OptionChoices> optionChoices = this.surveyService.getOptionChoice(question.getId());
                        List<String> choices = new ArrayList<>();
                        for (OptionChoices option: optionChoices) {
                            choices.add(option.getOptionChoiceName());
                        }
                        question.setChoices(choices);
                    }
                    section.setElements(questions);
                }
                getSurvey.setPages(sections);
            }

            result.setData(getSurvey);
        }
        return result;
    }

    @PostMapping("/section")
    public Result createSection(@RequestBody SurveySections surveySections) throws Exception{
        log.info(surveySections.toString());
        Result result = Result.successInstance();
        SurveySections createdSection = this.surveyService.createSection(surveySections);
        return result;
    }

    @GetMapping("/section")
    public Result getSectionByName(@RequestParam(name = "name") String name) throws  Exception{
        log.info("name : " + name);
        Result result = Result.successInstance();
        List<SurveySections> getSection = this.surveyService.getSectionBySectionName(name);
        if(getSection == null) result.fail();
        else result.setData(getSection);
        return result;
    }

    @PostMapping("/question")
    public Result createQuestion(@RequestBody Questions questions){
        log.info(questions.toString());
        Result result = Result.successInstance();
        Questions createdQuestion = this.surveyService.createQuestion(questions);
        if(createdQuestion == null) result.fail();
        return result;
    }

    @PostMapping("/option")
    public Result createOptionChoice(@RequestBody OptionChoices optionChoices){
        log.info(optionChoices.toString());
        Result result = Result.successInstance();
        OptionChoices createdOptionChoice = this.surveyService.createOptionChoices(optionChoices);
        return result;
    }


}
