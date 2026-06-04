<template>
  <div class="home-page">
    <!-- 顶部 -->
    <div class="header">
      <h1>VHR人事管理系统</h1>
      <el-button type="danger" @click="logout">退出登录</el-button>
    </div>

    <!-- 左侧菜单 + 右侧内容 -->
    <div class="container">
      <div class="sidebar">
        <el-menu
          router
          background-color="#2f4050"
          text-color="#fff"
          active-text-color="#ffd04b"
        >
          <el-menu-item index="/home">
            <i class="el-icon-house"></i> 首页
          </el-menu-item>

          <el-sub-menu index="1">
            <template #title>系统管理</template>
            <el-menu-item index="/home/department">部门管理</el-menu-item>
            <el-menu-item index="/home/position">职位管理</el-menu-item>
            <el-menu-item index="/home/joblevel">职称管理</el-menu-item>
          </el-sub-menu>

          <el-menu-item index="/home/employee">
            <i class="el-icon-user"></i> 员工管理
          </el-menu-item>
        </el-menu>
      </div>

      <div class="content">
        <router-view />
      </div>
    </div>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'

const router = useRouter()

// 退出登录
const logout = () => {
  localStorage.clear()
  ElMessage.success('退出成功')
  router.push('/login')
}
</script>

<style scoped>
.home-page {
  width: 100vw;
  height: 100vh;
  display: flex;
  flex-direction: column;
  overflow: hidden;
}

/* 顶部 */
.header {
  height: 60px;
  background: #2f4050;
  color: white;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 20px;
}

/* 主体 */
.container {
  display: flex;
  flex: 1;
  overflow: hidden;
}

/* 左侧菜单 */
.sidebar {
  width: 200px;
  background: #2f4050;
}

/* 右侧内容 */
.content {
  flex: 1;
  background: #f3f3f4;
  padding: 20px;
  overflow: auto;
}
</style>