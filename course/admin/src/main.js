import Vue, {createApp} from 'vue'
 import router from './router.js';
import App from './app.vue'
let app=createApp(App)
app.use(router)
app.mount('#app')




