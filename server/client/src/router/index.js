import Vue from "vue";
import VueRouter from "vue-router";
import MainGrid from "../views/MainGrid";
import Home from "../views/Home.vue";
import MyProduct from "../views/MyProduct.vue";
import SurveyComponent from "../components/SurveyComponent";
import SkinReport from "../views/SkinReport";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: MainGrid,
    meta: {
      title: "Fitskin",
    },
    children: [
      {
        path: "/",
        name: "home",
        component: Home,
      },
      {
        path: "/product/my",
        name: "MyProduct",
        component: MyProduct,
      },
      {
        path: "/customer_profile/skin_analysis/:id",
        name: "SkinReport",
        component: SkinReport,
      },
    ],
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },

  {
    path: "/survey",
    name: "SURVEY",
    component: SurveyComponent,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
