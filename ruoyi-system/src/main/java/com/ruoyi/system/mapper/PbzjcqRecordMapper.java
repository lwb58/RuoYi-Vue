package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PbzjcqRecord;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-18
 */
public interface PbzjcqRecordMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public PbzjcqRecord selectPbzjcqRecordById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param pbzjcqRecord 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<PbzjcqRecord> selectPbzjcqRecordList(PbzjcqRecord pbzjcqRecord);

    /**
     * 新增【请填写功能名称】
     * 
     * @param pbzjcqRecord 【请填写功能名称】
     * @return 结果
     */
    public int insertPbzjcqRecord(PbzjcqRecord pbzjcqRecord);

    /**
     * 修改【请填写功能名称】
     * 
     * @param pbzjcqRecord 【请填写功能名称】
     * @return 结果
     */
    public int updatePbzjcqRecord(PbzjcqRecord pbzjcqRecord);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deletePbzjcqRecordById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePbzjcqRecordByIds(Long[] ids);
}
