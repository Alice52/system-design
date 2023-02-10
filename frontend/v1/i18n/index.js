import Vue from 'vue';
import VueI18n from 'vue-i18n';

import zhCN from './zh-CN';
import enUS from './en-US';

Vue.use(VueI18n);

export default new VueI18n({
  locale: window.navigator.language.indexOf('zh') > -1 ? 'zh-CN' : 'en-US',
  messages: {
    'zh-CN': zhCN,
    'en-US': enUS,
  },
});
