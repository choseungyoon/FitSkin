<template>
    <div class="survey">
        <survey :survey="survey" />
    </div>
</template>

<script>
    import * as Survey from "survey-vue";
    import axios from "axios";
    import "survey-vue/modern.css";
    import "./index.css";

    Survey.StylesManager.applyTheme("modern");

    export default {
        name: "surveyjs-component",
        data() {
            const json = {
        "title": "Skin Type Survey",
        "description": "나만의 피부 Type을 확인하면 맞춤 Solution을 받을 수 있어요",
        "otherInfo": null,
        "id": 1,
        "pages": [
            {
                "id": 3,
                "surveyHeaderId": 1,
                "name": "common",
                "seq": 0,
                "elements": [
                    {
                        "id": 1,
                        "surveySectionId": 3,
                        "type": "radiogroup",
                        "name": "성별이 어떻게 되시나요?",
                        "seq": 0,
                        "choices": [
                            "남성",
                            "여성"
                        ],
                        "required": true
                    },
                    {
                        "id": 2,
                        "surveySectionId": 3,
                        "type": "radiogroup",
                        "name": "makeup",
                        "title" : "주 몇회 화장 하시나요?",
                        "seq": 1,
                        "choices": [
                            "전혀 하지 않음",
                            "1회 이하",
                            "2~3회",
                            "4~5회",
                            "거의 매일"
                        ],
                        "required": true,
                        "colCount" : 5
                    },
                    {
                        "id": 3,
                        "surveySectionId": 3,
                        "type": "radiogroup",
                        "name" : "age",
                        "title": "나이가 어떻게 되시나요?",
                        "seq": 2,
                        "choices": [
                            "24세 이하",
                            "25~29세",
                            "30~35회",
                            "36~40세",
                            "41~50회",
                            "51세 이상"
                        ],
                        "required": true,
                        "colCount" : 5
                    }
                ]
            },
            {
                "name": "female",
                "seq": 0,
                "elements": [
                    {
                        "type": "radiogroup",
                        "name" : "skintype",
                        "title": "평소에 느끼는 피부 타입이 있나요?",
                        "choices": [
                            "건성 피부",
                            "중성 피부",
                            "지성 피부",
                            "복합 피부",
                            "민감성 피부"
                        ],
                        "required": true,
                        "colCount" : 3
                    },
                    {
                        "type": "radiogroup",
                        "name" : "out",
                        "title": "하루에 야외 활동 정도가 어떻게 되시나요?",
                        "choices": [
                            "일상생활 대부분",
                            "3시간 이상",
                            "2시간 이상",
                            "1시간 이상",
                            "1시간 이하",
                            "거의 없음"
                        ],
                        "required": true,
                        "colCount" : 3
                    },
                    {
                        "type": "radiogroup",
                        "name" : "sleep",
                        "title": "수면 시간?",
                        "choices": [
                            "1~4시간",
                            "5~8시간",
                            "8~10시간 이상"
                        ],
                        "required": true,
                        "colCount" : 3
                    },
                    {
                        "type": "checkbox",
                        "name" : "if_makeup",
                        "title": "피부 화자을 한다면?",
                        "choices": [
                            "선크림",
                            "베이스",
                            "파운데이션",
                            "비비크림"
                        ],
                        "required": true,
                        "colCount" : 3
                    },
                    {
                        "type": "boolean",
                        "name": "smoke",
                        "title": "Please answer the question",
                        "label": "흡연 하시나요??",
                        "isRequired": true
                    },
                    {
                        "type": "boolean",
                        "name": "pore",
                        "title": "pore",
                        "label": "현재 거울을 봤을 때 모공이 눈에 띄게 보이나요?",
                        "isRequired": true
                    }
                ]
            },
             {
                "name": "email",
                "seq": 0,
                "elements": [
                     { 
                        type: "text", 
                        name: "email", 
                        title: "Thank you for taking our survey. 검사 결과를 받고 있다면 아래 이메일을 적어주세요."
                    }
                ]
             }
        ]
    };
            console.log("data");
            console.log(json);
            const survey = new Survey.Model(json);

            survey.onUpdateQuestionCssClasses.add(
                function(survey, options) {
                    var classes = options.cssClasses
                    classes.mainRoot += " sv_qstn";
                    classes.root = "sq-root";
                    classes.title += " sq-title"
                    classes.item += " sq-item";
                    classes.label += " sq-label";
            
                    if (options.question.isRequired) {
                        classes.title += " sq-title-required";
                        classes.root += " sq-root-required";
                    }
                    if (options.question.getType() === "checkbox") {
                        classes.root += " sq-root-cb";
                    }
                }
            );
            return {
                survey: survey
            };

            var surveyGetResult = function(s, options) {
            if(options.success) {
                alert(options.dataList);
                }
            };

        },
        created(){
        }
    };
</script>


<style scoped>

</style>>
    