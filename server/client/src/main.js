import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import vuetify from "./plugins/vuetify";
import { BootstrapVue, IconsPlugin } from "bootstrap-vue";
import VueApexChart from "vue-apexcharts";
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
import { library } from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import {
  faHome,
  faUser,
  faUserPlus,
  faSignInAlt,
  faSignOutAlt,
} from "@fortawesome/free-solid-svg-icons";

Vue.config.productionTip = false;

library.add(faHome, faUser, faUserPlus, faSignInAlt, faSignOutAlt);

// Install BootstrapVue
Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(VueApexChart);

Vue.component("apexchart", VueApexChart);
Vue.component("font-awesome-icon", FontAwesomeIcon);

new Vue({
  vuetify,
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
