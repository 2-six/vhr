<template>
  <div class="position">
    <div class="title">职位管理</div>
    <el-card shadow="hover">
      <div class="toolbar">
        <el-button type="primary" @click="openAdd">新增职位</el-button>
        <el-button type="danger" @click="batchDel" :disabled="selectIds.length === 0">批量删除</el-button>
      </div>

      <el-table :data="tableData" border stripe @selection-change="handleSelect">
        <el-table-column type="selection" width="55" />
        <el-table-column prop="id" label="ID" width="80" />
        <el-table-column prop="name" label="职位名称" />
        <el-table-column prop="createDate" label="创建时间" width="180" />
        <el-table-column label="操作" width="180">
          <template #default="scope">
            <el-button size="small" @click="openEdit(scope.row)">编辑</el-button>
            <el-button size="small" type="danger" @click="singleDel(scope.row.id)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <el-dialog v-model="dialogVisible" :title="dialogTitle">
      <el-form :model="form">
        <el-form-item label="职位名称">
          <el-input v-model="form.name" placeholder="请输入职位名称"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="submit">确定</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import request from '../utils/request'
import { ElMessage, ElMessageBox } from 'element-plus'

const tableData = ref([])
const dialogVisible = ref(false)
const dialogTitle = ref('新增职位')
const selectIds = ref([])
const form = ref({ id: null, name: '' })

const load = async () => {
  const res = await request.get('/position/list')
  tableData.value = res.data
}

onMounted(() => {
  load()
})

const handleSelect = (val) => {
  selectIds.value = val.map(item => item.id)
}

const openAdd = () => {
  dialogTitle.value = '新增职位'
  form.value = { id: null, name: '' }
  dialogVisible.value = true
}

const openEdit = (row) => {
  dialogTitle.value = '编辑职位'
  form.value = { ...row }
  dialogVisible.value = true
}

const submit = async () => {
  if (!form.value.name) {
    ElMessage.warning('请输入职位名称')
    return
  }

  try {
    if (!form.value.id) {
      await request.post('/position/add', form.value)
      ElMessage.success('新增成功')
    } else {
      await request.put('/position/update', form.value)
      ElMessage.success('修改成功')
    }
    dialogVisible.value = false
    load()
  } catch (e) {
    ElMessage.error('操作失败')
  }
}

const singleDel = async (id) => {
  try {
    await ElMessageBox.confirm('确定删除？')
    await request.delete('/position/delete/' + id)
    ElMessage.success('删除成功')
    load()
  } catch (e) {
    ElMessage.error('删除失败')
  }
}

const batchDel = async () => {
  try {
    await ElMessageBox.confirm('确定批量删除？')
    await request.delete('/position/batch', { data: selectIds.value })
    ElMessage.success('批量删除成功')
    selectIds.value = []
    load()
  } catch (e) {
    ElMessage.error('批量删除失败')
  }
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