<template>
  <div class="container">
    <header class="jumbotron">
      <h3>
        <strong>{{ currentUser.username }}</strong> Profile
      </h3>
    </header>
    <p>
      <strong>Token:</strong>
      {{ currentUser.accessToken.substring(0, 20) }} ...
      {{ currentUser.accessToken.substr(currentUser.accessToken.length - 20) }}
    </p>
    <p>
      <strong>Id:</strong>
      {{ currentUser.id }}
    </p>
    <p>
      <strong>Email:</strong>
      {{ currentUser.email }}
    </p>
    <strong>Authorities:</strong>
    <ul>
      <li v-for="(role, index) in currentUser.roles" :key="index">
        {{ role }}
      </li>
    </ul>

    <strong>SkinReport Result</strong>
    <v-data-table
      dense
      :headers="headers"
      :items="surveyresults"
      item-key="date"
      class="elevation-1"
    ></v-data-table>
  </div>
</template>

<script>
import SurveyDataService from "../services/SurveyDataService";

export default {
  name: "Profile",
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
  },
  data() {
    return {
      surveyresults: [],
      headers: [
        {
          text: "날짜",
          align: "start",
          sortable: true,
          value: "date",
        },
        { text: "보습", value: "moisturizing" },
        { text: "피지분비", value: "sebum" },
        { text: "민감성", value: "sensitivity" },
        { text: "탄력", value: "elasticity" },
        { text: "색소침착", value: "pigmentation" },
        { text: "트러블", value: "trouble" },
      ],
    };
  },
  mounted() {
    if (!this.currentUser) {
      this.$router.push("/login");
    }
  },
  created() {
    console.log(this.currentUser.email);
    SurveyDataService.getAllResult(this.currentUser.email)
      .then((response) => {
        console.log(response.data.data);
        this.surveyresults = response.data.data;
      })
      .catch((err) => {
        console.log(err);
      });
  },
};
</script>
