import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/components/Main'
import ProductSearch from '@/components/ProductSearch'
import FAQ from '@/components/FAQ'


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Main',
      component: Main
    },
    {
      path: '/product/search',
      name: 'ProductSearch',
      component: ProductSearch
    },{
      path: '/FAQ',
      name: 'FAQ',
      component: FAQ
    }
  ]
})
