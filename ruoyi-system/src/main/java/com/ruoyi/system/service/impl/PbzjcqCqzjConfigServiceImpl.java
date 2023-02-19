package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PbzjcqCqzjconfigMapper;
import com.ruoyi.system.domain.PbzjcqCqzjconfig;
import com.ruoyi.system.service.IPbzjcqCqzjconfigService;

/**
 * 抽取专家设置Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-19
 */
@Service
public class PbzjcqCqzjconfigServiceImpl implements IPbzjcqCqzjconfigService 
{
    @Autowired
    private PbzjcqCqzjconfigMapper pbzjcqCqzjconfigMapper;

    /**
     * 查询抽取专家设置
     * 
     * @param id 抽取专家设置主键
     * @return 抽取专家设置
     */
    @Override
    public PbzjcqCqzjconfig selectPbzjcqCqzjconfigById(Long id)
    {
        return pbzjcqCqzjconfigMapper.selectPbzjcqCqzjconfigById(id);
    }

    /**
     * 查询抽取专家设置列表
     * 
     * @param pbzjcqCqzjconfig 抽取专家设置
     * @return 抽取专家设置
     */
    @Override
    public List<PbzjcqCqzjconfig> selectPbzjcqCqzjconfigList(PbzjcqCqzjconfig pbzjcqCqzjconfig)
    {
        return pbzjcqCqzjconfigMapper.selectPbzjcqCqzjconfigList(pbzjcqCqzjconfig);
    }

    /**
     * 新增抽取专家设置
     * 
     * @param pbzjcqCqzjconfig 抽取专家设置
     * @return 结果
     */
    @Override
    public int insertPbzjcqCqzjconfig(PbzjcqCqzjconfig pbzjcqCqzjconfig)
    {
        return pbzjcqCqzjconfigMapper.insertPbzjcqCqzjconfig(pbzjcqCqzjconfig);
    }

    /**
     * 修改抽取专家设置
     * 
     * @param pbzjcqCqzjconfig 抽取专家设置
     * @return 结果
     */
    @Override
    public int updatePbzjcqCqzjconfig(PbzjcqCqzjconfig pbzjcqCqzjconfig)
    {
        return pbzjcqCqzjconfigMapper.updatePbzjcqCqzjconfig(pbzjcqCqzjconfig);
    }

    /**
     * 批量删除抽取专家设置
     * 
     * @param ids 需要删除的抽取专家设置主键
     * @return 结果
     */
    @Override
    public int deletePbzjcqCqzjconfigByIds(Long[] ids)
    {
        return pbzjcqCqzjconfigMapper.deletePbzjcqCqzjconfigByIds(ids);
    }

    /**
     * 删除抽取专家设置信息
     * 
     * @param id 抽取专家设置主键
     * @return 结果
     */
    @Override
    public int deletePbzjcqCqzjconfigById(Long id)
    {
        return pbzjcqCqzjconfigMapper.deletePbzjcqCqzjconfigById(id);
    }
}
