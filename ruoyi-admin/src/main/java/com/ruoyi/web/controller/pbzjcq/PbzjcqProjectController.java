package com.ruoyi.web.controller.pbzjcq;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.PbzjcqProject;
import com.ruoyi.system.service.IPbzjcqProjectService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author ruoyi
 * @date 2023-02-18
 */
@RestController
@RequestMapping("/system/project")
public class PbzjcqProjectController extends BaseController {
    @Autowired
    private IPbzjcqProjectService pbzjcqProjectService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:project:list')")
    @GetMapping("/list")
    public TableDataInfo list(PbzjcqProject pbzjcqProject) {
        startPage();
        Date startTime = pbzjcqProject.getStartTime();
        if (null != startTime) {
            DateTime dateTime = DateUtil.endOfDay(startTime);
            pbzjcqProject.setEndTime(dateTime);
        }
        List<PbzjcqProject> list = pbzjcqProjectService.selectPbzjcqProjectList(pbzjcqProject);
        return getDataTable(list);
    }

    /*为所选项目抽取专家*/
    @PreAuthorize("@ss.hasPermi('system:project:cqzj')")
    @Log(title = "抽取专家", businessType = BusinessType.CQZJ)
    @PostMapping("/cqzj")
    public TableDataInfo cqzj(PbzjcqProject pbzjcqProject) {
        startPage();
        Long rates = pbzjcqProject.getRates();
        Long amounts = pbzjcqProject.getAmounts();
        Long days = pbzjcqProject.getDays();

        List<PbzjcqProject> list = pbzjcqProjectService.selectPbzjcqProjectList(pbzjcqProject);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:project:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PbzjcqProject pbzjcqProject) {
        List<PbzjcqProject> list = pbzjcqProjectService.selectPbzjcqProjectList(pbzjcqProject);
        ExcelUtil<PbzjcqProject> util = new ExcelUtil<PbzjcqProject>(PbzjcqProject.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:project:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(pbzjcqProjectService.selectPbzjcqProjectById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:project:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PbzjcqProject pbzjcqProject) {
        return toAjax(pbzjcqProjectService.insertPbzjcqProject(pbzjcqProject));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:project:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PbzjcqProject pbzjcqProject) {
        return toAjax(pbzjcqProjectService.updatePbzjcqProject(pbzjcqProject));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:project:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(pbzjcqProjectService.deletePbzjcqProjectByIds(ids));
    }
}
