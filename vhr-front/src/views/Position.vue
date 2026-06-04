<template>
  <div class="position">
    <div class="title">职位管理</div>

    <el-card shadow="hover">
      <!-- 工具栏 -->
      <div class="toolbar">
        <el-button type="primary" @click="openAdd">新增职位</el-button>
        <el-button type="success" @click="openEdit">修改职位</el-button>
        <el-button type="danger" @click="deletePos">删除职位</el-button>
      </div>

      <!-- 表格 -->
      <el-table :data="tableData" border stripe>
        <el-table-column label="ID" prop="id" width="80" />
        <el-table-column label="职位名称" prop="name" />
        <el-table-column label="职位描述" prop="remark" />
        <el-table-column label="创建时间" prop="createDate" width="180" />
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

// 获取职位列表
const loadList = async () => {
  const res = await request.get('/position/list')
  tableData.value = res.data
}

// 新增
const openAdd = () => {
  ElMessage.success('打开新增弹窗')
}

// 修改
const openEdit = () => {
  ElMessage.success('打开修改弹窗')
}

// 删除
const deletePos = () => {
  ElMessage.warning('执行删除')
}
</script>

<style scoped>
.position {
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