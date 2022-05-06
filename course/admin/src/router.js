// 引入vue-router的两个api,
// createRouter创建路由，createWebHashHistory 采用hash模式， createWebHistory采用history模式
import {createRouter, createWebHistory} from 'vue-router'

// 引入文件，动态路由
const Login = () => import("./views/login.vue");
// @ts-ignore
const Admin = () => import("./views/admin.vue");
const Welcome = () => import("./views/admin/welcome.vue");
const Chapter = () => import("./views/admin/chapter.vue");
const Section = () => import("./views/admin/section.vue");
const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: "/login",
            component: Login
        }
        , {
            path: "/",
            name: "admin",
            component: Admin,
            children: [{
                //子路由的配置不要'/'开头
                path: "welcome",
                name: "welcome",
                component: Welcome,
            }, {
                path: "business/chapter",
                name: "business/chapter",
                component: Chapter,
            }, {
                path: "business/section",
                name: "business/section",
                component: Section,
            }]
        }
    ]
})
export default router
