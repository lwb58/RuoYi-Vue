package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PbzjcqProjectMapper;
import com.ruoyi.system.domain.PbzjcqProject;
import com.ruoyi.system.service.IPbzjcqProjectService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-18
 */
@Service
public class PbzjcqProjectServiceImpl implements IPbzjcqProjectService 
{
    @Autowired
    private PbzjcqProjectMapper pbzjcqProjectMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public PbzjcqProject selectPbzjcqProjectById(Long id)
    {
        return pbzjcqProjectMapper.selectPbzjcqProjectById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param pbzjcqProject 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<PbzjcqProject> selectPbzjcqProjectList(PbzjcqProject pbzjcqProject)
    {
        return pbzjcqProjectMapper.selectPbzjcqProjectList(pbzjcqProject);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param pbzjcqProject 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertPbzjcqProject(PbzjcqProject pbzjcqProject)
    {
        pbzjcqProject.setCreateTime(DateUtils.getNowDate());
        return pbzjcqProjectMapper.insertPbzjcqProject(pbzjcqProject);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param pbzjcqProject 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updatePbzjcqProject(PbzjcqProject pbzjcqProject)
    {
        return pbzjcqProjectMapper.updatePbzjcqProject(pbzjcqProject);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePbzjcqProjectByIds(Long[] ids)
    {
        return pbzjcqProjectMapper.deletePbzjcqProjectByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePbzjcqProjectById(Long id)
    {
        return pbzjcqProjectMapper.deletePbzjcqProjectById(id);
    }
}
