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
import com.ruoyi.system.domain.PbzjcqCqzjconfig;
import com.ruoyi.system.service.IPbzjcqCqzjconfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 抽取专家设置Controller
 * 
 * @author ruoyi
 * @date 2023-02-19
 */
@RestController
@RequestMapping("/system/cqzjconfig")
public class PbzjcqCqzjconfigController extends BaseController
{
    @Autowired
    private IPbzjcqCqzjconfigService pbzjcqCqzjconfigService;

    /**
     * 查询抽取专家设置列表
     */
    @PreAuthorize("@ss.hasPermi('system:cqzjconfig:list')")
    @GetMapping("/list")
    public TableDataInfo list(PbzjcqCqzjconfig pbzjcqCqzjconfig)
    {
        startPage();
        List<PbzjcqCqzjconfig> list = pbzjcqCqzjconfigService.selectPbzjcqCqzjconfigList(pbzjcqCqzjconfig);
        return getDataTable(list);
    }

    /**
     * 导出抽取专家设置列表
     */
    @PreAuthorize("@ss.hasPermi('system:cqzjconfig:export')")
    @Log(title = "抽取专家设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PbzjcqCqzjconfig pbzjcqCqzjconfig)
    {
        List<PbzjcqCqzjconfig> list = pbzjcqCqzjconfigService.selectPbzjcqCqzjconfigList(pbzjcqCqzjconfig);
        ExcelUtil<PbzjcqCqzjconfig> util = new ExcelUtil<PbzjcqCqzjconfig>(PbzjcqCqzjconfig.class);
        util.exportExcel(response, list, "抽取专家设置数据");
    }

    /**
     * 获取抽取专家设置详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cqzjconfig:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pbzjcqCqzjconfigService.selectPbzjcqCqzjconfigById(id));
    }

    /**
     * 新增抽取专家设置
     */
    @PreAuthorize("@ss.hasPermi('system:cqzjconfig:add')")
    @Log(title = "抽取专家设置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PbzjcqCqzjconfig pbzjcqCqzjconfig)
    {
        return toAjax(pbzjcqCqzjconfigService.insertPbzjcqCqzjconfig(pbzjcqCqzjconfig));
    }

    /**
     * 修改抽取专家设置
     */
    @PreAuthorize("@ss.hasPermi('system:cqzjconfig:edit')")
    @Log(title = "抽取专家设置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PbzjcqCqzjconfig pbzjcqCqzjconfig)
    {
        return toAjax(pbzjcqCqzjconfigService.updatePbzjcqCqzjconfig(pbzjcqCqzjconfig));
    }

    /**
     * 删除抽取专家设置
     */
    @PreAuthorize("@ss.hasPermi('system:cqzjconfig:remove')")
    @Log(title = "抽取专家设置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pbzjcqCqzjconfigService.deletePbzjcqCqzjconfigByIds(ids));
    }
}
