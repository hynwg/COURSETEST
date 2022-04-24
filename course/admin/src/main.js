import Vue, {createApp} from 'vue'
import router from './router.js';
import App from './app.vue'
import axios from 'axios'

let app = createApp(App)
app.use(router)
app.mount('#app')
app.config.globalProperties.$axios=axios




