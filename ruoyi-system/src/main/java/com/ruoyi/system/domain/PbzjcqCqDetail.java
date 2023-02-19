package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 pbzjcq_cq_detail
 * 
 * @author ruoyi
 * @date 2023-02-19
 */
public class PbzjcqCqDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 抽奖批次号 */
    @Excel(name = "抽奖批次号")
    private Long recordId;

    /** 专家序号 */
    @Excel(name = "专家序号")
    private Long specialistId;

    /** 项目编号 */
    @Excel(name = "项目编号")
    private Long projectId;

    /** 跟进状态 */
    @Excel(name = "跟进状态")
    private String gjzt;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
    }
    public void setSpecialistId(Long specialistId) 
    {
        this.specialistId = specialistId;
    }

    public Long getSpecialistId() 
    {
        return specialistId;
    }
    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }
    public void setGjzt(String gjzt) 
    {
        this.gjzt = gjzt;
    }

    public String getGjzt() 
    {
        return gjzt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("recordId", getRecordId())
            .append("specialistId", getSpecialistId())
            .append("projectId", getProjectId())
            .append("gjzt", getGjzt())
            .toString();
    }
}
