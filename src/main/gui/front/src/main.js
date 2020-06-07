// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App'
import router from './router'
import axios from 'axios';


Vue.use(ElementUI)

Vue.prototype.$http=axios;//修改内部的$http为axios  $http.get("") .post()
Vue.config.productionTip = false

/* eslint-disable no-new */
//项目启动类
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
