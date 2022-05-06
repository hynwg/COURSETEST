import {createApp} from 'vue'
import router from './router.js'
import App from './app.vue'
import axios from 'axios'
// import VueAxios from 'vue-axios'
let app = createApp(App)
app.use(router)
app.mount('#app')
app.config.globalProperties.$axios=axios
// app.use(router).use(VueAxios,axios).mount('#app')
/**
 * axios拦截器
 */
// axios.interceptors.request.use(function (config) {
//     console.log("请求：", config);
//     let token = Tool.getLoginUser().token;
//     if (Tool.isNotEmpty(token)) {
//         config.headers.token = token;
//         console.log("请求headers增加token:", token);
//     }
//     return config;
// }, error => {});
// axios.interceptors.response.use(function (response) {
//     console.log("返回结果：", response);
//     return response;
// }, error => {});


console.log("环境：", process.env.NODE_ENV);




