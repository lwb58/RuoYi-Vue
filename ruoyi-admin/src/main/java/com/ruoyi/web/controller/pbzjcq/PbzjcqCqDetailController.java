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
import com.ruoyi.system.domain.PbzjcqCqDetail;
import com.ruoyi.system.service.IPbzjcqCqDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2023-02-19
 */
@RestController
@RequestMapping("/system/detail")
public class PbzjcqCqDetailController extends BaseController
{
    @Autowired
    private IPbzjcqCqDetailService pbzjcqCqDetailService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:detail:list')")
    @GetMapping("/list")
    public TableDataInfo list(PbzjcqCqDetail pbzjcqCqDetail)
    {
        startPage();
        List<PbzjcqCqDetail> list = pbzjcqCqDetailService.selectPbzjcqCqDetailList(pbzjcqCqDetail);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:detail:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PbzjcqCqDetail pbzjcqCqDetail)
    {
        List<PbzjcqCqDetail> list = pbzjcqCqDetailService.selectPbzjcqCqDetailList(pbzjcqCqDetail);
        ExcelUtil<PbzjcqCqDetail> util = new ExcelUtil<PbzjcqCqDetail>(PbzjcqCqDetail.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:detail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pbzjcqCqDetailService.selectPbzjcqCqDetailById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:detail:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PbzjcqCqDetail pbzjcqCqDetail)
    {
        return toAjax(pbzjcqCqDetailService.insertPbzjcqCqDetail(pbzjcqCqDetail));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:detail:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PbzjcqCqDetail pbzjcqCqDetail)
    {
        return toAjax(pbzjcqCqDetailService.updatePbzjcqCqDetail(pbzjcqCqDetail));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:detail:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pbzjcqCqDetailService.deletePbzjcqCqDetailByIds(ids));
    }
}
