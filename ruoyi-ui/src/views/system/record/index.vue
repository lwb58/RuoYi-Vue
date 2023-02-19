<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="项目编号" prop="projectId">
        <el-input
          v-model="queryParams.projectId"
          placeholder="请输入项目编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="专家序号" prop="specialistId">
        <el-input
          v-model="queryParams.specialistId"
          placeholder="请输入专家序号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="正备选" prop="zbx">
        <el-input
          v-model="queryParams.zbx"
          placeholder="请输入正备选"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:record:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:record:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:record:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:record:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="recordList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="序号" align="center" prop="id"/>
      <el-table-column label="项目编号" align="center" prop="projectId"/>
      <el-table-column label="专家序号" align="center" prop="specialistId"/>
      <el-table-column label="正备选" align="center" prop="zbx"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:record:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:record:remove']"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改【请填写功能名称】对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目编号" prop="projectId">
          <el-input v-model="form.projectId" placeholder="请输入项目编号"/>
        </el-form-item>
        <el-form-item label="专家序号" prop="specialistId">
          <el-input v-model="form.specialistId" placeholder="请输入专家序号"/>
        </el-form-item>
        <el-form-item label="正备选" prop="zbx">
          <el-input v-model="form.zbx" placeholder="请输入正备选"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
<!--      <div class="scroll_table">
        <div style="display: inline-block; width: 100%">
          <vue-seamless-scroll
            ref="a"
            :data="tableList"
            class="seamless-warp"
            style="width: 100%"
            :class-option="classOption"
          >
            <el-table id="top"
                      :show-header="false"
                      :data="tableList"
                      class="table_scroll">
              <el-table-column
                v-for="(item,index) in columns"
                :key="index+'i'"
                :label="item.label"
                :prop="item.prop"
              />
            </el-table>
          </vue-seamless-scroll>
          <el-button @click="start">开始</el-button>
          <el-button @click="stop">暂停</el-button>
        </div>
      </div>-->
    </el-dialog>
  </div>
</template>

<script>
import vueSeamlessScroll from 'vue-seamless-scroll'
import {listRecord, getRecord, delRecord, addRecord, updateRecord} from "@/api/system/record";

export default {
  components: {
    vueSeamlessScroll
  },
  name: "Record",
  data() {
    return {
      columns: [
        {prop: 'name', label: '姓名', minWidth: '100', sort: true},
        {prop: 'date', label: '日期', minWidth: '180', sort: true},
        {prop: 'age', label: '年龄', minWidth: '180', sort: true},
        {prop: 'status', label: '状态', minWidth: '180', sort: true},
        {prop: 'address', label: '地址', minWidth: '220', sort: true}
      ],
      tableList: [
        {
          id: '1',
          date: '2019-09-25',
          name: '张三',
          status: '待处理',
          age: 18,
          address: '广东省广州市天河区'
        },
        {
          id: '2',
          date: '2019-09-26',
          name: '李四',
          age: 19,
          status: '已处理',
          address: '广州市天河区'
        },
        {
          id: '3',
          date: '2019-09-27',
          name: '王五',
          age: 20,
          status: '已完成',
          address: '广东省广州市天河区3'
        },
        {
          id: '3',
          date: '2019-09-27',
          name: '赵六',
          age: 20,
          status: '已完成',
          address: '广东省广州市天河区3'
        }
      ],
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 【请填写功能名称】表格数据
      recordList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        projectId: null,
        specialistId: null,
        zbx: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {}
    };
  },
  computed: {
    classOption() {
      return {
        step: 200, // 数值越大速度滚动越快
        limitMoveNum: this.tableList.length,
        // 开始无缝滚动的数据量，须小于等于 当前数据的长度，若大于的话滚动无法生效
        hoverStop: false, // 是否开启鼠标悬停stop
        direction: 1, // 0向下 1向上 2向左 3向右
        openWatch: true, // 开启数据实时监控刷新dom
        // singleHeight: 0, // 单步运动停止的高度(默认值0是无缝不停止的滚动) direction => 0/1
        // singleWidth: 0, // 单步运动停止的宽度(默认值0是无缝不停止的滚动) direction => 2/3
        // waitTime: 1000 // 单步运动停止的时间(默认值1000ms)
      }
    }
  },
  mounted() {
    console.log(this.$refs.a)
  },
  created() {
    this.getList();
  },
  methods: {
    start() {
      this.$refs.a._startMove()
    },
    stop() {
      this.$refs.a._stopMove()
    },
    /** 查询【请填写功能名称】列表 */
    getList() {
      this.loading = true;
      listRecord(this.queryParams).then(response => {
        this.recordList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        projectId: null,
        specialistId: null,
        createTime: null,
        zbx: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "抽取评标专家";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getRecord(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改评标抽取信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateRecord(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRecord(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除评标抽取编号为"' + ids + '"的数据项？').then(function () {
        return delRecord(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/record/export', {
        ...this.queryParams
      }, `record_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
<style lang="scss" scoped>
.scroll_table {
  margin: 15px;
  display: flex;
  ::v-deep .table .el-table__body-wrapper {
    display: none;
  }
  .seamless-warp {
    height: 200px;
    overflow: hidden;
    ::v-deep .table_scroll .el-table__header-wrapper {
      display: none;
    }
  }
}
</style>
