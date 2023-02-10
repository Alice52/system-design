/* eslint-disable */
import ProductionEnv from '@/env/production';
import StagingEnv from '@/env/staging';
import LocalEnv from '@/env/local';

let env = {
  apiDomain: '' // 默认使用当前页面域名
};
if (window.location.host.indexOf('staging') > -1) {
  env = Object.assign(env, StagingEnv);
} else if (window.location.host.indexOf('kol') > -1) {
  env = Object.assign(env, ProductionEnv);
} else {
  env = Object.assign(env, LocalEnv);
}

export default env;
