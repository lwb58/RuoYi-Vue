<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="200px">
      <el-form-item label="项目名称" prop="projectName">
        <el-input
          v-model="queryParams.projectName"
          placeholder="请输入项目名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目所属地" prop="projAddr">
        <el-input
          v-model="queryParams.projAddr"
          placeholder="请输入项目所属地"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="经办人姓名" prop="oper">
        <el-input
          v-model="queryParams.oper"
          placeholder="请输入经办人姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号码" prop="mobile">
        <el-input
          v-model="queryParams.mobile"
          placeholder="请输入手机号码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="监督部门" prop="department">
        <el-input
          v-model="queryParams.department"
          placeholder="请输入监督部门"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="评标开始时间" prop="startTime">
        <!--        <el-date-picker clearable
                                v-model="queryParams.startTime"
                                type="date"
                                value-format="yyyy-MM-dd"
                                placeholder="请选择评标开始时间">
                </el-date-picker>-->
        <el-date-picker
          v-model="queryParams.startTime"
          type="datetime"
          placeholder="请选择评标开始时间"
          align="right">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="评标地点" prop="addr">
        <el-input
          v-model="queryParams.addr"
          placeholder="请输入评标地点"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="倍选比率" prop="rates">
        <el-input
          v-model="queryParams.rates"
          placeholder="请输入倍选比率"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="招标方式" prop="zbfs">
        <el-input
          v-model="queryParams.zbfs"
          placeholder="请输入招标方式"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="屏蔽最近几天内被抽中的专家" prop="days">
        <el-input
          v-model="queryParams.days"
          placeholder="请输入屏蔽最近几天内被抽中的专家"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="同单位最多可以抽中的数量" prop="amounts">
        <el-input
          v-model="queryParams.amounts"
          placeholder="请输入同单位最多可以抽中的数量"
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
          v-hasPermi="['system:project:add']"
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
          v-hasPermi="['system:project:edit']"
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
          v-hasPermi="['system:project:remove']"
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
          v-hasPermi="['system:project:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="projectList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="项目编号" align="center" prop="id"/>
      <el-table-column label="项目名称" align="center" prop="projectName"/>
      <el-table-column label="项目所属地" align="center" prop="projAddr"/>
      <el-table-column label="经办人姓名" align="center" prop="oper"/>
      <el-table-column label="手机号码" align="center" prop="mobile"/>
      <el-table-column label="监督部门" align="center" prop="department"/>
      <el-table-column label="评标开始时间" align="center" prop="startTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.startTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="评标地点" align="center" prop="addr"/>
      <el-table-column label="屏蔽最近几天内被抽中的专家" align="center" prop="days"/>
      <el-table-column label="同单位最多可以抽中的数量" align="center" prop="amounts"/>
      <el-table-column label="倍选比率" align="center" prop="rates"/>
      <el-table-column label="招标方式" align="center" prop="zbfs"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:project:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:project:remove']"
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
    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="200px">
        <el-form-item label="项目名称" prop="projectName">
          <el-input v-model="form.projectName" placeholder="请输入项目名称"/>
        </el-form-item>
        <el-form-item label="项目所属地" prop="projAddr">
          <el-input v-model="form.projAddr" placeholder="请输入项目所属地"/>
        </el-form-item>
        <el-form-item label="经办人姓名" prop="oper">
          <el-input v-model="form.oper" placeholder="请输入经办人姓名"/>
        </el-form-item>
        <el-form-item label="手机号码" prop="mobile">
          <el-input v-model="form.mobile" placeholder="请输入手机号码"/>
        </el-form-item>
        <el-form-item label="监督部门" prop="department">
          <el-input v-model="form.department" placeholder="请输入监督部门"/>
        </el-form-item>
        <el-form-item label="评标开始时间" prop="startTime">
          <el-date-picker
            v-model="form.startTime"
            type="datetime"
            placeholder="请选择评标开始时间"
            align="right"
            :picker-options="pickerOptions">
          </el-date-picker>
          <!--          <el-date-picker clearable
                                    v-model="form.startTime"
                                    type="date"
                                    value-format="yyyy-MM-dd"
                                    placeholder="请选择评标开始时间">
                    </el-date-picker>-->
        </el-form-item>
        <el-form-item label="评标地点" prop="addr">
          <el-input v-model="form.addr" placeholder="请输入评标地点"/>
        </el-form-item>
        <el-form-item label="屏蔽最近几天内被抽中的专家" prop="days">
          <el-input-number v-model="form.days" :step="1" :max="10000" :min="0"></el-input-number>
          <!--          <el-input v-model="form.days" placeholder="请输入屏蔽最近几天内被抽中的专家"/>-->
        </el-form-item>
        <el-form-item label="同单位最多可以抽中的数量" prop="amounts">
          <el-input-number v-model="form.amounts" :step="1" :max="10000"
                           :min="0"></el-input-number>
          <!--          <el-input v-model="form.amounts" placeholder="请输入同单位最多可以抽中的数量"/>-->
        </el-form-item>
        <el-form-item label="倍选比率" prop="rates">
          <!--          <el-input v-model="form.rates" placeholder="请输入倍选比率"/>-->
          <el-input-number v-model="form.rates" :step="1" :max="100000"
                           :min="1"></el-input-number>
        </el-form-item>
        <el-form-item label="招标方式" prop="zbfs">
          <el-input v-model="form.zbfs" placeholder="请输入招标方式"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {listProject, getProject, delProject, addProject, updateProject} from "@/api/system/project";

export default {
  name: "Project",
  data() {
    return {
      pickerOptions: {
        shortcuts: [{
          text: '今天',
          onClick(picker) {
            picker.$emit('pick', new Date());
          }
        }, {
          text: '昨天',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24);
            picker.$emit('pick', date);
          }
        }, {
          text: '一周前',
          onClick(picker) {
            const date = new Date();
            date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
            picker.$emit('pick', date);
          }
        }]
      },
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
      projectList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        projectName: null,
        projAddr: null,
        oper: null,
        mobile: null,
        department: null,
        startTime: null,
        addr: null,
        days: null,
        amounts: null,
        rates: null,
        zbfs: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {}
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询【请填写功能名称】列表 */
    getList() {
      this.loading = true;
      listProject(this.queryParams).then(response => {
        this.projectList = response.rows;
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
        projectName: null,
        createTime: null,
        projAddr: null,
        oper: null,
        mobile: null,
        department: null,
        startTime: null,
        addr: null,
        days: null,
        amounts: null,
        rates: null,
        zbfs: null
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
      this.title = "添加项目";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getProject(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改项目信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateProject(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProject(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除项目编号为"' + ids + '"的数据项？').then(function () {
        return delProject(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/project/export', {
        ...this.queryParams
      }, `project_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
