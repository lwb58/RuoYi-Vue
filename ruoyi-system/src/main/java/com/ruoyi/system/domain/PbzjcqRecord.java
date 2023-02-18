package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 pbzjcq_record
 * 
 * @author ruoyi
 * @date 2023-02-18
 */
public class PbzjcqRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 项目编号 */
    @Excel(name = "项目编号")
    private Long projectId;

    /** 专家序号 */
    @Excel(name = "专家序号")
    private Long specialistId;

    /** 正备选 */
    @Excel(name = "正备选")
    private String zbx;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }
    public void setSpecialistId(Long specialistId) 
    {
        this.specialistId = specialistId;
    }

    public Long getSpecialistId() 
    {
        return specialistId;
    }
    public void setZbx(String zbx) 
    {
        this.zbx = zbx;
    }

    public String getZbx() 
    {
        return zbx;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("specialistId", getSpecialistId())
            .append("createTime", getCreateTime())
            .append("zbx", getZbx())
            .toString();
    }
}
