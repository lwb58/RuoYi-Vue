package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 抽取专家设置对象 pbzjcq_cqzjconfig
 * 
 * @author ruoyi
 * @date 2023-02-19
 */
public class PbzjcqCqzjconfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 项目编号 */
    @Excel(name = "项目编号")
    private Long projectId;

    /** 专家类别 */
    @Excel(name = "专家类别")
    private String zjlb;

    /** 参评专业 */
    @Excel(name = "参评专业")
    private String cpzy;

    /** 抽取人数 */
    @Excel(name = "抽取人数")
    private Long rs;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

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
    public void setZjlb(String zjlb) 
    {
        this.zjlb = zjlb;
    }

    public String getZjlb() 
    {
        return zjlb;
    }
    public void setCpzy(String cpzy) 
    {
        this.cpzy = cpzy;
    }

    public String getCpzy() 
    {
        return cpzy;
    }
    public void setRs(Long rs) 
    {
        this.rs = rs;
    }

    public Long getRs() 
    {
        return rs;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("zjlb", getZjlb())
            .append("cpzy", getCpzy())
            .append("rs", getRs())
            .append("projectName", getProjectName())
            .toString();
    }
}
