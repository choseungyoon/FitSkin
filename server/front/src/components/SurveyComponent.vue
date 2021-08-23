<template>
    <div class="survey">
        <survey :survey="survey" />
    </div>
</template>

<script>
    import * as Survey from "survey-vue";
    import "survey-vue/modern.css";
    import "./index.css";

    Survey.StylesManager.applyTheme("modern");

    export default {
        name: "surveyjs-component",
        data() {
            const json = {

"title": "Skin Type Survey",
"description": "나만의 피부 Type을 확인하면 맞춤 Solution을 받을 수 있어요",
 "pages": [
  {
   "name": "page1",
   "elements": [
    {
     "type": "radiogroup",
     "name": "sex",
     "title": "성별이 어떻게 되시나요?",
     "isRequired": true,
     "choices": [
      "남성",
      "여성"
     ],
     "colCount": 0
    },
    {
     "type": "radiogroup",
     "name": "makeup",
     "title": "화장을 하시나요?",
     "isRequired": true,
     "choices": [
       "Yes", "No"
     ]
    },
    {
     "type": "radiogroup",
     "name": "product_discovering",
     "title": "1주일에 몇번 정도 화장 하시나요? ",
     "isRequired": true,
     "visibleIf": "{makeup}='Yes'",
     "choices": [
        {
            "value" : 1,
            "text" : "1회 이하"
        },
        {
            "value" : 2,
            "text" : "2~3회"
        },
        {
            "value" : 3,
            "text" : "4~5회"
        },
        {
            "value" : 4,
            "text" : "매일"
        }
     ]
    },
    {
     "type": "radiogroup",
     "name": "age",
     "title": "나이가 어떻게 되시나요?",
     "isRequired": true,
     "choices": [
      "20대 이하",
      "30~35세",
      "36~40세",
      "41~50세",
      "50대 이상"
     ]
    }
   ]
  },
  {
   "name": "page2",
   "elements": [
    {
     "type": "radiogroup",
     "name": "skin_type",
     "title": "평소에 피부 타입이 어떻다고 느껴지시나요?",
     "isRequired": true,
     "choices": [
      "건성" , "중성" , "지성" , "복합성" , "민감성","잘 모르겠어요"
     ],
     "colCount": 5
    },
    {
     "type": "comment",
     "name": "describe_type",
     "visibleIf": "{skin_type} == '잘 모르겠어요'",
     "title": "본인의 전반적인 피부 타입에 대해 설명해주세요"
    }
   ]
  },
  {
   "name": "page3",
   "elements": [
    {
     "type": "radiogroup",
     "name": "product_alternative",
     "title": "What would you use as an alternative if [the product] were no\nlonger available?",
     "hasOther": true,
     "choices": [
      "Alternative 1",
      "Alternative 2",
      "Alternative 3",
      "Alternative 4",
      "Alternative 5",
      "Alternative 6"
     ],
     "otherText": "Other (please name)",
     "colCount": 3
    },
    {
     "type": "radiogroup",
     "name": "product_benefit",
     "title": "What is the primary benefit that you have received from the\nproduct?",
     "hasOther": true,
     "choices": [
      "Benefit 1",
      "Benefit 2",
      "Benefit 3",
      "Benefit 4",
      "Benefit 5",
      "Benefit 6"
     ],
     "colCount": 3
    },
    {
     "type": "radiogroup",
     "name": "product_recommend",
     "title": "Have you recommended the product to anyone?",
     "choices": [
      "Yes",
      "No"
     ]
    }
   ]
  },
  {
   "name": "page4",
   "elements": [
    {
     "type": "rating",
     "name": "nps_score",
     "title": "How likely are you to recommend the product to a friend or\ncolleague? ",
     "isRequired": true,
     "rateMin": 0,
     "rateMax": 10,
     "minRateDescription": "Most unlikely",
     "maxRateDescription": "Most likely"
    },
    {
     "type": "radiogroup",
     "name": "favorite_functionality",
     "title": "What's your favorite functionality / add-on for the product?",
     "hasOther": true,
     "choices": [
      "Feature 1",
      "Feature 2",
      "Feature 3",
      "Feature 4",
      "Feature 5",
      "Feature 6"
     ],
     "colCount": 3
    },
    {
     "type": "comment",
     "name": "product_improvement",
     "title": "How could the product be improved to better meet your\nneeds?"
    }
   ]
  },
  {
   "name": "page5",
   "elements": [
    {
     "type": "multipletext",
     "name": "contact_customer",
     "title": "Want us to follow-up? Leave your name and email here:",
     "items": [
      {
       "name": "Name"
      },
      {
       "name": "E-mail",
       "inputType": "email",
       "validators": [
        {
         "type": "email"
        }
       ]
      }
     ]
    }
   ]
  }
 ]
};
const survey = new Survey.Model(json);

            survey.onUpdateQuestionCssClasses.add(function(survey, options) {
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
});

            

            return {
                survey: survey
            };
        }
    };
</script>


<style scoped>

</style>>
    