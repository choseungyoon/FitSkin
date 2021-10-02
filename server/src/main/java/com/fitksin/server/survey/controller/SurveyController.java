package com.fitksin.server.survey.controller;

import com.fitksin.server.auth.security.jwt.JwtUtils;
import com.fitksin.server.common.domain.Result;
import com.fitksin.server.survey.domain.*;
import com.fitksin.server.survey.service.SurveyService;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/survey")
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
                "     \"correctAnswer\": true,\n" +
                "     \"isRequired\": true,\n" +
                "     \"labelTrue\": \"여성\\n\",\n" +
                "     \"labelFalse\": \"남성\\n\"" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"radiogroup\",\n" +
                "     \"name\": \"makeup_times\",\n" +
                "     \"title\": \"일주일에 화장 빈도가 어떻게 되시나요?\",\n" +
                "     \"isRequired\": true,\n" +
                "     \"choices\": [\n" +
                "      {\n" +
                "       \"value\": \"1-all_0\",\n" +
                "       \"text\": \"전혀하지 않음\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"2-all_1\",\n" +
                "       \"text\": \"주1회 이하\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"3-all_2\",\n" +
                "       \"text\": \"주 2~3회\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"4-all_3\",\n" +
                "       \"text\": \"주 4~5회\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"5-all_4\",\n" +
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
                "     \"name\": \"pregnant\",\n" +
                "     \"visibleIf\": \"{sex} = true\",\n" +
                "     \"title\": \"임신 혹은 임신 이력이 있으신가요?\",\n" +
                "     \"correctAnswer\": true,\n" +
                "     \"isRequired\": true,\n" +
                "     \"labelTrue\": \"있어요\",\n" +
                "     \"labelFalse\": \"없어요\",\n" +
                "     \"valueTrue\": \"all_3\",\n" +
                "     \"valueFalse\": \"all_0\"\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"boolean\",\n" +
                "     \"name\": \"Symptom_menstruation\",\n" +
                "     \"visibleIf\": \"{sex} = true\",\n" +
                "     \"title\": \"생리 전 증후군이 있나요?\",\n" +
                "     \"correctAnswer\": true,\n" +
                "     \"isRequired\": true,\n" +
                "     \"labelTrue\": \"있어요\",\n" +
                "     \"labelFalse\": \"없어요\",\n" +
                "     \"valueTrue\": \"all_2\",\n" +
                "     \"valueFalse\": \"all_0\"\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"boolean\",\n" +
                "     \"name\": \"lactation\",\n" +
                "     \"visibleIf\": \"{sex} = true\",\n" +
                "     \"title\": \"수유증이 있으신가요?\",\n" +
                "     \"correctAnswer\": true,\n" +
                "     \"isRequired\": true,\n" +
                "     \"labelTrue\": \"있어요\",\n" +
                "     \"labelFalse\": \"없어요\",\n" +
                "     \"valueTrue\": \"all_1\",\n" +
                "     \"valueFalse\": \"all_0\"\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"radiogroup\",\n" +
                "     \"name\": \"skintype\",\n" +
                "     \"title\": \"평소 피부타입이 어떻다고 느끼시나요?\",\n" +
                "     \"isRequired\": true,\n" +
                "     \"choices\": [\n" +
                "      {\n" +
                "       \"value\": \"1-Moisturizing_2\",\n" +
                "       \"text\": \"건성\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"2-Moisturizing_2, sebum_2\",\n" +
                "       \"text\": \"중성\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"3-sebum_4\",\n" +
                "       \"text\": \"지성\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"4-Moisturizing_4, sebum_4\",\n" +
                "       \"text\": \"복합성\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"5-trouble_4\",\n" +
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
                "       \"value\": \"1-pigmentation_5, elasticity_5\",\n" +
                "       \"text\": \"일상생활 대부분\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"2-pigmentation_4, elasticity_4\",\n" +
                "       \"text\": \"3시간 이상\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"3-pigmentation_3, elasticity_3\",\n" +
                "       \"text\": \"2시간 이상\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"4-pigmentation_2, elasticity_2\",\n" +
                "       \"text\": \"1시간 이상\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"5-pigmentation_1, elasticity_1\",\n" +
                "       \"text\": \"1시간 이하\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"6-all_0\",\n" +
                "       \"text\": \"거의 없음\"\n" +
                "      }\n" +
                "     ]\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"radiogroup\",\n" +
                "     \"name\": \"sleep\",\n" +
                "     \"title\": \"평소 수면시간이 어떻게 되시나요?\",\n" +
                "     \"isRequired\": true,\n" +
                "     \"choices\": [\n" +
                "      {\n" +
                "       \"value\": \"all_3\",\n" +
                "       \"text\": \"1~4시간\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"all_1\",\n" +
                "       \"text\": \"5~7시간\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"all_0\",\n" +
                "       \"text\": \"8시간 이상\"\n" +
                "      }\n" +
                "     ]\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"radiogroup\",\n" +
                "     \"name\": \"skinAge\",\n" +
                "     \"title\": \"피부 나이는 어느 정도로 보이시나요?\",\n" +
                "     \"isRequired\": true,\n" +
                "     \"choices\": [\n" +
                "      {\n" +
                "       \"value\": \"1-Moisturizing_5, elasticity_5\",\n" +
                "       \"text\": \"5년 이상 더 들어 보인다\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"2-Moisturizing_3, elasticity_3\",\n" +
                "       \"text\": \"1~3년 더 들어 보인다\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"3-Moisturizing_2, elasticity_2\",\n" +
                "       \"text\": \"실제 나이대로 보이는 것 같다\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"4-Moisturizing_1, elasticity_1\",\n" +
                "       \"text\": \"1~3년 더 어려 보인다\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"5-all_0\",\n" +
                "       \"text\": \"5년이상 더 어려 보인다\"\n" +
                "      }\n" +
                "     ]\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"checkbox\",\n" +
                "     \"name\": \"makeupTool\",\n" +
                "     \"visibleIf\": \"{makeup_times} <> '1-all_0'\",\n" +
                "     \"title\": \"피부화장을 한다면 어떤 것을 사용하나요? (중복선택 가능)\",\n" +
                "     \"choices\": [\n" +
                "      {\n" +
                "       \"value\": \"1-sensitivity_1, trouble_1\",\n" +
                "       \"text\": \"선크림\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"2-sensitivity_2, trouble_2\",\n" +
                "       \"text\": \"베이스\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"3-sensitivity_3, trouble_3\",\n" +
                "       \"text\": \"파운데이션\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"4-sensitivity_4, trouble_4\",\n" +
                "       \"text\": \"비비크림\"\n" +
                "      }\n" +
                "     ]\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"boolean\",\n" +
                "     \"name\": \"smoke\",\n" +
                "     \"title\": \"흡연 하시나요?\",\n" +
                "     \"correctAnswer\": true,\n" +
                "     \"isRequired\": true,\n" +
                "     \"labelTrue\": \"하고 있어요\",\n" +
                "     \"labelFalse\": \"비흡연이에요\",\n" +
                "     \"valueTrue\": \"all_5\",\n" +
                "     \"valueFalse\": \"all_0\"\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"checkbox\",\n" +
                "     \"name\": \"eatinghabits\",\n" +
                "     \"title\": \"평소 식습관에 해당되면 골라주세요(복수선택 가능)\",\n" +
                "     \"choices\": [\n" +
                "      {\n" +
                "       \"value\": \"1-Moisturizing_3\",\n" +
                "       \"text\": \"음주(주2회이상)\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"2-sebum_3, sensitivity_3\",\n" +
                "       \"text\": \"규칙적인 식사(하루 3끼)를 하지 못함\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"3-sebum_3, trouble_3\",\n" +
                "       \"text\": \"패스트푸드 섭취빈도 높음\"\n" +
                "      }\n" +
                "     ]\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"radiogroup\",\n" +
                "     \"name\": \"troubleTimes\",\n" +
                "     \"title\": \"여드름 또는 트러블이 얼마나 발생하시나요?\",\n" +
                "     \"isRequired\": true,\n" +
                "     \"choices\": [\n" +
                "      {\n" +
                "       \"value\": \"1-sebum_5, trouble_5\",\n" +
                "       \"text\": \"주 5회 이상\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"2-sebum_3, trouble_3\",\n" +
                "       \"text\": \"주 3회 이상\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"3-sebum_2, trouble_2\",\n" +
                "       \"text\": \"주 1회 이상\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"4-sebum_1, trouble_1\",\n" +
                "       \"text\": \"없음\"\n" +
                "      }\n" +
                "     ]\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"boolean\",\n" +
                "     \"name\": \"pigmentation\",\n" +
                "     \"visibleIf\": \"{makeup_times} <> 0\",\n" +
                "     \"title\": \"최근 얼굴이나 피부에 점이나 갈색반점이 생긴적 있나요?\",\n" +
                "     \"correctAnswer\": true,\n" +
                "     \"isRequired\": true,\n" +
                "     \"labelTrue\": \"있어요\",\n" +
                "     \"labelFalse\": \"없어요\",\n" +
                "     \"valueTrue\": \"pigmentation_5\",\n" +
                "     \"valueFalse\": \"all_0\"\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"boolean\",\n" +
                "     \"name\": \"makeup_side_effect\",\n" +
                "     \"visibleIf\": \"{makeup_times} <> '1-all_0'\",\n" +
                "     \"title\": \"클렌저, 보습제, 색조화장품, 기타 다른 화장품이 얼굴피부를 돋아 오르게 하거나 발진, 가려움증 혹은 따끔거리는 증상 등을 유발했던 경험이 있나요?\",\n" +
                "     \"correctAnswer\": true,\n" +
                "     \"isRequired\": true,\n" +
                "     \"labelTrue\": \"있어요\",\n" +
                "     \"labelFalse\": \"없어요\",\n" +
                "     \"valueTrue\": \"trouble_5, sebum_3\",\n" +
                "     \"valueFalse\": \"all_0\"\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"radiogroup\",\n" +
                "     \"name\": \"how_dry\",\n" +
                "     \"title\": \"건조한 환경에서 크림이나 미스트를 사용하지 않았을 때 고객님의 얼굴 상태는 어떻습니까?\",\n" +
                "     \"isRequired\": true,\n" +
                "     \"choices\": [\n" +
                "      {\n" +
                "       \"value\": \"1-Moisturizing_5\",\n" +
                "       \"text\": \"매우 건조한 느낌이 들거나 갈라진다\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"2-Moisturizing_3\",\n" +
                "       \"text\": \"다소 건조함을 느낀다\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"3-Moisturizing_1\",\n" +
                "       \"text\": \"적당한 밸런스가 유지되는 것 같다\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"4-all_0\",\n" +
                "       \"text\": \"항상 윤기가 흐르며, 세안 직후에도 당기지 않는다\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"5-Moisturizing_1\",\n" +
                "       \"text\": \"잘 모르겠다\"\n" +
                "      }\n" +
                "     ]\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"checkbox\",\n" +
                "     \"name\": \"skin_worry\",\n" +
                "     \"visibleIf\": \"{makeup_times} <> '1-all_0'\",\n" +
                "     \"title\": \"가장 큰 피부 고민은 무엇인가요? (복수선택 가능)\",\n" +
                "     \"isRequired\": true,\n" +
                "     \"choices\": [\n" +
                "      {\n" +
                "       \"value\": \"1-Moisturizing_5, sensitivity_5\",\n" +
                "       \"text\": \"각질\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"2-elasticity_5\",\n" +
                "       \"text\": \"탄력\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"3-elasticity_5,pigmentation_5\",\n" +
                "       \"text\": \"주름\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"4-sebum_5\",\n" +
                "       \"text\": \"모공\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"5-Moisturizing_5,sensitivity_5\",\n" +
                "       \"text\": \"건조함\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"6-sensitivity_5, trouble_5\",\n" +
                "       \"text\": \"잦은 트러블\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"7-trouble_5,sebum_5\",\n" +
                "       \"text\": \"여드름\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"8-Moisturizing_5\",\n" +
                "       \"text\": \"입술 갈라짐\"\n" +
                "      }\n" +
                "     ],\n" +
                "     \"colCount\": 4\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"boolean\",\n" +
                "     \"name\": \"look_pore\",\n" +
                "     \"title\": \"현재 거울을 봤을 때 모공이 눈에 띄게 보이나요?\",\n" +
                "     \"correctAnswer\": true,\n" +
                "     \"isRequired\": true,\n" +
                "     \"labelTrue\": \"있어요\",\n" +
                "     \"labelFalse\": \"없어요\",\n" +
                "     \"valueTrue\": \"sebum_3\",\n" +
                "     \"valueFalse\": \"all_0\"\n" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"boolean\",\n" +
                "     \"name\": \"look_old\",\n" +
                "     \"title\": \"지금 거울을 봤을 때 피부상태가 현재 나이보다 더 늙어보이나요?\",\n" +
                "     \"correctAnswer\": true,\n" +
                "     \"isRequired\": true,\n" +
                "     \"labelTrue\": \"있어요\",\n" +
                "     \"labelFalse\": \"없어요\"" +
                "    },\n" +
                "    {\n" +
                "     \"type\": \"radiogroup\",\n" +
                "     \"name\": \"wrinkle\",\n" +
                "     \"title\": \"얼굴에 주름이 어느 정도로 있는 편인가요? (중복선택 가능)\",\n" +
                "     \"isRequired\": true,\n" +
                "     \"choices\": [\n" +
                "      {\n" +
                "       \"value\": \"1-elasticity_3\",\n" +
                "       \"text\": \"굵은 눈가주름과 입가 팔자주름이 확연히 눈에 띈다\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"2-elasticity_3\",\n" +
                "       \"text\": \"웃거나 찡그리거나 눈썹으로 치켜 올리지 않아도 주름이 보인다\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"3-elasticity_1\",\n" +
                "       \"text\": \"얼굴에 움직임이 있는 상태에서 약간 보인다\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"4-elasticity_1\",\n" +
                "       \"text\": \"눈가와 입가에 미세한 얇은 주름이 보인다\"\n" +
                "      },\n" +
                "      {\n" +
                "       \"value\": \"5-all_0\",\n" +
                "       \"text\": \"없다\"\n" +
                "      }\n" +
                "     ]\n" +
                "    }\n" +
                "   ]\n" +
                "  }\n" +
                " ],\n" +
                " \"showCompletedPage\": false,\n" +
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
    public Result insertSurveyResult(@RequestBody HashMap<String,Object> result) throws Exception{
        log.info(result.toString());
        log.info(result.get("user").toString());
        Result retrunResult = Result.successInstance();
        retrunResult.setData(
                this.surveyService.insertResult(result,result.get("user").toString().equals("none") ? null : result.get("user").toString())
        );
        return retrunResult;
    }


    @GetMapping(value = "/result")
    public Result getSurveyResult(@RequestParam UUID id) throws Exception {
        Result retrunResult = Result.successInstance();
        retrunResult.setData(this.surveyService.selectResult(id));
        return retrunResult;
    }
}
