package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PbzjcqProject;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-18
 */
public interface PbzjcqProjectMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public PbzjcqProject selectPbzjcqProjectById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param pbzjcqProject 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<PbzjcqProject> selectPbzjcqProjectList(PbzjcqProject pbzjcqProject);

    /**
     * 新增【请填写功能名称】
     * 
     * @param pbzjcqProject 【请填写功能名称】
     * @return 结果
     */
    public int insertPbzjcqProject(PbzjcqProject pbzjcqProject);

    /**
     * 修改【请填写功能名称】
     * 
     * @param pbzjcqProject 【请填写功能名称】
     * @return 结果
     */
    public int updatePbzjcqProject(PbzjcqProject pbzjcqProject);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deletePbzjcqProjectById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePbzjcqProjectByIds(Long[] ids);
}
