<template>
  <div class="survey">
    <center>
      <img alt="Vue logo" src="../assets/img/icon.png" width="50px" />
    </center>
    <survey :survey="survey" />
    <div id="surveyResult"></div>
  </div>
</template>

<script>
import * as Survey from "survey-vue";
import axios from "axios";
import "survey-vue/modern.css";
import "./index.css";
import SurveyDataService from "../services/SurveyDataService";

Survey.StylesManager.applyTheme("modern");

export default {
  name: "surveyjs-component",
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
  },
  data() {
    return {
      json: "",
      survey: "",
    };
  },
  created: function() {
    SurveyDataService.getForm()
      .then((response) => {
        this.json = response.data.data;
        this.survey = new Survey.Model(this.json);
      })
      .catch((err) => {
        console.log(err);
      });
  },
  watch: {
    survey: function() {
      var ref = this;
      this.survey.onComplete.add(
        function(sender) {
          ref.completedSurvey(JSON.stringify(sender.data));
        }
        //this.$router.push("/customer_profile/skin_analysis");
      );
    },
  },
  methods: {
    completedSurvey: function(resultData) {
      SurveyDataService.insertResult(
        resultData,
        this.currentUser != null ? this.currentUser.email : "none"
      )
        .then((response) => {
          console.log(response.data);

          this.$router.push({
            path: `/customer_profile/skin_analysis/${response.data.data}`,
          });
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style scoped></style>>
