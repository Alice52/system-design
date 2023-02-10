import VueRouter from 'vue-router';
import Vue from 'vue';
import constantRoutes from './config';

Vue.use(VueRouter);

export default new VueRouter({
  routes: constantRoutes,
  scrollBehavior(to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition;
    }
    return { x: 0, y: 0 };
  },
});
