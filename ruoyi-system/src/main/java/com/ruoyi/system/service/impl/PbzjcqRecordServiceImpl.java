package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PbzjcqRecordMapper;
import com.ruoyi.system.domain.PbzjcqRecord;
import com.ruoyi.system.service.IPbzjcqRecordService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-18
 */
@Service
public class PbzjcqRecordServiceImpl implements IPbzjcqRecordService 
{
    @Autowired
    private PbzjcqRecordMapper pbzjcqRecordMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public PbzjcqRecord selectPbzjcqRecordById(Long id)
    {
        return pbzjcqRecordMapper.selectPbzjcqRecordById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param pbzjcqRecord 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<PbzjcqRecord> selectPbzjcqRecordList(PbzjcqRecord pbzjcqRecord)
    {
        return pbzjcqRecordMapper.selectPbzjcqRecordList(pbzjcqRecord);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param pbzjcqRecord 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertPbzjcqRecord(PbzjcqRecord pbzjcqRecord)
    {
        pbzjcqRecord.setCreateTime(DateUtils.getNowDate());
        return pbzjcqRecordMapper.insertPbzjcqRecord(pbzjcqRecord);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param pbzjcqRecord 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updatePbzjcqRecord(PbzjcqRecord pbzjcqRecord)
    {
        return pbzjcqRecordMapper.updatePbzjcqRecord(pbzjcqRecord);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePbzjcqRecordByIds(Long[] ids)
    {
        return pbzjcqRecordMapper.deletePbzjcqRecordByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePbzjcqRecordById(Long id)
    {
        return pbzjcqRecordMapper.deletePbzjcqRecordById(id);
    }
}
