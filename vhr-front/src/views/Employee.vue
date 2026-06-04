<template>
  <div class="employee">
    <div class="title">员工管理</div>

    <el-card shadow="hover">
      <div class="toolbar">
        <el-button type="primary" @click="add">新增员工</el-button>
        <el-button type="success" @click="edit">修改员工</el-button>
        <el-button type="danger" @click="del">删除员工</el-button>
      </div>

      <el-table :data="tableData" border stripe>
        <el-table-column prop="id" label="ID" width="80" />
        <el-table-column prop="name" label="姓名" />
        <el-table-column prop="phone" label="手机号" />
        <el-table-column prop="departmentName" label="部门" />
        <el-table-column prop="positionName" label="职位" />
        <el-table-column prop="jobLevelName" label="职称" />
        <el-table-column prop="workID" label="工号" width="120" />
      </el-table>
    </el-card>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import request from '../utils/request'
import { ElMessage } from 'element-plus'

const tableData = ref([])

onMounted(() => {
  loadList()
})

const loadList = async () => {
  const res = await request.get('/employee/list')
  tableData.value = res.data
}

const add = () => {
  ElMessage.success('打开新增')
}
const edit = () => {
  ElMessage.success('打开修改')
}
const del = () => {
  ElMessage.warning('执行删除')
}
</script>

<style scoped>
.employee {
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