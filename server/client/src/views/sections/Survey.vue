<template>
  <base-section
    id="survey"
  >
    <div
      v-if="loading"
      class="justify-center align-center"
    >
      <v-row
        align="center"
        justify="center"
      >
        <v-col
          cols="10"
          md="12"
        >
          <center>
            <ring-loader
              class="custom-class"
              :active="loading"
              :indeterminate="loading"
              color='#bada55'
              size=250
              sizeUnit="px"
              align="center"
              justify="center"
            />
            <br><br>
            <base-heading
              class="font-weight-black"
              title="FitSkin 알고리즘 분석중..."
              align="center"
            />
          </center>
        </v-col>
      </v-row>

    </div>
    <div
      v-else
      class="justify-center align-center"
    >
      <v-row
        align="center"
        justify="center"
      >
          <center>
            <v-img
              alt="Vue logo"
              src="@/assets/fitskin-img/logo.png"
              width="50px"
            />
          </center>
      </v-row>
      <v-row
        align="center"
        justify="center"
      >
        <v-col
          cols="12"
          md="2"
        >
        </v-col>
        <v-col
          cols="12"
          md="8"
        >
          <survey :survey="surveyModel" /> <!-- surveyJS 컴포넌트에 surveyModel을 넣는다 -->
        </v-col>
        <v-col
          cols="12"
          md="2"
        >
        </v-col>
      </v-row>
    </div>
  </base-section>
</template>

<script>
  import * as SurveyVue from 'survey-vue'
  import surveyJSON from '@/assets/survey/survey.json'
  import 'survey-vue/modern.css'
  import '@/assets/survey/css/index.css'
  import SurveyService from '@/services/SurveyService'
  import { RingLoader } from '@saeris/vue-spinners'

  SurveyVue.StylesManager.applyTheme('modern')

  let Survey = {}
  Survey = SurveyVue.Survey
  export default {
    name: 'SurveyjsComponent',
    metaInfo: { title: 'FikSkin-피부진단' },
    components: {
      Survey,
      RingLoader,
    },
    data () {
      return {
        loading: false,
      }
    },
    computed: {
      surveyModel () {
        let survyeModel = {}
        var ref = this
        survyeModel = new SurveyVue.Model(surveyJSON)
        survyeModel.onComplete.add(function (result) {
          ref.completedSurvey(JSON.stringify(result.data))
        })
        return survyeModel
      },
      currentUser () {
        return this.$store.state.auth.user
      },
    },
    methods: {
      completedSurvey: function (resultData) {
        SurveyService.insertResult(resultData, this.currentUser != null ? this.currentUser.email : 'none')
          .then((response) => {
            this.loading = true
            setTimeout(() => this.$router.push({ path: `/skin_analysis/${response.data.data}` }), 3000)
          })
          .catch((err) => {
            console.log(err)
          })
      },
      activate () {
        setTimeout(() => (this.loading = false), 30000)
      },
    },
  }
</script>
