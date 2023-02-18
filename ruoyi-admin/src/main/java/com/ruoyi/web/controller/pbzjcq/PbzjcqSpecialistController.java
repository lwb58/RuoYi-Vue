package com.ruoyi.web.controller.pbzjcq;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.system.domain.PbzjcqSpecialist;
import com.ruoyi.system.service.IPbzjcqSpecialistService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2023-02-18
 */
@RestController
@RequestMapping("/system/specialist")
public class PbzjcqSpecialistController extends BaseController
{
    @Autowired
    private IPbzjcqSpecialistService pbzjcqSpecialistService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:specialist:list')")
    @GetMapping("/list")
    public TableDataInfo list(PbzjcqSpecialist pbzjcqSpecialist)
    {
        startPage();
        List<PbzjcqSpecialist> list = pbzjcqSpecialistService.selectPbzjcqSpecialistList(pbzjcqSpecialist);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:specialist:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PbzjcqSpecialist pbzjcqSpecialist)
    {
        List<PbzjcqSpecialist> list = pbzjcqSpecialistService.selectPbzjcqSpecialistList(pbzjcqSpecialist);
        ExcelUtil<PbzjcqSpecialist> util = new ExcelUtil<PbzjcqSpecialist>(PbzjcqSpecialist.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:specialist:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pbzjcqSpecialistService.selectPbzjcqSpecialistById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:specialist:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PbzjcqSpecialist pbzjcqSpecialist)
    {
        return toAjax(pbzjcqSpecialistService.insertPbzjcqSpecialist(pbzjcqSpecialist));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:specialist:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PbzjcqSpecialist pbzjcqSpecialist)
    {
        return toAjax(pbzjcqSpecialistService.updatePbzjcqSpecialist(pbzjcqSpecialist));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:specialist:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pbzjcqSpecialistService.deletePbzjcqSpecialistByIds(ids));
    }
}
