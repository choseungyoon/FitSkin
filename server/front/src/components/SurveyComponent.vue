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
            const json = {};
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
        },
        created(){
            axios.get('http://localhost:9000/survey/header', {
                params : {
                    surveyId : 1
                }
            })
            .then( response => {
                this.json = response.data.data;
                console.log("created");
                console.log(this.json);
            })
            .catch(e => {
                console.log('error : ' , e)
            })
        }
    };
</script>


<style scoped>

</style>>
    