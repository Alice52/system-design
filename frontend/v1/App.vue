<template>
  <div id="app">
    <keep-alive>
      <router-view v-if="$route.meta.keepAlive" />
    </keep-alive>
    <router-view v-if="!$route.meta.keepAlive" />
  </div>
</template>

<script>
import { initBaseURL } from './main';

export default {
  name: 'App',
  created() {
    this.initBaseURLWithAccountId();
  },
  methods: {
    initBaseURLWithAccountId() {
      initBaseURL(this.$route.query);
    },
  },
};
</script>

<style lang="less">
@import '~@@/styles/reset.less';
@import '~@@/styles/common.less';
@import 'styles/reset.less';

#app {
  min-height: 100vh;
  height: 100%;
}

.van-toast {
  width: 100px;
}
</style>
