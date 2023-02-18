package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PbzjcqSpecialistMapper;
import com.ruoyi.system.domain.PbzjcqSpecialist;
import com.ruoyi.system.service.IPbzjcqSpecialistService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-18
 */
@Service
public class PbzjcqSpecialistServiceImpl implements IPbzjcqSpecialistService 
{
    @Autowired
    private PbzjcqSpecialistMapper pbzjcqSpecialistMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public PbzjcqSpecialist selectPbzjcqSpecialistById(Long id)
    {
        return pbzjcqSpecialistMapper.selectPbzjcqSpecialistById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param pbzjcqSpecialist 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<PbzjcqSpecialist> selectPbzjcqSpecialistList(PbzjcqSpecialist pbzjcqSpecialist)
    {
        return pbzjcqSpecialistMapper.selectPbzjcqSpecialistList(pbzjcqSpecialist);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param pbzjcqSpecialist 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertPbzjcqSpecialist(PbzjcqSpecialist pbzjcqSpecialist)
    {
        pbzjcqSpecialist.setCreateTime(DateUtils.getNowDate());
        return pbzjcqSpecialistMapper.insertPbzjcqSpecialist(pbzjcqSpecialist);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param pbzjcqSpecialist 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updatePbzjcqSpecialist(PbzjcqSpecialist pbzjcqSpecialist)
    {
        return pbzjcqSpecialistMapper.updatePbzjcqSpecialist(pbzjcqSpecialist);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePbzjcqSpecialistByIds(Long[] ids)
    {
        return pbzjcqSpecialistMapper.deletePbzjcqSpecialistByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePbzjcqSpecialistById(Long id)
    {
        return pbzjcqSpecialistMapper.deletePbzjcqSpecialistById(id);
    }
}
