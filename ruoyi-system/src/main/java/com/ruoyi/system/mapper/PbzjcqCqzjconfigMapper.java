package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PbzjcqCqzjconfig;

/**
 * 抽取专家设置Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-19
 */
public interface PbzjcqCqzjconfigMapper 
{
    /**
     * 查询抽取专家设置
     * 
     * @param id 抽取专家设置主键
     * @return 抽取专家设置
     */
    public PbzjcqCqzjconfig selectPbzjcqCqzjconfigById(Long id);

    /**
     * 查询抽取专家设置列表
     * 
     * @param pbzjcqCqzjconfig 抽取专家设置
     * @return 抽取专家设置集合
     */
    public List<PbzjcqCqzjconfig> selectPbzjcqCqzjconfigList(PbzjcqCqzjconfig pbzjcqCqzjconfig);

    /**
     * 新增抽取专家设置
     * 
     * @param pbzjcqCqzjconfig 抽取专家设置
     * @return 结果
     */
    public int insertPbzjcqCqzjconfig(PbzjcqCqzjconfig pbzjcqCqzjconfig);

    /**
     * 修改抽取专家设置
     * 
     * @param pbzjcqCqzjconfig 抽取专家设置
     * @return 结果
     */
    public int updatePbzjcqCqzjconfig(PbzjcqCqzjconfig pbzjcqCqzjconfig);

    /**
     * 删除抽取专家设置
     * 
     * @param id 抽取专家设置主键
     * @return 结果
     */
    public int deletePbzjcqCqzjconfigById(Long id);

    /**
     * 批量删除抽取专家设置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePbzjcqCqzjconfigByIds(Long[] ids);
}
