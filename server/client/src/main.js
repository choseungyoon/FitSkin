import Vue from 'vue'
import App from './App.vue'
import router from './router'
import vuetify from './plugins/vuetify'
import './plugins'
import appData from './mixins/app-data'
import '@/assets/login/styles.scss'
import store from './store'
import { library } from '@fortawesome/fontawesome-svg-core'
import { faUserSecret, faBan } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import '@storefront-ui/vue/styles.scss'
import { VueSpinners } from '@saeris/vue-spinners'

window.Kakao.init('73975ad30e810c26b2acbec57717d536')

Vue.mixin(appData)
Vue.config.productionTip = false

library.add(faUserSecret)
library.add(faBan)

Vue.use(VueSpinners)

Vue.component('font-awesome-icon', FontAwesomeIcon)

new Vue({
  router,
  vuetify,
  store,
  render: h => h(App),
}).$mount('#app')
