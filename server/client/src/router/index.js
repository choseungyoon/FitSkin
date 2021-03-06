// Imports
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  scrollBehavior: (to, from, savedPosition) => {
    if (to.hash) return { selector: to.hash }
    if (savedPosition) return savedPosition

    return { x: 0, y: 0 }
  },
  routes: [
    {
      path: '/survey',
      name: '피부 비타민 추천',
      component: () => import('@/views/sections/Survey.vue'),
    },
    {
      path: '/login',
      name: 'Login',
      component: () => import('@/views/login/Login.vue'),
    },
    {
      path: '/signup',
      name: 'Signup',
      component: () => import('@/views/login/Signup.vue'),
    },
    {
      path: '/',
      component: () => import('@/layouts/base/Index.vue'),
      children: [
        {
          path: '',
          name: 'Home',
          component: () => import('@/views/home/Index.vue'),
        },
        {
          path: 'profile',
          name: 'Profile',
          // lazy-loaded
          component: () => import('@/views/sections/Profile.vue'),
        },
        {
          path: 'about',
          name: 'About',
          component: () => import('@/views/about/Index.vue'),
        },
        {
          path: 'services',
          name: 'Services',
          component: () => import('@/views/services/Index.vue'),
        },
        {
          path: 'dna',
          name: '유전자검사',
          component: () => import('@/views/dna/Index.vue'),
        },
        {
          path: 'project/:id',
          name: 'ProjectDetail',
          props: true,
          component: () => import('@/views/portfolio/Detail.vue'),
        },
        {
          path: 'store',
          name: 'Store',
          component: () => import('@/views/store/Index.vue'),
        },
        {
          path: 'store/:id',
          name: 'ProductDetail',
          component: () => import('@/views/store/Detail.vue'),
        },
        {
          path: 'contact',
          name: 'Contact',
          component: () => import('@/views/contact/Index.vue'),
        },
        {
          path: 'sink',
          name: 'Sink',
          component: () => import('@/views/sink/Index.vue'),
        },
        {
          path: 'skin_analysis/:id',
          name: 'Analysis',
          component: () => import('@/views/sections/Analysis.vue'),
        },
        {
          path: '*',
          name: 'NotFound',
          component: () => import('@/views/not-found/Index.vue'),
        },
      ],
    },
  ],
})

export default router
