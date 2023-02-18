package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PbzjcqSpecialist;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-18
 */
public interface PbzjcqSpecialistMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public PbzjcqSpecialist selectPbzjcqSpecialistById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param pbzjcqSpecialist 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<PbzjcqSpecialist> selectPbzjcqSpecialistList(PbzjcqSpecialist pbzjcqSpecialist);

    /**
     * 新增【请填写功能名称】
     * 
     * @param pbzjcqSpecialist 【请填写功能名称】
     * @return 结果
     */
    public int insertPbzjcqSpecialist(PbzjcqSpecialist pbzjcqSpecialist);

    /**
     * 修改【请填写功能名称】
     * 
     * @param pbzjcqSpecialist 【请填写功能名称】
     * @return 结果
     */
    public int updatePbzjcqSpecialist(PbzjcqSpecialist pbzjcqSpecialist);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deletePbzjcqSpecialistById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePbzjcqSpecialistByIds(Long[] ids);
}
