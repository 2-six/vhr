import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'

// 👇 必须加这一行
import router from './router'

const app = createApp(App)
app.use(ElementPlus)

// 👇 必须加这一行
app.use(router)

app.mount('#app')