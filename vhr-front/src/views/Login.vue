<template>
  <div class="login-page">
    <el-card class="login-box">
      <h2 class="title">VHR人事管理系统</h2>
      <!-- 绑定表单数据、校验规则、表单ref -->
      <el-form ref="formRef" :model="loginForm" :rules="rules" label-width="80px">
        <el-form-item label="账号" prop="username">
          <el-input v-model="loginForm.username" placeholder="请输入账号"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="loginForm.password" type="password" placeholder="请输入密码" show-password></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="login" block :loading="loading">登录</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script setup>
import { ref, reactive } from 'vue'
import { useRouter } from 'vue-router'
import request from '../utils/request'
import { ElMessage } from 'element-plus'

// 路由实例
const router = useRouter()
// 登录按钮加载
const loading = ref(false)
// 表单数据
const loginForm = reactive({
  username: '',
  password: ''
})
// 表单校验规则
const rules = reactive({
  username: [{ required: true, message: '请输入账号', trigger: 'blur' }],
  password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
})
// 获取表单DOM
const formRef = ref(null)

// 登录方法
const login = async () => {
  // 先做表单校验
  await formRef.value.validate(async valid => {
    if (!valid) return
    loading.value = true
    try {
      // 调用后端登录接口
      const res = await request.post('/login', loginForm)
      // 存储token到本地
      localStorage.setItem('token', res.data.token)
      ElMessage.success('登录成功')
      // 跳转到首页/home
      router.push('/home')
    } catch (err) {
      ElMessage.error('账号或密码错误')
    } finally {
      loading.value = false
    }
  })
}
</script>

<style scoped>
.login-page{
  height:100vh;
  background:#f5f7fa;
  display:flex;
  justify-content:center;
  align-items:center;
}
.login-box{
  width:420px;
  padding:30px;
}
.title{
  text-align:center;
  margin-bottom:24px;
}
</style>