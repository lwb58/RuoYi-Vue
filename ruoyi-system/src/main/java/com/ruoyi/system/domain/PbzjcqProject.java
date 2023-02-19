package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 pbzjcq_project
 * 
 * @author ruoyi
 * @date 2023-02-18
 */
public class PbzjcqProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目编号 */
    private Long id;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 项目所属地 */
    @Excel(name = "项目所属地")
    private String projAddr;

    /** 经办人姓名 */
    @Excel(name = "经办人姓名")
    private String oper;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String mobile;

    /** 监督部门 */
    @Excel(name = "监督部门")
    private String department;

    /** 评标开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "评标开始时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "评标开始时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;


    /** 评标地点 */
    @Excel(name = "评标地点")
    private String addr;

    /** 屏蔽最近几天内被抽中的专家 */
    @Excel(name = "屏蔽最近几天内被抽中的专家")
    private Long days;

    /** 同单位最多可以抽中的数量 */
    @Excel(name = "同单位最多可以抽中的数量")
    private Long amounts;

    /** 倍选比率 */
    @Excel(name = "倍选比率")
    private Long rates;

    /** 招标方式 */
    @Excel(name = "招标方式")
    private String zbfs;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setProjAddr(String projAddr) 
    {
        this.projAddr = projAddr;
    }

    public String getProjAddr() 
    {
        return projAddr;
    }
    public void setOper(String oper) 
    {
        this.oper = oper;
    }

    public String getOper() 
    {
        return oper;
    }
    public void setMobile(String mobile) 
    {
        this.mobile = mobile;
    }

    public String getMobile() 
    {
        return mobile;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setAddr(String addr) 
    {
        this.addr = addr;
    }

    public String getAddr() 
    {
        return addr;
    }
    public void setDays(Long days) 
    {
        this.days = days;
    }

    public Long getDays() 
    {
        return days;
    }
    public void setAmounts(Long amounts) 
    {
        this.amounts = amounts;
    }

    public Long getAmounts() 
    {
        return amounts;
    }
    public void setRates(Long rates) 
    {
        this.rates = rates;
    }

    public Long getRates() 
    {
        return rates;
    }
    public void setZbfs(String zbfs) 
    {
        this.zbfs = zbfs;
    }

    public String getZbfs() 
    {
        return zbfs;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectName", getProjectName())
            .append("createTime", getCreateTime())
            .append("projAddr", getProjAddr())
            .append("oper", getOper())
            .append("mobile", getMobile())
            .append("department", getDepartment())
            .append("startTime", getStartTime())
            .append("addr", getAddr())
            .append("days", getDays())
            .append("amounts", getAmounts())
            .append("rates", getRates())
            .append("zbfs", getZbfs())
            .toString();
    }
}
