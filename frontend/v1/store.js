import Vuex from 'vuex';
import Vue from 'vue';

Vue.use(Vuex);

const requireContext = require.context('./pages', true, /store\.js$/);
const modules = requireContext.keys().reduce((result, key) => {
  const regExp = new RegExp(/\.\/([a-zA-Z0-9]+)\/./);
  const matches = key.match(regExp);
  if (matches && matches[1]) {
    result[matches[1].toLowerCase()] = requireContext(key).default;
  }
  return result;
}, {});

export default new Vuex.Store({
  modules,
});
