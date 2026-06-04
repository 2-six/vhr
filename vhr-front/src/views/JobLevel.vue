<template>
  <div class="joblevel">
    <div class="title">职称管理</div>

    <el-card shadow="hover">
      <!-- 工具栏 -->
      <div class="toolbar">
        <el-button type="primary" @click="add">新增职称</el-button>
        <el-button type="success" @click="edit">修改职称</el-button>
        <el-button type="danger" @click="del">删除职称</el-button>
      </div>

      <!-- 表格 -->
      <el-table :data="tableData" border stripe>
        <el-table-column prop="id" label="ID" width="80" />
        <el-table-column prop="name" label="职称名称" />
        <el-table-column prop="titleLevel" label="职称等级" />
        <el-table-column prop="createDate" label="创建时间" width="180" />
      </el-table>
    </el-card>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import request from '../utils/request'
import { ElMessage } from 'element-plus'

const tableData = ref([])

// 页面加载
onMounted(() => {
  loadList()
})

// 获取列表
const loadList = async () => {
  const res = await request.get('/joblevel/list')
  tableData.value = res.data
}

// 新增
const add = () => {
  ElMessage.success('打开新增弹窗')
}

// 修改
const edit = () => {
  ElMessage.success('打开修改弹窗')
}

// 删除
const del = () => {
  ElMessage.warning('执行删除')
}
</script>

<style scoped>
.joblevel {
  padding: 20px;
}
.title {
  font-size: 20px;
  font-weight: bold;
  margin-bottom: 20px;
}
.toolbar {
  margin-bottom: 15px;
}
</style>