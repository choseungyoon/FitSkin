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
                " \"title\": \"Skin Type Survey\",\n" +
                " \"description\": \"나만의 피부 Type을 확인하면 맞춤 Solution을 받을 수 있어요\",\n" +
                " \"pages\": [\n" +
                "  {\n" +
                "   \"name\": \"common\",\n" +
                "   \"elements\": [\n" +
                "    {\n" +
                "     \"type\": \"radiogroup\",\n" +
                "     \"name\": \"sex\",\n" +
                "     \"title\": \"성별이 어떻게 되시나요?\",\n" +
                "     \"choices\": [\n" +
                "      {\n" +
                "       \"value\": \"item1\",\n" +
                "       \"text\": \"남성\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item2\",\n" +
                "       \"text\": \"여성\"\n" +
                "      }\n" +
                "     ]\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"radiogroup\",\n" +
                "     \"name\": \"makeupTimes\",\n" +
                "     \"title\": \"1주일에 화장 빈도가 어떻게 되시나요?\",\n" +
                "     \"choices\": [\n" +
                "      {\n" +
                "       \"value\": \"item1\",\n" +
                "       \"text\": \"전혀 하지 않음\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item2\",\n" +
                "       \"text\": \"주 1회 이하\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item3\",\n" +
                "       \"text\": \"주 2~3회\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item4\",\n" +
                "       \"text\": \"주 4~5회\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item5\",\n" +
                "       \"text\": \"매일\"\n" +
                "      }\n" +
                "     ]\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"radiogroup\",\n" +
                "     \"name\": \"age\",\n" +
                "     \"title\": \"나이를 입력해주세요\",\n" +
                "     \"choices\": [\n" +
                "      {\n" +
                "       \"value\": \"item1\",\n" +
                "       \"text\": \"20대 이하\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item2\",\n" +
                "       \"text\": \"30~35세\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item3\",\n" +
                "       \"text\": \"36~40세\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item4\",\n" +
                "       \"text\": \"41~45세\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item5\",\n" +
                "       \"text\": \"51세 이상\"\n" +
                "      }\n" +
                "     ]\n" +
                "    }\n" +
                "   ],\n" +
                "   \"navigationButtonsVisibility\": \"show\"\n" +
                "  },\n" +
                "  {\n" +
                "   \"name\": \"common_lifestyle\",\n" +
                "   \"elements\": [\n" +
                "    {\n" +
                "     \"type\": \"radiogroup\",\n" +
                "     \"name\": \"skinType\",\n" +
                "     \"title\": \"평소 피부 타입이 어떻게 되시나요?\",\n" +
                "     \"isRequired\": true,\n" +
                "     \"hasComment\": true,\n" +
                "     \"choices\": [\n" +
                "      {\n" +
                "       \"value\": \"item1\",\n" +
                "       \"text\": \"건성\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item2\",\n" +
                "       \"text\": \"중성\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item3\",\n" +
                "       \"text\": \"지성\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item4\",\n" +
                "       \"text\": \"복합성\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item5\",\n" +
                "       \"text\": \"민감성\"\n" +
                "      }\n" +
                "     ]\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"radiogroup\",\n" +
                "     \"name\": \"question2\",\n" +
                "     \"title\": \"하루에 야외활동 빈도가 어떻게 되시나요?\",\n" +
                "     \"isRequired\": true,\n" +
                "     \"choices\": [\n" +
                "      {\n" +
                "       \"value\": \"item1\",\n" +
                "       \"text\": \"일상생활 대부분\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item2\",\n" +
                "       \"text\": \"3시간 이상\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item3\",\n" +
                "       \"text\": \"2시간 이상\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item4\",\n" +
                "       \"text\": \"1시간 이상\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item5\",\n" +
                "       \"text\": \"거의 없음\"\n" +
                "      }\n" +
                "     ]\n" +
                "    }\n" +
                "   ]\n" +
                "  },\n" +
                "  {\n" +
                "   \"name\": \"Female\",\n" +
                "   \"elements\": [\n" +
                "    {\n" +
                "     \"type\": \"boolean\",\n" +
                "     \"name\": \"question1\",\n" +
                "     \"title\": \"임신 혹은 이력이 있으신가요?\"\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"boolean\",\n" +
                "     \"name\": \"question3\",\n" +
                "     \"title\": \"생리전 증후군이 있으신가요?\"\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"boolean\",\n" +
                "     \"name\": \"question4\",\n" +
                "     \"title\": \"수유증이 있으신가요?\"\n" +
                "    }\n" +
                "   ],\n" +
                "   \"enableIf\": \"{sex} = 'item2'\"\n" +
                "  },\n" +
                "  {\n" +
                "   \"name\": \"makeup\",\n" +
                "   \"elements\": [\n" +
                "    {\n" +
                "     \"type\": \"checkbox\",\n" +
                "     \"name\": \"question5\",\n" +
                "     \"title\": \"피부화장을 한다면 어떤 것을 사용하나요?(중복)\",\n" +
                "     \"choices\": [\n" +
                "      {\n" +
                "       \"value\": \"item1\",\n" +
                "       \"text\": \"선크림\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item2\",\n" +
                "       \"text\": \"베이스\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item3\",\n" +
                "       \"text\": \"파운데이션\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item4\",\n" +
                "       \"text\": \"비비크림\"\n" +
                "      }\n" +
                "     ]\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"boolean\",\n" +
                "     \"name\": \"question6\",\n" +
                "     \"title\": \"클렌저, 보습제, 색조화장품, 기타 다른 화장품이 얼굴피부를 돋아 오르게 하거나 발진, 가려움증 혹은 따끔거리는 증상 등을 유발했던 경험이 있습니까?\"\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"checkbox\",\n" +
                "     \"name\": \"question7\",\n" +
                "     \"title\": \"건조한 환경에서 크림이나 미스트를 사용하지 않았을 때 고객님의 얼굴 상태는 어떻습니까?\",\n" +
                "     \"choices\": [\n" +
                "      {\n" +
                "       \"value\": \"item1\",\n" +
                "       \"text\": \"각질\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item2\",\n" +
                "       \"text\": \"탄력\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item3\",\n" +
                "       \"text\": \"주름\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item4\",\n" +
                "       \"text\": \"모공\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item5\",\n" +
                "       \"text\": \"건조함\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item6\",\n" +
                "       \"text\": \"잦은 트러블\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item7\",\n" +
                "       \"text\": \"여드름\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"item8\",\n" +
                "       \"text\": \"입술 갈라짐\"\n" +
                "      }\n" +
                "     ]\n" +
                "    }\n" +
                "   ]\n" +
                "  },\n" +
                "  {\n" +
                "   \"name\": \"receivedMail\",\n" +
                "   \"elements\": [\n" +
                "    {\n" +
                "     \"type\": \"comment\",\n" +
                "     \"name\": \"question8\",\n" +
                "     \"title\": \"분석 결과를 이메일로 받아보고 싶으시면 메일 주소를 아래 입력해주세요\"\n" +
                "    }\n" +
                "   ]\n" +
                "  }\n" +
                " ],\n" +
                " \"showProgressBar\": \"top\",\n" +
                " \"goNextPageAutomatic\": true,\n" +
                " \"firstPageIsStarted\": true\n" +
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
