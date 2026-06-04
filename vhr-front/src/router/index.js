import { createRouter, createWebHistory } from 'vue-router'
import Login from '../views/Login.vue'
import Home from '../views/Home.vue'

const routes = [
  { path: '/', redirect: '/login' },
  { path: '/login', component: Login },
  {
    path: '/home',
    component: Home,
    children: [
      { path: '', component: () => import('../views/Welcome.vue') },
       { path: 'department', component: () => import('../views/Department.vue') },
      // { path: 'position', component: () => import('../views/Position.vue') },
      // { path: 'joblevel', component: () => import('../views/JobLevel.vue') },
      // { path: 'employee', component: () => import('../views/Employee.vue') }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router