<template>
  <div class="department">
    <div class="title">部门管理</div>

    <el-card shadow="hover">
      <!-- 工具栏 -->
      <div class="toolbar">
        <el-button type="primary" @click="add">新增部门</el-button>
        <el-button type="success" @click="edit">修改部门</el-button>
        <el-button type="danger" @click="del">删除部门</el-button>
      </div>

      <!-- 表格 -->
      <el-table :data="tableData" border stripe>
        <el-table-column prop="id" label="ID" width="80" />
        <el-table-column prop="name" label="部门名称" />
        <el-table-column prop="parentName" label="上级部门" />
        <el-table-column prop="depPath" label="部门路径" />
        <el-table-column prop="enabled" label="状态">
          <template #default="scope">
            <el-tag type="success" v-if="scope.row.enabled">启用</el-tag>
            <el-tag type="danger" v-else>禁用</el-tag>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import request from '../utils/request'
import { ElMessage } from 'element-plus'

const tableData = ref([])

// 页面加载时获取部门列表
onMounted(() => {
  loadList()
})

// 加载部门列表
const loadList = async () => {
  const res = await request.get('/department/list')
  tableData.value = res.data
}

// 新增
const add = () => {
  ElMessage.info('打开新增弹窗')
}

// 修改
const edit = () => {
  ElMessage.info('打开修改弹窗')
}

// 删除
const del = () => {
  ElMessage.info('执行删除')
}
</script>

<style scoped>
.department {
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