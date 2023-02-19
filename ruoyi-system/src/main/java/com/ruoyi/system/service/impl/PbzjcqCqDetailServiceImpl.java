package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PbzjcqCqDetailMapper;
import com.ruoyi.system.domain.PbzjcqCqDetail;
import com.ruoyi.system.service.IPbzjcqCqDetailService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-19
 */
@Service
public class PbzjcqCqDetailServiceImpl implements IPbzjcqCqDetailService 
{
    @Autowired
    private PbzjcqCqDetailMapper pbzjcqCqDetailMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public PbzjcqCqDetail selectPbzjcqCqDetailById(Long id)
    {
        return pbzjcqCqDetailMapper.selectPbzjcqCqDetailById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param pbzjcqCqDetail 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<PbzjcqCqDetail> selectPbzjcqCqDetailList(PbzjcqCqDetail pbzjcqCqDetail)
    {
        return pbzjcqCqDetailMapper.selectPbzjcqCqDetailList(pbzjcqCqDetail);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param pbzjcqCqDetail 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertPbzjcqCqDetail(PbzjcqCqDetail pbzjcqCqDetail)
    {
        return pbzjcqCqDetailMapper.insertPbzjcqCqDetail(pbzjcqCqDetail);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param pbzjcqCqDetail 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updatePbzjcqCqDetail(PbzjcqCqDetail pbzjcqCqDetail)
    {
        return pbzjcqCqDetailMapper.updatePbzjcqCqDetail(pbzjcqCqDetail);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePbzjcqCqDetailByIds(Long[] ids)
    {
        return pbzjcqCqDetailMapper.deletePbzjcqCqDetailByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePbzjcqCqDetailById(Long id)
    {
        return pbzjcqCqDetailMapper.deletePbzjcqCqDetailById(id);
    }
}
