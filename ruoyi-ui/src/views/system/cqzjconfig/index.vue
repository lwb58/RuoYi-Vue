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
      <el-form-item label="专家类别" prop="zjlb">
        <el-input
          v-model="queryParams.zjlb"
          placeholder="请输入专家类别"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="参评专业" prop="cpzy">
        <el-input
          v-model="queryParams.cpzy"
          placeholder="请输入参评专业"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="抽取人数" prop="rs">
        <el-input
          v-model="queryParams.rs"
          placeholder="请输入抽取人数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目名称" prop="projectName">
        <el-input
          v-model="queryParams.projectName"
          placeholder="请输入项目名称"
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
          v-hasPermi="['system:cqzjconfig:add']"
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
          v-hasPermi="['system:cqzjconfig:edit']"
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
          v-hasPermi="['system:cqzjconfig:remove']"
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
          v-hasPermi="['system:cqzjconfig:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="cqzjconfigList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="序号" align="center" prop="id"/>
      <el-table-column label="项目编号" align="center" prop="projectId"/>
      <el-table-column label="专家类别" align="center" prop="zjlb"/>
      <el-table-column label="参评专业" align="center" prop="cpzy"/>
      <el-table-column label="抽取人数" align="center" prop="rs"/>
      <el-table-column label="项目名称" align="center" prop="projectName"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:cqzjconfig:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:cqzjconfig:remove']"
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

    <!-- 添加或修改抽取专家设置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="dynamicValidateForm" :model="dynamicValidateForm" :rules="rules" label-width="80px">
        <el-form-item label="项目名称" prop="projectName">
          <el-select v-model="dynamicValidateForm.projectName" placeholder="项目名称" clearable filterable
                     remote
                     :remote-method="searchProjectByName"
                     v-on:change="change"
                     :loading="loading">
            <el-option
              v-for="item in projectNameOptions"
              :key="item.id"
              :label="item.projectName"
              :value="item.id"
            />
          </el-select>
          <!--          <el-input v-model="form.zjlb" placeholder="请输入专家类别" />-->
        </el-form-item>
        <el-form-item label="项目编号" prop="projectId">
          <el-input v-model="dynamicValidateForm.projectId" placeholder="请输入项目编号" :disabled="true"/>
        </el-form-item>
        <el-form-item
          v-for="(zjzy, index) in dynamicValidateForm.zjzys"
          :label="'专家类别' + index"
          :key="zjzy.key"
          :prop="'zjzys.' + index + '.value'"
        >
          <el-row>
            <el-col :span="8">
              <el-select v-model="zjzy.zjlb" placeholder="专家类别" clearable
                         :rules="{required: true, message: '专家类别不能为空', trigger: 'blur'}">
                <el-option
                  v-for="dict in zjlbOptions"
                  :key="dict.dictValue"
                  :label="dict.dictLabel"
                  :value="dict.dictValue"
                />
              </el-select>
            </el-col>
            <el-col :span="8">
              <el-select v-model="zjzy.cpzy" placeholder="参评专业" clearable
                         :rules="{required: true, message: '参评专业不能为空', trigger: 'blur'}">
                <el-option
                  v-for="dict in cpzyOptions"
                  :key="dict.dictValue"
                  :label="dict.dictLabel"
                  :value="dict.dictValue"
                />
              </el-select>
            </el-col>
            <el-col :span="8">
              <el-button @click.prevent="removeZjzy(zjzy)">删除</el-button>
            </el-col>
          </el-row>
        </el-form-item>


        <el-form-item label="抽取人数" prop="rs">
          <el-input v-model="dynamicValidateForm.rs" placeholder="请输入抽取人数"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="addZjzy">添加专业类别</el-button>
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {listCqzjconfig, getCqzjconfig, delCqzjconfig, addCqzjconfig, updateCqzjconfig} from "@/api/system/cqzjconfig";
import {getProject, listProject} from "@/api/system/project";

export default {
  name: "Cqzjconfig",
  data() {
    return {
      dynamicValidateForm: {},
      zjlbOptions: [],
      cpzyOptions: [],
      projectNameOptions: [],
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
      // 抽取专家设置表格数据
      cqzjconfigList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        projectId: null,
        zjlb: null,
        cpzy: null,
        rs: null,
        projectName: null
      },
      // 表单校验
      rules: {
        projectId: [
          {required: true, message: "项目编号不能为空", trigger: "blur"}
        ],
        /*zjlb: [
          {required: true, message: "专家类别不能为空", trigger: "blur"}
        ],
        cpzy: [
          {required: true, message: "参评专业不能为空", trigger: "blur"}
        ],*/
        rs: [
          {required: true, message: "抽取人数不能为空", trigger: "blur"}
        ],
        projectName: [
          {required: true, message: "项目名称不能为空", trigger: "blur"}
        ]
      }
    };
  },
  created() {
    this.getList();
    this.getDicts("zjlb").then(response => {
      this.zjlbOptions = response.data;
    });
    this.getDicts("cpzy").then(response => {
      this.cpzyOptions_all = response.data;
    });
  },
  methods: {
    removeZjzy(item) {
      var index = this.dynamicValidateForm.zjzys.indexOf(item)
      if (index !== -1) {
        this.dynamicValidateForm.zjzys.splice(index, 1)
      }
    },
    addZjzy() {
      this.dynamicValidateForm.zjzys.push({
        value: '',
        key: Date.now()
      });
    },
    change(query) {
      console.log(query)
    },
    changeZjlb(param) {
      if (param.indexOf('sw')) {
        console.log(param)
      }
    },
    searchProjectByName(query) {
      if (query !== '') {
        this.loading = true;
        const tempQuery = {}
        tempQuery.projectName = query
        listProject(tempQuery).then(response => {
          this.projectNameOptions = response.rows;
          this.loading = false;
        });
      } else {
        this.projectNameOptions = [];
      }
    },
    /** 查询抽取专家设置列表 */
    getList() {
      this.loading = true;
      listCqzjconfig(this.queryParams).then(response => {
        this.cqzjconfigList = response.rows;
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
      this.dynamicValidateForm = {
        id: null,
        projectId: null,
        zjlb: null,
        cpzy: null,
        rs: null,
        projectName: null,
        zjzys: []
      };
      this.resetForm("dynamicValidateForm");
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
      this.title = "添加抽取专家设置";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCqzjconfig(id).then(response => {
        this.dynamicValidateForm = response.data;
        this.open = true;
        this.title = "修改抽取专家设置";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["dynamicValidateForm"].validate(valid => {
        if (valid) {
          if (this.dynamicValidateForm.id != null) {
            updateCqzjconfig(this.dynamicValidateForm).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCqzjconfig(this.dynamicValidateForm).then(response => {
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
      this.$modal.confirm('是否确认删除抽取专家设置编号为"' + ids + '"的数据项？').then(function () {
        return delCqzjconfig(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/cqzjconfig/export', {
        ...this.queryParams
      }, `cqzjconfig_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
