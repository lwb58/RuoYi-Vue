package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PbzjcqCqDetail;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-02-19
 */
public interface IPbzjcqCqDetailService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public PbzjcqCqDetail selectPbzjcqCqDetailById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param pbzjcqCqDetail 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<PbzjcqCqDetail> selectPbzjcqCqDetailList(PbzjcqCqDetail pbzjcqCqDetail);

    /**
     * 新增【请填写功能名称】
     * 
     * @param pbzjcqCqDetail 【请填写功能名称】
     * @return 结果
     */
    public int insertPbzjcqCqDetail(PbzjcqCqDetail pbzjcqCqDetail);

    /**
     * 修改【请填写功能名称】
     * 
     * @param pbzjcqCqDetail 【请填写功能名称】
     * @return 结果
     */
    public int updatePbzjcqCqDetail(PbzjcqCqDetail pbzjcqCqDetail);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deletePbzjcqCqDetailByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deletePbzjcqCqDetailById(Long id);
}
